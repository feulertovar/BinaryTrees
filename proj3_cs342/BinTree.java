package proj3_cs342;
//---------------------------------------------------------------------------
//
//BinaryTree
//Used in Binary Tree Parser Program
//
//Author: Feuler Tovar
//Date: 04/30/19
//Class: MET CS342, Project 3
//Issues: None known
//
//Description:
//Binary Tree based tree class
//
//Assumptions:
//
//

public class BinTree {

	private Node root;
	private int count;

	public BinTree() {
		// TODO Auto-generated constructor stub
	}

	public BinTree(BinTree tree) {
		// TODO Auto-generated constructor stub
		this.root = tree.root;
		this.count = tree.count;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean search(String data) {
		return (search(root, data) != null);
	}

	
	///////////////////////////////////////////////////////////////////
	/// Add (Add item to the Tree) 									///
	/// Input : data 												///
	/// Output: nothing 											///
	/// Returns adds a new word to the tree, no duplicates			///
	/// 															///
	///////////////////////////////////////////////////////////////////	
	public void add(String data) {

		if (search(data)) {
			return;
		}

		if (root == null) {
			// add root to the tree
			root = new Node();
			root.setData(data);
		} else {
			internalAdd(root, data);
		}
		// keep count of how many different words are added
		count++;
	}

	///////////////////////////////////////////////////////////////////
	/// internalAdd (worker function for Add) 						///
	/// Input : data 												///
	/// Output: nothing 											///
	/// Returns adds a new word to the tree, no duplicates			///
	/// 															///
	///////////////////////////////////////////////////////////////////
	private void internalAdd(Node root, String data) {
		if (root == null) {
			return;
		}

		if (data.compareTo(root.getData()) < 0) {
			if (root.getLchild() == null) {
				// add here
				Node n = new Node();
				n.setData(data);
				root.setLchild(n);

			} else {
				// recurse
				internalAdd(root.getLchild(), data);
			}
		} else {
			if (root.getRchild() == null) {
				// add here
				Node n = new Node();
				n.setData(data);
				root.setRchild(n);
			} else {
				// recurse
				internalAdd(root.getRchild(), data);
			}
		}
	}
	///////////////////////////////////////////////////////////////////
	/// search (search the tree for data) 							///
	/// Input : Node, String 										///
	/// Output: Node 												///
	/// Returns Node containing the data							///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public Node search(Node root, String data) {

		if (root == null)
			return null;

		if (data.compareTo(root.getData()) == 0) {
			return root;
		}

		if (data.compareTo(root.getData()) < 0) {
			return search(root.getLchild(), data);
		} else {
			return search(root.getRchild(), data);
		}

	}
	
	///////////////////////////////////////////////////////////////////
	/// printTree (print the entire tree) 							///
	/// Input : 													///
	/// Output: Tree Data 											///
	/// Returns Nothing												///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public void printTree() {
		printTree(root);
		System.out.println();

	}

	private void printTree(Node root) {
		// in order traversal
		// gives us the data lowest to highest

		if (root == null) {
			return;
		}

		printTree(root.getLchild());
		System.out.println(root.getData() + " ");
		printTree(root.getRchild());

	}
	
	///////////////////////////////////////////////////////////////////
	/// inOrder (print the entire tree in InOrder traversal 		///
	/// Input : 													///
	/// Output: Tree Data 											///
	/// Returns Nothing												///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public void inOrder() {
		inOrder(root);
		System.out.println();

	}

	private void inOrder(Node root) {
		// in order traversal
		// gives us the data lowest to highest

		if (root == null) {
			return;
		}

		inOrder(root.getLchild());
		System.out.print(root.getData() + " ");
		inOrder(root.getRchild());

	}

	///////////////////////////////////////////////////////////////////
	/// preOrder (print the entire tree in preOrder traversal 		///
	/// Input : 													///
	/// Output: Tree Data 											///
	/// Returns Nothing												///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public void preOrder() {
		preOrder(root);
		System.out.println();

	}

	private void preOrder(Node root) {
		// pre-order traversal

		if (root == null) {
			return;
		}

		System.out.print(root.getData() + " ");
		preOrder(root.getLchild());
		preOrder(root.getRchild());

	}

	///////////////////////////////////////////////////////////////////
	/// postOrder (print the entire tree in postOrder traversal 	///
	/// Input : 													///
	/// Output: Tree Data 											///
	/// Returns Nothing												///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public void postOrder() {
		postOrder(root);

	}

	private void postOrder(Node root) {
		// post order traversal
		// gives us the data lowest to highest

		if (root == null) {
			return;
		}

		postOrder(root.getLchild());
		postOrder(root.getRchild());
		System.out.print(root.getData() + " ");

	}

	///////////////////////////////////////////////////////////////////
	/// depth (depth of the tree)									///
	/// Output: 													///
	/// Returns The deepest level of the tree						///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public int depth() {
		return depth(root, 0, 0);

	}

	///////////////////////////////////////////////////////////////////
	/// depth (depth of the tree									///
	/// Input: root, curLevel, maxLevel								///
	/// Returns The deepest level of the tree						///
	/// 															///
	///////////////////////////////////////////////////////////////////
	private int depth(Node root, int curlevel, Integer maxlevel) {
		if (root == null) {
			return curlevel;
		}

		curlevel++;

		if (curlevel > maxlevel) {
			maxlevel = curlevel;
		}

		int lmax = depth(root.getLchild(), curlevel, maxlevel);
		int rmax = depth(root.getRchild(), curlevel, maxlevel);

		return rmax > lmax ? rmax : lmax;

	}

}
