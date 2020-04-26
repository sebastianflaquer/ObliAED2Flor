package uy.ort.ob2020;

public class Repartidor implements Comparable<Repartidor>{
	private int id;
    private String CI;
    private String Nombre;
    private String email;

    //CONSTRUCTOR
    public Repartidor(int id, String CI, String Nombre) {
        this.id = id;
        this.CI = CI;
        this.Nombre = Nombre;
    }

    //GETTER AND SETTER
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Repartidor t) {
        int ret = (int) Math.signum(this.CI.compareTo(t.CI));
        return ret;
    }
}
