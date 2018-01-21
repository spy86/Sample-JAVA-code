import sun.net.*;
import java.net.*;
import java.io.*;

public class MulticastSniffer{

    public static void main(String[] args) {
        InetAddress ia = null;
        byte[] buffer = new byte[65535];
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        int port = 0;


        //read IP ADDRESS on CMD
        try{
            try {
                ia = InetAddress.getByName(args[0]);
            }
            catch (UnknownHostException e) {
                System.err.println(e);
            }
            port = Integer.parseInt(args[1]);
        }// end try
        catch (Exception e) {
            System.err.println(e);
            System.err.println
            ("Using: java MulticastSniffer MulticastAddress port");
            System.exit(1);
        }

        try{
            MulticastSocket ms = new MulticastSocket(port);
            ms.joinGroup(ia);
            while (true) {
                ms.receive(dp);
                String s = new String(dp.getData(),0,dp.getLength());
                System.out.println(s);
            }
        }
        catch (SocketException se) {
            System.err.println(se);
        }
        catch (IOException ie) {
            System.err.println(ie);
        }
    }
}
