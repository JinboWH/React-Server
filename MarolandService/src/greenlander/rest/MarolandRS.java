package greenlander.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import greenlander.dao.*;
import greenlander.action.*;
import greenlander.entity.*;
import greenlander.persistence.entity.*;
import greenlander.persistence.entity.mysql.Task;

import javax.ws.rs.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Path("GL")
public class MarolandRS extends SpringBeanAutowiringSupport
{
	@Autowired
	private UserAction userAction;
	@Autowired
	private UserItemDao userItemDao;
	
	
	@GET
	@Path("GetString/{name}")
	@Produces("application/json;charset=utf-8")
	public String GetString(@PathParam("name") String name)
	{
//		Long id = (long) 10;
//		QualityControlItem item = userItemDao.Get(id);
//		
//		return item.getName();
		return name;
	}

	@GET
	@Path("item")
	@Produces("application/json;charset=utf-8")
	public QualityControlItem getItem()
	{
		Long id = (long) 10;
		QualityControlItem controlItem = userItemDao.Get(id);
		
		return controlItem;
	}

	@GET
	@Path("items")
	@Produces("application/json")
	public Item[] getJSONItems()
	{
		Item[] items = new Item[3];

		Item item1 = new Item("computer", 2500);
		Item item2 = new Item("chair", 100);
		Item item3 = new Item("table", 200);

		items[0] = item1;
		items[1] = item2;
		items[2] = item3;

		return items;
	}
	
	
	@GET
	@Path("GetServiceDatetime")
	@Produces("application/text;charset=utf-8")
	public String GetServiceDatetime() throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(new Date());
	}
	
	@GET
	@Path("UserLogin")	
	@Produces("application/json;charset=utf-8")	
	public User UserLogin(@QueryParam("userName") String userName, @QueryParam("passWord") String passWord) throws Exception
	{
		User user = userAction.Login(userName,passWord);
		if (user != null)
		{
			return user;
		}
		else
		{
			throw new Exception("invalid username or password");
		}
	}

}
