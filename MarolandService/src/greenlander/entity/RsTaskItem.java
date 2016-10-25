package greenlander.entity;

import javax.xml.bind.annotation.*;

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

@BadgerFish
@XmlRootElement(name = "TaskItem")
public class RsTaskItem
{
	private int id;
	
	private String name;
	private int done;
	
	@XmlElement
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	@XmlElement
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	@XmlElement
	public int getDone()
	{
		return done;
	}
	public void setDone(int done)
	{
		this.done = done;
	}
}
