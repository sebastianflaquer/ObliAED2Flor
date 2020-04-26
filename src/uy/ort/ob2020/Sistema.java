package uy.ort.ob2020;

public class Sistema implements ISistema{
	
    private int maxPuntos;
	
    //GETERS Y SETTERS
    public int getMaxPuntos() {
        return maxPuntos;
    }
    public void setMaxPuntos(int maxPuntos) {
        this.maxPuntos = maxPuntos;
    }
    
    ///////////////////////////////////////////////////////////
    //METODOS                                                //
    ///////////////////////////////////////////////////////////    
    
	
    @Override
    public Retorno inicializarSistema(int maxPuntos) {
        if(maxPuntos > 0){
                this.setMaxPuntos(maxPuntos);
                return new Retorno(Retorno.Resultado.OK);
        }
        return new Retorno(Retorno.Resultado.ERROR_1);
    }

    @Override
       public Retorno destruirSistema() {		
        this.setMaxPuntos(0);
        return new Retorno(Retorno.Resultado.OK);
    }
       
    @Override
    public Retorno registrarRepartidor(String matricula, String nombre) {
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno buscarRepartidor(String Ci) {
        // TODO Auto-generated method stub
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno listarRepartidores() {
        // TODO Auto-generated method stub
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno registrarCentro(String nombre, Double coordX, Double coordY, EnumCriticidad criticidad) {
        // TODO Auto-generated method stub
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno registrarEsquina(Double coordX, Double coordY) {
        // TODO Auto-generated method stub
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int metros) {
        // TODO Auto-generated method stub
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno centroCriticoMasCercano(Double coordX, Double coordY) {
        // TODO Auto-generated method stub
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno caminoSeguro() {
        // TODO Auto-generated method stub
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno dibujarMapa() {
        // TODO Auto-generated method stub
        return new Retorno(Retorno.Resultado.OK);
    }	

    Object registrarRepartidor(int i, String sebastian_Flaquer, String sgmailcom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
	
	
}