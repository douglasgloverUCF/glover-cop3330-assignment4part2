/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Douglas Glover
 */
package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.time.LocalDate;


public class ListManagerController {
    static final ListManagerModel model = new ListManagerModel();
    static final ItemWindowModel popupModel = new ItemWindowModel();
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
        try {
            descColumn.setCellValueFactory(new PropertyValueFactory<ListItem, String>("desc"));
            dateColumn.setCellValueFactory(new PropertyValueFactory<ListItem, String>("date"));
            statusColumn.setCellValueFactory(new PropertyValueFactory<ListItem, String>("status"));
            refreshList();
        }
        catch(Exception e)
        {
            //fix later
        }
    }

    @FXML
    public void addItemButtonClicked(ActionEvent actionEvent) {
        popupModel.createWindow("CreateItem.fxml", "Add Item");
    }
    @FXML
    public void editItemButtonClicked(ActionEvent actionEvent) {
        if(currentIndex != -1)
            popupModel.createWindow("CreateItem.fxml", "Edit Item");
    }
    @FXML
    public void deleteItemButtonClicked(ActionEvent actionEvent) {
        if(currentIndex != -1)
            model.removeItem();
        refreshList();
        currentIndex = -1;
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
        model.newList();
        refreshList();
    }

    @FXML
    public void saveButtonClicked(ActionEvent actionEvent) {
        //model.saveList();
    }

    @FXML
    public void loadButtonClicked(ActionEvent actionEvent) {
        //model.loadList();
    }
    @FXML
    public void tableClicked(MouseEvent mouseEvent) {
        currentIndex = listDisplay.getSelectionModel().getSelectedIndex();
        model.selectItem(currentIndex);
    }
    @FXML
    public void tableRightClicked(ContextMenuEvent contextMenuEvent) {
        try {
            currentIndex = listDisplay.getSelectionModel().getSelectedIndex();
            model.flipStatus(currentIndex);
            refreshList();
        }
        catch (Exception e) {
            //No bueno
        }
    }

    public void refreshList()
    {
        ObservableList<ListItem> newList = model.display(complete, incomplete);
        listDisplay.setItems(newList);
    }
}
