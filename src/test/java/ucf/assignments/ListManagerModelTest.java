package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListManagerModelTest {
    @Test
    void newList_creates_new_list_with_name() {
        //create a list with specific name
        //assert that the list name is equal to name given
    }

    @Test
    void deleteList_deletes_list_from_data_given_name() {
        //create several lists different names
        //call deleteList with a specific names
        //assert that listCollection does not contain deleted list
    }

    @Test
    void renameList_changes_list_name_to_given_name() {
        //create list
        //call renameList with list and new name
        //assert that list name is equal to name given
    }

    @Test
    void addItem_adds_item_to_list_with_given_description() {
        //create list
        //add item with specific description
        //assert that item description matches description given
    }

    @Test
    void addItem_adds_item_to_list_with_given__date() {
        //create list
        //add item with specific date
        //assert that item date matches date given
    }

    @Test
    void removeItem_removes_specific_item_from_list() {
        //create list
        //add several items
        //call removeItem with specific index
        //assert that item at index is not the same as original item at index
    }

    @Test
    void setItemDesc_updates_description_for_specific_item() {
        //create list
        //add item with specific description
        //call setItemDesc with item and new description
        //assert that item description matches new description
    }

    @Test
    void setItemDate_updates_date_for_specific_item() {
        //create list
        //add item with specific date
        //call setItemDate with item and new date
        //assert that item description matches new date
    }

    @Test
    void setStatus_marks_as_complete() {
        //create list
        //add item with status set to false
        //call setStatus with item and true boolean
        //assert that item status is true
    }
    @Test
    void display_displays_all_items() {
        //create list
        //add items with different statuses
        //call display with setting complete set to true
        //call display with setting incomplete set to true
        //assert that list displays all items given
    }
    @Test
    void display_displays_only_uncompleted() {
        //create list
        //add items with different statuses
        //call display with setting complete set to false
        //call display with setting incomplete set to true
        //assert that list displays only incomplete items
    }
    @Test
    void display_displays_only_completed() {
        //create list
        //add items with different statuses
        //call display with setting complete set to true
        //call display with setting incomplete set to false
        //assert that list displays only complete items
    }
    @Test
    void saveList_saves_selected_list() {
        //create list with name
        //call saveList with name and specific directory
        //get file at directory
        //convert file to list
        //assert that list is equal to given list
    }
    @Test
    void saveAll_saves_several_lists() {
        //create several list with different names
        //call saveAll with specific directory
        //get files at directory
        //convert files to lists
        //assert that lists are equal to given lists
    }
    @Test
    void loadLists_loads_single_file() {
        //create list
        //call saveList with given list and specific directory
        //call loadLists with specific directory
        //assert that returned list is original list
    }
    @Test
    void loadLists_loads_multiple_files() {
        //create lists
        //call saveAll with specific directory
        //call loadLists with specific directory
        //assert that returned lists are original lists
    }
}