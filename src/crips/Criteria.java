/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crips;

/**
 *
 * @author EJ Ortega
 */
public class Criteria {
    
    public long getSpeed(long startTime) {
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        return totalTime;
    }
    
    public long getMemoryCost() {
        Runtime rt = Runtime.getRuntime();
//        System.out.println(algo + " Memory used before: " + usedBefore + " bytes");
        return rt.totalMemory() - rt.freeMemory();   
//        System.out.println(algo + " Memory used after: " + usedAfter + " bytes");
    }
    
    public long getSecurity(String plainText, String cipher) {
        plainText=plainText.substring(0,plainText.length()/20000).toLowerCase();
        cipher=cipher.substring(0,plainText.length()).toLowerCase();
       
        long c=0;
        int i=0;
        String result="";
        while (!result.equals(plainText))
        {
            int d=(int)cipher.charAt(i);
            int p=(int)plainText.charAt(i);
            int add=0;
            if (p>d)
                add=1;
            else
               add=-1;
            while (d!=p)
            {
                d+=add;
                c++;
            }
            result=result+(char)p;
            i++;
        }
        return c;
    }
}
