package io.riju.demo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.Tag;

import io.riju.demo.entities.Color;


@Path("/color")
public class ColorResource {

    @ConfigProperty(name = "color-service.color", defaultValue="red")
    String colorName;

    @Inject
    MetricRegistry metricRegistry;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Color color() {
        Counter counter = metricRegistry.counter("color_total", new Tag("color", colorName));
        counter.inc();
        return new Color(colorName);
    }
}