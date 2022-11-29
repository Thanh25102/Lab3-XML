package com.bmt.lab3.util;

import com.bmt.lab3.const2.URL;
import com.bmt.lab3.dto.Category;
import com.bmt.lab3.dto.OnSale;
import com.bmt.lab3.dto.TopPick;
import com.bmt.lab3.dto.BaseModel;

import java.util.List;

public class LoadData {
    private static LoadData instance;
    private LoadData() {
    }
    public static LoadData getInstance() {
        if(instance == null) {
            instance = new LoadData();
        }
        return instance;
    }
    public List<OnSale> getOnSales(){
        return List.of(
            new OnSale("Proteins On Sale","https://www.petfoodindustry.com/rss/topic/292-proteins"), new OnSale("Amino Acids On Sale","https://www.petfoodindustry.com/rss/topic/293-amino-acids")
        );
    }
    public List<TopPick> getTopPicks(){
        return List.of(
                new TopPick("Fibers and Legumes Top Pic","https://www.petfoodindustry.com/rss/topic/295-fibers-and-legumes"), new TopPick("Minerals Top Pick","https://www.petfoodindustry.com/rss/topic/297-minerals")
        );
    }
    public List<Category> getCategories(){
        return List.of(
                new Category("Vitamin Category", "https://www.petfoodindustry.com/rss/topic/296-vitamins"), new Category("Grains and Starches", "https://www.petfoodindustry.com/rss/topic/294-grains-and-starches")
        );
    }
}
