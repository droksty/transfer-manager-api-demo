package io.droksty.transfersdemo.dto;

public final class AssociateDTO {
    private final Long      id;
    private final String    title;
    private final String    uid;

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
