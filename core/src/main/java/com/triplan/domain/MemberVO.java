package com.triplan.domain;



import com.triplan.enumclass.Gender;
import com.triplan.enumclass.MemberGrade;
import com.triplan.enumclass.State;
import lombok.Data;


import java.util.Date;

@Data


public class MemberVO {

    private Integer memberId;
    private String email;
    private String password;
    private String nickname;
    private String state;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private String emailConfirm;
    private Integer point;
    private String account;
    private MemberGrade grade;
    private String profileImg;
    private Gender gender;
    private String birthday;
    private String mobile;
    private String address;
    private String  snsInfo;


    public static void main(String[] args){
        MemberVO vo = new MemberVO();
        vo.setGrade(MemberGrade.BRONZE);
        vo.setGender(Gender.FEMALE);


        System.out.println(vo.getGrade());
        System.out.println(vo.getGrade().getCode());


        System.out.println(vo.getGender());
        System.out.println(vo.getGender().getCode());
        System.out.println(vo.getGender().getExplain());


    }
}
