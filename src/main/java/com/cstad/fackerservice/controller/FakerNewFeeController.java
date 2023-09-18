package com.cstad.fackerservice.controller;

import com.cstad.fackerservice.Client.FakerPublicClient;
import com.cstad.fackerservice.Client.request.FakerRequest;
import com.cstad.fackerservice.Client.response.FakerResponse;
import com.cstad.fackerservice.config.HttpClientGenerator;
import com.cstad.fackerservice.model.dto.NewFakerDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class FakerNewFeeController {

    private final FakerPublicClient fakerPublicClient;

    public  FakerNewFeeController (){
        fakerPublicClient = HttpClientGenerator.createClientService(FakerPublicClient.class);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/new-faker")
    public NewFakerDto localNew(){
        List<FakerResponse> faker = fakerPublicClient.getAllFaker();

        NewFakerDto newFakerDto = NewFakerDto.builder()
                .id(1)
                .faker(faker)
                .timestamp(LocalDateTime.now())
                .build();
        return newFakerDto;
    }

    @GetMapping("/new-faker/{id}")
    public FakerResponse findById( @PathVariable Integer id){
        return fakerPublicClient.findById(id);
    }

    @DeleteMapping("/new-faker/{id}")
    public FakerResponse deleteById(@PathVariable Integer id){
        return fakerPublicClient.deleteById(id);
    }

    @PostMapping("/new-faker")
    public FakerResponse saveFaker(@RequestBody FakerRequest fakerRequest){
        return fakerPublicClient.savaPost(fakerRequest);
    }

    @PutMapping("/new-faker/{id}")
    public FakerResponse updateFaker(@PathVariable Integer id , @RequestBody FakerRequest fakerRequest){
        return fakerPublicClient.updateProducts(id,fakerRequest);
    }

}
