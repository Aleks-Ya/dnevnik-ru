package ru.yaal.dnevnik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yaal.dnevnik.domain.ExcelEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.io.File;

@Service
public class ExcelService {

    private EntityManager em;

    @Autowired
    private void setEntityManager(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }

    @Transactional
    public void processExcelFile(File file) {
        ExcelEntity entity = new ExcelEntity();
        em.persist(entity);
        em.flush();
    }
}
