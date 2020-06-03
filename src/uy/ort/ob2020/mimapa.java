/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.ob2020;

import uy.ort.ob2020.Grafo.Grafo;
import uy.ort.ob2020.Grafo.NodoGrafo;

/**
 *
 * @author User Name
 */
class mimapa {
    
    static String getURLMapaPuntos(Grafo Grafo) {
        
        //int contador = 0;
        String Marker = "";
        String Tipo = "";
        NodoGrafo[] vertices = Grafo.getVertices();
                
        for(int i = 0; i < Grafo.getTope(); i++){
            if(vertices[i]!=null){
                
                Double cordX = vertices[i].getCoordX();
                Double cordY = vertices[i].getCoordY();
                NodoGrafo nodoActual = Grafo.existeVerticeCordenadas(cordX, cordY);
                
                //SI ES CENTRO MEDICO
                if(nodoActual.getDato() instanceof CentroMedico){                    
                    CentroMedico centroActual = (CentroMedico) nodoActual.getDato();                    
                    if(centroActual.getCriticidad() == EnumCriticidad.BAJA){
                        Marker += "markers=color:green";
                    }else if(centroActual.getCriticidad() == EnumCriticidad.MEDIA){
                        Marker += "markers=color:yellow";
                    }else{
                        Marker += "markers=color:red";
                    }
                    Tipo = "C";
                }else if(nodoActual.getDato() instanceof Esquina){ //SI ES ESQUINA
                    Marker += "markers=color:blue";
                    Tipo = "E";
                }else{
                    Marker += "markers=color:green";
                    Tipo = "S";
                }
                
                //contador++;
                Marker += "%7Clabel:"+Tipo+"%7C"+nodoActual.getCoordX()+","+nodoActual.getCoordY()+"&";
            }
        }

        String UrlIni = "http://maps.googleapis.com/maps/api/staticmap?center=Montevideo,Uruguay&zoom=13&size=1200x600&maptype=roadmap&";
        String UrlFin = "sensor=false&key=AIzaSyC2kHGtzaC3OOyc7Wi1LMBcEwM9btRZLqw";
        String urlCompleta = UrlIni + Marker + UrlFin;
        
        return urlCompleta;
        
    }
}
