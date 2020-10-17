package io.riju.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Counted;

import io.riju.demo.entities.Version;

@Path("/version")
public class VersionResource {

    @ConfigProperty(name = "quarkus.application.version", defaultValue = "N/A")
    String versionString;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(name = "versionCalls", description = "How many versions we've given.")
    public Version version() {
        return new Version(versionString);
    }
}