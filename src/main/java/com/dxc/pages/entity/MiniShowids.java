package com.dxc.pages.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MiniShowids {
	private int id;
	private String project;
	private String position;
	private String name;
	private String showId;
	private Integer sort;
	private int status;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:SS")
	private Date offlineTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:SS")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:SS")
	private Date updatedAt;
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShowId() {
		return showId;
	}
	public void setShowId(String showId) {
		this.showId = showId;
	}
	
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Date getOfflineTime() {
		return offlineTime;
	}
	public void setOfflineTime(Date offlineTime) {
		this.offlineTime = offlineTime;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
