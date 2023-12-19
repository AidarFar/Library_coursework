package com.example.factory;

import jakarta.persistence.*;

@Entity
@Table(name = "camera_models")
public class CameraModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Camera_id")
    private int cameraId;

    @Column(name = "Camera_resolution", nullable = false)
    private int cameraResolution;

    public int getCameraId() {
        return cameraId;
    }

    public void setCameraId(int cameraId) {
        this.cameraId = cameraId;
    }

    public int getCameraResolution() {
        return cameraResolution;
    }

    public void setCameraResolution(int cameraResolution) {
        this.cameraResolution = cameraResolution;
    }
// Getters and setters
}
