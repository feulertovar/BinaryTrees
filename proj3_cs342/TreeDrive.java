package proj3_cs342;
//---------------------------------------------------------------------------
//
//Binary Tree based text parser
//
//Author: Feuler Tovar
//Date: 04/30/19
//Class: MET CS342, Project 3
//Issues: None known
//
//Description:
//This program read in a lengthy text file.
//All punctuation and special characters will be removed
//Letters and numbers that remained will be made lower case and added to a binary tree.
//
//Assumptions:
//

public class TreeDrive {

	/**
	 * 
	 */
	public TreeDrive() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	///////////////////////////////////////////////////////////////////
	/// main program entry point ///
	/// Input : arguments. (these are ignored for this program) ///
	/// Output: None ///
	/// Returns nothing ///
	/// ///
	///////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeDrive td = new TreeDrive();
		td.doIt();
	}
	

	///////////////////////////////////////////////////////////////////
	/// do (Worker method called from main) ///
	/// Input : None ///
	/// Output: None ///
	/// Returns Nothing ///
	/// ///
	///////////////////////////////////////////////////////////////////
	public void doIt() {
	    BinTree myTree = new BinTree();
	    
	    // text file stored locally
		String filePath = "pg345.txt";

		// new parser
		ParseText prs = new ParseText();

		// Build Linked List from text file
		myTree = prs.buildTree(filePath, myTree);
		
		//build query data and output results to console
		DataQuery data = new DataQuery();
		prs.queryTree(data, myTree);
	   
	}

}
