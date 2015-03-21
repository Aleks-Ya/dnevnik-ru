package ru.yaal.dnevnik.service;

import org.springframework.stereotype.Service;
import ru.yaal.dnevnik.domain.ExcelEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.File;

@Service
public class ExcelService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void processExcelFile(File file) {
        ExcelEntity entity = new ExcelEntity();
        em.persist(entity);
        em.flush();
    }
}
