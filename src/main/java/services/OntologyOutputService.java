package services;

import models.OutputFormat;

public interface OntologyOutputService {
    String getSchema(OutputFormat format);
    String getIndividualsModel(OutputFormat format);
}
