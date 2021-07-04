package app;

import config.oracle_dropwizardConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import resource.oracle_dropwizardResource;

public class oracle_dropwizardApplication extends Application<oracle_dropwizardConfiguration> {
    public static void main(String[] args) throws Exception{
        new oracle_dropwizardApplication().run(args);
    }

    @Override
    public void run(oracle_dropwizardConfiguration configuration, Environment environment) {
        final oracle_dropwizardResource resource = new oracle_dropwizardResource(configuration.getInputNumber());
        environment.jersey().register(resource);
    }
}
