package com.smartsafety.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.Date;

@Data
@Document(collection = "alerts")
public class Alert {
    @Id
    private String id;

    private String type; // SOS, GEOFENCE, etc.
    private String deviceId;
    private String userId;
    private Date timestamp = new Date();

    private double lat;
    private double lon;
    private boolean resolved = false;
}
