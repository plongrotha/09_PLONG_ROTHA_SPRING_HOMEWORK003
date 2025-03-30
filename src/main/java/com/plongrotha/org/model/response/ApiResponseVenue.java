package com.plongrotha.org.model.response;

import java.time.LocalDateTime;

import com.plongrotha.org.model.entity.Venue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponseVenue {
    private String message;
    private Venue payload;
    private String status;
    private LocalDateTime timestemp;
}
