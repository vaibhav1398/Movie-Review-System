package com.example.shoutreview.service.response;

import com.example.shoutreview.domain.Genre;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponse {


    private String title;
    private Genre genre;
    private Double rating;
    private List<ReviewResponse> reviews;
}
