
public class Point {

	private String name; 
	private int x; 
	private int y; 
	
	public Point(String name, int x, int y)
	{
		this.name = name;
		this.x = x; 
		this.y = y; 
	}
	
	public Point(String name)
	{
		this(name, 0, 0);
	}
	
	public Point()
	{
		this("");
	}
	
	public boolean hasNonNegativeCoordinates()
	{
		return x <= 0 || y <= 0;
	}
	
	public boolean hasValidName()
	{
		return name.length() > 0 && Character.isLetter(name.charAt(0));
	}
	
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true; 
		}
		
		if (o == null)
		{
			return false; 
		}
		
		if (o instanceof Point)
		{
			Point p = (Point) o;
			
			return x == p.x && y == p.y && name.equals(p.name);
		}
		
		return false; 
	}
}
