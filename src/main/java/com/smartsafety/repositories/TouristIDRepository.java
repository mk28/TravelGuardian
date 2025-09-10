package com.smartsafety.repositories;

import com.smartsafety.models.TouristID;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TouristIDRepository extends MongoRepository<TouristID, String> {
}
