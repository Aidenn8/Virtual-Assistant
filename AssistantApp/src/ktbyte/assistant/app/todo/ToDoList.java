package ktbyte.assistant.app.todo;

import java.util.ArrayList;

import ktbyte.assistant.Assistant;
import ktbyte.assistant.app.Response;

public class ToDoList {
	private static Assistant assistant = null; 
	private static ArrayList<String> toDo = null; 
	private static ToDoList _instance = null;
	
	private ToDoList(){
		if(assistant == null) {
			assistant = Assistant.getInstance();
		}
		
		if(toDo == null) {
			toDo = new ArrayList<String>();
		}
	}
	
	static ToDoList getInstance(){
		if(_instance == null) {
			_instance = new ToDoList();
		}
		return _instance;
	}
	
	public void getList() {
		assistant.displayItem(new Response("To Do:"));
		for(String e : toDo) {
			assistant.displayItem(new Response(e));
		}
	}
	
	public void addItem(String item) {
		if(ToDoApp.addGetLikelihood == 0) {
			assistant.displayItem(new Response("Okay, what is the name of the event?"));
			ToDoApp.addGetLikelihood = 5;
		}else {
			toDo.add(item);
			assistant.displayItem(new Response("Event Added"));
			ToDoApp.addGetLikelihood = 0;
		}
		
	}
	
	public void removeItem(String item) {
		if(ToDoApp.removeGetLikelihood == 0) {
			assistant.displayItem(new Response("Okay, what is the name of the event?"));
			ToDoApp.removeGetLikelihood = 5;
		}else {
			if(toDo.contains(item)) {
				toDo.remove(item);
				assistant.displayItem(new Response("Event Removed"));
				ToDoApp.removeGetLikelihood = 0;
			}else {
				assistant.displayItem(new Response("Sorry, I couldn't find that event"));
			}
			
		}
		
	}
}
