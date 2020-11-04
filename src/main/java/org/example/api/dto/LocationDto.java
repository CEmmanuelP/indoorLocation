package org.example.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LocationDto {
    private String name;
    private Integer x;
    private Integer y;

}
