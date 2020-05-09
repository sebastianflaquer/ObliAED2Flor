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
public class busquedaRepartidor {
    private INodoTadAbb<Repartidor> Repartidor;
    private int cantidad;

    busquedaRepartidor(INodoTadAbb<Repartidor> raiz, int i) {
        this.Repartidor = raiz;
        this.cantidad = i;
    }

    public INodoTadAbb<Repartidor> getRepartidor() {
        return Repartidor;
    }

    public void setAfiliado(INodoTadAbb<Repartidor> Repartidor) {
        this.Repartidor = Repartidor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
