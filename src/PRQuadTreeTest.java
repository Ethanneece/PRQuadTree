import student.TestCase;

public class PRQuadTreeTest extends TestCase {
	
	private PRQuadTree empty; 
	private PRQuadTree small; 
	private PRQuadTree medium; 
	private PRQuadTree large;
	private PRQuadTree sameElements; 
	
	public void setUp()
	{
		Rectangle worldBox = new Rectangle(0, 0, 1024, 1024);
		empty = new PRQuadTree(worldBox); 
		
		small = new PRQuadTree(worldBox);
		for (int i = 0; i < 3; i++)
		{
			small.insert(new Point("small", i, i));
		}
		
		medium = new PRQuadTree(worldBox);
		for (int i = 0; i < 30; i++)
		{
			medium.insert(new Point("medium", i * 30, i * 30));
		}
		
		large = new PRQuadTree(worldBox);
		for (int i = 0; i < 1000; i++)
		{
			large.insert(new Point("large", i, i));
		}
		
		sameElements= new PRQuadTree(worldBox);
		for (int i = 10; i < 10; i++)
		{
			sameElements.insert(new Point("same", 10, 10));
		}
	}
	
	public void testInsert()
	{
		empty.insert(new Point("point ", 10, 10));
		
		assertTrue(empty.getHead() instanceof LeafNode);
		
		assertTrue(medium.getHead() instanceof InternalNode);
	}
	
	public void testRemove()
	{
		assertNull(empty.remove(0, 0));
		
		assertEquals(new Point("medium", 900, 900), medium.remove(900, 900));
		
		assertEquals(new Point("same", 10, 10), sameElements.remove(10, 10));
		
		assertEquals(new Point("large", 1000, 1000), large.remove(1000, 1000));
	}

	public void 
}
