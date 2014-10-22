package controller;

import dto.DtoPojos;
import modelo.ModeloPersona;

public class ControladorPersona {

    private final ModeloPersona modeloPersona;
    private DtoPojos pojos;

    public ControladorPersona() {
        modeloPersona = new ModeloPersona();

    }

    public void insertar(String documento_identidad, String antecedentes_penales, String direccion,
            String telefono, String email, String nombres, String apellidos) {
        if (modeloPersona.insertar(new DtoPojos(documento_identidad, antecedentes_penales, direccion,
                telefono, email, nombres, apellidos), email)) {
            System.out.println("Usuario registrado con exitos ");
        } else {
            System.out.println("Usuario no registrado");
        }
    }

    public void modificar(String id, String documento_identidad, String antecedentes_penales, String direccion,
            String telefono, String email, String nombres, String apellidos) {
        if (modeloPersona.modificar(id, new DtoPojos(documento_identidad, antecedentes_penales, direccion,
                telefono, email, nombres, apellidos))) {

            System.out.println("Usuario modificado con exitos ");

        } else {
            System.out.println("Usuario no registrado");
        }
    }

    public void eliminal(String id) {
        if (modeloPersona.eliminar(id)) {
            System.out.println("Usuario eliminado con exitos");
        } else {
            System.out.println("Usuario no eliminado");
        }
    }

    public void buscar(String id) {
        if (id.equals("") || id.length() == 0) {
            System.out.println("Id no recibido");

        } else {
            pojos = modeloPersona.leer(id);
            try {

                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("%15s %15s %15s %15s %15s %15s %15s", "Documento Identidad", "Antecedentes penales", "Direccion", "Telefono", "Email", "Nombres", "Apellidos");
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

                System.out.format("%15s %15s %15s %15s %15s %15s %15s", pojos.getIdentificacion(), pojos.getAntecedentesPenales(),
                        pojos.getDireccion(), pojos.getTelefono(), pojos.getEmail(), pojos.getNombre(), pojos.getApellidos());
            } catch (Exception e) {
                System.out.println("Usuario no encontrado");
            }
        }

    }

    public void listar() {

        for (DtoPojos dp : modeloPersona.leerTodos()) {
            System.out.println("Documento Identidad: " + dp.getIdentificacion() + "  |Antecendentes penales: " + dp.getAntecedentesPenales() + "  |Direccion: " + dp.getDireccion() + "  |Telefono: " + dp.getTelefono() + "  |Email" + dp.getEmail() + "  |Nombres: " + dp.getNombre() + "  |Apellidos: " + dp.getApellidos() + "\n");
        }
    }

}
