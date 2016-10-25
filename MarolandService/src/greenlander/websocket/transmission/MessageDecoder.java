package greenlander.websocket.transmission;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MessageDecoder implements Decoder.Text
{
	@Override
	public Message decode(String string)
	{
		StringReader stringReader = new StringReader(string);
		JsonObject json = Json.createReader(stringReader).readObject();
		return new Message(json);
	}

	@Override
	public boolean willDecode(String string)
	{
		try
		{
			StringReader stringReader = new StringReader(string);
			Json.createReader(stringReader).read();
			return true;
		} catch (JsonException ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * The following two methods are placeholders as we don't need to do
	 * anything special for init or destroy.
	 */
	@Override
	public void init(EndpointConfig config)
	{
		System.out.println("init");
	}

	@Override
	public void destroy()
	{
		System.out.println("destroy");
	}
}
