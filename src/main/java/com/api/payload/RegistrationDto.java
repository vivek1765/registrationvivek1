package com.api.payload;

import com.api.entity.Registration;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RegistrationDto {
    @NotEmpty
    @Size (min=2, message = "Min should be 2 letters")
    private String name;
    @Email
    private String email;
    @Size(min= 10, message= "should be 10 digits")
    private String mobile;


}

