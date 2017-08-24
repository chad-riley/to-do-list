//ToDoItemRepository.java
package com.liberymutual.goforcode.todolist.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.text.html.parser.Parser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.liberymutual.goforcode.todolist.models.ToDoItem;

@Service
public class ToDoItemRepository {

	private int nextId = 1;
	ArrayList<ToDoItem> items;

	public ToDoItemRepository() {
		items = new ArrayList<ToDoItem>();
	}

	public List<ToDoItem> getAll() {

		if (items.size() == 0) {
			try (FileReader reader = new FileReader("ToDo.csv")) {
				for (CSVRecord record : CSVFormat.DEFAULT.parse(reader).getRecords()) {

					int id = Integer.parseInt(record.get(0));
					String text = record.get(1);
					boolean isComplete = Boolean.parseBoolean(record.get(2));
					ToDoItem item = new ToDoItem();
					item.setId(id);
					item.setText(text);
					item.setComplete(isComplete);
					items.add(item);
					nextId += 1;

				}

			} catch (FileNotFoundException e) {
				System.out.println("Could not read file");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Could not read file");
				e.printStackTrace();
			}
		}
		return items;
	}

	/**
	 * Assigns a new id to the ToDoItem and saves it to the file.
	 * 
	 * @param item
	 *            The to-do item to save to the file.
	 */
	public void create(ToDoItem item) {
		// Fill this in with something meaningful

		try 
		(FileWriter writer = new FileWriter("ToDoList.csv", true)){
			
			System.out.println("everything's fine");
		
		CSVPrinter printer = CSVFormat.DEFAULT.print(writer);
			String[] record = new String[3];
			record = new String[] { String.valueOf(nextId), item.getText(), String.valueOf(item.isComplete()) };

			printer.printRecord(record);
			item.setId(nextId);
			items.add(item);
			nextId = nextId + 1;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public ToDoItem getById(int id) {
		for (ToDoItem item : items) { //
			if (id == item.getId()) { //
				return item; //
			}
		}
		return null; //
	}



	
	public void update(ToDoItem updatedItem) {
		
			for (ToDoItem item : items) {
				if (updatedItem.getId() == item.getId()) {
					
					item.setComplete(item.isComplete());		
				}
			}
			
			try 
			(FileWriter writer = new FileWriter("ToDoList.csv");
			CSVPrinter printer = CSVFormat.DEFAULT.print(writer)){
										
				for (ToDoItem item : items){
					
					String[] record = new String[3];
					record = new String[] {
							String.valueOf(item.getId()),
							item.getText(),
							String.valueOf(item.isComplete())};
					printer.printRecord(record);
					
			} 
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
}

