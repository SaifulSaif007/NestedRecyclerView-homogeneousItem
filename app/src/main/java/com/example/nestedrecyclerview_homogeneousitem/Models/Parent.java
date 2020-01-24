package com.example.nestedrecyclerview_homogeneousitem.Models;

import java.util.List;

public class Parent {

    private String genre;
    private List<Child> children;


    public Parent(String genre, List<Child> children) {
        this.genre = genre;
        this.children = children;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

}
