package logic;

public class BearMovement
{
	private int oldX;
	private int oldY;
	private int newX;
	private int newY;

	public BearMovement(int oldX, int oldY, int newX, int newY)
	{
		super();
		this.oldX = oldX;
		this.oldY = oldY;
		this.newX = newX;
		this.newY = newY;
	}

	public int getOldX()
	{
		return this.oldX;
	}

	public void setOldX(int oldX)
	{
		this.oldX = oldX;
	}

	public int getOldY()
	{
		return this.oldY;
	}

	public void setOldY(int oldY)
	{
		this.oldY = oldY;
	}

	public int getNewX()
	{
		return this.newX;
	}

	public void setNewX(int newX)
	{
		this.newX = newX;
	}

	public int getNewY()
	{
		return this.newY;
	}

	public void setNewY(int newY)
	{
		this.newY = newY;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = (prime * result) + this.newX;
		result = (prime * result) + this.newY;
		result = (prime * result) + this.oldX;
		result = (prime * result) + this.oldY;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BearMovement other = (BearMovement) obj;
		if (this.newX != other.newX)
			return false;
		if (this.newY != other.newY)
			return false;
		if (this.oldX != other.oldX)
			return false;
		if (this.oldY != other.oldY)
			return false;
		return true;
	}

}
