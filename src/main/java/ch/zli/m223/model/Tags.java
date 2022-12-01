package ch.zli.m223.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Set;

import javax.persistence.*;public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long tag_id;

    @Column(nullable = false)
    private String title;

    @ManyToMany
    private Set<Entry> entries;

    @ManyToMany
    @JoinTable(
        name = "entry_tags",
        joinColumns = @JoinColumn(name="tag_id"),
        inverseJoinColumns = @JoinColumn(name="entry_id")
      )
    private Set<Entry> entryTags;
}
