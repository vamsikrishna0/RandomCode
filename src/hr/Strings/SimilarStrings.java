package hr.Strings;

import java.util.*;

public class SimilarStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        String s = in.next();
        while (q > 0) {
            int li = in.nextInt();
            int ri = in.nextInt();
            int lenSub = ri - li + 1;

            //Get the substring for this query. 'str'.
            //The similar words' indices are grouped using a HashMap of Arraylist
            String str = s.substring(li - 1, ri);
            boolean[] setOfDissismilarIndices = new boolean[lenSub];
            HashMap<Character, ArrayList<Integer>> freq = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char temp = str.charAt(i);
                if (freq.containsKey(temp)) {
                    freq.get(temp).add(i);
                } else {
                    ArrayList<Integer> x = new ArrayList<>();
                    x.add(i);
                    setOfDissismilarIndices[i] = true;
                    freq.put(temp, x);
                }
            }

//            ArrayList<Integer> setOfDissismilarIndices =  new ArrayList<>();

            HashMap<Integer, ArrayList<Integer>> setOfSimilarIndices = new HashMap<>();
            for (ArrayList<Integer> sim : freq.values()) {
                int firstInt = sim.get(0);
                if(sim.size() > 1){
                    setOfSimilarIndices.put(firstInt, sim);
                }
            }

            //Empty the hashmap for grabage collector
            freq = null;

            //Here count is the number of similar strings. Its initialized to 0;
            int count = 0;

            //Test for 'similarity', according to the problem, of the string.
            for (int i = 0; i <= n - lenSub; i++) {
                String temp = s.substring(i, i + lenSub);
                HashSet<Character> setOfFirstChars = new HashSet<>();
                boolean isSimilar = true;
                char firstCharOfGroup;

                //Checking each substring to check if it is similar
                for (int j = 0; j < lenSub; j++) {

                    if(setOfDissismilarIndices[j]){
                        //The first char of this group is obtained: firstCharOfGroup
                        firstCharOfGroup = temp.charAt(j);

                        //Check if its dissimilar to the set of already obtained values.
                        if (setOfFirstChars.contains(firstCharOfGroup)) {
                            //If yes, then break. Its not similar
                            isSimilar = false;
                            break;
                        } else {
                            //Else add it to the set and proceed.
                            setOfFirstChars.add(firstCharOfGroup);
                        }
                    }


                }

                if(isSimilar){
                    for (Map.Entry<Integer, ArrayList<Integer>> sim : setOfSimilarIndices.entrySet()) {
                        //The first char of this group is obtained: firstCharOfGroup
                        firstCharOfGroup = temp.charAt(sim.getKey());

                        //Check for the chars of each group to be similar to each other.
                            for (int j = 0; j < sim.getValue().size(); j++) {
                                if (temp.charAt(sim.getValue().get(j)) != firstCharOfGroup) {
                                    isSimilar = false;
                                    break;
                                }
                            }

                        //To break the outer loop.
                        if (!isSimilar) break;
                    }
                } else{
                    continue;
                }


                if (isSimilar) {
                    //System.out.println(temp);
                    count++;
                }
            }
            System.out.println(count);

            q--;
        }
    }
}
