package abstraction.eq9Distributeur3;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import abstraction.eqXRomu.filiere.Filiere;
import abstraction.eqXRomu.filiere.IActeur;
import abstraction.eqXRomu.general.Journal;
import abstraction.eqXRomu.general.Variable;

public class Distributeur3Acteur implements IActeur {
	
	protected int cryptogramme;

	public Distributeur3Acteur() {
	}
	
	public void initialiser() {
	}

	public String getNom() {// NE PAS MODIFIER
		return "EQ9";
	}

	////////////////////////////////////////////////////////
	//         En lien avec l'interface graphique         //
	////////////////////////////////////////////////////////

	public void next() {
		
	}
	
	
	public void etat_ventes(){
		// regarder les stocks de chaque gamme (moyen, moyen BE, haut), 
		// regarder nos ventes et les ventes du marché pour savoir ce 
		// qu'il faut acheter par ordre de priorité

		// variables dont j'ai besoin : 
		// 1. stocks L = [10000,20000,12000] par exemple
		// 2. ventes L = [x,y,z] et ventes du marche à calculer L = [x_eq1 + x_eq_2 + ...,y,z]

		
	}
	public void achat_stock(){

		// en fonction de lookat_results(), l�acteur devra réaliser des contrats
		// cadres ou des appels d'offres ou accepter des offres pour certaines 
		// gammes bas� sur leur priorité.


	}
	public void contrat_cadre(){}
	public void appels_offres(){}
	public void offres(){}
	public void calcul_prix_de_vente() {
		// pour chaque gamme, renvoie une hashmap <marque, prix>       
		// (prendre en compte la rentabilité, le positionnement des autres marques)

	}
	public void repartition_tete_gondole() {
		//renvoie une hashmap <marque, quatité>
	}
	public void cout_stock() {
				//, calcul le coût de stockage.

	}
	public void quantite_rayon() {

				//déterminer quel part du stock est mise en rayon

	}
	public void cout_masse_salariale() {}

	

	public Color getColor() {// NE PAS MODIFIER
		return new Color(245, 155, 185); 
	}

	public String getDescription() {
		return "Bla bla bla";
	}

	// Renvoie les indicateurs
	public List<Variable> getIndicateurs() {
		List<Variable> res = new ArrayList<Variable>();
		return res;
	}

	// Renvoie les parametres
	public List<Variable> getParametres() {
		List<Variable> res=new ArrayList<Variable>();
		return res;
	}

	// Renvoie les journaux
	public List<Journal> getJournaux() {
		List<Journal> res=new ArrayList<Journal>();
		return res;
	}

	////////////////////////////////////////////////////////
	//               En lien avec la Banque               //
	////////////////////////////////////////////////////////

	// Appelee en debut de simulation pour vous communiquer 
	// votre cryptogramme personnel, indispensable pour les
	// transactions.
	public void setCryptogramme(Integer crypto) {
		this.cryptogramme = crypto;
	}

	// Appelee lorsqu'un acteur fait faillite (potentiellement vous)
	// afin de vous en informer.
	public void notificationFaillite(IActeur acteur) {
	}

	// Apres chaque operation sur votre compte bancaire, cette
	// operation est appelee pour vous en informer
	public void notificationOperationBancaire(double montant) {
	}
	
	// Renvoie le solde actuel de l'acteur
	public double getSolde() {
		return Filiere.LA_FILIERE.getBanque().getSolde(Filiere.LA_FILIERE.getActeur(getNom()), this.cryptogramme);
	}

	////////////////////////////////////////////////////////
	//        Pour la creation de filieres de test        //
	////////////////////////////////////////////////////////

	// Renvoie la liste des filieres proposees par l'acteur
	public List<String> getNomsFilieresProposees() {
		ArrayList<String> filieres = new ArrayList<String>();
		return(filieres);
	}

	// Renvoie une instance d'une filiere d'apres son nom
	public Filiere getFiliere(String nom) {
		return Filiere.LA_FILIERE;
	}

}
