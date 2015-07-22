package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemManager
{

	private final List<Item> items;
	private final HashMap<Item, Item> descendants;
	private final HashMap<String, Item> itemNames;
	private final HashMap<Integer, Item> IDItems;
	private static ItemManager instance = null;

	public static ItemManager getInstance()
	{
		if (instance == null)
			instance = new ItemManager();
		return instance;
	}

	private ItemManager()
	{
		this.descendants = new HashMap<>();
		this.itemNames = new HashMap<>();
		this.items = new ArrayList<>();
		this.IDItems = new HashMap<>();
		createItemNames();
		createItems();
		createHierarchy();
		createIDItems();
	}

	private void createIDItems()
	{
		this.IDItems.put(0, Item.EMPTY);
		this.IDItems.put(1, Item.GRASS);
		this.IDItems.put(2, Item.BUSH);
		this.IDItems.put(3, Item.TREE);
		this.IDItems.put(4, Item.HUT);
		this.IDItems.put(5, Item.HOUSE);
		this.IDItems.put(6, Item.MANSION);
		this.IDItems.put(7, Item.CASTLE);
		this.IDItems.put(8, Item.FLOATING_CASTLE);
		this.IDItems.put(9, Item.TRIPLE_CASTLE);
		this.IDItems.put(10, Item.CRISTAL);

		this.IDItems.put(11, Item.BEAR);
		this.IDItems.put(12, Item.CHURCH);
		this.IDItems.put(13, Item.CATHEDRAL);
		this.IDItems.put(14, Item.TOMBSTONE);
		this.IDItems.put(15, Item.ROCK);

	}

	private void createItemNames()
	{
		this.itemNames.put(Item.EMPTY.getName(), Item.EMPTY);
		this.itemNames.put(Item.GRASS.getName(), Item.GRASS);
		this.itemNames.put(Item.BUSH.getName(), Item.BUSH);
		this.itemNames.put(Item.TREE.getName(), Item.TREE);
		this.itemNames.put(Item.HUT.getName(), Item.HUT);
		this.itemNames.put(Item.HOUSE.getName(), Item.HOUSE);
		this.itemNames.put(Item.MANSION.getName(), Item.MANSION);
		this.itemNames.put(Item.CASTLE.getName(), Item.CASTLE);
		this.itemNames.put(Item.FLOATING_CASTLE.getName(), Item.FLOATING_CASTLE);
		this.itemNames.put(Item.TRIPLE_CASTLE.getName(), Item.TRIPLE_CASTLE);
		this.itemNames.put(Item.CRISTAL.getName(), Item.CRISTAL);
		this.itemNames.put(Item.ROCK.getName(), Item.ROCK);

		this.itemNames.put(Item.BEAR.getName(), Item.BEAR);
		this.itemNames.put(Item.CHURCH.getName(), Item.CHURCH);
		this.itemNames.put(Item.CATHEDRAL.getName(), Item.CATHEDRAL);
		this.itemNames.put(Item.TOMBSTONE.getName(), Item.TOMBSTONE);

	}

	private void createItems()
	{
		this.items.add(Item.EMPTY);
		this.items.add(Item.GRASS);
		this.items.add(Item.BUSH);
		this.items.add(Item.TREE);
		this.items.add(Item.HUT);
		this.items.add(Item.HOUSE);
		this.items.add(Item.MANSION);
		this.items.add(Item.CASTLE);
		this.items.add(Item.FLOATING_CASTLE);
		this.items.add(Item.TRIPLE_CASTLE);
		this.items.add(Item.CRISTAL);
		this.items.add(Item.ROCK);

		this.items.add(Item.BEAR);
		this.items.add(Item.CATHEDRAL);
		this.items.add(Item.CHURCH);
		this.items.add(Item.TOMBSTONE);
	}

	private void createHierarchy()
	{
		// FIXME risolvere problema triplecastle --> empty
		this.descendants.put(Item.EMPTY, Item.EMPTY);
		this.descendants.put(Item.GRASS, Item.BUSH);
		this.descendants.put(Item.BUSH, Item.TREE);
		this.descendants.put(Item.TREE, Item.HUT);
		this.descendants.put(Item.HUT, Item.HOUSE);
		this.descendants.put(Item.HOUSE, Item.MANSION);
		this.descendants.put(Item.MANSION, Item.CASTLE);
		this.descendants.put(Item.CASTLE, Item.FLOATING_CASTLE);
		this.descendants.put(Item.FLOATING_CASTLE, Item.TRIPLE_CASTLE);
		this.descendants.put(Item.TRIPLE_CASTLE, Item.TRIPLE_CASTLE);
		this.descendants.put(Item.CRISTAL, Item.CRISTAL);
		this.descendants.put(Item.ROCK, Item.ROCK);

		this.descendants.put(Item.BEAR, Item.TOMBSTONE);
		this.descendants.put(Item.TOMBSTONE, Item.CHURCH);
		this.descendants.put(Item.CHURCH, Item.CATHEDRAL);
		this.descendants.put(Item.CATHEDRAL, Item.EMPTY);
	}

	public Item getDescendant(String from)
	{
		return this.descendants.get(getItemFromName(from));
	}

	public Item getItemFromName(String from)
	{
		return this.itemNames.get(from);
	}

	public Item getItemFromID(Integer from)
	{
		return this.IDItems.get(from);
	}

	public List<Item> getItems()
	{
		return this.items;
	}
}
