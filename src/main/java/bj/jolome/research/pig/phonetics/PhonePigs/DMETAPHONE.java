package bj.jolome.research.pig.phonetics.PhonePigs;

import org.apache.commons.codec.language.DoubleMetaphone;
import java.io.IOException;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

public class DMETAPHONE extends EvalFunc<String> {
	
	public String exec(Tuple input) throws IOException {
		if (input.size() == 0)
			return null;
		try {
			String str = (String) input.get(0);
			str = new DoubleMetaphone().doubleMetaphone(str);
			return str;

		} catch (Exception e) {
			throw new RuntimeException(
					"Caught exception processing input row: "+ ((String) input.get(0))+" ", e);
		}
	}

}

