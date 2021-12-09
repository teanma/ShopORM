package org.iesfm.shop.controller;

import org.iesfm.shop.Article;
import org.iesfm.shop.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/articles")
    public List<Article> list() {
        return articleRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/articles/{id}")
    public Article get(@PathVariable("id") int id) {
        // Podría ser null o un artículo
        Optional<Article> articleOptional = articleRepository.findById(id);
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


    @RequestMapping(method = RequestMethod.POST, path = "/articles")
    public void insert(@RequestBody Article article) {
        articleRepository.save(article);
    }
}
