package ktbyte.assistant.app.dictionary;

import ktbyte.assistant.Assistant;
import ktbyte.assistant.app.Response;

public class dictionaryFunctions {
	Assistant assistant = Assistant.getInstance();
	void question() {
		assistant.displayItem(new Response("What word would you like to define?"));
		DictionaryApp.getLikelihood = 5;
	}
	
	
}
