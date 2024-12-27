package io.droksty.transfersdemo.dto;

import java.util.List;


public final class ErrorDTO {
    private final List<String> errors;

    public ErrorDTO(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return List.copyOf(errors) ;
    }
}
