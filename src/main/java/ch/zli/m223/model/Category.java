package ch.zli.m223.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long category_id;

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "category")
    private Set<Entry> entries;

    //getter and setter
}