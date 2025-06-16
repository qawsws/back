package org.zerock.tourist_spring.member.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.tourist_spring.member.vo.MemberVO;

public interface MemberMapper {
    String getTime();
    void insertMember(MemberVO memberVO);
    MemberVO selectLogin(MemberVO memberVO);
//  마이바티스에서 두개 이상의 매개변수를 사용할 경우
//  @Param 어노테이션 사용하여 변수마다 이름을 설정해야 xml에서 인식이 가능함.
    MemberVO selectLogin2(@Param("id") String id, @Param("pw") String pw);
}
