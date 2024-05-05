package ktbyte.assistant.app.todo;

import ktbyte.assistant.app.Action;

public class GetListAction extends Action{
	String[] keywords = { "list", "get", "to do", "view"};
//	double[] scores =   { 0.2,       4,     3};
	
	
	public void doCommand(String command) {
		ToDoList toDoList = ToDoList.getInstance();
		toDoList.getList();
	}

	
	public double getLikelihood(String command) {
		for(String e : keywords) {
			if(command.contains(e)) {
				return 3;
			}
		}
		
		return 0;
		
	}
	
	
}
