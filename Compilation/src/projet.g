// Grammaire du langage PROJET
// CMPL L3info 
// Nathalie Girard, Anne Grazon, Veronique Masson
// il convient d'y inserer les appels a {PtGen.pt(k);}
// relancer Antlr apres chaque modification et raffraichir le projet Eclipse le cas echeant

// attention l'analyse est poursuivie apres erreur si l'on supprime la clause rulecatch

grammar projet;

options {
  language=Java; k=1;
 }

@header {           
import java.io.IOException;
import java.io.DataInputStream;
import java.io.FileInputStream;
} 


// partie syntaxique :  description de la grammaire //
// les non-terminaux doivent commencer par une minuscule


@members {

 
// variables globales et methodes utiles a placer ici
  
}
// la directive rulecatch permet d'interrompre l'analyse a la premiere erreur de syntaxe
@rulecatch {
catch (RecognitionException e) {reportError (e) ; throw e ; }}


unite  :   unitprog {PtGen.pt(255);} EOF 
      |    unitmodule  EOF
  ;
  
unitprog
  : 'programme' ident ':'  
     declarations  
     corps { System.out.println("succes, arret de la compilation "); }
  ;
  
unitmodule
  : 'module' ident ':' 
     declarations   
  ;
  
declarations
  : partiedef? partieref? consts? vars? {PtGen.pt(27);} decprocs? 
  ;
  
partiedef
  : 'def' ident  (',' ident )* ptvg
  ;
  
partieref: 'ref'  specif (',' specif)* ptvg
  ;
  
specif  : ident  ( 'fixe' '(' type  ( ',' type  )* ')' )? 
                 ( 'mod'  '(' type  ( ',' type  )* ')' )? 
  ;
  
consts  : 'const' ( ident {PtGen.pt(1);} '=' valeur {PtGen.pt(2);} ptvg  )+ 
  ;
  
vars  : 'var' ( type ident {PtGen.pt(3);} ( ','  ident {PtGen.pt(3);} )* ptvg  )+ 
  ;
  
type  : 'ent'  {PtGen.pt(4);}
  |     'bool' {PtGen.pt(5);}
  ;
  
decprocs: {PtGen.pt(54);} (decproc ptvg)+ {PtGen.pt(53);} 
  ;
  

decproc :  'proc'  ident {PtGen.pt(43);} parfixe? parmod? {PtGen.pt(46);} consts? vars?  {PtGen.pt(47);} corps 
  ;
  
ptvg  : ';'
  | 
  ;
  
corps : 'debut' instructions 'fin' {PtGen.pt(48);}
  ;
  
parfixe: 'fixe' '(' pf ( ';' pf)* ')'
  ;
  
pf  : type ident {PtGen.pt(44);} ( ',' ident {PtGen.pt(44);} )*  
  ;

parmod : 'mod' '(' pm ( ';' pm)* ')'
  ;
  
pm  : type ident {PtGen.pt(45);} ( ',' ident {PtGen.pt(45);} )*
  ;
  
instructions
  : instruction ( ';' instruction)*
  ;
  
instruction
  : inssi
  | inscond
  | boucle
  | lecture
  | ecriture
  | affouappel
  |
  ;
  
inssi : 'si' expression 'alors' {PtGen.pt(33);} instructions ('sinon' {PtGen.pt(34);} instructions)? 'fsi' {PtGen.pt(35);}
  ;
  
inscond : 'cond' {PtGen.pt(39);} expression ':' {PtGen.pt(40);} instructions
          (',' {PtGen.pt(41);} expression  ':' {PtGen.pt(40);}  instructions )* 
          ('aut' {PtGen.pt(41);} instructions |  ) 
          'fcond' {PtGen.pt(55);} {PtGen.pt(42);}
  ;
  
boucle  : 'ttq' {PtGen.pt(36);} expression 'faire' {PtGen.pt(37);} instructions 'fait' {PtGen.pt(38);}
  ;
  
lecture: 'lire' '(' ident {PtGen.pt(28);} ( ',' ident {PtGen.pt(28);} )* ')' 
  ;
  
ecriture: 'ecrire' '(' expression {PtGen.pt(29);} ( ',' expression {PtGen.pt(29);} )* ')'
   ;
  
affouappel
  : ident {PtGen.pt(30);} ( ':=' expression  {PtGen.pt(31);}
            | (effixes (effmods)?)? {PtGen.pt(52);}
           )
  ;
   
effixes : '(' {PtGen.pt(49);} (expression {PtGen.pt(50);} (',' expression {PtGen.pt(50);} )*)? ')'
  ;
  
effmods :'(' (ident {PtGen.pt(51);} (',' ident {PtGen.pt(51);} )*)? ')'
  ; 
  
expression: (exp1) ('ou' {PtGen.pt(23);} exp1 {PtGen.pt(23);} {PtGen.pt(26);} )*
  ;
  
exp1  : exp2 ('et' {PtGen.pt(23);}  exp2 {PtGen.pt(23);} {PtGen.pt(25);})*
  ;
  
exp2  : 'non' exp2 {PtGen.pt(23);} {PtGen.pt(24);} 
  | exp3  
  ;
  
exp3  : exp4 
  ( '='  {PtGen.pt(12);} exp4 {PtGen.pt(12);} {PtGen.pt(17);}
  | '<>' {PtGen.pt(12);} exp4 {PtGen.pt(12);} {PtGen.pt(18);}
  | '>'  {PtGen.pt(12);} exp4 {PtGen.pt(12);} {PtGen.pt(19);}
  | '>=' {PtGen.pt(12);} exp4 {PtGen.pt(12);} {PtGen.pt(20);}
  | '<'  {PtGen.pt(12);} exp4 {PtGen.pt(12);} {PtGen.pt(21);}
  | '<=' {PtGen.pt(12);} exp4 {PtGen.pt(12);} {PtGen.pt(22);}
  ) ?
  ;
  
exp4  : exp5 
        ('+' {PtGen.pt(12);} exp5 {PtGen.pt(12);} {PtGen.pt(15);}
        |'-' {PtGen.pt(12);} exp5 {PtGen.pt(12);} {PtGen.pt(16);}
        )*
  ;
  
exp5  : primaire  
        (    '*' {PtGen.pt(12);}   primaire  {PtGen.pt(12);} {PtGen.pt(13);}
          | 'div' {PtGen.pt(12);}  primaire  {PtGen.pt(12);} {PtGen.pt(14);}
        )*
  ;
  
primaire: valeur {PtGen.pt(11);}
  | ident  {PtGen.pt(10);}
  | '(' expression ')'
  ;
  
valeur  : nbentier {PtGen.pt(6);}
  | '+' nbentier {PtGen.pt(6);}
  | '-' nbentier {PtGen.pt(7);}
  | 'vrai' {PtGen.pt(8);}
  | 'faux' {PtGen.pt(9);}
  ;

// partie lexicale  : cette partie ne doit pas etre modifiee  //
// les unites lexicales de ANTLR doivent commencer par une majuscule
// Attention : ANTLR n'autorise pas certains traitements sur les unites lexicales, 
// il est alors ncessaire de passer par un non-terminal intermediaire 
// exemple : pour l'unit lexicale INT, le non-terminal nbentier a du etre introduit
 
      
nbentier  :   INT { UtilLex.valEnt = Integer.parseInt($INT.text);}; // mise a jour de valEnt

ident : ID  { UtilLex.traiterId($ID.text); } ; // mise a jour de numIdCourant
     // tous les identificateurs seront places dans la table des identificateurs, y compris le nom du programme ou module
     // (NB: la table des symboles n'est pas geree au niveau lexical mais au niveau du compilateur)
        
  
ID  :   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ; 
     
// zone purement lexicale //

INT :   '0'..'9'+ ;
WS  :   (' '|'\t' |'\r')+ {skip();} ; // definition des "blocs d'espaces"
RC  :   ('\n') {UtilLex.incrementeLigne(); skip() ;} ; // definition d'un unique "passage a la ligne" et comptage des numeros de lignes

COMMENT
  :  '\{' (.)* '\}' {skip();}   // toute suite de caracteres entouree d'accolades est un commentaire
  |  '#' ~( '\r' | '\n' )* {skip();}  // tout ce qui suit un caractere diese sur une ligne est un commentaire
  ;

// commentaires sur plusieurs lignes
ML_COMMENT    :   '/*' (options {greedy=false;} : .)* '*/' {$channel=HIDDEN;}
    ;	   



	   
