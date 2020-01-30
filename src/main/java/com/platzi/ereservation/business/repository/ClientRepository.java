package com.platzi.ereservation.business.repository;

import com.platzi.ereservation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author dandrspc
 */
public interface ClientRepository extends JpaRepository<Client, String> {
    /**
     * Method definition for search clients by lastname
     * @param lastName
     * @return
     */
    public List<Client> findByLastName(String lastName);

    public Client findByIdentification(String identification);

}
