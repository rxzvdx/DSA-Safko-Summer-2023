
public class Patient implements Comparable<Patient>
{
	private String name;
	private int ID;
	private String ailment;
	private int priority;

	public Patient(String name, int ID, String ailment, int priority) 
	{
		this.name = name;
		this.ID = ID;
		this.ailment = ailment;
		this.priority = priority;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public void setID(int iD) 
	{
		ID = iD;
	}

	public void setAilment(String ailment) 
	{
		this.ailment = ailment;
	}

	public void setPriority(int priority) 
	{
		this.priority = priority;
	}

	public String getName() 
	{
		return name;
	}

	public int getID() 
	{
		return ID;
	}

	public String getAilment() 
	{
		return ailment;
	}

	public int getPriority() 
	{
		return priority;
	}

	@Override
	public String toString() 
	{
		return "Name: " + name + ", ID: " + ID + ", Ailment: " + ailment + ", Priority: " + priority + "\n";
	}
	
	@Override
	public int compareTo(Patient other) 
	{
		// Compare patients based on their priority
		return Integer.compare(this.priority, other.priority);
	}
}
