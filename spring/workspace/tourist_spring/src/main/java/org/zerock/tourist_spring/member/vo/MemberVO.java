package org.zerock.tourist_spring.member.vo;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberVO {
    private String id;
    private String email;
    private String name;
    private String password;
    private String phone;
    private String gender;
    private boolean agree;
    private String content;
    private String regidate;
}
