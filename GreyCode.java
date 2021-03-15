import java.util.*; 

    class Main
    { 

    static int num; 

    static void grayCodeUtil(Vector<Integer> res, int n) 
    { 

        if (n == 0) 
        { 
            res.add(num); 
            return; 
        } 

        // ignore the bit. 
        grayCodeUtil(res, n - 1); 

        // invert the bit. 
        num = num ^ (1 << (n - 1)); 
        grayCodeUtil(res, n - 1); 
    } 

    static Vector<Integer> grayCodes(int n) 
    { 
        Vector<Integer> res = new Vector<Integer>(); 

        num = 0; 
        grayCodeUtil(res, n); 

        return res; 
    } 


    public static void main(String[] args) 
    { 
    Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Vector<Integer> code = grayCodes(n); 
        for (int i = 0; i < code.size(); i++) 
            System.out.println(code.get(i)); 
    } 
    } 
