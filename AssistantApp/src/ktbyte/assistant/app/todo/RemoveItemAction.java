package ktbyte.assistant.app.todo;

import ktbyte.assistant.app.Action;

public class RemoveItemAction extends Action{
	
	String[] keywords = {"remove", "delete", "finish", "done", "complete"};
	
	public void doCommand(String command) {
		ToDoList toDoList = ToDoList.getInstance();
		toDoList.removeItem(command);
		
	}

	
	public double getLikelihood(String command) {
		if(ToDoApp.removeGetLikelihood == 0) {
			for(String e : keywords) {
				if(command.contains(e)) {
					return 3;
				}
			}
		}else if(ToDoApp.removeGetLikelihood == 5) {
			return 3;
		}
		return 0;
	}
}
