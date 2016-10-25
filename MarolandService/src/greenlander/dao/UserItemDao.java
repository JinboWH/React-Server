package greenlander.dao;

import greenlander.persistence.entity.*;


public interface UserItemDao
{
	public void Save(QualityControlItem qualityControlItem);
	
	public QualityControlItem Get(Long id);
	
	public User GetUser(String userName, String passWord);
}
