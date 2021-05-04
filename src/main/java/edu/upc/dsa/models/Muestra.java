package edu.upc.dsa.models;

import java.util.Date;

public class Muestra {
    String idMuestra;
    String idClinico;
    String idPersona;
    Date fechaDeExtraccion;
    String idLaboratorio;


    public Muestra(String idMuestra, String idClinico, String idPersona, Date fechaDeExtraccion, String idLaboratorio) {
        this.idMuestra = idMuestra;
        this.idClinico = idClinico;
        this.idPersona = idPersona;
        this.fechaDeExtraccion = fechaDeExtraccion;
        this.idLaboratorio = idLaboratorio;
    }


    public Muestra(){}

    public String getIdMuestra() {
        return idMuestra;
    }

    public void setIdMuestra(String idMuestra) {
        this.idMuestra = idMuestra;
    }

    public String getIdClinico() {
        return idClinico;
    }

    public void setIdClinico(String idClinico) {
        this.idClinico = idClinico;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public Date getFechaDeExtraccion() {
        return fechaDeExtraccion;
    }

    public void setFechaDeExtraccion(Date fechaDeExtraccion) {
        this.fechaDeExtraccion = fechaDeExtraccion;
    }

    public String getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(String idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }
}
