package edu.upc.dsa;

import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Usuario;

import java.util.List;

public interface JuegoInterfaz {
     //autenticacion
    public Usuario Registro (String id, String nombre, String apellido, String password);
    public Usuario Login (String user, String password);


    //servicios
    public List<Usuario> getAllUser ();
    public Usuario getUsuario (String id);
    public Usuario actualizarUsuario( Usuario usuario) ;
    public void deleteUsuaer(String id);

    public List<Jugador> muestrasJugadores (String idJugador);
    public int sizeJugadores();


}
