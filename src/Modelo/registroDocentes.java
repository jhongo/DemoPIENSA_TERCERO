package Modelo;


public class registroDocentes {

     private int Id;
    private String usuario;
    private String password;
    private String nombre;
    private String correo;
    private String last_sesion; 

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getLast_sesion() {
        return last_sesion;
    }

    public void setLast_sesion(String last_sesion) {
        this.last_sesion = last_sesion;
    }
    
    
    
    
}
