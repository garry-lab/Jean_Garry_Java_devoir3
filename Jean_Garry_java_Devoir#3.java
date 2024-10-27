// Devoir#3 de Jean Garry
package Jean_Garry_java_devoir#3;

import java.util.ArrayList;
import java.util.Scanner;


//Creation de la Classe représentant un étudiant
class Etudiant {
 private String name;
 private String firstname;
 private String filiere;
 private ArrayList<Double> notesmatieres;

 // Constructeur permettant d'initialiser les données de l'étudiant
 public Etudiant(String name, String firstname, String filiere) {
     this.name = name;
     this.firstname = firstname;
     this.filiere = filiere;
     this.notesmatieres = new ArrayList<>();
 }

 // Méthode permettant  l'ajouter d'une note à la liste
 public void ajouterNote(double note) {
     notesmatieres.add(note);
 }

 // Méthode permettant de calculer la moyenne correspondantes aux notes de l'étudiant
 public double calculerMoyenne() {
     if (notesmatieres.isEmpty()) {
         return 0.0;
     }
     double somme = 0;
     for (double note : notesmatieres) {
         somme += note;
     }
     return somme / notesmatieres.size();
 }

 //  obtention les informations de l'étudiant
 public String getName() {
     return name;
 }

 public String getfirstname() {
     return firstname;
 }

 public String getFiliere() {
     return filiere;
 }
}

public class GestionsEtudiants {
	
	// Liste de stockage  de tous les étudiants
    private static ArrayList<Etudiant> etudiants = new ArrayList<>();

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        boolean continuer = true;

	        while (continuer) {
	            System.out.println("1. Ajouter un étudiant dans la liste");
	            System.out.println("2. Afficher les moyennes des étudiants en 4ème année");
	            System.out.println("3. Quitter");

	            int choix = scanner.nextInt();
	            scanner.nextLine(); // Consommer la nouvelle ligne

	            switch (choix) {
	                case 1:
	                    ajouterEtudiant(scanner);
	                    break;
	                case 2:
	                    afficherMoyennes();
	                    break;
	                case 3:
	                    continuer = false;
	                    break;
	                default:
	                    System.out.println("Choix non valide.");
	            }
	        }
	        scanner.close();
	    }

	    // Méthode permettant d'ajouter un étudiant
	    private static void ajouterEtudiant(Scanner scanner) {
	        System.out.print("Entrer le Nom de l'étudiant: ");
	        String name = scanner.nextLine();
	        System.out.print("Entrer le Prénom de l'étudiant: ");
	        String firstname = scanner.nextLine();
	        System.out.print("Filière (Génie Civil, Génie Électrique, Informatique): ");
	        String filiere = scanner.nextLine();

	        // Création de l'étudiant
	        Etudiant etudiant = new Etudiant(name, firstname, filiere);

	        System.out.println("Entrez le nombre de note dont vous voulez calculer leur moyenne.");
	        int nbNotes = scanner.nextInt();

	        // Saisie des notes
	        for (int i = 0; i < nbNotes; i++) {
	            System.out.print("Entrez la note " + (i + 1) + ": ");
	            double note = scanner.nextDouble();
	            etudiant.ajouterNote(note);
	        }

	        // Ajout de l'étudiant à la liste
	        etudiants.add(etudiant);
	    }

	    // Méthode permettant d'afficher les moyennes des étudiants en 4ème année
	    private static void afficherMoyennes() {
	        System.out.println("Moyennes des étudiants de 4ème année:");
	        for (Etudiant etudiant : etudiants) {
	            if (etudiant.getFiliere().equals("Génie Civil") ||
	                etudiant.getFiliere().equals("Génie Électrique") ||
	                etudiant.getFiliere().equals("Informatique")) {

	                System.out.println(etudiant.getName() + " " + etudiant.getfirstname() + " - " +
	                        etudiant.getFiliere() + " : " + etudiant.calculerMoyenne());
	            }
	        }
		
		

	}

}
