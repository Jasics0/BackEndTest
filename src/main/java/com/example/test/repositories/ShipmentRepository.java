package com.example.test.repositories;

import com.example.test.model.Shipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends CrudRepository<Shipment,Integer> {

    @Query(nativeQuery = true, value = "select COUNT(*) from shipments where num_guide = ?1")
    int validateGuide(String numGuide);
}
