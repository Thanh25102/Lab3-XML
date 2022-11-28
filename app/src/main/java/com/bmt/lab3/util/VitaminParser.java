package com.bmt.lab3.util;

import android.util.Log;
import android.util.Xml;
import com.bmt.lab3.dto.Vitamin;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class VitaminParser {
    private static String TAG_CHANNEL = "channel";
    private static String TAG_TITLE = "title";
    private static String TAG_LINK = "link";
    private static String TAG_DESCRIPTION = "description";
    private static String TAG_PUB_DATE = "pubDate";
    private static String TAG_GUID = "guid";

    private static String TAG_ITEM = "item";
    public static VitaminParser vitaminParser;

    private VitaminParser(){}

    public static VitaminParser getInstance(){
        if(vitaminParser == null)
            vitaminParser = new VitaminParser();
        return vitaminParser;
    }
    public List<Vitamin> parseVitamin(InputStream inputStream) throws XmlPullParserException,
            IOException {
        String title = null;
        String link = null;
        String description = null;
        String pubDate = null;
        String guid = null;
        boolean isItem = false;
        String imageUrl = null;
        List<Vitamin> items = new ArrayList<>();
        try {
            XmlPullParser xmlPullParser = Xml.newPullParser();
            xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            xmlPullParser.setInput(inputStream, null);

            xmlPullParser.nextTag();
            while (xmlPullParser.next() != XmlPullParser.END_DOCUMENT) {
                int eventType = xmlPullParser.getEventType();

                String name = xmlPullParser.getName();
                if(name == null)
                    continue;

                if(eventType == XmlPullParser.END_TAG) {
                    if(name.equalsIgnoreCase("item")) {
                        isItem = false;
                    }
                    continue;
                }

                if (eventType == XmlPullParser.START_TAG) {
                    if(name.equalsIgnoreCase("item")) {
                        isItem = true;
                        continue;
                    }
                }

                String result = "";
                if (xmlPullParser.next() == XmlPullParser.TEXT) {
                    result = xmlPullParser.getText();
                    xmlPullParser.nextTag();
                }

                if (name.equalsIgnoreCase("title")) {
                    title = result;
                } else if (name.equalsIgnoreCase("description")) {
                    description = result;
                } else if (name.equalsIgnoreCase("guid")) {
                    guid = result;
                }  else if (name.equalsIgnoreCase("pubDate")) {
                    pubDate = result;
                } else if (name.equalsIgnoreCase("link")) {
                    link = result;
                } else if(name.equalsIgnoreCase("media:content")){
                    Log.i("result", result);
                }
                if (title != null && link != null && description != null && pubDate != null && guid != null) {
                    if(isItem) {
                        Vitamin item = new Vitamin(title, description, guid,pubDate,link);
                        items.add(item);
                    }
                    title = null;
                    link = null;
                    description = null;
                    guid = null;
                    pubDate = null;
                    isItem = false;
                }
            }
            return items;
        } finally {
            inputStream.close();
        }
    }
}
