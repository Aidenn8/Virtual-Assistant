package ktbyte.assistant.app.time;

import java.time.LocalTime;

import ktbyte.assistant.Assistant;
import ktbyte.assistant.app.Action;
import ktbyte.assistant.app.Response;

public class GetTimeAction extends Action{
	public void doCommand(String command) {
		Assistant assistant = Assistant.getInstance();
		
		String result = LocalTime.now().toString();
		
		assistant.displayItem(new Response("Local time: " + result));
	}
	
	public double getLikelihood(String command) {
		if(command.contains("time") || command.contains("clock")) {
			return 4;
		}
		return 0;
		
		
	}
}
