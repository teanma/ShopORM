package org.iesfm.shop.repository;

import org.iesfm.shop.Article;
import org.iesfm.shop.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByClientId(int clientId);
}
