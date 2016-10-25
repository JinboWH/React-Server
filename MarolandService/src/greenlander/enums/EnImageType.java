package greenlander.enums;

public enum EnImageType
{
	JPEG (0),
	AVI (1),
	DICOM (2);
	
	private final int value;
	
	public int getValue() {  
        return value;  
    }  
	
	EnImageType(int value)
	{
		this.value = value;  
	}
}
