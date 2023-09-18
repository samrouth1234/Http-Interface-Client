package com.cstad.fackerservice.model.dto;

import com.cstad.fackerservice.Client.response.PostResponse;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record NewFeeDto(
        Long id,
        List <PostResponse> posts,
        LocalDateTime timestamp) {

}
