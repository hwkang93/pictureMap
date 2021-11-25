package hwkang.pictureMap.picture.controller;

import hwkang.pictureMap.annotation.loginUser.LoginUser;
import hwkang.pictureMap.auth.SessionUser;
import hwkang.pictureMap.picture.dto.Picture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class PictureRestController {

    @GetMapping("/pictures")
    public List<Picture> findAll(@LoginUser SessionUser user) throws Exception {

        List<Picture> resultList = user.getPictureService().findList();

        return resultList;
    }

}
