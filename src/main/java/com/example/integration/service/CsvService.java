package com.example.integration.service;

import com.example.integration.dto.LeiDto;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {

    public CsvService() {}

    public List<LeiDto> readCsv(InputStream inputStream) throws CsvValidationException, IOException {
        List<LeiDto> leis = new ArrayList<>();
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

        try (Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             CSVReader csvReader = new CSVReaderBuilder(reader)
                     .withCSVParser(parser)
                     .build()) {

            String[] line;
            csvReader.readNext(); // pula cabeçalho

            while ((line = csvReader.readNext()) != null) {
                if (!line[5].equals("EXTERNO")) {
                    leis.add(new LeiDto(
                            Integer.parseInt(line[0]),
                            line[1],
                            line[2],
                            line[3],
                            line[4],
                            line[5],
                            line[6],
                            line[7]
                    ));
                }
            }
        }

        return leis;
    }
}
