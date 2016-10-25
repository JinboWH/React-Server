package greenlander.action;

import greenlander.persistence.entity.*;

public interface UserAction
{
	public String getUserId();
	
	public User Login(String userName,String passWord);
}
