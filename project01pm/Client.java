package project01pm;

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {

        Socket socket = new Socket("localhost", 3000);

        if (args.length < 3) {
            System.out.println("Invalid input. Disconnecting connection");
            return;
        }

        float a = Float.parseFloat(args[0]);
        String b = args[1];
        float c = Float.parseFloat(args[2]);

        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        DataOutputStream dos = new DataOutputStream(bos);

        dos.writeFloat(a);
        dos.writeUTF(b);
        dos.writeFloat(c);
        dos.flush();

        InputStream is = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        DataInputStream dis = new DataInputStream(bis);

        System.out.println("Calculations sent from Server: " + dis.readFloat());

        socket.close();

    }
}
