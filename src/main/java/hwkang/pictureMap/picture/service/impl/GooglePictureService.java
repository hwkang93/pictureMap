package hwkang.pictureMap.picture.service.impl;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files;
import com.google.api.services.drive.DriveScopes;
import hwkang.pictureMap.picture.dto.Picture;
import hwkang.pictureMap.picture.service.PictureService;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

/*
    https://developers.google.com/drive/api/v3/quickstart/java#prerequisites
    https://developers.google.com/drive/activity/v2/quickstart/java

    * 코틀린이긴 한데 참고하면 좋을 것 같음
    https://jsonobject.tistory.com/561
 */
@Service
public class GooglePictureService implements PictureService {

    private Drive drive;

    private GooglePictureService() throws IOException, GeneralSecurityException {
        String appName = "picture-map";
        String keyFileName = "client_secret.json";
        InputStream keyFile = ResourceUtils.getURL("classpath:"+keyFileName).openStream();

        GoogleCredential credential = GoogleCredential.fromStream(keyFile).createScoped(Arrays.asList(DriveScopes.DRIVE));
        NetHttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();

        drive = new Drive.Builder(transport, JacksonFactory.getDefaultInstance(), credential).setApplicationName(appName).build();
    }

    @Override
    public List<Picture> findList() throws IOException {

        Files files = drive.files();
        Files.List fileList = files.list();

        fileList.forEach(System.out::printf);



        return null;
    }
}
