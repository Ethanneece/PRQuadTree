import java.util.ArrayList;

public class DataBase {

	private PRQuadTree quadTree;
	private SkipList<String, Point> skipList;
	
	public DataBase()
	{
		quadTree = new PRQuadTree(new Rectangle(0, 0, 1024, 1024));
		skipList = new SkipList<>();
	}
	
	public void insert(String name, int x, int y)
	{
		Point point = new Point(name, x, y);

		if (point.isOutofBounds(rectangle))
		{
			System.out.println("Point rejected: (" + point.toString() + ")");
		}

		for(Point p : skipList.search(name))
		{
			if (p.equals(point))
			{
				System.out.println("Point rejected: (" + point.toString() + ")");
				return;
			}
		}

		skipList.insert(name, point);
		quadTree.insert(point);

		System.out.println("Point Inserted: (" + point.toString() + ")");
	}
	
	public void remove(String name)
	{
		Point p = skipList.remove(name);

		if (p == null)
		{
			System.out.println("Point not removed: " + name);
			return;
		}

		quadTree.remove(p);

		System.out.println("Point removed: (" + p.toString() + ")");
	}
	
	public void remove(int x, int y)
	{
		Point rangeTester = new Point(x, y);

		if (rangeTester.isOutOfBounds(rectangle))
		{
			System.out.println("Point rejected: (" + x ", " + y ")");
		}

		Point p = quadTree.remove(x, y);

		if (p == null)
		{
			System.out.println("Point not found: (" + x + ", " + y ")");
			return;
		}

		skipList.remove(p.getName());
		System.out.println("Point removed: (" + p.toString() + ")");
	}
	
	public void regionSearch(int x, int y, int w, int h)
	{
		Rectangle region = new Rectangle(x,y,w,h);

		if (!region.hasDimensions())
		{
			System.out.println("Rectangle rejected: " + region.noName());
			return;
		}

		ArrayList<Point> points = new ArrayList<>();
		int nodesVisted = quadTree.regionSearch(region, points);

		System.out.println("Points intersecting region " + region.noName() + ":");
		for (int i = 0; i < points.size(); i++)
		{
			System.out.println("Point found: (" + points.get(i).toString() + ")");
		}
		System.out.println(nodesVisted + " quadtree nodes visited");

	}
	
	public void duplicates()
	{
		ArrayList<Point> duplicates = quadTree.duplicates();

		System.out.println("Duplicate points:");
		for(Point point : duplicates)
		{
			System.out.println("(" + point.getX() + ", " + point.getY() + ")");
		}
	}
	
	public void search(String name)
	{
		ArrayList<Point> points = skipList.search(name);

		if (points.size() == 0)
		{
			System.out.println("Point not found: " + name);
			return;
		}

		for (Point point : points)
		{
			System.out.println("Found ( " + point.toString() + ")");
		}
	}
	
	public void dump()
	{
		skipList.dump();
		quadTree.dump();
	}
}