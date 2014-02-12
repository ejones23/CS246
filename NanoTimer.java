public class NanoTimer {
   public static void main(String args[]){
      while(true) {
         System.out.println(System.nanoTime());
      }
   }
}
//Sampled differences:
//4093
//4039
//14080
//3938
//Median: about 4 microseconds.