public class Item
{
	public final static Item EMPTY = new Item("Empty", 0);
	public final static Item TRIPLE_CASTLE = new Item("Triple castle", 90);
	public final static Item FLOATING_CASTLE = new Item("Floating castle", 80);
	public final static Item CASTLE = new Item("Castle", 70);
	public final static Item MANSION = new Item("Mansion", 60);
	public final static Item HOUSE = new Item("House", 50);
	public final static Item HUT = new Item("Hut", 40);
	public final static Item TREE = new Item("Tree", 30);
	public final static Item BUSH = new Item("Bush", 20);
	public final static Item GRASS = new Item("Grass", 10);

	public final static Item BEAR = new Item("Bear", 10);
	public final static Item TOMBSTONE = new Item("Tombstone", 20);
	public final static Item CHURCH = new Item("Church", 30);
	public final static Item CATHEDRAL = new Item("Cathedral", 40);

	private String name;
	private int score;

	public Item(String name, int score)
	{
		this.name = name;
		this.score = score;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getScore()
	{
		return this.score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.name == null) ? 0 : this.name.hashCode());
		result = (prime * result) + this.score;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (this.name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!this.name.equals(other.name))
			return false;
		if (this.score != other.score)
			return false;
		return true;
	}

}
