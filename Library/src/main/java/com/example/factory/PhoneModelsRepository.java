package com.example.factory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhoneModelsRepository extends JpaRepository<PhoneModels, String> {

    @Query("SELECT pm FROM PhoneModels pm " +
            "JOIN pm.processor p " +
            "JOIN pm.material m " +
            "JOIN pm.cameraModel cm " +
            "JOIN pm.display d " +
            "JOIN d.displaySize ds " +
            "JOIN d.matrixType mt " +
            "WHERE CONCAT_WS(' ', pm.phoneName,pm.batteryCapacity, p.processorName, m.materialName, " +
            "cm.cameraResolution, d.displayId, ds.displaySize, mt.matrixType) LIKE %:keyword%")
    List<PhoneModels> search(@Param("keyword") String keyword);
}

