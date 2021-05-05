package services;

import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Departamento;
import repositories.RepositoryDepartamento;

@Path("/departamento")
public class ServicesDepartamento {

    RepositoryDepartamento repo;

    public ServicesDepartamento() {
        this.repo = new RepositoryDepartamento();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Departamento> getDepartamentos() throws SQLException {
        return this.repo.getDepartamentos();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Departamento getDepartamentoNo(@PathParam("id") String id) throws SQLException {
        int deptno = Integer.parseInt(id);
        return this.repo.getDepartamentoNo(deptno);
    }
}
