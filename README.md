##PhonePigs
Reads /fəˈnɛpɪgs/ is a Pig UDF for phonetic matching algorithm. It will extend to some string matching algorithms that play nice when combined with soundex, caverphone, etc...



##Demo

Given this list of names (names.txt) , we want to group together names that sound the same:

	Yurgen
	Aboubakar
	Bridget
	Alan
	Allan
	Alaan
	Abubacar
	Bridgitt
	Jürgen


Run this Pig script:


	DEFINE SOUNDEX bj.jolome.research.pig.phonetics.PhonePigs.SOUNDEX;
	REGISTER PhonePigs.jar;
	A = LOAD 'names.txt' as (name:chararray);
	B = FOREACH A GENERATE SOUNDEX(name) as sound, name;
	C = group B by sound;
	DUMP C;

We get this:

	(A112,{(A112,Abubacar),(A112,Aboubakar)})
	(A450,{(A450,Alaan),(A450,Allan),(A450,Alan)})
	(B632,{(B632,Bridgitt),(B632,Bridget)})
	(J625,{(J625,Jürgen)})
	(Y625,{(Y625,Yurgen)})
	
If we use CAVERPHONE instead, you get a better result for this specific data:

	(ALN1111111,{(ALN1111111,Alaan),(ALN1111111,Allan),(ALN1111111,Alan)})
	(APPKA11111,{(APPKA11111,Abubacar),(APPKA11111,Aboubakar)})
	(PRKT111111,{(PRKT111111,Bridgitt),(PRKT111111,Bridget)})
	(YKN1111111,{(YKN1111111,Jürgen),(YKN1111111,Yurgen)})

##Acknowledgements
I originally wrote started this project for Jolome Benin to remove duplicates from the LEPI (Liste Electorale Permanente Informatisée) for Electoral Ballots in Benin Republic. I also used it for WhyInside.com (GrubHub for latin restaurants). It's lightweight and plays nice with DataFu.