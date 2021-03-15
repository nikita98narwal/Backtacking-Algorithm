import java.util.*;
  import java.io.*;

  public class Main {
    public static void main(String args[]) throws IOException {

      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      for(int i=0;i<n;i=i+1)
      {
        String s=sc.next();
        String [] array={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        recursion(array,s,0,"");
        System.out.println();
      }
    }

    static void recursion(String array[],String s,int index,String str)
    {
      if(index==s.length())
      {
        System.out.print(str+" ");
        return;
      }

      String temp=array[s.charAt(index)-'0'];
      for(int i=0;i<temp.length();i=i+1)
      {
        recursion(array,s,index+1,str+temp.charAt(i));
      }
    }
  }
