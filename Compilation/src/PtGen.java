
/*********************************************************************************
 * VARIABLES ET METHODES FOURNIES PAR LA CLASSE UtilLex (cf libClass_Projet)     *
 *       complement à l'ANALYSEUR LEXICAL produit par ANTLR                      *
 *                                                                               *
 *                                                                               *
 *   nom du programme compile, sans suffixe : String UtilLex.nomSource           *
 *   ------------------------                                                    *
 *                                                                               *
 *   attributs lexicaux (selon items figurant dans la grammaire):                *
 *   ------------------                                                          *
 *     int UtilLex.valEnt = valeur du dernier nombre entier lu (item nbentier)   *
 *     int UtilLex.numIdCourant = code du dernier identificateur lu (item ident) *
 *                                                                               *
 *                                                                               *
 *   methodes utiles :                                                           *
 *   ---------------                                                             *
 *     void UtilLex.messErr(String m)  affichage de m et arret compilation       *
 *     String UtilLex.chaineIdent(int numId) delivre l'ident de codage numId     *
 *     void afftabSymb()  affiche la table des symboles                          *
 *********************************************************************************/


import java.io.*;
import java.util.Arrays;

/**
 * classe de mise en oeuvre du compilateur
 * =======================================
 * (verifications semantiques + production du code objet)
 * 
 * @author Girard, Masson, Perraudeau
 *
 */

public class PtGen {
    

    // constantes manipulees par le compilateur
    // ----------------------------------------

	private static final int 
	
	// taille max de la table des symboles
	MAXSYMB=300,

	// codes MAPILE :
	RESERVER=1,EMPILER=2,CONTENUG=3,AFFECTERG=4,OU=5,ET=6,NON=7,INF=8,
	INFEG=9,SUP=10,SUPEG=11,EG=12,DIFF=13,ADD=14,SOUS=15,MUL=16,DIV=17,
	BSIFAUX=18,BINCOND=19,LIRENT=20,LIREBOOL=21,ECRENT=22,ECRBOOL=23,
	ARRET=24,EMPILERADG=25,EMPILERADL=26,CONTENUL=27,AFFECTERL=28,
	APPEL=29,RETOUR=30,

	// codes des valeurs vrai/faux
	VRAI=1, FAUX=0,

    // types permis :
	ENT=1,BOOL=2,NEUTRE=3,

	// categories possibles des identificateurs :
	CONSTANTE=1,VARGLOBALE=2,VARLOCALE=3,PARAMFIXE=4,PARAMMOD=5,PROC=6,
	DEF=7,REF=8,PRIVEE=9,

    //valeurs possible du vecteur de translation 
    TRANSDON=1,TRANSCODE=2,REFEXT=3;


    // utilitaires de controle de type
    // -------------------------------
    /**
     * verification du type entier de l'expression en cours de compilation 
     * (arret de la compilation sinon)
     */
	private static void verifEnt() {
		if (tCour != ENT)
			UtilLex.messErr("expression entiere attendue");
	}
	/**DIV
	 * verification du type booleen de l'expression en cours de compilation 
	 * (arret de la compilation sinon)
	 */
	private static void verifBool() {
		if (tCour != BOOL)
			UtilLex.messErr("expression booleenne attendue");
	}

    // pile pour gerer les chaines de reprise et les branchements en avant
    // -------------------------------------------------------------------

    private static TPileRep pileRep;  


    // production du code objet en memoire
    // -----------------------------------

    private static ProgObjet po;
    
    
    // COMPILATION SEPAREE 
    // -------------------
    //
    /** 
     * modification du vecteur de translation associe au code produit 
     * + incrementation attribut nbTransExt du descripteur
     *  NB: effectue uniquement si c'est une reference externe ou si on compile un module
     * @param valeur : TRANSDON, TRANSCODE ou REFEXT
     */
    private static void modifVecteurTrans(int valeur) {
		if (valeur == REFEXT || desc.getUnite().equals("module")) {
			po.vecteurTrans(valeur);
			desc.incrNbTansExt();
		}
	}    
    // descripteur associe a un programme objet (compilation separee)
    private static Descripteur desc;

     
    // autres variables fournies
    // -------------------------
    
 // MERCI de renseigner ici un nom pour le trinome, constitue EXCLUSIVEMENT DE LETTRES
    public static String trinome="Navarri_Bastien__Diallo_Sadou__Rio_Yohann"; 
    
    private static int tCour; // type de l'expression compilee
    private static int vCour; // sert uniquement lors de la compilation d'une valeur (entiere ou boolenne)
  
   
    // TABLE DES SYMBOLES
    // ------------------
    //
    private static EltTabSymb[] tabSymb = new EltTabSymb[MAXSYMB + 1];
    
    // it = indice de remplissage de tabSymb
    // bc = bloc courant (=1 si le bloc courant est le programme principal)
	private static int it, bc;

	private static int iterateurDesVariables;
	private static int iterateurDesProc;
	private static int idVarAffectation;
	private static int nbParamAppel;
	private static int idDef;
	
	/** 
	 * utilitaire de recherche de l'ident courant (ayant pour code UtilLex.numIdCourant) dans tabSymb
	 * 
	 * @param borneInf : recherche de l'indice it vers borneInf (=1 si recherche dans tout tabSymb)
	 * @return : indice de l'ident courant (de code UtilLex.numIdCourant) dans tabSymb (O si absence)
	 */
	private static int presentIdent(int borneInf) {
		int i = it;
		while (i >= borneInf && tabSymb[i].code != UtilLex.numIdCourant)
			i--;
		if (i >= borneInf)
			return i;
		else
			return 0;
	}

	/**
	 * utilitaire de placement des caracteristiques d'un nouvel ident dans tabSymb
	 * 
	 * @param code : UtilLex.numIdCourant de l'ident
	 * @param cat : categorie de l'ident parmi CONSTANTE, VARGLOBALE, PROC, etc.
	 * @param type : ENT, BOOL ou NEUTRE
	 * @param info : valeur pour une constante, ad d'exécution pour une variable, etc.
	 */
	private static void placeIdent(int code, int cat, int type, int info) {
		if (it == MAXSYMB)
			UtilLex.messErr("debordement de la table des symboles");
		it = it + 1;
		tabSymb[it] = new EltTabSymb(code, cat, type, info);
	}

	/**
	 *  utilitaire d'affichage de la table des symboles
	 */
	private static void afftabSymb() { 
		System.out.println("       code           categorie      type    info");
		System.out.println("      |--------------|--------------|-------|----");
		for (int i = 1; i <= it; i++) {
			if (i == bc) {
				System.out.print("bc=");
				Ecriture.ecrireInt(i, 3);
			} else if (i == it) {
				System.out.print("it=");
				Ecriture.ecrireInt(i, 3);
			} else
				Ecriture.ecrireInt(i, 6);
			if (tabSymb[i] == null)
				System.out.println(" reference NULL");
			else
				System.out.println(" " + tabSymb[i]);
		}
		System.out.println();
	}
    

	/**
	 *  initialisations A COMPLETER SI BESOIN
	 *  -------------------------------------
	 */
	public static void initialisations() {
	
		// indices de gestion de la table des symboles
		it = 0;
		bc = 1;
		
		iterateurDesVariables = 0;
		iterateurDesProc = 0;
		nbParamAppel = 0;
		idDef = 0;
		
		// pile des reprises pour compilation des branchements en avant
		pileRep = new TPileRep(); 
		// programme objet = code Mapile de l'unite en cours de compilation
		po = new ProgObjet();
		// COMPILATION SEPAREE: desripteur de l'unite en cours de compilation
		desc = new Descripteur();
		
		// initialisation necessaire aux attributs lexicaux
		UtilLex.initialisation();
	
		// initialisation du type de l'expression courante
		tCour = NEUTRE;

	} // initialisations

	/**
	 *  code des points de generation A COMPLETER
	 *  -----------------------------------------
	 * @param numGen : numero du point de generation a executer
	 */
	
	
	public static void pt(int numGen) {
		int idIdent;
		int ipotmp;
		int ipoprec;
		switch (numGen) {
			case 0:
				initialisations();
				break;
			// Constantes
			case 1: 
				if(presentIdent(1) != 0) {
					UtilLex.messErr("Identifiant deja utilise");
				}
				break; 
			case 2: 
				placeIdent(UtilLex.numIdCourant, CONSTANTE, tCour, vCour);
				break;
			// VARIABLES
			case 3: 
				if(presentIdent(1) != 0) {
					UtilLex.messErr("Identifiant deja utilise");
				} else {
					if(bc != 1) {
						placeIdent(UtilLex.numIdCourant, VARLOCALE, tCour, iterateurDesProc);
						iterateurDesProc++;
					} else {
						placeIdent(UtilLex.numIdCourant, VARGLOBALE, tCour, iterateurDesVariables);
					}
				}
				iterateurDesVariables++;
				afftabSymb();
				break;
			case 27: 
				if(iterateurDesVariables != 0 || desc.getUnite() == "programme") {
					po.produire(RESERVER);
					po.produire(iterateurDesVariables);
				}
				desc.setTailleGlobaux(iterateurDesVariables);
				break;
			// TYPES
			case 4: 
				tCour = ENT;
				break;
			case 5: 
				tCour = BOOL;
				break;
			// VALEUR
			case 6: 
				vCour = UtilLex.valEnt;
				tCour = ENT;
				break;
			case 7: 
				vCour = -1*UtilLex.valEnt;
				tCour = ENT;
				break;
			case 8: 
				vCour = VRAI;
				tCour = BOOL;
				break;
			case 9: 
				vCour = FAUX;
				tCour = BOOL;
				break;
			// PRIMAIRE
			case 10: 
				idIdent = presentIdent(1);
				if(idIdent == 0) {
					UtilLex.messErr("Identifiant inconnu");
				}
				tCour = tabSymb[idIdent].type;
				if(tabSymb[idIdent].categorie == CONSTANTE) {
					po.produire(EMPILER);
					po.produire(tabSymb[idIdent].info);
				} else if(tabSymb[idIdent].categorie == VARGLOBALE) {
					po.produire(CONTENUG);
					po.produire(tabSymb[idIdent].info);
					modifVecteurTrans(TRANSDON);
				}  else if(tabSymb[idIdent].categorie == PARAMFIXE || tabSymb[idIdent].categorie == VARLOCALE) {
					po.produire(CONTENUL);
					po.produire(tabSymb[idIdent].info);
					po.produire(0);
				}  else if(tabSymb[idIdent].categorie == PARAMMOD) {
					po.produire(CONTENUL);
					po.produire(tabSymb[idIdent].info);
					po.produire(1);
				} 
				break;
			case 11: 
				po.produire(EMPILER);
				po.produire(vCour);
				break;
			// EXP5
			case 12: 
				verifEnt();
				break;
			case 13: 
				po.produire(MUL);
				tCour = ENT;
				break;
			case 14: 
				po.produire(DIV);
				tCour = ENT;
				break;
			// EXP4
			case 15: 
				po.produire(ADD);
				tCour = ENT;
				break;
			case 16: 
				po.produire(SOUS);
				tCour = ENT;
				break;
			// EXP3
			case 17: 
				po.produire(EG);
				tCour = BOOL;
				break;
			case 18: 
				po.produire(DIFF);
				tCour = BOOL;
				break;
			case 19: 
				po.produire(SUP);
				tCour = BOOL;
				break;
			case 20: 
				po.produire(SUPEG);
				tCour = BOOL;
				break;
			case 21: 
				po.produire(INF);
				tCour = BOOL;
				break;
			case 22: 
				po.produire(INFEG);
				tCour = BOOL;
				break;
			//EXP2
			case 23: 
				verifBool();
				break;
			case 24: 
				po.produire(NON);
				tCour = BOOL;
				break;
			//EXP1
			case 25: 
				po.produire(ET);
				tCour = BOOL;
				break;
			//EXPRESSION
			case 26: 
				po.produire(OU);
				tCour = BOOL;
				break;
			//LECTURE
			case 28: 
				idIdent = presentIdent(1);
				if(idIdent == 0) {
					UtilLex.messErr("Identifiant inconnu");
				}
				if(tabSymb[idIdent].categorie == CONSTANTE || tabSymb[idIdent].categorie == PARAMFIXE){
					UtilLex.messErr("On ne peut pas modifier une constante");
				}
				if(tabSymb[idIdent].type == BOOL) {
					po.produire(LIREBOOL);
				} else if(tabSymb[idIdent].type == ENT) {
					po.produire(LIRENT);
				}
				if(tabSymb[idIdent].categorie == VARGLOBALE) {
					po.produire(AFFECTERG);
					po.produire(tabSymb[idIdent].info);
					modifVecteurTrans(TRANSDON);
				} else if (tabSymb[idIdent].categorie == VARLOCALE) {
					po.produire(AFFECTERL);
					po.produire(tabSymb[idIdent].info);
					po.produire(0);
				} else if (tabSymb[idIdent].categorie == PARAMMOD) {
					po.produire(AFFECTERL);
					po.produire(tabSymb[idIdent].info);
					po.produire(1);
				}
				break;
			//ECRITURE
			case 29: 
				if(tCour == BOOL) {
					po.produire(ECRBOOL);
				} else if(tCour == ENT) {
					po.produire(ECRENT);
				}
				break;
			//AFFECTATION
			case 30: 
				idIdent = presentIdent(1);
				if(idIdent == 0) {
					UtilLex.messErr("Identifiant inconnu");
				}
				if(tabSymb[idIdent].categorie == CONSTANTE || tabSymb[idIdent].categorie == PARAMFIXE) {
					UtilLex.messErr("Impossible d'affecter une constante");
				}
				idVarAffectation = idIdent;
				break;
			case 31: 
				if(tabSymb[idVarAffectation].type != tCour) {
					UtilLex.messErr("type incompatible avec le type de la variable à affecter");
				}
				if(tabSymb[idVarAffectation].categorie == VARGLOBALE) {
					po.produire(AFFECTERG);
					po.produire(tabSymb[idVarAffectation].info);
				} else if (tabSymb[idVarAffectation].categorie == VARLOCALE) {
					po.produire(AFFECTERL);
					po.produire(tabSymb[idVarAffectation].info);
					po.produire(0);
				} else if (tabSymb[idVarAffectation].categorie == PARAMMOD) {
					po.produire(AFFECTERL);
					po.produire(tabSymb[idVarAffectation].info);
					po.produire(1);
				}
				break;
			//inssi - then
			case 33: 
				po.produire(BSIFAUX);
				po.produire(-1);
				modifVecteurTrans(TRANSCODE);
				pileRep.empiler(po.getIpo());
				break;
			//inssi - sinon
			case 34: 
				po.produire(BINCOND);
				po.produire(-1);
				modifVecteurTrans(TRANSCODE);
				po.modifier(pileRep.depiler(), po.getIpo() + 1);
				pileRep.empiler(po.getIpo());
				break;
			//inssi - fsi
			case 35: 
				po.modifier(pileRep.depiler(), po.getIpo() + 1);
				break; 
			//boucle - ttq
			case 36: 
				pileRep.empiler(po.getIpo() + 1);
				break; 
			//inssi - faire
			case 37: //identique au gen 33 
				po.produire(BSIFAUX);
				po.produire(-1);
				modifVecteurTrans(TRANSCODE);
				pileRep.empiler(po.getIpo());
				break; 
			//inssi - fait
			case 38: 
				po.modifier(pileRep.depiler(), po.getIpo() + 3);
				po.produire(BINCOND);
				po.produire(pileRep.depiler());
				modifVecteurTrans(TRANSCODE);
				break; 
			//condition - cond
			case 39: 
				pileRep.empiler(-2);
				System.out.println("1 - " + pileRep.ip + " - " + Arrays.deepToString(pileRep.T));
				break; 
			//condition - finExpr
			case 40: 
				po.produire(BSIFAUX);
				po.produire(-1);
				modifVecteurTrans(TRANSCODE);
				pileRep.empiler(po.getIpo());
				System.out.println("2 - " + pileRep.ip + " - " + Arrays.deepToString(pileRep.T));
				break;
			//condition - finExpr
			case 41: 
				po.modifier(pileRep.depiler(), po.getIpo() + 3);
				po.produire(BINCOND);
				po.produire(pileRep.depiler());
				modifVecteurTrans(TRANSCODE);
				pileRep.empiler(po.getIpo());
				System.out.println("3 - " + pileRep.ip + " - " + Arrays.deepToString(pileRep.T));
				break; 
			case 55: 
				po.modifier(pileRep.depiler(), po.getIpo() + 1);
				break; 
			//condition - fincond
			case 42: 
				System.out.println("4 - " + pileRep.ip + " - " + Arrays.deepToString(pileRep.T));
				ipotmp = pileRep.depiler();
				while (ipotmp != -2) {
					ipoprec = po.getElt(ipotmp);
					po.modifier(ipotmp, po.getIpo() + 1);
					ipotmp = ipoprec;
				}
				System.out.println("5 - " + pileRep.ip + " - " + Arrays.deepToString(pileRep.T));
				break; 
			//procedure
			case 43: 
				if(presentIdent(bc) != 0) {
					UtilLex.messErr("Identifiant deja utilise");
				}
				idDef = desc.presentDef(UtilLex.chaineIdent(UtilLex.numIdCourant));
				if(idDef != 0){
					desc.modifDefAdPo(idDef, po.getIpo() + 1);
				}
				placeIdent(UtilLex.numIdCourant, PROC, NEUTRE, po.getIpo() + 1);
				if(idDef != 0) {
					placeIdent(-1, DEF, NEUTRE, -1);
				} else {
					placeIdent(-1, PRIVEE, NEUTRE, -1);
				}
				bc = it + 1;
				iterateurDesProc = 0;
				break; 
			case 44: 
				if(presentIdent(bc) != 0) {
					UtilLex.messErr("Identifiant deja utilise");
				}
				placeIdent(UtilLex.numIdCourant, PARAMFIXE, tCour, iterateurDesProc);
				iterateurDesProc++;
				break; 
			case 45: 
				if(presentIdent(bc) != 0) {
					UtilLex.messErr("Identifiant deja utilise");
				}
				placeIdent(UtilLex.numIdCourant, PARAMMOD, tCour, iterateurDesProc);
				iterateurDesProc++;
				break; 
			case 46: 
				tabSymb[bc - 1].info = iterateurDesProc;
				if(idDef != 0) {
					desc.modifDefNbParam(idDef, iterateurDesProc);
				}
				iterateurDesVariables=0;
				iterateurDesProc+=2;
				break;
			case 47: 
				if(iterateurDesVariables > 0) {
					po.produire(RESERVER);
					po.produire(iterateurDesVariables);
				}
				break; 
			//fin
			case 48: 
				if(bc != 1) {
					po.produire(RETOUR);
					po.produire(tabSymb[bc - 1].info);
					int nbValSup = 0;
					for (int i = bc; i <= it ; i++) {
						if(tabSymb[i].categorie == PARAMFIXE || tabSymb[i].categorie == PARAMMOD) {
							tabSymb[i].code = -1;
						} else if(tabSymb[i].categorie == VARLOCALE || tabSymb[i].categorie == CONSTANTE) {
							nbValSup++;
							tabSymb[i] = null;
						}
					}
					it -= nbValSup ;
					bc = 1;
				} else {
					po.produire(ARRET);
				}// affichage de la table des symboles en fin de compilation
				break; 
			case 49: 
				nbParamAppel = 0; 
				break; 
			case 50:
				//appel paramfixe
				if(nbParamAppel >= tabSymb[idVarAffectation + 1].info) {
					UtilLex.messErr("Trop de parametres declares");
				}
				if(tabSymb[idVarAffectation + 2 + nbParamAppel].type != tCour) {
					UtilLex.messErr("Mauvais type de variable sur le " + nbParamAppel + "e parametre");
				}
				if(tabSymb[idVarAffectation + 2 + nbParamAppel].categorie == PARAMMOD) {
					UtilLex.messErr("Trop de constantes declares");
				}
				nbParamAppel++;
				break; 
			case 51: 
				//appel parammod
				if(nbParamAppel >= tabSymb[idVarAffectation + 1].info) {
					UtilLex.messErr("Trop de parametres declares :" + nbParamAppel + " " + tabSymb[idVarAffectation + 1].info);
				}
				idIdent = presentIdent(1);
				if(idIdent == 0) {
					UtilLex.messErr("Identifiant inconnu");
				}
				if(tabSymb[idVarAffectation + 2 + nbParamAppel].type != tabSymb[idIdent].type) {
					UtilLex.messErr("Mauvais type de variable sur le " + nbParamAppel + "e parametre");
				}
				if(tabSymb[idVarAffectation + 2 + nbParamAppel].categorie == PARAMFIXE) {
					UtilLex.messErr("Constante(s) non declares");
				}
				if(tabSymb[idIdent].categorie == CONSTANTE) {
					UtilLex.messErr("Vous ne pouvez pas déclarer de constante en parametre modifiable de fonction");
				}
				nbParamAppel++;
				
				if(tabSymb[idIdent].categorie == PARAMMOD) {
					po.produire(EMPILERADL);
					po.produire(tabSymb[idIdent].info);
					po.produire(1);
				} else if(tabSymb[idIdent].categorie == VARLOCALE || tabSymb[idIdent].categorie == PARAMFIXE) {
					po.produire(EMPILERADL);
					po.produire(tabSymb[idIdent].info);
					po.produire(0);
				} else if(tabSymb[idIdent].categorie == VARGLOBALE) {
					po.produire(EMPILERADG);
					po.produire(tabSymb[idIdent].info);
				}
				break; 
			case 52: 
				if(nbParamAppel != tabSymb[idVarAffectation + 1].info) {
					UtilLex.messErr("Mauvais nombre de parametre declare : " + nbParamAppel + " " + tabSymb[idVarAffectation + 1].info);
				}
				po.produire(APPEL);
				po.produire(tabSymb[idVarAffectation].info);
				modifVecteurTrans(REFEXT);
				po.produire(tabSymb[idVarAffectation + 1].info);
				break; 
			case 53: 
				if(desc.getUnite() == "programme") {
					if(bc == 1) {
						po.modifier(pileRep.depiler(), po.getIpo() + 1);
					}
				}
				break; 
			case 54 : 
				if(desc.getUnite() == "programme") {
					po.produire(BINCOND);
					po.produire(-1);
					modifVecteurTrans(TRANSCODE);
					pileRep.empiler(po.getIpo());
				}
				break;
			//Refs
			case 56 : 
				//mettre erreur ident
				desc.ajoutRef(UtilLex.chaineIdent(UtilLex.numIdCourant));
				placeIdent(UtilLex.numIdCourant, PROC, NEUTRE, desc.getNbRef());
				placeIdent(-1, REF, NEUTRE, -1);
				iterateurDesVariables = 0;
				bc = it + 1;
				break;
			case 57 : 
				placeIdent(-1, PARAMFIXE, tCour, iterateurDesVariables);// à modifier l'info, mettre le compteur
				iterateurDesVariables++;
				break;
			case 58 : 
				placeIdent(-1, PARAMMOD, tCour, iterateurDesVariables);
				iterateurDesVariables++;
				break;
			case 59 : 
				tabSymb[bc - 1].info = iterateurDesVariables;
				desc.modifRefNbParam(desc.getNbRef(), iterateurDesVariables);
				break;
			//Finrefs
				
			//Descripteur Unite
			case 60 : 
				desc.setUnite("programme");
				break;
			case 61 : 
				desc.setUnite("module");
				break;
			//Descripteur tailleCode
			case 62 : 
				//gestion d'erreur, si une fonction est dans tabDef mais n'est jamais d�clar�
				for (int i = 1; i <= desc.getNbDef(); i++) {
					boolean isDefined = false;
					for (int j = 1; j < tabSymb.length; j++) {
						if(tabSymb[j].categorie == DEF) {
							if(tabSymb[j-1].info == desc.getDefAdPo(i)) {
								isDefined = true;
								break;
							}
						}
					}
					if(!isDefined) {
						UtilLex.messErr("Fonction d�finie mais non d�clar�e.");
					}
				}
				desc.setTailleCode(po.getIpo());
				break;
			case 63 : 
				desc.ajoutDef(UtilLex.chaineIdent(UtilLex.numIdCourant));
				break;
			case 64 : 
				bc = 1;
				iterateurDesVariables = 0;  
				break;
            case 255 :
            	po.constObj();
            	po.constGen();
            	afftabSymb(); 
            	desc.ecrireDesc(UtilLex.nomSource);
            	break;

			// TODO
			
			default:
				System.out.println("Point de generation non prevu dans votre liste");
				break;

		}
	}
}
