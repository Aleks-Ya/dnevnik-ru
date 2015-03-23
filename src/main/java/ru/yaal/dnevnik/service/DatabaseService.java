package ru.yaal.dnevnik.service;

import org.springframework.stereotype.Service;
import ru.yaal.dnevnik.domain.ExcelEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class DatabaseService {

    @PersistenceContext
    private EntityManager em;

    public List<ExcelEntity> getAllEntities() {
        return em.createQuery("SELECT e FROM ExcelEntity e", ExcelEntity.class).getResultList();
    }

}
