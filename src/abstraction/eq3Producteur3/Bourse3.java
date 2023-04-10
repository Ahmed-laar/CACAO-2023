package abstraction.eq3Producteur3;

import java.util.Set;

import abstraction.eqXRomu.bourseCacao.IVendeurBourse;
import abstraction.eqXRomu.filiere.Filiere;
import abstraction.eqXRomu.produits.Feve;
import abstraction.eqXRomu.produits.Lot;

/**
 * @author Gabriel
 */
public class Bourse3 extends Producteur3 implements IVendeurBourse {
	
	/**
	 * @author Gabriel
	 */
	public double offre(Feve f, double cours) {
		//== fonctionne ?
		int quantiteM =0;
		Lot lotM = super.getStock().getStock().get(Feve.F_MQ_BE);
		Set<Integer> KeyListM = lotM.getQuantites().keySet();
			for(Integer key : KeyListM) {
				//Les feves M ont depasse les 6 mois donc il faut les vendre
				if(Filiere.LA_FILIERE.getEtape() - key > 12) {
					quantiteM += lotM.getQuantites().get(key);
				}
			
			
		}
		return quantiteM;
	}

	
	public Lot notificationVente(Feve f, double quantiteEnT, double coursEnEuroParT) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void notificationBlackList(int dureeEnStep) {
		// TODO Auto-generated method stub
		
	}

}
