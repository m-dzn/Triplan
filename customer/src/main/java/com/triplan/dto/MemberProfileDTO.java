package com.triplan.dto;

import com.triplan.domain.MemberVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class MemberProfileDTO {

    private Integer memberId;
    private String profileImg;

    @NotBlank
    @Pattern(regexp="^[ㄱ-ㅎ가-힣a-zA-Z0-9]{2,20}$")
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
