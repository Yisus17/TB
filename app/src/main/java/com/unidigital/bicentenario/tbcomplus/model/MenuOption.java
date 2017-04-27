package com.tekknow.bicentenario.tbcomplus.model;

public class MenuOption {

    private String title;
    private String categoryId;
    private Class<?> activity;

    public MenuOption(String title, String categoryId) {
        this.title = title;
        this.categoryId = categoryId;
    }

    public MenuOption(String title, Class<?> activity) {
        this.title = title;
        this.activity = activity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Class<?> getActivity() {
        return activity;
    }

    public void setActivity(Class<?> activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return this.title.toUpperCase();
    }

}