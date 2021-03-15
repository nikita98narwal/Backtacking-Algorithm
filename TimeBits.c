#include <stdio.h>
    #include<stdlib.h>


      char hour[10];
      char minute[10];

    int b(char bitString[], int n){
         int ret = 0;
         for(int i = 0; i < n; i++)
              if(bitString[i] == '1')
                ret |= 1 << ((n-1)-i);

         return ret;
    }
    void backtrack(char s[], const int start,const int num)
    {

            for(int i=6;i<10;i++)
             hour[i] = s[i];
            int hours = b(hour,10);
            if(hours > 11){
                return;
            }

            for(int j=0;j<6;j++)
                minute[j] = s[j];
            int minutes = b(minute,6);
            if(minutes > 59){
                return;
            }
            if(num==0){
                printf(" %d:%s%d",hours,(minutes < 10 ? "0" : ""),(minutes) );
                return;
            }

            if(start == 10){
                return;
            }

            for(int i=start; i<10; ++i){
                s[i] = '1';
                backtrack(s, i+1, num-1);
                s[i] = '0';
            }
        }


    int main()
    {
      int n;
      scanf("%d",&n);
      char s[]={'0','0','0','0','0','0','0','0','0','0'};
      backtrack(s,0,n);

      return 0;
    }
