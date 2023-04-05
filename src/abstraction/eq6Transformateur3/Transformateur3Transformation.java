package abstraction.eq6Transformateur3;

import abstraction.eqXRomu.general.Variable;
import abstraction.eqXRomu.produits.Feve;

public class Transformateur3Transformation extends Transformateur3Stocks {

	/** Maxime Bedu*/
	
/** processus de transformation : 
	           unit� de temps de transformation : diff�rent selon les f�ves 
	           prends dans le stock et remets dans le stock post-transfo, (OK)
	  pareil diff�rents types de stocks initiaux et finaux en fonction du type de f�ve (OK)
	           implementer IChocolatdemarque ou autre truc de Romu (� voir)
	           Type de produit � r�aliser (dans v1 seulement plaque)
	           Quantit� de f�ves � transformer dans les fonctions 
	           
	           pour info temps de transfo : A d�terminer, pour faire liste par produit de step avant qu'ils
	           ne soient pr�ts
	           
	           Fonction besoin, en utilisant la fonction demande pour voir si il y a un manque ici, et pour 
	           pouvoir informer qu'il faut augmenter les stocks pour r�pondre � la demande
	           -peut aussi permettre de jouer sur "qte", la quantit� de transformation qu'on veut faire
	           � chaque step
	           
	           
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
					}
			}
	}
}

protected double BesoinStep(int Step, Feve f) {
