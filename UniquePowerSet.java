import java.util.*;
  import java.io.*;

  public class Main {
    //static ArrayList<Integer>answer=new ArrayList<>();
    public static void main(String args[]) throws IOException {

      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int array[]=new int[n];
      for(int i=0;i<n;i=i+1)
      {
        array[i]=sc.nextInt();
      }
      int set[]=new int[n];
      int visited[]=new int[1000];
      for(int i=0;i<n;i=i+1)
      {
        visited[array[i]]=visited[array[i]]+1;
      }
      Arrays.sort(array);
      recursion(array,visited,set,0,0);
    }

    static void recursion(int array[],int visited[],int set[],int position,int current)
    {
      if(current!=0)
      print(set,current);

      for(int i=position;i<array.length;i=i+1)
      {
        if(visited[array[i]]==0 )
        {
          continue;
        }
        if(i!=0 && array[i]==array[i-1])
          continue;
        set[current]=array[i];
        visited[array[i]]-=1;
        recursion(array,visited,set,i,current+1);
        visited[array[i]]+=1;
      }
    }

    static void print(int set[],int current)
    {
      for(int i=0;i<current;i=i+1)
      {
        System.out.print(set[i]+" ");
      }
      System.out.println();
    }
  }
