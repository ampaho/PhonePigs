DEFINE SOUNDEX bj.jolome.research.pig.phonetics.PhonePigs.SOUNDEX;

REGISTER PhonePigs.jar;
A = LOAD 'client_names' as (name:chararray);
B = FOREACH A GENERATE SOUNDEX(name) as sound, name;
C = group B by sound;
DUMP C;
