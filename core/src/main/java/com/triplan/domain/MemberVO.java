package com.triplan.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
public class MemberVO {
    private Long member_id;
    private String email;
    private String password;
    private String nickname;
    private String state;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
    private String email_confirm;
    private Long point;
    private String account;
    private String grade;
    private String profile_img;
    private String gender;
    private String birthday;
    private String mobile;
    private String address;
    private String sns_info;


}
