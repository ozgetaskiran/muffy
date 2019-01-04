package models;

import org.apache.jena.riot.Lang;
import org.springframework.http.MediaType;

public enum OutputFormat {
    RDF_XML(Lang.RDFXML, MediaType.APPLICATION_XML),
    RDF_JSON(Lang.RDFJSON, MediaType.APPLICATION_JSON),
    TRIPLES_XML(Lang.TRIX, MediaType.APPLICATION_XML),
    TRIPLES_JSON(Lang.JSONLD, MediaType.APPLICATION_JSON),
    TRIPLES_PLAIN(Lang.NTRIPLES, MediaType.TEXT_PLAIN);

    private Lang lang;
    private MediaType mediaType;

    OutputFormat(Lang lang, MediaType mediaType){
        this.lang = lang;
        this.mediaType = mediaType;
    }

    public String getLang(){
        return lang.getName();
    }

    public MediaType getMediaType(){
        return mediaType;
    }

    public static OutputFormat getFromString(String format){
        switch(format.toLowerCase()){
            case "xml":
            case "schema-xml": return RDF_XML;
            case "json":
            case "schema-json": return RDF_JSON;
            case "triples-xml": return TRIPLES_XML;
            case "triples-json": return TRIPLES_JSON;
            case "triples": return TRIPLES_PLAIN;
            default: return RDF_XML;
        }
    }

}
