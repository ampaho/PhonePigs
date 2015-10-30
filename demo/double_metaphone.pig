DEFINE DMETAPHONE bj.jolome.research.pig.phonetics.PhonePigs.DMETAPHONE;

REGISTER PhonePigs.jar;
A = LOAD 'client_names' as (name:chararray);
B = FOREACH A GENERATE DMETAPHONE(name) as sound, name;
C = group B by sound;
DUMP C;
