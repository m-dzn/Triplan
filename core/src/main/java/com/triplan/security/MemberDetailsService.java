package com.triplan.security;

import com.triplan.domain.MemberVO;
import com.triplan.domain.RoleVO;
import com.triplan.mapper.MemberMapper;
import com.triplan.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    private final MemberMapper memberMapper;
    private final RoleMapper roleMapper;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MemberVO memberVO = memberMapper.selectByEmail(email);
        List<RoleVO> roleList = roleMapper.selectByMemberId(memberVO.getMemberId());

        return MemberPrincipal.create(memberVO, roleList);
    }

    @Transactional
    public UserDetails loadUserById(Integer id) throws UsernameNotFoundException {
        MemberVO memberVO = memberMapper.select(id);
        List<RoleVO> roleList = roleMapper.selectByMemberId(id);

        return MemberPrincipal.create(memberVO, roleList);
    }

}
