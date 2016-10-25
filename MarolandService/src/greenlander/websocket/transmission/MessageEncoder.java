package greenlander.websocket.transmission;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder  implements Encoder.Text 
{
	@Override
	public String encode(Object object) throws EncodeException
	{
		Message message = (Message) object;
		String json = message.getJson().toString();
		return json;
	}
	
	@Override
	public void init(EndpointConfig config)
	{
		System.out.println("Init");
	}

	@Override
	public void destroy()
	{
		System.out.println("destroy");
	}
}
