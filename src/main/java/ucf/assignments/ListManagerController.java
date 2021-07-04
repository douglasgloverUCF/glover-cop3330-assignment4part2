/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Douglas Glover
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class ListManagerController {
    private static ListManagerModel model = new ListManagerModel();
    @FXML
    private TableView<String> listDisplay = new TableView<String>();
    @FXML
    private ListView<String> listNavigator = new ListView<String>();
    @FXML
    private Tab listTab = new Tab();

    @FXML
    public void newListButtonClicked(ActionEvent actionEvent) {
        //open a small input window
        //collect name
        //use model to create list with name
        //display new item in listDisplay
        //update listNavigator with new data
    }
    @FXML
    public void deleteListButtonClicked(ActionEvent actionEvent) {
        //get list selected from listNavigator
        //use model to delete list
        //clear listTab
        //update listNavigator with new data
    }
    @FXML
    public void renameListButtonClicked(ActionEvent actionEvent) {
        //get list selected from listNavigator
        //open a small input window
        //collect new name
        //use model to rename list
        //display new list on listTab
        //display new list on listNavigator
    }
    @FXML
    public void openListButtonClicked(ActionEvent actionEvent) {
        //get list selected from listNavigator
        //display list on listDisplay
    }
    @FXML
    public void addItemButtonClicked(ActionEvent actionEvent) {
        //open a small input window
        //collect new description and date
        //use model to create item with data
        //display new item in listDisplay
    }
    @FXML
    public void deleteItemButtonClicked(ActionEvent actionEvent) {
        //get item selected from listDisplay
        //use model to delete item
        //display new list in listDisplay
    }
    @FXML
    public void editItemButtonClicked(ActionEvent actionEvent) {
        //get item selected from listDisplay
        //open a small input window
        //collect new description and date
        //use model to update item with data
        //display new list in listDisplay
    }
    @FXML
    public void flipStatusClicked(MouseEvent mouseEvent) {
        //get item selected from listDisplay
        //get item status
        //use model to invert status
        //display new list in listDisplay
    }

    @FXML
    public void includeIncompleteButtonClicked(ActionEvent actionEvent) {
        //get list selected from listNavigator
        //check button status
        //use model to change display settings according to status
        //display new list
    }
    @FXML
    public void includeCompleteButtonClicked(ActionEvent actionEvent) {
        //get list selected from listNavigator
        //check button status
        //use model to change display settings according to status
        //display new list
    }
    @FXML
    public void saveAllButtonClicked(ActionEvent actionEvent) {
        //get lists from listNavigator
        //get directory
        //use model to save all lists at directory
    }
    @FXML
    public void saveButtonClicked(ActionEvent actionEvent) {
        //get selected list from listNavigator
        //get directory
        //use model to save list
    }
    @FXML
    public void loadButtonClicked(ActionEvent actionEvent) {
        //get directory
        //use model to load list from directory
        //display list on listNavigator
        //display list on listDisplay
    }
}
