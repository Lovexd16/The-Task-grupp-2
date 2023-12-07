package com.thetask.demo;

import java.util.ArrayList;
import java.util.List;

public class ItemListTest {
 private List<String> itemList = new ArrayList<>();

    public void addItem(String item) {
        itemList.add(item);
    }

    public List<String> getItemList() {
        return itemList;
    }
}

