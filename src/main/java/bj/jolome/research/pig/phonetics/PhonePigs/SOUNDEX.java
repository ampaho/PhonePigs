package bj.jolome.research.pig.phonetics.PhonePigs;

import org.apache.commons.codec.language.Soundex;
import java.io.IOException;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import java.text.Normalizer;

public class SOUNDEX extends EvalFunc<String> {
	
	//private final static String ACCENTS = "ŠS ŽZ šs žz ŸY ÀA ÁA ÂA ÃA ÄA ÅA ÇC ÈE ÉE ÊE ËE ÌI ÍI ÎI ÏI ÑN ÒO ÓO ÔO ÕO ÖO ØO ÙU ÚU ÛU ÜU ÝY àa áa âa ãa äa åa çc èe ée êe ëe ìi íi îi ïi ñn òo óo ôo õo öo øo ùu úu ûu üu ýy µu ÞTH þth ÐDH ðdh ßss ŒOE œoe ÆAE æae";
	//static public final char[] US_ENGLISH_SOUNDEX_MAPPING = "01230120022455012623010202".toCharArray();

	public String exec(Tuple input) throws IOException {
		if (input.size() == 0)
			return null;
		try {
			String str = (String) input.get(0);
			str = Normalizer.normalize(str, Normalizer.Form.NFD);
			str = str.replaceAll("[^\\p{ASCII}]", "");
			str = new Soundex().soundex(str);
			return str;

		} catch (Exception e) {
			throw new RuntimeException(
					"Caught exception processing input row: "+ ((String) input.get(0))+" ", e);
		}
	}

}
