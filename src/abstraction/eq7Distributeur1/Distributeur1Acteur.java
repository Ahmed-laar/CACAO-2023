package abstraction.eq7Distributeur1;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import abstraction.eqXRomu.filiere.Filiere;
import abstraction.eqXRomu.filiere.IActeur;
import abstraction.eqXRomu.general.Journal;
import abstraction.eqXRomu.general.Variable;
import abstraction.eqXRomu.produits.ChocolatDeMarque;
import abstraction.eqXRomu.produits.Feve;

public class Distributeur1Acteur implements IActeur {
	////////////////////////////////////////////////
	//d�claration des variables
	public static Color COLOR_LLGRAY = new Color(238,238,238);
	public static Color COLOR_BROWN  = new Color(141,100,  7);
	public static Color COLOR_PURPLE = new Color(100, 10,115);
	public static Color COLOR_LPURPLE= new Color(155, 89,182);
	public static Color COLOR_GREEN  = new Color(  6,162, 37);
	public static Color COLOR_LGREEN = new Color(  6,255, 37);
	public static Color COLOR_LBLUE  = new Color(  6,130,230);

	
	protected Journal journal;

	private Variable qualiteHaute;  // La qualite d'un chocolat de gamme haute 
	private Variable qualiteMoyenne;// La qualite d'un chocolat de gamme moyenne  
	private Variable qualiteBasse;  // La qualite d'un chocolat de gamme basse
	private Variable pourcentageRSEmax;//Le pourcentage de reversion RSE pour un impact max sur la qualite percue
	private Variable partRSEQualitePercue;//L'impact de pourcentageRSEmax% du prix consacres aux RSE dans la qualite percue du chocolat
	private Variable coutStockageProducteur;//Le cout moyen du stockage d'une Tonne a chaque step chez un producteur de feves

	protected Variable totalStocksCB;  // La qualite totale de stock de chocolat bas de gamme 
	protected Variable totalStocksCML;  // La qualite totale de stock de chocolat moyenne gamme lab�llis�
	protected Variable totalStocksCMNL;  // La qualite totale de stock de chocolat moyenne gamme non lab�llis�
	protected Variable totalStocksCH;  // La qualite totale de stock de chocolat haute gamme
	protected Variable totalStocks;  // La qualite totale de stock de chocolat
	
	protected Variable coutCB; //Cout d'1kg de chocolat basse gamme
	protected Variable coutCML; //Cout d'1kg de chocolat moyenne gamme labellis�
	protected Variable coutCMNL; //Cout d'1kg de chocolat moyenne gamme non labellis�
	protected Variable coutCH; //Cout d'1kg de chocolat haute gamme labellis�
	
	protected List<Feve> lesFeves;
	
	////////////////////////////////////////
	
	protected HashMap<ChocolatDeMarque, Double> stockChocoMarque7;
	
	protected int cryptogramme;

	public Distributeur1Acteur() {
	}
	
	public void initialiser() {
	}

	public String getNom() {// NE PAS MODIFIER
		return "EQ7";
	}

	////////////////////////////////////////////////////////
	//         En lien avec l'interface graphique         //
	////////////////////////////////////////////////////////

	public void next() {
	}

	public Color getColor() {// NE PAS MODIFIER
		return new Color(162, 207, 238); 
	}

	public String getDescription() {
		return "Bla bla bla";
	}

	// Renvoie les indicateurs
	public List<Variable> getIndicateurs() {
		List<Variable> res = new ArrayList<Variable>();
		res.add(this.totalStocksCB);
		res.add(this.totalStocksCH);
		res.add(this.totalStocksCML);
		res.add(this.totalStocksCMNL);
		res.add(this.totalStocks);

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
		if (this==acteur) {
			System.out.println("They killed Chocorama... ");
		} else {
			System.out.println("try again "+acteur.getNom()+"... We will not miss you. "+this.getNom());
		}
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
