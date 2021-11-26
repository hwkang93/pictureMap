package hwkang.pictureMap.picture.service.impl;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import hwkang.pictureMap.picture.dto.Picture;
import hwkang.pictureMap.picture.service.PictureService;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


//참조 URL : https://cfdf.tistory.com/10

/*
    client_secret.json 파일에 있는 client-email 은 진짜 이메일이었음.
    본 구글 계정에 폴더 및 파일을 만들고 client-email 에 공유를 해야 client-email 에서 확인이 가능함.
 */
@Service
public class GooglePictureService implements PictureService {

    private final String KEY_FILE = "client_secret.json";
    private final String APP_NAME = "picture-map";
    private final List<String> SCOPES = Arrays.asList(DriveScopes.DRIVE);

    private final Drive drive;

    public GooglePictureService() throws IOException, GeneralSecurityException {
        final InputStream keyFile = ResourceUtils.getURL("classpath:" + KEY_FILE).openStream();
        final Credential credential = GoogleCredential.fromStream(keyFile).createScoped(SCOPES);
        final NetHttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();

        drive = new Drive.Builder(transport, JacksonFactory.getDefaultInstance(), credential)
                .setApplicationName(APP_NAME)
                .build();

        /*
        UserCredentials.newBuilder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setRefreshToken(credential.getRefreshToken())
                .build();

        PhotosLibrarySettings settings =
                PhotosLibrarySettings.newBuilder()
                        .setCredentialsProvider(FixedCredentialsProvider.create(credential))
                        .build();
         */
    }

    @Override
    public List<Picture> pictureList() throws Exception {
        final FileList fileList = drive.files().list()
                .setFields("nextPageToken, files(thumbnailLink,imageMediaMetadata,name,mimeType)")
                .execute();

        return fileList.getFiles().stream()
                .filter(Picture::validation)
                .map(Picture::ofGoogleData)
                .collect(Collectors.toList());
    }

}
