package logic;

public class Item
{
	public final static Item CRISTAL = new Item("Cristal", "Cristal", 10);
	public final static Item ROCK = new Item("Rock", "Rock", 0);
	public final static Item EMPTY = new Item("Empty", "Empty", 0);
	public final static Item TRIPLE_CASTLE = new Item("Triple castle", "Triple castle", 9);
	public final static Item FLOATING_CASTLE = new Item("Floating castle", "Triple castle", 8);
	public final static Item CASTLE = new Item("Castle", "Floating castle", 7);
	public final static Item MANSION = new Item("Mansion", "Castle", 6);
	public final static Item HOUSE = new Item("House", "Mansion", 5);
	public final static Item HUT = new Item("Hut", "House", 4);
	public final static Item TREE = new Item("Tree", "Hut", 3);
	public final static Item BUSH = new Item("Bush", "Tree", 2);
	public final static Item GRASS = new Item("Grass", "Bush", 1);

	public final static Item BEAR = new Item("Bear", "Tombstone", 1);
	public final static Item TOMBSTONE = new Item("Tombstone", "Church", 2);
	public final static Item CHURCH = new Item("Church", "Cathedral", 3);
	public final static Item CATHEDRAL = new Item("Cathedral", "Cathedral", 4);

	private String name;
	private String descendant;
	private int score;

	public Item(String name, String descendant, int score)
	{
		this.descendant = descendant;
		this.name = name;
		this.score = score;
	}

	public String getDescendant()
	{
		return this.descendant;
	}

	public void setDescendant(String descendant)
	{
		this.descendant = descendant;
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
