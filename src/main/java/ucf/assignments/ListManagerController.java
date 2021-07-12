/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Douglas Glover
 */
package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;


public class ListManagerController {
    static final ListManagerModel model = new ListManagerModel();
    static final PopUpWindow popupModel = new PopUpWindow();
    @FXML
    private TableView<ListItem> listDisplay;
    @FXML
    private TableColumn<ListItem, String> descColumn;
    @FXML
    private TableColumn<ListItem, String> dateColumn;
    @FXML
    private TableColumn<ListItem, String> statusColumn;
    @FXML
    private CheckMenuItem completeStatus;
    @FXML
    private CheckMenuItem incompleteStatus;


    private boolean complete = true;
    private boolean incomplete = true;
    private int currentIndex = -1;

    @FXML
    public void mainWindowEntered(MouseEvent mouseEvent) {
        refreshList();
    }
    @FXML
    public void initialize()
    {
        //connect table columns to appropriate ListItem variables
        descColumn.setCellValueFactory(new PropertyValueFactory<ListItem, String>("desc"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<ListItem, String>("date"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<ListItem, String>("status"));
    }

    @FXML
    public void addItemButtonClicked(ActionEvent actionEvent) {
        //open Add Item window
        popupModel.createWindow("CreateItem.fxml", "Add Item");
    }
    @FXML
    public void editItemButtonClicked(ActionEvent actionEvent) {
        //open Edit Item Window if an index is selected
        if(currentIndex != -1)
            popupModel.createWindow("CreateItem.fxml", "Edit Item");
    }
    @FXML
    public void deleteItemButtonClicked(ActionEvent actionEvent) {
        //use removeItem method if an index is selected
        if(currentIndex != -1) {
            model.removeItem();
            //deselect any selected index
            currentIndex = -1;
        }
        //display new list on listDisplay
        refreshList();
    }

    @FXML
    public void includeCompleteButtonClicked(ActionEvent actionEvent) {
        //get complete status
        complete = completeStatus.isSelected();
        //display new list on listDisplay
        refreshList();
    }

    @FXML
    public void includeIncompleteButtonClicked(ActionEvent actionEvent) {
        //get incomplete status
        incomplete = incompleteStatus.isSelected();
        //display new list on listDisplay
        refreshList();
    }

    @FXML
    public void clearListButtonClicked(ActionEvent actionEvent) {
        //call newList method
        model.newList();
        //display new list on listDisplay
        refreshList();
    }

    @FXML
    public void saveButtonClicked(ActionEvent actionEvent) {
        //create and launch a filechooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save list");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"));
        //get file for saving
        File saveFile = fileChooser.showSaveDialog(listDisplay.getScene().getWindow());
        //call saveList method with save file
        model.saveList(saveFile);
    }

    @FXML
    public void loadButtonClicked(ActionEvent actionEvent) {
        //create and launch a filechooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load list");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"));
        //get file to load
        File loadFile = fileChooser.showOpenDialog(listDisplay.getScene().getWindow());
        //call loadList method with file
        model.loadList(loadFile);
    }
    @FXML
    public void tableClicked(MouseEvent mouseEvent) {
        //determine selected index in table
        currentIndex = listDisplay.getSelectionModel().getSelectedIndex();
        //update model's selected index using selectItem method
        model.selectItem(currentIndex, complete, incomplete);
    }
    @FXML
    public void tableRightClicked(ContextMenuEvent contextMenuEvent) {
        try {
            //determine index that was right clicked
            currentIndex = listDisplay.getSelectionModel().getSelectedIndex();
            //invert status of item at index using flipStatus method
            model.flipStatus();
            //display new list on listDisplay
            refreshList();
        }
        catch (Exception e) {
            //no index selected
        }
    }

    public void refreshList()
    {
        //create a new list with appropriate items using display method
        ObservableList<ListItem> newList = model.display(complete, incomplete);
        //set list to listDisplay
        listDisplay.setItems(newList);
    }

    public void helpButtonClicked(ActionEvent actionEvent) {
        //open Help window
        popupModel.createWindow("Help.fxml", "Help");
    }
}
