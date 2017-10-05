package geographyTesting;

import static org.junit.Assert.*;

import org.junit.Test;
import geography.*;
public class ProvinceTesting 
{
	@Test
	public void provinceConstructionTest()
	{
		Province<Integer> p = new Province<>(0,0);
		assertEquals(p.getXCoordinate().intValue(),0);
		assertEquals(p.getYCoordinate().intValue(),0);
		MapNode<Integer> n = new Province<>(1,1);
		assertTrue(n instanceof Province<?>);
	}
	
	@Test
	public void interProvincePathCreationTest()
	{
		Province<Integer> pathFrom = new Province<>(0,0);
		Province<Integer> pathTo = new Province<>(1,0);
		MapNode.createPath(pathFrom,pathTo);
		assertTrue(pathFrom.hasPathTo(pathTo));
		assertTrue(pathTo.hasPathTo(pathFrom));
		try
		{
			assertTrue(pathTo.getPathTo(pathFrom) == pathFrom.getPathTo(pathTo));
			assertEquals(pathTo.getPathTo(pathFrom).getPathDistance(),1,0);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void multiplePathCreation()
	{
		Province<Integer> centre = new Province<>(0,0);
		Province<Integer> north = new Province<>(0,5);
		Province<Integer> east = new Province<>(5,0);
		Province<Integer> south = new Province<>(0,-5);
		Province<Integer> west = new Province<>(-5,0);
		
		MapNode.createPath(centre,north);
		MapNode.createPath(centre,east);
		MapNode.createPath(centre,south);
		MapNode.createPath(centre,west);
		
		assertTrue(centre.hasPathTo(north));
		assertTrue(centre.hasPathTo(east));
		assertTrue(centre.hasPathTo(south));
		assertTrue(centre.hasPathTo(west));
		
		assertFalse(north.hasPathTo(east));
		assertFalse(north.hasPathTo(south));
		assertFalse(north.hasPathTo(west));
		
		assertFalse(east.hasPathTo(south));
		assertFalse(east.hasPathTo(west));
		
		assertFalse(south.hasPathTo(west));
	}
	
	@Test
	public void attemptingToGetAPathThatDoesntExistTest()
	{
		Province<Integer> p1 = new Province<>(0,0);
		Province<Integer> p2 = new Province<>(0,1);
		try
		{
			p1.getPathTo(p2);
			fail();
		}
		catch(Exception e)
		{
			
		}
	}

}
