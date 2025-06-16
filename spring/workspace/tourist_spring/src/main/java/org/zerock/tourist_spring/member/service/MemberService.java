package org.zerock.tourist_spring.member.service;

import org.zerock.tourist_spring.member.dto.MemberDTO;

public interface MemberService {
    void addMember(MemberDTO memberDTO);
    MemberDTO getMember(String id, String pw);
}
