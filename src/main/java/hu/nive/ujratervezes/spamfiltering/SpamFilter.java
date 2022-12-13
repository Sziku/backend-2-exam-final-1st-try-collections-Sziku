package hu.nive.ujratervezes.spamfiltering;

import java.util.*;

public class SpamFilter {
    private HashSet<String> whitelist;
    private HashSet<String> blacklist;

    public SpamFilter(List<String> whitelist, List<String> blacklist) throws IllegalArgumentException {
        if (whitelist == null || blacklist == null) {
            throw new IllegalArgumentException();
        }
        this.whitelist = new HashSet<>(whitelist);
        this.blacklist = new HashSet<>(blacklist);
    }

    public List<List<String>> applyRules(List<List<String>> sentence) {
        List<List<String>> passedSentence = new ArrayList<>();
        List<List<String>> tempSentence = new ArrayList<>();

        if (blacklist.size() > 0) {
            for (List<String> strings : sentence) {
                for (String badWord : blacklist) {
                    if (strings.contains(badWord)) {
                        break;
                    } else {
                        tempSentence.add(strings);
                    }
                }
            }
        }else{
            tempSentence = passedSentence;
        }

        if (tempSentence.size() > 0) {
            for (List<String> strings : tempSentence) {
                for (String goodWord : whitelist) {
                    if (tempSentence.contains(goodWord)) {
                        passedSentence.add(strings);
                        break;
                    }
                }
            }
        }

        return passedSentence;
    }
}
