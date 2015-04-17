package diary.pagemodel;

import java.util.List;

public class Page<T> {

	/**
	 * 存放数据的集合
	 */
	private List<T> list;

	/**
	 * 要显示的当前页
	 */
	private int current;

	/**
	 * 一个页面的大小
	 */
	private int pagesize = 10;

	/**
	 * 总的记录条数
	 */
	private int total;

	/**
	 * 总的页数
	 */
	private int totalpage;
	
	
	/**
	 * 初始化Page对象
	 * @param current  当前面
	 * @param total    总的记录数
	 */
	public Page(int current,int total) {
		this.total = total;
		this.current = current;
		if (this.total % this.pagesize == 0) {
			totalpage = this.total / this.pagesize;
		} else if (this.total % this.pagesize != 0) {
			totalpage = this.total / this.pagesize + 1;
		}
	}

	public int getTotalpage() {
		return totalpage;
	}

	

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

}
