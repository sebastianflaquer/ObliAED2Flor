package uy.ort.ob2020;

public class Repartidor implements Comparable<Repartidor>{
    private String Matricula;
    private String Nombre;

    //CONSTRUCTOR
    public Repartidor(String Matricula, String Nombre) {
        this.Matricula = Matricula;
        this.Nombre = Nombre;
    }

    //GETTER AND SETTER
    
    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public int compareTo(Repartidor t) {
        int ret = (int) Math.signum(this.Matricula.compareTo(t.Matricula));
        return ret;
    }
}
