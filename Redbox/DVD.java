package Redbox;

// container class for relevant data
public class DVD implements Comparable<DVD>
{
	// members to hold our data
	private String title;
	private int available;
	private int rented;
	
	// standard getters
	public String getTitle(){return title;}
	public int getAvailable(){return available;}
	public int getRented(){return rented;}
	
	// standard setters
	public void setTitle(String title){this.title = title;}
	public void setAvailable(int available){this.available = available;}
	public void setRented(int rented){this.rented = rented;}
	
	// standard constructor
	public DVD()
	{
		title = "";
		available = rented = 0;
	}
	
	// full constructor
	public DVD(String title, int available, int rented)
	{
		this.title = title;
		this.available = available;
		this.rented = rented;
	}
	// String constructor for new DVD
	public DVD(String title)
	{
		this();
		this.title = title;
	}
	// add available items
	public void addAmt(int available, int rented)
	{
		this.available += available;
		this.rented += rented;
	}
	// add available items
	public void addAmt(int num)
	{
		available += num;
	}
	// remove a dvd
	public void removeAmt(int num) throws ArithmeticException
	{
		if (available - num < 0)
			throw new ArithmeticException("None Available");
		else
		{
			available -= num;
		}
	}
	// rent a dvd
	public void rentAmt(int num) throws ArithmeticException
	{
		if (available - num < 0)
			throw new ArithmeticException("None Available");
		else
		{
			available -= num;
			rented += num;
		}
	}
	// return a dvd
	public void returnAmt(int num) throws ArithmeticException
	{
		if (rented - num < 0)
			throw new ArithmeticException("None Available");
		else
		{
			available += num;
			rented -= num;
		}
	}
	// compareTo takes a DVD
	@Override
	public int compareTo(DVD item)
	{
		return this.title.compareTo(item.getTitle());
	}
}
