package com.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl {
	
	int count;
	
	List<Item> itemList;
	
	public ItemServiceImpl(){
		count=0;
		itemList = new ArrayList<Item>();
	}
	
	public List<Item> getAllItems(){
		return this.itemList;
	}
	
	public Item addItem(Item item){
		count++;
		item.setId(count);
		itemList.add(item);
		return item;
	}
	
	public Item getItem(int id){
		Item item = null;
		for (Item currentItem : itemList) {
			if(id == currentItem.getId()){
				item= currentItem;
			}
		}
		return item;
	}
	
	public Item updateItem(Item item){
		for (Item currentItem : itemList) {
			if(item.getId() == currentItem.getId()){
				currentItem.setNotes(item.getNotes());
				currentItem.setTodo(item.getTodo());
				return currentItem;
			}
		}
		return null;
	}

}
