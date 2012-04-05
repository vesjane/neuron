package org.kimrgrey.neural.app;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.xml.XmlConfiguration;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);


	public static void main (String... args) {
		Application application = new Application(args);
		application.execute();
	}

	private CommandLine commandLine = null;

	public Application (String... args) {
		Options options = new Options();
        options.addOption("h", "help", false, "Display message that describes parameters for the application");
        CommandLineParser parser = new PosixParser();
        try {
            this.commandLine = parser.parse(options, args);
        } catch (ParseException expression) {
            printUsage(options);
            return;
        }
        if (commandLine.hasOption("help")) {
            printUsage(options);
            this.commandLine = null;
        }
	}

	private void printUsage(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "neural", options);
    }

	public void execute(String... args) {
		if (commandLine == null) {
            return;
        }
		Server server = null;
		try {
			Resource resource = Resource.newSystemResource("jetty.xml");
			XmlConfiguration configuration  = new XmlConfiguration(resource.getInputStream());
			server = (Server)configuration.configure();
		} catch (Exception exception) {
			logger.error("Failed to create Search Your Vacancy Web Service because of error", exception);
			return;
		} 
        try {
			server.start();
			server.join();
		} catch (Exception exception) {
			logger.error("Failed to start web service because of configuration parsing error", exception);
		}
	}
}