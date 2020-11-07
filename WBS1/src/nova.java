import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;

import java.io.InputStream;

public class nova {
    static final String inputFileName= "C:\\Users\\x\\IdeaProjects\\WBS1\\nova1.xml";

    public static void main(String[] args){

        Model model = ModelFactory.createDefaultModel();
        InputStream in = FileManager.get().open(inputFileName);
        if(in == null){
            throw new IllegalArgumentException("FIle: " + inputFileName + " not found");

        }
        model.read(in, "");



        System.out.println("Print as RDF/XML:");
        model.write(System.out, "RDF/XML");

        //retrive the vcard resource from the model
        Resource jSmithVcard = model.getResource("https://www.facebook/com/aleksandra.stefanovska99/");


        //retrieve the value of the N property
        Resource name = (Resource) jSmithVcard.getProperty(VCARD.N).getResource();

        //za literal na property
        //Resource name = (Resource) jSmithVcard.getProperty(VCARD.N).getString();


        jSmithVcard.addProperty(VCARD.NICKNAME, "Alek").addProperty(VCARD.NICKNAME, "Ane");

        System.out.println("Nickname \"" + name + "\" :");

        StmtIterator iter = jSmithVcard.listProperties(VCARD.NICKNAME);
        while(iter.hasNext()){
            System.out.println("  " + iter.nextStatement().getObject().toString());
        }

    }
}
