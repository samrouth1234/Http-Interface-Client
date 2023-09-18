package com.cstad.fackerservice.Client.response;

public record FakerResponse(Integer id,
                            String title,
                            Integer price,
                            String description,
                            String category) {
}
