package com.example.demo.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@Data
@MappedSuperclass
public class extra {
    private String created_by;
    private String updated_by;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
