DEFINE RSOUNDEX bj.jolome.research.pig.phonetics.PhonePigs.RSOUNDEX;

REGISTER PhonePigs.jar;
A = LOAD 'client_names' as (name:chararray);
B = FOREACH A GENERATE RSOUNDEX(name) as sound, name;
C = group B by sound;
DUMP C;
