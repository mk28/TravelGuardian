package com.smartsafety.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

import java.util.Date;

@Data
@Document(collection = "tourist_ids")
public class TouristID {
    @Id
    private String id;

    private String touristName;
    private String nationality;
    private Date issueDate;
    private Date expiryDate;
    private String ownerUserId;
}
