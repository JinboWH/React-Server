package greenlander.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="listing")
public class Item {

	private String name;
	private int    id;
	
	public Item(String Name, int Id )
	{
		name = Name;
		id = Id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
