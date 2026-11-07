package com.maintenance.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.maintenance.entity.AssetMaintenance;

public interface AssetMaintenanceRepository extends JpaRepository<AssetMaintenance, Long> {

    AssetMaintenance findByName(String name);

    List<AssetMaintenance> findByStatus(String status);
}