package edu.upc.dsa;

import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Persona;
import edu.upc.dsa.models.Usuario;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class JuegoImpl implements JuegoInterfaz {


    private static JuegoImpl manager;
    static final Logger logger = Logger.getLogger(JuegoImpl.class.getName());

    HashMap<String, Jugador> jugadores;
    List<Jugador> jugones;
    List<Usuario> usuarios;

    private JuegoImpl() {
        /* Señalizamos las estructuras de datos */

        this.jugadores = new HashMap<String, Jugador>();
        this.jugones = new LinkedList<Jugador>();
        this.usuarios = new LinkedList<Usuario>();

    }

    public static JuegoImpl getInstance()  /*Singletone, puerta de entrada a la instancia*/ {
        if (manager == null) manager = new JuegoImpl();
        return manager;


    }

    public static void delete() {
        manager = null;    //Permite reiniciar la base de datos
        logger.info("Instancia MathManagerImpl borrada");

    }


    @Override
    public Usuario Registro(String id, String nombre, String apellido, String password) {
        Usuario usuarioNuevo = new Usuario(id, nombre, apellido, password);
        this.usuarios.add(usuarioNuevo);
        return usuarioNuevo;
    }

    @Override
    public Usuario Login(String user, String password) {
        Usuario userEcontrado = new Usuario();
        for (Usuario u : this.usuarios) {

            if (u.getNombre().equals(user)) {
                if (u.getPassword().equals(password)) {
                     userEcontrado = u;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        return userEcontrado;

    }

    @Override
    public List<Usuario> getAllUser() {
        return this.usuarios;
    }


    @Override
    public Usuario getUsuario(String id) {
        Usuario usuarioEncontrado = new Usuario();
        for (Usuario u: this.usuarios){
            if (u.getIdUser().equals(id))
            {
                usuarioEncontrado= u;
            }
        }
        return usuarioEncontrado;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        Usuario usuarioActualizado = new Usuario();
        for ( Usuario u: this.usuarios){
            if(u.getIdUser().equals(usuario.getIdUser()))

            {
                u.setApellido(usuario.getApellido());
                u.setNombre(usuario.getNombre());
                u.setPassword(usuario.getPassword());
                usuarioActualizado = u;
            }
        }
        return usuarioActualizado;
    }

    @Override
    public void deleteUsuaer(String id) {
        for (Usuario u: this.usuarios){
            if (u.getIdUser().equals(id)){
                this.usuarios.remove(u);
            }
        }
    }

    @Override
    public List<Jugador> muestrasJugadores(String idJugador) {
        for(Jugador j: this.jugones)
        {
            if(j.getId() == idJugador)
            {
                this.jugones.add(j);

            }

        }

        return this.jugones;
    }

    @Override
    public int sizeJugadores() {
        int ret = this.jugones.size();
        logger.info("size muestras Procesadas: "+ ret);
        return ret;
    }
}
