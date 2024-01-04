package com.victoria.interact.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private String lecturer;
    private String description;
    private String subject;
}
