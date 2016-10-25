package greenlander.dao;

import java.util.List;

import greenlander.entity.RsTaskItem;
import greenlander.persistence.entity.mysql.*;

public interface MySqlConnection
{
	public List<Task> getTaskList();
	
	public void deleteTaskItem(int id);
	
	public void updateTaskItem(RsTaskItem taskItem);
}
