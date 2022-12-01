package ch.zli.m223.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Tag;

public class TagService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Tag createTag(Tag tag) {
        entityManager.persist(tag);
        return tag;
    }

    public List<Tag> findAll() {
        var query = entityManager.createQuery("FROM Entry", Tag.class);
        return query.getResultList();
    }

    @Transactional
    public void delete(Long id) {
        Tag entry = entityManager.find(Tag.class, id);
        entityManager.remove(entry);
    }
    @Transactional
    public Tag update(Tag tag) {
        return entityManager.merge(tag);
    }
}
