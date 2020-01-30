package com.platzi.ereservation.business.services;

import com.platzi.ereservation.business.repository.ClientRepository;
import com.platzi.ereservation.model.Client;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase para definir los servicios del cliente
 */
@Service
@Transactional(readOnly = true)
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Método para realizar la operación de guardar un cliente
     * @param client
     * @return
     */
    @Transactional
    public Client create (Client client){
        return this.clientRepository.save(client);
    }

    /**
     *
     * @param client
     * @return
     */
    @Transactional
    public Client update (Client client){
        return this.clientRepository.save(client);
    }

    /**
     *
     * @param client
     */
    @Transactional
    public void delete(Client client){
        this.clientRepository.delete(client);
    }

    /**
     *
     * @param identification
     * @return
     */
    public Client findByIdentification(String identification){
        return this.clientRepository.findByIdentification(identification);
    }

    public List<Client> findAll(){
        return this.clientRepository.findAll();
    }
}
