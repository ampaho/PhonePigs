##PhonePigs
Reads /fəˈnɛpɪgs/ is a Pig UDF for phonetic matching algorithm. It will extend to some string matching algorithms that play nice when combined with soundex, caverphone, etc...



##Demo

Given this list of names (names.txt) , we want to group together names that sound the same:

	Aboubakar
	Bridget
	Alan
	Allan
	Alaan
	Abubacar
	Bridgitt

Run this Pig script:


	REGISTER PhonePig.jar;
	A = LOAD 'names.txt' as (name:chararray);
	B = FOREACH A GENERATE SOUNDEX(name) as sound, name;
	C = group B by sound;
	DUMP C;

We get this:

	(A112,{(A112,Abubacar),(A112,Aboubakar)})
	(A450,{(A450,Alaan),(A450,Allan),(A450,Alan)})
	(B632,{(B632,Bridgitt),(B632,Bridget)})
	

##Acknowledgements
I originally wrote started this project for Jolome Benin to remove duplicates from the LEPI (Liste Electorale Permanente Informatisée) for Electoral Ballots. I also used it for WhyInside.com (GrubHub for latin restaurants).##