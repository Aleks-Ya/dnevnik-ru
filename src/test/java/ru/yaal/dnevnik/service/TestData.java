package ru.yaal.dnevnik.service;

import org.joda.time.DateTime;
import ru.yaal.dnevnik.domain.ExcelEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Тестовые данные из Right-XLS.xls и Right-XLSX.xlsx
 * (содержимое обоих файлов идентичное).
 */
public class TestData {
    public static final List<ExcelEntity> RIGHT_ENTITIES_WITHOUT_ID = new ArrayList<>();
    public static final List<ExcelEntity> RIGHT_ENTITIES_WITH_ID = new ArrayList<>();

    static {
        addEntry(1, 1, "Чайник", 2000D, new DateTime(2015, 3, 10, 10, 30));
        addEntry(2, 2, "Чашка", 205.5D, new DateTime(1990, 1, 1, 23, 5));
        addEntry(3, 3, "Ложка", 50.15D, new DateTime(2014, 2, 28, 18, 59));
    }

    private static void addEntry(Integer id, Integer code, String name, Double price, DateTime date) {
        RIGHT_ENTITIES_WITHOUT_ID.add(new ExcelEntity(code, name, price, date.toDate()));
        RIGHT_ENTITIES_WITH_ID.add(new ExcelEntity(id, code, name, price, date.toDate()));
    }
}