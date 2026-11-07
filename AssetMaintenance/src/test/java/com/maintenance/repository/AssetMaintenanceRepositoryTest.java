
package com.maintenance.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.maintenance.entity.AssetMaintenance;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AssetMaintenanceRepositoryTest
{
    @Autowired
    private AssetMaintenanceRepository repository;

    @Test
    void testFindAllAssets()
    {
        List<AssetMaintenance> assets = repository.findAll();
        assertNotNull(assets);
        assertFalse(assets.isEmpty());
        System.out.println("Total Assets: " + assets.size());
    }

    @Test
    void testFindAssetById()
    {
        Optional<AssetMaintenance> asset = repository.findById(1L);
        assertTrue(asset.isPresent());
        assertEquals(1L, asset.get().getAssetMaintenanceId());
        System.out.println("Asset ID: " + asset.get().getAssetMaintenanceId());
        System.out.println("Asset Name: " + asset.get().getName());
    }

    @Test
    void testFindAssetByInvalidId()
    {
        Optional<AssetMaintenance> asset = repository.findById(99999L);
        assertFalse(asset.isPresent());
    }

    @Test
    void testFindAssetByName()
    {
        AssetMaintenance asset = repository.findByName("HP Laptop");
        assertNotNull(asset);
        assertEquals("HP Laptop", asset.getName());
        System.out.println("Asset Name: " + asset.getName());
    }

    @Test
    void testFindAssetByStatus()
    {
        List<AssetMaintenance> assets = repository.findByStatus("Available");
        assertNotNull(assets);
        System.out.println("Available Assets: " + assets.size());
    }

    @Test
    void testDatabaseConnection()
    {
        long count = repository.count();
        assertTrue(count >= 0);
        System.out.println("Total Assets in Database: " + count);
    }

    @Test
    void testAssetDetails()
    {
        Optional<AssetMaintenance> asset = repository.findById(1L);
        assertTrue(asset.isPresent());

        AssetMaintenance foundAsset = asset.get();

        assertNotNull(foundAsset.getName());
        assertNotNull(foundAsset.getType());
        assertNotNull(foundAsset.getStatus());
        assertNotNull(foundAsset.getLocation());
        assertNotNull(foundAsset.getCreatedAt());
        assertNotNull(foundAsset.getUpdatedAt());

        System.out.println("Name: " + foundAsset.getName());
        System.out.println("Type: " + foundAsset.getType());
        System.out.println("Status: " + foundAsset.getStatus());
        System.out.println("Location: " + foundAsset.getLocation());
    }
}
