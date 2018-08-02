package arrays.accounts.merge;

import java.util.*;

public class MergeEmailIds {
    public static void main(String[] args) {
        System.out.println();

    }

    public class StringCustom {
        public String str;
        public StringCustom(String str) {
            this.str = str;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<StringCustom, Set<String>> mergedMap = new HashMap<>();
        Map<String, StringCustom> emailUserMap = new HashMap<>();

        for(List<String> account : accounts) {
            if(account.size() == 1) {
                mergedMap.put(new StringCustom(account.get(0)), new TreeSet<>());
            }

            StringCustom user = new StringCustom(account.get(0));
            boolean flag = false;

            for(int i = 1; i < account.size(); i++) {
                if(emailUserMap.containsKey(account.get(i))) {
                    merge(account, emailUserMap.get(account.get(i)), mergedMap, emailUserMap);
                    flag = true;
                    break;
                }
            }

            if(!flag)
                merge(account, user, mergedMap, emailUserMap);
        }

        List<List<String>> finalList = new LinkedList<>();

        for(StringCustom key : mergedMap.keySet()) {
            List<String> emailList = new LinkedList<>();
            emailList.add(key.str);

            for(String email : mergedMap.get(key)) {
                emailList.add(email);
            }
            finalList.add(emailList);
        }

        return finalList;
    }

    public void merge(List<String> account, StringCustom user, Map<StringCustom, Set<String>> mergedMap, Map<String, StringCustom> emailUserMap) {
        Set<String> emailIds;
        if(mergedMap.containsKey(user)) {
            emailIds = mergedMap.get(user);
        } else {
            emailIds = new TreeSet<>();
        }

        for(int i = 1; i < account.size(); i++) {
            emailUserMap.put(account.get(i), user);
            emailIds.add(account.get(i));
        }

        mergedMap.put(user, emailIds);
    }
}
