package com.tx.zhongxun.mapper;

import com.tx.zhongxun.pojo.Ultrasound;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UltrasoundMapper {

    @Select("select * from table_ultrasound_2 where CONCAT(id,waveform,equipment,constructionSite,section,author,uploadDate,foundDate) like CONCAT('%',#{id},'%')")
    public List<Ultrasound> getUltrasoundList(String id);

    @Insert("insert into table_ultrasound_2 (id,waveform,equipment,constructionSite,section,author,uploadDate,foundDate) " +
            "values (#{id},#{waveform},#{equipment},#{constructionSite},#{section},#{author},#{uploadDate},#{foundDate})")
    public int add(Ultrasound ultrasound);

    @Delete(" delete from table_ultrasound_2 where id= #{id} ")
    public void del(int id);

    @Select("select * from table_ultrasound_2 where id= #{id} ")
    public Ultrasound getUltrasound(int id);

    @Update("update table_ultrasound_2 set " +
            "waveform = #{waveform}," +
            "equipment = #{equipment}," +
            "constructionSite = #{constructionSite}," +
            "section = #{section}," +
            "author = #{author}," +
            "uploadDate = #{uploadDate}, " +
            "foundDate = #{foundDate} " +
            "where id=#{id} ")
    public int update(Ultrasound ultrasound);

}
