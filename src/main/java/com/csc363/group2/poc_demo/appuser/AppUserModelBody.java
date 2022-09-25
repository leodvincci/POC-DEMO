package com.csc363.group2.poc_demo.appuser;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AppUserModelBody {
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;
    private  AppUserRole role;
}
