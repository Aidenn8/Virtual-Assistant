package ktbyte.assistant.app.dictionary;

import java.util.Arrays;
import java.util.List;

import ktbyte.assistant.app.Action;
import ktbyte.assistant.app.App;

public class DictionaryApp extends App{
	static int getLikelihood = 0;
	public List<Action> getActions() {
		return Arrays.asList(new DictionaryAction());
	}
	
}
