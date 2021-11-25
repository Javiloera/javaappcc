/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocc1.empleadosDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author javier
 */
public class conexion {
    String strConexionDB = "jdbc:mysql://10.0.0.6:3306/proyectocc1?useUnicode=true&use"
            + "JDBCCompilantTimezoneShift=true&useLegacyDatetimeCode=flase&"
            + "serverTimezone=UTC";
    Connection conn=null;
    
    public conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://10.0.0.6:3306/proyectocc1", "javierl", "elDecimo10**");
            
            System.out.println("Conexion establecida");
        } catch (Exception e) {
            System.out.println("Conexion no establecida: " + e);
        }
        
    }
    public int ejecutarSentenciaSQL(String strSentenciaSQL)
    {
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
            
        } catch (SQLException e) {
            System.out.print(e);
            return 0;
        }

    }
    public ResultSet consultarRegistro(String strSentenciaSQL)
    {
        try {
            
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }        
    }
}
