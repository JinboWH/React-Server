package greenlander.websocket.transmission;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class WsPatientImage implements JsonConvertor
{
	public String imageData;
	
	public JsonObject ToJsonObject()
	{
		JsonObjectBuilder joBuild = Json.createObjectBuilder();
		joBuild.add("JsonConvertor", "WsPatientImage");
		
		joBuild.add("image", getString(imageData));	
		return joBuild.build();
	}
	
	private	 String getString(Object o)
	{
		return o == null ? "" : o.toString();
	}
}
