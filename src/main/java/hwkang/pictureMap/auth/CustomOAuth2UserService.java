package hwkang.pictureMap.auth;

import hwkang.pictureMap.picture.service.PictureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final HttpSession httpSession;
    private final Map<String, PictureService> pictureServiceMap;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName();

        OAuthType oAuthType = OAuthType.findBy(registrationId);
        String beanName = oAuthType.getPictureServiceBeanName();
        PictureService pictureService = pictureServiceMap.get(beanName);

        OAuthAttributes attributes = OAuthAttributes.of(oAuthType, userNameAttributeName,
                oAuth2User.getAttributes(), pictureService);

        httpSession.setAttribute("user", new SessionUser(attributes));

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(Role.LOGIN_USER.getKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey()
        );
    }
}
