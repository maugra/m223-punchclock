package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import ch.zli.m223.model.Tag;

@ApplicationScoped
public class TagService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Tag createTag(Tag tag) {
        return entityManager.merge(tag);
    }

    @Transactional
    public void deleteTag(Long id) {
        Tag tag = entityManager.find(Tag.class, id);
        entityManager.remove(tag);
    }

    @Transactional
    public Tag updateTag(Long id, Tag tag) {
        tag.setId(id);
        return entityManager.merge(tag);
    }

    public List<Tag> findAll() {
        TypedQuery<Tag> query = entityManager.createQuery("FROM Tag", Tag.class);
        return query.getResultList();
    }
}