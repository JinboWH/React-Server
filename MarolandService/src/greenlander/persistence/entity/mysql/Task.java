package greenlander.persistence.entity.mysql;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="task")
public class Task
{
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;

	@Column(name="status")
	private String status;
	
	@OneToMany(fetch = FetchType.EAGER,cascade={CascadeType.REFRESH,CascadeType.REMOVE})
	@JoinColumn(name="taskid")    
	private Set<TaskItem> taskItems;
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}	
	
	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	
	public Set<TaskItem> getTaskItems()
	{
		return taskItems;
	}

	public void setTaskItems(Set<TaskItem> taskItems)
	{
		this.taskItems = taskItems;
	}
	
	
}