package uy.ort.ob2020;

public class Obligatorio {
	
	public static void main(String[] args) {
        // TODO code application logic here
        
        Sistema s = new Sistema();
        Prueba p = new Prueba();
        
        s.inicializarSistema(10);
       
        prueba1(s,p);
        //prueba2(s,p);
        
    }
	
    //PRUEBA 1
    static void prueba1(Sistema s, Prueba p){
        
        ////////////////////////////
        // PUNTOS                 //
        ////////////////////////////
        Double PuntoSx = -34.897518;
        Double PuntoSy = -56.164655;
        
        Double PuntoAx = -34.886598;
        Double PuntoAy = -56.136361;
        
        Double PuntoBx = -34.907627;
        Double PuntoBy = -56.155776;
        
        Double PuntoCx = -34.901418;
        Double PuntoCy = -56.174630;
        
        Double PuntoDx = -34.908761;
        Double PuntoDy = -56.169940;
        
        Double PuntoEx = -34.891956;
        Double PuntoEy = -56.169030;
        
        Double PuntoFx = -34.872275;
        Double PuntoFy = -56.146211;
        
        Double PuntoGx = -34.920027;
        Double PuntoGy = -56.161021;
        ////////////////////////////
        // END PUNTOS             //
        ////////////////////////////
        
        //REGISTRAR REPARTIDORES
        p.imprimirComentario("REGISTRAMOS REPARTIDORES");
        p.ver(s.registrarRepartidor("OAA2222","Sebastian").resultado, Retorno.Resultado.OK, "Se agrego Repartidor");
        p.ver(s.registrarRepartidor("OAA1111","Agustin").resultado, Retorno.Resultado.OK, "Se agrego Repartidor");
        p.ver(s.registrarRepartidor("OA 33333","Juan").resultado, Retorno.Resultado.ERROR_1, "No Se agrego Repartidor Matricula Incorrecta");        
        p.ver(s.registrarRepartidor("OAA4444","Pedro").resultado, Retorno.Resultado.OK, "Se agrego Repartidor");
        
        p.imprimirComentario("BUSCAR REPARTIDORES");
        p.ver(s.buscarRepartidor("OAA4444").resultado, Retorno.Resultado.OK, "Se Busco Repartidor");
        
        p.imprimirComentario("LISTAR TODOS LOS REPARTIDORES");
        p.ver(s.listarRepartidores().resultado, Retorno.Resultado.OK, "Se listaron los Repartidores");
        System.out.print( "Datos Repartidores:"+ s.listarRepartidores().valorString + "\n");
        System.out.print( "\n");
        
        p.imprimirComentario("REGISTRAR CENTRO MEDICO");
        p.ver(s.registrarCentro("Medica Uruguaya", PuntoAx, PuntoAy, EnumCriticidad.ALTA).resultado, Retorno.Resultado.OK,  "Se registro centro medico");        
        p.ver(s.registrarCentro("CASMU", PuntoBx, PuntoBy, EnumCriticidad.BAJA).resultado, Retorno.Resultado.OK,  "Se registro centro medico");
        p.ver(s.registrarCentro("Circulo Catolico", PuntoCx, PuntoCy, EnumCriticidad.ALTA).resultado, Retorno.Resultado.OK,  "Se registro centro medico");
        p.ver(s.registrarCentro("Medicina Peronalizada", PuntoDx, PuntoDy, EnumCriticidad.BAJA).resultado, Retorno.Resultado.OK,  "Se registro centro medico");
        p.ver(s.registrarCentro("SMI", PuntoEx, PuntoEy, EnumCriticidad.MEDIA).resultado, Retorno.Resultado.OK,  "Se registro centro medico");
        p.ver(s.registrarCentro("La Española", PuntoFx, PuntoFy, EnumCriticidad.BAJA).resultado, Retorno.Resultado.OK,  "Se registro centro medico");
        p.ver(s.registrarCentro("SEM", PuntoGx, PuntoGy, EnumCriticidad.MEDIA).resultado, Retorno.Resultado.OK,  "Se registro centro medico");
        
        p.ver(s.registrarCentro("Medica Uruguaya", PuntoAx, PuntoAy, EnumCriticidad.BAJA).resultado, Retorno.Resultado.ERROR_2,  "No Se registro centro medico por estar duplicado");
        
        
        
        
        //p.imprimirComentario("REGISTRAR ESQUINA");
        
        //p.imprimirComentario("REGISTRAR TRAMO");
        
        //p.imprimirComentario("REGISTRAR");
        
        //p.imprimirComentario("REGISTRAR");        
        p.ver(s.dibujarMapa().resultado, Retorno.Resultado.OK, "Dibujar Mapa");
        
        
        //IMPRIMIR DATOS DE PRUEBA
        p.imprimirResultadosPrueba();
        
        
        
    }
    
    //PRUEBA 2
    static void prueba2(Sistema s, Prueba p){
//        p.imprimirComentario("CREAMOS SISTMA PARA 5 CIUDADES");
//        p.ver(s.crearSistemaEmergencias(5).resultado, Retorno.Resultado.OK, "Se creó el sistema de reservas");
//        p.imprimirComentario("INGRESAMOS CIUDADES");
//        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresa Montevideo");
//        p.ver(s.registrarCiudad("Santiago").resultado, Retorno.Resultado.OK, "Se ingresa Santiago");
//        p.ver(s.registrarCiudad("Lima").resultado, Retorno.Resultado.OK, "Se ingresa Lima");
//        p.ver(s.registrarCiudad("San Pablo").resultado, Retorno.Resultado.OK, "Se ingresa San Pablo");
//        p.ver(s.registrarCiudad("New York").resultado, Retorno.Resultado.OK, "Se ingresa New York");
//
//        p.imprimirComentario("INGRESAMOS CIUDAD REPETIDA");
//        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.ERROR_1, "Montevideo ya existe");
//
//        p.imprimirComentario("INTENTAMOS SOBREPASAR EL LIMITE DE CIUDADES");
//        p.ver(s.registrarCiudad("Buenos Aires").resultado, Retorno.Resultado.ERROR_2, "Se sobrepasa el l�mite de ciudades gestionados por el sistema");
//
//        p.imprimirResultadosPrueba();   
    }
}
