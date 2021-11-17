package hwkang.pictureMap;

import hwkang.pictureMap.auth.OAuthType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OAuthTest {

    @Test
    void findPictureServiceBeanSuccess() {
        //1. given
        String registrationId = "google";
        //2. when
        OAuthType oAuthType = OAuthType.findBy(registrationId);

        //3. then
        Assertions.assertThat(oAuthType.getPictureServiceBeanName()).isEqualTo("GooglePictureService");
    }

    @Test
    void findPictureServiceBeanFail() {
        //1. given
        String registrationId = "kakao";
        //2. when
        OAuthType oAuthType = OAuthType.findBy(registrationId);

        //3. then
        Assertions.assertThat(oAuthType.getPictureServiceBeanName()).isNotEqualTo("KakaoPictureService");
    }
}
