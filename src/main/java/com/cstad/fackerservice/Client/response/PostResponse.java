package com.cstad.fackerservice.Client.response;

public record PostResponse(
        Integer id,
        Integer userId,
        String title,
        String body) {

}
