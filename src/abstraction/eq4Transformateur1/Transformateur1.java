package abstraction.eq4Transformateur1;

import java.util.LinkedList;
import java.util.List;

import abstraction.eqXRomu.filiere.Filiere;
import abstraction.eqXRomu.filiere.IFabricantChocolatDeMarque;
import abstraction.eqXRomu.produits.Chocolat;
import abstraction.eqXRomu.produits.ChocolatDeMarque;
import abstraction.eqXRomu.produits.Feve;
import abstraction.eqXRomu.produits.Gamme;


public class Transformateur1 extends Transformateur1Acteur implements IFabricantChocolatDeMarque{
	
	private List<ChocolatDeMarque>chocosProduits;

	public Transformateur1() {
		super();
		this.chocosProduits = new LinkedList<ChocolatDeMarque>();
	}

	public List<ChocolatDeMarque> getChocolatsProduits() {
		if (this.chocosProduits.size()==0) {
				Chocolat c1 = Chocolat.C_MQ;
				Chocolat c2 = Chocolat.C_HQ_BE;
				this.chocosProduits.add(new ChocolatDeMarque(c1, "Yocttoootoa", 55, 0));
				this.chocosProduits.add(new ChocolatDeMarque(c2, "Vccotioi", 90, 10));
		}
	//System.out.println(	Filiere.LA_FILIERE.getParametre("pourcentage min cacao BQ").getValeur());
		
		return this.chocosProduits;
	}

}
	
