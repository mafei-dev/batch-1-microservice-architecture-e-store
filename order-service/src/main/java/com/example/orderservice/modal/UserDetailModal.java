package com.example.orderservice.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailModal {
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("is_active")
    private int isActive;
    private String username;
    private String tel;
    private String address;

}
