package bj.jolome.research.pig.phonetics.PhonePigs;

import org.apache.commons.codec.language.RefinedSoundex;

import java.io.IOException;
import java.text.Normalizer;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

//Refined Soundex
public class RSOUNDEX extends EvalFunc<String> {
	public String exec(Tuple input) throws IOException {
		if (input.size() == 0)
			return null;
		try {
			String str = (String) input.get(0);
			str = Normalizer.normalize(str, Normalizer.Form.NFD);
			str = str.replaceAll("[^\\p{ASCII}]", "");
			str = new RefinedSoundex().soundex(str);
			return str;
 
		} catch (Exception e) {
			throw new RuntimeException(
					"Caught exception processing input row ", e);
		}
	}
 
}