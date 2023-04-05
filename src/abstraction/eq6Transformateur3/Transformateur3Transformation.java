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
	
	public void transformationChoco(Feve f, double qte) {
		if (f instanceof F_BQ) {
			double pourcentageTransfo = this.getPourcentageCacaoBG().getValeur();
			double a=stockFeve.get(F_BQ);
			stockFeve.replace(F_BQ, a-(pourcentageTransfo*qte));
			double b=stockChocolat.get(C_BQ);
			stockChocolat.replace(C_BQ,b+qte);
			} else {
				if (f instanceof F_MQ) {
					double pourcentageTransfo = this.getPourcentageCacaoBG().getValeur();
					double a=stockFeve.get(F_MQ);
					stockFeve.replace(F_MQ, a-(pourcentageTransfo*qte));
					double b=stockChocolat.get(C_MQ);
					stockChocolat.replace(C_MQ,b+qte);
					} else {
						if (f instanceof F_MQ_BE) {
							double pourcentageTransfo = this.getPourcentageCacaoBG().getValeur();
							double a=stockFeve.get(F_MQ_BE);
							stockFeve.replace(F_MQ_BE, a-(pourcentageTransfo*qte));
							double b=stockChocolat.get(C_MQ_BE);
							stockChocolat.replace(C_MQ_BE,b+qte);
							} else {
								if (f instanceof F_HQ_BE) {
									double pourcentageTransfo = this.getPourcentageCacaoBG().getValeur();
									double a=stockFeve.get(F_HQ_BE);
									stockFeve.replace(F_HQ_BE, a-(pourcentageTransfo*qte));
									double b=stockChocolat.get(C_HQ_BE);
									stockChocolat.replace(C_HQ_BE,b+qte);
							}
	
}
