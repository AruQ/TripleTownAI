package logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Matrix
{
	private final int DIMENSION = 6;
	private final ItemType[][] matrix = new ItemType[DIMENSION][DIMENSION];

	public Matrix()
	{
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				matrix[i][j] = ItemType.EMPTY;
			}
		}
		for (int i = 0; i < 30; i++)
		{
			int xTemp = new Random().nextInt(DIMENSION);
			int yTemp = new Random().nextInt(DIMENSION);
			matrix[yTemp][xTemp] = ItemType.GRASS;
		}
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				if (matrix[i][j] == ItemType.EMPTY)
					System.out.print("|     |" + "  ");
				else
					System.out.print("|" + matrix[i][j].getName() + "|" + "  ");
			}
			System.out.println();
		}
	}
	public ItemType[][] getMatrix()
	{
		return matrix;
	}

	public List<logic.Cell> findAdjacentElements(Cell currentCell)
	{
		List<logic.Cell> adjacents = new ArrayList<>();
		if (currentCell.getX() > 0
				&& matrix[currentCell.getY()][currentCell.getX() - 1].getName().equals(currentCell.getType()))
		{
			adjacents.add(new Cell(currentCell.getX() - 1, currentCell.getY(), currentCell.getType()));
		}
		if (currentCell.getY() > 0
				&& matrix[currentCell.getY() - 1][currentCell.getX()].getName().equals(currentCell.getType()))
		{
			adjacents.add(new Cell(currentCell.getX(), currentCell.getY() - 1, currentCell.getType()));
		}
		if (currentCell.getY() < DIMENSION - 1
				&& matrix[currentCell.getY() + 1][currentCell.getX()].getName().equals(currentCell.getType()))
		{
			adjacents.add(new Cell(currentCell.getX(), currentCell.getY() + 1, currentCell.getType()));
		}
		if (currentCell.getX() < DIMENSION - 1
				&& matrix[currentCell.getY()][currentCell.getX() + 1].getName().equals(currentCell.getType()))
		{
			adjacents.add(new Cell(currentCell.getX() + 1, currentCell.getY(), currentCell.getType()));
		}
		return adjacents;
	}

	public void update (Cell lastAdded)
	{
		List<Cell> adjacentElements = findAdjacentElements(lastAdded);
		HashSet<Cell> toReturn = new HashSet<>();
		while (adjacentElements.size()>0)
		{
			Cell removed = adjacentElements.remove(0);
			if (!present(removed, toReturn))
			{
				adjacentElements.addAll(findAdjacentElements(removed));
				toReturn.add(removed);
			}
		}
	}

	public boolean present(Cell currentCell, HashSet<Cell> cells)
	{
		for (Cell cell : cells)
		{
			if (cell.equals(currentCell))
				return true;
		}
		return false;
	}

	public List<logic.Cell> toCells()
	{
		List<logic.Cell> cells = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				cells.add(new logic.Cell(j, i, matrix[i][j].getName()));
			}
		}
		return cells;
	}

	public static void main(String[] args)
	{
		World world = new World();
		// world.matrix.update(new Cell(0, 0, "Grass"));
		List<Cell> update = world.update(new Cell(0, 0, "Grass"));
		System.out.println(update);
	}

}
