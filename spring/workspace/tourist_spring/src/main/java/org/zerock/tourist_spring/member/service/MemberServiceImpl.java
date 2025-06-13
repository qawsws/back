package org.zerock.tourist_spring.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zerock.tourist_spring.board.dto.BoardDTO;
import org.zerock.tourist_spring.board.vo.BoardVO;
import org.zerock.tourist_spring.member.dto.MemberDTO;
import org.zerock.tourist_spring.member.mapper.MemberMapper;
import org.zerock.tourist_spring.member.vo.MemberVO;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;
    @Override
    public void join(MemberDTO memberDTO){
        MemberVO memberVO = MemberVO.builder()
                .id(memberDTO.getId())
                .email(memberDTO.getEmail())
                .name(memberDTO.getName())
                .password(memberDTO.getPassword())
                .phone(memberDTO.getPhone())
                .gender(memberDTO.getGender())
                .agree(memberDTO.isAgree())
                .content(memberDTO.getContent())
                .build();
        memberMapper.insertMember(memberVO);
    }

}
