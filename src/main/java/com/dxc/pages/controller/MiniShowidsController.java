package com.dxc.pages.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dxc.pages.entity.MiniShowids;
import com.dxc.pages.service.MiniShowidService;
import com.github.pagehelper.PageInfo;

@Controller
public class MiniShowidsController {
	@Autowired
	MiniShowidService miniShowidService;
	//根据项目、广告位、状态、广告名称、分页查询showids
	@RequestMapping(value = "/getshowids")
	@ResponseBody
	public Map<String,Object> getAllShowidsByproject(String project
			,String postion
			,Integer status
			,String name
			,Integer page
			,Integer pageSize
			) {
		return miniShowidService.selectAll(project, postion, status, name, page, pageSize);
	}
	
	//添加showids
	@RequestMapping(value = "/showidAdd",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> showidAdd(String project
				,String position
				,String name
				,String showId
				,Integer sort) {
		return miniShowidService.miniShowidAdd(project,position,name,showId,sort);
	}
	
	//重置全部已下线的showid
	@RequestMapping(value = "/updatestatusall")
	@ResponseBody
	public Map<String,Object> updateTypeAll(String project) {
		return miniShowidService.updateTypeAll(project);
	}
	
	//根据编号重置下线的showid
	@RequestMapping(value = "/updatestatus")
	@ResponseBody
	public Map<String,Object> updateTypeById(String project,Integer id) {
		return miniShowidService.updateTypeById(project, id);
	}
	
	//根据编号修改showid
	@RequestMapping(value = "/update")
	@ResponseBody
	public Map<String,Object> updateById(int id
			,String project
			,String position
			,String name
			,String showId
			,Integer sort
			) {
		return miniShowidService.updateById(id, project, position, name, showId, sort);
	}
	
	//根据编号删除showid
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Map<String,Object> deleteById(int id) {
		return miniShowidService.deleteById(id);
	}
}
