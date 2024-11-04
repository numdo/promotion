package com.promotion.user.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    private String userId;
    private String userPassword;
    private String role;
}
