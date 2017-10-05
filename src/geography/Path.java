package geography;

import mathsUtility.*;

public class Path
{
	private final MapNode<? extends Number> mapNodeOne;
	private final MapNode<? extends Number> mapNodeTwo;
	private final double pathDistance; //Distance may not equal cost
	/**
	 * The arguments for a Path Instance must pass the following sanity checks:
	 * to != from
	 * 
	 * @param to a MapNode to be included in the Path
	 * @param from a MapNode to be included in the Path
	 */
	public Path(MapNode<? extends Number> to, MapNode<? extends Number> from)
	{
		//TODO Sanity checks
		mapNodeOne = to;
		mapNodeTwo = from;
		pathDistance = MapNode.getDistance(to, from);
	}
	public <M extends MapNode<? extends Number>> boolean hasMapNode(M node)
	{
		return (mapNodeOne == node || mapNodeTwo == node);
	}
	public Pair<MapNode<? extends Number>,MapNode<? extends Number>> getNodes()
	{
		return new Pair<MapNode<? extends Number>,MapNode<? extends Number>>(mapNodeOne,mapNodeTwo);
	}
	public double getPathDistance()
	{
		return pathDistance;
	}
}
