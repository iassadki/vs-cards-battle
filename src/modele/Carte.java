package modele;

import java.util.ArrayList;

public class Carte {

	private String couleur;
	private String nom;
	private int valeur;
	
	static ArrayList<Carte> paquet = new ArrayList<Carte>();

	public Carte() {
		super();
	}

	public Carte(String couleur, String nom, int valeur) {
		super();
		this.couleur = couleur;
		this.nom = nom;
		this.valeur = valeur;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public static ArrayList<Carte> initialisationPaquet() {

	String[] couleurs = { "Coeur", "Carreau", "Trèfle", "Pique" };
	int[] valeurs = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 }; // "Valet", "Dame", "Roi", "As"
	String[] noms = { "Deux", "Trois", "Quatre", "Cinq", "Six", "Sept", "Huit", "Neuf", "Dix", "Valet", "Dame", "Roi", "As" };


	        for (int i = 0; i < couleurs.length; i++) {
	            for (int j = 0; j < valeurs.length; j++) {
	                Carte carte = new Carte(couleurs[i], noms[j], valeurs[j]);
	                paquet.add(carte);
	            }
	        }
			
			return paquet;

	    }

	   public static void distribuerCartes(ArrayList<Carte> paquet, ArrayList<Carte> paquetJoueur1, ArrayList<Carte> paquetJoueur2) {

		    int tailleDuPaquet = paquet.size();
		    int cartesParJoueur = tailleDuPaquet / 2;

		    if (tailleDuPaquet % 2 != 0) {
		        System.out.println("Le paquet ne peut pas être équitablement divisé entre les joueurs.");
		        return;
		    }

		    for (int i = 0; i < cartesParJoueur; i++) {
		        paquetJoueur1.add(new Carte(paquet.get(i).getCouleur(), paquet.get(i).getNom(), paquet.get(i).getValeur()));
		        paquetJoueur2.add(new Carte(paquet.get(i + cartesParJoueur).getCouleur(), paquet.get(i + cartesParJoueur).getNom(), paquet.get(i + cartesParJoueur).getValeur()));
		    }
		}
	
	public static void voirPaquet(ArrayList<Carte> paquet) {
		System.out.println("Il reste " + paquet.size()+ " cartes au paquet");
		
		for (int i = 0; i < paquet.size(); i++) {
			if (paquet.get(i) != null) {
				System.out.println(paquet.get(i).toString());
			} else {
				System.out.println("Aucune carte existe a cet emplacement");
			}
			
		}
		
        for (Carte carte : paquet) {
           System.out.println("affichage des cartes");
           System.out.println(carte.getNom() + " de " + carte.getCouleur());
        }
	}	

	@Override
	public String toString() {
		return this.getNom() + " de " + this.getCouleur();
	}

}
