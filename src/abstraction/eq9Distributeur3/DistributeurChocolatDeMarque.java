package abstraction.eq9Distributeur3;


import java.util.HashMap;
import java.util.Map.Entry;




import abstraction.eqXRomu.clients.ClientFinal;
import abstraction.eqXRomu.filiere.IDistributeurChocolatDeMarque;
import abstraction.eqXRomu.produits.ChocolatDeMarque;

public class DistributeurChocolatDeMarque extends Distributeur3Acteur implements IDistributeurChocolatDeMarque {
	
	private double capaciteDeVente;
	private HashMap<ChocolatDeMarque, Double> prix;

	
	

	public DistributeurChocolatDeMarque(ChocolatDeMarque[] chocos, double[] stocks, double capaciteDeVente, double[] prix, String[] marques) {

		super(chocos, stocks);
		this.capaciteDeVente = capaciteDeVente;
		this.prix = new HashMap<ChocolatDeMarque, Double> ();
	}
	//william
	@Override
	public double prix(ChocolatDeMarque choco) {
		return 0.0;
	}
	
	//baptiste
	public HashMap<ChocolatDeMarque, Double> quantiteTotale() {
		HashMap<ChocolatDeMarque, Double> qtVente = new HashMap<ChocolatDeMarque, Double> ();
		HashMap<ChocolatDeMarque, Double> Stock = stock.getQteStock();
		
		for (Entry<ChocolatDeMarque, Double> chocolat : Stock.entrySet()) {
			qtVente.put(chocolat.getKey(), (double) 0);
		}
		double quantiteEnVente = 0;
		double quantiteEnVente_0 = 0;
		boolean rupture = true;
		
		while (quantiteEnVente < this.capaciteDeVente && rupture) {
			for (Entry<ChocolatDeMarque, Double> chocolat : Stock.entrySet()) {
				qtVente.replace(chocolat.getKey(), Math.min(Math.min(this.capaciteDeVente/3, chocolat.getValue()), this.capaciteDeVente - quantiteEnVente));
			}
			if (quantiteEnVente == quantiteEnVente_0) {
				rupture = false;
			} else {
				quantiteEnVente_0 = quantiteEnVente;
			}
		}
		return qtVente;

	}

	//baptiste
	public double quantiteEnVente(ChocolatDeMarque choco, int crypto) {

		if (crypto != this.cryptogramme) {
			journal.ajouter("On essaie de me pirater (RayonVide)");
			return 0;
		} else {
			HashMap<ChocolatDeMarque, Double> qtVente = this.quantiteTotale();
			return qtVente.get(choco);

		}
	}
	
	//baptiste 
	public double quantiteEnVenteTG(ChocolatDeMarque choco, int crypto) {

		if (crypto!=this.cryptogramme) {
			journal.ajouter("Quelqu'un essaye de me pirater !");
			return 0.0;
		} else {
			int pos= (chocolats.indexOf(choco));
			if (pos<0) {
				return 0.0;
			} else {
				HashMap<ChocolatDeMarque, Double> qtVente = this.quantiteTotale();
				return qtVente.get(choco)/10.0;
			}

		}
	}

	@Override
	//william
	public void vendre(ClientFinal client, ChocolatDeMarque choco, double quantite, double montant, int crypto) {

		if (crypto != this.cryptogramme) {
			journal.ajouter("On essaie de me pirater (RayonVide)");
		} else {
			journal.ajouter("On a plus de " + choco.getNom());
			this.stock.ajoutQte(choco, -(montant/this.prix(choco)));
		}
		
		

	}

	
	public void notificationRayonVide(ChocolatDeMarque choco) {
		journal.ajouter(" Aie... j'aurais du mettre davantage de "+choco.getNom()+" en vente");
	}
	@Override
	public void notificationRayonVide(ChocolatDeMarque choco, int crypto) {

		if (crypto != this.cryptogramme) {
			journal.ajouter("On essaie de me pirater (RayonVide)");
		} else {
			journal.ajouter(" Aie... j'aurais du mettre davantage de "+choco.getNom()+" en vente");
		}
			

		
	}

}
