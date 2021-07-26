package com.example.nestedrecyclerview_homogeneousitem.DataStore;

import com.example.nestedrecyclerview_homogeneousitem.Models.Child;
import com.example.nestedrecyclerview_homogeneousitem.R;

import java.util.ArrayList;
import java.util.List;

public class ChildDataFactory {

    List<Child> childList = new ArrayList<>();


    public ChildDataFactory() {

        childList.add(new Child("Avengers", R.drawable.avengers));
        childList.add(new Child("Venom", R.drawable.venom));
        childList.add(new Child("Terminator", R.drawable.terminator));
        childList.add(new Child("Batman Begins", R.drawable.batman));
        childList.add(new Child("Catching Fire", R.drawable.hungergames));
        childList.add(new Child("Last Christmas",R.drawable.lastchristmnas));
        childList.add(new Child("Shawshank Redemption",R.drawable.shawshank));
        childList.add(new Child("A Star is Born", R.drawable.starisborn));
        childList.add(new Child("Star War", R.drawable.starwar));
    }



    public List<Child> getChilds(){

        return childList;
    }

    public Child getChild(int i){
        return childList.get(i);
    }

}
