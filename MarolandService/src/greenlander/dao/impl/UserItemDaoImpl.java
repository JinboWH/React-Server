package greenlander.dao.impl;

import java.util.List;

import greenlander.dao.*;
import greenlander.persistence.entity.QualityControlItem;
import greenlander.persistence.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class UserItemDaoImpl implements UserItemDao
{
	@PersistenceContext(unitName="oracle")
	private EntityManager entityManager;
	
	public void Save(QualityControlItem qualityControlItem)
	{
		
	}
	
	public QualityControlItem Get(Long id)
	{
		return entityManager.find(QualityControlItem.class,id);
	}
	
	@SuppressWarnings("unchecked")
	public User GetUser(String userName, String passWord)
	{
		String hql = "from User where UserName = :userName and PassWord = :passWord ";
		Query query = entityManager.createQuery(hql, User.class);
		
		query.setParameter("userName", userName);
		query.setParameter("passWord",passWord);
		
		List<User> userList = query.getResultList();
		if (userList.size() > 0)
		{
			return userList.get(0);
		}
		return null;
	}
	
	
}
