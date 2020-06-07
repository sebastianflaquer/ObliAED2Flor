/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.ob2020.Grafo;

import uy.ort.ob2020.CentroMedico;
import uy.ort.ob2020.EnumCriticidad;

/**
 *
 * @author User Name
 */
public class Grafo {
    
    private int tope; //maxima cantidad de nodos permitido.
    private int cantidad; //cantidad actual de nodos.
    private NodoGrafo[] vertices; //representamos los vertices (la existencia o no existencia).
    private Arista[][] matAdy; //representamos las conexiones entre los vertices).
    private int aux;
    
    //CONSTRUCTOR
    public Grafo(int tope) {
        this.tope = tope;
        this.vertices = new NodoGrafo[tope];
        
        this.matAdy = new Arista[tope][tope];
        for (int i = 0; i < tope; i++) {
            for (int j = i; j < tope; j++) {
                matAdy[i][j] = matAdy[j][i] = new Arista();
            }
        }
    } 
    
    //GETTER AND SETTERS
    public NodoGrafo[] getVertices() {
        return vertices;
    }

    public void setVertices(NodoGrafo[] vertices) {
        this.vertices = vertices;
    }
    public Arista[][] getMatAdy() {
        return matAdy;
    }

    public void setMatAdy(Arista[][] matAdy) {
        this.matAdy = matAdy;
    }

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    //METODOS
    private int posOcupada() {
        for (int i = 0; i < tope; i++)
            if (vertices[i] != null)
                return i;
        return -1;
    }

    private int posLibre() {
        for (int i = 0; i < tope; i++)
            if (vertices[i] == null)
                    return i;
        return -1;
    }

    // Pre: !existeVertice(ver) && !esLleno()
    public void agregarVertice(NodoGrafo ver) {
        int pos = posLibre();
        vertices[pos] = ver;
        cantidad++;
    }

    // Pre: existeVertice(origen) && existeVertice(destino) &&
    // !existeArista(origen, destino)
    public void agregarArista(NodoGrafo origen, NodoGrafo destino, int peso) {
        int posOrigen = posVertice(origen);
        int posDestino = posVertice(destino);

        matAdy[posOrigen][posDestino].setExiste(true);
        //matAdy[posDestino][posOrigen].setExiste(true);
        matAdy[posOrigen][posDestino].setPeso(peso);
        //matAdy[posDestino][posOrigen].setValor(peso);
    }
    
    //MODIFICAR PESO ARISTA
    public void modificarPesoArista(NodoGrafo origen, NodoGrafo destino, int peso) {
        int posOrigen = posVertice(origen);
        int posDestino = posVertice(destino);

        matAdy[posOrigen][posDestino].setPeso(peso);
        //matAdy[posDestino][posOrigen].setPeso(peso);
    }
    
    //SI ESTA LLENO
    public boolean esLleno() {
        return cantidad == tope;
    }
    
    public boolean sonAdyacentes(int a, int b) {
	return (this.matAdy[a][b].isExiste());
    }

   
    //EXISTE VERTICE
    public boolean existeVertice(NodoGrafo ver) {
        return posVertice(ver) != -1;
    }
    
     //POSICION VERTICE
    private int posVertice(NodoGrafo ver) {
        for (int i = 0; i < tope; i++){
            if(vertices[i] != null){
                if(ver.equals(vertices[i])){
                    return i;
                }
            }
        }
        return -1;
    }
    
    //EXISTE VERTICE CORDENADAS
    public boolean existeVerticeCord(Double coordX, Double coordY) {
        return posVerticeCord(coordX, coordY) != -1;
    }
    private int posVerticeCord(Double coordX, Double coordY) {
        for (int i = 0; i < tope; i++)
            if(vertices[i] != null){
                if ((coordX.equals(vertices[i].getCoordX())) &&  (coordY.equals(vertices[i].getCoordY()))){
                    return i;
                }
            }
        return -1;
    }    
    
    public NodoGrafo existeVerticeCordenadas(Double coordXi, Double coordYi) {
        for(int i = 0; i < tope; i++){
            if(this.vertices[i]!=null){
                Double cordX = this.vertices[i].getCoordX();
                Double cordY = this.vertices[i].getCoordY();
                
                int resX = cordX.compareTo(coordXi);
                int resY = cordY.compareTo(coordYi);
                        
                //if((cordX == coordXi)&&(cordY == coordYi)){
                if( resX == 0 && resY == 0 ){
                    return this.vertices[i];
                }
            }
        }
        return null;
    }
    
    //EXISTE ARISTA
    public boolean existeArista(NodoGrafo origen, NodoGrafo destino) {
        int posOrigen = posVertice(origen);
        int posDestino = posVertice(destino);

        return matAdy[posOrigen][posDestino].isExiste();
    }
    
    

    // Pre: existeVertice(ver)
    public void borrarVertice(NodoGrafo ver) {
        int pos = posVertice(ver);

        vertices[pos] = null;

        for (int i = 0; i < tope; i++) {
            matAdy[pos][i].setExiste(false);
            matAdy[i][pos].setExiste(false);
        }
    }

    public void borrarArista(NodoGrafo origen, NodoGrafo destino) {
        int posOrigen = posVertice(origen);
        int posDestino = posVertice(destino);

        matAdy[posOrigen][posDestino].setExiste(false);
        matAdy[posDestino][posOrigen].setExiste(false);
    }
    
    
    

    

    public NodoGrafo[] getVerticesCriticos() {
        
        int count = 0;
        NodoGrafo[] verticesCriticos = new NodoGrafo[cantidad];
        
        for(int i = 0; i< cantidad; i++){
            
            NodoGrafo nodoActual = vertices[i];
            if(nodoActual.getDato() instanceof CentroMedico){         
                
                CentroMedico centroActual = (CentroMedico)nodoActual.getDato();
                if(centroActual.getCriticidad() == EnumCriticidad.ALTA){                    
                    verticesCriticos[count] = nodoActual;
                    count++;
                }
            }
        }
        
        return verticesCriticos;
    }
    
    /****************************************/
    /* DFS                                  */
    /****************************************/
    public void DFS(){
        boolean[] vis = new boolean[tope];
        int pos = posOcupada();
        if(pos != -1){
            for (int i = 0; i < tope; i++) {
                if(!vis[i] && vertices[i] != null)
                {
                    DFSRec(i, vis);
                }
            }
        }
    }

    private void DFSRec(int pos, boolean[] vis) {
        vis[pos] = true;
        System.out.println(vertices[pos]);
        for (int i = 0; i < tope; i++) {
            if(!vis[i] && matAdy[pos][i].isExiste())
            {
                DFSRec(i, vis);
            }
        }
    }
    
    
//    /****************************************/
//    /* CAMINO MINIMO                        */
//    /****************************************/
//    public int caminoMinimoGrafo(int o, int d) { //origen y destino
//        //        
//        boolean[] visitados = new boolean[this.cantidad + 1]; //Marcamos en verde.
//        int[] predecesores = new int[this.cantidad +1];
//        int[] costos = new int[this.cantidad +1];
//        //
//        ////INICIALIZACION
//        visitados[o] = true;
//        costos[o] = 0;
//        //
//        for (int i=1; i<=this.cantidad + 1; i++) {
//            if (i!=o) //para todos los vertices menos para el inicial
//                if (this.sonAdyacentes(o, i)) {
//                    costos[i] = this.matAdy[o][i].peso;
//                    predecesores[i] = o;
//                }
//                else{
//                    costos[i] = Integer.MAX_VALUE;
//                }
//                        
//        }
//        //FIN INICIALIZACION
//        //
//        //LOOP
//        for (int i=1; i<=this.cantidad + 1; i++) {
//            //Hallar w: Vertice con la distancia mas corta y no visitado.
//            int w = VerticeConDistanciaMasCortaNoVisitado(costos, visitados);
//            visitados[w] = true; //Marcarlo en verde.//Etiqueta definitiva.
//
//            for (int j=1; j<=this.cantidad +1; j++) {
//                //Solo nos interesan los vertices adyacentes a w y que no hayan sido visitados.
//                if (this.sonAdyacentes(w, j) && !visitados[j]) {
//                    //Pregunto si conviene actualizar la distancia a estos vertices.
//                    if (costos[j] > costos[w] + this.matAdy[w][j].peso) {
//                        //Cambio el camino porque encontre una mejor ruta
//                        costos[j] = costos[w] + this.matAdy[w][j].peso;
//                        predecesores[j] = w;
//                    }
//                }
//            }
//        }
//        
//        //FIN LOOP
//        //imprimirCaminos(o,d,predecesores);
//        
//        return costos[d];
//    }
    
    
    
    /****************************************/
    /* DIJKSTRA                             */
    /****************************************/
    public String dijkstraSolo(NodoGrafo origen) {
        int posO = posVertice(origen);
        String dato = "";
        int metros = Integer.MAX_VALUE;;
        //int posD = posVertice(destino);

        // Etapa 1: Inicializo vectores
        int[] dist = new int[tope];
        int[] ant = new int[tope];
        boolean[] vis = new boolean[tope];
        
        //for (int i = 0; i < tope; ant[i] = -1,dist[i] = Integer.MAX_VALUE,i++);
        for (int i = 0; i < tope; i++){
            ant[i] = -1;
            dist[i] = Integer.MAX_VALUE;
        }
        
        dijkstraInterno(posO, dist, ant, vis);
        
        for(int j = 0; j < tope; j++){
            
            NodoGrafo nodoActual = vertices[j];
            if(nodoActual.getDato() instanceof CentroMedico){                         
                CentroMedico centroActual = (CentroMedico)nodoActual.getDato();
                if(centroActual.getCriticidad() == EnumCriticidad.ALTA){
                    if(metros > dist[j]){
                        
                        dato = hacerCamino(j, ant);
                        metros = dist[j];
                        
                    }
                }
            }
            //this.vertices[j].getDato()
        }
        
        dato = dato + "|" + String.valueOf(metros);

        return dato;
    }
    
    //coordx1;coordy1-coordx2;coordy2|coordx1;coordy1-coordx3;coordy3|coordx2;coordy2-coordx4;coordy4
    public String hacerCamino(int dest, int[] ant){ 
        
        String dato = vertices[dest].getStringCord() + "-";
        
        int anterior = ant[dest];
        
        while(anterior != -1){
            dato =  vertices[anterior].getStringCord() + "-" + dato;            
            anterior = ant[anterior];
        }
        
        return dato;
    }
    
    
    public int dijkstra(NodoGrafo origen, NodoGrafo destino) {
        int posO = posVertice(origen);
        int posD = posVertice(destino);

        // Etapa 1: Inicializo vectores
        int[] dist = new int[tope];
        int[] ant = new int[tope];
        boolean[] vis = new boolean[tope];
        
        //for (int i = 0; i < tope; ant[i] = -1,dist[i] = Integer.MAX_VALUE,i++);
        for (int i = 0; i < tope; i++){
            ant[i] = -1;
            dist[i] = Integer.MAX_VALUE;
        }
        
        dijkstraInterno(posO, dist, ant, vis);
        
        if(dist[posD] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[posD];
        }
    }

    private void dijkstraInterno(int posO, int[] dist, int[] ant, boolean[] vis) {
        // Etapa 2: Actualizo las distancias de los adyacentes del origen
        dist[posO] = 0;
        vis[posO] = true;

        for (int i = 0; i < tope; i++) {
            if(matAdy[posO][i].isExiste()) {
                dist[i] = matAdy[posO][i].getPeso();
                ant[i] = posO;
            }
        }

        // Etapa 3: Proceso iterativo para actualizar distancias,
        //    actualizando aquellas aristas que marquen un mejor camino

        for (int k = 1; k < tope; k++) {
            // Elijo al próximo vertice, siendo éste el de menor distancia no visitada
            int posCand = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < tope; i++) {
                if(!vis[i] && dist[i]<min) {
                    min = dist[i];
                    posCand = i;
                }
            }

            // Si no hay candidato, no es conexo.
            if(posCand == -1){
                return;
            }   

            vis[posCand] = true;

            for (int i = 0; i < tope; i++) {
                if(!vis[i] && matAdy[posCand][i].isExiste()){
                    int sumaDist = dist[posCand] + matAdy[posCand][i].getPeso();
                    if(sumaDist < dist[i]){
                        dist[i] = sumaDist;
                        ant[i] = posCand;						
                    }
                }
            }
        }
    }
    
    
    
    /****************************************/
    /* PRIM                                 */
    /****************************************/
    public Grafo prim(){
		
        Grafo ret = new Grafo(tope);

        for (int i = 0; i < tope; i++) {
            if(vertices[i] != null)
            {
                ret.agregarVertice(vertices[i]);
            }
        }

        boolean[] vis = new boolean[tope];
        // for (int i = 0; i < tope; vis[i++]=false);

        vis[posOcupada()] = true;

        for (int k = 0; k < cantidad-1; k++) {

            int min = Integer.MAX_VALUE;
            int posOrigen = -1;
            int posDestino = -1;

            for (int i = 0; i < tope; i++) {
                if(vis[i]){
                    for (int j = 0; j < tope; j++) {
                        if(!vis[j] && matAdy[i][j].isExiste() && matAdy[i][j].getPeso()< min){                            
                            min = matAdy[i][j].getPeso();
                            posOrigen = i;
                            posDestino = j;                            
                        }
                    }
                }
            }
            
            ret.agregarArista(vertices[posOrigen], vertices[posDestino], min);
            vis[posDestino] = true;
            
        }
        
        return ret;
    }

    //CALCULA LA SUMA DE TODAS LAS ARISTAS - HAY QUE TENER EN CUENTA QUE TODOS LOS CAMINOS SON DE DOBLE SENTIDO
    public int TotalDistancias() {
        
        int distanciaTotal = 0;
        
        for(int i = 0; i <  cantidad; i++){
            for(int j = 0; j < tope; j++){
                if(matAdy[i][j].isExiste()){
                    
                    distanciaTotal = distanciaTotal + matAdy[i][j].getPeso();
                }
            }
        }
        return distanciaTotal/2;
    }

    //GENERA UN STRING CON LOS VERTICES - coordx1;coordy1-coordx2;coordy2|coordx1;coordy1-coordx3;coordy3|coordx2;coordy2-coordx4;coordy4
    public String CaminoString() {
        
        String retorno = "";
        
        for(int i = 0; i <  cantidad; i++){
            for(int j = 0; j < tope; j++){
                if(matAdy[i][j].isExiste()){
                    
                    retorno = retorno + vertices[i].getCoordX() + ";" + vertices[i].getCoordY();
                    retorno = retorno + "-";
                    retorno = retorno + vertices[j].getCoordX() + ";" + vertices[j].getCoordY();
                    retorno = retorno + "|";
                    
                    //lo marca como visitado para que no lo sume otra vez.
                    matAdy[j][i].existe = false;
                }
            }
        }
        
        retorno = retorno.substring(0, retorno.length()-1);
    
        return retorno;
    }

    
    
}
