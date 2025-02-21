package abstraction.eq4Transformateur1.Vente;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import abstraction.eq4Transformateur1.Stock;
import abstraction.eq4Transformateur1.Achat.AchatBourse;
import abstraction.eqXRomu.contratsCadres.Echeancier;
import abstraction.eqXRomu.contratsCadres.ExemplaireContratCadre;
import abstraction.eqXRomu.contratsCadres.IAcheteurContratCadre;
import abstraction.eqXRomu.contratsCadres.IVendeurContratCadre;
import abstraction.eqXRomu.contratsCadres.SuperviseurVentesContratCadre;
import abstraction.eqXRomu.filiere.Filiere;
import abstraction.eqXRomu.offresAchat.PropositionVenteOA;
import abstraction.eqXRomu.produits.Chocolat;
import abstraction.eqXRomu.produits.ChocolatDeMarque;
import abstraction.eqXRomu.produits.Feve;
import abstraction.eqXRomu.produits.Gamme;
import abstraction.eqXRomu.produits.IProduit;
import abstraction.eqXRomu.produits.Lot;

/**

 * @author Fouad LBAKALI & Amine RAHIM & verification François Glavatkii

/**

 *
 */

public class CC_distributeur extends AchatBourse implements IVendeurContratCadre {


	protected SuperviseurVentesContratCadre superviseurVentesCC;
	
	public void initialiser() {
		super.initialiser();
		this.superviseurVentesCC = (SuperviseurVentesContratCadre)(Filiere.LA_FILIERE.getActeur("Sup.CCadre"));
	}
	
	/**
	 * @author fouad
	 *
	 */

	
	 //next de amine :
	/*public void next() {
		super.next();

		// === Lancement si possible d'un contrat cadre
		if (this.superviseurVentesCC!=null) {
			List<IProduit> produits = new LinkedList<IProduit>();
			Chocolat cb = Chocolat.C_BQ;	
			produits.add(cb);
			for (ChocolatDeMarque c: Filiere.LA_FILIERE.getChocolatsProduits()) {
				if (c.getMarque().equals("Vccotioi")) {
					produits.add(c);
				}
				}
			this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, Color.BLUE, " CCV : Tentative de lancer un contrat cadre");
			this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, Color.BLUE, " CCV : Liste de tous les produits "+produits);
			List<IProduit> produitsAcheteur = new LinkedList<IProduit>();
			List<IProduit> produits2Acheteurs = new LinkedList<IProduit>();
			for (IProduit prod : produits) {
				if (superviseurVentesCC.getAcheteurs(prod).size()>0) {
					produitsAcheteur.add(prod);
					if (superviseurVentesCC.getAcheteurs(prod).size()>1) {
						produits2Acheteurs.add(prod);
					}
				}
			}
			this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, Color.BLUE, " CCV : Liste de tous les produits pour lesquels il existe au moins 1 acheteur  "+produitsAcheteur);
			this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, Color.BLUE, " CCV : Liste de tous les produits pour lesquels il existe au moins 2 acheteurs "+produits2Acheteurs);
			if (produitsAcheteur.size()>0) {
				IProduit produit = produitsAcheteur.get((int)(Math.random()*produitsAcheteur.size()));
				this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, Color.BLUE, " CCV : Produit tire au sort = "+produit);
				List<IAcheteurContratCadre> acheteurs = superviseurVentesCC.getAcheteurs(produit);
				this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, Color.BLUE, " CCV : Les acheteurs de "+produit+" sont : "+acheteurs);
				if (acheteurs.size()>0) {
					IAcheteurContratCadre acheteur = acheteurs.get((int)(Math.random()*acheteurs.size()));
					if (acheteur!=this) { // on ne peut pas passer de contrat avec soi meme
						this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, Color.BLUE, " CCV : Acheteur tire au sort = "+acheteur);
						ExemplaireContratCadre contrat = superviseurVentesCC.demandeVendeur(acheteur, this, produit, this.propositionDuVendeur(produit), this.cryptogramme.intValue(), false);
						if (contrat!=null) {
							this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, Color.BLUE, " CCV : contrat signe = "+contrat);
						}
					}
				}
			}
		}
	}*/

	//next de Fouad :
	public void next() {
		super.next();

		// === Lancement si possible d'un contrat cadre
		if (this.superviseurVentesCC!=null) {
			// Tentative de lancer un contrat avec tous les acheteurs
			if (Filiere.LA_FILIERE.getEtape()==3) {
				List<IProduit> produits = new LinkedList<IProduit>();
				Chocolat cb = Chocolat.C_BQ;	
				produits.add(cb);
				for (ChocolatDeMarque c: Filiere.LA_FILIERE.getChocolatsProduits()) {
					if (c.getMarque().equals("Vccotioi")) {
						produits.add(c);
					}
				}
				for (IProduit cm : produits) {
					List<IAcheteurContratCadre> acheteurs = superviseurVentesCC.getAcheteurs(cm);
					this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, Color.BLACK, " CCV : tentative de vente de "+cm+" aupres de "+acheteurs);
					for (IAcheteurContratCadre acheteur : acheteurs) {
						if (!acheteur.equals(this)) {
							Echeancier echeancier = new Echeancier(Filiere.LA_FILIERE.getEtape()+1, 10, 100);
							this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, Color.BLUE, " CCV : tentative de vente aupres de "+acheteur);
							ExemplaireContratCadre contrat = superviseurVentesCC.demandeVendeur(acheteur, this, cm, echeancier, this.cryptogramme, false);
							if (contrat!=null) {
								this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, Color.BLUE, " CCV : contrat signe = "+contrat);
							}
						}
				}
			}
			}
		}
		}
	
	public boolean vend(IProduit produit) {
		boolean res=false;
		if (produit instanceof ChocolatDeMarque) {
			//this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, COLOR_LBLUE, "  CCV : vend("+produit+") --> "+(this.stockChocoMarque.keySet().contains(produit)?" dans keySet "+this.stockChocoMarque.get(produit):"pas dans keySet"));
			res=this.stockChocoMarque.keySet().contains(produit) && this.stockChocoMarque.get(produit)>200;
		} else if (produit instanceof Chocolat) {
			//this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, COLOR_LBLUE, "  CCV : vend("+produit+") --> "+(this.stockChoco.keySet().contains(produit)?" dans keySet "+this.stockChoco.get(produit):"pas dans keySet"));
			res=this.stockChoco.keySet().contains(produit) && this.stockChoco.get(produit)>200;
		}
		//this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, COLOR_LBLUE, "  CCV : vend("+produit+") --> "+res);
		return res;
	}
	
	
	/**
	 @author amine
	 */
	
	public Echeancier propositionDuVendeur(IProduit produit){
		double qtok=0;
		if (produit instanceof ChocolatDeMarque) {
			if (this.stockChocoMarque.keySet().contains(produit)) {
				qtok= this.stockChocoMarque.get(produit);
				if (qtok>200) {
				this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, COLOR_LBLUE, "  CCV : propovend --> nouvel echeancier="+new Echeancier(Filiere.LA_FILIERE.getEtape()+1, 15, qtok/15.0));
				return new Echeancier(Filiere.LA_FILIERE.getEtape()+1, 15, qtok/15.0);
	}
			}
			}
		else if (produit instanceof Chocolat) {
			if (this.stockChoco.keySet().contains(produit)) {
				qtok= this.stockChoco.get(produit);
				if (qtok>200) {
				this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, COLOR_LBLUE, "  CCV : propovend --> nouvel echeancier="+new Echeancier(Filiere.LA_FILIERE.getEtape()+1, 15, qtok/15.0));
				return new Echeancier(Filiere.LA_FILIERE.getEtape()+1, 15, qtok/15.0);
				}
	}
		}
		return new Echeancier(Filiere.LA_FILIERE.getEtape()+1, 15, 101);
	}
	

	public Echeancier contrePropositionDuVendeur(ExemplaireContratCadre contrat) {
		if (contrat.getTeteGondole()) {
			return null;
		}
		Object produit = contrat.getProduit();
		double qtok=0;
		if (produit instanceof ChocolatDeMarque) {
			if (((ChocolatDeMarque) produit).getMarque().equals("Vccotioi") && this.stockChocoMarque.keySet().contains(produit)) {
				qtok= this.stockChocoMarque.get(produit);
				if (qtok>200) {
					
					if (contrat.getEcheancier().getQuantiteTotale()<qtok && contrat.getEcheancier().getQuantiteTotale()>100 ){
						this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, COLOR_LBLUE, "  CCV : contrepropovend --> meme echeancier");
						return contrat.getEcheancier();
					} else {
						this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, COLOR_LBLUE, "  CCV : contrepropovend --> nouvel echeancier="+new Echeancier(contrat.getEcheancier().getStepDebut(), 15, (qtok*0.8)/15.0));
						return new Echeancier(contrat.getEcheancier().getStepDebut(), 15, qtok*0.8/15.0);
					}
			}
			}
			}
		 else if (produit instanceof Chocolat) {
				switch ((Chocolat)produit) {
				case C_HQ_BE   : return null;
				case C_MQ  : return null;
				case C_MQ_BE :return null;
				case C_BQ :
			if (this.stockChoco.keySet().contains(produit)) {
				qtok= this.stockChoco.get(produit);
				if (qtok>200) {
					if (contrat.getEcheancier().getQuantiteTotale()<qtok && contrat.getEcheancier().getQuantiteTotale()>100) {
						this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, COLOR_LBLUE, "  CCV : contrepropovend --> meme echeancier");
						return contrat.getEcheancier();
					} else {
						this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, COLOR_LBLUE, "  CCV : contrepropovend --> nouvel echeancier="+new Echeancier(contrat.getEcheancier().getStepDebut(), 15, (qtok*0.8)/15.0));
						return new Echeancier(contrat.getEcheancier().getStepDebut(), 15, qtok*0.8/15.0);
					}
			}
		}
				
		}
		
		
}
		this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, COLOR_LBLUE, "  CCV : contrepropovend --> return null");
		return null;
	}


	
	/**
	 * @author fouad
	 *
	 */
	
	public double propositionPrix(ExemplaireContratCadre contrat) {
		double prix=0.0;
		Object produit = contrat.getProduit();
		if (produit instanceof ChocolatDeMarque) {
			produit = ((ChocolatDeMarque)produit).getChocolat();
		}
		if (produit instanceof Chocolat) {
			switch ((Chocolat)produit) {
			case C_HQ_BE   : prix= 11.55;break;
			case C_BQ      : prix=  5.25;break;
			}
		}
		this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, COLOR_LBLUE, "  CCV : propose prix de "+prix+" pour "+produit);
		return prix;
	}

	public double contrePropositionPrixVendeur(ExemplaireContratCadre contrat) {
		double prixInit=contrat.getListePrix().get(0);
		double prix = contrat.getPrix();
		if (prix>0.0 && (prixInit-prix)/prixInit<=0.049) {
			return prix;
		} else {
			return prixInit;
		}
	}

	public Lot livrer(IProduit produit, double quantite, ExemplaireContratCadre contrat) {
		double stock=0.0;
		double livre=0.0;
		Lot lot = null;
		if (produit instanceof ChocolatDeMarque) {
			if (this.stockChocoMarque.keySet().contains(produit)) {
				stock= this.stockChocoMarque.get(produit);
				livre = Math.min(stock, quantite);
				if (quantite>stock) {
					this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, COLOR_LBLUE, "  Stock insuffisant pour satisfaire toute la demande");
				}
				if (livre>0) {
					this.stockChocoMarque.put((ChocolatDeMarque)produit, this.stockChocoMarque.get(produit)-livre);
				}
				lot=new Lot((ChocolatDeMarque)produit);
			}
		} else if (produit instanceof Chocolat) {
			if (this.stockChoco.keySet().contains(produit)) {
				stock= this.stockChoco.get(produit);
				livre = Math.min(stock, quantite);
				if (quantite>stock) {
					this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, COLOR_LBLUE, "  Stock insuffisant pour satisfaire toute la demande");

				}
				if (livre>0) {
					this.stockChoco.put((Chocolat)produit, this.stockChoco.get(produit)-livre);
				}
				lot=new Lot((Chocolat)produit);
			}
		} 
		this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, COLOR_LBLUE, "  CCV : doit livrer "+quantite+" de "+produit+" --> livre "+livre);
		if (livre>0) {
		lot.ajouter(Filiere.LA_FILIERE.getEtape(), livre);}
		return lot;
	}
	

	/*public void notificationNouveauContratCadre(ExemplaireContratCadre contrat) {
		this.journal_CC_DISTRI.ajouter(COLOR_LLGRAY, Color.BLUE, "  CCV : nouveau cc conclu "+contrat);
	}*/
}

