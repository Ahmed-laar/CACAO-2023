package abstraction.eq6Transformateur3;

import abstraction.eqXRomu.general.Variable;
import abstraction.eqXRomu.produits.Feve;

public class Transformateur3Transformation extends Transformateur3Stocks {

	/** Maxime Bedu*/
	
/** processus de transformation : 
	           unit� de temps de transformation : diff�rent selon les f�ves
	           prends dans le stock et remets dans le stock post-transfo,
	  pareil diff�rents types de stocks initiaux et finaux en fonction du type de f�ve
	           implementer IChocolatdemarque ou autre truc de Romu 
	           Type de produit � r�aliser (dans v1 seulement plaque)
	           Quantit� de f�ves � transformer dans les fonctions 
	           
	           pour info temps de transfo : 
	           
	           
	*/
	
	public void transformationChoco(Feve f) {
		if (f instanceof F_BQ) {
			Variable pourcentageTransfo = this.getPourcentageCacaoBG();
			stockFeve.replace(F_BQ, )
		}
		
	}
	
}
