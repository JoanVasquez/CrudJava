package dto;

/**
 *
 * @author Administrador
 */
public class DtoPojos {

    private String id;
    private String identificacion;
    private String antecedentesPenales;
    private String direccion;
    private String email;
    private String nombre;
    private String apellidos;
    private String telefono;

    public DtoPojos() {

    }

    public DtoPojos(String id) {
        this.id = id;
    }

    public DtoPojos(String identificacion, String antecedentesPenales, String direccion, String telefono, String email, String nombre, String apellidos) {
        this.identificacion = identificacion;
        this.antecedentesPenales = antecedentesPenales;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;

    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getAntecedentesPenales() {
        return antecedentesPenales;
    }

    public void setAntecedentesPenales(String antecedentesPenales) {
        this.antecedentesPenales = antecedentesPenales;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

}
