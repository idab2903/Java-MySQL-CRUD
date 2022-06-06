/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaodbc;

/**
 *
 * @author Ivan
 */
import java.sql.*;
import java.util.ArrayList;


/*Metodo listar*/
public class metodos{

    public ArrayList<Informe> Listar_Informe(){
        ArrayList<Informe> list = new ArrayList<Informe>();
        bd conec = new bd();
        String sql = "SELECT * FROM usuario;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Informe vo = new Informe();
                vo.setId(rs.getInt(1));
                vo.setDescripcion(rs.getString(2));
                vo.setFoto(rs.getBytes(3));
                list.add(vo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }


/*Metodo agregar*/
    public void Agregar_Informe(Informe vo){
        bd conec = new bd();
        String sql = "INSERT INTO usuario (id, descripcion, foto)\n" +
"VALUES (NULL,?,?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getDescripcion());
            ps.setBytes(2, vo.getFoto());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("A "+ex.getMessage());
        }catch(Exception ex){
            System.out.println("B "+ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }


/*Metodo Modificar*/
    public void Modificar_Informe(Informe vo){
        bd conec = new bd();
        String sql = "UPDATE usuario SET descripcion = ?, foto = ?\n" +
"WHERE id = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getDescripcion());
            ps.setBytes(2, vo.getFoto());
            ps.setInt(3, vo.getId());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

    public void Modificar_Informe2(Informe vo){
        bd conec = new bd();
        String sql = "UPDATE usuario SET descripcion = ? \n" +
"WHERE id = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getDescripcion());
            ps.setInt(2, vo.getId());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

/*Metodo Eliminar*/
    public void Eliminar_Informe(Informe vo){
        bd conec = new bd();
        String sql = "DELETE FROM usuario WHERE id = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getId());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }


}