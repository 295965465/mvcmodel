package com.dewell.common.easyuitool;

import java.io.Serializable;

public class PageTool implements Serializable {
	private static final long serialVersionUID = 2360278913378031622L;
	 //默认当前页面为第�?�?
	 private int pageNow;
	 //默认每页显示10条数�?
     private int pageSize;
     //记录总条�?
     private int totalCount;
     //总页�?
     private int totalPageCount;
     // �?始位置，�?0�?�?
     @SuppressWarnings("unused")
     private int startPos;
     // 是否有首�?
     @SuppressWarnings("unused")
     private boolean hasFirst;
     // 是否有前�?�?
     @SuppressWarnings("unused")
     private boolean hasPre;
     // 是否有下�?�?
     @SuppressWarnings("unused")
     private boolean hasNext;
     // 是否有最后一�?
     @SuppressWarnings("unused")
     private boolean hasLast;
     private int row;
     private int endPos;
     private String news;
     /**
      * 得到总条数和当前页数
      * @param totalCount
      * @param pageNow
     * @param news 
      */
     public PageTool(int row, int pageNow, String news) {
    	this.row=row;
    	 this.pageNow = pageNow;
    	 this.news=news;
	}
     
     public PageTool(int row, int pageNow) {
     	this.row=row;
     	 this.pageNow = pageNow;
     
 	}
     
	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getStartPos() {
		return (pageNow - 1) * row;
	}
	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}
	
	
	public int getEndPos() {
		return pageNow*row;
	}
	public void setEndPos(int endPos) {
		this.endPos = endPos;
	}
	@Override
	public String toString() {
		return "PageTool [pageNow=" + pageNow + ", startPos=" + startPos
				+ ", row=" + row + ", endPos=" + endPos + "]";
	}
	
     
}