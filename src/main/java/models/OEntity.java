package models;

import ontology.Ontologie;
import utils.OUtils;

public class OEntity {

    public String name;

    private String uri = null;

    public OEntity(String name){
        this.name = name;
    }


    public String getUri(){
        if(this.uri==null){
            this.uri = createUri();
        }
        return this.uri;
    }

    private String createUri() {
        return Ontologie.createIndvUri(OUtils.makeUriFriendly(name), getClass());
    }
}
