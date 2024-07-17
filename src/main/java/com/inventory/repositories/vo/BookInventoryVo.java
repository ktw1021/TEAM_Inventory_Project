package com.inventory.repositories.vo;

import java.util.Date;

public class BookInventoryVo {
	
	private String branchId;
	private String bookCode;
	private String bookName;
	private int inventory;
	private Date inDate;
	private Date outDate;
	private int price;
	private String kindCode;
	
	public BookInventoryVo() {
		
	}


	public BookInventoryVo(String branchId, String bookCode, String bookName, Integer inventory, Date inDate,
			Date outDate, int price, String kindCode) {

		this.branchId = branchId;
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.inventory = inventory;
		this.price = price;
		this.kindCode = kindCode;
		this.inDate = inDate;
		this.outDate = outDate;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "BookInventoryVo [branchId=" + branchId + ", bookCode=" + bookCode + ", bookName=" + bookName
				+ ", inventory=" + inventory + ", inDate=" + inDate + ", outDate=" + outDate + "]";
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public String getKindCode() {
		return kindCode;
	}

	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	
	
}
