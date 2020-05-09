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
class ABBCentroMedico {
    
    private INodoTadAbb<Repartidor> raiz;
    
    public INodoTadAbb<Repartidor> getRaiz(){
        return raiz;
    }
    
    public void insertar(Repartidor r) {
        if (raiz == null) {
            raiz = new NodoTadAbb<> (r);            
            //raiz = new NodoTadAbb<> (a);
        } else {
            insertarRec(raiz, r);
        }
    }    

    //INSERTAR
    private void insertarRec(INodoTadAbb<Repartidor> raiz, Repartidor r) {
        //1 - este mayor a este
        //0 - iguales
        //-1 - este mayor a este        
        
        //SI EL ID ES MENOR
        //if(a.getId() < raiz.obtener().getId()){
        if(r.getMatricula().compareTo(raiz.obtener().getMatricula()) < 0){
            if(raiz.izq()==null){
                raiz.enlIzq(new NodoTadAbb(r));
            }else{
                insertarRec(raiz.izq(), r);
            }
        }
        //SI EL ID ES MAYOR
        else{
          if(raiz.der()==null){
              raiz.enlDer(new NodoTadAbb(r));
          }else{
              insertarRec(raiz.der(), r);
          }
        }
    }
    
}
