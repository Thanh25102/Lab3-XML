package com.bmt.lab3.util;

import com.bmt.lab3.dto.Category;
import com.bmt.lab3.dto.OnSale;
import com.bmt.lab3.dto.TopPick;
import com.bmt.lab3.dto.Vitamin;

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
            new OnSale("Foods Sale"), new OnSale("Beef Sale")
        );
    }
    public List<TopPick> getTopPicks(){
        return List.of(
                new TopPick("Foods Pick"), new TopPick("Beef Pick")
        );
    }
    public List<Category> getCategories(){
        return List.of(
                new Category("Vitamin Category", Vitamin.class), new Category("Beef Category", Object.class)
        );
    }
}
