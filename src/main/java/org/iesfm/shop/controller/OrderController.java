package org.iesfm.shop.controller;

import org.iesfm.shop.Order;
import org.iesfm.shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/clients/{clientId}/orders")
    public List<Order> list(@PathVariable("clientId") int clientId) {
        return orderRepository.findByClientId(clientId);
    }

}
