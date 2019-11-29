package com.example.menutest;
import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class dataController {

    //devuelve un boolean, servirá para validar
    public static boolean validLogin(String correo, String password) {
        return Boolean.parseBoolean(getData(false,
                "login", new String[][]{{"correo", correo}, {"password", password}}).optString(0));
    }

    //el JSON resultante puede tener estos valores
    //(int id, string correo, string tel_grupo, string nombre, string primer_apellido, string segundo_apellido)

    public static ArrayList<Persona> listado(boolean alumno, int pagina) {
        String str = alumno ? "alumno" : "profesor";
        ArrayList<Persona> ls = new ArrayList();
        JSONArray jarr = getData(true, str + "/listado/?pagina=" + pagina, new String[][]{});
        for (int i = 0; i < jarr.length(); i++) {
            try {
                JSONObject jsonObject = new JSONObject(jarr.optString(i));
                ls.add(new Persona(
                        Integer.parseInt(jsonObject.getString("id")),
                        jsonObject.getString("correo"),
                        jsonObject.getString("tel_grupo"),
                        jsonObject.getString("nombre"),
                        jsonObject.getString("primer_apellido"),
                        jsonObject.getString("segundo_apellido")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ls;
    }

    //Ver individualmente a una persona
    public static Persona persona(boolean alumno, int id) {
        String str = alumno ? "alumno" : "profesor";
        String sql = "http://10.0.2.2:49775/" + str + "/ver/?id=" + id;

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = null;
        HttpURLConnection conn;
        try {
            url = new URL(sql);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            JSONObject jsonObject = new JSONObject(response.toString());

            return new Persona(
                    Integer.parseInt(jsonObject.getString("id")),
                    jsonObject.getString("correo"),
                    jsonObject.getString("tel_grupo"),
                    jsonObject.getString("nombre"),
                    jsonObject.getString("primer_apellido"),
                    jsonObject.getString("segundo_apellido"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Funciona igual que el método de antes
    public static ArrayList<Persona> alumnosProfesor(int id, int pagina){
        ArrayList<Persona> ls = new ArrayList();
        JSONArray jarr = getData(false, "profesor/alumnos",
                new String[][] {{"id", id + ""},{"pagina", pagina + ""}});
        for (int i = 0; i < jarr.length(); i++){
            try {
                JSONObject jsonObject = new JSONObject(jarr.optString(i));
                ls.add(new Persona(
                        Integer.parseInt(jsonObject.getString("id")),
                        jsonObject.getString("correo"),
                        jsonObject.getString("tel_grupo"),
                        jsonObject.getString("nombre"),
                        jsonObject.getString("primer_apellido"),
                        jsonObject.getString("segundo_apellido")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ls;
    }

    //Envío de mensajes, recibe true si el mensaje se envió correctamente
    public static boolean enviar(int id_emisor, int id_receptor, String mensaje){
        return Boolean.parseBoolean(getData(false, "mensaje/enviar",
                new String[][] {{"id_emisor", String.valueOf(id_emisor)},{"id_receptor",
                        String.valueOf(id_receptor)},{"mensaje", mensaje}}).optString(0));
    }

    public static ArrayList<Mensaje> buzon(int id, int pagina){
        ArrayList<Mensaje> ls = new ArrayList();
        JSONArray jarr = getData(false, "mensaje/ver",
                new String[][] {{"id", id + ""},{"pagina", pagina + ""}});
        for (int i = 0; i < jarr.length(); i++){
            try {
                JSONObject jsonObject = new JSONObject(jarr.optString(i));
                ls.add(new Mensaje(
                        Integer.parseInt(jsonObject.getString("id_emisor")),
                        jsonObject.getString("contenido"),
                        jsonObject.getString("fecha")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ls;
    }

    public static grupoAlumno grupoAlumno(int id) {
        String sql = "http://10.0.2.2:49775/profesor/grupo_alumno/?id=" + id;

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = null;
        HttpURLConnection conn;
        try {
            url = new URL(sql);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            JSONObject jsonObject = new JSONObject(response.toString());

            return new grupoAlumno(
                    Integer.parseInt(jsonObject.getString("grupos")),
                    Integer.parseInt(jsonObject.getString("alumnos")));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONArray getData(boolean get, String dir, String[][] data) {
        String sql = "http://10.0.2.2:49775/" + dir;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = null;
        HttpURLConnection conn;
        try {
            url = new URL(sql);
            conn = (HttpURLConnection) url.openConnection();

            if (get){
                conn.setRequestMethod("GET");
            }else {
                conn.setRequestMethod("POST");
                conn.addRequestProperty("Content-Type", "application/json");
                OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
                JSONObject gson = new JSONObject();
                for (int i = 0; i < data.length; i++){
                    gson.put(data[i][0],data[i][1]);
                }
                out.write(String.valueOf(gson));
                out.close();
            }

            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            String json = "";

            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            json = response.toString();

            return new JSONArray(json);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
