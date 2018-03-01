package com.iba.entity;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageInfo;

public class IPageInfo implements Serializable{

	private static final long serialVersionUID = -5176435748316040669L;

	private List<?> records;
	
	private long totalRecordNum;
	
	private int totalPageNum;
	
	private int pageSize;
	
	private int pageNum;
	
	public static IPageInfo instance(List<?> records) {
		PageInfo<?> pi = new PageInfo<>(records);
		IPageInfo ipf = new IPageInfo();
		ipf.setTotalRecordNum(pi.getTotal());
		ipf.setTotalPageNum(pi.getPages());;
		ipf.setPageNum(pi.getPageNum());;
		ipf.setPageSize(pi.getPageSize());
		ipf.setRecords(records);
		return ipf;
	}

	public List<?> getRecords() {
		return records;
	}

	public void setRecords(List<?> records) {
		this.records = records;
	}

	public long getTotalRecordNum() {
		return totalRecordNum;
	}

	public void setTotalRecordNum(long totalRecordNum) {
		this.totalRecordNum = totalRecordNum;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}
