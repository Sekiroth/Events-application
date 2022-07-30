package com.afisha.classifier.dto.classifiers;

import javax.validation.constraints.NotBlank;

public class CreationCategory {

    @NotBlank(message = "Title must not be blank")
    private String title;

    public CreationCategory() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String description) {
        this.title = description;
    }
}
