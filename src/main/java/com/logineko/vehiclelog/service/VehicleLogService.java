package com.logineko.vehiclelog.service;

import com.logineko.vehiclelog.persistance.VehicleLogRepository;
import com.logineko.vehiclelog.persistance.model.VehicleLog;
import com.logineko.vehiclelog.web.search.VehicleLogSearchDTO;
import com.logineko.vehiclelog.web.search.VehicleLogSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class VehicleLogService {

    private final CsvParser csvParser;
    private final VehicleLogRepository vehicleLogRepository;

    @Transactional(readOnly = true)
    public Page<VehicleLog> findAllBy(final VehicleLogSearchDTO searchDTO, final Pageable pageable) {
        return vehicleLogRepository.findAll(new VehicleLogSpecification(searchDTO.searchCriteria()), pageable);
    }

    @Transactional
    public void importVehicleLogs(final MultipartFile file) {
        if (file.getOriginalFilename().startsWith("LD_C")) {
            vehicleLogRepository.saveAll(csvParser.parseCombines(file));
        } else if (file.getOriginalFilename().startsWith("LD_A")) {
            vehicleLogRepository.saveAll(csvParser.parseTractors(file));
        } else {
            throw new RuntimeException("Error");
        }
    }

}
