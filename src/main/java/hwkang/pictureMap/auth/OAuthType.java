package hwkang.pictureMap.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.function.Supplier;

@RequiredArgsConstructor
@Getter
public enum OAuthType {
    GOOGLE("google", "GooglePictureService"),
    NAVER("naver", "NaverPictureService"),
    KAKAO("kakao", "KakaoPictureService");

    private final String registrationId;
    private final String pictureServiceBeanName;

    public static OAuthType findBy(String registrationId) {

        return Arrays.asList(OAuthType.values()).stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not found OAuthType. Request registrationId : " + registrationId));
    }
}
