package com.wru.wrubookstore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LikeDto {
    private Integer LikeId;
    private Integer BookId;
    private Integer UserId;
}
