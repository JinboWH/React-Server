package greenlander.persistence.entity.mysql;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="taskItem")
@XmlRootElement(name="taskItem") 
public class TaskItem
{
	
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="done")
	private int done;
	

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getDone()
	{
		return done;
	}

	public void setDone(int done)
	{
		this.done = done;
	}
}
