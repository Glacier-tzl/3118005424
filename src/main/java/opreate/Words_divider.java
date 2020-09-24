package Util;




import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.SpeedTokenizer;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

import java.io.IOException;
import java.util.*;

public class Words_divider {


    //分词
    public HashMap<String,Integer> division(String sentence) throws IOException {
        List<Term> termList= StandardTokenizer.segment(sentence);
        HashMap<String,Integer> word=new HashMap<>();
        for (Term term : termList) {
            int times=0;
            if(word.containsKey(term.word)){
                times=word.get(term.word);
                word.put(term.word,times+1);
            }else{
                word.put(term.word,1);
            }
        }
        return word;
    }
    
    //引入句子
    public List<String> getPhrase(String str1,String str2){
        HashSet<String> phraseSet= new HashSet<>();
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(str1);
        stringBuilder.append(str2);
        List<String> phrase=null;
        List<Term> termList= SpeedTokenizer.segment(stringBuilder.toString());
        for (Term term : termList) {
            phraseSet.add(term.word);
        }
        phrase=Arrays.asList(phraseSet.toArray(new String[0]));
        return phrase;
    }
    
}
