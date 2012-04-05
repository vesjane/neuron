package org.kimrgrey.neural.rest;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/api/networks")
@Produces("application/json; charset=UTF-8")
@Consumes("application/json; charset=UTF-8")
public class NeuralNetworkWebResource {
	/**
     * Логгер SLF4J для класса.
     */
    private static final Logger logger = LoggerFactory.getLogger(NeuralNetworkWebResource.class);

    /**
     * Конструктор по умолчанию. Должен быть явно указан для классов, представляющих
     * ресурсы веб-сервиса.
     */
	public NeuralNetworkWebResource() {
	}

	@GET
	public Response list() {
		Map<String, String> test = new HashMap<String, String>();
		test.put("Hello", "World");
		test.put("Bye", "Bye");
		return Response.ok().entity(test).build();
	}

	@GET
	@Path("/create")
	// @POST
	public Response create(@QueryParam("input") int input, @QueryParam("output") int output) {
		return Response.ok().entity(String.format("Input %d and output %d", input, output)).build();
	}
}