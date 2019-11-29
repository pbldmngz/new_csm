package com.example.menutest;

public class Mensaje {
    public Mensaje(){

    }
    public Mensaje(int _id_emisor, String _contenido, String _fecha)
    {
        id_emisor = _id_emisor;
        contenido = _contenido;
        fecha = _fecha;
    }
    public int id_emisor;
    public String contenido;
    public String fecha;
}
