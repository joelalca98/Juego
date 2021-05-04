package edu.upc.dsa.services;
import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Persona;
import edu.upc.dsa.models.Track;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
@Api(value = "/Covid", description = "Endpoint to Text Service")
@Path("Covid")
public class CovidService {
    private Covid19ManagerImpl cm;

    public CovidService(){
        this.cm = Covid19ManagerImpl.getInstance();
        if(cm.sizePersonas() == 0){
            cm.añadePersona("persona1","Kevin","Alcalde",24,"A");
            cm.añadePersona("persona2","Hola","Alcalde",24,"B");
            cm.añadePersona("persona3","Joel","Alcalde",23,"C");
            cm.añadePersona("persona4","Hola","Alcalde",22,"B");



        }

        if(cm.sizeMuestras()==0) {

            cm.añadeMuestra("muestra1","clinico1","persona1",new Date(2020,07,20),"lab1");
            cm.añadeMuestra("muestra2","clinico2","persona1",new Date(2020,07,20),"lab1");
            cm.añadeMuestra("muestra3","clinico3","persona1",new Date(2020,07,20),"lab1");



        }


    }


    @POST /*Añadimos un nueva persona */
    @ApiOperation(value = "añadimos persona a la lista", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Persona.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/addPersona/{idPersona}/{nom}/{ape}/{edad}/{estado}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newBrote(@PathParam("idPersona") String idPersona,@PathParam("nom") String nom,@PathParam("ape")String ape, @PathParam("edad")int edad,@PathParam("estado")String estado) {

        /* if (track.getSinger()==null || track.getTitle()==null)  return Response.status(500).entity(track).build();*/
      Persona persona = cm.añadePersona(idPersona, nom, ape, edad, estado);
       return Response.status(201).entity(persona).build();


    }



    @POST /*Añadimos una nueva muestra */
    @ApiOperation(value = "añadimos muestra a la lista", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Muestra.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/addMuestra/{idMuestra}/{idClinico}/{idPersona}/{dia}/{mes}/{año}/{idLaboratorio}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newMuestra(@PathParam("idMuestra") String idMuestra,@PathParam("idClinico") String idClinico,@PathParam("aidPersona")String idPersona, @PathParam("dia")int dia,@PathParam("mes")int mes,@PathParam("año")int año,@PathParam("idLaboratorio")String idLaboratorio) {

        /* if (track.getSinger()==null || track.getTitle()==null)  return Response.status(500).entity(track).build();*/

        Date fecha = new Date (dia,mes,año);
        Muestra muestra = cm.añadeMuestra(idMuestra,idClinico,idPersona,fecha,idLaboratorio);

        return Response.status(201).entity(muestra).build();


    }

    @GET
    @ApiOperation(value = "Muestras de un usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Muestra.class ,responseContainer = "List"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/prueba/{id}/{resultado}/{comentario}")
    public Response OrderLista(@PathParam("id")String  idPersona,@PathParam("resultado")String  resultado,@PathParam("comentario")String  comentario) {

        this.cm.procesarMuestra(resultado,comentario);


        List<Muestra> muestras = this.cm.muestrasUsuario(idPersona);


        GenericEntity<List<Muestra>> entity = new GenericEntity<List<Muestra>>(muestras) {
        };
        return Response.status(201).entity(entity).build();
    }



















    }
