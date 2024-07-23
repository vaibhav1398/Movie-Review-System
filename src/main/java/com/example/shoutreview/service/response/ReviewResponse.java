package com.example.shoutreview.service.response;

import lombok.*;

@Data
@Builder
public class ReviewResponse {
    //this is data which will be showed to end user
    //so only add info which we need to show
    private String review;
    private Double rating;
}
