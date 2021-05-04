package edu.upc.dsa;

import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Persona;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

public class Covid19ManagerImpl implements Covid19Manager {


    private static Covid19ManagerImpl manager;

    static final Logger logger = Logger.getLogger(Covid19ManagerImpl.class.getName());

    HashMap<String, Persona> personas;
    List<Muestra> muestras;
    List<Muestra> muestrasProcesadas;
    List<Muestra> muestrasPorUsuario;




    private Covid19ManagerImpl(){
        /* Señalizamos las estructuras de datos */

        this.personas = new HashMap<String, Persona>();
        this.muestras   = new LinkedList<Muestra>();
        this.muestrasProcesadas = new LinkedList<Muestra>();
        this.muestrasPorUsuario = new LinkedList<Muestra>();


    }
    public static Covid19ManagerImpl getInstance()  /*Singletone, puerta de entrada a la instancia*/
    {
        if (manager==null) manager = new Covid19ManagerImpl();
        return manager;


    }
    public static void delete(){
        manager = null;    //Permite reiniciar la base de datos
        logger.info("Instancia MathManagerImpl borrada");

    }




    @Override
    public Persona añadePersona(String idPersona, String nom, String apellido, int edad, String estado) {
        Persona personaNueva = new Persona(idPersona,nom,edad,apellido,estado);
        this.personas.put(idPersona,personaNueva);
        return personaNueva;

    }

    @Override
    public Muestra añadeMuestra(String idMuestra, String idClinico, String idPersona, Date fechaExtraccion, String idLab) {
        Muestra muestraNueva = new Muestra(idMuestra,idClinico,idPersona,fechaExtraccion,idLab);
        this.muestras.add(muestraNueva);

        return muestraNueva;
    }

    @Override
    public void procesarMuestra(String resultado, String comentario) {
        String idPersona;
        for (Muestra m: this.muestras){
            idPersona =  m.getIdPersona();
           Persona personaSelec = this.personas.get(idPersona);
           personaSelec.setComentario(comentario);
           personaSelec.setResultado(resultado);
           this.muestrasProcesadas.add(m);
            logger.info("se ha procesado la muestra de :"+ idPersona);

        }
    }

    @Override
    public List<Muestra> muestrasUsuario(String idPersona) {
        for(Muestra m: this.muestrasProcesadas)
        {
         if(m.getIdPersona() == idPersona)
         {
             this.muestrasProcesadas.add(m);

         }

        }

        return this.muestrasPorUsuario;


    }

    @Override
    public int sizeMuestrasProcesadas() {
       int ret = this.muestrasProcesadas.size();
       logger.info("size muestras Procesadas: "+ ret);
       return ret;
    }

    @Override
    public int sizePersonas() {

        int ret = this.personas.size();
        logger.info("size Personas: "+ ret);
        return ret;

    }

    @Override
    public int sizeMuestras() {
        int ret = this.muestras.size();
        logger.info("size Personas: "+ ret);
        return ret;

    }

    @Override
    public Muestra getMuestra(String idMuestra) {
        return null;

    }
}
