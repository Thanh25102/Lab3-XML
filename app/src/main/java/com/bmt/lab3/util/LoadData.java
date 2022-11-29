package com.bmt.lab3.util;

import com.bmt.lab3.dto.Category;
import com.bmt.lab3.dto.OnSale;
import com.bmt.lab3.dto.TopPick;

import java.util.List;

public class LoadData {
    private static LoadData instance;

    private LoadData() {
    }

    public static LoadData getInstance() {
        if (instance == null) {
            instance = new LoadData();
        }
        return instance;
    }

    public List<OnSale> getOnSales() {
        return List.of(
                new OnSale("Proteins On Sale", "https://www.petfoodindustry.com/rss/topic/292-proteins"),
                new OnSale("Amino Acids On Sale", "https://www.petfoodindustry.com/rss/topic/293-amino-acids"),
                new OnSale("Processing functional ingredients On Sale", "https://www.petfoodindustry.com/rss/topic/299-processing-functional-ingredients"),
                new OnSale("Nutraceutical On Sale", "https://www.petfoodindustry.com/rss/topic/298-nutraceuticals"),
                new OnSale("Fats and-Oils", "https://www.petfoodindustry.com/rss/topic/300-fats-and-oils"),
                new OnSale("Preservatives On Sale", "https://www.petfoodindustry.com/rss/topic/301-preservatives"),
                new OnSale("Dog and Cat Food Nutrition On Sale", "https://www.petfoodindustry.com/rss/topic/450-dog-and-cat-food-nutrition"),
                new OnSale("Pet Food Ingredients", "https://www.petfoodindustry.com/rss/topic/212-pet-food-ingredients"),
                new OnSale("Ingredient Usage Analysis", "https://www.petfoodindustry.com/rss/topic/451-ingredient-usage-analysis"),
                new OnSale("Pet Food Palatability On Sale", "https://www.petfoodindustry.com/rss/topic/251-pet-food-palatability")
        );
    }

    public List<TopPick> getTopPicks() {
        return List.of(
                new TopPick("Fibers and Legumes Top Pic", "https://www.petfoodindustry.com/rss/topic/295-fibers-and-legumes"),
                new TopPick("Minerals Top Pick", "https://www.petfoodindustry.com/rss/topic/297-minerals"),
                new TopPick("Pet Food Additives / Supplements Top Pick", "https://www.petfoodindustry.com/rss/topic/250-pet-food-additives-supplements")
                , new TopPick("Natural Organic Pet Food Top Pick", "https://www.petfoodindustry.com/rss/topic/226-natural-organic-pet-food")

        );
    }

    public List<Category> getCategories() {
        return List.of(
                new Category("Vitamin Category", "https://www.petfoodindustry.com/rss/topic/296-vitamins"),
                new Category("Grains and Starches", "https://www.petfoodindustry.com/rss/topic/294-grains-and-starches")
        );
    }
}
