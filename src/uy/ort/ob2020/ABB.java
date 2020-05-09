/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.ob2020;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author User Name
 */
class ABB {
    
    private INodoTadAbb raiz;
    
    public INodoTadAbb getRaiz(){
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
    
    /////////////////////////////////////////////////////////////
    //BUSCAR
    String con ="";
    public void mostrarTodo(INodoTadAbb<Repartidor> r){
        if(r!=null){
            visitar(r);
            mostrarTodo(r.izq());
            mostrarTodo(r.der());
        }
    }
    public void visitar(INodoTadAbb<Repartidor> r) {
        //con+="Nombre: "+r.obtener().getNombre()+", Cedula:"+r.obtener().getCI()+", Mail:"+r.obtener().getEmail()+" \n";
    }
    
    /////////////////////////////////////////////////////////////
    //LISTAR ASCENDENTE
    public String listarAscendente() {
        String listado ="";
        listado+= listarAscendenteRec(raiz, listado);
        return listado;
    }
    
    private String listarAscendenteRec(INodoTadAbb<Repartidor> nodo, String listado) {
        
        if (nodo != null) {
            listado = listarAscendenteRec(nodo.izq(), listado);
            listado += nodo.obtener().getMatricula()+";"+ nodo.obtener().getNombre()+"|";
            listado = listarAscendenteRec(nodo.der(), listado);
        }
        return listado;
    }
    
    /////////////////////////////////////////////////////////////
    //MOSTRAR
    public String mostrar(INodoTadAbb<Repartidor> r){
        con="";
        mostrarTodo(r);
        return con;
    }
    
    /////////////////////////////////////////////////////////////
    // VALIDA CEDULA
    public boolean validarMatricula(INodoTadAbb<Repartidor> r){
        boolean retorno = false;
        retorno =  esMatriculaValida(r.obtener().getMatricula());
        return retorno;
    }
    
    //ES MATRICULA VALIDA
    public boolean esMatriculaValida(String matricula) { 
                
        boolean retorno = false;
        // Patrón para validar Matricula [_A-Z]{3} = que arranque con 3 letras de A a Z y despues [_0-9]{4} = que siga con 4 numeros de 0 a 9
        Pattern pattern1 = Pattern.compile("^[_A-Z]{3}[_0-9]{4}");        
        Matcher mather = pattern1.matcher(matricula);
        
        if(mather.find() == true){
            retorno = true;
        }else{
            retorno = false;
        }
        
        return retorno;
    }
    
     /////////////////////////////////////////////////////////////
    // BUSCAR
    public busquedaRepartidor buscarPorMatricula(String matricula){
        int cant = 0;        
        if(raiz==null){
            return null;
        }else{
            return buscarRec(raiz, matricula, cant);
        }
    }
    private busquedaRepartidor buscarRec(INodoTadAbb<Repartidor> raiz, String matricula, int cant) {
        
        //SI EL ID ES IGUAL A LA RAIZ        
        if(matricula.compareTo(raiz.obtener().getMatricula()) == 0){
            return new busquedaRepartidor(raiz, cant + 1);
        }
        else{
            //SI EL ID ES MENOR
            if(matricula.compareTo(raiz.obtener().getMatricula()) < 0){
                if(raiz.izq()==null){
                    return null;
                }else{
                    return buscarRec(raiz.izq(), matricula, cant + 1);
                }
            }
            //SI ES MAYOR
            else{
                if(raiz.der()==null){
                    return null;
                }else{
                    return buscarRec(raiz.der(), matricula, cant + 1);
                }
            }
        }
    }
    
    /////////////////////////////////////////////////////////////
    // ELIMINAR
    private INodoTadAbb<Repartidor> eliminar(INodoTadAbb<Repartidor> raiz, String x){
        if(raiz.obtener().getMatricula().compareTo(x) == 0){
            return borrar(raiz, x);
        }else{
            if(x.compareTo(raiz.obtener().getMatricula()) < 0){
                raiz.enlIzq(eliminar(raiz.izq(), x));
            }else{
                raiz.enlDer(eliminar(raiz.izq(), x));
            }
            return raiz;
        }
    }

    /////////////////////////////////////////////////////////////
    // BORRAR    
    private INodoTadAbb<Repartidor> borrar(INodoTadAbb<Repartidor> raiz, String x) {
        if(raiz.izq()==null && raiz.der()==null){
            return null;
        }else{
            if(raiz.izq()==null){
                return raiz.der();
            }else{
                if(raiz.der()==null){
                    return raiz.der();
                }else{
                    INodoTadAbb<Repartidor> may = numeroMayor(raiz.izq());
                    raiz.modificar(may.obtener());
                    raiz.enlIzq(eliminar(raiz.izq(), may.obtener().getMatricula()));
                    return raiz;
                }
            }
        } 
    }

    /////////////////////////////////////////////////////////////
    // NUMERO MAYOR
    private INodoTadAbb<Repartidor> numeroMayor(INodoTadAbb<Repartidor> raiz) {
        if(raiz!=null){
            if(raiz.der()!=null){
                return numeroMayor(raiz.der());
            }else{
                return raiz;
            }
        }else{
            return null;
        }
    }
}
