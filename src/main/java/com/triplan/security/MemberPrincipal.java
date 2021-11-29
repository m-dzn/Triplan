package com.triplan.security;

import com.triplan.domain.member.MemberVO;
import com.triplan.domain.member.RoleVO;
import com.triplan.enumclass.member.MemberState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@ToString
public class MemberPrincipal implements UserDetails, OAuth2User {

    private Integer memberId;
    private String email;
    private String nickname;
    private String password;
    private String profileImg;

    private Set<? extends GrantedAuthority> authorities;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @Setter
    private Map<String, Object> attributes;

    public MemberPrincipal(MemberVO memberVO, Set<? extends GrantedAuthority> authorities) {
        this.memberId = memberVO.getMemberId();
        this.email = memberVO.getEmail();
        this.nickname = memberVO.getNickname();
        this.password = memberVO.getPassword();
        this.profileImg = memberVO.getProfileImg();
        this.authorities = authorities;

        this.enabled = MemberState.REGISTER.equals(memberVO.getState());
        this.accountNonExpired = this.accountNonLocked = this.credentialsNonExpired = true;
    }

    public static MemberPrincipal create(MemberVO memberVO, List<RoleVO> roleList) {
        Set<GrantedAuthority> authorities = roleList.stream().map(role
                -> new SimpleGrantedAuthority(role.getName().getKey())
        ).collect(Collectors.toSet());

        return new MemberPrincipal(memberVO, authorities);
    }

    public static MemberPrincipal create(MemberVO memberVO, List<RoleVO> roleList, Map<String, Object> attributes) {
        MemberPrincipal memberPrincipal = MemberPrincipal.create(memberVO, roleList);
        memberPrincipal.setAttributes(attributes);

        return memberPrincipal;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getName() {
        return nickname;
    }

}
