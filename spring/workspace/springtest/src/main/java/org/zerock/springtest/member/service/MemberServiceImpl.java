package org.zerock.springtest.member.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zerock.springtest.member.dto.MemberDTO;
import org.zerock.springtest.member.mapper.MemberMapper;
import org.zerock.springtest.member.vo.MemberVO;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;
    @Override
    public MemberDTO getMember(String id, String pw) {
        MemberVO vo = MemberVO.builder()
                .id(id)
                .pw(pw)
                .build();
        vo = memberMapper.selectLogin(vo);

        MemberDTO dto = null;

        if (vo != null) {

            dto = MemberDTO.builder()
                    .id(vo.getId())
                    .pw(vo.getPw())
                    .name(vo.getName())
                    .email(vo.getEmail())
                    .regiDate(vo.getRegidate())
                    .build();
        }
        return dto;
    }

    @Override
    public void addMember(MemberDTO memberDTO) {
        MemberVO vo = MemberVO.builder()
                .id(memberDTO.getId())
                .pw(memberDTO.getPw())
                .name(memberDTO.getName())
                .email(memberDTO.getEmail())
                .build();

        memberMapper.insertMember(vo);
    }

    @Override
    public void removeMember(String id) {
        memberMapper.deleteMember(id);
    }
}
