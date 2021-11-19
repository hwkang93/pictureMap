package hwkang.pictureMap.picture.service.impl;

import hwkang.pictureMap.picture.dto.Picture;
import hwkang.pictureMap.picture.service.PictureService;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    https://developers.google.com/drive/api/v3/quickstart/java#prerequisites
    https://developers.google.com/drive/activity/v2/quickstart/java

    * 코틀린이긴 한데 참고하면 좋을 것 같음
    https://jsonobject.tistory.com/561
 */
@Service
public class GooglePictureService implements PictureService {

    @Override
    public List<Picture> findList() {

        return null;
    }
}
