package ktbyte.assistant.app.todo;

import java.util.Arrays;
import java.util.List;

import ktbyte.assistant.app.Action;
import ktbyte.assistant.app.App;

public class ToDoApp extends App{
	static int addGetLikelihood = 0;
	static int removeGetLikelihood = 0;
	public List<Action> getActions(){
		return Arrays.asList(new GetListAction(), new AddItemAction(), new RemoveItemAction());
	}
	
}
