package org.zerock.springtest.member.vo;

import lombok.*;

@Data
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberVO {
    private String id;
    private String pw;
    private String name;
    private String email;
    private String regidate;
}
