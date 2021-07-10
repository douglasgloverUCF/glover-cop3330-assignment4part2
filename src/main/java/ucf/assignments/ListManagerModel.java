/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Douglas Glover
 */
package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListManagerModel {
    private ObservableList<ListItem> currentList = FXCollections.observableArrayList();
    private int currentIndex;
    void newList() {
        currentList = FXCollections.observableArrayList();
    }
    void addItem(String desc, String date) {
        ListItem item = new ListItem(desc, date, "");
        if (currentIndex != -1)
            currentList.add(currentIndex, item);
        else
            currentList.add(item);
        currentIndex = -1;
    }
    void selectItem(int index)
    {
        currentIndex = index;
    }
    void removeItem() {
        currentList.remove(currentIndex);
    }
    void editItem(String desc, String date) {
        ListItem item = new ListItem(desc, date, "");
        currentList.set(currentIndex, item);
    }
    String getSelectedItemDesc() {
        return currentList.get(currentIndex).getDesc();
    }
    String getSelectedItemDate() {
        return currentList.get(currentIndex).getDate();
    }
    void flipStatus(int index) {
        ListItem item = currentList.get(index);
        if(item.getStatus().equals(""))
            item.setStatus("X");
        else
            item.setStatus("");
        currentList.set(index, item);
    }
    ObservableList<ListItem> display(Boolean complete, Boolean incomplete) {
        //create a new empty list
        ObservableList<ListItem> displayList = FXCollections.observableArrayList();
        for (ListItem item : currentList) {
            if (complete && item.getStatus().equals("X"))
                displayList.add(item);
            if (incomplete && item.getStatus().equals(""))
                displayList.add(item);
        }
        //return list created
        return displayList;
    }
    void saveList(String directory) {
        //save list to file at given directory
    }
    void loadList(String directory) {
        //load list from file at given directory
    }

}
