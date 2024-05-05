package ktbyte.assistant.app.dictionary;

import org.json.JSONArray;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import ktbyte.assistant.Assistant;
import ktbyte.assistant.app.Action;
import ktbyte.assistant.app.Response;

public class DictionaryAction extends Action{
	Assistant assistant = Assistant.getInstance();
	
	String[] keywords = {"meaning", "definition", "define"};
	public void doCommand(String command) {
		String url = "https://api.dictionaryapi.dev/api/v2/entries/en/" + command;
		HttpRequest req = null;
		req = Unirest.get(url);
		System.out.println(req);
		
		if(DictionaryApp.getLikelihood == 5) {
			try {
				HttpResponse<JsonNode> ans = req.asJson();
				System.out.println(ans);
				JsonNode node = ans.getBody();
				
				JSONArray json = node.getArray();
				System.out.println("found it");
				
				System.out.println(json.length());
				JSONArray meaning = json.getJSONObject(0).getJSONArray("meanings");
				JSONArray definitions = meaning.getJSONObject(0).getJSONArray("definitions");
				String definition = definitions.getJSONObject(0).getString("definition");
				
				System.out.println(definition);
				assistant.displayItem(new Response(definition));
				
			}catch(UnirestException e) {
				System.out.println("request error occurred: " + e);
				assistant.displayItem(new Response("An error occurred"));
			}
			
			DictionaryApp.getLikelihood = 0;
		}else {
			assistant.displayItem(new Response("What word would you like to define?"));
			DictionaryApp.getLikelihood = 5;
		}
		
		
		
		
		
	}

	
	public double getLikelihood(String command) {
		if(DictionaryApp.getLikelihood == 0) {
			for(String e : keywords) {
				if(command.contains(e)) {
					return 3;
				}
			}
			
		}else if(DictionaryApp.getLikelihood == 5) {
			return 3;
		}
		
		return 0;
		
	}
	

}
