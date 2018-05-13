package cn.lzx.domin;

import java.util.List;

public class Page<T> {
	//总记录数
	private Integer totalCount;
	//当前页数
	private Integer currPage;
	//总共页数
	private Integer totalPage;
    //每页总记录数   
	private Integer pageSize;
	//开始检索的位置
	private Integer startIndex;
	//需要检索的数量
	private Integer selectCount;
	//需要分页的类查询的数据
	private List<T> list;
	
	
	public Page() {
		super();
	}

	public Page(Integer totalCount, Integer currPage, Integer totalPage, Integer pageSize, Integer startIndex,
			Integer selectCount) {
		super();
		this.totalCount = totalCount;
		this.currPage = currPage;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.startIndex = startIndex;
		this.selectCount = selectCount;
	}
	
	public void count() {
		
		this.pageSize=3;
		int plus=(this.totalCount%this.pageSize)==0?0:1;
		int totalPage=this.totalCount/this.pageSize+plus;
		if(totalPage<=0) {
			totalPage=1;
		}
		this.totalPage=totalPage;
		if(this.totalPage<this.currPage) {
			this.currPage=this.totalPage;
		}
		if(this.currPage<1) {
			this.currPage=1;
		}
		this.startIndex=(this.currPage-1)*this.pageSize;
		this.selectCount=this.pageSize;
	}
	
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		this.count();
	}
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getSelectCount() {
		return selectCount;
	}
	public void setSelectCount(Integer selectCount) {
		this.selectCount = selectCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Page [totalCount=" + totalCount + ", currPage=" + currPage + ", totalPage=" + totalPage + ", pageSize="
				+ pageSize + ", startIndex=" + startIndex + ", selectCount=" + selectCount + ", list=" + list + "]";
	}
	
	
	
}
