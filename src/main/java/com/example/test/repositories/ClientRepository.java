package com.example.test.repositories;

import com.example.test.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Uso de JPA con un modelo
@Repository
public interface ClientRepository extends CrudRepository<Client,Integer> {
    @Query(nativeQuery = true, value = "select COUNT(*) from clients where id_card = ?1")
    int validateIdCard(String idCard);

    abstract Optional<Client> findClientByIdCard(String idCard);

}
