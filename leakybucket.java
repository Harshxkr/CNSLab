import java.util.Scanner;
public class leakybucket {
public static void main(String[] args)
{
int i;
int a[]=new int[20];
int remaining=0,sent,accepted;

Scanner sc = new Scanner(System.in);

System.out.println("Enter the number of packets");
int n = sc.nextInt();

System.out.println("Enter the packets");
for(i=1;i<=n;i++)
  a[i]= sc.nextInt();
System.out.println("Enter the maximum capacity of packet in the bucket:");
int capacity= sc.nextInt();
System.out.println("Enter the rate of packets to be sent from the buckket:");
int rate =sc.nextInt();

System.out.println("Clock   Packet size    Packet accepted  Packets sent   Packet remaining");
for(i=1;i<=n;i++)
{
   if(a[i]!=0)
   {
       if(remaining+a[i]>capacity)
       {
            accepted=-1;
       }
       else
       {
          accepted=a[i];
          remaining+=a[i];
       }
   }
   else
      {
        accepted=0;
      }
    
 if(remaining!=0)
    {
         if(a[i]<rate)
         {
             sent=remaining;
              remaining=0;
         }
         else
        {
            sent=rate;
            remaining=remaining-rate; 
        }
    }
    else
       {
       sent=0;
       }

    if(accepted==-1)
       System.out.println(+i+ "\t\t" +a[i]+ "\t\tdropped \t" +  sent +"\t\t" +remaining);
    else
       System.out.println(+i+ "\t\t" +a[i] +"\t\t" +accepted +"\t\t" +sent + "\t\t" +remaining);
}
}
}
