import student.TestCase;

public class PointTest extends TestCase {
	
	private Point small; 
	private Point medium;
	private Point huge; 
	private Point validName; 
	private Point invalidName; 
	
	public void setUp()
	{
		small = new Point("", 0, 0);
		
		medium = new Point("medium", 100, 100);
		
		huge = new Point("huge", 1000, 1000);
		
		validName = new Point("validName", 55, 55);
		
		invalidName = new Point("99", 70, 70);
	}
	
	public void testHasValidName()
	{
		assertTrue(validName.hasValidName());
		
		assertFalse(invalidName.hasValidName());
	}
	
	public void testGetters()
	{
		assertEquals(0, small.getX());
		
		assertEquals(100, medium.getY());
		
		assertEquals("huge", huge.getName());
	}

	public void testEquals()
	{
		assertTrue(small.equals(small));
		
		assertFalse(small.equals(null));
		
		assertFalse(small.equals(""));
		
		assertFalse(small.equals(medium));
		
		Point smallCopy = new Point("", 0, 0);
		
		assertTrue(small.equals(smallCopy));
	}
	
	public void testCompareTo()
	{
		assertEquals(-1, small.compareTo(medium));
		
		Point sameXDifferentY = new Point("", 0, 100);
		
		assertEquals(1, small.compareTo(sameXDifferentY));
		
		assertEquals(0, small.compareTo(small));
	}
}
