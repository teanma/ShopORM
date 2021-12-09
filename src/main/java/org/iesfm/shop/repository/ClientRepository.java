package org.iesfm.shop.repository;

import org.iesfm.shop.Article;
import org.iesfm.shop.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
