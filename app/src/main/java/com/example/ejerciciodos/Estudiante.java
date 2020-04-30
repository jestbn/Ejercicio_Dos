package com.example.ejerciciodos;

class Estudiante {
    /// fields ////////////////
    private String name;
    private Double nota1;
    private Double nota2;
    private Double nota3;
    private Double nota4;
    private Double promedio;

    /////// constructors ////////////////////
    public Estudiante(String theName, Double lanota1, Double lanota2, Double lanota3, Double lanota4) {
        this.name = theName;
        this.nota1 = lanota1;
        this.nota2 = lanota2;
        this.nota3 = lanota3;
        this.nota4 = lanota4;
        lanota1 = lanota1 * (0.2);
        lanota2 = lanota2 * (0.3);
        lanota3 = lanota3 * (0.15);
        lanota4 = lanota4 * (0.35);
        this.promedio = (lanota1 + lanota2 + lanota3 + lanota4);
    }

    //////////// methods ///////////////////////
    public String getName() {
        return this.name;
    }

    public void setName(String theName) {
        this.name = theName;
    }

    public Double getNota1() {
        return nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public Double getNota3() {
        return nota3;
    }

    public Double getNota4() {
        return nota4;
    }

    public Double getPromedio() {
        return promedio;
    }
}
