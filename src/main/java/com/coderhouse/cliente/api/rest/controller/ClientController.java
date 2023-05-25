package com.coderhouse.cliente.api.rest.controller;

import com.coderhouse.cliente.api.rest.middleware.ResponseHandler;
import com.coderhouse.cliente.api.rest.model.Client;
import com.coderhouse.cliente.api.rest.repository.ClientRepository;
import com.coderhouse.cliente.api.rest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Create client
    @PostMapping(path = "/save")
    public ResponseEntity<Object> postClient(@RequestBody Client client) {
        try{
            System.out.println(client);
            Client clientSaved = clientService.postClient(client);
            return ResponseHandler.generateResponse(
                    "Client successfully created.",
                    HttpStatus.OK,
                    clientSaved
            );
        } catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    // Get client
    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getClientAge(@PathVariable() int id) {
        try {
            Object clientFound = clientService.getClientAge(id);
            return ResponseHandler.generateResponse(
                    "Client age retrieved",
                    HttpStatus.OK,
                    clientFound
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }


}
