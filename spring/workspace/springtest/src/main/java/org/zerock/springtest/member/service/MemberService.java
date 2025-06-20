package org.zerock.springtest.member.service;

import org.zerock.springtest.member.dto.MemberDTO;

public interface MemberService {
    void addMember(MemberDTO memberDTO);
    MemberDTO getMember(String id, String pw);
    void removeMember(String id);
}
