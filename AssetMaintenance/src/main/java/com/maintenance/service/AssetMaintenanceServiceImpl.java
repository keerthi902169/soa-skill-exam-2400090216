package com.maintenance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maintenance.entity.AssetMaintenance;
import com.maintenance.repository.AssetMaintenanceRepository;

@Service
public class AssetMaintenanceServiceImpl implements AssetMaintenanceService {

    @Autowired
    private AssetMaintenanceRepository repo;

    @Override
    public AssetMaintenance addAsset(AssetMaintenance asset) {
        return repo.save(asset);
    }

    @Override
    public List<AssetMaintenance> getAllAssets() {
        return repo.findAll();
    }

    @Override
    public AssetMaintenance getAssetById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public AssetMaintenance updateAsset(AssetMaintenance asset, Long id) {
        if (repo.existsById(id)) {
            asset.setAssetMaintenanceId(id);
            return repo.save(asset);
        }
        return null;
    }

    @Override
    public String deleteAsset(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "record deleted";
        }
        return "Record not found";
        
    }
    @Override
    public AssetMaintenance getAssetByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<AssetMaintenance> getAssetByStatus(String status) {
        return repo.findByStatus(status);
    }
}