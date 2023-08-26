//
//public class TreeInt 
//{
//	protected TreeNodeInt root = new TreeNodeInt();
//	
//	public TreeInt()
//	{
//		root.data = 0;
//		root.left = null;
//		root.right = null;
//	}
//	
//	public TreeInt(int data)
//	{
//		root.data = data;
//		// or this: root.setData(data);
//		root.left = null;
//		root.right = null;
//	}
//	
//	public TreeInt(int data, TreeNodeInt left, TreeNodeInt right) 
//	{
//		root.data = data;
//		root.left = left;
//		root.right = right;
//	}
//	
//	/*
//	 * DESTROY TREE
//	 */
//	public void upRoot() 
//	{
//		root = null;
//	}
//	
//	public boolean isEmpty() 
//	{
//		return (root == null);
//	}
//	
//	public void add(int element) 
//	{
//		root = addRecursive(root, element);
//	}
//	
//	private TreeNodeInt addRecursive(TreeNodeInt current, int data) 
//	{
//		// if nothing exists, becomes top/root
//		if(current == null) 
//		{
//			return new TreeNodeInt(data);
//		}
//		
//		// if curr < root, goes to left
//		if(data < current.data) 
//		{
//			current.left = addRecursive(current.left, data);
//		}
//		
//		// if curr > root, goes to right
//		else if(data > current.data) 
//		{
//			current.right = addRecursive(current.right, data);
//		}
//		
//		// data already exists
//		else 
//		{
//			return current;
//		}
//		
//		// will never get here
//		return current;
//	}
//	
//	public TreeNodeInt add(int element, TreeNodeInt t)
//	{
//		if(t == null) 
//		{
//			return new TreeNodeInt(element);
//		}
//		// INCOMPLETE
//		return null;
//	}
//	
//	public void preOrderTraversal() 
//	{
//		preOrderTraversalRecursive(root);
//	}
//	
//	private void preOrderTraversalRecursive(TreeNodeInt node) 
//	{
//		if(node != null) 
//		{
//			System.out.print(" - " + node.data);
//			preOrderTraversalRecursive(node.left);
//			preOrderTraversalRecursive(node.right);
//		}
//	}
//
//	/*
//	 * METHODS TO MAKE
//	 * contains()
//	 * findMin()
//	 * findMax()
//	 * getHeight()
//	 * preOrder() 	TRAVERSAL
//	 * postOrder() 	TRAVERSAL
//	 * inOrder()	TRAVERSAL
//	 */
//	
//	
//}
