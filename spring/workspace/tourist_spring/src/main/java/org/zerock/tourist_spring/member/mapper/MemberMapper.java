package org.zerock.tourist_spring.member.mapper;

import org.zerock.tourist_spring.member.vo.MemberVO;

public interface MemberMapper {
    String getTime();
    void insertMember(MemberVO memberVO);
}

