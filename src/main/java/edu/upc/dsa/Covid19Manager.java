package edu.upc.dsa;

import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Persona;

import java.util.Date;
import java.util.List;

public interface Covid19Manager {

public Persona añadePersona(String idPersona, String nom, String apellido, int edad, String estado);
public Muestra añadeMuestra(String idMuestra, String idClinico, String idPersona, Date fechaExtraccion, String idLab);
public void  procesarMuestra(String resultado, String Comentario); /*genera un informe aociadoa esa muestra positivo/negativo y un comentario*/
public List<Muestra> muestrasUsuario (String idPersona);
public int sizeMuestrasProcesadas();
public int sizePersonas();
public int sizeMuestras();
public Muestra getMuestra(String idMuestra);



}
