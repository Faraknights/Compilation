programme simple: {test de si}

	const cinq=5;
	var ent resultat;

debut
	si cinq=4 alors 
	resultat:=1 
	sinon
	si cinq=3 alors 
	resultat:=2 
	sinon
	resultat:=3 
	fsi;
	fsi;
	ecrire(resultat);
fin
