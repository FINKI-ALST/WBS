import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.vocabulary.VCARD;
public class prelab {
    static String personURI = "https://www.facebook/com/aleksandra.stefanovska99/";
    static String fullName = "Aleksandra Stefanovska";
    public static void main (String[] args){

        //create an empty model
        Model model = ModelFactory.createDefaultModel();

        //create the resource
        Resource johnSmith = model.createResource(personURI);

        //add rhe property
        johnSmith.addProperty(VCARD.FN, fullName);


        model.write(System.out);
    }
}