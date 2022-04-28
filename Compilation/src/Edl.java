import java.io.*;
 //TODO : Renseigner le champs auteur : Nom1_Prenom1_Nom2_Prenom2_Nom3_Prenom3
 /**
 * 
 * @author XXX, YYY, ZZZ
 * @version 2022
 *
 */


public class Edl {

	// nombre max de modules, taille max d'un code objet d'une unite
	static final int MAXMOD = 5, MAXOBJ = 1000;
	// nombres max de references externes (REF) et de points d'entree (DEF)
	// pour une unite
	private static final int MAXREF = 10, MAXDEF = 10;

	// typologie des erreurs
	private static final int FATALE = 0, NONFATALE = 1;

	// valeurs possibles du vecteur de translation
	private static final int TRANSDON=1,TRANSCODE=2,REFEXT=3;

	// table de tous les descripteurs concernes par l'edl
	static Descripteur[] tabDesc = new Descripteur[MAXMOD + 1];

	//TODO : declarations de variables A COMPLETER SI BESOIN
	static int ipo, nMod, nbErr;
	static String nomProg;
	
	static class EltDef {
		// nomProc = nom de la procedure definie en DEF
		public String nomProc;
		// adPo = adresse de debut de code de cette procedure
		// nbParam =  nombre de parametres de cette procedure
		public int adPo, nbParam;

		public EltDef(String nomProc, int adPo, int nbParam) {
			this.nomProc = nomProc;
			this.adPo = adPo;
			this.nbParam = nbParam;
		}
	}


	// utilitaire de traitement des erreurs
	// ------------------------------------
	static void erreur(int te, String m) {
		System.out.println(m);
		if (te == FATALE) {
			System.out.println("ABANDON DE L'EDITION DE LIENS");
			System.exit(1);
		}
		nbErr = nbErr + 1;
	}

	// utilitaire de remplissage de la table des descripteurs tabDesc
	// --------------------------------------------------------------
	static void lireDescripteurs() {
		String s;
		System.out.println("les noms doivent etre fournis sans suffixe");
		System.out.print("nom du programme : ");
		s = Lecture.lireString();
		tabDesc[0] = new Descripteur();
		tabDesc[0].lireDesc(s);
		if (!tabDesc[0].getUnite().equals("programme"))
			erreur(FATALE, "programme attendu");
		nomProg = s;

		nMod = 0;
		while (!s.equals("") && nMod < MAXMOD) {
			System.out.print("nom de module " + (nMod + 1)
					+ " (RC si termine) ");
			s = Lecture.lireString();
			if (!s.equals("")) {
				nMod = nMod + 1;
				tabDesc[nMod] = new Descripteur();
				tabDesc[nMod].lireDesc(s);

				if (!tabDesc[nMod].getUnite().equals("module"))
					erreur(FATALE, "module attendu");
			}
		}
	}


	static void constMap() {
		// f2 = fichier executable .map construit
		OutputStream f2 = Ecriture.ouvrir(nomProg + ".map");
		if (f2 == null)
			erreur(FATALE, "creation du fichier " + nomProg
					+ ".map impossible");
		// pour construire le code concatene de toutes les unit�s
		int[] po = new int[(nMod + 1) * MAXOBJ + 1];
		
		//TODO : ... A COMPLETER ...
		// 
		//

		Ecriture.fermer(f2);

		// creation du fichier en mnemonique correspondant
		Mnemo.creerFichier(ipo, po, nomProg + ".ima");
	}

	public static void main(String argv[]) {
		System.out.println("EDITEUR DE LIENS / PROJET LICENCE");
		System.out.println("---------------------------------");
		System.out.println("");
		nbErr = 0;

		// Phase 1 de l'edition de liens
		// -----------------------------
		lireDescripteurs();		//TODO : lecture des descripteurs a completer si besoin

		int[] transDon = new int[nMod+1];
		int[] transCode = new int[nMod+1];
		
		transDon[0] = 0;
		transCode[0] = 0;

		for (int i = 1; i <= nMod; i++) {
			transDon[i] = transDon[i - 1] + tabDesc[i - 1].getTailleGlobaux();
			transCode[i] = transCode[i - 1] + tabDesc[i - 1].getTailleCode();
		}
		
		EltDef[] DicoDef = new EltDef[MAXDEF];
		int nbDicoDef = 0;
		
		for (int i = 0; i <= nMod; i++) {
			for (int j = 1; j <= tabDesc[i].getNbDef(); j++) {
				for (int k = 0; k < nbDicoDef; k++) {
					if(DicoDef[k].nomProc == tabDesc[i].getDefNomProc(j)) {
						erreur(NONFATALE, "fonction " + DicoDef[k].nomProc + " defini plusieurs fois");
					}
				}
				DicoDef[nbDicoDef] = new EltDef( tabDesc[i].getDefNomProc(j), 
												 tabDesc[i].getDefAdPo(j) + transCode[i], 
												 tabDesc[i].getDefNbParam(j)
											   );
				nbDicoDef++;
			}
		}
		
		int[][] adFinale = new int[5][10];
		
		for (int i = 0; i <= nMod; i++) {
			for (int j = 1; j <= tabDesc[i].getNbRef(); j++) {
				String tmp = tabDesc[i].getRefNomProc(j);
				boolean isDefined = false;
				for (int k = 0; k < nbDicoDef; k++) {
					if(DicoDef[k].nomProc.equals(tmp)) {
						isDefined = true;
						adFinale[i][j] = DicoDef[k].adPo;
						break;
					}
				}
				if(!isDefined) {
					erreur(NONFATALE, "fonction " + tmp + " defini mais non reference");
				}
			}
		}

		// Phase 2 de l'edition de liens
		// -----------------------------
		constMap();				//TODO : ... A COMPLETER ...
		System.out.println("Edition de liens terminee");
	}
}