package crudjava;

import controller.ControladorPersona;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CrudJava {

    private static int opciones, tareas;
    private static boolean interruptor = true;
    private static ControladorPersona controladorPersona;
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

   public static void main(String[] args) {

        System.out.println("-----------------------------------");
        System.out.println("*                                 *");
        System.out.println("*******Welcome to the System*******");
        System.out.println("*                                 *");
        System.out.println("-----------------------------------");
        while (interruptor) {
            System.out.println("\n \nPor favor elija una opcion: \n 1 - Registrars"
                    + "\n 2 - Ingresar al sistema");

            try {
                opciones = Integer.parseInt(reader.readLine());
                if (opciones == 1) {
                    System.out.println("Ingrese la identificacion: ");
                    String identificacion = reader.readLine();

                    System.out.println("Ingrese la Antecedentes penales: ");
                    String antecedentesPenales = reader.readLine();

                    System.out.println("Ingrese la direccion: ");
                    String direccion = reader.readLine();

                    System.out.println("Ingrese el telefono: ");
                    String telefono = reader.readLine();

                    System.out.println("Ingrese el Correo electronico: ");
                    String email = reader.readLine();

                    System.out.println("Ingrese el nombre: ");
                    String nombre = reader.readLine();

                    System.out.println("Ingrese los apellidos: ");
                    String apellidos = reader.readLine();

                    controladorPersona = new ControladorPersona();
                    controladorPersona.insertar(identificacion, antecedentesPenales, direccion, telefono, email, nombre, apellidos);

                } else if (opciones == 2) {
                    ingresarAlSistema();
                    tareas = Integer.parseInt(reader.readLine());

                    if (tareas == 1) {
                        modificar();
                    } else if (tareas == 2) {
                        eliminar();

                    } else if (tareas == 3) {
                        buscar();
                    } else if (tareas == 4) {
                        listar();
                    } else if (tareas == 5) {
                        interruptor = false;
                    }

                }
            } catch (NumberFormatException e) {
                System.out.println("Solo numeros, Por favor elija una opcion");
            } catch (IOException ex) {
                System.out.println("Error al elegir la opcion");
            }
        }
    }

    private static void modificar() {
        try {
            System.out.println("Id del usuario a modificar: ");
            String id = reader.readLine();

            System.out.println("Ingrese la identificacion: ");
            String identificacion = reader.readLine();

            System.out.println("Ingrese la Antecedentes penales: ");
            String antecedentesPenales = reader.readLine();

            System.out.println("Ingrese la direccion: ");
            String direccion = reader.readLine();

            System.out.println("Ingrese el telefono: ");
            String telefono = reader.readLine();

            System.out.println("Ingrese el Correo electronico: ");
            String email = reader.readLine();

            System.out.println("Ingrese el nombre: ");
            String nombre = reader.readLine();

            System.out.println("Ingrese los apellidos: ");
            String apellidos = reader.readLine();

            controladorPersona = new ControladorPersona();
            controladorPersona.modificar(id, identificacion, antecedentesPenales, direccion, telefono, email, nombre, apellidos);
        } catch (IOException ex) {
            System.out.println("Error al modificar usuario");
        }
    }

    private static void eliminar() {
        try {
            System.out.println("Id del usuario a eliminar");
            String id = reader.readLine();

            controladorPersona = new ControladorPersona();
            controladorPersona.eliminal(id);
        } catch (IOException ex) {
            System.out.println("Error al eliminar usuario: " + ex);
        }
    }

    private static void buscar() {
        try {
            System.out.println("Identidad del usuario a buscar");
            String id = reader.readLine();
            controladorPersona = new ControladorPersona();
            controladorPersona.buscar(id);

        } catch (IOException ex) {
            System.out.println("Error al buscar usuario: " + ex);
        }
    }

    private static void ingresarAlSistema() {
        System.out.println("Que desea hacer?");
        System.out.println("\n 1 -Modificar un usuario \n 2 - Eliminar un usuario \n 3 - Buscar usuario \n 4 - Listar usuario"
                + "\n 5 - Salir");
    }

    private static void listar() {
        controladorPersona = new ControladorPersona();
        controladorPersona.listar();
  }

}
