/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiendareloj;

import conexionBD.ConfiguracionBaseDatos;
import controlador.ControladorCliente;
import controlador.ControladorIA;
import excepcion.InvalidoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.Administrador;
import modelos.Cliente;
import modelos.Producto;
import repositorio.AdministradorRepositorio;
import repositorio.ClienteRepositorio;
import repositorio.ProductoRepositorio;
import servicio.ServicioAdministrador;
import servicio.ServicioCliente;
import servicio.ServicioProducto;
import vistas.VentanaAdministrador;
import vistas.VentanaInicio;

/**
 *
 * @author daniel
 */
public class TiendaReloj {

    public static void main(String[] args) throws InvalidoException {
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
//         Cliente nuevoCliente = new Cliente("direccion", "Ivan", "Castillo", 123456789, "ivan@ejemplo.com", "345");
//
//        try {
//            // Registrar el cliente
//            boolean respuesta = servicio.registrarCliente(nuevoCliente);
//            if(respuesta){
//                System.out.println("Cliente registrado exitosamente.");
//            }else{
//                System.out.println("Cliente existente");
//            }
//        } catch (InvalidoException e) {
//            // Manejo de la excepción personalizada
//            System.out.println("Error: " + e.getMessage());
//        } catch (SQLException e) {
//            // Manejo de la excepción de SQL
//            System.out.println("Error en la conexión a la base de datos: " + e.getMessage());
//        }
     
        
        //pruba lista productos
        ControladorCliente controladorCliente = new ControladorCliente();

        try {
            ArrayList<Producto> productos = controladorCliente.obtenerProductos();
            // Imprimir los productos obtenidos
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener productos: " + e.getMessage());
        }
    }
<<<<<<< HEAD
        
=======
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
    
//     ControladorIA controladorIA = new ControladorIA();
//
//        // Filtrar productos por modelo
//        System.out.println("Filtrar productos por modelo 'G-shock':");
//        controladorIA.buscarYGenerarContenido("G-shock");
//
//        // Filtrar productos por marca
//        System.out.println("\nFiltrar productos por marca 'Cassio':");
//        controladorIA.buscarYGenerarContenido("Cassio");
//
//        // Intentar filtrar productos no existentes
//        System.out.println("\nFiltrar productos no existentes:");
//        controladorIA.buscarYGenerarContenido("NoExistente");



        //prueba guardar producto en BD /Funciona
//        
//        // Crear un objeto Producto
//        Producto producto = new Producto("Prueba1", "Modelo1", 23456, "Descripcion");
//
//        // Instancia de la clase donde está el método guardarProducto
//        ProductoRepositorio productoRepositorio = new ProductoRepositorio();
//
//        try {
//            // Llamar al método guardarProducto
//            productoRepositorio.guardarProducto(producto);
//            System.out.println("Producto guardado correctamente.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Error al guardar el producto: " + e.getMessage());
//        }


        //Prueba metodo agregar de servicioProducto
//         ProductoRepositorio productoRepositorio = new ProductoRepositorio(); // Asegúrate de que esta clase esté implementada
//        ServicioProducto productoServicio = new ServicioProducto();

        // Intentar agregar el producto
//        productoServicio.agregarProducto(producto);


//        try {
//        ServicioCliente servicio = new ServicioCliente(); // Asumiendo que tienes una clase ServicioCliente que contiene el método buscarCliente
//        String correo = "prueba@ejemplo.com"; // Un correo que sí exista en la base de datos
//        String contrasenia = "123";
//        Cliente cliente = servicio.iniciarSesion(correo, correo); // Llamada al método buscarCliente
//
//        if (cliente == null) {
//            System.out.println("No se encontró ningún cliente con el correo: " + correo);
//        } else {
//            // Si se encontró el cliente, imprime sus detalles
//            System.out.println("Cliente encontrado:");
//            System.out.println("Nombre: " + cliente.getNombre());
//            System.out.println("Apellido: " + cliente.getApellido());
//            System.out.println("Celular: " + cliente.getCelular());
//            System.out.println("Correo: " + cliente.getCorreo());
//            System.out.println("Dirección: " + cliente.getDireccion());
//        }
//    } catch (SQLException e) {
//        e.printStackTrace(); // Imprime cualquier error de SQL
//    }

//        ServicioAdministrador servicio = new ServicioAdministrador();
//        AdministradorRepositorio repositorio = new AdministradorRepositorio();
//
//        String correo = "Ruiz@ejemplo.com";
//        String contraseña = "987";
//        try{
//            Administrador administrador = repositorio.buscarAdministrador(correo, contraseña);
//                    if(administrador != null){
//                        VentanaAdministrador va = new VentanaAdministrador(administrador);
//                        va.setVisible(true);
//                    }else{
//                        JOptionPane.showMessageDialog(null, "Correo o contraseña incorretos");
//                    }
//        }catch(SQLException e){
//            JOptionPane.showMessageDialog(null, "Correo o contraseña incorretos, SQL");
////        } catch (InvalidoException ex) {
////            Logger.getLogger(VentanaInicio.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}




