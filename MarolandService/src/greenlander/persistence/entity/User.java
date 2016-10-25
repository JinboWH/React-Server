package greenlander.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_user")
public class User
{
	private User()
	{}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String UserId;	

	@Column(name="UserName")
	private String UserName;
	
	@Column(name="UserPassWord")
	private String PassWord;
	
	
	public String getUserId()
	{
		return UserId;
	}

	public void setUserId(String userId)
	{
		UserId = userId;
	}

	public String getUserName()
	{
		return UserName;
	}

	public void setUserName(String userName)
	{
		UserName = userName;
	}

	public String getPassWord()
	{
		return PassWord;
	}

	public void setPassWord(String passWord)
	{
		PassWord = passWord;
	}
	
}