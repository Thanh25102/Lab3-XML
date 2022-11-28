package com.bmt.lab3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Vitamin {
    private String title;
    private String description;
    private String guid;
    private String pubDate;
    private String link;

    public Vitamin(String title, String description, String guid, String pubDate, String link) {
        this.title = title;
        this.description = description;
        this.guid = guid;
        this.pubDate = pubDate;
        this.link = link;
    }

    public Vitamin() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Vitamin{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", guid='" + guid + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
