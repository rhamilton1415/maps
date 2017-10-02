package geography;

import java.util.HashSet;

public abstract class MapNode<T extends Number>
{
	private T xCoordinate;
	private T yCoordinate;
	private HashSet<Path> paths;
	public MapNode(T x, T y)
	{
		xCoordinate = x;
		yCoordinate = y;
	}
	public T getXCoordinate()
	{
		return xCoordinate;
	}
	public T getYCoordinate()
	{
		return yCoordinate;
	}
	
	public <M extends MapNode> boolean hasPathTo(M target)
	{
		try
		{
			getPathTo(target);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public <M extends MapNode> Path getPathTo(M target)
	{
		for(Path p : paths)
		{
			if(p.hasMapNode(target))
			{
				return p;
			}
		}
		throw new Exception();
	}
}
