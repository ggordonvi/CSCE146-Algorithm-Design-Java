import java.util.*;

public class BortSort {
        public static void main(String[] args) {
                // TODO Auto-generated method stub
                String[] bortArray = {"Bort","asdf","asdfbort","asdfasdfbortBortBORTbort","bortbortbortbortBORTBORTBORTBORT","qwertqwertqwertqwertbortBORT","bortzilla","bortderbort","bored"};
                System.out.println("Unsorted\n");
                for(String bortString : bortArray)
                {
                        System.out.println(bortString);
                }
                String[] bortSorted = new String[bortArray.length];
                System.out.println("\nBORT SORTED!!!\n");
                bortSorted = bortSort(bortArray);
                for(String bortString : bortSorted)
                {
                        System.out.println(bortString);
                }
        }
        private static class BortCountUnit
        {
                private String bortWord;
                private int bortCount;
                public BortCountUnit()
                {
                        this.bortWord = "";
                        this.bortCount = 0;
                }
               public static int bortCount(String bort){
                   int count = 0;
                   int begin = 0;
                   for(int i=0; i<bort.length(); i++){
                       int index = bort.toUpperCase().indexOf("BORT",begin);
                       if(index == -1) return count;
                       count++;
                       begin = index+1;
                   }
                   return 0;
               }
        }
        public static String[] bortSort(String[] bortArray)
        {
           String[] bortSorted = new String[bortArray.length];
           BortCountUnit BCU = new BortCountUnit();
           for(int i=0; i<bortArray.length; i++)
           bortSorted[i] = bortArray[i];
           boolean swap = true;
           int index = 0;
           while(swap){
               swap = false;
               index++;
               for(int i=0; i<bortSorted.length-index; i++){
                   if(BCU.bortCount(bortSorted[i]) > BCU.bortCount(bortSorted[i+1])){
                       String temp = bortSorted[i];
                       bortSorted[i] = bortSorted[i+1];
                       bortSorted[i+1] = temp;
                       swap = true;
                   }
               }
           }
           return bortSorted;
        }
}