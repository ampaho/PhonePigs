package bj.jolome.research.pig.phonetics.PhonePigs;

import org.apache.commons.codec.language.Metaphone;
import java.io.IOException;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

public class METAPHONE extends EvalFunc<String> {
	
	public String exec(Tuple input) throws IOException {
		if (input.size() == 0)
			return null;
		try {
			String str = (String) input.get(0);
			str = new Metaphone().metaphone(str);
			return str;

		} catch (Exception e) {
			throw new RuntimeException(
					"Caught exception processing input row: "+ ((String) input.get(0))+" ", e);
		}
	}

}

