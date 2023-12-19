package com.example.factory;

import jakarta.persistence.*;


@Entity
@Table(name = "phone_models")
public class PhoneModels {

    @Id
    @Column(name = "Phone_name", nullable = false)
    private String phoneName;

    @Column(name = "Battery_capacity", nullable = false)
    private int batteryCapacity;

    @ManyToOne
    @JoinColumn(name = "Processor_name", nullable = false)
    private Processors processor;

    @ManyToOne
    @JoinColumn(name = "Material_id", nullable = false)
    private Materials material;

    @ManyToOne
    @JoinColumn(name = "Camera_id", nullable = false)
    private CameraModels cameraModel;

    @ManyToOne
    @JoinColumn(name = "Display_id", nullable = false)
    private Displays display;

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Processors getProcessor() {
        return processor;
    }

    public void setProcessor(Processors processor) {
        this.processor = processor;
    }

    public Materials getMaterial() {
        return material;
    }

    public void setMaterial(Materials material) {
        this.material = material;
    }

    public CameraModels getCameraModel() {
        return cameraModel;
    }

    public void setCameraModel(CameraModels cameraModel) {
        this.cameraModel = cameraModel;
    }

    public Displays getDisplay() {
        return display;
    }

    public void setDisplay(Displays display) {
        this.display = display;
    }
// Getters and setters
}
