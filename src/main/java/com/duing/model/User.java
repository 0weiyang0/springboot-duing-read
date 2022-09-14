package com.duing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data@AllArgsConstructor@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -4157591440911559182L;
    private int id;
    private String name;
    private String password;
}
