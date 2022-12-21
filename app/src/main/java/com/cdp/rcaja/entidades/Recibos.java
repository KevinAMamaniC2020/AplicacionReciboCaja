package com.cdp.rcaja.entidades;

public class Recibos {
    private int CodigoRecibo;
    private String nombreCliente;
    private String nombreBanco;
    private String correo_electornico;
    private int monto;
    private String estado;
    private String color;
    private int id;

    /*public Recibos(int id,String color, String nombreCliente, String correo_electornico, String estado){
        this.color=color;
        this.nombreCliente=nombreCliente;
        this.correo_electornico=correo_electornico;
        this.estado=estado;
        this.id=id;
    }*/

    public int getCodigoRecibo() {
        return CodigoRecibo;
    }

    public void setCodigoRecibo(int codigoRecibo) {
        CodigoRecibo = codigoRecibo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getCorreo_electornico() {
        return correo_electornico;
    }

    public void setCorreo_electornico(String correo_electornico) {
        this.correo_electornico = correo_electornico;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

