package org.zerock.springtest.member.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.zerock.springtest.member.vo.MemberVO;

@Mapper
public interface MemberMapper {
    void insertMember(MemberVO memberVO);
    MemberVO selectLogin(MemberVO memberVO);
    MemberVO selectOne(@Param("id") String id, @Param("pw") String pw);
    void deleteMember(String id);
}
