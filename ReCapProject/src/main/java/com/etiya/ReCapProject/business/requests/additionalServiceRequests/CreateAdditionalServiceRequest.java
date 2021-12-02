package com.etiya.ReCapProject.business.requests.additionalServiceRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdditionalServiceRequest {

    @JsonIgnore
    private int id;
    private String serviceName;
    private double dailyPrice;
    private String description;
}
