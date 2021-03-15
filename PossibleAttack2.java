import java.util.*;
import java.io.*;
public class Main {
  static ArrayList<String> Sarr=new ArrayList<String>();
  public static void main(String args[]) throws IOException {
    Scanner sc=new Scanner(System.in);
    int size=sc.nextInt();
    int[] arr=new int[size];
    int[] freq=new int[52];
    for(int i=0;i<size;i++){
      arr[i]=sc.nextInt();
      freq[arr[i]]++;
    }
    Arrays.sort(arr);
    backTracking(freq,arr,"",0);
  }
  static void backTracking(int[] freq,int[] arr,String res,int count){
    if(count==arr.length){
      if(!Sarr.contains(res)){
        System.out.println(res);
        Sarr.add(res);
      }
    }
    else{
      for(int i=0;i<arr.length;i++){
        if(freq[arr[i]]>0){
          freq[arr[i]]--;
          backTracking(freq,arr,res+arr[i]+" ",count+1);
          freq[arr[i]]++;
        }
      }
    }
  }
}
