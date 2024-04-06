package com.darshan.eventmanagementsystem.services;


import com.darshan.eventmanagementsystem.models.Event;
import com.darshan.eventmanagementsystem.repository.EventRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class EventReaderService {

    @Autowired
    private EventRepository eventRepository;

    public void readCsvAndSaveInDb(String csvFilePath) {
        try (Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\darsh\\Desktop\\MyProject\\EventManagementSystem\\Backend_assignment_gg_dataset - dataset.csv"))) {

            CsvToBean<Event> csvToBean = new CsvToBeanBuilder<Event>(reader)
                    .withType(Event.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Event> events = csvToBean.parse();

            eventRepository.saveAll(events);

        } catch (Exception ex) {
            // handle exception
        }
    }
}