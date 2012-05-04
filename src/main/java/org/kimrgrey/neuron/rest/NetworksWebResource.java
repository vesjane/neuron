package org.kimrgrey.neuron.rest;

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

import org.kimrgrey.neuron.network.NeuralNetwork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/api/networks")
@Produces("application/json; charset=UTF-8")
@Consumes("application/json; charset=UTF-8")
public class NetworksWebResource {
	/**
     * Логгер SLF4J для класса.
     */
    private static final Logger logger = LoggerFactory.getLogger(NetworksWebResource.class);

    /**
     * Конструктор по умолчанию. Должен быть явно указан для классов, представляющих
     * ресурсы веб-сервиса.
     */
	public NetworksWebResource() {
	}

	@GET
	public Response list() {
		Map<String, Object> test = new HashMap<String, Object>();
        NeuralNetwork nn = new NeuralNetwork(2, 3, 1);
        int maxRuns = 50000;
        double minErrorCondition = 0.001;
        test = nn.run(maxRuns, minErrorCondition);
       // test.put("1","2");
		return Response.ok().entity(test).build();
	}

	@POST
	public Response create(@QueryParam("input") int input, @QueryParam("output") int output) {
		return Response.ok().entity(String.format("Input %d and output %d", input, output)).build();
	}

	/*@GET
	@Path("/{uid}")
	public Response create(@PathParam("uid") String uid) {
		return Response.ok().build();
	}*/
}