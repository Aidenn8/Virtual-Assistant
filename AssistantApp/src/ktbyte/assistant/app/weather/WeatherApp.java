package ktbyte.assistant.app.weather;

import java.util.Arrays;
import java.util.List;

import ktbyte.assistant.app.Action;
import ktbyte.assistant.app.App;

public class WeatherApp extends App{

  @Override
  public List<Action> getActions() {
    return Arrays.asList(new GetWeatherAction());
  }
}