package org.zerock.tourist_spring.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zerock.tourist_spring.member.dto.MemberDTO;
import org.zerock.tourist_spring.member.mapper.MemberMapper;
import org.zerock.tourist_spring.member.vo.MemberVO;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;
    public void addMember(MemberDTO memberDTO){
        MemberVO vo = MemberVO.builder()
                .id(memberDTO.getId())
                .name(memberDTO.getName())
                .email(memberDTO.getEmail())
                .password(memberDTO.getPassword())
                .phone(memberDTO.getPhone())
                .gender(memberDTO.getGender())
                .agree(memberDTO.isAgree())
                .content(memberDTO.getContent())
                .build();
        memberMapper.insertMember(vo);
    }
    @Override
    public MemberDTO getMember(String id, String pw){
        MemberVO vo = MemberVO.builder()
                .id(id)
                .password(pw)
                .build();
        vo = memberMapper.selectLogin(vo);
        // vo의 데이터가 null이라면 dto도 null을 반환하도록 설정
        MemberDTO dto = null;
        // vo가 null인 경우 controller에서 로그인 실패로 처리하게 됩니다
        if(vo != null){
            dto = MemberDTO.builder()
                    .id(vo.getId())
                    .email(vo.getEmail())
                    .name(vo.getName())
                    .password(vo.getPassword())
                    .phone(vo.getPhone())
                    .gender(vo.getGender())
                    .agree(vo.isAgree())
                    .content(vo.getContent())
                    .regidate(vo.getRegidate())
                    .build();
        }
        return dto;
    }
}
