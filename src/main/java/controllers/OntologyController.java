package controllers;

import models.OutputFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.impl.DefaultOntologyOutputService;

@RestController
public class OntologyController {


    @RequestMapping(value = "/ontology/schema", produces = "application/json")
    public ResponseEntity<String> schema (@RequestParam(value="format", defaultValue = "xml") String format){
        OutputFormat outputFormat = OutputFormat.getFromString(format);
        String rdfString = DefaultOntologyOutputService.getInstance().getSchema(outputFormat);
        return ResponseEntity.ok().contentType(outputFormat.getMediaType()).body(rdfString);
    }

}
