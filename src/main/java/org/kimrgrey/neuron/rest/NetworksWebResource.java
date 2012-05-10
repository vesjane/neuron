package org.kimrgrey.neuron.rest;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.kimrgrey.neuron.network.NeuralNetwork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/api/networks")
@Produces("application/json; charset=UTF-8")

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
        test.put("1","2");
        return Response.ok().entity(test).build();
	}

    @GET
    @Path("/{index}")
    public Response getNeuronNetwork(@PathParam("index") int index, @QueryParam("step") int step) {
        //NeuralNetwork network = NeuralNetwork.find(index, step);
        NeuralNetwork network = NeuralNetwork.find(index);
        if (network == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(network).build();
    }

	@POST
	public Response create(@FormParam("input") int input, @FormParam("hidden") int hidden, @FormParam("output") int output) {
        NeuralNetwork.create(input, hidden, output);
        return Response.ok().build();
	}

	/*@GET
	@Path("/{uid}")
	public Response create(@PathParam("uid") String uid) {
		return Response.ok().build();
	}*/
}