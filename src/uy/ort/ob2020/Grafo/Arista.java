/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.ob2020.Grafo;

/**
 *
 * @author User Name
 */
public class Arista {
    
    public boolean existe;
    public int peso;
    
    public Arista(){}
    public Arista(int peso){
        this.existe = true;
        this.peso = peso;
    }
    
    //GET AND SET
    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    //METODOS
    public boolean isExiste() {
        return existe;
    }
    
}
