package greenlander.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_M_QUALITYCONTROLITEM")
public class QualityControlItem
{
	private QualityControlItem()
	{}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long code;
	
	@Column(name="name")
	private String name;
	

	@Column(name="remark")
	private String remark;
	
	@Column(name="modality")
	private String modality;
	
	@Column(name="gradeType")
	private String gradeType;

	public Long getCode()
	{
		return code;
	}

	public String getName()
	{
		return name;
	}

	public String getRemark()
	{
		return remark;
	}

	public String getModality()
	{
		return modality;
	}

	public String getGradeType()
	{
		return gradeType;
	}
}