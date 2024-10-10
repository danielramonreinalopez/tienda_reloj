/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package validador;

import modelos.Producto;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge
 */
public class ValidarProductoTest {
    
    public ValidarProductoTest() {
    }

    @Test
    public void testValidarId() {
        System.out.println("validarId");
        int id = 0;
        boolean expResult = false;
        boolean result = ValidarProducto.validarId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarMarca() {
        System.out.println("validarMarca");
        String marca = "";
        boolean expResult = false;
        boolean result = ValidarProducto.validarMarca(marca);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarModelo() {
        System.out.println("validarModelo");
        String modelo = "";
        boolean expResult = false;
        boolean result = ValidarProducto.validarModelo(modelo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarPrecio() {
        System.out.println("validarPrecio");
        double precio = 0.0;
        boolean expResult = false;
        boolean result = ValidarProducto.validarPrecio(precio);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarCantidad() {
        System.out.println("validarCantidad");
        int cantidad = 0;
        boolean expResult = false;
        boolean result = ValidarProducto.validarCantidad(cantidad);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarDescripcion() {
        System.out.println("validarDescripcion");
        String descripcion = "";
        boolean expResult = false;
        boolean result = ValidarProducto.validarDescripcion(descripcion);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarProducto() {
        System.out.println("validarProducto");
        Producto producto = null;
        boolean expResult = false;
        boolean result = ValidarProducto.validarProducto(producto);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
