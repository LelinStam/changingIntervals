package matc.controller;
import matc.entity.User;
import matc.persistence.Dao;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class RESTCreator {

    @POST
    @Path("/id")

    public Response findId(@FormParam("id") int id) {
        if(id == 0) {

            Dao dao = new Dao(User.class);
            List<User> users = dao.getAll();
            return Response.status(200)
                    .entity("Users are : " + users)
                    .build();
        } else {
            return Response.status(200)
                    .entity(" You entered id: " + id)
                    .build();
        }
    }
}
