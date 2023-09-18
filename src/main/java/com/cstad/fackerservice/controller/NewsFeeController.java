package com.cstad.fackerservice.controller;

import com.cstad.fackerservice.Client.JsonPlaceholderClient;
import com.cstad.fackerservice.Client.request.PostRequest;
import com.cstad.fackerservice.Client.response.PostResponse;
import com.cstad.fackerservice.config.HttpClientGenerator;
import com.cstad.fackerservice.model.dto.NewFeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class NewsFeeController {

    private final JsonPlaceholderClient jsonPlaceholderClient;

    // create constructor
    public  NewsFeeController(){
        jsonPlaceholderClient = HttpClientGenerator.createClientService(JsonPlaceholderClient.class);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/new-feed")
    public NewFeeDto loadNewFee(){
        List<PostResponse> posts = jsonPlaceholderClient.all();
        NewFeeDto newFeeDto = NewFeeDto.builder()
                .id(1l)
                .posts(posts)
                .timestamp(LocalDateTime.now())
                .build();
        return newFeeDto;
    }

    @GetMapping("/new-feed/{id}")
    public PostResponse findById( @PathVariable Integer id){
        return jsonPlaceholderClient.findById(id);
    }

    @PostMapping("/new-feed")
    public PostResponse savePost(@RequestBody PostRequest postRequest){
        return jsonPlaceholderClient.savaPost(postRequest);
    }

    @PutMapping("/new-feed/{id}")
    public PostResponse updatePost(@PathVariable Integer id , @RequestBody PostRequest postRequest){
        return jsonPlaceholderClient.updatePost(id,postRequest);
    }

}
