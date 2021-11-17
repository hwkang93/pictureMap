package hwkang.pictureMap.auth;

import hwkang.pictureMap.picture.service.PictureService;
import hwkang.pictureMap.picture.service.impl.GooglePictureService;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;
    private PictureService pictureService;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name,
                           String email, String picture, PictureService pictureService) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.pictureService = pictureService;
    }

    public static OAuthAttributes of(OAuthType oAuthType, String userNameAttributeName,
                                     Map<String, Object> attributes, PictureService pictureService) {

        return ofGoogle(userNameAttributeName, attributes, pictureService);
    }

    public static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes, PictureService pictureService) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .pictureService(pictureService)
                .build();
    }
}
