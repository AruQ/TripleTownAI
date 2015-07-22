package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager
{
	private final Matrix matrix = new Matrix();
	private boolean gameOver = false;
	private Item nextItem;

	public GameManager()
	{
		// iniziaizeMatrix();
		this.matrix.readMatrixFromFile("./matrix.txt");
		generateNextItem();
	}

	private void update(Cell lastAdded)
	{
		if (!lastAdded.getType().equals(Item.BEAR.getName())
				&& !lastAdded.getType().equals(Item.ROCK.getName())
				&& !lastAdded.getType().equals(Item.TRIPLE_CASTLE.getName()))
		{
			List<Cell> update = WorldJDLV.update(this.matrix, lastAdded);
			if (update.size() >= 3)
			{
				for (Cell cell : update)
				{
					this.matrix.setItemToMatrix(cell.getX(), cell.getY(), Item.EMPTY);
				}
				lastAdded.setType(ItemManager.getInstance().getDescendant(lastAdded.getType())
						.getName());
				this.matrix.setItemToMatrix(lastAdded.getX(), lastAdded.getY(), ItemManager
						.getInstance().getItemFromName(lastAdded.getType()));
				update(lastAdded);
			}
		}
		if (this.matrix.isFull())
			this.gameOver = true;
	}

	private void moveBears()
	{
		List<Cell> tombstones = new ArrayList<Cell>();
		List<BearMovement> calculateNewPositionBears = WorldJDLV.calculateNewPositionBears(
				this.matrix, tombstones);
		for (BearMovement bearMovement : calculateNewPositionBears)
		{
			this.matrix.setItemToMatrix(bearMovement.getOldX(), bearMovement.getOldY(), Item.EMPTY);
		}
		for (BearMovement bearMovement : calculateNewPositionBears)
		{
			this.matrix.setItemToMatrix(bearMovement.getNewX(), bearMovement.getNewY(), Item.BEAR);
		}
		for (Cell cell : tombstones)
		{
			this.matrix.setItemToMatrix(cell.getX(), cell.getY(), Item.TOMBSTONE);
		}
		for (Cell cell : tombstones)
		{
			if (this.matrix.getItemFromPosition(cell.getX(), cell.getY()) == Item.TOMBSTONE)
				update(cell);
		}

	}

	private void generateNextItem()
	{
		// int prob = 42;
		int prob = new Random().nextInt(87) + 1;
		if ((prob >= 1) && (prob <= 2))
			this.nextItem = Item.HUT;
		else if ((prob >= 3) && (prob <= 6))
			this.nextItem = Item.TREE;
		else if ((prob >= 7) && (prob <= 11))
			this.nextItem = Item.CRISTAL;
		else if ((prob >= 12) && (prob <= 27))
			this.nextItem = Item.BUSH;
		else if ((prob >= 28) && (prob <= 87))
			this.nextItem = Item.GRASS;

		// int prob = new Random().nextInt(100) + 1;
		// if (prob <= 30)
		// this.nextItem = Item.FLOATING_CASTLE;
		// else if ((prob >= 31) && (prob <= 100))
		// this.nextItem = Item.FLOATING_CASTLE;

	}

	private void iniziaizeMatrix()
	{

		for (int i = 0; i < 10; i++)
		{
			int xTemp = new Random().nextInt(this.matrix.getDimension());
			int yTemp = new Random().nextInt(this.matrix.getDimension());
			while (this.matrix.getItemFromPosition(xTemp, yTemp) != Item.EMPTY)
			{
				xTemp = new Random().nextInt(this.matrix.getDimension());
				yTemp = new Random().nextInt(this.matrix.getDimension());
			}
			generateNextItem();
			this.matrix.setItemToMatrix(xTemp, yTemp, this.nextItem);
			if (this.nextItem == Item.BEAR)
			{
				Cell bear = new Cell(xTemp, yTemp, this.nextItem.getName());
				List<Cell> bearAvaibleMovements = WorldJDLV.bearAvaibleMovements(this.matrix, bear);
				this.matrix.setItemToMatrix(bear.getX(), bear.getY(), Item.EMPTY);
				if (bearAvaibleMovements.isEmpty())
				{
					this.matrix.setItemToMatrix(bear.getX(), bear.getY(), Item.TOMBSTONE);
				}
				else
				{
					this.matrix.setItemToMatrix(bear.getX(), bear.getY(), Item.BEAR);
				}
			}
		}
		generateNextItem();
	}

	public void setNextItem(Item nextItem)
	{
		this.nextItem = nextItem;
	}

	public Item getNextItem()
	{
		return this.nextItem;
	}

	public Matrix getMatrix()
	{
		return this.matrix;
	}

	public boolean placeNextItem(int x, int y)
	{
		if (this.matrix.getItemFromPosition(x, y) == Item.EMPTY)
		{
			this.matrix.setItemToMatrix(x, y, this.nextItem);
			update(new Cell(x, y, this.nextItem.getName()));
			moveBears();
			generateNextItem();
			return true;
		}
		else
		{
			return false;
		}

	}

	public void print()
	{
		this.matrix.print();
	}

	public boolean isGameOver()
	{
		return this.gameOver;
	}
}
