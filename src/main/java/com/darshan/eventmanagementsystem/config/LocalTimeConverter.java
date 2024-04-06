package com.darshan.eventmanagementsystem.config;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class LocalTimeConverter extends AbstractBeanField<Object, LocalTime> {

    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss");
        return LocalTime.parse(value, formatter);
    }
}