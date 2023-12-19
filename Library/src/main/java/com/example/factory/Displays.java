package com.example.factory;

import jakarta.persistence.*;


@Entity
@Table(name = "displays")
public class Displays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Display_id")
    private int displayId;

    @ManyToOne
    @JoinColumn(name = "Size_id", nullable = false)
    private DisplaySizes displaySize;

    @ManyToOne
    @JoinColumn(name = "Matrix_id", nullable = false)
    private MatrixType matrixType;

    public int getDisplayId() {
        return displayId;
    }

    public void setDisplayId(int displayId) {
        this.displayId = displayId;
    }

    public DisplaySizes getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(DisplaySizes displaySize) {
        this.displaySize = displaySize;
    }

    public MatrixType getMatrixType() {
        return matrixType;
    }

    public void setMatrixType(MatrixType matrixType) {
        this.matrixType = matrixType;
    }
// Getters and setters
}

