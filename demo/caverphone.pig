DEFINE CAVERPHONE bj.jolome.research.pig.phonetics.PhonePigs.CAVERPHONE;

REGISTER PhonePigs.jar;
A = LOAD 'client_names' as (name:chararray);
B = FOREACH A GENERATE CAVERPHONE(name) as sound, name;
C = group B by sound;
DUMP C;
--ILLUSTRATE C;
