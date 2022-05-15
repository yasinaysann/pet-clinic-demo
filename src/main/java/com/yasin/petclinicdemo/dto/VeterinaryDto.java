package com.yasin.petclinicdemo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeterinaryDto implements Serializable {

    private String name;
    private String surname;
    private String phoneNumber;

    //Stack<String> stringStack = new Stack<>();
    //Deque<Integer> stack = new ArrayDeque<Integer>();


}
