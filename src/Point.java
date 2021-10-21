
public class Point implements Comparable<Point> {

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

	}

	public Point(int x, int y)
	{
		this("", x, y);
	}
	
	public boolean hasNonNegativeCoordinates()
	{
		return x <= 0 || y <= 0;
	}
	
	public boolean hasValidName()
	{
		return name.length() > 0 && Character.isLetter(name.charAt(0));
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public String getName()
	{
		return name;
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

	@Override
	public int compareTo(Point point) {

		if (x != point.x)
		{
			return -1;
		}
		if (y != point.y)
		{
			return 1;
		}

		return 0;
	}
}
