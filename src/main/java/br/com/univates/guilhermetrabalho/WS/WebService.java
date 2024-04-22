/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.guilhermetrabalho.WS;

import br.com.univates.guilhermetrabalho.Model.Pessoa;
import br.com.univates.guilhermetrabalho.dao.PessoaDao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import java.lang.reflect.Type;
import java.sql.SQLException;

/**
 *
 * 
 */
@Path("contato")
public class WebService {
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of test1
     */
    public WebService() {
    }
    
    @GET
    //@Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public String getJson() {
        return "MEU PRIMEIRO WS";
    }
    
     @GET
    @Produces("application/json")
    @Path("contaId/{id}")
    public String getContatoByID(@PathParam("id") int id) {
//        try {
//            PessoaService pes = new PessoaService();
//            Pessoa pessoa = pes.procurar(id);
//            Gson g = new Gson();
//            
//            return g.toJson(pessoa);
//        } catch (NotFoundException ex) {
//            return "Erro";
//        }

        PessoaDao dao = new PessoaDao();
        Pessoa pessoa = dao.read(id);
        Gson g = new Gson();
            
        return g.toJson(pessoa);

    }
    
    
    
    @POST
    @Consumes("application/json")
    @Path("inserir")
    public String inserir(String conteudo) {
        try {
            Gson g = new Gson();
            Type contatoType = new TypeToken<Pessoa>() {
            }.getType();
            Pessoa u = g.fromJson(conteudo, contatoType);
            System.out.print(u.getNome());
            PessoaDao pes = new PessoaDao();
            pes.adicionar(u);
            
            return "Usuário criado";
        } catch (SQLException ex) {
            return "Erro sql";
        } 
    }
    
    
    @PUT
    @Consumes("application/json")
    @Path("alterar")
    public String alterar(String conteudo) {
        Gson g = new Gson();
        Pessoa u = (Pessoa) g.fromJson(conteudo, Pessoa.class);
        PessoaDao pes = new PessoaDao();
        pes.alterar(u);
        return "Alterado";
    }
    
    @DELETE
    @Path("excluir/{id}")
    public String excluir(@PathParam("id") int id) {
        PessoaDao pesquisa = new PessoaDao();
        pesquisa.excluir(id);
        return "Excluído";
    }
    
}
