package com.example.test.service;

import com.example.test.model.Client;
import com.example.test.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
//En esta clase se crea toda la lógica de negocio, haciendo uso del repositorio el cual usa JPA.

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public ArrayList<Client> getClients(){
        return (ArrayList<Client>) clientRepository.findAll();
    }

    public Client saveClient(Client client){
        if(clientRepository.validateIdCard(client.getIdCard())!=0){
            throw new DuplicateKeyException("Ya existe un cliente con esa cedula. ");
        }
        System.out.println(client);
         return clientRepository.save(client);
    }

    public Optional<Client> getClientById(int id){
        return clientRepository.findById(id);
    }

    public Optional<Client> getClientByCard(String id){
        Optional<Client> client=clientRepository.findClientByIdCard(id);
        client.get();
        return client;
    }

    public boolean deleteClient(int id){
        try {
            clientRepository.deleteById(id);
            return true;
        }catch (Exception error){
            return false;
        }
    }

    public boolean updateClient(Client client, String id){
        try {
            Client originalClient=clientRepository.findClientByIdCard(id).get();
            originalClient.setName(client.getName());
            originalClient.setIdCard(client.getIdCard());
            clientRepository.save(originalClient);
            return true;
        }catch (Exception error){
            return false;
        }
    }
}
