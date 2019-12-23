package com.practice.ssm.dao;

import com.practice.ssm.daomain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {

    @Select("select * from member where id=#{id}")
    Member findById(String id) throws Exception;

}
