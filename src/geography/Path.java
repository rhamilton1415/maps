package geography;

import mathsUtility.*;

public class Path<T extends MapNode<? extends Number>>
{
	private final T mapNodeOne;
	private final T mapNodeTwo;
	private final double pathDistance; //Distance may not equal cost
	/**
	 * The arguments for a Path Instance must pass the following sanity checks:
	 * to != from
	 * 
	 * @param to a MapNode to be included in the Path
	 * @param from a MapNode to be included in the Path
	 */
	public Path(T to, T from)
	{
		mapNodeOne = to;
		mapNodeTwo = from;
		pathDistance = MapNode.getDistance(to, from);
	}
	public <M extends MapNode<? extends Number>> boolean hasMapNode(M node)
	{
		return (mapNodeOne == node || mapNodeTwo == node);
	}
	public Pair<T,T> getNodes()
	{
		return new Pair<T,T>(mapNodeOne,mapNodeTwo);
	}
	public double getPathDistance()
	{
		return pathDistance;
	}
}
