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
public class Informe {
     int id;
    String descripcion;
    private byte[] foto;

public Informe(){}

/*Todo los codigos get*/
    public int getId(){
        return id;
    }
    public String getDescripcion(){
        return descripcion;
    }
    
    


/*Todo los codigos set*/
    public void setId(int id){
        this.id = id;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    /**
     * @return the foto
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

}

