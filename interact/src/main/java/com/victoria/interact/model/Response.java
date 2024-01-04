package com.victoria.interact.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response {
    private String responseCode;
    private String responseMessage;
    private CourseDTO courseDTO;
}
