package io.droksty.transfersdemo.dto;

import jakarta.validation.constraints.NotNull;

public final class AssociateDTO {
    private final Long id;

    @NotNull(message = "Required field: title")
    private final String title;

    @NotNull(message = "Required field: uid")
    private final String uid;

    public AssociateDTO(Long id, String title, String uid) {
        this.id = id;
        this.title = title;
        this.uid = uid;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getUid() {
        return uid;
    }

    @Override
    public String toString() {
        return "AssociateDTO{" +
                "id="       + id +
                ", uid="    + uid +
                ", title="  + title +
                '}';
    }
}
