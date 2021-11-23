package hwkang.pictureMap.auth;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter @ToString
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(OAuthAttributes attributes) {
        this.name = attributes.getName();
        this.email = attributes.getEmail();
        this.picture = attributes.getPicture();
    }
}
