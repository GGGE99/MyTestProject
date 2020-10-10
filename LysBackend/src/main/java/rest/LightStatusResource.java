package rest;

import DTOs.LightStatusDto;
import DTOs.LightStatusDtos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.LightStatus;
import utils.EMF_Creator;
import facades.LightStatusFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("light")
public class LightStatusResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    //An alternative way to get the EntityManagerFactory, whithout having to type the details all over the code
    //EMF = EMF_Creator.createEntityManagerFactory(DbSelector.DEV, Strategy.CREATE);
    private static final LightStatusFacade FACADE = LightStatusFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("status")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String addLightStatus(String lightStatusDto) {
        LightStatusDto lightDto = GSON.fromJson(lightStatusDto, LightStatusDto.class);
        LightStatus lightAdded = FACADE.InserLightToDB(lightDto);
        return GSON.toJson(lightAdded);
    }

    @Path("status/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String editLightStatus(String lightStatusDto, @PathParam("id") Integer id) {
        LightStatusDto lightDto = GSON.fromJson(lightStatusDto, LightStatusDto.class);
        lightDto.setId(id);
        LightStatus lightAdded = FACADE.editLight(lightDto);
        return GSON.toJson(lightAdded);
    }

    @GET
    @Path("/pop")
    @Produces({MediaType.APPLICATION_JSON})
    public String popLightStatus() {
        LightStatus lightAdded = FACADE.popDb();
        return GSON.toJson(lightAdded);
    }

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllLightStatus() {
        LightStatusDtos lights = FACADE.getAllLights();
        return GSON.toJson(lights);
    }

}
