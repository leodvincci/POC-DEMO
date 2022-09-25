package com.csc363.group2.poc_demo.security;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UpdatePasswordBody {

        private  String email;
        private  String password;

}
