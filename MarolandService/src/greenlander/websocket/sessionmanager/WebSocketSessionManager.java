package greenlander.websocket.sessionmanager;

import greenlander.websocket.transmission.JsonConvertor;
import greenlander.websocket.transmission.Message;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

import javax.websocket.EncodeException;
import javax.websocket.Session;


public class WebSocketSessionManager
{
	private HashSet<Session> set = new HashSet<Session>();
	
	public void AddSession(Session session)
	{
		String id = session.getId();
 		set.add(session);
	}
	
	public void RemoveSession(Session session)
	{
		if (set.contains(session))
		{
			set.remove(session);
		}
	}
	
	public void SendMessage(String message)
	{
		Iterator<Session> iterator = set.iterator();
		if (iterator.hasNext())
		{
			Session session = iterator.next();
			try
			{
				session.getBasicRemote().sendText(message);
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void SendObject(JsonConvertor jsonConvertor)
	{
		Iterator<Session> iterator = set.iterator();
		if (iterator.hasNext())
		{
			Session session = iterator.next();
			try
			{
				Message message = new Message(jsonConvertor.ToJsonObject());
				session.getBasicRemote().sendObject(message);
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EncodeException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
