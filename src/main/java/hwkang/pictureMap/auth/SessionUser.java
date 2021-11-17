package hwkang.pictureMap.auth;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(OAuthAttributes attributes) {

    }
}
