/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Douglas Glover
 */
package ucf.assignments;

import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import static javafx.collections.FXCollections.observableArrayList;

public class ListManagerModel {
    private ObservableList<ListItem> currentList = observableArrayList();
    private int currentIndex;
    void newList() {
        //set current list to new empty list
        currentList = observableArrayList();
        //deselect any index
        currentIndex = -1;
    }
    void addItem(String desc, String date, String status) {
        //create a new item with given desc, date, status
        ListItem item = new ListItem(desc, date, status);
        //if an index is selected, place there
        if (currentIndex != -1)
            currentList.add(currentIndex, item);
        //if no index is selected, place at end
        else
            currentList.add(item);
        //deselect any index
        currentIndex = -1;
    }
    void selectItem(int index, boolean complete, boolean incomplete)
    {
        //get displayed list
        ObservableList<ListItem> displayList = display(complete, incomplete);
        //get item at given index
        ListItem item = displayList.get(index);
        //get index of item in currentList
        int newIndex = currentList.indexOf(item);
        //update current index to new index
        currentIndex = newIndex;
    }
    void removeItem() {
        //remove the currently selected index from the current list
        currentList.remove(currentIndex);
    }
    void editItem(String desc, String date) {
        //get the status of the item at the selected index
        String status = currentList.get(currentIndex).getStatus();
        //create an item with the new description and date, and previous item's status
        ListItem item = new ListItem(desc, date, status);
        //set the new item to the selected index
        currentList.set(currentIndex, item);
    }
    String getSelectedItemDesc() {
        //return description of item at selected index
        return currentList.get(currentIndex).getDesc();
    }
    String getSelectedItemDate() {
        //return date of item at selected index
        return currentList.get(currentIndex).getDate();
    }
    void flipStatus() {
        //get item at selected index
        ListItem item = currentList.get(currentIndex);
        String status = "Unknown";
        //create status of X if item's status is blank
        if(item.getStatus().equals(" "))
            status = "X";
        //create status of blank if item's status is X
        else if(item.getStatus().equals("X"))
            status = " ";
        //create new item with original items description and date, and new status
        ListItem newItem = new ListItem(item.getDesc(), item.getDate(), status);
        //set the new item to the selected index
        currentList.set(currentIndex, newItem);
    }
    ObservableList<ListItem> display(Boolean complete, Boolean incomplete) {
        //create a new empty list
        ObservableList<ListItem> displayList = observableArrayList();
        for (ListItem item : currentList) {
            //if complete is true, find items with X status and add to new list
            if (complete && item.getStatus().equals("X"))
                displayList.add(item);
            //if incomplete is true, find items with blank status and add to new list
            if (incomplete && item.getStatus().equals(" "))
                displayList.add(item);
        }
        //return list created
        return displayList;
    }
    void saveList(File file) {
        try {
            //create writer to write into file given
            FileWriter myWriter = new FileWriter(file);
            for (ListItem item : currentList) {
                //enter description and separator
                myWriter.write(item.getDesc() + ":");
                //enter date and separator
                myWriter.write(item.getDate() + ":");
                //enter status and new line
                myWriter.write(item.getStatus() + "\n");
            }
            //close writer
            myWriter.close();
        }
        catch(Exception e)
        {
            //file invalid
        }
    }
    void loadList(File file) {
        try {
            //create scanner to read file
            Scanner sc = new Scanner(file);
            String line;
            String[] lineSplit;
            //create a blank list to copy into
            newList();
            //get next line of file until no more lines exist
            while(sc.hasNextLine())
            {
                line = sc.nextLine();
                //split lines into data using separator
                lineSplit = line.split(":");
                //add item with retrieved data into new list
                addItem(lineSplit[0], lineSplit[1], lineSplit[2]);
            }
            //close scanner
            sc.close();
        }
        catch (Exception e)
        {
            //file invalid
        }
    }
}
