package hwkang.pictureMap.picture.dto;

import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.File.ImageMediaMetadata.Location;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Picture {

    private String name;
    private String time;
    private String imageLink;
    private double latitude;
    private double longitude;

    @Builder
    public Picture(String name, String time, String imageLink, double latitude, double longitude) {
        this.name = name;
        this.time = time;
        this.imageLink = imageLink;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Check Required Parameter Values.
     * @param file ( Google File )
     * @return
     */
    public static boolean validation(File file) {
        if( ! file.getMimeType().startsWith("image")) {
            return false;
        }

        if(file.getImageMediaMetadata() == null) {
            return false;
        }

        if(file.getImageMediaMetadata().getLocation() == null) {
            return false;
        }

        return true;
    }

    /**
     * Google Data -> Picture Object
     * @param file (Google File)
     * @return
     */
    public static Picture ofGoogleData(File file) {
        final Location location = file.getImageMediaMetadata().getLocation();

        return Picture.builder()
                .name(file.getName())
                .time(file.getImageMediaMetadata().getTime())
                .imageLink(file.getThumbnailLink())
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .build();
    }
}
