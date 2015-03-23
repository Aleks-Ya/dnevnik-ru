package ru.yaal.dnevnik.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yaal.dnevnik.domain.ExcelEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.InputStream;
import java.util.List;

@Service
public class ExcelService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ExcelParser parser;

    @Transactional
    public int processExcelFile(InputStream excel, String filename) throws ServiceException {
        List<ExcelEntity> entities;
        try {
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
            switch (ext) {
                case "xls": {
                    Workbook workbook = new HSSFWorkbook(excel);
                    entities = parser.parse(workbook);
                    break;
                }
                case "xlsx": {
                    Workbook workbook = new XSSFWorkbook(excel);
                    entities = parser.parse(workbook);
                    break;
                }
                default: {
                    throw new ServiceException("Формат файлов не поддерживается: %s", ext);
                }
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

        try {
            for (ExcelEntity entity : entities) {
                em.persist(entity);
            }
            em.flush();
            return entities.size();
        } catch (Exception e) {
            throw new ServiceException("Ошибка сохранения информации в БД", e);
        }
    }
}
