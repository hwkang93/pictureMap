package hwkang.pictureMap.auth;

import hwkang.pictureMap.picture.service.PictureService;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter @ToString
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;
    private PictureService pictureService;

    public SessionUser(OAuthAttributes attributes) {
        this.name = attributes.getName();
        this.email = attributes.getEmail();
        this.picture = attributes.getPicture();
        this.pictureService = attributes.getPictureService();
    }
}
