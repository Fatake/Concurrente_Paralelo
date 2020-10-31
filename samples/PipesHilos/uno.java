import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
public class uno{
	static int NUMBER = 100;
	public static void main(String [] args){
        try{
            PipedInputStream pipeIn2 = new PipedInputStream();
            PipedOutputStream pipeOut2 = new PipedOutputStream();
            
            new Multiple(2, pipeIn2, pipeOut2).start();
            
            PipedInputStream pipeIn3 = new PipedInputStream();
            PipedOutputStream pipeOut3 = new PipedOutputStream();
            new Multiple(3, pipeIn3, pipeOut3).start();
            
            PipedInputStream pipeIn5 = new PipedInputStream();
            PipedOutputStream pipeOut5 = new PipedOutputStream();
            new Multiple(5, pipeIn5, pipeOut5).start();
            

            DataInputStream myIn2 = new DataInputStream(pipeIn2);
            DataInputStream myIn3 = new DataInputStream(pipeIn3);
            DataInputStream myIn5 = new DataInputStream(pipeIn5);
            DataOutputStream myOut2 = new DataOutputStream(pipeOut2);
            DataOutputStream myOut3 = new DataOutputStream(pipeOut3);
            DataOutputStream myOut5 = new DataOutputStream(pipeOut5);

            myOut2.writeInt(1); // Send 1 to
            myOut3.writeInt(1); // each thread
            myOut5.writeInt(1);
            
            int k = 1; // Counter
            int last = 1; // Last term in sequence so far
            format(last, 6); // Formatted output
            int n2 = myIn2.readInt(); // Get first values
            int n3 = myIn3.readInt(); // from each thread
            int n5 = myIn5.readInt();
            while (k < NUMBER){
                k++;
                // Skip terms that are not bigger than last
                while (n2 <= last) n2 = myIn2.readInt();
                while (n3 <= last) n3 = myIn3.readInt();
                while (n5 <= last) n5 = myIn5.readInt();
                // Select the smallest of available numbers
                if (n2 <= n3 && n2 <= n5){
                    last = n2;
                    format(last, 6);
                    myOut2.writeInt(n2);
                    myOut3.writeInt(n2);
                    myOut5.writeInt(n2);
                    n2 = myIn2.readInt();
                } else if (n3 <= n2 && n3 <= n5) {
                    last = n3;
                    format(last, 6);
                    myOut2.writeInt(n3);
                    myOut3.writeInt(n3);
                    myOut5.writeInt(n3);
                    n3 = myIn3.readInt();
                }
                else if (n5 <= n3 && n5 <= n2) {
                    last = n5;
                    format(last, 6);
                    myOut2.writeInt(n5);
                    myOut3.writeInt(n5);
                    myOut5.writeInt(n5);
                    n5 = myIn5.readInt();
                }
                if (k%10==0)
                    System.out.println();
            }
        }catch (IOException e) { }
    }
    
    static void format(int n, int size){
        String s = String.valueOf(n);
        for (int k=1; k<=size-s.length(); k++)
        System.out.print(" ");
        System.out.print(s);
    }
}