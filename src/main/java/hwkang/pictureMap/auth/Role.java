package hwkang.pictureMap.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    LOGIN_USER("ROLE_LOGIN", "로그인 사용자"),
    NOT_LOGIN_USER("ROLE_NOT_LOGIN", "비로그인 사용자");

    private final String key;
    private final String title;
}
