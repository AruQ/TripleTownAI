public class Cell
{
	private int x;
	private int y;
	private String type;

	public Cell()
	{
	}

	public Cell(int x, int y, String type)
	{
		super();
		this.x = x;
		this.y = y;
		this.type = type;
	}

	public int getX()
	{
		return this.x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return this.y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public String getType()
	{
		return this.type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.type == null) ? 0 : this.type.hashCode());
		result = (prime * result) + this.x;
		result = (prime * result) + this.y;
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
		Cell other = (Cell) obj;
		if (this.type == null)
		{
			if (other.type != null)
				return false;
		}
		else if (!this.type.equals(other.type))
			return false;
		if (this.x != other.x)
			return false;
		if (this.y != other.y)
			return false;
		return true;
	}

}
