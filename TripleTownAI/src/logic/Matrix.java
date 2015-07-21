package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Matrix
{
	private int emptyCell = 0;
	public static final int DIMENSION = 6;
	private final Item[][] matrix = new Item[this.DIMENSION][this.DIMENSION];
	private int score = 0;

	public Matrix()
	{
		for (int i = 0; i < this.matrix.length; i++)
		{
			for (int j = 0; j < this.matrix[i].length; j++)
			{
				setItemToMatrix(j, i, Item.EMPTY);
			}
		}
	}

	public Integer getScore()
	{
		return this.score;
	}

	public void print()
	{
		for (int i = 0; i < this.matrix.length; i++)
		{
			for (int j = 0; j < this.matrix[i].length; j++)
			{
				if (this.matrix[i][j] == Item.EMPTY)
					System.out.print("|     |" + "  ");
				else
					System.out.print("|" + this.matrix[i][j].getName() + "|" + "  ");
			}
			System.out.println();
		}
	}

	public void readMatrixFromFile(String path)
	{
		String line;
		int i = 0;
		BufferedReader buffer = null;
		try
		{
			buffer = new BufferedReader(new FileReader(new File(path)));
			while ((line = buffer.readLine()) != null)
			{
				String[] vals = line.trim().split("\\s+");
				for (int j = 0; j < this.DIMENSION; j++)
				{
					this.matrix[i][j] = ItemManager.getInstance().getItemFromID(
							Integer.parseInt(vals[j]));
				}
				i++;
			}
		} catch (NumberFormatException | IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				buffer.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

	}

	public int getDimension()
	{
		return this.DIMENSION;
	}

	public List<Cell> toCells()
	{
		List<Cell> cells = new ArrayList<>();
		for (int i = 0; i < this.matrix.length; i++)
		{
			for (int j = 0; j < this.matrix[i].length; j++)
			{
				cells.add(new Cell(j, i, this.matrix[i][j].getName()));
			}
		}
		return cells;
	}

	public boolean isFull()
	{
		return this.emptyCell == 0;
	}

	public void setItemToMatrix(int x, int y, Item itemType)
	{
		if (itemType == Item.EMPTY)
		{
			this.emptyCell++;
		}
		else
		{
			this.emptyCell--;
		}
		this.score += itemType.getScore() * 100;
		this.matrix[y][x] = itemType;
	}

	public Item getItemFromPosition(int x, int y)
	{
		return this.matrix[y][x];
	}

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		GameManager gameManager = new GameManager();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		gameManager.print();
		while (!gameManager.isGameOver())
		{
			boolean placeNextItem = false;
			do
			{
				System.out.println("Dove vuoi posizionare " + gameManager.getNextItem().getName()
						+ "?");
				System.out.println("I=");
				int x = Integer.parseInt(input.readLine());

				System.out.println("J=");
				input = new BufferedReader(new InputStreamReader(System.in));
				int y = Integer.parseInt(input.readLine());
				placeNextItem = gameManager.placeNextItem(y, x);
			} while (!placeNextItem);
			gameManager.print();
		}
	}

	public List<Cell> getMaxElement()
	{
		int max = 0;
		List<Cell> maxItemCells = new ArrayList<>();
		for (int i = 0; i < DIMENSION; i++)
			for (int j = 0; j < DIMENSION; j++)
			{
				Item item = this.matrix[i][j];
				if (item.getScore() >= max)
				{
					if (item.getScore() > max)
						maxItemCells.clear();
					Cell maxItemCell = new Cell();
					max = item.getScore();
					maxItemCell.setX(j);
					maxItemCell.setY(i);
					maxItemCell.setType(item.getName());
					maxItemCells.add(maxItemCell);
				}
			}
		if (maxItemCells.isEmpty())
			throw new RuntimeException("No maxItem");
		return maxItemCells;
	}
}
