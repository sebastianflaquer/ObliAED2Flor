package uy.ort.ob2020;

import java.awt.Desktop;
import java.net.URL;
import uy.ort.ob2020.Grafo.Arista;
import uy.ort.ob2020.Grafo.Grafo;
import uy.ort.ob2020.Grafo.NodoGrafo;

public class Sistema implements ISistema{
	
    private int maxPuntos;
    private int cantPuntos;
    //public Double coordX;
    //public Double coordY;
    private ABBRepartidor ABBRepartidores;
    private Grafo Grafo;
	
    //GETERS Y SETTERS
    public int getMaxPuntos() {
        return maxPuntos;
    }
    public void setMaxPuntos(int maxPuntos) {
        this.maxPuntos = maxPuntos;
    }
    public int getCantPuntos() {
        return cantPuntos;
    }
    public void setCantPuntos(int cantPuntos) {
        this.cantPuntos = cantPuntos;
    }
    
//    public Double getCoordX() {
//        return coordX;
//    }
//    public void setCoordX(Double coordX) {
//        this.coordX = coordX;
//    }
//    public Double getCoordY() {
//        return coordY;
//    }
//    public void setCoordY(Double coordY) {
//        this.coordY = coordY;
//    }
    
    public ABBRepartidor getAbbRepartidores() {
        return ABBRepartidores;
    }
    public void setAbbRepartidores(ABBRepartidor AbbRepartidores) {
        this.ABBRepartidores = AbbRepartidores;
    }
    public Grafo getGrafo() {
        return Grafo;
    }
    public void setGrafo(Grafo Grafo) {
        this.Grafo = Grafo;
    }
    
    ///////////////////////////////////////////////////////////
    //METODOS                                                //
    ///////////////////////////////////////////////////////////    
	
    
    //INICIAR SISTEMA  - REVISAR
    @Override
    public Retorno inicializarSistema(int maxPuntos) {
        if(maxPuntos > 0){
            this.setMaxPuntos(maxPuntos);
            this.setAbbRepartidores(new ABBRepartidor());
            this.setGrafo(new Grafo(maxPuntos));
            
            return new Retorno(Retorno.Resultado.OK);
        }
        return new Retorno(Retorno.Resultado.ERROR_1);
    }
    
    //DESTRUIR SISTEMA  - REVISAR
    @Override
    public Retorno destruirSistema() {		
        this.setMaxPuntos(0);
        return new Retorno(Retorno.Resultado.OK);
    }
       
    //REGISTRAR REPARTIDOR  - REVISAR
    @Override
    public Retorno registrarRepartidor(String matricula, String nombre) {
        
        //BUSCAR SI EXITE EL REPARTIDOR
        busquedaRepartidor BusRep = this.ABBRepartidores.buscarPorMatricula(matricula);
        
        //SI EL REPARTIDOR YA EXISTE
        if(BusRep != null){
            return new Retorno(Retorno.Resultado.ERROR_2);
        }else{
            //SI LA MATRICULA ES VALIDA
            if(this.ABBRepartidores.esMatriculaValida(matricula)){
                //REGISTRA EL REPARTIDOR
                Repartidor RepActual = new Repartidor(matricula, nombre);
                this.ABBRepartidores.insertar(RepActual);
                return new Retorno(Retorno.Resultado.OK);
            }else{
                return new Retorno(Retorno.Resultado.ERROR_1);
            }
        }
    }
    
    //BUSCAR REPARTIDOR - REVISAR
    @Override
    public Retorno buscarRepartidor(String matricula) {
        
        String datoRepartidor = "";
        int canrRecorrida = 0;
        
        //VALIDA MATRICULA
        if(this.ABBRepartidores.esMatriculaValida(matricula)){
            
            //BUSCAR SI EXITE EL REPARTIDOR
            busquedaRepartidor BusRep = this.ABBRepartidores.buscarPorMatricula(matricula);
            if(BusRep != null){
                datoRepartidor = BusRep.getRepartidor().obtener().getMatricula();
                datoRepartidor = datoRepartidor +"; ";
                datoRepartidor = datoRepartidor + BusRep.getRepartidor().obtener().getNombre();
                canrRecorrida = BusRep.getCantidad();
                return new Retorno(Retorno.Resultado.OK, datoRepartidor, canrRecorrida);
            }
            
            return new Retorno(Retorno.Resultado.ERROR_2);
            
        }else{
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
    }

    
    //LISTAR REPARTIDOR  - REVISAR
    @Override
    public Retorno listarRepartidores() {
        
        String datosAfiliado = this.ABBRepartidores.listarAscendente();
        datosAfiliado = datosAfiliado.substring(0, datosAfiliado.length()-1);
        return new Retorno(Retorno.Resultado.OK, datosAfiliado, 0);
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////
    // HASTA ACA                                                                                //
    //////////////////////////////////////////////////////////////////////////////////////////////
    
    
    //REGISTRAR CENTRO - REVISAR
    @Override  
    public Retorno registrarCentro(String nombre, double coordX, double coordY, EnumCriticidad criticidad) {
        
        //si la cantidad es menor que el maximo
        if(cantPuntos < maxPuntos){
            
            CentroMedico CentroActual = new CentroMedico(nombre, coordX, coordY, criticidad);
            NodoGrafo nodoActual = new NodoGrafo(CentroActual, coordX, coordY);
            
            //busca si ya existe un punto en esas cordenadas
            boolean existe = this.Grafo.existeVerticeCord(coordX, coordY);
            
            if(!existe){ 
                
                //SI NO EXISTE AGREGA AL GRAFO                
                this.Grafo.agregarVertice(nodoActual);
                return new Retorno(Retorno.Resultado.OK);
                
            }else{
                //SI YA EXISTE EL CENTRO MEDICO
                return new Retorno(Retorno.Resultado.ERROR_2);
            }
        }else{
            //SI YA SE SUPERO EL MAXIMO
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
    }
    
    //REGISTRAR ESQUINA  - REVISAR
    @Override
    public Retorno registrarEsquina(double coordX, double coordY) {
        
        //si la cantidad es menor que el maximo
        if(cantPuntos < maxPuntos){
            
            Esquina EsquinaActual = new Esquina(coordX, coordY);
            NodoGrafo nodoActual = new NodoGrafo(EsquinaActual, coordX, coordY);
            
            //busca si ya existe un punto en esas cordenadas
             boolean existe = this.Grafo.existeVerticeCord(coordX, coordY);
            if(!existe){ 
                
                //SI NO EXISTE AGREGA AL GRAFO                
                this.Grafo.agregarVertice(nodoActual);
                return new Retorno(Retorno.Resultado.OK);
                
            }else{
                //SI YA EXISTE EL CENTRO MEDICO
                return new Retorno(Retorno.Resultado.ERROR_2);
            }
        }else{
            //SI YA SE SUPERO EL MAXIMO
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
    }
    
    //REGISTRAR TRAMO
    @Override
    public Retorno registrarTramo(double coordXi, double coordYi, double coordXf, double coordYf, int metros) {
        
        if(metros > 0){
            
            NodoGrafo nodoOrigen = this.Grafo.existeVerticeCordenadas(coordXi, coordYi);
            NodoGrafo nodoDestino = this.Grafo.existeVerticeCordenadas(coordXf, coordYf);
            
            //si existe los nodos para agregar el tramo
            if(nodoOrigen != null && nodoDestino != null){
                
                boolean existeArista = this.Grafo.existeArista(nodoOrigen, nodoDestino);
                
                //si el tramo no existe
                if(!existeArista){
                
                    //CREO EL TRAMO
                    this.Grafo.agregarArista(nodoOrigen, nodoDestino, metros);
                    return new Retorno(Retorno.Resultado.OK);
                    
                }else{
                    return new Retorno(Retorno.Resultado.ERROR_3);
                }
            }else{
                return new Retorno(Retorno.Resultado.ERROR_2);
            }
        }else{
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
    }
    
    //CENTRO CRITICO MAS CERCANO
    @Override
    public Retorno centroCriticoMasCercano(double coordX, double coordY) {
        
        // TODO Auto-generated method stub
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        
    }
    
    //CAMINO SEGURO
    @Override
    public Retorno caminoSeguro() {
        
        // TODO Auto-generated method stub
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        
    }

    //DIBUJAR MAPA
    @Override
    public Retorno dibujarMapa() {
        
        String url = mimapa.getURLMapaPuntos(this.Grafo);
        
        try {
            Desktop.getDesktop().browse(new URL(url).toURI());
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        }
         return new Retorno(Retorno.Resultado.OK);
         
    }
}