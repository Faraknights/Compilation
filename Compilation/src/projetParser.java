// $ANTLR 3.5.2 projet.g 2022-02-10 13:06:56
           
import java.io.IOException;
import java.io.DataInputStream;
import java.io.FileInputStream;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class projetParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "ID", "INT", "ML_COMMENT", 
		"RC", "WS", "'('", "')'", "'*'", "'+'", "','", "'-'", "':'", "':='", "';'", 
		"'<'", "'<='", "'<>'", "'='", "'>'", "'>='", "'alors'", "'aut'", "'bool'", 
		"'cond'", "'const'", "'debut'", "'def'", "'div'", "'ecrire'", "'ent'", 
		"'et'", "'faire'", "'fait'", "'faux'", "'fcond'", "'fin'", "'fixe'", "'fsi'", 
		"'lire'", "'mod'", "'module'", "'non'", "'ou'", "'proc'", "'programme'", 
		"'ref'", "'si'", "'sinon'", "'ttq'", "'var'", "'vrai'"
	};
	public static final int EOF=-1;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int COMMENT=4;
	public static final int ID=5;
	public static final int INT=6;
	public static final int ML_COMMENT=7;
	public static final int RC=8;
	public static final int WS=9;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public projetParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public projetParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return projetParser.tokenNames; }
	@Override public String getGrammarFileName() { return "projet.g"; }



	 
	// variables globales et methodes utiles a placer ici
	  



	// $ANTLR start "unite"
	// projet.g:37:1: unite : ( unitprog EOF | unitmodule EOF );
	public final void unite() throws RecognitionException {
		try {
			// projet.g:37:8: ( unitprog EOF | unitmodule EOF )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==49) ) {
				alt1=1;
			}
			else if ( (LA1_0==45) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// projet.g:37:12: unitprog EOF
					{
					pushFollow(FOLLOW_unitprog_in_unite64);
					unitprog();
					state._fsp--;

					match(input,EOF,FOLLOW_EOF_in_unite67); 
					}
					break;
				case 2 :
					// projet.g:38:12: unitmodule EOF
					{
					pushFollow(FOLLOW_unitmodule_in_unite80);
					unitmodule();
					state._fsp--;

					match(input,EOF,FOLLOW_EOF_in_unite83); 
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unite"



	// $ANTLR start "unitprog"
	// projet.g:41:1: unitprog : 'programme' ident ':' declarations corps ;
	public final void unitprog() throws RecognitionException {
		try {
			// projet.g:42:3: ( 'programme' ident ':' declarations corps )
			// projet.g:42:5: 'programme' ident ':' declarations corps
			{
			match(input,49,FOLLOW_49_in_unitprog98); 
			pushFollow(FOLLOW_ident_in_unitprog100);
			ident();
			state._fsp--;

			match(input,16,FOLLOW_16_in_unitprog102); 
			pushFollow(FOLLOW_declarations_in_unitprog111);
			declarations();
			state._fsp--;

			pushFollow(FOLLOW_corps_in_unitprog120);
			corps();
			state._fsp--;

			 System.out.println("succes, arret de la compilation "); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unitprog"



	// $ANTLR start "unitmodule"
	// projet.g:47:1: unitmodule : 'module' ident ':' declarations ;
	public final void unitmodule() throws RecognitionException {
		try {
			// projet.g:48:3: ( 'module' ident ':' declarations )
			// projet.g:48:5: 'module' ident ':' declarations
			{
			match(input,45,FOLLOW_45_in_unitmodule137); 
			pushFollow(FOLLOW_ident_in_unitmodule139);
			ident();
			state._fsp--;

			match(input,16,FOLLOW_16_in_unitmodule141); 
			pushFollow(FOLLOW_declarations_in_unitmodule149);
			declarations();
			state._fsp--;

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unitmodule"



	// $ANTLR start "declarations"
	// projet.g:52:1: declarations : ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )? ;
	public final void declarations() throws RecognitionException {
		try {
			// projet.g:53:3: ( ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )? )
			// projet.g:53:5: ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )?
			{
			// projet.g:53:5: ( partiedef )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==31) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// projet.g:53:5: partiedef
					{
					pushFollow(FOLLOW_partiedef_in_declarations167);
					partiedef();
					state._fsp--;

					}
					break;

			}

			// projet.g:53:16: ( partieref )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==50) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// projet.g:53:16: partieref
					{
					pushFollow(FOLLOW_partieref_in_declarations170);
					partieref();
					state._fsp--;

					}
					break;

			}

			// projet.g:53:27: ( consts )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==29) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// projet.g:53:27: consts
					{
					pushFollow(FOLLOW_consts_in_declarations173);
					consts();
					state._fsp--;

					}
					break;

			}

			// projet.g:53:35: ( vars )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==54) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// projet.g:53:35: vars
					{
					pushFollow(FOLLOW_vars_in_declarations176);
					vars();
					state._fsp--;

					}
					break;

			}

			// projet.g:53:41: ( decprocs )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==48) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// projet.g:53:41: decprocs
					{
					pushFollow(FOLLOW_decprocs_in_declarations179);
					decprocs();
					state._fsp--;

					}
					break;

			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declarations"



	// $ANTLR start "partiedef"
	// projet.g:56:1: partiedef : 'def' ident ( ',' ident )* ptvg ;
	public final void partiedef() throws RecognitionException {
		try {
			// projet.g:57:3: ( 'def' ident ( ',' ident )* ptvg )
			// projet.g:57:5: 'def' ident ( ',' ident )* ptvg
			{
			match(input,31,FOLLOW_31_in_partiedef196); 
			pushFollow(FOLLOW_ident_in_partiedef198);
			ident();
			state._fsp--;

			// projet.g:57:18: ( ',' ident )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==14) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// projet.g:57:19: ',' ident
					{
					match(input,14,FOLLOW_14_in_partiedef202); 
					pushFollow(FOLLOW_ident_in_partiedef204);
					ident();
					state._fsp--;

					}
					break;

				default :
					break loop7;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partiedef209);
			ptvg();
			state._fsp--;

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "partiedef"



	// $ANTLR start "partieref"
	// projet.g:60:1: partieref : 'ref' specif ( ',' specif )* ptvg ;
	public final void partieref() throws RecognitionException {
		try {
			// projet.g:60:10: ( 'ref' specif ( ',' specif )* ptvg )
			// projet.g:60:12: 'ref' specif ( ',' specif )* ptvg
			{
			match(input,50,FOLLOW_50_in_partieref221); 
			pushFollow(FOLLOW_specif_in_partieref224);
			specif();
			state._fsp--;

			// projet.g:60:26: ( ',' specif )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==14) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// projet.g:60:27: ',' specif
					{
					match(input,14,FOLLOW_14_in_partieref227); 
					pushFollow(FOLLOW_specif_in_partieref229);
					specif();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partieref233);
			ptvg();
			state._fsp--;

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "partieref"



	// $ANTLR start "specif"
	// projet.g:63:1: specif : ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )? ;
	public final void specif() throws RecognitionException {
		try {
			// projet.g:63:9: ( ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )? )
			// projet.g:63:11: ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )?
			{
			pushFollow(FOLLOW_ident_in_specif247);
			ident();
			state._fsp--;

			// projet.g:63:18: ( 'fixe' '(' type ( ',' type )* ')' )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==41) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// projet.g:63:20: 'fixe' '(' type ( ',' type )* ')'
					{
					match(input,41,FOLLOW_41_in_specif252); 
					match(input,10,FOLLOW_10_in_specif254); 
					pushFollow(FOLLOW_type_in_specif256);
					type();
					state._fsp--;

					// projet.g:63:37: ( ',' type )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==14) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// projet.g:63:39: ',' type
							{
							match(input,14,FOLLOW_14_in_specif261); 
							pushFollow(FOLLOW_type_in_specif263);
							type();
							state._fsp--;

							}
							break;

						default :
							break loop9;
						}
					}

					match(input,11,FOLLOW_11_in_specif269); 
					}
					break;

			}

			// projet.g:64:18: ( 'mod' '(' type ( ',' type )* ')' )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==44) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// projet.g:64:20: 'mod' '(' type ( ',' type )* ')'
					{
					match(input,44,FOLLOW_44_in_specif294); 
					match(input,10,FOLLOW_10_in_specif297); 
					pushFollow(FOLLOW_type_in_specif299);
					type();
					state._fsp--;

					// projet.g:64:37: ( ',' type )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==14) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// projet.g:64:39: ',' type
							{
							match(input,14,FOLLOW_14_in_specif304); 
							pushFollow(FOLLOW_type_in_specif306);
							type();
							state._fsp--;

							}
							break;

						default :
							break loop11;
						}
					}

					match(input,11,FOLLOW_11_in_specif312); 
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "specif"



	// $ANTLR start "consts"
	// projet.g:67:1: consts : 'const' ( ident '=' valeur ptvg )+ ;
	public final void consts() throws RecognitionException {
		try {
			// projet.g:67:9: ( 'const' ( ident '=' valeur ptvg )+ )
			// projet.g:67:11: 'const' ( ident '=' valeur ptvg )+
			{
			match(input,29,FOLLOW_29_in_consts330); 
			// projet.g:67:19: ( ident '=' valeur ptvg )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==ID) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// projet.g:67:21: ident '=' valeur ptvg
					{
					pushFollow(FOLLOW_ident_in_consts334);
					ident();
					state._fsp--;

					match(input,22,FOLLOW_22_in_consts337); 
					pushFollow(FOLLOW_valeur_in_consts339);
					valeur();
					state._fsp--;

					pushFollow(FOLLOW_ptvg_in_consts342);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "consts"



	// $ANTLR start "vars"
	// projet.g:70:1: vars : 'var' ( type ident ( ',' ident )* ptvg )+ ;
	public final void vars() throws RecognitionException {
		try {
			// projet.g:70:7: ( 'var' ( type ident ( ',' ident )* ptvg )+ )
			// projet.g:70:9: 'var' ( type ident ( ',' ident )* ptvg )+
			{
			match(input,54,FOLLOW_54_in_vars361); 
			// projet.g:70:15: ( type ident ( ',' ident )* ptvg )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==27||LA15_0==34) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// projet.g:70:17: type ident ( ',' ident )* ptvg
					{
					pushFollow(FOLLOW_type_in_vars365);
					type();
					state._fsp--;

					pushFollow(FOLLOW_ident_in_vars367);
					ident();
					state._fsp--;

					// projet.g:70:29: ( ',' ident )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==14) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// projet.g:70:31: ',' ident
							{
							match(input,14,FOLLOW_14_in_vars372); 
							pushFollow(FOLLOW_ident_in_vars375);
							ident();
							state._fsp--;

							}
							break;

						default :
							break loop14;
						}
					}

					pushFollow(FOLLOW_ptvg_in_vars381);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "vars"



	// $ANTLR start "type"
	// projet.g:73:1: type : ( 'ent' | 'bool' );
	public final void type() throws RecognitionException {
		try {
			// projet.g:73:7: ( 'ent' | 'bool' )
			// projet.g:
			{
			if ( input.LA(1)==27||input.LA(1)==34 ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type"



	// $ANTLR start "decprocs"
	// projet.g:77:1: decprocs : ( decproc ptvg )+ ;
	public final void decprocs() throws RecognitionException {
		try {
			// projet.g:77:9: ( ( decproc ptvg )+ )
			// projet.g:77:11: ( decproc ptvg )+
			{
			// projet.g:77:11: ( decproc ptvg )+
			int cnt16=0;
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==48) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// projet.g:77:12: decproc ptvg
					{
					pushFollow(FOLLOW_decproc_in_decprocs425);
					decproc();
					state._fsp--;

					pushFollow(FOLLOW_ptvg_in_decprocs427);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt16 >= 1 ) break loop16;
					EarlyExitException eee = new EarlyExitException(16, input);
					throw eee;
				}
				cnt16++;
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decprocs"



	// $ANTLR start "decproc"
	// projet.g:80:1: decproc : 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps ;
	public final void decproc() throws RecognitionException {
		try {
			// projet.g:80:9: ( 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps )
			// projet.g:80:12: 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps
			{
			match(input,48,FOLLOW_48_in_decproc443); 
			pushFollow(FOLLOW_ident_in_decproc446);
			ident();
			state._fsp--;

			// projet.g:80:27: ( parfixe )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==41) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// projet.g:80:27: parfixe
					{
					pushFollow(FOLLOW_parfixe_in_decproc449);
					parfixe();
					state._fsp--;

					}
					break;

			}

			// projet.g:80:36: ( parmod )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==44) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// projet.g:80:36: parmod
					{
					pushFollow(FOLLOW_parmod_in_decproc452);
					parmod();
					state._fsp--;

					}
					break;

			}

			// projet.g:80:44: ( consts )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==29) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// projet.g:80:44: consts
					{
					pushFollow(FOLLOW_consts_in_decproc455);
					consts();
					state._fsp--;

					}
					break;

			}

			// projet.g:80:52: ( vars )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==54) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// projet.g:80:52: vars
					{
					pushFollow(FOLLOW_vars_in_decproc458);
					vars();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_corps_in_decproc461);
			corps();
			state._fsp--;

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decproc"



	// $ANTLR start "ptvg"
	// projet.g:83:1: ptvg : ( ';' |);
	public final void ptvg() throws RecognitionException {
		try {
			// projet.g:83:7: ( ';' |)
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==18) ) {
				alt21=1;
			}
			else if ( (LA21_0==EOF||LA21_0==ID||LA21_0==27||(LA21_0 >= 29 && LA21_0 <= 30)||LA21_0==34||LA21_0==48||LA21_0==50||LA21_0==54) ) {
				alt21=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// projet.g:83:9: ';'
					{
					match(input,18,FOLLOW_18_in_ptvg476); 
					}
					break;
				case 2 :
					// projet.g:85:3: 
					{
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ptvg"



	// $ANTLR start "corps"
	// projet.g:87:1: corps : 'debut' instructions 'fin' ;
	public final void corps() throws RecognitionException {
		try {
			// projet.g:87:7: ( 'debut' instructions 'fin' )
			// projet.g:87:9: 'debut' instructions 'fin'
			{
			match(input,30,FOLLOW_30_in_corps494); 
			pushFollow(FOLLOW_instructions_in_corps496);
			instructions();
			state._fsp--;

			match(input,40,FOLLOW_40_in_corps498); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "corps"



	// $ANTLR start "parfixe"
	// projet.g:90:1: parfixe : 'fixe' '(' pf ( ';' pf )* ')' ;
	public final void parfixe() throws RecognitionException {
		try {
			// projet.g:90:8: ( 'fixe' '(' pf ( ';' pf )* ')' )
			// projet.g:90:10: 'fixe' '(' pf ( ';' pf )* ')'
			{
			match(input,41,FOLLOW_41_in_parfixe510); 
			match(input,10,FOLLOW_10_in_parfixe512); 
			pushFollow(FOLLOW_pf_in_parfixe514);
			pf();
			state._fsp--;

			// projet.g:90:24: ( ';' pf )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==18) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// projet.g:90:26: ';' pf
					{
					match(input,18,FOLLOW_18_in_parfixe518); 
					pushFollow(FOLLOW_pf_in_parfixe520);
					pf();
					state._fsp--;

					}
					break;

				default :
					break loop22;
				}
			}

			match(input,11,FOLLOW_11_in_parfixe524); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "parfixe"



	// $ANTLR start "pf"
	// projet.g:93:1: pf : type ident ( ',' ident )* ;
	public final void pf() throws RecognitionException {
		try {
			// projet.g:93:5: ( type ident ( ',' ident )* )
			// projet.g:93:7: type ident ( ',' ident )*
			{
			pushFollow(FOLLOW_type_in_pf538);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pf540);
			ident();
			state._fsp--;

			// projet.g:93:19: ( ',' ident )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==14) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// projet.g:93:21: ',' ident
					{
					match(input,14,FOLLOW_14_in_pf545); 
					pushFollow(FOLLOW_ident_in_pf547);
					ident();
					state._fsp--;

					}
					break;

				default :
					break loop23;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pf"



	// $ANTLR start "parmod"
	// projet.g:96:1: parmod : 'mod' '(' pm ( ';' pm )* ')' ;
	public final void parmod() throws RecognitionException {
		try {
			// projet.g:96:9: ( 'mod' '(' pm ( ';' pm )* ')' )
			// projet.g:96:11: 'mod' '(' pm ( ';' pm )* ')'
			{
			match(input,44,FOLLOW_44_in_parmod565); 
			match(input,10,FOLLOW_10_in_parmod567); 
			pushFollow(FOLLOW_pm_in_parmod569);
			pm();
			state._fsp--;

			// projet.g:96:24: ( ';' pm )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==18) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// projet.g:96:26: ';' pm
					{
					match(input,18,FOLLOW_18_in_parmod573); 
					pushFollow(FOLLOW_pm_in_parmod575);
					pm();
					state._fsp--;

					}
					break;

				default :
					break loop24;
				}
			}

			match(input,11,FOLLOW_11_in_parmod579); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "parmod"



	// $ANTLR start "pm"
	// projet.g:99:1: pm : type ident ( ',' ident )* ;
	public final void pm() throws RecognitionException {
		try {
			// projet.g:99:5: ( type ident ( ',' ident )* )
			// projet.g:99:7: type ident ( ',' ident )*
			{
			pushFollow(FOLLOW_type_in_pm593);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pm595);
			ident();
			state._fsp--;

			// projet.g:99:19: ( ',' ident )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==14) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// projet.g:99:21: ',' ident
					{
					match(input,14,FOLLOW_14_in_pm600); 
					pushFollow(FOLLOW_ident_in_pm602);
					ident();
					state._fsp--;

					}
					break;

				default :
					break loop25;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pm"



	// $ANTLR start "instructions"
	// projet.g:102:1: instructions : instruction ( ';' instruction )* ;
	public final void instructions() throws RecognitionException {
		try {
			// projet.g:103:3: ( instruction ( ';' instruction )* )
			// projet.g:103:5: instruction ( ';' instruction )*
			{
			pushFollow(FOLLOW_instruction_in_instructions621);
			instruction();
			state._fsp--;

			// projet.g:103:17: ( ';' instruction )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==18) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// projet.g:103:19: ';' instruction
					{
					match(input,18,FOLLOW_18_in_instructions625); 
					pushFollow(FOLLOW_instruction_in_instructions627);
					instruction();
					state._fsp--;

					}
					break;

				default :
					break loop26;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "instructions"



	// $ANTLR start "instruction"
	// projet.g:106:1: instruction : ( inssi | inscond | boucle | lecture | ecriture | affouappel |);
	public final void instruction() throws RecognitionException {
		try {
			// projet.g:107:3: ( inssi | inscond | boucle | lecture | ecriture | affouappel |)
			int alt27=7;
			switch ( input.LA(1) ) {
			case 51:
				{
				alt27=1;
				}
				break;
			case 28:
				{
				alt27=2;
				}
				break;
			case 53:
				{
				alt27=3;
				}
				break;
			case 43:
				{
				alt27=4;
				}
				break;
			case 33:
				{
				alt27=5;
				}
				break;
			case ID:
				{
				alt27=6;
				}
				break;
			case 14:
			case 18:
			case 26:
			case 37:
			case 39:
			case 40:
			case 42:
			case 52:
				{
				alt27=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}
			switch (alt27) {
				case 1 :
					// projet.g:107:5: inssi
					{
					pushFollow(FOLLOW_inssi_in_instruction644);
					inssi();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:108:5: inscond
					{
					pushFollow(FOLLOW_inscond_in_instruction650);
					inscond();
					state._fsp--;

					}
					break;
				case 3 :
					// projet.g:109:5: boucle
					{
					pushFollow(FOLLOW_boucle_in_instruction656);
					boucle();
					state._fsp--;

					}
					break;
				case 4 :
					// projet.g:110:5: lecture
					{
					pushFollow(FOLLOW_lecture_in_instruction662);
					lecture();
					state._fsp--;

					}
					break;
				case 5 :
					// projet.g:111:5: ecriture
					{
					pushFollow(FOLLOW_ecriture_in_instruction668);
					ecriture();
					state._fsp--;

					}
					break;
				case 6 :
					// projet.g:112:5: affouappel
					{
					pushFollow(FOLLOW_affouappel_in_instruction674);
					affouappel();
					state._fsp--;

					}
					break;
				case 7 :
					// projet.g:114:3: 
					{
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "instruction"



	// $ANTLR start "inssi"
	// projet.g:116:1: inssi : 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' ;
	public final void inssi() throws RecognitionException {
		try {
			// projet.g:116:7: ( 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' )
			// projet.g:116:9: 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi'
			{
			match(input,51,FOLLOW_51_in_inssi691); 
			pushFollow(FOLLOW_expression_in_inssi693);
			expression();
			state._fsp--;

			match(input,25,FOLLOW_25_in_inssi695); 
			pushFollow(FOLLOW_instructions_in_inssi697);
			instructions();
			state._fsp--;

			// projet.g:116:46: ( 'sinon' instructions )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==52) ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// projet.g:116:47: 'sinon' instructions
					{
					match(input,52,FOLLOW_52_in_inssi700); 
					pushFollow(FOLLOW_instructions_in_inssi703);
					instructions();
					state._fsp--;

					}
					break;

			}

			match(input,42,FOLLOW_42_in_inssi707); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inssi"



	// $ANTLR start "inscond"
	// projet.g:119:1: inscond : 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond' ;
	public final void inscond() throws RecognitionException {
		try {
			// projet.g:119:9: ( 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond' )
			// projet.g:119:11: 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond'
			{
			match(input,28,FOLLOW_28_in_inscond721); 
			pushFollow(FOLLOW_expression_in_inscond724);
			expression();
			state._fsp--;

			match(input,16,FOLLOW_16_in_inscond727); 
			pushFollow(FOLLOW_instructions_in_inscond729);
			instructions();
			state._fsp--;

			// projet.g:120:11: ( ',' expression ':' instructions )*
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( (LA29_0==14) ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// projet.g:120:12: ',' expression ':' instructions
					{
					match(input,14,FOLLOW_14_in_inscond743); 
					pushFollow(FOLLOW_expression_in_inscond746);
					expression();
					state._fsp--;

					match(input,16,FOLLOW_16_in_inscond749); 
					pushFollow(FOLLOW_instructions_in_inscond751);
					instructions();
					state._fsp--;

					}
					break;

				default :
					break loop29;
				}
			}

			// projet.g:121:11: ( 'aut' instructions |)
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==26) ) {
				alt30=1;
			}
			else if ( (LA30_0==39) ) {
				alt30=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}

			switch (alt30) {
				case 1 :
					// projet.g:121:12: 'aut' instructions
					{
					match(input,26,FOLLOW_26_in_inscond768); 
					pushFollow(FOLLOW_instructions_in_inscond771);
					instructions();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:121:35: 
					{
					}
					break;

			}

			match(input,39,FOLLOW_39_in_inscond789); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inscond"



	// $ANTLR start "boucle"
	// projet.g:125:1: boucle : 'ttq' expression 'faire' instructions 'fait' ;
	public final void boucle() throws RecognitionException {
		try {
			// projet.g:125:9: ( 'ttq' expression 'faire' instructions 'fait' )
			// projet.g:125:11: 'ttq' expression 'faire' instructions 'fait'
			{
			match(input,53,FOLLOW_53_in_boucle804); 
			pushFollow(FOLLOW_expression_in_boucle807);
			expression();
			state._fsp--;

			match(input,36,FOLLOW_36_in_boucle809); 
			pushFollow(FOLLOW_instructions_in_boucle811);
			instructions();
			state._fsp--;

			match(input,37,FOLLOW_37_in_boucle813); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "boucle"



	// $ANTLR start "lecture"
	// projet.g:128:1: lecture : 'lire' '(' ident ( ',' ident )* ')' ;
	public final void lecture() throws RecognitionException {
		try {
			// projet.g:128:8: ( 'lire' '(' ident ( ',' ident )* ')' )
			// projet.g:128:10: 'lire' '(' ident ( ',' ident )* ')'
			{
			match(input,43,FOLLOW_43_in_lecture826); 
			match(input,10,FOLLOW_10_in_lecture828); 
			pushFollow(FOLLOW_ident_in_lecture830);
			ident();
			state._fsp--;

			// projet.g:128:28: ( ',' ident )*
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( (LA31_0==14) ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// projet.g:128:30: ',' ident
					{
					match(input,14,FOLLOW_14_in_lecture835); 
					pushFollow(FOLLOW_ident_in_lecture837);
					ident();
					state._fsp--;

					}
					break;

				default :
					break loop31;
				}
			}

			match(input,11,FOLLOW_11_in_lecture843); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "lecture"



	// $ANTLR start "ecriture"
	// projet.g:131:1: ecriture : 'ecrire' '(' expression ( ',' expression )* ')' ;
	public final void ecriture() throws RecognitionException {
		try {
			// projet.g:131:9: ( 'ecrire' '(' expression ( ',' expression )* ')' )
			// projet.g:131:11: 'ecrire' '(' expression ( ',' expression )* ')'
			{
			match(input,33,FOLLOW_33_in_ecriture856); 
			match(input,10,FOLLOW_10_in_ecriture858); 
			pushFollow(FOLLOW_expression_in_ecriture860);
			expression();
			state._fsp--;

			// projet.g:131:36: ( ',' expression )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==14) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// projet.g:131:38: ',' expression
					{
					match(input,14,FOLLOW_14_in_ecriture865); 
					pushFollow(FOLLOW_expression_in_ecriture867);
					expression();
					state._fsp--;

					}
					break;

				default :
					break loop32;
				}
			}

			match(input,11,FOLLOW_11_in_ecriture873); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ecriture"



	// $ANTLR start "affouappel"
	// projet.g:134:1: affouappel : ident ( ':=' expression | ( effixes ( effmods )? )? ) ;
	public final void affouappel() throws RecognitionException {
		try {
			// projet.g:135:3: ( ident ( ':=' expression | ( effixes ( effmods )? )? ) )
			// projet.g:135:5: ident ( ':=' expression | ( effixes ( effmods )? )? )
			{
			pushFollow(FOLLOW_ident_in_affouappel889);
			ident();
			state._fsp--;

			// projet.g:135:12: ( ':=' expression | ( effixes ( effmods )? )? )
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==17) ) {
				alt35=1;
			}
			else if ( (LA35_0==10||LA35_0==14||LA35_0==18||LA35_0==26||LA35_0==37||(LA35_0 >= 39 && LA35_0 <= 40)||LA35_0==42||LA35_0==52) ) {
				alt35=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}

			switch (alt35) {
				case 1 :
					// projet.g:135:17: ':=' expression
					{
					match(input,17,FOLLOW_17_in_affouappel897); 
					pushFollow(FOLLOW_expression_in_affouappel899);
					expression();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:136:17: ( effixes ( effmods )? )?
					{
					// projet.g:136:17: ( effixes ( effmods )? )?
					int alt34=2;
					int LA34_0 = input.LA(1);
					if ( (LA34_0==10) ) {
						alt34=1;
					}
					switch (alt34) {
						case 1 :
							// projet.g:136:18: effixes ( effmods )?
							{
							pushFollow(FOLLOW_effixes_in_affouappel919);
							effixes();
							state._fsp--;

							// projet.g:136:26: ( effmods )?
							int alt33=2;
							int LA33_0 = input.LA(1);
							if ( (LA33_0==10) ) {
								alt33=1;
							}
							switch (alt33) {
								case 1 :
									// projet.g:136:27: effmods
									{
									pushFollow(FOLLOW_effmods_in_affouappel922);
									effmods();
									state._fsp--;

									}
									break;

							}

							}
							break;

					}

					}
					break;

			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "affouappel"



	// $ANTLR start "effixes"
	// projet.g:140:1: effixes : '(' ( expression ( ',' expression )* )? ')' ;
	public final void effixes() throws RecognitionException {
		try {
			// projet.g:140:9: ( '(' ( expression ( ',' expression )* )? ')' )
			// projet.g:140:11: '(' ( expression ( ',' expression )* )? ')'
			{
			match(input,10,FOLLOW_10_in_effixes954); 
			// projet.g:140:15: ( expression ( ',' expression )* )?
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( ((LA37_0 >= ID && LA37_0 <= INT)||LA37_0==10||LA37_0==13||LA37_0==15||LA37_0==38||LA37_0==46||LA37_0==55) ) {
				alt37=1;
			}
			switch (alt37) {
				case 1 :
					// projet.g:140:16: expression ( ',' expression )*
					{
					pushFollow(FOLLOW_expression_in_effixes957);
					expression();
					state._fsp--;

					// projet.g:140:28: ( ',' expression )*
					loop36:
					while (true) {
						int alt36=2;
						int LA36_0 = input.LA(1);
						if ( (LA36_0==14) ) {
							alt36=1;
						}

						switch (alt36) {
						case 1 :
							// projet.g:140:29: ',' expression
							{
							match(input,14,FOLLOW_14_in_effixes961); 
							pushFollow(FOLLOW_expression_in_effixes963);
							expression();
							state._fsp--;

							}
							break;

						default :
							break loop36;
						}
					}

					}
					break;

			}

			match(input,11,FOLLOW_11_in_effixes971); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effixes"



	// $ANTLR start "effmods"
	// projet.g:143:1: effmods : '(' ( ident ( ',' ident )* )? ')' ;
	public final void effmods() throws RecognitionException {
		try {
			// projet.g:143:9: ( '(' ( ident ( ',' ident )* )? ')' )
			// projet.g:143:10: '(' ( ident ( ',' ident )* )? ')'
			{
			match(input,10,FOLLOW_10_in_effmods983); 
			// projet.g:143:14: ( ident ( ',' ident )* )?
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==ID) ) {
				alt39=1;
			}
			switch (alt39) {
				case 1 :
					// projet.g:143:15: ident ( ',' ident )*
					{
					pushFollow(FOLLOW_ident_in_effmods986);
					ident();
					state._fsp--;

					// projet.g:143:22: ( ',' ident )*
					loop38:
					while (true) {
						int alt38=2;
						int LA38_0 = input.LA(1);
						if ( (LA38_0==14) ) {
							alt38=1;
						}

						switch (alt38) {
						case 1 :
							// projet.g:143:23: ',' ident
							{
							match(input,14,FOLLOW_14_in_effmods990); 
							pushFollow(FOLLOW_ident_in_effmods992);
							ident();
							state._fsp--;

							}
							break;

						default :
							break loop38;
						}
					}

					}
					break;

			}

			match(input,11,FOLLOW_11_in_effmods1000); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effmods"



	// $ANTLR start "expression"
	// projet.g:146:1: expression : ( exp1 ) ( 'ou' exp1 )* ;
	public final void expression() throws RecognitionException {
		try {
			// projet.g:146:11: ( ( exp1 ) ( 'ou' exp1 )* )
			// projet.g:146:13: ( exp1 ) ( 'ou' exp1 )*
			{
			// projet.g:146:13: ( exp1 )
			// projet.g:146:14: exp1
			{
			pushFollow(FOLLOW_exp1_in_expression1014);
			exp1();
			state._fsp--;

			}

			// projet.g:146:20: ( 'ou' exp1 )*
			loop40:
			while (true) {
				int alt40=2;
				int LA40_0 = input.LA(1);
				if ( (LA40_0==47) ) {
					alt40=1;
				}

				switch (alt40) {
				case 1 :
					// projet.g:146:21: 'ou' exp1
					{
					match(input,47,FOLLOW_47_in_expression1018); 
					pushFollow(FOLLOW_exp1_in_expression1021);
					exp1();
					state._fsp--;

					}
					break;

				default :
					break loop40;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expression"



	// $ANTLR start "exp1"
	// projet.g:149:1: exp1 : exp2 ( 'et' exp2 )* ;
	public final void exp1() throws RecognitionException {
		try {
			// projet.g:149:7: ( exp2 ( 'et' exp2 )* )
			// projet.g:149:9: exp2 ( 'et' exp2 )*
			{
			pushFollow(FOLLOW_exp2_in_exp11039);
			exp2();
			state._fsp--;

			// projet.g:149:14: ( 'et' exp2 )*
			loop41:
			while (true) {
				int alt41=2;
				int LA41_0 = input.LA(1);
				if ( (LA41_0==35) ) {
					alt41=1;
				}

				switch (alt41) {
				case 1 :
					// projet.g:149:15: 'et' exp2
					{
					match(input,35,FOLLOW_35_in_exp11042); 
					pushFollow(FOLLOW_exp2_in_exp11045);
					exp2();
					state._fsp--;

					}
					break;

				default :
					break loop41;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp1"



	// $ANTLR start "exp2"
	// projet.g:152:1: exp2 : ( 'non' exp2 | exp3 );
	public final void exp2() throws RecognitionException {
		try {
			// projet.g:152:7: ( 'non' exp2 | exp3 )
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==46) ) {
				alt42=1;
			}
			else if ( ((LA42_0 >= ID && LA42_0 <= INT)||LA42_0==10||LA42_0==13||LA42_0==15||LA42_0==38||LA42_0==55) ) {
				alt42=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 42, 0, input);
				throw nvae;
			}

			switch (alt42) {
				case 1 :
					// projet.g:152:9: 'non' exp2
					{
					match(input,46,FOLLOW_46_in_exp21063); 
					pushFollow(FOLLOW_exp2_in_exp21065);
					exp2();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:153:5: exp3
					{
					pushFollow(FOLLOW_exp3_in_exp21072);
					exp3();
					state._fsp--;

					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp2"



	// $ANTLR start "exp3"
	// projet.g:156:1: exp3 : exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? ;
	public final void exp3() throws RecognitionException {
		try {
			// projet.g:156:7: ( exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? )
			// projet.g:156:9: exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			{
			pushFollow(FOLLOW_exp4_in_exp31088);
			exp4();
			state._fsp--;

			// projet.g:157:3: ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			int alt43=7;
			switch ( input.LA(1) ) {
				case 22:
					{
					alt43=1;
					}
					break;
				case 21:
					{
					alt43=2;
					}
					break;
				case 23:
					{
					alt43=3;
					}
					break;
				case 24:
					{
					alt43=4;
					}
					break;
				case 19:
					{
					alt43=5;
					}
					break;
				case 20:
					{
					alt43=6;
					}
					break;
			}
			switch (alt43) {
				case 1 :
					// projet.g:157:5: '=' exp4
					{
					match(input,22,FOLLOW_22_in_exp31095); 
					pushFollow(FOLLOW_exp4_in_exp31099);
					exp4();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:158:5: '<>' exp4
					{
					match(input,21,FOLLOW_21_in_exp31106); 
					pushFollow(FOLLOW_exp4_in_exp31109);
					exp4();
					state._fsp--;

					}
					break;
				case 3 :
					// projet.g:159:5: '>' exp4
					{
					match(input,23,FOLLOW_23_in_exp31116); 
					pushFollow(FOLLOW_exp4_in_exp31120);
					exp4();
					state._fsp--;

					}
					break;
				case 4 :
					// projet.g:160:5: '>=' exp4
					{
					match(input,24,FOLLOW_24_in_exp31127); 
					pushFollow(FOLLOW_exp4_in_exp31130);
					exp4();
					state._fsp--;

					}
					break;
				case 5 :
					// projet.g:161:5: '<' exp4
					{
					match(input,19,FOLLOW_19_in_exp31137); 
					pushFollow(FOLLOW_exp4_in_exp31141);
					exp4();
					state._fsp--;

					}
					break;
				case 6 :
					// projet.g:162:5: '<=' exp4
					{
					match(input,20,FOLLOW_20_in_exp31148); 
					pushFollow(FOLLOW_exp4_in_exp31151);
					exp4();
					state._fsp--;

					}
					break;

			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp3"



	// $ANTLR start "exp4"
	// projet.g:166:1: exp4 : exp5 ( '+' exp5 | '-' exp5 )* ;
	public final void exp4() throws RecognitionException {
		try {
			// projet.g:166:7: ( exp5 ( '+' exp5 | '-' exp5 )* )
			// projet.g:166:9: exp5 ( '+' exp5 | '-' exp5 )*
			{
			pushFollow(FOLLOW_exp5_in_exp41173);
			exp5();
			state._fsp--;

			// projet.g:167:9: ( '+' exp5 | '-' exp5 )*
			loop44:
			while (true) {
				int alt44=3;
				int LA44_0 = input.LA(1);
				if ( (LA44_0==13) ) {
					alt44=1;
				}
				else if ( (LA44_0==15) ) {
					alt44=2;
				}

				switch (alt44) {
				case 1 :
					// projet.g:167:10: '+' exp5
					{
					match(input,13,FOLLOW_13_in_exp41185); 
					pushFollow(FOLLOW_exp5_in_exp41188);
					exp5();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:168:10: '-' exp5
					{
					match(input,15,FOLLOW_15_in_exp41200); 
					pushFollow(FOLLOW_exp5_in_exp41203);
					exp5();
					state._fsp--;

					}
					break;

				default :
					break loop44;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp4"



	// $ANTLR start "exp5"
	// projet.g:172:1: exp5 : primaire ( '*' primaire | 'div' primaire )* ;
	public final void exp5() throws RecognitionException {
		try {
			// projet.g:172:7: ( primaire ( '*' primaire | 'div' primaire )* )
			// projet.g:172:9: primaire ( '*' primaire | 'div' primaire )*
			{
			pushFollow(FOLLOW_primaire_in_exp51229);
			primaire();
			state._fsp--;

			// projet.g:173:9: ( '*' primaire | 'div' primaire )*
			loop45:
			while (true) {
				int alt45=3;
				int LA45_0 = input.LA(1);
				if ( (LA45_0==12) ) {
					alt45=1;
				}
				else if ( (LA45_0==32) ) {
					alt45=2;
				}

				switch (alt45) {
				case 1 :
					// projet.g:173:14: '*' primaire
					{
					match(input,12,FOLLOW_12_in_exp51245); 
					pushFollow(FOLLOW_primaire_in_exp51249);
					primaire();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:174:13: 'div' primaire
					{
					match(input,32,FOLLOW_32_in_exp51264); 
					pushFollow(FOLLOW_primaire_in_exp51267);
					primaire();
					state._fsp--;

					}
					break;

				default :
					break loop45;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp5"



	// $ANTLR start "primaire"
	// projet.g:178:1: primaire : ( valeur | ident | '(' expression ')' );
	public final void primaire() throws RecognitionException {
		try {
			// projet.g:178:9: ( valeur | ident | '(' expression ')' )
			int alt46=3;
			switch ( input.LA(1) ) {
			case INT:
			case 13:
			case 15:
			case 38:
			case 55:
				{
				alt46=1;
				}
				break;
			case ID:
				{
				alt46=2;
				}
				break;
			case 10:
				{
				alt46=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}
			switch (alt46) {
				case 1 :
					// projet.g:178:11: valeur
					{
					pushFollow(FOLLOW_valeur_in_primaire1291);
					valeur();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:179:5: ident
					{
					pushFollow(FOLLOW_ident_in_primaire1298);
					ident();
					state._fsp--;

					}
					break;
				case 3 :
					// projet.g:180:5: '(' expression ')'
					{
					match(input,10,FOLLOW_10_in_primaire1306); 
					pushFollow(FOLLOW_expression_in_primaire1308);
					expression();
					state._fsp--;

					match(input,11,FOLLOW_11_in_primaire1310); 
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "primaire"



	// $ANTLR start "valeur"
	// projet.g:183:1: valeur : ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' );
	public final void valeur() throws RecognitionException {
		try {
			// projet.g:183:9: ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' )
			int alt47=5;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt47=1;
				}
				break;
			case 13:
				{
				alt47=2;
				}
				break;
			case 15:
				{
				alt47=3;
				}
				break;
			case 55:
				{
				alt47=4;
				}
				break;
			case 38:
				{
				alt47=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}
			switch (alt47) {
				case 1 :
					// projet.g:183:11: nbentier
					{
					pushFollow(FOLLOW_nbentier_in_valeur1324);
					nbentier();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:184:5: '+' nbentier
					{
					match(input,13,FOLLOW_13_in_valeur1331); 
					pushFollow(FOLLOW_nbentier_in_valeur1333);
					nbentier();
					state._fsp--;

					}
					break;
				case 3 :
					// projet.g:185:5: '-' nbentier
					{
					match(input,15,FOLLOW_15_in_valeur1340); 
					pushFollow(FOLLOW_nbentier_in_valeur1342);
					nbentier();
					state._fsp--;

					}
					break;
				case 4 :
					// projet.g:186:5: 'vrai'
					{
					match(input,55,FOLLOW_55_in_valeur1349); 
					}
					break;
				case 5 :
					// projet.g:187:5: 'faux'
					{
					match(input,38,FOLLOW_38_in_valeur1356); 
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "valeur"



	// $ANTLR start "nbentier"
	// projet.g:197:1: nbentier : INT ;
	public final void nbentier() throws RecognitionException {
		Token INT1=null;

		try {
			// projet.g:197:11: ( INT )
			// projet.g:197:15: INT
			{
			INT1=(Token)match(input,INT,FOLLOW_INT_in_nbentier1385); 
			 UtilLex.valEnt = Integer.parseInt((INT1!=null?INT1.getText():null));
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "nbentier"



	// $ANTLR start "ident"
	// projet.g:199:1: ident : ID ;
	public final void ident() throws RecognitionException {
		Token ID2=null;

		try {
			// projet.g:199:7: ( ID )
			// projet.g:199:9: ID
			{
			ID2=(Token)match(input,ID,FOLLOW_ID_in_ident1396); 
			 UtilLex.traiterId((ID2!=null?ID2.getText():null)); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ident"

	// Delegated rules



	public static final BitSet FOLLOW_unitprog_in_unite64 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_unite67 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unitmodule_in_unite80 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_unite83 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_unitprog98 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitprog100 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_unitprog102 = new BitSet(new long[]{0x00450000E0000000L});
	public static final BitSet FOLLOW_declarations_in_unitprog111 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_corps_in_unitprog120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_unitmodule137 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitmodule139 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_unitmodule141 = new BitSet(new long[]{0x00450000A0000000L});
	public static final BitSet FOLLOW_declarations_in_unitmodule149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_partiedef_in_declarations167 = new BitSet(new long[]{0x0045000020000002L});
	public static final BitSet FOLLOW_partieref_in_declarations170 = new BitSet(new long[]{0x0041000020000002L});
	public static final BitSet FOLLOW_consts_in_declarations173 = new BitSet(new long[]{0x0041000000000002L});
	public static final BitSet FOLLOW_vars_in_declarations176 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_decprocs_in_declarations179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_partiedef196 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef198 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_14_in_partiedef202 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef204 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_ptvg_in_partiedef209 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_partieref221 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref224 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_14_in_partieref227 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref229 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_ptvg_in_partieref233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_specif247 = new BitSet(new long[]{0x0000120000000002L});
	public static final BitSet FOLLOW_41_in_specif252 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_specif254 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif256 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_specif261 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif263 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_specif269 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_44_in_specif294 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_specif297 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif299 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_specif304 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif306 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_specif312 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_consts330 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_consts334 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_consts337 = new BitSet(new long[]{0x008000400000A040L});
	public static final BitSet FOLLOW_valeur_in_consts339 = new BitSet(new long[]{0x0000000000040020L});
	public static final BitSet FOLLOW_ptvg_in_consts342 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_54_in_vars361 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_vars365 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars367 = new BitSet(new long[]{0x0000000408044000L});
	public static final BitSet FOLLOW_14_in_vars372 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars375 = new BitSet(new long[]{0x0000000408044000L});
	public static final BitSet FOLLOW_ptvg_in_vars381 = new BitSet(new long[]{0x0000000408000002L});
	public static final BitSet FOLLOW_decproc_in_decprocs425 = new BitSet(new long[]{0x0001000000040000L});
	public static final BitSet FOLLOW_ptvg_in_decprocs427 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_48_in_decproc443 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_decproc446 = new BitSet(new long[]{0x0040120060000000L});
	public static final BitSet FOLLOW_parfixe_in_decproc449 = new BitSet(new long[]{0x0040100060000000L});
	public static final BitSet FOLLOW_parmod_in_decproc452 = new BitSet(new long[]{0x0040000060000000L});
	public static final BitSet FOLLOW_consts_in_decproc455 = new BitSet(new long[]{0x0040000040000000L});
	public static final BitSet FOLLOW_vars_in_decproc458 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_corps_in_decproc461 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_ptvg476 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_corps494 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_corps496 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_corps498 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_parfixe510 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_parfixe512 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pf_in_parfixe514 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_18_in_parfixe518 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pf_in_parfixe520 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_11_in_parfixe524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pf538 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf540 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_pf545 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf547 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_44_in_parmod565 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_parmod567 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pm_in_parmod569 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_18_in_parmod573 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pm_in_parmod575 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_11_in_parmod579 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pm593 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm595 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_pm600 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm602 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_instruction_in_instructions621 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_18_in_instructions625 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instruction_in_instructions627 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_inssi_in_instruction644 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inscond_in_instruction650 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boucle_in_instruction656 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lecture_in_instruction662 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ecriture_in_instruction668 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_affouappel_in_instruction674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_inssi691 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_inssi693 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_inssi695 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inssi697 = new BitSet(new long[]{0x0010040000000000L});
	public static final BitSet FOLLOW_52_in_inssi700 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inssi703 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_inssi707 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_inscond721 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_inscond724 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_inscond727 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inscond729 = new BitSet(new long[]{0x0000008004004000L});
	public static final BitSet FOLLOW_14_in_inscond743 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_inscond746 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_inscond749 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inscond751 = new BitSet(new long[]{0x0000008004004000L});
	public static final BitSet FOLLOW_26_in_inscond768 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inscond771 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_inscond789 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_boucle804 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_boucle807 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_boucle809 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_boucle811 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_boucle813 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_lecture826 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_lecture828 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture830 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_lecture835 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture837 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_lecture843 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_ecriture856 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_ecriture858 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_ecriture860 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_ecriture865 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_ecriture867 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_ecriture873 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_affouappel889 = new BitSet(new long[]{0x0000000000020402L});
	public static final BitSet FOLLOW_17_in_affouappel897 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_affouappel899 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_effixes_in_affouappel919 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_effmods_in_affouappel922 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_effixes954 = new BitSet(new long[]{0x008040400000AC60L});
	public static final BitSet FOLLOW_expression_in_effixes957 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_effixes961 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_effixes963 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_effixes971 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_effmods983 = new BitSet(new long[]{0x0000000000000820L});
	public static final BitSet FOLLOW_ident_in_effmods986 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_effmods990 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_effmods992 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_effmods1000 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp1_in_expression1014 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_47_in_expression1018 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_exp1_in_expression1021 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_exp2_in_exp11039 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_35_in_exp11042 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_exp2_in_exp11045 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_46_in_exp21063 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_exp2_in_exp21065 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp3_in_exp21072 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp4_in_exp31088 = new BitSet(new long[]{0x0000000001F80002L});
	public static final BitSet FOLLOW_22_in_exp31095 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31099 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_exp31106 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31109 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_exp31116 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_exp31127 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31130 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_exp31137 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31141 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_exp31148 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31151 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp5_in_exp41173 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_13_in_exp41185 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp5_in_exp41188 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_15_in_exp41200 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp5_in_exp41203 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_primaire_in_exp51229 = new BitSet(new long[]{0x0000000100001002L});
	public static final BitSet FOLLOW_12_in_exp51245 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_primaire_in_exp51249 = new BitSet(new long[]{0x0000000100001002L});
	public static final BitSet FOLLOW_32_in_exp51264 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_primaire_in_exp51267 = new BitSet(new long[]{0x0000000100001002L});
	public static final BitSet FOLLOW_valeur_in_primaire1291 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_primaire1298 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_primaire1306 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_primaire1308 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_primaire1310 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nbentier_in_valeur1324 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_valeur1331 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur1333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_valeur1340 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur1342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_valeur1349 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_valeur1356 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_nbentier1385 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_ident1396 = new BitSet(new long[]{0x0000000000000002L});
}
