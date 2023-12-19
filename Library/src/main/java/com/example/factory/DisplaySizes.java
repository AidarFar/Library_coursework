package com.example.factory;

import jakarta.persistence.*;

@Entity
@Table(name = "display_sizes")
public class DisplaySizes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Size_id")
    private int sizeId;

    @Column(name = "Display_size", nullable = false)
    private int displaySize;

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public int getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(int displaySize) {
        this.displaySize = displaySize;
    }
// Getters and setters
}
