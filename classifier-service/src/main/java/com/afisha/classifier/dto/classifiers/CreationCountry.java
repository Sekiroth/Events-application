package com.afisha.classifier.dto.classifiers;

import javax.validation.constraints.NotBlank;

public class CreationCountry {

    @NotBlank(message = "Title must not be blank")
    private String title;
    private String description;

    public CreationCountry() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
