package com.triplan.security;

import com.triplan.domain.MemberVO;
import com.triplan.domain.RoleVO;
import com.triplan.enumclass.MemberState;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class MemberPrincipal implements UserDetails, OAuth2User {

    private Integer memberId;
    private String email;
    private String name;
    private String password;

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
        this.name = memberVO.getNickname();
        this.password = memberVO.getPassword();
        this.authorities = authorities;

        this.enabled = memberVO.getState().equals(MemberState.REGISTER);
        this.accountNonExpired = this.accountNonLocked = this.credentialsNonExpired = true;
    }

    public static MemberPrincipal create(MemberVO memberVO, List<RoleVO> roleList) {
        Set<GrantedAuthority> authorities = roleList.stream().map(role
                -> new SimpleGrantedAuthority(role.getName().name())
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

}
