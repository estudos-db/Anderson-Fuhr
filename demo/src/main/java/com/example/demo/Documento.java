package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
public class Documento {

    public Documento() {
    }

    public String getDocumento(Integer id) {
        return String.valueOf(Objects.hash(id));

    }
}
