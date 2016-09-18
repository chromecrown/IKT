import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class IKTest {

	public static void main(String[] args) {
		String text = "lxw的大数据田地 -- lxw1234.com 专注Hadoop、Spark、Hive等大数据技术博客。 北京优衣库";
		Analyzer analyzer = new IKAnalyzer(true);
		System.out.println("now ------------");
		StringReader reader = new StringReader(text);
		TokenStream ts = analyzer.tokenStream("",reader);
		CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
		try {
			while(ts.incrementToken()){
				System.out.println(term.toString()+"|");
			}
			analyzer.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
