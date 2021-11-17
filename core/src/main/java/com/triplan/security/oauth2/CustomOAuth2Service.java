package com.triplan.security.oauth2;

import com.triplan.domain.MemberVO;
import com.triplan.domain.RoleVO;
import com.triplan.enumclass.SNSProvider;
import com.triplan.exception.OAuth2ProviderException;
import com.triplan.exception.ResourceNotFoundException;
import com.triplan.mapper.MemberMapper;
import com.triplan.mapper.RoleMapper;
import com.triplan.security.MemberPrincipal;
import com.triplan.security.oauth2.userinfo.OAuth2UserInfo;
import com.triplan.security.oauth2.userinfo.OAuth2UserInfoFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomOAuth2Service extends DefaultOAuth2UserService {

    private final MemberMapper memberMapper;
    private final RoleMapper roleMapper;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        try {
            return processOAuth2User(userRequest, oAuth2User);
        } catch (ArithmeticException e) {
            throw e;
        } catch(Exception e) {
            throw new InternalAuthenticationServiceException(e.getMessage(), e.getCause());
        }
    }

    @Transactional
    private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
        OAuth2UserInfo userInfo = OAuth2UserInfoFactory.getUserInfo(
                userRequest.getClientRegistration().getRegistrationId(),
                oAuth2User.getAttributes()
        );

        // email 길이가 0이면 에러 발생
        if (!StringUtils.hasLength(userInfo.getEmail())) {
            throw new ResourceNotFoundException("Email Not Found");
        }

        MemberVO memberVO = memberMapper.selectByEmail(userInfo.getEmail());

        if (memberVO == null) {
            memberVO = registerNewMember(userRequest, userInfo);
        } else if (!isEmailRegistered(memberVO, userRequest)) {
            // 다른 SNS Provider를 통해 이미 가입된 이메일이면 에러 발생
            throw new OAuth2ProviderException(memberVO.getProvider().toString());
        }

        List<RoleVO> roleList = roleMapper.selectByMemberId(memberVO.getMemberId());

        return MemberPrincipal.create(memberVO, roleList, oAuth2User.getAttributes());
    }

    private boolean isEmailRegistered(MemberVO memberVO, OAuth2UserRequest userRequest) {
        String memberProvider = memberVO.getProvider().toString();
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        return memberProvider.equals(registrationId);
    }

    @Transactional
    private MemberVO registerNewMember(OAuth2UserRequest userRequest, OAuth2UserInfo userInfo) {
        MemberVO memberVO = new MemberVO();
        memberVO.setEmail(userInfo.getEmail());
        memberVO.setNickname(userInfo.getName());
        memberVO.setProfileImg(userInfo.getProfileImg());
        memberVO.setProvider(SNSProvider.valueOf(userRequest.getClientRegistration().getRegistrationId()));

        memberMapper.insert(memberVO);

        return memberVO;
    }

}
