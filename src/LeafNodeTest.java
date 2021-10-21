import student.TestCase;

public class LeafNodeTest extends TestCase {

	private LeafNode empty; 
	private LeafNode small; 
	private LeafNode medium; 
	private LeafNode large;
	private LeafNode sameElements; 
	
	
	
	public void setUp()
	{
		empty = new LeafNode(); 
		
		small = new LeafNode(); 
		for (int i = 0; i < 3; i++)
		{
			small.add(new Point("small", i, i));
		}
		
		medium = new LeafNode();
		for (int i = 0; i < 10; i++)
		{
			medium.add(new Point("medium", i, i));
		}
		
		large = new LeafNode();
		sameElements = new LeafNode();
		for (int i = 0; i < 100; i++)
		{
			large.add(new Point("large", i, i));
			sameElements.add(new Point("same", 1, 1));
		}
	}
	
	public void testAdd()
	{
		Point p = new Point("", 0, 0);
		empty.add(p);
		
		assertTrue(empty.getPoints().contains(p));
	}
	
	public void testcanDecomp()
	{
		assertFalse(empty.canDecomp());
		
		assertFalse(small.canDecomp());
		
		assertTrue(medium.canDecomp());
		
		assertFalse(sameElements.canDecomp());
		
		assertTrue(large.canDecomp());
	}
	
	public void testToString()
	{
		assertEquals("leaf", large.toString());
	}
}
