package com.example.nestedrecyclerview_homogeneousitem.DataStore;

import com.example.nestedrecyclerview_homogeneousitem.Models.Child;
import com.example.nestedrecyclerview_homogeneousitem.Models.Parent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParentDataFactory {

    List<Parent> parentList = new ArrayList<>();


    public List<Parent> parentList(){

        parentList.add(new Parent("Classic", getChilds()));
        parentList.add(new Parent("Action", getChilds()));
        parentList.add(new Parent("Romantic", getChilds()));

        return parentList;
    }



    private List<Child> getChilds() {
        ChildDataFactory childDataFactory = new ChildDataFactory();
        List<Child>  children = childDataFactory.getChilds();
        Collections.shuffle(children);
        return children;
    }

}
