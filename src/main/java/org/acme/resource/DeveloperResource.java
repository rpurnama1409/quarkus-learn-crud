/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.acme.resource;

import org.acme.dto.DeveloperDTO;
import org.acme.entity.Developer;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Produces;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author rpurnama
 */

@Path("developer")
public class DeveloperResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDevelopers() {
        List<Developer> developers = Developer.findAll().list();
        return Response.ok(developers).build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDeveloper(DeveloperDTO developerDto) {
        Developer developer = new Developer();

        developer.setName(developerDto.getName());
        developer.setSkill(developerDto.getSkill());
        developer.setHobby(developerDto.getHobby());

        developer.persist();
        return Response.ok().build();

    }

    @PUT
    @Path("{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response updateDeveloper(@PathParam("id") Long id, DeveloperDTO developerDto) {
        Optional<Developer> developerOptional = Developer.findByIdOptional(id);

        if (developerOptional.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Developer developer = Developer.findById(id);

        developer.setName(developerDto.getName());
        developer.setSkill(developerDto.getSkill());
        developer.setHobby(developerDto.getHobby());

        developer.persist();
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDeveloper(@PathParam("id") Long id) {
        Optional<Developer> developerOptional = Developer.findByIdOptional(id);

        if (developerOptional.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Developer.deleteById(id);
        return Response.ok().build();
    }

}
