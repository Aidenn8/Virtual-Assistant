package ktbyte.assistant.app.todo;

import ktbyte.assistant.app.Action;

public class AddItemAction extends Action{
	String[] keywords = {"add", "put", "new item"};
	public void doCommand(String command) {
		ToDoList toDoList = ToDoList.getInstance();
		toDoList.addItem(command);
	}

	public double getLikelihood(String command) {
		
		if(ToDoApp.addGetLikelihood==0) {
			for(String e : keywords) {
				if(command.contains(e)) {
					return 3;
				}
			}
		}else if(ToDoApp.addGetLikelihood==5) {
			return 3;
		}
		return 0;
	}	
}
	

