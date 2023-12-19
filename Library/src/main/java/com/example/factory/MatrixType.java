package com.example.factory;

import jakarta.persistence.*;


@Entity
@Table(name = "matrix_type")
public class MatrixType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Matrix_id")
    private int matrixId;

    @Column(name = "Matrix_type", nullable = false)
    private String matrixType;

    public int getMatrixId() {
        return matrixId;
    }

    public void setMatrixId(int matrixId) {
        this.matrixId = matrixId;
    }

    public String getMatrixType() {
        return matrixType;
    }

    public void setMatrixType(String matrixType) {
        this.matrixType = matrixType;
    }
// Getters and setters
}
