package com.logineko.vehiclelog.repository;

import com.logineko.vehiclelog.repository.model.VehicleLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VehicleLogRepository extends JpaRepository<VehicleLog, Long>, JpaSpecificationExecutor<VehicleLog> {

}
