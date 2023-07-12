package com.logineko.vehiclelog.controller;

import com.logineko.vehiclelog.repository.model.VehicleLog;
import com.logineko.vehiclelog.service.VehicleLogService;
import com.logineko.vehiclelog.controller.search.VehicleLogSearchDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/vehicle-logs")
@RequiredArgsConstructor
public class VehicleLogController implements VehicleLogControllerDocs {

    private final VehicleLogService vehicleLogService;

    @PostMapping(value = "/search")
    public Page<VehicleLog> advancedSearch(
            @RequestBody @Valid final VehicleLogSearchDTO searchDTO,
            @PageableDefault final Pageable pageable) {
        return vehicleLogService.findAllBy(searchDTO, pageable);
    }

    @PostMapping(value = "/upload")
    public void uploadCSV(@RequestParam("file") final MultipartFile file) {
        vehicleLogService.importVehicleLogs(file);
    }

}
