package tests;

import modele.Joueur;
import modele.Carte;
import java.util.Collections;
import java.util.ArrayList;

public class Tests {

	public static void main(String[] args) {

		System.out.println("Bataille");

		int waiting = 100;

		System.out.println("Création des joueurs...");
		Joueur j1 = new Joueur("Joueur 1");
		Joueur j2 = new Joueur("Joueur 2");
		ArrayList<Carte> paquetJoueur1 = new ArrayList<Carte>(); //
		ArrayList<Carte> paquetJoueur2 = new ArrayList<Carte>(); //

		try {
			Thread.sleep(waiting);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Création du paquet de cartes...");
		ArrayList<Carte> paquet = Carte.initialisationPaquet(); //

		System.out.println("Création de la pile du jeu...");
		ArrayList<Carte> pileDuJeu = new ArrayList<Carte>(); // 

		try {
			Thread.sleep(waiting);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Mélange du paquet de cartes...");
		Collections.shuffle(paquet);

		try {
			Thread.sleep(waiting);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Distribution des cartes aux deux joueurs...");
		Carte.distribuerCartes(paquet, paquetJoueur1, paquetJoueur2);


		try {
			Thread.sleep(waiting);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(" ");

		int tour = 0;
		while (!paquetJoueur1.isEmpty() && !paquetJoueur2.isEmpty()) {
			int waitingGame = 110;
			System.out.println("Tour N°" + tour);
			
			try {
				Thread.sleep(waitingGame);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// System.out.println("pileDuJeu : "+pileDuJeu.size());
			System.out.println(" "); 
			j1.tireCarte(paquetJoueur1); j2.tireCarte(paquetJoueur2); 
			System.out.println("Joueur 1 tire et pose : "+j1.getCarteTiree());
			System.out.println("Joueur 2 tire et pose : "+j2.getCarteTiree());
			pileDuJeu.add(0, j1.getCarteTiree()); pileDuJeu.add(j2.getCarteTiree());
			if (j1.getCarteTiree().getValeur() > j2.getCarteTiree().getValeur()) {                 
				j1.incrementerCompteurPoints();                 
				System.out.println("-> Joueur 1 gagne la manche !");
				j1.recupererPileDuJeu(pileDuJeu);
				System.out.println(" ");
			} else if (j1.getCarteTiree().getValeur() < j2.getCarteTiree().getValeur()) {                 
				j2.incrementerCompteurPoints();                  
				System.out.println("-> Joueur 2 gagne la manche !");
				j2.recupererPileDuJeu(pileDuJeu);
				System.out.println(" ");
			} else {                   
				System.out.println("Bataille !");
				j1.tireCarte(paquetJoueur1); j2.tireCarte(paquetJoueur2); 
				System.out.println("Joueur 1 tire et pose : "+j1.getCarteTiree());
				System.out.println("Joueur 2 tire et pose : "+j2.getCarteTiree());
				pileDuJeu.add(0, j1.getCarteTiree()); pileDuJeu.add(j2.getCarteTiree()); 
						int maxDeBatailles = 3; // Le nombre maximum de batailles consécutives que vous voulez autoriser
						int nombreDeBatailles = 0;
						while (nombreDeBatailles != maxDeBatailles) {
						    if (j1.getCarteTiree().getValeur() > j2.getCarteTiree().getValeur()) {                 
						        j1.incrementerCompteurPoints();                 
						        System.out.println("-> Joueur 1 gagne la bataille !");                 
						        j1.recupererPileDuJeu(pileDuJeu);
						        System.out.println(" ");
						        // La bataille est résolue, réinitialisez le compteur
						        nombreDeBatailles = 0;
								break;
						    } else if (j1.getCarteTiree().getValeur() < j2.getCarteTiree().getValeur()) {                 
						        j2.incrementerCompteurPoints();                 
						        System.out.println("-> Joueur 2 gagne la bataille !");                 
						        j2.recupererPileDuJeu(pileDuJeu);
						        System.out.println(" ");
						        // La bataille est résolue, réinitialisez le compteur
						        nombreDeBatailles = 0;
								break;
						    } else if (j1.getCarteTiree().getValeur() == j2.getCarteTiree().getValeur()) { 
						        // Les cartes sont égales, augmentez le compteur
						        nombreDeBatailles++;
						    }
						}
		
			}

		if (paquetJoueur1.isEmpty() && paquetJoueur2.isEmpty()) {
			System.out.println(" ");
			System.out.println("Fin de la partie !");
			System.out.println("Score de Joueur 1 : " + j1.getScore());
			System.out.println("Score de Joueur 2 : " + j2.getScore());
			if (j1.getScore() > j2.getScore()) {
				System.out.println(" ");
				System.out.println("-> Joueur 1 gagne la partie !");
				System.out.println("Nombre de cartes de Joueur 1 : " + paquetJoueur1.size());
				System.out.println("Nombre de cartes de Joueur 2 : " + paquetJoueur2.size());
			} else if (j1.getScore() < j2.getScore()) {
				System.out.println(" ");
				System.out.println("-> Joueur 2 gagne la partie !");
				System.out.println("Nombre de cartes de Joueur 1 : " + paquetJoueur1.size());
				System.out.println("Nombre de cartes de Joueur 2 : " + paquetJoueur2.size());
			} else {
				System.out.println(" ");
				System.out.println("-> Égalité entre Joueur 1 & Joueur 2 !");
				System.out.println("Nombre de cartes de Joueur 1 : " + paquetJoueur1.size());
				System.out.println("Nombre de cartes de Joueur 2 : " + paquetJoueur2.size());
			}
		}

			
		try {
			Thread.sleep(waitingGame);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}



		tour++;
		pileDuJeu.clear(); 
		System.out.println(" ");
		System.out.println("--------------------");
		}



	}
}



