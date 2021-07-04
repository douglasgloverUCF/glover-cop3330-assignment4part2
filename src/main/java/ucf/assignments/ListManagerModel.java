/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Douglas Glover
 */
package ucf.assignments;

import java.util.ArrayList;

public class ListManagerModel {
    ArrayList<List> listCollection = new ArrayList<List>();
    List newList(String name) {
        //create new list object in listCollection
        //set name to given name
        //return list
        return null;
    }
    void deleteList(List input) {
        //delete list
    }
    List renameList(List input) {
        //delete list
        //return list
        return null;
    }
    List addItem(List input, String desc, String date) {
        //call list addItem method with data
        //return list
        return null;
    }
    List removeItem(List input, int index) {
        //call list deleteItem method with index
        //return list
        return null;
    }
    List setItemDesc(List input, int index, String desc) {
        //get item at list index
        //call listItem updateDesc method with data
        //return list
        return null;
    }
    List setItemDate(List input, int index, String date) {
        //get item at list index
        //call listItem updateDate method with data
        //return list
        return null;
    }
    List setStatus(List input, int index, Boolean status) {
        //get item at list index
        //call listItem updateStatus method with data
        //return list
        return null;
    }
    List display(List input, String setting, Boolean status) {
        //check setting and status
        //create new list, removing or adding items based on status
        //return new list
        return null;
    }
    void saveList(List input, String directory) {
        //save list to file at given directory
    }
    void saveAll(String directory) {
        //saves all lists in listCollection to file at given directory
    }
    List loadLists(String directory) {
        //load list from file at given directory
        //add each list to collection
        //return list
        return null;
    }
}
