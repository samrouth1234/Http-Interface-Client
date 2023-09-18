package com.cstad.fackerservice.Client.request;

public record FakerRequest(
        Integer id,
        String title,
        Integer price,
        String description,
        String category) {

}
