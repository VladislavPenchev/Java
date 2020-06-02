package com.minkov.springintroapp.viewmodels;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class WhiskeyModel {
    @NotNull(message = "Not null")
    @Size(min = 3, max = 15, message = "Invalid length")
    private String name;

    public WhiskeyModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
