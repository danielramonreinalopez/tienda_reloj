/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package validador;

import modelos.Administrador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge
 */
public class ValidarAdministradorTest {
    
    public ValidarAdministradorTest() {
    }

    @Test
    public void testValidarRol() {
        System.out.println("validarRol");
        String rol = "";
        boolean expResult = false;
        boolean result = ValidarAdministrador.validarRol(rol);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarNombre() {
        System.out.println("validarNombre");
        String nombre = "";
        boolean expResult = false;
        boolean result = ValidarAdministrador.validarNombre(nombre);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarApellido() {
        System.out.println("validarApellido");
        String apellido = "";
        boolean expResult = false;
        boolean result = ValidarAdministrador.validarApellido(apellido);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarNumeroCelular() {
        System.out.println("validarNumeroCelular");
        int numCelular = 0;
        boolean expResult = false;
        boolean result = ValidarAdministrador.validarNumeroCelular(numCelular);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarCorreo() {
        System.out.println("validarCorreo");
        String correo = "";
        boolean expResult = false;
        boolean result = ValidarAdministrador.validarCorreo(correo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarContrasenia() {
        System.out.println("validarContrasenia");
        String contrasenia = "";
        boolean expResult = false;
        boolean result = ValidarAdministrador.validarContrasenia(contrasenia);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarAdministrador() {
        System.out.println("validarAdministrador");
        Administrador administrador = null;
        boolean expResult = false;
        boolean result = ValidarAdministrador.validarAdministrador(administrador);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
