package com.iu.ss1.util;




public class Pager {

	
	private Long curPage; //파라미터로 받아줘야함
	private Long perPage; //페이지당 글 갯수
	private Long startRow; //시작 글번호
	private Long perBlock;
	private Long startNum;
	private Long lastNum;
	
	private boolean pre;
	private boolean next;

	private String kind;
	private String search;
	
	
	
	
	
	
	
	
	
	public void makeRow() throws Exception{
		
		//curPage 가 1일때 startRow 0
		// 2 --> 10
		// 3 --> 20
		
		
		this.startRow = (this.getCurPage()-1)*(this.getPerPage());
	}
	
	
	public void makeNum(Long totalCount) {
		
		
		
		//totalcount totalpage totalblock curblock startNum
		
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage()!=0) {
			totalPage++;
		}
		
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.getPerBlock()!=0) {
			totalBlock++;
		}
		
		Long curBlock = this.getCurPage()/this.getPerBlock()+1;
		if(this.getCurPage()%this.getPerBlock()==0) {
			curBlock--;
		}
		
		this.setStartNum(this.getPerBlock()*(curBlock-1)+1);
		this.setLastNum(this.getPerBlock()*curBlock);
		
		
		this.pre=true;
		this.next=true;
		
		
		if(curBlock==totalBlock) {
			this.setLastNum(totalPage);
			this.next=false;
		}
		
		
		if(curBlock==1) {
			this.pre=false;
		}
		
		
	}
	
	
	
	
	
	
	public Long getStartNum() {
		return startNum;
	}
	
	
	
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	
	
	
	public Long getLastNum() {
		return lastNum;
	}
	
	
	
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	
	
	
	public Long getPerBlock() {
		
		if(this.perBlock==null ||this.perBlock==0) {
			perBlock=5L;
		}
		
		return perBlock;
	}
	
	
	
	public void setPerBlock(Long perBlock) {
		
		if(this.perBlock==null ||this.perBlock==0) {
			this.perBlock=5L;
		}else {
			
			
			this.perBlock = perBlock;}
	}
	
	
	
	public void setCurPage(Long curPage) {
		if(this.curPage==null || this.curPage<1) {
			this.curPage=1L;
		}else {
			this.curPage=curPage;
		}
	}
	
	
	
	public Long getCurPage() {
		if(this.curPage==null || this.curPage==0) {
			this.curPage=1L;
		}
		return curPage;
		
	}
	
	
	public Long getPerPage() {
		if(this.perPage==null || this.perPage==0) {
			this.perPage=10L;
		}
		
		return perPage;
	}
	
	
	
	
	public void setPerPage(Long perPage) {
		
		if(perPage==null || perPage==0) {
			this.perPage=10L;
		}else {
			
			this.perPage = perPage;
		}
	}
	
	
	
	public Long getStartRow() {
		return startRow;
	}
	
	
	
	
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}


	public boolean isPre() {
		return pre;
	}


	public void setPre(boolean pre) {
		this.pre = pre;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		
		return search;
	}


	public void setSearch(String search) {
		if(this.search==null) {
			this.search="";
		}
		
		this.search = search;
	}
	
	
	
	
	
}


