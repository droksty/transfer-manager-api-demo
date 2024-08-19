package io.droksty.transfersdemo.dto;

public final class AssociateDTO {
    private final Long    id;
    private final String  title;

    public AssociateDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }


    @Override
    public String toString() {
        return "AssociateDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
