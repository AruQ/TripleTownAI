import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager
{
	private Matrix matrix = new Matrix();
	private boolean gameOver = false;
	private Item nextItem;
	private List<Cell> bearsPosition = new ArrayList<Cell>();

	public GameManager()
	{
		iniziaizeMatrix();
	}

	private void update(Cell lastAdded)
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
		if (this.matrix.isFull())
			this.gameOver = true;
		else
		{
			moveBears();
			generateNextItem();
		}
	}

	private void moveBears()
	{
		ArrayList<Cell> movedBears = new ArrayList<>();
		for (int i = 0; i < this.bearsPosition.size(); i++)
		{
			Cell bear = this.bearsPosition.get(i);
			if (movedBears.contains(bear))
				continue;
			List<Cell> bearAvaibleMovements = WorldJDLV.bearAvaibleMovements(this.matrix, bear);
			if (bearAvaibleMovements.isEmpty())
			{
				List<Cell> bearNeighbour = WorldJDLV.update(this.matrix, bear);
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
		this.matrix.setItemToMatrix(bear.getX(), bear.getY(), Item.EMPTY);
		int indexPosition = new Random().nextInt(bearAvaibleMovements.size());
		this.matrix.setItemToMatrix(bearAvaibleMovements.get(indexPosition).getX(),
				bearAvaibleMovements.get(indexPosition).getY(), Item.BEAR);
	}

	private void movableNeighbours(List<Cell> bearNeighbour, ArrayList<Cell> movedBears, Cell bear)
	{
		boolean canMove = false;
		for (Cell cell : bearNeighbour)
		{
			if (cell == bear)
				continue;
			List<Cell> bearAvaibleMovements = WorldJDLV.bearAvaibleMovements(this.matrix, cell);
			if (!bearAvaibleMovements.isEmpty())
			{
				canMove = true;
				moveBearToRandomDirection(cell, bearAvaibleMovements);
				movedBears.add(cell);
			}
		}
		if (!canMove)
		{
			for (Cell cell : bearNeighbour)
			{
				transformBearToTombstone(cell);
			}
		}
		update(bearNeighbour.get(bearNeighbour.size() - 1));
	}

	private void transformBearToTombstone(Cell cell)
	{
		this.matrix.setItemToMatrix(cell.getX(), cell.getY(), Item.TOMBSTONE);
		cell.setType(Item.TOMBSTONE.getName());
		this.bearsPosition.remove(cell);
	}

	private void generateNextItem()
	{
		int prob = new Random().nextInt(100) + 1;
		if ((prob >= 1) && (prob <= 2))
			this.nextItem = Item.HUT;
		else if ((prob >= 3) && (prob <= 6))
			this.nextItem = Item.TREE;
		else if ((prob >= 7) && (prob <= 24))
			this.nextItem = Item.BEAR;
		else if ((prob >= 25) && (prob <= 40))
			this.nextItem = Item.BUSH;
		else if ((prob >= 41) && (prob <= 100))
			this.nextItem = Item.GRASS;

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
					this.bearsPosition.add(bear);
					this.matrix.setItemToMatrix(bear.getX(), bear.getY(), Item.BEAR);
				}
			}
		}
		generateNextItem();
	}

	public Item getNextItem()
	{
		return this.nextItem;
	}

	public boolean placeNextItem(int x, int y)
	{
		if (this.matrix.getItemFromPosition(x, y) == Item.EMPTY)
		{
			this.matrix.setItemToMatrix(x, y, this.nextItem);
			if (this.nextItem == Item.BEAR)
			{
				this.bearsPosition.add(new Cell(x, y, this.nextItem.getName()));
			}
			update(new Cell(x, y, this.nextItem.getName()));
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
