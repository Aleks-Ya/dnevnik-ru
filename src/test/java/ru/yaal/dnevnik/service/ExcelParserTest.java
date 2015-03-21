package ru.yaal.dnevnik.service;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.yaal.dnevnik.domain.ExcelEntity;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration("classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ExcelParserTest {

    @Autowired
    private ExcelParser parser;

    @Test
    public void testParse() throws IOException, ServiceException {
        InputStream is = ExcelService.class.getResourceAsStream("../../../../Right-XLSX.xlsx");
        Workbook wb = new XSSFWorkbook(is);
        List<ExcelEntity> actual = parser.parse(wb);

        assertEquals(TestData.RIGHT_ENTITIES_WITHOUT_ID, actual);
    }
}