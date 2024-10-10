/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiendareloj;

import conexionBD.ConfiguracionBaseDatos;
import controlador.ControladorIA;
import excepcion.InvalidoException;
import java.sql.Connection;
import java.sql.SQLException;
import modelos.Cliente;
import repositorio.ClienteRepositorio;
import servicio.ServicioCliente;

/**
 *
 * @author daniel
 */
public class TiendaReloj {

    public static void main(String[] args) {
    /*    System.out.println("Hello World!");
         ClienteRepositorio clienteRepo = new ClienteRepositorio();
         ServicioCliente servicio = new ServicioCliente();

        // Correo del cliente que deseas buscar
//        String correoABuscar = "ramon@ejemplo.com"; // Cambia esto por el correo que deseas buscar
//        String contraseña = "123";
//        
//        try {
//            // Llamar al método buscarCliente
//            Cliente clienteEncontrado = clienteRepo.buscarCliente(correoABuscar);
//            Cliente clienteServicio = servicio.iniciarSesion(correoABuscar, contraseña);
//            
//            //Imprimir los datos del cliente encontrado por el repositorio
//            if (clienteEncontrado != null) {
//                System.out.println("Cliente encontrado:");
//                System.out.println("Nombre: " + clienteEncontrado.getNombre());
//                System.out.println("Apellido: " + clienteEncontrado.getApellido());
//                System.out.println("Celular: " + clienteEncontrado.getNumcelular());
//                System.out.println("Correo: " + clienteEncontrado.getCorreo());
//                System.out.println("Dirección: " + clienteEncontrado.getDireccion());
//                // No imprimas la contraseña por razones de seguridad
//            } else {
//                System.out.println("No se encontró ningún cliente por el repositorio con el correo: " + correoABuscar);
//            }
//            
//            // Imprimir los datos del cliente encontrado por el servicio
//            if (clienteServicio != null) {
//                System.out.println("Cliente encontrado:");
//                System.out.println("Nombre: " + clienteServicio.getNombre());
//                System.out.println("Apellido: " + clienteServicio.getApellido());
//                System.out.println("Celular: " + clienteServicio.getNumcelular());
//                System.out.println("Correo: " + clienteServicio.getCorreo());
//                System.out.println("Dirección: " + clienteServicio.getDireccion());
//                // No imprimas la contraseña por razones de seguridad
//            } else {
//                System.out.println("No se encontró ningún cliente por el servicio con el correo: " + correoABuscar);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // Imprimir el stack trace en caso de error en la conexión a la base de datos
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage()); // Imprimir mensajes de excepción si el correo es inválido
//        } catch (InvalidoException e) {
//            System.out.println(e.getMessage());
//        }


         //Prueba registrar cliente del servicioCliente
         Cliente nuevoCliente = new Cliente("direccion", "Ivan", "Castillo", 123456789, "ivan@ejemplo.com", "345");

        try {
            // Registrar el cliente
            boolean respuesta = servicio.registrarCliente(nuevoCliente);
            if(respuesta){
                System.out.println("Cliente registrado exitosamente.");
            }else{
                System.out.println("Cliente existente");
            }
        } catch (InvalidoException e) {
            // Manejo de la excepción personalizada
            System.out.println("Error: " + e.getMessage());
        } catch (SQLException e) {
            // Manejo de la excepción de SQL
            System.out.println("Error en la conexión a la base de datos: " + e.getMessage());
        }
        
    }
    */
    
    /*
        // Crear una instancia del controlador de IA
        ControladorIA controladorIA = new ControladorIA();

        // Mensaje de prueba
        String mensaje = "Escribe un texto para generar contenido.";

        // Llamar al método crearContenido y mostrar el resultado
        String contenidoGenerado = controladorIA.crearContenido(mensaje);
        
        // Imprimir el contenido generado en la consola
        if (contenidoGenerado != null) {
            System.out.println("Contenido generado:");
            System.out.println(contenidoGenerado);
        } else {
            System.out.println("No se pudo generar contenido.");
        }
    }
    */
    
     ControladorIA controladorIA = new ControladorIA();

        // Filtrar productos por modelo
        System.out.println("Filtrar productos por modelo 'G-shock':");
        controladorIA.buscarYGenerarContenido("G-shock");

        // Filtrar productos por marca
        System.out.println("\nFiltrar productos por marca 'Cassio':");
        controladorIA.buscarYGenerarContenido("Cassio");

        // Intentar filtrar productos no existentes
        System.out.println("\nFiltrar productos no existentes:");
        controladorIA.buscarYGenerarContenido("NoExistente");
    }
}




