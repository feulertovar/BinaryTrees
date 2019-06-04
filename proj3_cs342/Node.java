package proj3_cs342;

//---------------------------------------------------------------------------
//
//Node for BinTree text parser.
//
//Author: Feuler Tovar
//Date: 04/30/19
//Class: MET CS342, Project 3
//Issues: None known
//
//Description:
//Node of a Person's data to be used for the Binary Tree that will parse a text file.

//
//Assumptions:
//
//

public class Node {

	public Node() {
		// TODO Auto-generated constructor stub
	}

	private String data;
	private Node lchild;
	private Node rchild;
	private Integer instance = 1;
	
	
	public Integer getInstance() {
		return instance;
	}

	public void setInstance(Integer instance) {
		this.instance = instance;
	}


	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getLchild() {
		return lchild;
	}

	public void setLchild(Node lchild) {
		this.lchild = lchild;
	}

	public Node getRchild() {
		return rchild;
	}

	public void setRchild(Node rchild) {
		this.rchild = rchild;
	}

}
