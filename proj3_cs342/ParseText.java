package proj3_cs342;
//---------------------------------------------------------------------------
//
//ParseText :  
//Used in Binary Tree text parser program
//
//Author: Feuler Tovar
//Date: 04/30/19
//Class: MET CS342, Project 3
//Issues: None known
//
//Description:
//Class model to handle text parsing and data query.
//
//Assumptions:
//
//
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ParseText {

	private static int total = 0;
	private static int counter = 0;
	private static String topWord = null;
	private static int topInstance = 0;
	
	public ParseText() {
		// TODO Auto-generated constructor stub
	}

	///////////////////////////////////////////////
	/// buildTree 								///
	/// Input : String, BinTree 				///
	/// Output: None 							///
	/// Returns Built Binary Tree 				///
	///////////////////////////////////////////////
	public BinTree buildTree(String filename, BinTree myTree) {

		try {

			// read text file into scanner
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(new File(filename));
			String strword;
			int curCount = 0;

			while (scan.hasNext()) {
				// filter word before adding to tree
				// Only letters & numbers
				// all lower case
				// EXtra Character's should be eaten
				strword = scan.next();
				strword = filterWord(strword);

				// check tree to see if word already exist
				// update instance count to it exist
				// add word to the Binary Tree if it does not exist
				Node ns = new Node();
				ns = myTree.search(myTree.getRoot(), strword);

				if (ns != null) {
					curCount = ns.getInstance() + 1;
					ns.setInstance(curCount);
					// check for word made of blank spaces
					// do not add to the tree if found
				} else if (!strword.equals("")) {
					myTree.add(strword);
				}

			}
		} catch (IOException e) {
			System.out.println("Error accessing input file!");
		}

		return myTree;
	}

	///////////////////////////////////////////////
	/// filterWord 								///
	/// Input : String							///
	/// Output: None 							///
	/// Returns Built Binary Tree 				///
	///////////////////////////////////////////////
	public String filterWord(String strword) {

		// filter letter and numbers
		strword = strword.replaceAll("[^a-zA-Z0-9]", "");
		// make all lower case
		strword = strword.toLowerCase();

		return strword;
	}

	///////////////////////////////////////////////
	/// DataQuery 								///
	/// Input : DataQuery, BinTree				///
	/// Output: None 							///
	/// Returns Data query in DataQuery model	///
	///////////////////////////////////////////////
	public DataQuery queryTree(DataQuery data, BinTree tree) {

		// How times do the following words appear in the tree:
		data.setCnttransylvania(wordInstances("transylvania", tree));
		data.setCntharker(wordInstances("harker", tree));
		data.setCntrenfield(wordInstances("renfield", tree));
		data.setCntvampire(wordInstances("vampire", tree));
		data.setCntexpostulate(wordInstances("expostulate", tree));
		data.setCntfang(wordInstances("fang", tree));
		data.setTreeCount(tree.getCount());
		data.setStrFrequent(getMostFrequent(tree.getRoot()));

		// display answers determined above
		System.out.println("transylvania appears = " + data.getCnttransylvania());
		System.out.println("harker appears = " + data.getCntharker());
		System.out.println("renfield appears = " + data.getCntrenfield());
		System.out.println("vampire appears = " + data.getCntvampire());
		System.out.println("expostulate appears = " + data.getCntexpostulate());
		System.out.println("fang appears = " + data.getCntfang());
		
		//What is the depth of the binary tree
		System.out.println("");
		System.out.println("Depth of tree is " + tree.depth());
		System.out.println("How many different words are there in the book? = " + tree.getCount());
		System.out.println("What word is at the root of the tree? = " + tree.getRoot().getData());
		System.out.println("How many total words are in the book? = " + getTotalWords(tree.getRoot()));
		System.out.print("Which word(s) are at the deepest level of the tree? " );
		getDeepestData(tree, tree.getRoot(), 0);
		System.out.println();
		System.out.println("Which word occurs most frequently? = " + data.getStrFrequent() + " ("
				+ (tree.search(tree.getRoot(),data.getStrFrequent()).getInstance() + ")"));
		//
		System.out.println();
		System.out.println("First 20 words in a Pre-Order Traversal: ");
		displayPreOrder20(tree.getRoot());
		System.out.println();
		counter = 0;
		//		
		System.out.println();
		System.out.println("First 20 words in a Post-Order Traversal: ");
		displayPostOrder20(tree.getRoot());
		System.out.println();
		counter = 0;
		//
		System.out.println();
		System.out.println("First 20 words in a In-Order Traversal: ");
		displayInOrder20(tree.getRoot());		
		System.out.println();

		return data;
	}

	///////////////////////////////////////////////
	/// wordInstances 							///
	/// Input : String, BinTree					///
	/// Output: None 							///
	/// Returns instances of a given String		///
	///////////////////////////////////////////////
	public int wordInstances(String word, BinTree myTree) {
		//BinTree tree = new BinTree(myTree);

		int count = 0;
		Node nor = myTree.search(myTree.getRoot(), word);
		if (nor != null) {
			count = nor.getInstance();

		}
		return count;

	}

	///////////////////////////////////////////////
	/// getMostFrequent()						///
	/// Input : Node							///
	/// Output: String 							///
	/// Returns most frequently used word		///
	///////////////////////////////////////////////
	public String getMostFrequent(Node root) {

		// loop though tree and get the most frequent occurring word
		// return its node
		
		// in order traversal
		// gives us the data lowest to highest

		if (root == null) {
			return null;
		}

		getMostFrequent(root.getLchild());
		if ( root.getInstance() > topInstance ) {
		topInstance = root.getInstance();
		topWord = root.getData();
		}
		getMostFrequent(root.getRchild());
		
		return topWord;
	}

	///////////////////////////////////////////////
	/// getTotalWords()							///
	/// Input : Node							///
	/// Output: int 							///
	/// Returns total number of words in tree	///
	///////////////////////////////////////////////
	public int getTotalWords(Node root) {
		
		// in order traversal
		// gives us the data lowest to highest

		if (root == null) {
			return 0;
		}
		
		getTotalWords(root.getLchild());
		total = total + root.getInstance();
		getTotalWords(root.getRchild());
		
		return total;
	}
	///////////////////////////////////////////////////////////////////
	/// preOrder (print the entire tree in preOrder traversal		///
	/// Input : 													///
	/// Output: Tree Data 											///
	/// Returns Nothing												///
	///////////////////////////////////////////////////////////////////
	public void displayPreOrder20(Node root) {
		// in order traversal
		// gives us the data lowest to highest
		counter ++;

		if (root == null || counter > 26) {
			return;  
		}

		System.out.print(root.getData() + " ");
		displayPreOrder20(root.getLchild());
		displayPreOrder20(root.getRchild());
		
}
	
	///////////////////////////////////////////////////////////////////
	/// postOrder (print the entire tree in postOrder traversal		///
	/// Input : 													///
	/// Output: Tree Data 											///
	/// Returns Nothing												///
	///////////////////////////////////////////////////////////////////
	public void displayPostOrder20(Node root) {
		
		// in order traversal
		// gives us the data lowest to highest
		counter ++;

		if (root == null || counter > 26) {
			return;
		}

		displayPostOrder20(root.getLchild());
		displayPostOrder20(root.getRchild());
		System.out.print(root.getData() + " ");
		
}
		
	
	///////////////////////////////////////////////////////////////////
	/// inOrder (print the entire tree in InOrder traversal 		///
	/// Input : 													///
	/// Output: Tree Data 											///
	/// Returns Nothing												///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public void displayInOrder20(Node root) {
		
		// in order traversal
		// gives us the data lowest to highest
		counter ++;

		if (root == null || counter > 26) {
			return;
		}
		
		displayInOrder20(root.getLchild());
		System.out.print(root.getData() + " ");
		displayInOrder20(root.getRchild());
	}
	
	////////////////////////////////////////////////////////
	/// getDeepestData()						   		 ///
	/// Input : BinTree, Node, Int						 ///
	/// Output: Finds and prints data from deepest nodes ///
	/// Returns Nothing							   		 ///
	////////////////////////////////////////////////////////
	public void  getDeepestData(BinTree tree, Node root, int curLevel) {
		
		// in order traversal
		// gives us the data lowest to highest
		
		curLevel ++;

		if ( root == null ) {
			return;
		}
		
		getDeepestData( tree, root.getLchild(), curLevel );
		
		if ( tree.depth() == curLevel ) {
			System.out.print(root.getData() + " ");
		}
		
		getDeepestData( tree, root.getRchild(), curLevel );
	}
	

}
