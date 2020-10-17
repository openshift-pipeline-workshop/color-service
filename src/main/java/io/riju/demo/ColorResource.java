package io.riju.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Counted;

import io.riju.demo.entities.Color;


@Path("/color")
public class ColorResource {

    @ConfigProperty(name = "color-service.color", defaultValue="red")
    String colorName;

    @ConfigProperty(name = "color-service.hexValue", defaultValue="#E53E3E")
    String hexValue;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(name = "color", description = "How many colors we've given.")
    public Color color() {
        return new Color(colorName, hexValue);
    }
}