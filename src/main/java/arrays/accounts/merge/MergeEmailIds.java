package arrays.accounts.merge;

import com.sun.scenario.effect.Merge;

import java.util.*;


//[["David","David0@m.co","David1@m.co"],["David","David3@m.co","David4@m.co"],["David","David4@m.co","David5@m.co"],
// ["David","David2@m.co","David3@m.co"],["David","David1@m.co","David2@m.co"]]

public class MergeEmailIds {
    public static void main(String[] args) {
        System.out.println(new MergeEmailIds().accountsMerge(new LinkedList<List<String>>() {
            {
                add(new LinkedList<String>(){
                    {
                        add("Raj");
                        add("rajesh1");
                        add("rajesh2");
                        add("rajesh3");
                    }
                });
                add(new LinkedList<String>(){
                    {
                        add("Raj");
                        add("rajesh4");
                        add("rajesh6");
                        add("rajesh5");
                    }
                });
                add(new LinkedList<String>(){
                    {
                        add("Raj");
                        add("rajesh8");
                        add("rajesh2");
                        add("rajesh7");
                    }
                });
                add(new LinkedList<String>(){
                    {
                        add("Raj");
                        add("rajesh8");
                        add("rajesh10");
                        add("rajesh9");
                    }
                });
                add(new LinkedList<String>(){
                    {
                        add("Raj");
                        add("rajesh9");
                        add("rajesh11");
                        add("rajesh12");
                    }
                });
            }
        }));

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
                    merge(user, account, emailUserMap.get(account.get(i)), mergedMap, emailUserMap);
                    flag = true;
                    break;
                }
            }

            if(!flag)
                merge(user, account, user, mergedMap, emailUserMap);
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

    public void merge(StringCustom newUser, List<String> account, StringCustom origUserA, Map<StringCustom, Set<String>> mergedMap, Map<String, StringCustom> emailUserMap) {
        Set<String> emailIds = new TreeSet<>();
        List<StringCustom> oldUser = new LinkedList<>();
        oldUser.add(origUserA);

        for(int i = 1; i < account.size(); i++) {
            if(emailUserMap.containsKey(account.get(i))) {
                oldUser.add(emailUserMap.get(account.get(i)));
            }
            emailUserMap.put(account.get(i), newUser);
            emailIds.add(account.get(i));
        }

        for(StringCustom origUser : oldUser) {
            if (mergedMap.containsKey(origUser)) {
                for (String emailId : mergedMap.get(origUser)) {
                    emailUserMap.put(emailId, newUser);
                    emailIds.add(emailId);
                }
                mergedMap.remove(origUser);
            }
        }

        mergedMap.put(newUser, emailIds);
    }
}
