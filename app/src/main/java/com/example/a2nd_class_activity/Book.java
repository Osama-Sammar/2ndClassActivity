package com.example.a2nd_class_activity;

public class Book {

    private String title;
    private String authorName;
    private String Pages;
    private boolean available;

    public Book(String title, String authorName, String pages, boolean available) {
        this.title = title;
        this.authorName = authorName;
        Pages = pages;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPages() {
        return Pages;
    }

    public void setPages(String pages) {
        Pages = pages;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvaliable(boolean available) {
        this.available = available;
    }
}
