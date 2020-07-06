package com.example.playstore;

import java.util.ArrayList;

public class CategoryModel {
    public String category;
    public CategoryModel(String category)
    {
        this.category=category;
    }
    public static ArrayList<CategoryModel> getCategoryList()
    {
        ArrayList<CategoryModel> categoryModelArrayList = new ArrayList<CategoryModel>();
        for(int i=1;i<=10;i++)
        {
            categoryModelArrayList.add(new CategoryModel("Category "+Integer.toString(i)));
        }
        return categoryModelArrayList;
    }
}
