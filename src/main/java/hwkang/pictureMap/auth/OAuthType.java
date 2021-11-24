package hwkang.pictureMap.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum OAuthType {
    GOOGLE("google", "googlePictureService"),
    NAVER("naver", "naverPictureService"),
    KAKAO("kakao", "kakaoPictureService");

    private final String registrationId;
    private final String pictureServiceBeanName;

    public static OAuthType findBy(String registrationId) {

        return Arrays.asList(OAuthType.values()).stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not found OAuthType. Request registrationId : " + registrationId));
    }
}
