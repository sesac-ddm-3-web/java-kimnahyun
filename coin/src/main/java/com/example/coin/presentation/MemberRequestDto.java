package com.example.coin.presentation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class MemberRequestDto {

    @NotNull
    @NotBlank
    String name;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{3}-\\d{4}-\\d{4}$")
    String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }


}
