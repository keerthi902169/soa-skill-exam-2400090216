package com.maintenance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maintenance.entity.AssetMaintenance;

@Service
public interface AssetMaintenanceService {

    public AssetMaintenance addAsset(AssetMaintenance asset);

    public List<AssetMaintenance> getAllAssets();

    public AssetMaintenance getAssetById(Long id);

    public AssetMaintenance updateAsset(AssetMaintenance asset, Long id);

    public String deleteAsset(Long id);
    public AssetMaintenance getAssetByName(String name);

    public List<AssetMaintenance> getAssetByStatus(String status);
}