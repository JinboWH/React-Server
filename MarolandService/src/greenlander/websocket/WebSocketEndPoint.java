package greenlander.websocket;

import greenlander.dao.*;
import greenlander.action.*;
import greenlander.websocket.transmission.*;
import greenlander.websocket.sessionmanager.*;

import java.io.IOException;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@ServerEndpoint(value="/websocket", encoders = {MessageEncoder.class}, decoders = {MessageDecoder.class})
public class WebSocketEndPoint extends SpringBeanAutowiringSupport
{
	@Autowired
	private UserAction userAction;
	@Autowired
	private UserItemDao userItemDao;
	@Autowired
	private WebSocketSessionManager sessionManager;
	
	@OnMessage
    public void onMessage(Message message, Session session) throws IOException, InterruptedException 
	{
		System.out.println("Received: " + message);
		// Print the client message for testing purposes
		//System.out.println("Received: " + message);
		
		// Send the first message to the client
		//session.getBasicRemote().sendText("This is the first server message");
		
//		// Send 3 messages to the client every 5 seconds
//		int sentMessages = 0;
//		while(sentMessages < 3)
//		{
//			Thread.sleep(5000);
//			session.getBasicRemote().sendText("This is an intermediate server message. Count: " + sentMessages);
//			sentMessages++;
//		}
//		
//		Long id = (long) 10;
//		session.getBasicRemote().sendText(userItemDao.Get(id).getName());
//		
//		// Send a final message to the client
//		session.getBasicRemote().sendText("This is the last server message");
    }
	
	@OnOpen
    public void onOpen (Session session)
	{
		sessionManager.AddSession(session);
    }

    @OnClose
    public void onClose (Session session) 
    {
    	System.out.println("closed Session Id = " + session.getId());
    	sessionManager.RemoveSession(session);
    	System.out.println("Connection closed");
    }
}