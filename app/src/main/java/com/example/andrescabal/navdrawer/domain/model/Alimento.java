package com.example.andrescabal.navdrawer.domain.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrés Cabal on 6/05/2018.
 */

public class Alimento {
    @SerializedName("nombre")
    private String nameAlimento;
    private Double calorias;
    private Double proteinas;
    private Double grasas;
    private Double carbohidratos;
    private Double racion;
    private String imagen;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

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
