package uy.ort.ob2020;

public class Sistema implements ISistema{
	
	private int maxPuntos;
	private int cantPuntos;
    private Double coordX;
    private Double coordY;
    private int[][] matrizVertices;
	
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
    
    public int[][] getMatrizVertices() {
        return matrizVertices;
    }
    public void setMatrizVertices(int[][] matrizVertices) {
        this.matrizVertices = matrizVertices;
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
	public Retorno registrarRepartidor(int id, String cedula, String nombre, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retorno buscarRepartidor(String Ci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retorno listarRepartidores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retorno registrarCentro(String nombre, Double coordX, Double coordY, EnumCriticidad criticidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retorno registrarEsquina(Double coordX, Double coordY) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int metros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retorno centroCriticoMasCercano(Double coordX, Double coordY) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retorno caminoSeguro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retorno dibujarMapa() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	
}