package ru.yaal.dnevnik.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import ru.yaal.dnevnik.domain.ExcelEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ExcelParser {
    private static final int CODE_COLUMN = 0;
    private static final int NAME_COLUMN = 1;
    private static final int PRICE_COLUMN = 2;
    private static final int DATE_COLUMN = 3;

    public List<ExcelEntity> parse(Workbook workbook) throws ServiceException {
        List<ExcelEntity> entities = new ArrayList<>();
        Sheet sheet1 = workbook.getSheetAt(0);
        for (int row = sheet1.getFirstRowNum() + 1; row <= sheet1.getLastRowNum(); row++) {
            Row row1 = sheet1.getRow(row);

            Cell code = row1.getCell(CODE_COLUMN);
            Cell name = row1.getCell(NAME_COLUMN);
            Cell price = row1.getCell(PRICE_COLUMN);
            Cell date = row1.getCell(DATE_COLUMN);

            if (!isHeaderRow(row)) {
                if (code.getCellType() != Cell.CELL_TYPE_NUMERIC) {
                    throw new ServiceException(
                            "В ячейке ожидается число: строка=%d, столбец=%d", row, CODE_COLUMN);
                }
                if (name.getCellType() != Cell.CELL_TYPE_STRING) {
                    throw new ServiceException(
                            "В ячейке ожидается строка: строка=%d, столбец=%d", row, NAME_COLUMN);
                }
                if (price.getCellType() != Cell.CELL_TYPE_NUMERIC) {
                    throw new ServiceException(
                            "В ячейке ожидается число: строка=%d, столбец=%d", row, PRICE_COLUMN);
                }
                if (date.getCellType() != Cell.CELL_TYPE_NUMERIC) {
                    throw new ServiceException(
                            "В ячейке ожидается дата: строка=%d, столбец=%d", row, DATE_COLUMN);
                }
            }

            Integer codeValue = new Double(code.getNumericCellValue()).intValue();
            String nameValue = name.getStringCellValue();
            Double priceValue = price.getNumericCellValue();
            Date dateValue = date.getDateCellValue();

            entities.add(new ExcelEntity(codeValue, nameValue, priceValue, dateValue));
        }
        return entities;
    }

    private static boolean isHeaderRow(int row) {
        return row == 0;
    }
}