package hwkang.pictureMap.picture.service.impl;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.DriveScopes;
import hwkang.pictureMap.picture.dto.Picture;
import hwkang.pictureMap.picture.service.PictureService;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
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
