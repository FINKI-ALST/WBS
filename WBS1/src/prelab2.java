import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;

public class prelab2 {
    public static void main(String[] args) {
         String personURI = "https://www.facebook/com/aleksandra.stefanovska99/";

         String givenName = "Aleksandra";
         String familyName = "Stefanovska";
         String fullName = givenName + "" + familyName;

        String givenName1 = "Aleksandra1";
        String familyName1 = "Stefanovska1";
        String fullName1 = givenName1 + "" + familyName1;

        String givenName2 = "Aleksandra2";
        String familyName2 = "Stefanovska2";
        String fullName2 = givenName2 + "" + familyName2;

        String givenName3 = "Aleksandra3";
        String familyName3 = "Stefanovska3";
        String fullName3 = givenName3 + "" + familyName3;

        String givenName4 = "Aleksandra4";
        String familyName4 = "Stefanovska4";
        String fullName4 = givenName4 + "" + familyName4;

        String givenName5 = "Aleksandra5";
        String familyName5 = "Stefanovska5";
        String fullName5 = givenName5 + "" + familyName5;

        String givenName6 = "Aleksandra6";
        String familyName6 = "Stefanovska6";
        String fullName6 = givenName6 + "" + familyName6;

        String givenName7 = "Aleksandra7";
        String familyName7 = "Stefanovska7";
        String fullName7 = givenName7 + "" + familyName7;

        String givenName8 = "Aleksandra8";
        String familyName8 = "Stefanovska8";
        String fullName8 = givenName8 + "" + familyName8;

        String givenName9 = "Aleksandra9";
        String familyName9 = "Stefanovska9";
        String fullName9 = givenName9 + "" + familyName9;



         Model model = ModelFactory.createDefaultModel();
         Resource johnSmith = model.createResource(personURI).addProperty(VCARD.FN, fullName)
                 .addProperty(VCARD.N, model.createResource().addProperty(VCARD.Given, givenName).addProperty(VCARD.Family, familyName));

        Resource johnSmith1 = model.createResource(personURI).addProperty(VCARD.FN, fullName1)
                .addProperty(VCARD.N, model.createResource().addProperty(VCARD.Given, givenName1).addProperty(VCARD.Family, familyName1));

        Resource johnSmith2 = model.createResource(personURI).addProperty(VCARD.FN, fullName2)
                .addProperty(VCARD.N, model.createResource().addProperty(VCARD.Given, givenName2).addProperty(VCARD.Family, familyName2));

        Resource johnSmith3 = model.createResource(personURI).addProperty(VCARD.FN, fullName3)
                .addProperty(VCARD.N, model.createResource().addProperty(VCARD.Given, givenName3).addProperty(VCARD.Family, familyName3));

        Resource johnSmith4 = model.createResource(personURI).addProperty(VCARD.FN, fullName4)
                .addProperty(VCARD.N, model.createResource().addProperty(VCARD.Given, givenName4).addProperty(VCARD.Family, familyName4));

        Resource johnSmith5 = model.createResource(personURI).addProperty(VCARD.FN, fullName5)
                .addProperty(VCARD.N, model.createResource().addProperty(VCARD.Given, givenName5).addProperty(VCARD.Family, familyName5));

        Resource johnSmith6 = model.createResource(personURI).addProperty(VCARD.FN, fullName6)
                .addProperty(VCARD.N, model.createResource().addProperty(VCARD.Given, givenName6).addProperty(VCARD.Family, familyName6));

        Resource johnSmith7 = model.createResource(personURI).addProperty(VCARD.FN, fullName7)
                .addProperty(VCARD.N, model.createResource().addProperty(VCARD.Given, givenName7).addProperty(VCARD.Family, familyName7));

        Resource johnSmith8 = model.createResource(personURI).addProperty(VCARD.FN, fullName8)
                .addProperty(VCARD.N, model.createResource().addProperty(VCARD.Given, givenName8).addProperty(VCARD.Family, familyName8));

        Resource johnSmith9 = model.createResource(personURI).addProperty(VCARD.FN, fullName9)
                .addProperty(VCARD.N, model.createResource().addProperty(VCARD.Given, givenName9).addProperty(VCARD.Family, familyName9));


        StmtIterator iter = model.listStatements();
        while(iter.hasNext()){
            Statement stmt = iter.nextStatement();
            Resource subject = stmt.getSubject();
            Property predicate = stmt.getPredicate();
            RDFNode object = stmt.getObject();

            System.out.print("Printing with model.listStatements():");
            System.out.print(subject.toString() + " - ");
            System.out.print("  " + predicate.toString() + " - ");
            if(object instanceof Resource){
                System.out.println(object.toString());
            }
            else {
                System.out.print(" \"" + object.toString() + "\"");
            }
            System.out.print(" .");
        }

        System.out.println("Print as RDF/XML:");
        model.write(System.out);

        System.out.println("Print as pretty RDF/XML:");
        model.write(System.out, "RDF/XML-ABBREV");

        System.out.println("Print as N-Triples:");
        model.write(System.out, "N-Triples");

        System.out.println("Print as Turtle:");
        model.write(System.out, "Turtle");


    }
}