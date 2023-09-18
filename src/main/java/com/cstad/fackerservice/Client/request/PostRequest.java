package com.cstad.fackerservice.Client.request;

public record PostRequest(
        Integer id,
        Integer userId,
        String title,
        String body) {
}
