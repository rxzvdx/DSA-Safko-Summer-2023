import java.util.LinkedList;
import java.util.Queue; // for printTree()

public class Tree 
{
	/*
	 * METHODS TO MAKE
	 * add()									DONE		Source: class/Gregory Safko
	 * remove(int val)							DONE		Source: geeksforgeeks.org/old DSA lab
	 * find()									DONE		Source: self
	 * contains()								DONE		Source: self
	 * findMin()								DONE		Source: self
	 * findMax()								DONE		Source: self
	 * countNodes()								DONE		Source: old DSA lab
	 * getSum()									DONE		Source: self
	 * findAverage()							DONE		Source: self
	 * getDepth()								DONE		Source: self
	 * getTreeRootedAt(int a)					DONE		Source: self
	 * getHeight()								DONE		Source: self
	 * preOrder() 					TRAVERSAL	DONE		Source: old DSA lab
	 * postOrder() 					TRAVERSAL	DONE		Source: old DSA lab
	 * inOrder()					TRAVERSAL	DONE		Source: old DSA lab
	 * findIfAncestor()							DONE		Source: class/geeksforgeeks.org
	 */
	protected TNode root;

	public Tree()
	{
		/*
		root.data = 0;
		root.left = null;
		root.right = null;	
		 */
		root = null;
	}

	/*
	 * Constructor to create a binary search tree with a single node.
	 *
	 * @param data the data value of the root node.
	 */
	public Tree(int data)
	{
		root.data = data;		
		// or this: root.setData(data);	
		root.left = null;
		root.right = null;
	}

	/**
	 * Constructor to create a binary search tree with a root node
	 * and two subtrees.
	 *
	 * @param data  the data value of the root node.
	 * @param left  the left subtree of the root node.
	 * @param right the right subtree of the root node.
	 */
	public Tree(int data, TNode left, TNode right)
	{
		root.data = data;
		root.left = left;
		root.right = right;		
	}

	/**
	 * Set the root of the tree to null, effectively 
	 * removing all nodes in the tree.
	 */
	public void upRoot()
	{
		root = null;
	}

	/**
	 * Check if the binary search tree is empty.
	 *
	 * @return true if the tree is empty, 
	 * false otherwise.
	 */
	public boolean isEmpty()
	{
		return (root == null);
	}

	/**
	 * Add an element to the binary search tree.
	 *
	 * @param element the element to be added.
	 */
	public void add(int element)
	{
		root = addRecursive(root, element);
	}

	/*
	 * Recursive helper method to add an element to 
	 * the binary search tree.
	 *
	 * @param current the current node being examined.
	 * @param data    the data value of the element to be added.
	 * @return the modified node or a new node if current is null.
	 */
	private TNode addRecursive(TNode current, int data)
	{
		if(current == null)
		{
			return new TNode(data);
		}
		if(data < current.data)
		{
			current.left = addRecursive(current.left, data);
		}
		else if (data > current.data)
		{
			current.right = addRecursive(current.right, data);
		}
		else // data is already on the tree
		{
			return current;
		}

		// should never get here
		return current;
	}

	public TNode add(int element, TNode t)
	{
		if(t == null)
		{
			return new TNode(element, null, null);
		}
		return null;
	}

	/**
	 * Remove an element from the binary search tree.
	 *
	 * @param element the element to be removed.
	 */
	public void remove(int element) 
	{
		root = removeRecursive(root, element);
	}

	/**
	 * Recursive helper method to remove an element from the binary search tree.
	 *
	 * @param current the current node being examined.
	 * @param data    the data value of the element to be removed.
	 * @return the modified node or null if the element was not found.
	 */
	private TNode removeRecursive(TNode current, int data) 
	{
		// empty BST
		if (current == null) 
		{
			return null;
		}

		// if BST contains data...
		if (data == current.data) 
		{
			// if left and right are null
			if (current.left == null && current.right == null) 
			{
				return null;
			} 

			// if left == null
			else if (current.left == null) 
			{
				return current.right;
			} 

			// if right == null
			else if (current.right == null) 
			{
				return current.left;
			} 

			// else, remove recursively
			else 
			{
				int minValue = findMinRecursive(current.right);
				current.data = minValue;
				current.right = removeRecursive(current.right, minValue);
			}
		} 

		else if (data < current.data) 
		{
			current.left = removeRecursive(current.left, data);
		} 

		else 
		{
			current.right = removeRecursive(current.right, data);
		}
		return current;
	}

	/**
	 * Find a node with the given element in the binary search tree.
	 *
	 * @param element the element to be searched for.
	 * @return the node containing the element, or null if not found.
	 */
	public TNode find(int element) 
	{
		return findRecursive(root, element);
	}

	/**
	 * Recursive helper method to find a node with the given 
	 * element in the binary search tree.
	 *
	 * @param current the current node being examined.
	 * @param data    the data value of the element to be found.
	 * @return the node containing the element, or null if not found.
	 */
	private TNode findRecursive(TNode current, int data) 
	{
		if (current == null) 
		{
			return null;
		}

		if (data == current.data) 
		{
			return current;
		} 

		else if (data < current.data) 
		{
			return findRecursive(current.left, data);
		} 

		else 
		{
			return findRecursive(current.right, data);
		}
	}

	/**
	 * Find the minimum element in the binary search tree.
	 *
	 * @return the minimum element in the tree.
	 */
	public int findMin() 
	{
		if (root == null) 
		{
			System.out.println("Tree is empty, cannot find minimum.");
		}

		return findMinRecursive(root);
	}

	/**
	 * Recursive helper method to find the minimum element in the binary search tree.
	 *
	 * @param current the current node being examined.
	 * @return the minimum element in the tree.
	 */
	private int findMinRecursive(TNode current) 
	{
		if (current.left == null) 
		{
			return current.data;
		}
		return findMinRecursive(current.left);
	}

	/**
	 * Find the maximum element in the binary search tree.
	 *
	 * @return the maximum element in the tree.
	 */
	public int findMax() 
	{
		if (root == null) 
		{
			System.out.println("Tree is empty, cannot find maximum.");
		}
		return findMaxRecursive(root);
	}

	/**
	 * Recursive helper method to find the maximum element in the binary search tree.
	 *
	 * @param current the current node being examined.
	 * @return the maximum element in the tree.
	 */
	private int findMaxRecursive(TNode current) 
	{
		if (current.right == null) 
		{
			return current.data;
		}
		return findMaxRecursive(current.right);
	}

	/**
	 * Check if the binary search tree contains a given value.
	 *
	 * @param value the value to be checked.
	 * @return true if the value is found, false otherwise.
	 */
	public boolean contains(int value) 
	{
		return containsRecursive(root, value);
	}

	/**
	 * Recursive helper method to check if the binary search tree contains a given value.
	 *
	 * @param current the current node being examined.
	 * @param value   the value to be checked.
	 * @return true if the value is found, false otherwise.
	 */
	private boolean containsRecursive(TNode current, int value) 
	{
		if (current == null) 
		{
			return false;
		}

		if (value == current.data) 
		{
			return true;
		}

		if (value < current.data) 
		{
			return containsRecursive(current.left, value);
		} 

		else 
		{
			return containsRecursive(current.right, value);
		}
	}

	/**
	 * Count the number of nodes in the binary search tree.
	 *
	 * @return the number of nodes in the tree.
	 */
	public int countNodes() 
	{
		return countNodesRecursive(root);
	}

	/**
	 * Recursive helper method to count the number of nodes in the binary search tree.
	 *
	 * @param node the current node being examined.
	 * @return the number of nodes in the tree.
	 */
	private int countNodesRecursive(TNode node) 
	{
		// empty BST
		if (node == null) 
		{
			return 0;
		}
		return 1 + countNodesRecursive(node.left) + countNodesRecursive(node.right);
	}

	/**
	 * Get the sum of all elements in the binary search tree.
	 *
	 * @return the sum of all elements in the tree.
	 */
	public int getSum() 
	{
		return getSumRecursive(root);
	}

	/**
	 * Recursive helper method to get the sum of all elements in the binary search tree.
	 *
	 * @param node the current node being examined.
	 * @return the sum of all elements in the tree.
	 */
	private int getSumRecursive(TNode node) 
	{
		if (node == null) 
		{
			return 0;
		}
		return node.data + getSumRecursive(node.left) + getSumRecursive(node.right);
	}

	/**
	 * Calculate the average value of all elements in the binary search tree.
	 *
	 * @return the average value of all elements in the tree.
	 */
	public double findAverage() 
	{
		int sum = getSum();
		int count = countNodes();
		if (count == 0) 
		{
			return 0; // Avoid division by zero
		}
		return (double) sum / count;
	}

	/**
	 * Get the depth of a node with the given element in the binary search tree.
	 *
	 * @param element the element to find the depth for.
	 * @return the depth of the node with the element, or -1 if the element is not found.
	 */
	public int getDepth(int element) 
	{
		return getDepthRecursive(root, element, 0);
	}

	/**
	 * Recursive helper method to get the depth of a node with the given element in the binary search tree.
	 *
	 * @param current the current node being examined.
	 * @param data    the data value of the element to find the depth for.
	 * @param depth   the current depth.
	 * @return the depth of the node with the element, or -1 if the element is not found.
	 */
	private int getDepthRecursive(TNode current, int data, int depth) 
	{
		if (current == null) 
		{
			return -1;
		}

		if (data == current.data) 
		{
			return depth;
		} 

		else if (data < current.data) 
		{
			return getDepthRecursive(current.left, data, depth + 1);
		} 

		else 
		{
			return getDepthRecursive(current.right, data, depth + 1);
		}
	}

	/**
	 * Get a subtree rooted at the node with the given element in the binary search tree.
	 *
	 * @param element the element to find the subtree root for.
	 * @return a new Tree instance representing the subtree, or null if the element is not found.
	 */
	public Tree getTreeRootedAt(int a) 
	{
		TNode rootOfSubtree = find(a);
		if (rootOfSubtree == null) 
		{
			System.out.println("Element not found in the tree.");
			return null;
		} 

		else 
		{
			Tree subtree = new Tree();
			subtree.root = rootOfSubtree;
			return subtree;
		}
	}

	/**
	 * Get the height of the binary search tree.
	 *
	 * @return the height of the tree.
	 */
	public int getHeight() 
	{
		return getHeightRecursive(root);
	}

	/**
	 * Recursive helper method to get the height of the binary search tree.
	 *
	 * @param node the current node being examined.
	 * @return the height of the tree.
	 */
	private int getHeightRecursive(TNode node) {
		if (node == null) 
		{
			return -1; // Height of an empty tree is -1
		}
		int leftHeight = getHeightRecursive(node.left);
		int rightHeight = getHeightRecursive(node.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

	/*
	 * PREORDER: 	VISIT, LEFT, RIGHT
	 * POST ORDER: 	LEFT, RIGHT, VISIT
	 * INORDER: 	LEFT, VISIT, RIGHT AKA SORT
	 */

	/**
	 * Perform a pre-order traversal of the binary search tree and print the elements.
	 */
	public void PreOrderTraversal()
	{
		PreOrderTraversalRecursive(root);
	}

	/**
	 * Recursive helper method to perform a pre-order traversal of the binary search tree and print the elements.
	 *
	 * @param node the current node being examined.
	 */
	private void PreOrderTraversalRecursive(TNode node)
	{
		if(node != null)
		{
			System.out.print(node.data + ", ");		
			PreOrderTraversalRecursive(node.left);
			PreOrderTraversalRecursive(node.right);
		}

	}

	/**
	 * Perform a post-order traversal of the binary search tree and print the elements.
	 */
	public void postOrderTraversal() 
	{
		postOrderTraversalRecursive(root);
	}

	/**
	 * Recursive helper method to perform a post-order traversal of the binary search tree and print the elements.
	 *
	 * @param node the current node being examined.
	 */
	private void postOrderTraversalRecursive(TNode node) 
	{
		if (node != null) {
			postOrderTraversalRecursive(node.left);
			postOrderTraversalRecursive(node.right);
			System.out.print(node.data + ", ");
		}
	}

	/**
	 * Perform an in-order traversal of the binary search tree and print the elements.
	 */
	public void inOrderTraversal() 
	{
		inOrderTraversalRecursive(root);
	}

	/**
	 * Recursive helper method to perform an in-order traversal of the binary search tree and print the elements.
	 *
	 * @param node the current node being examined.
	 */
	private void inOrderTraversalRecursive(TNode node) 
	{
		if (node != null) {
			inOrderTraversalRecursive(node.left);
			System.out.print(node.data + ", ");
			inOrderTraversalRecursive(node.right);
		}
	}

	/*
	 * OPTIONAL METHOD
	 * Find if a node with the first element is an ancestor of the node with the second element.
	 *
	 * @param first  the first element to check.
	 * @param second the second element to check.
	 * @return true if the first element is an ancestor of the second element, false otherwise.
	 */
	public boolean findIfAncestor(int first, int second) 
	{
		return findIfAncestorRecursive(root, first, second);
	}

	/**
	 * Checks if a given node is an ancestor of another node in a binary tree, using a recursive approach.
	 *
	 * @param node       The root of the current subtree being checked.
	 * @param ancestor   The data value of the node that is being considered as an ancestor.
	 * @param descendant The data value of the node that is being considered as a descendant.
	 * @return {@code true} if the 'ancestor' node is indeed an ancestor of the 'descendant' node,
	 *         {@code false} otherwise.
	 */
	private boolean findIfAncestorRecursive(TNode node, int ancestor, int descendant) {
		if (node == null) 
		{
			return false;
		}

		if (node.data == ancestor) 
		{
			return isDescendant(node, descendant);
		}

		return findIfAncestorRecursive(node.left, ancestor, descendant) || findIfAncestorRecursive(node.right, ancestor, descendant);
	}

	/**
	 * Checks if a given node is a descendant of another node in a binary tree, using a recursive approach.
	 *
	 * @param node   The root of the current subtree being checked.
	 * @param target The data value of the node that is being considered as a potential descendant.
	 * @return {@code true} if the 'target' node is indeed a descendant of the current subtree,
	 *         {@code false} otherwise.
	 */
	private boolean isDescendant(TNode node, int target) 
	{
		if (node == null) 
		{
			return false;
		}

		if (node.data == target) 
		{
			return true;
		}

		return isDescendant(node.left, target) || isDescendant(node.right, target);
	}

	/*
	 * DISPLAY OF TREE AS ACTUAL TREE
	 */
	public void printTree() 
	{
		if (root == null) 
		{
			System.out.println("Tree is empty.");
			return;
		}

		Queue<TNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) 
		{
			int levelSize = queue.size();

			for (int i = 0; i < levelSize; i++) 
			{
				TNode current = queue.poll();
				System.out.print(current.data + " ");

				if (current.left != null) 
				{
					queue.add(current.left);
				}

				if (current.right != null) 
				{
					queue.add(current.right);
				}
			}
			System.out.println();
		}
	}

}