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
        if (popupModel.popup.getTitle().equals("Edit Item")) {
            String descCurrent = model.getSelectedItemDesc();
            descriptionInput.setText(descCurrent);
            if(!descCurrent.equals("")) {
                String dateCurrent = model.getSelectedItemDate();
                LocalDate date = LocalDate.parse(dateCurrent);
                dateInput.setValue(date);
            }
        }
    }
    @FXML
    public void addButtonClicked(ActionEvent actionEvent) {

        String desc = descriptionInput.getText();
        String dateString;
        try {
            LocalDate date = dateInput.getValue();
            dateString = date.toString();
        }
        catch (Exception e)
        {
            dateString = "";
        }
        if(popupModel.popup.getTitle().equals("Add Item"))
            model.addItem(desc, dateString, " ");
        else if (popupModel.popup.getTitle().equals("Edit Item"))
            model.editItem(desc, dateString);
        popupModel.closeWindow();
    }
    @FXML
    public void CancelButtonClicked(ActionEvent actionEvent) {
        popupModel.closeWindow();
    }
}
