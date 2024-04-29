/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author salce
 */
public class Mensaje {
    @SerializedName("tipo")
    private String tipo;
    @SerializedName("objeto")
    private Object object;

    public Mensaje() {
    }

    public Mensaje(String tipo, Object object) {
        this.tipo = tipo;
        this.object = object;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}