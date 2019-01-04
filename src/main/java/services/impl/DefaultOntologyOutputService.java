package services.impl;

import models.OutputFormat;
import ontology.Ontologie;
import services.OntologyOutputService;

import java.io.StringWriter;

public class DefaultOntologyOutputService implements OntologyOutputService {

    private static DefaultOntologyOutputService SINGLE_INSTANCE = new DefaultOntologyOutputService();

    private DefaultOntologyOutputService() {
    }

    public static DefaultOntologyOutputService getInstance() {
        return SINGLE_INSTANCE;
    }

    @Override
    public String getSchema(OutputFormat format) {
        StringWriter writer = new StringWriter();
        Ontologie.getModel().write(writer, format.getLang(), Ontologie.baseUri);
        return writer.toString();
    }

    @Override
    public String getIndividualsModel(OutputFormat format) {
        return null;
    }
}
