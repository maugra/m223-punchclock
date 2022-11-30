package ch.zli.m223.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.*;public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private String title;
}
