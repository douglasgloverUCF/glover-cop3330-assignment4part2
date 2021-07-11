/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Douglas Glover
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class CreateItemController extends ListManagerController{
    @FXML
    private TextArea descriptionInput;
    @FXML
    private DatePicker dateInput;
    @FXML
    public void initialize()
    {
        //if the opened window is for editing
        if (popupModel.popup.getTitle().equals("Edit Item")) {
            //set text in input window to item's description
            String descCurrent = model.getSelectedItemDesc();
            descriptionInput.setText(descCurrent);
            if(!descCurrent.equals("")) {
                //set date in input window to item's date
                String dateCurrent = model.getSelectedItemDate();
                LocalDate date = LocalDate.parse(dateCurrent);
                dateInput.setValue(date);
            }
        }
    }
    @FXML
    public void addButtonClicked(ActionEvent actionEvent) {
        //get the text in the description input box
        String desc = descriptionInput.getText();
        String dateString;
        //get the date in the date input box
        try {
            LocalDate date = dateInput.getValue();
            dateString = date.toString();
        }
        catch (Exception e)
        {
            dateString = "";
        }
        //if the item is being added call addItem method
        if(popupModel.popup.getTitle().equals("Add Item"))
            model.addItem(desc, dateString, " ");
        //if the item is being edited call editItem method
        else if (popupModel.popup.getTitle().equals("Edit Item"))
            model.editItem(desc, dateString);
        //close window
        popupModel.closeWindow();
    }
    @FXML
    public void CancelButtonClicked(ActionEvent actionEvent) {
        //close window
        popupModel.closeWindow();
    }
}
