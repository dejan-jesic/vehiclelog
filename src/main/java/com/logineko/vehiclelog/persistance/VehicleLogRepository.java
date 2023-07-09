package com.logineko.vehiclelog.persistance;

import com.logineko.vehiclelog.persistance.model.VehicleLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VehicleLogRepository extends JpaRepository<VehicleLog, Long>, JpaSpecificationExecutor<VehicleLog> {

}
