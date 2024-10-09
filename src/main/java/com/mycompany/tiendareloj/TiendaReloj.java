/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiendareloj;

import conexionBD.ConfiguracionBaseDatos;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author daniel
 */
public class TiendaReloj {

    public static void main(String[] args) {
        System.out.println("Hello World!");
         try {

		            Connection connection = ConfiguracionBaseDatos.getConnection();

		            if (connection != null) {

		                System.out.println("Conexión a la base de datos establecida correctamente.");

		            } else {

		                System.out.println("No se pudo conectar a la base de datos.");

		            }

		        } catch (SQLException e) {

		            System.out.println("Error al conectar a la base de datos: " + e.getMessage());

		        }
    }
}
