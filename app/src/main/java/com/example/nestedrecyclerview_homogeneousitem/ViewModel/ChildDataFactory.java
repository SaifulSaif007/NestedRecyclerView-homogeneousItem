package com.example.nestedrecyclerview_homogeneousitem.ViewModel;

import com.example.nestedrecyclerview_homogeneousitem.Models.Child;
import com.example.nestedrecyclerview_homogeneousitem.R;

import java.util.List;

public class ChildDataFactory {

    private List<Child> childList;

    public List<Child> getChilds(){

        childList.add(new Child("Avengers", R.drawable.avengers));
        childList.add(new Child("Venom", R.drawable.venom));
        childList.add(new Child("Terminator", R.drawable.terminator));

        return childList;
    }


}
