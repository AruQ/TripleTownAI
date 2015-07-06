package logic;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager
{
	private final Matrix matrix = new Matrix();
	private boolean gameOver = false;
	private Item nextItem;
	private List<Cell> bearsPosition = new ArrayList<Cell>();

	public GameManager()
	{
		// iniziaizeMatrix();
		bearsPosition = matrix.readMatrixFromFile("./matrix.txt");
		nextItem = Item.BEAR;
		// generateNextItem();
	}

	private void update(Cell lastAdded)
	{
		if (!lastAdded.getType().equals(Item.BEAR.getName()))
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
		else
		{
			// moveBears();
		}
	}

	private void moveBears()
	{
		ArrayList<Cell> movedBears = new ArrayList<>();
		for (int i = 0; i < bearsPosition.size(); i++)
		{
			Cell bear = bearsPosition.get(i);
			if (movedBears.contains(bear))
				continue;
			List<Cell> bearAvaibleMovements = WorldJDLV.bearAvaibleMovements(matrix, bear);
			if (bearAvaibleMovements.isEmpty())
			{
				List<Cell> bearNeighbour = WorldJDLV.update(matrix, bear);
				if (bearNeighbour.size() > 1)
				{
					movableNeighbours(bearNeighbour, movedBears, bear);
					i = -1;

				}
				else
				{
					transformBearToTombstone(bear);
					update(bear);
				}
			}
			else
			{
				moveBearToRandomDirection(bear, bearAvaibleMovements);
				movedBears.add(bear);
			}
		}
	}

	private void moveBearToRandomDirection(Cell bear, List<Cell> bearAvaibleMovements)
	{
		matrix.setItemToMatrix(bear.getX(), bear.getY(), Item.EMPTY);
		int indexPosition = new Random().nextInt(bearAvaibleMovements.size());
		bear.setX(bearAvaibleMovements.get(indexPosition).getX());
		bear.setY(bearAvaibleMovements.get(indexPosition).getY());
		matrix.setItemToMatrix(bear.getX(), bear.getY(), Item.BEAR);
	}

	private void movableNeighbours(List<Cell> bearNeighbour, ArrayList<Cell> movedBears, Cell bear)
	{
		boolean canMove = false;
		for (Cell cell : bearNeighbour)
		{
			if (cell.equals(bear))
				continue;
			List<Cell> bearAvaibleMovements = WorldJDLV.bearAvaibleMovements(matrix, cell);
			if (!bearAvaibleMovements.isEmpty())
			{
				canMove = true;
				int indexOfBear = bearsPosition.indexOf(cell);
				Cell currentBear = bearsPosition.get(indexOfBear);
				moveBearToRandomDirection(currentBear, bearAvaibleMovements);
				movedBears.add(currentBear);
			}
		}
		if (!canMove)
		{
			for (Cell cell : bearNeighbour)
			{
				transformBearToTombstone(cell);
			}
			update(bearNeighbour.get(bearNeighbour.size() - 1));
		}
	}

	private void transformBearToTombstone(Cell cell)
	{
		matrix.setItemToMatrix(cell.getX(), cell.getY(), Item.TOMBSTONE);
		bearsPosition.remove(cell);
		cell.setType(Item.TOMBSTONE.getName());
	}

	private void generateNextItem()
	{
		int prob = new Random().nextInt(100) + 1;
		if ((prob >= 1) && (prob <= 2))
			nextItem = Item.HUT;
		else if ((prob >= 3) && (prob <= 6))
			nextItem = Item.TREE;
		else if ((prob >= 7) && (prob <= 24))
			nextItem = Item.BEAR;
		else if ((prob >= 25) && (prob <= 40))
			nextItem = Item.BUSH;
		else if ((prob >= 41) && (prob <= 100))
			nextItem = Item.GRASS;

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
					bearsPosition.add(bear);
					matrix.setItemToMatrix(bear.getX(), bear.getY(), Item.BEAR);
				}
			}
		}
		generateNextItem();
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
			if (nextItem == Item.BEAR)
			{
				bearsPosition.add(new Cell(x, y, nextItem.getName()));
			}
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

	public void print()
	{
		matrix.print();
	}

	public boolean isGameOver()
	{
		return gameOver;
	}
}
