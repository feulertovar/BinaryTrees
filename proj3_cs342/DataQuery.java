package proj3_cs342;
//---------------------------------------------------------------------------
//
//DataQuery :  
//Used in Binary Tree text parser program
//
//Author: Feuler Tovar
//Date: 04/30/19
//Class: MET CS342, Project 3
//Issues: None known
//
//Description:
//Model to hold some query data
//
//Assumptions:
//
//

public class DataQuery {

	public DataQuery() {
		// TODO Auto-generated constructor stub
	}
	private int cnttransylvania = 0;
	private int cntharker = 0;
	private int cntrenfield = 0;
	private int cntvampire = 0;
	private int cntexpostulate = 0;
	private int cntfang = 0;
	private int depth = 0;
	private String strFrequent;
	private int treeCount = 0;
	
	public int getTreeCount() {
		return treeCount;
	}
	public void setTreeCount(int treeCount) {
		this.treeCount = treeCount;
	}

	
	public int getCnttransylvania() {
		return cnttransylvania;
	}
	public void setCnttransylvania(int cnttransylvania) {
		this.cnttransylvania = cnttransylvania;
	}
	public int getCntharker() {
		return cntharker;
	}
	public void setCntharker(int cntharker) {
		this.cntharker = cntharker;
	}
	public int getCntrenfield() {
		return cntrenfield;
	}
	public void setCntrenfield(int cntrenfield) {
		this.cntrenfield = cntrenfield;
	}
	public int getCntvampire() {
		return cntvampire;
	}
	public void setCntvampire(int cntvampire) {
		this.cntvampire = cntvampire;
	}
	public int getCntexpostulate() {
		return cntexpostulate;
	}
	public void setCntexpostulate(int cntexpostulate) {
		this.cntexpostulate = cntexpostulate;
	}
	public int getCntfang() {
		return cntfang;
	}
	public void setCntfang(int cntfang) {
		this.cntfang = cntfang;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getStrFrequent() {
		return strFrequent;
	}
	public void setStrFrequent(String str) {
		this.strFrequent = str;
	}


}
