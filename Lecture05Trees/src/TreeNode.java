
public class TreeNode<T> 
{
	// attributes
	protected T data;
	protected TreeNode<T> left;
	protected TreeNode<T> right;

	public TreeNode() 
	{
		data = null;
		left = null;
		right = null;
	}

	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) 
	{
		this.data = data;
		this.left = left;
		this.right = right;
	}

	// accessors:
	public T getData() 
	{
		return data;
	}

	public TreeNode<T> getLeft() 
	{
		return left;
	}

	// mutators:
	public TreeNode<T> getRight() 
	{
		return right;
	}

	public void setData(T data) 
	{
		this.data = data;
	}

	public void setLeft(TreeNode<T> left) 
	{
		this.left = left;
	}

	public void setRight(TreeNode<T> right) 
	{
		this.right = right;
	}

	@Override
	public String toString() 
	{
		return "TreeNode [data = " + data + ", left = " + left + ", right = " + right + "]";
	}
}
