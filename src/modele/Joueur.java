package modele;

import java.util.ArrayList;

public class Joueur {

	private String nom;
	private ArrayList<Carte> paquetJoueur;
	private int score; 
	private Carte carteTiree; 
	static ArrayList<Carte> pileDuJeu = new ArrayList<Carte>();

	public Joueur() {
		super();
	}

	public Joueur(String nom) {
		super();
		this.nom = nom;
		this.score = 0;
		this.setPaquet(new ArrayList<Carte>());
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPaquet(ArrayList<Carte> paquet) {
		this.paquetJoueur = paquet;
	}

	public ArrayList<Carte> getPaquet() {
		return this.paquetJoueur;
	}
	
	public static void voirCartes(ArrayList<Carte> paquetJoueur) {
		System.out.println("Il reste " + paquetJoueur.size()+ " cartes au paquet du joueur");
		
		for (int i = 0; i < paquetJoueur.size(); i++) {
			if (paquetJoueur.get(i) != null) {
				System.out.println(paquetJoueur.get(i).toString());
			} else {
				System.out.println("Aucune carte existe a cet emplacement");
			}
			
		}
	}
	    
    public void tireCarte(ArrayList<Carte> paquetJoueur) {

        if (paquetJoueur.isEmpty()) {
            System.out.println("Le paquet est vide, impossible de tirer une carte.");
            return; 
        }
        carteTiree = paquetJoueur.get(0); 
        paquetJoueur.remove(0);  
    }

	public void getCarteTiree(ArrayList<Carte> paquetJoueur) {
		System.out.println("La carte tirée par le joueur : "+carteTiree);
	}

    public void poseCarte() {
        pileDuJeu.add(carteTiree); 
    }

	public void compareTo(ArrayList<Carte> paquetJoueur2) {
		System.out.println(paquetJoueur2.size());
		System.out.println(this.getCarteTiree());
	}

	public Carte getCarteTiree() {
		return carteTiree;
	}

	public void setCarteTiree(Carte carteTiree) {
		this.carteTiree = carteTiree;
	}
	
	public void setscore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", paquet=" + paquetJoueur + ", score=" + score + "]";
	}

	public void recupererPileDuJeu(ArrayList<Carte> pileDuJeu) {
		paquetJoueur.addAll(0, this.pileDuJeu);

	}

	public void incrementerCompteurPoints() {
		score++;
	} 

}

