package ch.zli.m223.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Tags;

public class TagService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Tags createTag(Tags tag) {
        entityManager.persist(tag);
        return tag;
    }

    public List<Tags> findAll() {
        var query = entityManager.createQuery("FROM Entry", Tags.class);
        return query.getResultList();
    }

    @Transactional
    public void delete(Long id) {
        Tags entry = entityManager.find(Tags.class, id);
        entityManager.remove(entry);
    }
    @Transactional
    public Tags update(Tags tag) {
        return entityManager.merge(tag);
    }
}
