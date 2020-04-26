package uy.ort.ob2020;


public interface ISistema {
	
	Retorno inicializarSistema (int maxPuntos);
	
	Retorno destruirSistema();
	
	Retorno registrarRepartidor(int id, String cedula, String nombre, String email);
	
	Retorno buscarRepartidor(String Ci);
	
	Retorno listarRepartidores();
	
	Retorno registrarCentro(String nombre, Double coordX, Double coordY, EnumCriticidad criticidad);
	
	Retorno registrarEsquina(Double coordX, Double coordY);
	
	Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int metros);
	
	Retorno centroCriticoMasCercano(Double coordX, Double coordY);
	
	Retorno caminoSeguro();

	Retorno dibujarMapa();
	
	
	
}
