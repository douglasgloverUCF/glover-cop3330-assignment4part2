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
        currentIndex = -1;
        currentList = observableArrayList();
    }
    void addItem(String desc, String date, String status) {
        ListItem item = new ListItem(desc, date, status);
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
        String status = currentList.get(currentIndex).getStatus();
        ListItem item = new ListItem(desc, date, status);
        currentList.set(currentIndex, item);
    }
    String getSelectedItemDesc() {
        return currentList.get(currentIndex).getDesc();
    }
    String getSelectedItemDate() {
        return currentList.get(currentIndex).getDate();
    }
    void flipStatus() {
        ListItem item = currentList.get(currentIndex);
        String status = "O";
        if(item.getStatus().equals(" "))
            status = "X";
        else if(item.getStatus().equals("X"))
            status = " ";
        ListItem newItem = new ListItem(item.getDesc(), item.getDate(), status);
        currentList.set(currentIndex, newItem);
    }
    ObservableList<ListItem> display(Boolean complete, Boolean incomplete) {
        //create a new empty list
        ObservableList<ListItem> displayList = observableArrayList();
        for (ListItem item : currentList) {
            if (complete && item.getStatus().equals("X"))
                displayList.add(item);
            if (incomplete && item.getStatus().equals(" "))
                displayList.add(item);
        }
        //return list created
        return displayList;
    }
    void saveList(File file) {
        //save list to file at given directory
        try {
            FileWriter myWriter = new FileWriter(file);
            for (ListItem item : currentList) {
                myWriter.write(item.getDesc() + ":");
                myWriter.write(item.getDate() + ":");
                myWriter.write(item.getStatus());
            }
            myWriter.close();
        }
        catch(Exception e)
        {
            //error message
        }
    }
    void loadList(File file) {
        try {
            Scanner sc = new Scanner(file);
            String line;
            String[] lineSplit;
            newList();
            while(sc.hasNextLine())
            {
                line = sc.nextLine();
                lineSplit = line.split(":");
                addItem(lineSplit[0], lineSplit[1], lineSplit[2]);
            }
            sc.close();
        }
        catch (Exception e)
        {
            //error message
        }
    }

}
