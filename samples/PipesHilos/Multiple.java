import java.io.*;
class Multiple extends Thread{
    private int mult;
    private DataInputStream in;
    private DataOutputStream out;
    public Multiple(int m, PipedInputStream i,PipedOutputStream o){
        mult = m;
        try{
            in = new DataInputStream(new PipedInputStream(o));
            out = new DataOutputStream(new PipedOutputStream(i));
        }catch (IOException e) { }
    }

    public void run(){
        try{ 
            while (true){
                int k = in.readInt();
                out.writeInt(mult*k);
            }
        }catch (IOException e) { }
    }
}