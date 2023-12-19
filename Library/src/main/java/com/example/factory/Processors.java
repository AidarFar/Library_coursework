package com.example.factory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "processors")
public class Processors {

    @Id
    @Column(name = "Processor_name", nullable = false)
    private String processorName;

    @Column(name = "Cores_number", nullable = false)
    private int coresNumber;

    @Column(name = "Frequency", nullable = false)
    private int frequency;

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    public int getCoresNumber() {
        return coresNumber;
    }

    public void setCoresNumber(int coresNumber) {
        this.coresNumber = coresNumber;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
// Getters and setters
}
