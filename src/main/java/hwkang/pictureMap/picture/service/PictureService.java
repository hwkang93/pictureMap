package hwkang.pictureMap.picture.service;

import hwkang.pictureMap.picture.dto.Picture;

import java.io.IOException;
import java.util.List;

public interface PictureService {

    List<Picture> findList() throws IOException;

}
