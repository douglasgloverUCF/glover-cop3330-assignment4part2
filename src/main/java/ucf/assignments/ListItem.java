/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Douglas Glover
 */
package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;

public class ListItem {
    private final SimpleStringProperty desc;
    private final SimpleStringProperty date;
    private final SimpleStringProperty status;

    public ListItem(String desc, String date, String status)
    {
        this.desc = new SimpleStringProperty(desc);
        this.date = new SimpleStringProperty(date);
        this.status = new SimpleStringProperty(status);
    }

    public String getDesc()
    {
        return desc.get();
    }
    public String getDate()
    {
        return date.get();
    }
    public String getStatus()
    {
        return status.get();
    }
}
