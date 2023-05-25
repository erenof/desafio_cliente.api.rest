package com.coderhouse.cliente.api.rest.service;

import com.coderhouse.cliente.api.rest.model.Client;
import com.coderhouse.cliente.api.rest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Method to save a client
    public Client postClient(Client client) throws Exception {
        return clientRepository.save(client);
    }

    // Method to get client age
    public Object getClient(int id) throws Exception {
        Optional<Client> client = clientRepository.findById(id);

        if(client.isEmpty()){
            return null;
        } else {
            Client clientExist = client.get();
            LocalDate birthDate = clientExist.getBirthDate();
            LocalDate actualDate = LocalDate.now();
            int age = Period.between(birthDate, actualDate).getYears();

            return age;
        }
    }




}
