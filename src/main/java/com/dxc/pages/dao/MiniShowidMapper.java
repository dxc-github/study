package com.dxc.pages.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dxc.pages.entity.MiniShowids;

public interface MiniShowidMapper {
	@Select("<script>"
			+ "SELECT * FROM mini_showids WHERE project=#{project}"
			+"<if test=\"postion!=null\">and position=#{position}</if>"
			+"<if test=\"status!=null\">and status=#{status}</if>"
			+"<if test=\"name!=null and ''!=name\">and like '%'+name+'%'</if>"
			+"</script>")
	public List<MiniShowids> selectAll(String project
			,String postion
			,Integer status
			,String name
			);
	@Select("<script>"
			+"SELECT * FROM mini_showids WHERE project=#{project} and show_id=#{showId} and position=#{position}"
			+"<if test=\"id!=null\">and id!=#{id}</if>"
			+"</script>")
	public MiniShowids selectByShowid(String project,String showId,String position,Integer id);
	@Select("<script>"
			+"SELECT * FROM mini_showids WHERE project=#{project} and sort=#{sort} and position=#{position}"
			+"<if test=\"id!=null\">and id!=#{id}</if>"
			+"</script>")
	public MiniShowids selectBySort(String project,Integer sort,String position,Integer id);
	@Insert("INSERT INTO mini_showids VALUES(null,#{project},#{position},#{name},#{showId},#{sort},#{status},#{offlineTime,jdbcType=TIMESTAMP},#{createdAt,jdbcType=TIMESTAMP},#{updatedAt,jdbcType=TIMESTAMP})")
	public boolean inset(MiniShowids miniShowids);
	@Update("UPDATE mini_showids SET sort=NULL,status=0,offline_time=NULL WHERE project=#{project} AND status<>0")
	public boolean updateTypeAll(String project);
	@Update("UPDATE mini_showids SET sort=NULL,status=0,offline_time=NULL WHERE project=#{project} AND id=#{id}")
	public boolean updateTypeById(String project,Integer id);
	@Update("UPDATE mini_showids SET position=#{position},name=#{name},show_id=#{showId},sort=#{sort},updated_at=#{updatedAt,jdbcType=TIMESTAMP} WHERE project=#{project} AND id=#{id}")
	public boolean updateById(MiniShowids miniShowids);
	@Delete("DELETE FROM mini_showids WHERE id=#{id}")
	public boolean deleteById(int id);
}
