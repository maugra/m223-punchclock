package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Tags;

import ch.zli.m223.service.TagService;

@Path("/tags")
@Tag(name = "Entries", description = "Handling of entries")
public class TagController {

    @Inject
    TagService tagService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Index all tags.",
        description = "Returns a list of all tags."
    )
    public List<Tags> index() {
        return tagService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Creates a new Category.",
        description = "Creates a new Category and returns the newly added entry."
    )
    public Tags create(Tags tag) {
       return tagService.createTag(tag);
    }

    @Path("/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "deletes an entry",
        description = "deletes the specified Entry"
    )
    public void delete(Long id){
        tagService.delete(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "edits an existing entry",
        description = "edits the specified entry"
    )
    public Tags update(Tags tag){
        return tagService.update(tag);
    }
    

}
