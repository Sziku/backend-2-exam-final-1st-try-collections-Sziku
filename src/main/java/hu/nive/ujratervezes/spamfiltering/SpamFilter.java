package hu.nive.ujratervezes.spamfiltering;

import java.util.*;

public class SpamFilter {
    private  List<String>  whitelist;
    private  List<String>  blacklist;

    public SpamFilter(List<String> whitelist, List<String> blacklist) throws IllegalArgumentException{
        if(whitelist == null || blacklist == null){
            throw new IllegalArgumentException();
        }

        this.whitelist = whitelist;
        this.blacklist = blacklist;
    }

    public List<List<String>> applyRules(List<List<String>> sentence){
        List<List<String>> passedSentence = new ArrayList<>();

        for (List<String> strings : sentence) {
            for (String badWord : blacklist) {
                if (strings.contains(badWord)) {
                    break;
                }
            }

            for (String goodWord : whitelist) {
                if (strings.contains(goodWord)) {
                    passedSentence.add(strings);
                    break;
                }
            }

        }
        return passedSentence;
    }
}
