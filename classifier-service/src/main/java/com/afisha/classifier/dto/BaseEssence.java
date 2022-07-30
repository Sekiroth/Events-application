package com.afisha.classifier.dto;

import java.util.UUID;

public class BaseEssence {
    private final UUID uuid;
    private final Integer dtCreate;
    private Integer dtUpdate;

    private BaseEssence() {
        this.uuid = UUID.randomUUID();
        this.dtCreate = generateTime();
        this.dtUpdate = generateTime();
    }

    public static int generateTime() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public UUID getUuid() {
        return uuid;
    }

    public Integer getDtCreate() {
        return dtCreate;
    }

    public Integer getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(Integer dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public static BaseEssence getInstance() {
        return new BaseEssence();
    }
}
