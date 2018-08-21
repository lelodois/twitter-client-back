package br.com.lelo.twclient.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Top {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_top")
    private Long id;

    @NotNull
    @Column(name = "nm_type")
    @Enumerated(EnumType.STRING)
    private TopType type;

    @NotNull
    @Column(name = "nm_top_result")
    private String name;

    @Column(name = "nr_size")
    private int size;

    public Top() {
    }

    public Top(TopType type, String name) {
        this.type = type;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TopType getType() {
        return type;
    }

    public void setType(TopType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Top withType(TopType type) {
        this.setType(type);
        return this;
    }
}
