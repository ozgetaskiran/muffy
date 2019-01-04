package ontology;

import models.OEntity;
import org.apache.jena.ontology.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.vocabulary.XSD;

public class Ontologie {

    public static final String baseUri = "http://www.ege.edu.tr/mfic";
    public static final String schemaUri = baseUri + "#";
    public static final String individualsUri = baseUri + "/";

    private static final OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);

    public static final OntClass Tag = createOntClass( "Tag");
    public static final OntClass Attainment = createOntClass("Attainment");
    public static final OntClass Subtopic = createOntClass("Subtopic");
    public static final OntClass Subject = createOntClass("Subject");
    public static final OntClass Course = createOntClass("Course");
    public static final OntClass Class = createOntClass("Class");
    public static final OntClass EducationYear = createOntClass("EducationYear");
    public static final OntClass Curriculum = createOntClass("Curriculum");


    public static final DatatypeProperty hasName = createDataProperty("hasName");
    public static final DatatypeProperty hasCode = createDataProperty("hasCode");
    public static final DatatypeProperty hasDescription = createDataProperty("hasDescription");
    public static final DatatypeProperty hasOrder = createDataProperty("hasOrder");

    public static final ObjectProperty hasTag  = createObjectProperty("hasTag");
    public static final ObjectProperty hasAttainment = createObjectProperty("hasAttainment");
    public static final ObjectProperty hasSubtopic = createObjectProperty("hasSubtopic");
    public static final ObjectProperty hasSubject = createObjectProperty("hasSubject");
    public static final ObjectProperty hasCourse = createObjectProperty("hasCourse");
    public static final ObjectProperty hasClass = createObjectProperty("hasClass");
    public static final ObjectProperty hasEducationYear = createObjectProperty("hasEducationYear");

    public static final TransitiveProperty hasPrerequisite = createTransitiveProperty("hasPrerequisite");
    public static final TransitiveProperty hasPreCourse = createTransitiveProperty("hasPreCourse");
    public static final TransitiveProperty hasPreSubtopic = createTransitiveProperty("hasPreSubtopic");
    public static final TransitiveProperty hasPreSubject = createTransitiveProperty("hasPreSubject");


    static{
        m.setNsPrefix("", schemaUri);

        hasName.addDomain(Tag);
        hasName.addDomain(Attainment);
        hasName.addDomain(Subtopic);
        hasName.addDomain(Subject);
        hasName.addDomain(Course);
        hasName.addDomain(Class);
        hasName.addDomain(EducationYear);
        hasName.addDomain(Curriculum);
        hasName.addRange(XSD.xstring);

        hasCode.addDomain(Course);

        hasDescription.addDomain(Attainment);

        hasOrder.addDomain(Subject);

        hasTag.addDomain(Attainment);
        hasTag.addRange(Tag);

        hasAttainment.addDomain(Curriculum);
        hasAttainment.addDomain(Subtopic);
        hasAttainment.addRange(Attainment);

        hasSubtopic.addDomain(Subject);
        hasSubtopic.addRange(Subtopic);

        hasSubject.addDomain(Course);
        hasSubject.addRange(Subject);

        hasCourse.addDomain(Curriculum);
        hasCourse.addRange(Course);

        hasClass.addDomain(Curriculum);
        hasClass.addRange(Class);

        hasEducationYear.addDomain(Curriculum);
        hasEducationYear.addRange(EducationYear);

        hasPrerequisite.addSubProperty(hasPreCourse);
        hasPrerequisite.addSubProperty(hasPreSubject);
        hasPrerequisite.addSubProperty(hasPreCourse);

        hasPreCourse.addDomain(Course);
        hasPreCourse.addRange(Course);

        hasPreSubject.addDomain(Subject);
        hasPreSubject.addRange(Subject);

        hasPreSubtopic.addDomain(Subtopic);
        hasPreSubtopic.addRange(hasPreSubtopic);
    }

    public static Model getModel(){
        return m;
    }

    public static String createIndvUri(String localName, Class<? extends OEntity> clazz){
        String type = clazz.getSimpleName().toLowerCase();
        return String.format("%s%s/%s", individualsUri, type, localName);
    }

    private static OntClass createOntClass(String className){
        return m.createClass(schemaUri + className);
    }

    private static DatatypeProperty createDataProperty(String propName){
        return m.createDatatypeProperty(schemaUri + propName);
    }

    private static ObjectProperty createObjectProperty(String propName){
        return m.createObjectProperty(schemaUri + propName);
    }

    private static TransitiveProperty createTransitiveProperty(String propName){
        return m.createTransitiveProperty(schemaUri + propName);
    }

}
