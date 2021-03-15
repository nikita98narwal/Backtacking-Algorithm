import java.util.*;
  import java.io.*;

  public class Main {
    static boolean visited[][];
    public static void main(String args[]) throws IOException {

      Scanner sc=new Scanner(System.in);
      int rows=sc.nextInt();
      int column=sc.nextInt();
      char array[][]=new char[rows][column];

      for(int i=0;i<rows;i=i+1)
      {
        for(int j=0;j<column;j=j+1)
        {
          array[i][j]=sc.next().charAt(0);
        }
      }

      int t=sc.nextInt();
      for(int i=0;i<t;i=i+1)
      {
        visited=new boolean[rows][column]; 
        boolean answer=recursion(rows,column,array,sc.next());
        if(answer==true)
          System.out.println("Yes");
        else
          System.out.println("No");
      }
    }

    static boolean recursion(int rows,int column,char array[][],String word)
    {
      for(int i=0;i<rows;i=i+1)
      {
        for(int j=0;j<column;j=j+1)
        {
          if(word.charAt(0)==array[i][j]  &&  searchWord(rows,column,i,j,array,word,0))
          {
            return true;
          }
        }
      }
      return false;
    }

    static boolean searchWord(int rows,int column,int i,int j,char array[][],String word,int index)
    {
      if(index==word.length())
        return true;

      if(i<0 || i>=rows || j<0 || j>=column || word.charAt(index)!=array[i][j] || visited[i][j])
      {
        return false;
      }

      visited[i][j]=true;

      if(searchWord(rows,column,i+1,j,array,word,index+1) ||
      searchWord(rows,column,i-1,j,array,word,index+1) ||
      searchWord(rows,column,i,j+1,array,word,index+1) ||
      searchWord(rows,column,i,j-1,array,word,index+1))
      {
        return true;
      }

      visited[i][j]=false;
      return false;
    }
  }
