import student.TestCase;

public class EmptyLeafNodeTest extends TestCase {

	private EmptyLeafNode empty; 
	
	public void setUp()
	{
		empty = new EmptyLeafNode(); 
	}
	
	public void testToString()
	{
		assertEquals("Empty", empty.toString());
	}
}
