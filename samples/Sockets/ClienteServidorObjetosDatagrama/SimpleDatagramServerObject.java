// SimpleDatagramServer.java
import java.io.*;
import java.net.*;
public class SimpleDatagramServerObject
{
   public static void main(String[] args)
   {
     DatagramSocket socket = null;
     DatagramPacket recvPacket, sendPacket;
     int hostPort;
     if ( args.length > 0 )
       hostPort = Integer.valueOf(args[0]).intValue();
     else
       hostPort = 50001;
     try
     {
       socket = new DatagramSocket(hostPort);
        PersonaNew p;
          recvPacket =new DatagramPacket(new byte[512], 512);
          socket.receive(recvPacket);
          ByteArrayInputStream bs= new ByteArrayInputStream(recvPacket.getData()); 
          ObjectInputStream is = new ObjectInputStream(bs);
          try { 
          p=(PersonaNew) is.readObject();
          System.out.println("he recibido ha dracula "+p);
          }catch(Exception e){
          	System.out.println(e.getMessage());
          }
         
         
         
      }
      catch (SocketException se)
        {
         System.out.println("Error in "+ "SimpleDatagramServer: " + se);
        }
      catch (IOException ioe)
      {
         System.out.println("Error in "+ "SimpleDatagramServer: " + ioe);
      }
   }
}