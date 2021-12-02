package com.etiya.ReCapProject.business.requests.additionalServiceRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAdditionalServiceRequest {

    private int id;
    private String serviceName;
    private double dailyPrice;
    private String description;


}
