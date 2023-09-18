package com.cstad.fackerservice.Client;

import com.cstad.fackerservice.Client.request.FakerRequest;
import com.cstad.fackerservice.Client.response.FakerResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.*;

import java.util.List;

@HttpExchange(url = "https://fakestoreapi.com")
public interface FakerPublicClient {

    @GetExchange("/products")
    List <FakerResponse> getAllFaker();

    @GetExchange("/products/{id}")
    FakerResponse findById(@PathVariable Integer id);

    @PostExchange("/products")
    FakerResponse savaPost( @RequestBody FakerRequest fakerRequest);

    @PutExchange("/products/{id}")
    FakerResponse updateProducts(@PathVariable Integer id , @RequestBody FakerRequest fakerRequest);

    @DeleteExchange("/products/{id}")
    FakerResponse deleteById(@PathVariable Integer id);

}
