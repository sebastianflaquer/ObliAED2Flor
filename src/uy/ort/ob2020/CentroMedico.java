/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.ob2020;

/**
 *
 * @author User Name
 */
public class CentroMedico {
    
    private String nombre;
    private Double coordX;
    private Double coordY;
    private EnumCriticidad criticidad;
    
    //CONSTRUCTOR
    public CentroMedico(String nombre, Double coordX, Double coordY, EnumCriticidad criticidad) {
        this.nombre = nombre;
        this.coordX = coordX;
        this.coordY = coordY;
        this.criticidad = criticidad;
    }
    
    //GETER AND SETTER
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCoordX() {
        return coordX;
    }
    public void setCoordX(Double coordX) {
        this.coordX = coordX;
    }
    public Double getCoordY() {
        return coordY;
    }
    public void setCoordY(Double coordY) {
        this.coordY = coordY;
    }

    public EnumCriticidad getCriticidad() {
        return criticidad;
    }
    public void setCriticidad(EnumCriticidad criticidad) {
        this.criticidad = criticidad;
    }
}
