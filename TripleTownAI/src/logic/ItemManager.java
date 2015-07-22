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
		descendants = new HashMap<>();
		itemNames = new HashMap<>();
		items = new ArrayList<>();
		IDItems = new HashMap<>();
		createItemNames();
		createItems();
		createHierarchy();
		createIDItems();
	}

	private void createIDItems()
	{
		IDItems.put(0, Item.EMPTY);
		IDItems.put(1, Item.GRASS);
		IDItems.put(2, Item.BUSH);
		IDItems.put(3, Item.TREE);
		IDItems.put(4, Item.HUT);
		IDItems.put(5, Item.HOUSE);
		IDItems.put(6, Item.MANSION);
		IDItems.put(7, Item.CASTLE);
		IDItems.put(8, Item.FLOATING_CASTLE);
		IDItems.put(9, Item.TRIPLE_CASTLE);
		IDItems.put(10, Item.CRISTAL);

		IDItems.put(11, Item.BEAR);
		IDItems.put(12, Item.CHURCH);
		IDItems.put(13, Item.CATHEDRAL);
		IDItems.put(14, Item.TOMBSTONE);
		IDItems.put(15, Item.ROCK);
		IDItems.put(16, Item.MOUNTAIN);
		IDItems.put(17, Item.CHEST);

	}

	private void createItemNames()
	{
		itemNames.put(Item.EMPTY.getName(), Item.EMPTY);
		itemNames.put(Item.GRASS.getName(), Item.GRASS);
		itemNames.put(Item.BUSH.getName(), Item.BUSH);
		itemNames.put(Item.TREE.getName(), Item.TREE);
		itemNames.put(Item.HUT.getName(), Item.HUT);
		itemNames.put(Item.HOUSE.getName(), Item.HOUSE);
		itemNames.put(Item.MANSION.getName(), Item.MANSION);
		itemNames.put(Item.CASTLE.getName(), Item.CASTLE);
		itemNames.put(Item.FLOATING_CASTLE.getName(), Item.FLOATING_CASTLE);
		itemNames.put(Item.TRIPLE_CASTLE.getName(), Item.TRIPLE_CASTLE);
		itemNames.put(Item.CRISTAL.getName(), Item.CRISTAL);

		itemNames.put(Item.BEAR.getName(), Item.BEAR);
		itemNames.put(Item.CHURCH.getName(), Item.CHURCH);
		itemNames.put(Item.CATHEDRAL.getName(), Item.CATHEDRAL);
		itemNames.put(Item.TOMBSTONE.getName(), Item.TOMBSTONE);

		itemNames.put(Item.ROCK.getName(), Item.ROCK);
		itemNames.put(Item.MOUNTAIN.getName(), Item.MOUNTAIN);
		itemNames.put(Item.CHEST.getName(), Item.CHEST);

	}

	private void createItems()
	{
		items.add(Item.EMPTY);
		items.add(Item.GRASS);
		items.add(Item.BUSH);
		items.add(Item.TREE);
		items.add(Item.HUT);
		items.add(Item.HOUSE);
		items.add(Item.MANSION);
		items.add(Item.CASTLE);
		items.add(Item.FLOATING_CASTLE);
		items.add(Item.TRIPLE_CASTLE);
		items.add(Item.CRISTAL);

		items.add(Item.BEAR);
		items.add(Item.CATHEDRAL);
		items.add(Item.CHURCH);
		items.add(Item.TOMBSTONE);

		items.add(Item.ROCK);
		items.add(Item.MOUNTAIN);
		items.add(Item.CHEST);
	}

	private void createHierarchy()
	{
		// FIXME risolvere problema triplecastle --> empty
		descendants.put(Item.EMPTY, Item.EMPTY);
		descendants.put(Item.GRASS, Item.BUSH);
		descendants.put(Item.BUSH, Item.TREE);
		descendants.put(Item.TREE, Item.HUT);
		descendants.put(Item.HUT, Item.HOUSE);
		descendants.put(Item.HOUSE, Item.MANSION);
		descendants.put(Item.MANSION, Item.CASTLE);
		descendants.put(Item.CASTLE, Item.FLOATING_CASTLE);
		descendants.put(Item.FLOATING_CASTLE, Item.TRIPLE_CASTLE);
		descendants.put(Item.TRIPLE_CASTLE, Item.TRIPLE_CASTLE);
		descendants.put(Item.CRISTAL, Item.CRISTAL);

		descendants.put(Item.BEAR, Item.TOMBSTONE);
		descendants.put(Item.TOMBSTONE, Item.CHURCH);
		descendants.put(Item.CHURCH, Item.CATHEDRAL);
		descendants.put(Item.CATHEDRAL, Item.EMPTY);

		descendants.put(Item.ROCK, Item.MOUNTAIN);
		descendants.put(Item.MOUNTAIN, Item.CHEST);
		descendants.put(Item.CHEST, Item.CHEST);
	}

	public Item getDescendant(String from)
	{
		return descendants.get(getItemFromName(from));
	}

	public Item getItemFromName(String from)
	{
		return itemNames.get(from);
	}

	public Item getItemFromID(Integer from)
	{
		return IDItems.get(from);
	}

	public List<Item> getItems()
	{
		return items;
	}
}
