package com.coderhouse.cliente.api.rest.repository;

import com.coderhouse.cliente.api.rest.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    // Custom query to get client age
    //Atentos con Client, así se llama la entidad en nuestro programa.
    @Query("SELECT birthDate FROM Client a WHERE id = :id")
    Integer getAgebyID(@Param("id") int id);

}
