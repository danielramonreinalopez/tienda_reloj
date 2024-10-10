/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package validador;

import modelos.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge
 */
public class ValidarClienteTest {
    
    public ValidarClienteTest() {
    }

    @Test
    public void testValidarDireccion() {
        System.out.println("validarDireccion");
        String direccion = "";
        boolean expResult = false;
        boolean result = ValidarCliente.validarDireccion(direccion);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarNombre() {
        System.out.println("validarNombre");
        String nombre = "";
        boolean expResult = false;
        boolean result = ValidarCliente.validarNombre(nombre);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarApellido() {
        System.out.println("validarApellido");
        String apellido = "";
        boolean expResult = false;
        boolean result = ValidarCliente.validarApellido(apellido);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarNumeroCelular() {
        System.out.println("validarNumeroCelular");
        int numCelular = 0;
        boolean expResult = false;
        boolean result = ValidarCliente.validarNumeroCelular(numCelular);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarCorreo() {
        System.out.println("validarCorreo");
        String correo = "";
        boolean expResult = false;
        boolean result = ValidarCliente.validarCorreo(correo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarContrasenia() {
        System.out.println("validarContrasenia");
        String contrasenia = "";
        boolean expResult = false;
        boolean result = ValidarCliente.validarContrasenia(contrasenia);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarCliente() {
        System.out.println("validarCliente");
        Cliente cliente = null;
        boolean expResult = false;
        boolean result = ValidarCliente.validarCliente(cliente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
