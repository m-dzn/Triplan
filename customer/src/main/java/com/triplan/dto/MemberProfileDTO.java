package com.triplan.dto;

import com.triplan.domain.MemberVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberProfileDTO {


    private Integer memberId;
    private String profileImg;
    private String nickname;

    public static MemberProfileDTO of (MemberVO memberVO){

        MemberProfileDTO dto = new MemberProfileDTO();

        dto.setMemberId(memberVO.getMemberId());
        dto.setProfileImg(memberVO.getProfileImg());
        dto.setNickname(memberVO.getNickname());

        return dto;
    }

    public MemberVO toVO() {

        MemberVO vo = new MemberVO();

        vo.setMemberId(memberId);
        vo.setProfileImg(profileImg);
        vo.setNickname(nickname);

        return vo;
    }

}
