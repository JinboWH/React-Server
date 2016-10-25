package greenlander.rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import greenlander.persistence.entity.mysql.Task;
import greenlander.persistence.entity.mysql.TaskItem;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.jboss.resteasy.annotations.providers.jaxb.json.*;

import greenlander.dao.MySqlConnection;
import greenlander.entity.RsTaskItem;

@Path("/React")
public class ReactRS extends SpringBeanAutowiringSupport
{
	@Autowired
	private MySqlConnection taskItemDao;
	
	@GET
	@Path("/GetTaskList")	
	@Produces("application/json;charset=utf-8")	
	public Task[] GetTaskList()
	{
		List<Task> list = taskItemDao.getTaskList();
		
		Task[] tasks = new Task[list.size()];
		list.toArray(tasks);
		
		return tasks;
	}
	
	@DELETE
	@Path("/DeleteTaskItem/{taskItemId}")
	public void DeleteTaskItem(@PathParam("taskItemId") int taskItemId){
		taskItemDao.deleteTaskItem(taskItemId);
	}
			
	
	@POST
	@Path("/UpdateTaskItem/")
	public void UpdateTaskItem(@Mapped(attributesAsElements={"TaskItem"}) RsTaskItem taskItem ){
		
		if (taskItem != null){
			taskItemDao.updateTaskItem(taskItem);			
		}
		else{
			Logger.getLogger("UpdateTaskItem").log(Level.ERROR, "taskItem is null");
		}
	}
}
