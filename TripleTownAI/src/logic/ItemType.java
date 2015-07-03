package logic;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;


public enum ItemType
{
	EMPTY("Empty", 0), GRASS("Grass", 10), BUSH("Bush", 20), TREE("Tree", 30), HUT("Hut", 40), HOUSE(
			"House", 50), MANSION(
			"Mansion", 60), CASTLE("Castle", 70), FLOATING_CASTLE("Floating castle", 80), TRIPLE_CASTLE(
					"Triple castle", 90);
	private String name;
	private int score;
	private static HashMap<String, String> hierarchy = null;

	private ItemType(String name, int score)
	{
		this.name = name;
		this.score = score;
	}

	public String getName()
	{
		return name;
	}

	public int getScore()
	{
		return score;
	}

	static public HashMap<String, String> getHierarchy()
	{
		if (hierarchy != null)
		{
			return hierarchy;

		}
		hierarchy = new HashMap<>();

		Properties properties = null;
		FileInputStream fileInput = null;
		try
		{
			fileInput = new FileInputStream(new File("./Properties/Buildings.properties"));
			properties = new Properties();
			properties.load(fileInput);

		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{

			try
			{
				fileInput.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		Set<Object> keySet = properties.keySet();
		for (Object object : keySet)
		{
			hierarchy.put((String) object, (String) properties.get(object));
		}
		return hierarchy;
	}





}

