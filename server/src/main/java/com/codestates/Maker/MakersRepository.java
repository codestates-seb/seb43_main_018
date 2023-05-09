package com.codestates.Maker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Repository
public class MakersRepository {
    private ObjectMapperUtil objectMapperUtil;
    private EntityManager entityManager;

    @Autowired
    public MakersRepository(ObjectMapperUtil objectMapperUtil, EntityManager entityManager) {
        this.objectMapperUtil = objectMapperUtil;
        this.entityManager = entityManager;
    }

    @Transactional
    public void saveData() throws IOException {
        List<Makers> makersList = objectMapperUtil.readJsonFile();
        for (Makers makers : makersList) {
            entityManager.persist(makers);
        }
        entityManager.flush();
    }

    public List<Makers> findAll() {
        return entityManager.createQuery("SELECT m FROM Makers m", Makers.class).getResultList();
    }

    public void save(Makers makers) {
        entityManager.persist(makers);
    }

    public Makers findById(Long id) {
        return entityManager.find(Makers.class, id);
    }
}

