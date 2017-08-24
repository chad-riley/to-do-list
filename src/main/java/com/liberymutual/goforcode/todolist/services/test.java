// ToDoItemRepository.java
package com.liberymutual.goforcode.todolist.services;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.liberymutual.goforcode.todolist.models.ToDoItem;

@Service
public class test {

    private int nextId = 1;

    /**
     * Get all the items from the file. 
     * @return A list of the items. If no items exist, returns an empty list.
     */
    public List<ToDoItem> getAll() {
        // Replace this with something meaningful
        return Collections.emptyList();
    }

    /**
     * Assigns a new id to the ToDoItem and saves it to the file.
     * @param item The to-do item to save to the file.
     */
    public void create(ToDoItem item) {
        // Fill this in with something meaningful
    }

    /**
     * Gets a specific ToDoItem by its id.
     * @param id The id of the ToDoItem.
     * @return The ToDoItem with the specified id or null if none is found.
     */
    public ToDoItem getById(int id) {
        // Replace this with something meaningful
        return null;
    }

    /**
     * Updates the given to-do item in the file.
     * @param item The item to update.
     */
    public void update(ToDoItem item) {
        // Fill this in with something meaningful
    }

}
