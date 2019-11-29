package com.example.menutest;

public class Persona {
    public int id;
    public String correo;
    public String tel_grupo;
    public String nombre;
    public String primer_apellido;
    public String segundo_apellido;

    public Persona(){
    }

    public Persona(int _id, String _correo, String _tel_grupo, String _nombre, String _primer_apellido, String _segundo_apellido){
        id = _id;
        correo = _correo;
        tel_grupo = _tel_grupo;
        nombre = _nombre;
        primer_apellido = _primer_apellido;
        segundo_apellido = _segundo_apellido;
    }
}
