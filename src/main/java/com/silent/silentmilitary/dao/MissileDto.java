package com.silent.silentmilitary.dao;


import com.silent.silentmilitary.domain.Missile;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MissileDto {

    @Select("select * from missile where Name = #{name}")
    Missile findMissileByName(@Param("name") String name);

    @Insert("insert into missile(Name,Country) values(#{name},#{country})")
    int insertMissile(@Param("name") String name,@Param("country") String country);


}
