import student.TestCase;

public class InternalNodeTest extends TestCase {
	
	InternalNode basic; 
	InternalNode hasInternalNode; 
	
	public void setUp()
	{
		basic = new InternalNode(); 
		hasInternalNode = new InternalNode(); 
		
		InternalNode node = new InternalNode(); 
		
		hasInternalNode.setRegion(0, node);

	}
	
	public void testgetRegion()
	{
		EmptyLeafNode empty = new EmptyLeafNode(); 
		LeafNode leaf = new LeafNode(); 
		hasInternalNode.setRegion(1, empty);
		hasInternalNode.setRegion(2, leaf);
		
		assertEquals(empty, hasInternalNode.getRegion(1));
		assertEquals(leaf, hasInternalNode.getRegion(2)); 
		
	}
	
	public void testContainsInternal()
	{
		assertTrue(hasInternalNode.containsInternal());
		
		assertFalse(basic.containsInternal());
	}
	
	public void testSetRegion()
	{
		LeafNode empty = new LeafNode(); 
		
		for (int i = 0; i < 4; i++)
		{
			basic.setRegion(i, empty);
			assertEquals(basic.getRegion(i), empty);
		}
	}
	
	public void testToString()
	{
		assertEquals("Internal", basic.toString());
	}
}
