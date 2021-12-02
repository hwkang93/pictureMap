package hwkang.pictureMap.picture.controller;

import hwkang.pictureMap.annotation.loginUser.LoginUser;
import hwkang.pictureMap.auth.SessionUser;
import hwkang.pictureMap.common.response.BasicResponse;
import hwkang.pictureMap.common.response.SuccessResponse;
import hwkang.pictureMap.picture.dto.Picture;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PictureRestController {

    @GetMapping("/pictures")
    public ResponseEntity<BasicResponse> findAll(@LoginUser SessionUser user) throws Exception {
        /**
         * 건수가 하나도 없을 경우 어떻게 할 건지 생각해봐야함.
         * 평균적인 조회 시간
         *
         * 캐싱할 수 있는 정보 있는지 ?
         */
        List<Picture> pictureList = user.getPictureService().pictureList();

        return ResponseEntity.ok().body(new SuccessResponse<>(pictureList));
    }

}
