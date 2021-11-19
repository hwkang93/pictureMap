package hwkang.pictureMap.picture.controller;

import hwkang.pictureMap.picture.dto.Picture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PictureRestController {

    @GetMapping("/pictures")
    public List<Picture> findAll() {

        return new ArrayList<>();
    }

}
