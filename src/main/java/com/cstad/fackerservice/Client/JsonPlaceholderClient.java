package com.cstad.fackerservice.Client;

import com.cstad.fackerservice.Client.request.PostRequest;
import com.cstad.fackerservice.Client.response.PostResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

@HttpExchange("https://jsonplaceholder.typicode.com")
public interface JsonPlaceholderClient {
    @GetExchange("/posts")
    List<PostResponse> all();

    @PostExchange("/posts")
    PostResponse savaPost( @RequestBody PostRequest postRequest);

    @PutExchange("/posts/{id}")
    PostResponse updatePost(@PathVariable Integer id,@RequestBody PostRequest postRequest);

    @GetExchange("/posts/{id}")
    PostResponse findById(@PathVariable Integer id);



}
