DEFINE METAPHONE bj.jolome.research.pig.phonetics.PhonePigs.METAPHONE;

REGISTER PhonePigs.jar;
A = LOAD 'client_names' as (name:chararray);
B = FOREACH A GENERATE METAPHONE(name) as sound, name;
C = group B by sound;
DUMP C;
