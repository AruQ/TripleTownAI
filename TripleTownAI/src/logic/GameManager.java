package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager
{
	private Matrix matrix = new Matrix();
	private boolean gameOver = false;
	private Item nextItem;

	public GameManager()
	{
		iniziaizeMatrix();
		// matrix.readMatrixFromFile("./matrix.txt");
		generateNextItem();
	}

	private void update(Cell lastAdded)
	{
		if (!lastAdded.getType().equals(Item.BEAR.getName())
				&& !lastAdded.getType().equals(Item.CHEST.getName())
				&& !lastAdded.getType().equals(Item.TRIPLE_CASTLE.getName()))
		{
			List<Cell> update = WorldJDLV.update(matrix, lastAdded);
			if (update.size() >= 3)
			{
				for (Cell cell : update)
				{
					matrix.setItemToMatrix(cell.getX(), cell.getY(), Item.EMPTY);
				}
				lastAdded.setType(ItemManager.getInstance().getDescendant(lastAdded.getType())
						.getName());
				matrix.setItemToMatrix(lastAdded.getX(), lastAdded.getY(), ItemManager
						.getInstance().getItemFromName(lastAdded.getType()));
				update(lastAdded);
			}
		}
		if (matrix.isFull())
			gameOver = true;
	}

	private void moveBears()
	{
		List<Cell> tombstones = new ArrayList<Cell>();
		List<BearMovement> calculateNewPositionBears = WorldJDLV.calculateNewPositionBears(
				matrix, tombstones);
		for (BearMovement bearMovement : calculateNewPositionBears)
		{
			matrix.setItemToMatrix(bearMovement.getOldX(), bearMovement.getOldY(), Item.EMPTY);
		}
		for (BearMovement bearMovement : calculateNewPositionBears)
		{
			matrix.setItemToMatrix(bearMovement.getNewX(), bearMovement.getNewY(), Item.BEAR);
		}
		for (Cell cell : tombstones)
		{
			matrix.setItemToMatrix(cell.getX(), cell.getY(), Item.TOMBSTONE);
		}
		for (Cell cell : tombstones)
		{
			if (matrix.getItemFromPosition(cell.getX(), cell.getY()) == Item.TOMBSTONE)
				update(cell);
		}

	}

	private void generateNextItem()
	{
		int prob = new Random().nextInt(87) + 1;
		if ((prob >= 1) && (prob <= 2))
			nextItem = Item.HUT;
		else if ((prob >= 3) && (prob <= 6))
			nextItem = Item.TREE;
		else if ((prob >= 7) && (prob <= 11))
			nextItem = Item.CRISTAL;
		else if ((prob >= 12) && (prob <= 27))
			nextItem = Item.BUSH;
		else if ((prob >= 28) && (prob <= 87))
			nextItem = Item.GRASS;

		// else if ((prob >= 88) && (prob <= 94))
		// nextItem = Item.BEAR;


	}

	private void iniziaizeMatrix()
	{

		for (int i = 0; i < 10; i++)
		{
			int xTemp = new Random().nextInt(matrix.getDimension());
			int yTemp = new Random().nextInt(matrix.getDimension());
			while (matrix.getItemFromPosition(xTemp, yTemp) != Item.EMPTY)
			{
				xTemp = new Random().nextInt(matrix.getDimension());
				yTemp = new Random().nextInt(matrix.getDimension());
			}
			generateNextItem();
			if (nextItem == Item.CRISTAL)
				nextItem = Item.ROCK;
			matrix.setItemToMatrix(xTemp, yTemp, nextItem);
			if (nextItem == Item.BEAR)
			{
				Cell bear = new Cell(xTemp, yTemp, nextItem.getName());
				List<Cell> bearAvaibleMovements = WorldJDLV.bearAvaibleMovements(matrix, bear);
				matrix.setItemToMatrix(bear.getX(), bear.getY(), Item.EMPTY);
				if (bearAvaibleMovements.isEmpty())
				{
					matrix.setItemToMatrix(bear.getX(), bear.getY(), Item.TOMBSTONE);
				}
				else
				{
					matrix.setItemToMatrix(bear.getX(), bear.getY(), Item.BEAR);
				}
			}
		}
		matrix.setScore(0);
		generateNextItem();
	}

	public void setNextItem(Item nextItem)
	{
		this.nextItem = nextItem;
	}

	public Item getNextItem()
	{
		return nextItem;
	}

	public Matrix getMatrix()
	{
		return matrix;
	}

	public boolean placeNextItem(int x, int y)
	{
		if (matrix.getItemFromPosition(x, y) == Item.EMPTY)
		{
			matrix.setItemToMatrix(x, y, nextItem);
			update(new Cell(x, y, nextItem.getName()));
			moveBears();
			generateNextItem();
			return true;
		}
		else
		{
			return false;
		}

	}

	public void reset()
	{
		matrix = new Matrix();
		gameOver = false;
		iniziaizeMatrix();

	}
	public void print()
	{
		matrix.print();
	}

	public boolean isGameOver()
	{
		return gameOver;
	}
}
