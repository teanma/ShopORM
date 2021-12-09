package org.iesfm.shop.controller;

import org.iesfm.shop.Article;
import org.iesfm.shop.Client;
import org.iesfm.shop.repository.ArticleRepository;
import org.iesfm.shop.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/clients")
    public List<Client> list() {
        return clientRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/clients/{id}")
    public Client get(@PathVariable("id") int id) {
        // Podría ser null o un artículo
        Optional<Client> articleOptional = clientRepository.findById(id);
//        return articleOptional
//                .orElseThrow(
//                        () ->
//                                new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra el artículo")
//                );

        if (articleOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra el artículo");
        } else {
            return articleOptional.get();
        }
    }


    @RequestMapping(method = RequestMethod.POST, path = "/clients")
    public void insert(@RequestBody Client client) {
        if(clientRepository.existsById(client.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe el cliente");
        } else {
            clientRepository.save(client);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/clients/{id}")
    public void update(@RequestBody Client client) {
        if(!clientRepository.existsById(client.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el cliente");
        } else {
            clientRepository.save(client);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/clients/{id}")
    public void delete(@PathVariable("id") int id) {
        if(clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el cliente");
        }
    }

}
