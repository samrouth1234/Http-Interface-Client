package com.cstad.fackerservice.model.dto;

import com.cstad.fackerservice.Client.response.FakerResponse;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record NewFakerDto(
        Integer id,
        List <FakerResponse> faker,
        LocalDateTime timestamp){

}
