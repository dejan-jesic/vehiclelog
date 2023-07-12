package com.logineko.vehiclelog.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.logineko.vehiclelog.repository.model.CombineLog;
import com.logineko.vehiclelog.repository.model.TractorLog;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class CsvParser {

    public List<CombineLog> parseCombines(final MultipartFile file) {
        try (var reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            final CsvToBean<CombineLog> csvToBean = new CsvToBeanBuilder<CombineLog>(reader)
                    .withType(CombineLog.class)
                    .withSeparator(';')
                    .build();
            return csvToBean.parse();
        } catch (final IOException e) {
            log.error("Error: ", e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<TractorLog> parseTractors(final MultipartFile file) {
        try (var reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            final CsvToBean<TractorLog> csvToBean = new CsvToBeanBuilder<TractorLog>(reader)
                    .withType(TractorLog.class)
                    .withSeparator(';')
                    .build();
            return csvToBean.parse();
        } catch (final IOException e) {
            log.error("Error: ", e);
            throw new RuntimeException(e.getMessage());
        }
    }

}
