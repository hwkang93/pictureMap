package hwkang.pictureMap.picture.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Picture {
    private String title;
    private String description;
    private LocalDateTime time;
    private GeoLocation location;
}
