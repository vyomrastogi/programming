package com.practice.programming.hrank.hrhashtables;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class SherlockAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
      
        Hashtable<Integer[],Integer> sigArrMap = new Hashtable<Integer[],Integer>();
        //number of substring possible
        for(int range=1; range<=s.length()-1; range++){           
            for(int i=0;i<=s.length(); i++){
                Integer[] sigArr = new Integer[26];
                if(i<=s.length()-range){
                    String subString = s.substring(i,i+range);
                    for (int j=0;j<subString.length();j++){
                        System.out.println(subString);
                        char[] subStringArr = subString.toCharArray();
                        if(sigArr[subStringArr[j]-'a']==null) {
                        	sigArr[subStringArr[j]-'a'] = 1;
                        }else {
                        	sigArr[subStringArr[j]-'a']++;
                        }
                        
                    }
                    if(!sigArrMap.containsKey(sigArr)){
                        sigArrMap.put(sigArr,1);
                    }else {
                        sigArrMap.put(sigArr,sigArrMap.get(sigArr)+1);
                    }                    
                }              
                
            }
        }
        int numberOfAnagram = 0;
        for (Map.Entry<Integer[],Integer> e : sigArrMap.entrySet()){
            numberOfAnagram += (e.getValue()*(e.getValue()-1)/2);
        }

        return  numberOfAnagram;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(result);
            
           /* bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();*/
        }

       // bufferedWriter.close();

        scanner.close();
    }
}
