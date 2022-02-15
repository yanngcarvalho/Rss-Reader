package br.com.yann.rssreader.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.yann.rssreader.entity.User;
import br.com.yann.rssreader.service.AdminService;


@Path("auth/admin")
public class AdminController{

  @Inject
  AdminService service;
  //TODO DTO
  //TODO nao pode retornar as senhas


  @GET
  @Path("listUsers")
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response listUsers(){
    List<User> users = service.listUsers();
    return Response.ok(users).build();
  }

  @GET
  @Path("findByLogin")
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response findAnyUserByLogin(@QueryParam("username") String username){
    User user = service.findAnyUserByUsername(username);
    return Response.ok(user).build();
  }

  @PUT
  @Path("update")
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response updateAnyUser(@QueryParam("username") String username, User user){
    service.updateAnyUser(user);
    return Response.ok().build();
  }

  @DELETE
  @Path("delete")
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response deleteAnyUser(@QueryParam("username") String username){
    service.deleteAnyUser(username);
    return Response.ok().build();
  }

  //FIXME VALIDAR RSS
  //TODO UPDATE IS NOT WORKING


}
