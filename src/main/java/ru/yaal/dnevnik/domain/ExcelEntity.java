package ru.yaal.dnevnik.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "excel")
public class ExcelEntity {

    public ExcelEntity() {
    }

    public ExcelEntity(Integer id, Integer code, String name, Double price, Date date) {
        this(code, name, price, date);
        this.id = id;
    }

    public ExcelEntity(Integer code, String name, Double price, Date date) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.date = date;
    }

    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private Integer id;

    private Integer code;

    private String name;

    private Double price;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExcelEntity entity = (ExcelEntity) o;
        if (!code.equals(entity.code)) return false;
        if (!date.equals(entity.date)) return false;
        if (id != null ? !id.equals(entity.id) : entity.id != null) return false;
        if (!name.equals(entity.name)) return false;
        if (!price.equals(entity.price)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + code.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ExcelEntity{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}