package ktbyte.assistant.app.randomFact;

import org.json.JSONArray;
import com.mashape.unirest.http.JsonNode;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
 

import com.mashape.unirest.http.HttpResponse;

import ktbyte.assistant.Assistant;
import ktbyte.assistant.app.Action;
import ktbyte.assistant.app.Response;

public class RandomFactAction extends Action{
	String[] keywords = {"fact", "random", "information", "info", "unusual", "useless"};
	int factLength;
	public void doCommand(String command) {
		Assistant assistant = Assistant.getInstance();
		HttpRequest req = null;
		req = Unirest.get("https://uselessfacts.jsph.pl/random.json?language=en");
		System.out.println(req);
		try {
			HttpResponse<JsonNode> ans = req.asJson();
			System.out.println(ans);
			JsonNode node = ans.getBody();
			
			JSONArray json = node.getArray();
			System.out.println("found it");
			
			System.out.println(json.length());
			String fact = json.getJSONObject(0).getString("text");
			
			System.out.println(fact);
			//FIGURE OUT HOW TO SPLIT UP FACT INTO MULTIPLE LINES
//			for(int i = 0; i<fact.length(); i++) {
//				factLength+=1;
//				if(factLength % 10 == 0 &  ) {
//					assistant.displayItem(new Response(" "));
//				}
//			}
			assistant.displayItem(new Response(fact));
			
		}catch(UnirestException e) {
			System.out.println("request error occurred: " + e);
			assistant.displayItem(new Response("An error occurred"));
		}
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
