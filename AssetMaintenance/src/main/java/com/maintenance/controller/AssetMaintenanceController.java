package com.maintenance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maintenance.entity.AssetMaintenance;
import com.maintenance.service.AssetMaintenanceService;

@RestController
@RequestMapping("/asset")
@Validated

public class AssetMaintenanceController {

    @Autowired
    private AssetMaintenanceService service;

    @GetMapping("/")
    public String home()
    {
        return "service is good";
    }

    @PostMapping("/Add")
    public AssetMaintenance addAsset(@RequestBody AssetMaintenance asset)
    {
        return service.addAsset(asset);
    }

    @GetMapping("/display/{id}")
    public AssetMaintenance getAssetById(@PathVariable Long id)
    {
        return service.getAssetById(id);
    }

    @GetMapping("/displayAll")
    public List<AssetMaintenance> getAllAssets()
    {
        return service.getAllAssets();
    }

    @PutMapping("/update/{id}")
    public AssetMaintenance updateAsset(
            @RequestBody AssetMaintenance asset,
            @PathVariable Long id
            )
    {
        return service.updateAsset(asset, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAsset(@PathVariable Long id)
    {
        return service.deleteAsset(id);
    }
    @GetMapping("/displayByName/{name}")
    public AssetMaintenance getAssetByName(@PathVariable String name) {
        return service.getAssetByName(name);
    }

    @GetMapping("/displayByStatus/{status}")
    public List<AssetMaintenance> getAssetByStatus(@PathVariable String status) {
        return service.getAssetByStatus(status);
    }
}