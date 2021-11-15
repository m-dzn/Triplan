package com.triplan.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public abstract class BaseVO {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
