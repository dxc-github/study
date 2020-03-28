package com.dxc.pages;

import java.util.Date;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dxc.pages.dao.MiniShowidMapper;
import com.dxc.pages.entity.MiniShowids;
import com.dxc.pages.service.MiniShowidService;
import com.github.pagehelper.PageInfo;

@SpringBootTest
class PagesApplicationTests {
	@Autowired
	MiniShowidService minishowidservice;
	@Autowired
	MiniShowidMapper m;
	
	MiniShowids miniShowids=new MiniShowids();
	@Test
	void contextLoads() {
		Map<String, Object> selectAll = minishowidservice.selectAll("ys001",null,null,null,1,0);
		System.out.println(selectAll.get("data"));
		
	}
	@Test
	void add() {
		minishowidservice.miniShowidAdd("ys001","左上","信息流3","sss77",null);
	}
	
	@Test
	void byid() {
		MiniShowids s=m.selectByShowid("ys001","ss6636","右上",null);
		System.out.println(s.getId());
	}
	
	@Test
	void bysort() {
		MiniShowids selectBySort = m.selectBySort("ys001", 1, "左侧广告",null);
		System.out.println(selectBySort.getId());
	}
	
	@Test
	void update() {
		boolean updateTypeAll = m.updateTypeAll("ys001");
		System.out.println(updateTypeAll);
	}
	
	@Test
	void updateById() {
		Map<String, Object> updateById = minishowidservice.updateById(1, "ys001", "左侧广告", "左侧信息流2", "asxdf2", 10);
		System.out.println(updateById.get("node"));
	}
	
	@Test
	void deleteById() {
		Map<String, Object> deleteById = minishowidservice.deleteById(11);
		System.out.println(deleteById.get("node"));
	}

}
