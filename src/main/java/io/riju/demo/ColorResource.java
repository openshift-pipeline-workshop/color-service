package io.riju.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.riju.demo.entities.Color;
import org.eclipse.microprofile.config.inject.ConfigProperty;


@Path("/color")
public class ColorResource {

    @ConfigProperty(name = "color-service.color", defaultValue="red")
    String colorName;

    @ConfigProperty(name = "color-service.hexValue", defaultValue="#E53E3E")
    String hexValue;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Color color() {
        return new Color(colorName, hexValue);
    }
}