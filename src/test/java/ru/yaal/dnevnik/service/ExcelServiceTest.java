package ru.yaal.dnevnik.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.yaal.dnevnik.domain.ExcelEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration("classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ExcelServiceTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ExcelService service;

    @Test
    public void testProcessExcelFile() {
        service.processExcelFile(null);
        ExcelEntity entity = em.find(ExcelEntity.class, 1);
        assertNotNull(entity);
    }
}