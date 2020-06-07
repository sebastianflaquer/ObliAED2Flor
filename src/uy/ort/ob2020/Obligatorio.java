package uy.ort.ob2020;

public class Obligatorio {
	
	public static void main(String[] args) {
        // TODO code application logic here
        
        Sistema s = new Sistema();
        Prueba p = new Prueba();
        
        s.inicializarSistema(12);
       
        prueba1(s,p);
        //prueba2(s,p);
        
    }
	
    //PRUEBA 1
    static void prueba1(Sistema s, Prueba p){
        
        ////////////////////////////
        // PUNTOS                 //
        ////////////////////////////
        //MEDICA URUGUAYA
        Double PuntoAx = -34.893308;
        Double PuntoAy = -56.162643;       
        
        //CASMU
        Double PuntoBx = -34.887946; 
        Double PuntoBy = -56.162160;
        
        //CIRCULO CATOLICO
        Double PuntoCx = -34.888513; 
        Double PuntoCy = -56.165397;
        
        //MEDICINA PERSONALIZADA       
        Double PuntoDx = -34.897972;
        Double PuntoDy = -56.158385;
        
        //SMI
        Double PuntoEx = -34.895882;
        Double PuntoEy = -56.150601;
        
        //LA ESPAÑOLA
        Double PuntoFx = -34.900484;
        Double PuntoFy = -56.164556;
        
        //SEM
        Double PuntoGx = -34.912917;
        Double PuntoGy = -56.162763;
        
        //ESQUINAS
        Double PuntoHx = -34.886598;
        Double PuntoHy = -56.136361;
        
        Double PuntoIx = -34.907627;
        Double PuntoIy = -56.155776;
        
        Double PuntoJx = -34.901418;
        Double PuntoJy = -56.174630;
        
        Double PuntoKx = -34.908761;
        Double PuntoKy = -56.169940;
        
        Double PuntoMx = -34.891956;
        Double PuntoMy = -56.169030;
        
        //puntos que no se ingresan en el sistems
        Double PuntoXx = -34.111111;
        Double PuntoXy = -56.111111;
        ////////////////////////////
        // END PUNTOS             //
        ////////////////////////////
        
        //REGISTRAR REPARTIDORES
        p.imprimirComentario("REGISTRAMOS REPARTIDORES");
        p.ver(s.registrarRepartidor("OAA2222","Sebastian").resultado, Retorno.Resultado.OK, "Se agrego Repartidor");
        p.ver(s.registrarRepartidor("OAA1111","Agustin").resultado, Retorno.Resultado.OK, "Se agrego Repartidor");
        p.ver(s.registrarRepartidor("OA 33333","Juan").resultado, Retorno.Resultado.ERROR_1, "No Se agrego Repartidor Matricula Incorrecta");        
        p.ver(s.registrarRepartidor("OAA4444","Pedro").resultado, Retorno.Resultado.OK, "Se agrego Repartidor");
        
        //BUSCAR REPARTIDORES
        p.imprimirComentario("BUSCAR REPARTIDORES");
        p.ver(s.buscarRepartidor("OAA4444").resultado, Retorno.Resultado.OK, "Se Busco Repartidor");
        
        //REPARTIDORES
        p.imprimirComentario("LISTAR TODOS LOS REPARTIDORES");
        p.ver(s.listarRepartidores().resultado, Retorno.Resultado.OK, "Se listaron los Repartidores");
        System.out.print( "Datos Repartidores:"+ s.listarRepartidores().valorString + "\n");
        System.out.print( "\n");
        
        //CENTRO MEDICO
        p.imprimirComentario("REGISTRAR CENTRO MEDICO");
        p.ver(s.registrarCentro("Medica Uruguaya", PuntoAx, PuntoAy, EnumCriticidad.BAJA).resultado, Retorno.Resultado.OK,  "Se registro centro medico");        
        p.ver(s.registrarCentro("CASMU", PuntoBx, PuntoBy, EnumCriticidad.BAJA).resultado, Retorno.Resultado.OK,  "Se registro centro medico");
        p.ver(s.registrarCentro("Circulo Catolico", PuntoCx, PuntoCy, EnumCriticidad.ALTA).resultado, Retorno.Resultado.OK,  "Se registro centro medico");
        p.ver(s.registrarCentro("Medicina Peronalizada", PuntoDx, PuntoDy, EnumCriticidad.BAJA).resultado, Retorno.Resultado.OK,  "Se registro centro medico");
        p.ver(s.registrarCentro("SMI", PuntoEx, PuntoEy, EnumCriticidad.MEDIA).resultado, Retorno.Resultado.OK,  "Se registro centro medico");
        p.ver(s.registrarCentro("La Española", PuntoFx, PuntoFy, EnumCriticidad.BAJA).resultado, Retorno.Resultado.OK,  "Se registro centro medico");
        p.ver(s.registrarCentro("SEM", PuntoGx, PuntoGy, EnumCriticidad.MEDIA).resultado, Retorno.Resultado.OK,  "Se registro centro medico");
        //ERROR AL REGISTRAR CENTRO REPETIDO
        p.ver(s.registrarCentro("Medica Uruguaya", PuntoAx, PuntoAy, EnumCriticidad.BAJA).resultado, Retorno.Resultado.ERROR_2,  "No Se registro centro medico por estar duplicado");
        
        
        //ESQUINA
        p.imprimirComentario("REGISTRAR ESQUINA");
        p.ver(s.registrarEsquina(PuntoHx, PuntoHy).resultado, Retorno.Resultado.OK, "Se Registro la Esquina");
        p.ver(s.registrarEsquina(PuntoIx, PuntoIy).resultado, Retorno.Resultado.OK, "Se Registro la Esquina");
        p.ver(s.registrarEsquina(PuntoJx, PuntoJy).resultado, Retorno.Resultado.OK, "Se Registro la Esquina");
        p.ver(s.registrarEsquina(PuntoKx, PuntoKy).resultado, Retorno.Resultado.OK, "Se Registro la Esquina");
        p.ver(s.registrarEsquina(PuntoMx, PuntoMy).resultado, Retorno.Resultado.OK, "Se Registro la Esquina");
        //ERROR AL REGISTRAR ESQUINA REPETIDA
        p.ver(s.registrarEsquina(PuntoHx, PuntoHy).resultado, Retorno.Resultado.ERROR_2, "NO Se Registro la Esquina");                
        
        
        //TRAMO       
        p.imprimirComentario("REGISTRAR TRAMO");
        
        //SOLO CENTROS
        p.ver(s.registrarTramo(PuntoAx, PuntoAy, PuntoCx, PuntoCy, 500).resultado, Retorno.Resultado.OK, "Se Registro Tramo Medica - Circulo Catolico");
        p.ver(s.registrarTramo(PuntoAx, PuntoAy, PuntoBx, PuntoBy, 400).resultado, Retorno.Resultado.OK, "Se Registro Tramo Medica - Casmu");
        p.ver(s.registrarTramo(PuntoBx, PuntoBy, PuntoEx, PuntoEy, 700).resultado, Retorno.Resultado.OK, "Se Registro Tramo Casmu - SMI");
        p.ver(s.registrarTramo(PuntoEx, PuntoEy, PuntoDx, PuntoDy, 400).resultado, Retorno.Resultado.OK, "Se Registro Tramo SMI - MP");
        p.ver(s.registrarTramo(PuntoDx, PuntoDy, PuntoFx, PuntoFy, 300).resultado, Retorno.Resultado.OK, "Se Registro Tramo MP - La Española");
        p.ver(s.registrarTramo(PuntoFx, PuntoFy, PuntoGx, PuntoGy, 500).resultado, Retorno.Resultado.OK, "Se Registro Tramo La Española - SEM");
        p.ver(s.registrarTramo(PuntoFx, PuntoFy, PuntoAx, PuntoAy, 500).resultado, Retorno.Resultado.OK, "Se Registro Tramo La Española - Medica Uruguaya");
        
        //CON ESQUINAS
        p.ver(s.registrarTramo(PuntoKx, PuntoKy, PuntoGx, PuntoGy, 700).resultado, Retorno.Resultado.OK, "Se Registro Tramo Esquina K - SEM ");
        p.ver(s.registrarTramo(PuntoGx, PuntoGy, PuntoIx, PuntoIy, 600).resultado, Retorno.Resultado.OK, "Se Registro Tramo SEM - Esquina I");
        p.ver(s.registrarTramo(PuntoIx, PuntoIy, PuntoDx, PuntoDy, 400).resultado, Retorno.Resultado.OK, "Se Registro Tramo Esquina I - MP");
        p.ver(s.registrarTramo(PuntoEx, PuntoEy, PuntoHx, PuntoHy, 1200).resultado, Retorno.Resultado.OK, "Se Registro Tramo SMI - Esquina H");
        p.ver(s.registrarTramo(PuntoHx, PuntoHy, PuntoBx, PuntoBy, 1500).resultado, Retorno.Resultado.OK, "Se Registro Tramo Esquina H - CASMU");
        p.ver(s.registrarTramo(PuntoKx, PuntoKy, PuntoJx, PuntoJy, 600).resultado, Retorno.Resultado.OK, "Se Registro Tramo Esquina K - Esquina J");
        p.ver(s.registrarTramo(PuntoJx, PuntoJy, PuntoMx, PuntoMy, 800).resultado, Retorno.Resultado.OK, "Se Registro Tramo Esquina J - Esquina M");
        p.ver(s.registrarTramo(PuntoJx, PuntoJy, PuntoFx, PuntoFy, 400).resultado, Retorno.Resultado.OK, "Se Registro Tramo Esquina J - La Española");
        p.ver(s.registrarTramo(PuntoMx, PuntoMy, PuntoCx, PuntoCy, 400).resultado, Retorno.Resultado.OK, "Se Registro Tramo Esquina M - Circulo Catolico");
        p.ver(s.registrarTramo(PuntoMx, PuntoMy, PuntoAx, PuntoAy, 300).resultado, Retorno.Resultado.OK, "Se Registro Tramo Esquina M - Medica Uruguaya");
        
        //error
        p.ver(s.registrarTramo(PuntoMx, PuntoMy, PuntoAx, PuntoAy,0).resultado, Retorno.Resultado.ERROR_1, "No se registro porque los metros son 0");
        
        //CENTRO MEDICO MAS CERCANO
        p.ver(s.centroCriticoMasCercano(PuntoIx, PuntoIy).resultado, Retorno.Resultado.OK, "El centro medico mas cercano desde Esquina I");
        System.out.print( "Se encuentra a:"+ s.centroCriticoMasCercano(PuntoIx, PuntoIy).valorEntero + "metros \n");
        System.out.print( "Y se llama:"+ s.centroCriticoMasCercano(PuntoIx, PuntoIy).valorString + "\n");
        System.out.print( "\n");
        
        p.ver(s.centroCriticoMasCercano(PuntoXx, PuntoXy).resultado, Retorno.Resultado.ERROR_1, "Si la esquina no existe:\n");
        System.out.print( "Se encuentra a:"+ s.centroCriticoMasCercano(PuntoIx, PuntoIy).valorEntero + "metros \n");
        System.out.print( "Y se llama:"+ s.centroCriticoMasCercano(PuntoIx, PuntoIy).valorString + "\n");
        System.out.print( "\n");
        
        //modifica la criticidad de los centros que tienen ALTA a BAJA
        p.ver(s.centroCriticoMasCercano(PuntoIx, PuntoIy).resultado, Retorno.Resultado.ERROR_2, "Si no encuentra un centro con criticidad ALTA:\n");        
        System.out.print( "Se encuentra a:"+ s.centroCriticoMasCercano(PuntoIx, PuntoIy).valorEntero + "metros \n");
        System.out.print( "Y se llama:"+ s.centroCriticoMasCercano(PuntoIx, PuntoIy).valorString + "\n");
        System.out.print( "\n");
        
        //CAMINO SEGURO
        p.imprimirComentario("CAMINO SEGURO");        
        p.ver(s.caminoSeguro().resultado, Retorno.Resultado.OK, "EL camino seguro es: \n");
        System.out.print( "\n"+ s.caminoSeguro().valorString + "\n");
        System.out.println();
        
        p.imprimirComentario("DIBUJAR MAPA");
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
