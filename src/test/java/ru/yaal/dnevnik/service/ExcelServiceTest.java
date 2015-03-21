package ru.yaal.dnevnik.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.yaal.dnevnik.domain.ExcelEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration("classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ExcelServiceTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ExcelService service;

    @Test
    public void xlsx() throws ServiceException {
        String filename = "Right-XLSX.xlsx";
        InputStream is = ExcelService.class.getResourceAsStream("../../../../" + filename);
        service.processExcelFile(is, filename);
        List<ExcelEntity> actual = em.createQuery(
                "SELECT e FROM ExcelEntity e", ExcelEntity.class)
                .getResultList();

        assertEquals(TestData.RIGHT_ENTITIES_WITH_ID, actual);
    }
}