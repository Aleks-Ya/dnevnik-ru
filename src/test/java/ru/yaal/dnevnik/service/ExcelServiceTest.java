package ru.yaal.dnevnik.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.yaal.dnevnik.domain.ExcelEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration("classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ExcelServiceTest {

    @Autowired
    private EntityManagerFactory emf;

    @Autowired
    private ExcelService service;

    @Test(expected = NullPointerException.class)
    public void testProcessExcelFile() throws Exception {
        service.processExcelFile(null);
        EntityManager em = emf.createEntityManager();
        ExcelEntity entity = em.find(ExcelEntity.class, 1);
        assertNotNull(entity);
    }
}