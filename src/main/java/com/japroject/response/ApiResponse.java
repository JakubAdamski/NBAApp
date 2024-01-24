package com.japroject.response;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponse {

    private List<DataResponse> response;
}
