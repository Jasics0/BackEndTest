package com.example.test.controller;

import com.example.test.model.Client;
import com.example.test.service.ClientService;
import com.example.test.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

// Única clase que se comunica con el exterior

@RestController
@RequestMapping("/clientes")
public class ClientController {
    @Autowired
    ClientService clientService;
    @Autowired
    LoginService loginService;

    @GetMapping()
    public ArrayList<Client> getClients() {
        return clientService.getClients();
    }

    @PostMapping()
    public Client saveClient(@RequestBody Client client) {
        if(client.getName()=="null" ||client.getIdCard()=="null" ){
            throw new NullPointerException("Verifique que los datos necesarios fueron ingresados.");
        }
        return clientService.saveClient(client);
    }

    @GetMapping(path = "/{id}")
    public Optional<Client> getClientById(@PathVariable("id") String id) {
        return clientService.getClientByCard(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteClientById(@PathVariable("id") int id) {
        boolean done = clientService.deleteClient(id);
        return (done) ? "Se eliminó el cliente con id: " + id : "No se pudo eliminar el cliente";
    }

    @PutMapping(path = "/{id}")
    public String updateClientById(@RequestBody Client client, @PathVariable("id") String id) {
        boolean done = clientService.updateClient(client,id);
        return (done) ? "Se actualizó el cliente con id: " + id : "No se pudo actualizar el cliente";
    }
}
