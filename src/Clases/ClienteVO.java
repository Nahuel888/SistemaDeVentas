package Clases;

import java.sql.Date;

/**
 *
 * @author nahuel
 */
public class ClienteVO {
    
    private int numeroCliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private String fechaNacimiento;
    private int telefono;
    private String email;
    private int dni;

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public int getDni() {
        return dni;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
     
    
    
}
