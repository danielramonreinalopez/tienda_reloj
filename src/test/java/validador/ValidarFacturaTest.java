/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package validador;

import java.util.Date;
import java.util.List;
import modelos.Cliente;
import modelos.Producto;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge
 */
public class ValidarFacturaTest {
    
    public ValidarFacturaTest() {
    }

    @Test
    public void testValidarId() {
        System.out.println("validarId");
        int id = 0;
        boolean expResult = false;
        boolean result = ValidarFactura.validarId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarCliente() {
        System.out.println("validarCliente");
        Cliente cliente = null;
        boolean expResult = false;
        boolean result = ValidarFactura.validarCliente(cliente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarProductos() {
        System.out.println("validarProductos");
        List<Producto> productos = null;
        boolean expResult = false;
        boolean result = ValidarFactura.validarProductos(productos);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarFecha() {
        System.out.println("validarFecha");
        Date date = null;
        boolean expResult = false;
        boolean result = ValidarFactura.validarFecha(date);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarTotal() {
        System.out.println("validarTotal");
        double total = 0.0;
        boolean expResult = false;
        boolean result = ValidarFactura.validarTotal(total);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
