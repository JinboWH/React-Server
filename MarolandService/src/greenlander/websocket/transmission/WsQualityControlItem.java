package greenlander.websocket.transmission;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class WsQualityControlItem implements JsonConvertor
{
	public Long code;
	
	public String name;

	public String remark;
	
	public String modality;
	
	public String gradeType;
	
	public JsonObject ToJsonObject()
	{
		JsonObjectBuilder joBuild = Json.createObjectBuilder();
		joBuild.add("JsonConvertor", "WsQualityControlItem");
		joBuild.add("code",getString(code));
		joBuild.add("name", getString(name));
		joBuild.add("remark",getString(remark));
		joBuild.add("modality",getString(modality));
		joBuild.add("gradeType", getString(gradeType));	
		
		return joBuild.build();
	}
	
	private	 String getString(Object o)
	{
		return o == null ? "" : o.toString();
	}
}
