package abstraction.eq1Producteur1;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import abstraction.eqXRomu.filiere.Filiere;
import abstraction.eqXRomu.filiere.IActeur;
import abstraction.eqXRomu.general.Journal;
import abstraction.eqXRomu.general.Variable;
import abstraction.eqXRomu.produits.Lot;

public class Producteur1Acteur implements IActeur {
	
	protected int cryptogramme;
	protected Journal journal;
	protected Journal journal_stocks;
	protected Journal journal_ventes;
	protected int step;
	protected champ champ;
	protected Lot stockFeveBas;
	protected Lot stockFeveMoy;

	public Producteur1Acteur() {
		this.journal = new Journal("Journal "+this.getNom(), this);
		this.journal_stocks = new Journal("Journal : stocks"+this.getNom(), this);
		this.journal_ventes = new Journal("Journal : ventes"+this.getNom(), this);
	}
	
	public void initialiser() {
		this.step = 0;
		this.champ = new champ();//initialisation de nos champs avec un hectare pour compiler sans bug : à modifier
		this.champ.add(new hectar("B"));
	}

	public String getNom() {// NE PAS MODIFIER
		return "EQ1";
	}

	////////////////////////////////////////////////////////
	//         En lien avec l'interface graphique         //
	////////////////////////////////////////////////////////

	public void next() {
		this.step = this.step + 1;
		this.journal.ajouter("step : "+step);
		this.journal_stocks.ajouter("===== step : "+step+" =====");
		this.journal_stocks.ajouter("Stock bas de gamme : "+this.stockFeveBas.getQuantiteTotale());
		this.journal_stocks.ajouter("Stock moyenne gamme : "+this.stockFeveMoy.getQuantiteTotale());
	}

	public Color getColor() {// NE PAS MODIFIER
		return new Color(243, 165, 175); 
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
		res.add(this.journal);
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
	public String toString() {
		return this.getNom();
	}
}
