package com.example.andrescabal.navdrawer.domain.model;

/**
 * Created by Andrés Cabal on 6/05/2018.
 */

public class Alimento {
    private String nameAlimento;
    private Double calorias;
    private Double proteinas;
    private Double grasas;
    private Double carbohidratos;
    private Double racion;

    public String getNameAlimento() {
        return nameAlimento;
    }

    public void setNameAlimento(String nameAlimento) {
        this.nameAlimento = nameAlimento;
    }

    public Double getCalorias() {
        return calorias;
    }

    public void setCalorias(Double calorias) {
        this.calorias = calorias;
    }

    public Double getProteinas() {
        return proteinas;
    }

    public void setProteinas(Double proteinas) {
        this.proteinas = proteinas;
    }

    public Double getGrasas() {
        return grasas;
    }

    public void setGrasas(Double grasas) {
        this.grasas = grasas;
    }

    public Double getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(Double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public Double getRacion() {
        return racion;
    }

    public void setRacion(Double racion) {
        this.racion = racion;
    }
}
