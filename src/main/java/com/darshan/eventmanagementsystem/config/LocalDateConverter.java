
package com.darshan.eventmanagementsystem.config;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Configuration
public class LocalDateConverter extends AbstractBeanField<Object,LocalDate> {

    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(value, formatter);
    }
}