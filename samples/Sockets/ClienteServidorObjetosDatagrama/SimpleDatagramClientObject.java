 // DatagramClient.java
import java.io.*;
import java.net.*;

public class SimpleDatagramClientObject
{
   private DatagramSocket socket = null;
   private DatagramPacket recvPacket, sendPacket;
   private int hostPort;

   public static void main(String[] args)
   {
        DatagramSocket socket = null;
        DatagramPacket recvPacket, sendPacket;
        int hostPort;
        if (args.length > 0)
          hostPort = Integer.valueOf(args[0]).intValue();
        else
          hostPort = 50001;
        try
        {
          socket = new DatagramSocket();
          InetAddress hostAddress = InetAddress.getByName("localhost");
           
          System.out.println("vamos a mandar al mundo a dracula");
             
             PersonaNew persona=new PersonaNew(2500,"Dracula","2");
            
             ByteArrayOutputStream bs= new ByteArrayOutputStream();
             ObjectOutputStream os = new ObjectOutputStream (bs);
             os.writeObject(persona);
             byte sendbuf[] = bs.toByteArray();
             sendPacket = new DatagramPacket(sendbuf,sendbuf.length,hostAddress,hostPort );

             socket.send(sendPacket);
            System.out.println("ya esta dracula en el mundo");
          
        }
        catch (SocketException se)
        {
            System.out.println("Error "+ "SimpleDatagramClient: "+ se);
        }
        catch (IOException ioe)
        {
            System.out.println("Error "+ "SimpleDatagramClient: "+ ioe);
        }
    }
}