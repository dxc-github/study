package com.dxc.pages.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.pages.dao.MiniShowidMapper;
import com.dxc.pages.entity.MiniShowids;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class MiniShowidService {
	@Autowired
	MiniShowidMapper miniShowidMapper;
	MiniShowids miniShowids=new MiniShowids();
	Map<String, Object> jsonMap=new HashMap<String, Object>();
	public Map<String,Object> selectAll(String project
			,String postion
			,Integer status
			,String name
			,Integer page
			,Integer pageSize
			){
		if(page==null) {
			page=1;
		}
		if(pageSize==null) {
			pageSize=0;
		}
		PageHelper.startPage(page, pageSize);
		List<MiniShowids> miniShowidList=miniShowidMapper.selectAll(project, postion, status, name);
		PageInfo<MiniShowids> pageinfo=new PageInfo<>(miniShowidList);
		jsonMap.put("status", "200");
		jsonMap.put("node", "success");
		jsonMap.put("data", pageinfo.getList());
		jsonMap.put("pageSize", pageinfo.getSize());
		jsonMap.put("count", pageinfo.getPages());
		return jsonMap;
	}
	
	public Map<String,Object> miniShowidAdd(String project
			,String position
			,String name
			,String showId
			,Integer sort) {
		if(position==null||position=="") {
			jsonMap.put("status", "300");
			jsonMap.put("node", "广告位不能为空");
			return jsonMap;
		}
		if(name==null||name=="") {
			jsonMap.put("status", "300");
			jsonMap.put("node", "广告位名称不能为空");
			return jsonMap;
		}
		if(showId==null||showId=="") {
			jsonMap.put("status", "300");
			jsonMap.put("node", "showid不能为空");
			return jsonMap;
		}
		if(sort!=null) {
			MiniShowids ss=miniShowidMapper.selectBySort(project,sort,position,null);
			if(ss!=null) {
				jsonMap.put("status", "300");
				jsonMap.put("node", "排序不能重复");
				return jsonMap;
			}
		}
		MiniShowids sh=miniShowidMapper.selectByShowid(project,showId,position,null);
		if(sh!=null) {
			jsonMap.put("status", "300");
			jsonMap.put("node", "showid已存在");
			return jsonMap;
		}else {
			miniShowids.setProject(project);
			miniShowids.setPosition(position);
			miniShowids.setName(name);
			miniShowids.setShowId(showId);
			miniShowids.setSort(sort);
			miniShowids.setStatus(0);
			miniShowids.setCreatedAt(new Date());
			boolean inset = miniShowidMapper.inset(miniShowids);
			if(inset==true) {
				jsonMap.put("status", "200");
				jsonMap.put("node", "success");
				return jsonMap;
			}else {
				jsonMap.put("status", "400");
				jsonMap.put("node", "error");
				return jsonMap;
			}
		}
	}
	
	public Map<String, Object> updateTypeAll(String project){
		boolean updateTypeAll = miniShowidMapper.updateTypeAll(project);
		if(updateTypeAll==true) {
			jsonMap.put("status", "200");
			jsonMap.put("node", "success");
			return jsonMap;
		}else {
			jsonMap.put("status", "400");
			jsonMap.put("node", "error");
			return jsonMap;
		}
	}
	
	public Map<String, Object> updateTypeById(String project,Integer id){
		boolean updateTypeById = miniShowidMapper.updateTypeById(project, id);
		if(updateTypeById==true) {
			jsonMap.put("status", "200");
			jsonMap.put("node", "success");
			return jsonMap;
		}else {
			jsonMap.put("status", "400");
			jsonMap.put("node", "error");
			return jsonMap;
		}
	}
	
	public Map<String, Object> updateById(int id
			,String project
			,String position
			,String name
			,String showId
			,Integer sort
			){
		MiniShowids sh = miniShowidMapper.selectByShowid(project, showId, position,id);
		if(sh!=null) {
			jsonMap.put("status", "300");
			jsonMap.put("node", "showid已存在");
			return jsonMap;
		}
		if(sort!=null) {
			MiniShowids ss=miniShowidMapper.selectBySort(project,sort,position,id);
			if(ss!=null) {
				jsonMap.put("status", "300");
				jsonMap.put("node", "排序不能重复");
				return jsonMap;
			}
		}
		System.out.println(position);
		System.out.println(name);
		System.out.println(showId);
		System.out.println(sort);
		miniShowids.setId(id);
		miniShowids.setProject(project);
		miniShowids.setPosition(position);
		miniShowids.setName(name);
		miniShowids.setShowId(showId);
		miniShowids.setSort(sort);
		miniShowids.setUpdatedAt(new Date());
		boolean updateById = miniShowidMapper.updateById(miniShowids);
		if(updateById==true) {
			jsonMap.put("status", "200");
			jsonMap.put("node", "success");
			return jsonMap;
		}else {
			jsonMap.put("status", "400");
			jsonMap.put("node", "error");
			return jsonMap;
		}
	}
	
	public Map<String, Object> deleteById(int id){
		boolean deleteById = miniShowidMapper.deleteById(id);
		if(deleteById==true) {
			jsonMap.put("status", "200");
			jsonMap.put("node", "success");
			return jsonMap;
		}else {
			jsonMap.put("status", "400");
			jsonMap.put("node", "error");
			return jsonMap;
		}
	}
	
	
}
