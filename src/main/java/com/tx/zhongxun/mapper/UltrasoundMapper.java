package com.tx.zhongxun.mapper;

import com.tx.zhongxun.pojo.Ultrasound;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UltrasoundMapper {


    @Results(id = "ultrasounds",value = {
            @Result(property = "id",column = "Experimenters_id"),
            @Result(property = "waveform",column = "wave_data"),
            @Result(property = "equipment",column = "equipment"),
            @Result(property = "constructionSite",column = "construction_site"),
            @Result(property = "section",column = "section"),
            @Result(property = "author",column = "Experimenters"),
            @Result(property = "uploadDate",column = "upload_date"),
            @Result(property = "foundDate",column = "found_date")
    })
    @Select("select * from table_ultrasound where CONCAT(Experimenters_id,wave_data,equipment,construction_site,section,Experimenters,upload_date,found_date) like CONCAT('%',#{id},'%')")
    public List<Ultrasound> getUltrasoundList(String id);



    @ResultMap("ultrasounds")
    @Insert("insert into table_ultrasound (Experimenters_id,wave_data,equipment,construction_site,section,Experimenters,upload_date,found_date) " +
            "values (#{id},#{waveform},#{equipment},#{constructionSite},#{section},#{author},#{uploadDate},#{foundDate})")
    public int add(Ultrasound ultrasound);



    @ResultMap("ultrasounds")
    @Delete(" delete from table_ultrasound where Experimenters_id= #{id} ")
    public void del(int id);



    @ResultMap("ultrasounds")
    @Select("select * from table_ultrasound where Experimenters_id= #{id} ")
    public Ultrasound getUltrasound(int id);



    @ResultMap("ultrasounds")
    @Update("update table_ultrasound set " +
            "wave_data = #{waveform}," +
            "equipment = #{equipment}," +
            "construction_site = #{constructionSite}," +
            "section = #{section}," +
            "Experimenters = #{author}," +
            "upload_date = #{uploadDate}, " +
            "found_date = #{foundDate} " +
            "where Experimenters_id=#{id} ")
    public int update(Ultrasound ultrasound);

}
