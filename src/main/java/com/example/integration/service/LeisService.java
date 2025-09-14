package com.example.integration.service;

import com.example.integration.dto.LeiDto;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class LeisService {

    private final CsvService csvService;

    public LeisService(CsvService csvService) {
        this.csvService = csvService;
    }

    @Cacheable("leis")
    public List<LeiDto> readCsv() throws CsvValidationException, IOException {
        Resource resource  = new ClassPathResource("leis-data.csv");
        try (InputStream inputStream = resource.getInputStream()) {
            return csvService.readCsv(inputStream);
        }
    }

}
