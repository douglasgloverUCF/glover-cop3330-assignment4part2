package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.io.File;
import java.util.Scanner;

import static javafx.collections.FXCollections.observableArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ListManagerModelTest {
    ListManagerModel model = new ListManagerModel();
    @Test
    void newList_clears_list_of_items() {
        //call newList
        model.newList();
        //get list with display
        ObservableList<ListItem> newList = model.display(true, true);
        //assert that list is empty
        assertTrue(newList.isEmpty());
    }

    @Test
    void addItem_adds_new_item_to_list() {
        //clear list
        model.newList();
        //use addItem to create item with data
        model.addItem("Example Description", "2021-01-01", " ");
        //get new list
        ObservableList<ListItem> newList = model.display(true, true);
        //get item data from list
        String itemDesc = newList.get(0).getDesc();
        //assert that item data is identical
        assertEquals("Example Description", itemDesc);
    }

    @Test
    void removeItem_removes_selected_item_from_list() {
        //clear list
        model.newList();
        //add items to list
        model.addItem("Example Description", "2021-01-01", " ");
        model.addItem("Example Description 2", "2021-02-02", " ");
        model.addItem("Example Description 3", "2021-03-03", " ");
        //get list
        ObservableList<ListItem> beforeList = model.display(true, true);
        //get item at specific index
        ListItem beforeItem = beforeList.get(1);
        //select index
        model.selectItem(1, true, true);
        //remove item from list at index
        model.removeItem();
        //get new list
        ObservableList<ListItem> afterList = model.display(true, true);
        //get item at same index
        ListItem afterItem = afterList.get(1);
        //assert that items are different
        assertNotEquals(beforeItem, afterItem);
    }

    @Test
    void editItem_changes_description() {
        //clear list
        model.newList();
        //use addItem to create item with data
        model.addItem("Example Description", "2021-01-01", " ");
        //select item
        model.selectItem(0, true, true);
        //use editItem to edit item with new data
        model.editItem("Edited Description", "2021-02-02");
        //get item
        ListItem item = model.display(true, true).get(0);
        //assert that item data is updated to new data
        assertEquals("Edited Description", item.getDesc());
    }

    @Test
    void editItem_changes_date() {
        //clear list
        model.newList();
        //use addItem to create item with data
        model.addItem("Example Description", "2021-01-01", " ");
        //select item
        model.selectItem(0, true, true);
        //use editItem to edit item with new data
        model.editItem("Edited Description", "2021-02-02");
        //get item
        ListItem item = model.display(true, true).get(0);
        //assert that item data is updated to new data
        assertEquals("2021-02-02", item.getDate());
    }

    @Test
    void flipStatus_marks_complete() {
        //clear list
        model.newList();
        //use addItem to create item with incomplete status
        model.addItem("Example Description", "2021-01-01", " ");
        //select item
        model.selectItem(0, true, true);
        //use flipStatus to change status to complete
        model.flipStatus();
        //get item
        ListItem item = model.display(true, true).get(0);
        //assert that item data is updated to new data
        assertEquals("X", item.getStatus());
    }

    @Test
    void flipStatus_marks_incomplete() {
        //clear list
        model.newList();
        //use addItem to create item with complete status
        model.addItem("Example Description", "2021-01-01", "X");
        //select item
        model.selectItem(0, true, true);
        //use flipStatus to change status to incomplete
        model.flipStatus();
        //get item
        ListItem item = model.display(true, true).get(0);
        //assert that item data is updated to new data
        assertEquals(" ", item.getStatus());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void display_returns_all_items(int index) {
        //create list of items
        ListItem item1 = new ListItem("Example Description", "2021-01-01", "X");
        ListItem item2 = new ListItem("Example Description 2", "2021-02-02", " ");
        ListItem item3 = new ListItem("Example Description 3", "2021-03-03", "X");
        ObservableList<ListItem> expectedList = observableArrayList(item1, item2, item3);
        //clear list
        model.newList();
        //add items with different statuses
        model.addItem("Example Description", "2021-01-01", "X");
        model.addItem("Example Description 2", "2021-02-02", " ");
        model.addItem("Example Description 3", "2021-03-03", "X");
        //get list using display given parameters of complete and incomplete items
        ObservableList<ListItem> displayList = model.display(true, true);
        //assert that data in lists is identical
        assertEquals(expectedList.get(index).getDesc(), displayList.get(index).getDesc());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void display_returns_only_complete(int index) {
        //create list of items with only complete
        ListItem item1 = new ListItem("Example Description", "2021-01-01", "X");
        ListItem item3 = new ListItem("Example Description 3", "2021-03-03", "X");
        ObservableList<ListItem> expectedList = observableArrayList(item1, item3);
        //clear list
        model.newList();
        //add items with different statuses
        model.addItem("Example Description", "2021-01-01", "X");
        model.addItem("Example Description 2", "2021-02-02", " ");
        model.addItem("Example Description 3", "2021-03-03", "X");
        //get list using display given parameters of only complete items
        ObservableList<ListItem> displayList = model.display(true, false);
        //assert that data in lists is identical
        assertEquals(expectedList.get(index).getDesc(), displayList.get(index).getDesc());
    }

    @Test
    void display_returns_only_incomplete() {
        //create list of items with only incomplete
        ListItem item2 = new ListItem("Example Description 2", "2021-02-02", " ");
        ObservableList<ListItem> expectedList = observableArrayList(item2);
        //clear list
        model.newList();
        //add items with different statuses
        model.addItem("Example Description", "2021-01-01", "X");
        model.addItem("Example Description 2", "2021-02-02", " ");
        model.addItem("Example Description 3", "2021-03-03", "X");
        //get list using display given parameters of only incomplete items
        ObservableList<ListItem> displayList = model.display(false, true);
        //assert that data in lists is identical
        assertEquals(expectedList.get(0).getDesc(), displayList.get(0).getDesc());
    }

    @Test
    void saveList_saves_to_file() {
        //clear list
        model.newList();
        //add items to list
        model.addItem("Example Description", "2021-01-01", " ");
        model.addItem("Example Description 2", "2021-02-02", "X");
        model.addItem("Example Description 3", "2021-03-03", " ");
        //create file to save to
        File saveFile = new File("testfiles/test.file");
        //save list to file
        model.saveList(saveFile);
        //read file
        try {
            Scanner sc = new Scanner(saveFile);
            String line = sc.nextLine();
            //assert that file saved data as formatted text
            assertEquals("Example Description:2021-01-01: ", line);
        }
        catch(Exception e){fail();}
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void loadList_loads_from_file(int index) {
        //clear list
        model.newList();
        //add items to list
        model.addItem("Example Description", "2021-01-01", " ");
        model.addItem("Example Description 2", "2021-02-02", "X");
        model.addItem("Example Description 3", "2021-03-03", " ");
        //get list
        ObservableList<ListItem> expectedList = model.display(true, true);
        //create file to save to
        File file = new File("testfiles/test.file");
        //save list to file
        model.saveList(file);
        //clear list
        model.newList();
        //load list from file
        model.loadList(file);
        //get loaded list
        ObservableList<ListItem> loadedList = model.display(true, true);
        //assert that lists contain same data
        assertEquals(loadedList.get(index).getDesc(), expectedList.get(index).getDesc());
    }
}