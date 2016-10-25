package greenlander.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import greenlander.dao.MySqlConnection;
import greenlander.entity.RsTaskItem;
import greenlander.persistence.entity.mysql.*;

@Repository
@Transactional
public class MySqlConnectionImpl implements MySqlConnection
{
	@PersistenceContext(unitName="mysql")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Task> getTaskList()
	{
		String hql = "from Task ";
		Query query = entityManager.createQuery(hql, Task.class);
					
		List<Task> list = query.getResultList();
		return list;
	}
	
	public void deleteTaskItem(int id){
		TaskItem taskItem = entityManager.find(TaskItem.class, id);
		if (taskItem != null){
			entityManager.remove(taskItem);
		}
	}
	
	public void updateTaskItem(RsTaskItem taskItem){
		if (taskItem != null){
			TaskItem currentTaskItem = entityManager.find(TaskItem.class, taskItem.getId());
			currentTaskItem.setName(taskItem.getName());
			currentTaskItem.setDone(taskItem.getDone());
			
			entityManager.merge(currentTaskItem);
		}
	}
	
	
}
