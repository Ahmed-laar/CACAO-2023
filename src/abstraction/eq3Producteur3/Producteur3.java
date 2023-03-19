package abstraction.eq3Producteur3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import abstraction.eqXRomu.produits.Lot;

public class Producteur3 extends Producteur3Acteur  {
	/*
	 * ChampsH est un dictionnaire qui contient les champs Haut de Gamme
	 * On associe � un ensemble d'hectars un int qui correspond � leur step de plantaison 
	 *
	 *private HashMap<Integer,String> ChampsH;//UTILE ?
	 *
	 * ChampsM est un dictionnaire qui contient les champs Moyen de Gamme
	 * On associe � un ensemble d'hectars un int qui correspond � leur step de plantaison 
	 *
	 *private HashMap<Integer,String> ChampsM;//UTILE ?
	 *
	 * On cr�e un dictionnaire qui associe � la clef H ou M le dico ChampsM ou ChapmsH
	 */
	private HashMap<String,HashMap> Champs;
	
	/*
	 * Je n'ai pas trouve le type du champs donc j'ai choisit String. A CHANGER
	 * Il faudra aussi penser � se mettre d'accord sur les tailles des champs initiaux.
	 */
	public Producteur3() {
		super();
		HashMap<Integer,String> ChampsInitialeH = new HashMap<Integer,String>();
		HashMap<Integer,String> ChampsInitialeM = new HashMap<Integer,String>();
		HashMap<String,HashMap> ChampsInitiale = new HashMap<String,HashMap>();
		ChampsInitiale.put( "H",ChampsInitialeH);
		ChampsInitiale.put( "M",ChampsInitialeM);
		this.Champs=ChampsInitiale;	
	}
	public Producteur3(HashMap<String,HashMap> m) {
		this.Champs=m;
	}
	
	public LinkedList<Lot> Harvest(int CurrentStep, HashMap<String,HashMap> Fields) {
		if(Champs==null) {
			throw new IllegalArgumentException("HashMap<String,HashMap> Fields ==null --> Pb");
		}
		/*
		 * R�colte des f�ves moyennes gammes
		 */
		HashMap<Integer,String> FieldM = Fields.get("M");
		//On r�cup�re la liste des clefs de FieldM
		Set<Integer> KeysM = FieldM.keySet();
		//On cr�e une liste qui contient les clefs de tous les champs M qui doivent �tre r�colt�s
		LinkedList<Integer> HarvestKeysM = new LinkedList<Integer>();
		//On regarde si un des champs de FieldM doit �tre r�colt� sachant qu'un champ M doit �tre r�colt� tous les 6 mois
		for(Integer key : KeysM) {
			/*DateActuelle-DatePlantaison=DureeGestation. Si DureeGestation est divisible par 12(nombre de semaines
			*dans 6 mois), alors le champ M doit �tre r�colt�
			**/
			if((CurrentStep - key)%12==0) {
				HarvestKeysM.add(key);
			}
		}
		//Lot lotH = HarvestM(HarvestKeysM,FieldM);
		/*
		 * R�colte des f�ves hautes gammes
		 */
		HashMap<Integer,String> FieldH = Fields.get("H");
		//On r�cup�re la liste des clefs de FieldH
		Set<Integer> KeysH = FieldH.keySet();
		//On cr�e une liste qui contient les clefs de tous les champs H qui doivent �tre r�colt�s
		LinkedList<Integer> HarvestKeysH = new LinkedList<Integer>();
		//On regarde si un des champs de FieldH doit �tre r�colt� sachant qu'un champs H doit �tre r�colt� tous les 7 mois
		for(Integer key : KeysM) {
			/*DateActuelle-DatePlantaison=DureeGestation. Si DureeGestation est divisible par 14(nombre de semaines
			*dans 7 mois), alors le champ H doit �tre r�colt�
			**/
			if((CurrentStep - key)%14==0) {
				HarvestKeysH.add(key);
			}
		}
		//PARTIE R�COLTE-->Lot
		return null;
	}
}
