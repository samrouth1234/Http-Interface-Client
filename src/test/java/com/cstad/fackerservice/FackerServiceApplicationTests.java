package com.cstad.fackerservice;

import com.cstad.fackerservice.Client.FakerPublicClient;
import com.cstad.fackerservice.Client.request.FakerRequest;
import com.cstad.fackerservice.Client.request.PostRequest;
import com.cstad.fackerservice.Client.response.FakerResponse;
import com.cstad.fackerservice.Client.response.PostResponse;
import com.cstad.fackerservice.config.HttpClientGenerator;
import com.cstad.fackerservice.Client.JsonPlaceholderClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FackerServiceApplicationTests {

    @Test
    void jsonPlaceHolder() {
        JsonPlaceholderClient client = HttpClientGenerator.createClientService(JsonPlaceholderClient.class);
        System.out.print(client.all());
    }

    @Test
    void findById() {
        JsonPlaceholderClient client = HttpClientGenerator.createClientService(JsonPlaceholderClient.class);
        System.out.print(client.findById(1));
    }

    @Test
    void createPost(){
        PostRequest postRequest = new PostRequest(1,23,"My post","My Post Application");
        JsonPlaceholderClient client = HttpClientGenerator.createClientService(JsonPlaceholderClient.class);
        PostResponse postResponse = client.savaPost(postRequest);
        System.out.println(postResponse);
    }

    @Test
    void updatePost(){
        PostRequest postRequest = new PostRequest(1,23,"My post","My Post Application");
        JsonPlaceholderClient client = HttpClientGenerator.createClientService(JsonPlaceholderClient.class);
        PostResponse postResponse = client.updatePost(1,postRequest);
        System.out.println(postResponse);
    }


    @Test
    void FindAllFaker() {
        FakerPublicClient client = HttpClientGenerator.createClientService(FakerPublicClient.class);
        System.out.print(client.getAllFaker());
    }

    @Test
    void FindByIdFaker() {
        FakerPublicClient client = HttpClientGenerator.createClientService(FakerPublicClient.class);
        System.out.print(client.findById(1));
    }

    @Test
    void create(){
        FakerRequest fakerRequest = new FakerRequest(1,"My Post",123,"My Post Application","books");
        FakerPublicClient client = HttpClientGenerator.createClientService(FakerPublicClient.class);
        FakerResponse fakerResponse = client.savaPost(fakerRequest);
        System.out.println(fakerResponse);
    }

    @Test
    void updateProduct(){
        FakerRequest fakerRequest = new FakerRequest(1,"My Post",123,"My Post Application","books");
        FakerPublicClient client = HttpClientGenerator.createClientService(FakerPublicClient.class);
        FakerResponse fakerResponse = client.updateProducts(1,fakerRequest);
        System.out.println(fakerResponse);
    }

    @Test
    void DeletedFaker() {
        FakerPublicClient client = HttpClientGenerator.createClientService(FakerPublicClient.class);
        FakerResponse fakerResponse = client.deleteById(1);
        System.out.println(fakerResponse);

    }

}
