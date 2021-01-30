import java.io.*;
import java .net.*;
public class client{
    public static void main(String args[]) throws Exception{
        Socket sock = new Socket("127.0.0.1",4000);
        System.out.println("Enter the filename:");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String fname=br.readLine();
        OutputStream ostream=sock.getOutputStream();
        PrintWriter pwrite=new PrintWriter(ostream,true);
        pwrite.println(fname);
        InputStream istream=sock.getInputStream();
        BufferedReader readsocket=new BufferedReader(new InputStreamReader(istream));
        String str;
        while((str=readsocket.readLine()) !=  null)
        {
            System.out.println(str);
        }
        readsocket.close();pwrite.close();br.close();sock.close();


    }
}