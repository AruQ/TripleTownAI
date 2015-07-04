import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemManager
{

	private List<Item> items;
	private HashMap<Item, Item> descendants;
	private HashMap<String, Item> itemNames;
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
		createItemNames();
		createItems();
		createHierarchy();
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
		this.descendants.put(Item.TRIPLE_CASTLE, Item.EMPTY);

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

	public List<Item> getItems()
	{
		return this.items;
	}
}
