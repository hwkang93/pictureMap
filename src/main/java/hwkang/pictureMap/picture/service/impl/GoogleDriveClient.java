package hwkang.pictureMap.picture.service.impl;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Arrays;

@Component
public class GoogleDriveClient {

    private Drive drive;

    public GoogleDriveClient() throws IOException, GeneralSecurityException {
        String appName = "picture-map";
        String keyFileName = "client_secret.json";
        InputStream keyFile = ResourceUtils.getURL("classpath:"+keyFileName).openStream();

        GoogleCredential credential = GoogleCredential.fromStream(keyFile).createScoped(Arrays.asList(DriveScopes.DRIVE));
        NetHttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();

        drive = new Drive.Builder(transport, JacksonFactory.getDefaultInstance(), credential).setApplicationName(appName).build();
    }

    public void getFileList() {

    }
}
