package geography;

import java.util.HashSet;

public abstract class MapNode<T extends Number>
{
	//TODO add factory construction and Province IDs
	private T xCoordinate;
	private T yCoordinate;
	private HashSet<Path> paths;
	
	public MapNode(T x, T y)
	{
		xCoordinate = x;
		yCoordinate = y;
		paths = new HashSet<>();
	}
	public T getXCoordinate()
	{
		return xCoordinate;
	}
	public T getYCoordinate()
	{
		return yCoordinate;
	}
	
	//A safe version of the "getPathTo"
	public <M extends MapNode<? extends Number>> boolean hasPathTo(M target)
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
	public <M extends MapNode<? extends Number>> Path getPathTo(M target) throws Exception
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
	private void addPath(Path p)
	{
		//TODO Sanity Checks
		paths.add(p);
	}
	@Override
	public String toString()
	{
		//TODO convert to JSON string
		return getXCoordinate().toString() + " " + getYCoordinate().toString();
	}
	public static void createPath(MapNode<? extends Number> to, MapNode<? extends Number> from)
	{
		//TODO Sanity checks
		Path p = new Path(to,from);
		to.addPath(p);
		from.addPath(p);
	}
	/**
	 * Returns the exact distance between the two MapNode arguments, not considering existing Paths
	 * @param to, from MapNode instances to measure
	 */
	public static <M extends MapNode<? extends Number>> double getDistance(M to, M from)
	{
		double xDistance = Math.abs(to.getXCoordinate().doubleValue()-from.getXCoordinate().doubleValue());
		double yDistance = Math.abs(to.getYCoordinate().doubleValue()-from.getYCoordinate().doubleValue());
		return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
	}
}
