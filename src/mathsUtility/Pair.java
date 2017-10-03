package mathsUtility;

public class Pair<L,R> 
{
	private L first;
	private R second;
	public Pair(L one, R two)
	{
		first = one;
		second = two;
	}
	public boolean has(Object o)
	{
		return(first.equals(o) || second.equals(o));
	}
	public L getFirst()
	{
		return first;
	}
	public R getSecond()
	{
		return second;
	}
}
