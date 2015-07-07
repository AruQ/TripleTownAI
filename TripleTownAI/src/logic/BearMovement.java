package logic;

public class BearMovement
{
	private int oldX;
	private int oldY;
	private int newX;
	private int newY;

	public BearMovement()
	{
	}
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
		return oldX;
	}

	public void setOldX(int oldX)
	{
		this.oldX = oldX;
	}

	public int getOldY()
	{
		return oldY;
	}

	public void setOldY(int oldY)
	{
		this.oldY = oldY;
	}

	public int getNewX()
	{
		return newX;
	}

	public void setNewX(int newX)
	{
		this.newX = newX;
	}

	public int getNewY()
	{
		return newY;
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
		result = (prime * result) + newX;
		result = (prime * result) + newY;
		result = (prime * result) + oldX;
		result = (prime * result) + oldY;
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
		if (newX != other.newX)
			return false;
		if (newY != other.newY)
			return false;
		if (oldX != other.oldX)
			return false;
		if (oldY != other.oldY)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "BearMovement [oldX=" + oldX + ", oldY=" + oldY + ", newX=" + newX + ", newY="
				+ newY + "]";
	}

}
