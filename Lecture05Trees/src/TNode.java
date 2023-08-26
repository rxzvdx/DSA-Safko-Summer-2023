public class TNode
{
	// atrributes
	protected int data;
	protected TNode left;
	protected TNode right;
	
	public TNode()
	{
		data = 0;
		left = null;
		right = null;
	}
	
	public TNode(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
	
	public TNode(int data, TNode left, TNode right)
	{
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public int getData() 
	{
		return data;
	}

	public void setData(int data) 
	{
		this.data = data;
	}

	public TNode getLeft() 
	{
		return left;
	}

	public void setLeft(TNode left) 
	{
		this.left = left;
	}

	public TNode getRight() 
	{
		return right;
	}

	public void setRight(TNode right) 
	{
		this.right = right;
	}

	@Override
	public String toString() 
	{
		return "Data = " + data;
	}
}
