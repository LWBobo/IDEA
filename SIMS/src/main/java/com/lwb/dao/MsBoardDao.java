package com.lwb.dao;

import com.lwb.pojo.MsBoard;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MsBoardDao {

    /**
     * 添加一条留言
     * @param msboard
     * @return
     */
    @Insert("insert into msboard (uid,uname,mstitle,mskeyword,mscontents) values (#{uid},#{uname},#{mstitle},#{mskeyword},#{mscontents})")
    int addMessage(MsBoard msboard);


    /**
     * 删除一条留言记录
     * @param msid
     * @return
     */
    @Delete("delete from msboard where msid = #{msid}")
    int delMsessage(int msid);

    /**
     * 修改一条记录
     * @param msboard
     * @return
     */
    @Update({
            "<script>",
            "update msboard ",
            "<set>",
            "<if test='mstitle != null'>","mstitle = #{mstitle},","</if>",
            "<if test='mskeyword != null'>","mskeyword = #{mskeyword},","</if>",
            "<if test='mscontents != null'>","mscontents = #{mscontents},","</if>",
            "</set>",
            "where msid = #{msid}",
            "</script>"
    })
    int updatemessage(MsBoard msboard);

    /**
     * 查询所有留言信息
     * @return
     */
    @Select("select * from msboard")
    List<MsBoard> showAllMessage();


    /**
     * 查询某一个用户的所有留言信息
     * @param uid
     * @return
     */
    @Select("select * from msboard where uid = #{uid}")
    List<MsBoard> findByUid(String uid);
}
