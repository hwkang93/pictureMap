package hwkang.pictureMap.main;

import hwkang.pictureMap.annotation.loginUser.LoginUser;
import hwkang.pictureMap.auth.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainView(@LoginUser SessionUser loginUser) {
        if(loginUser == null) {
            return "redirect:/login";
        }

        return "main";
    }
}
