package project01pm;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(3000);
        System.out.println("Waiting for connection...");

        while (true) {
            Socket conn = server.accept();
            System.out.println("Connected with new client!");

            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            float inputA = dis.readFloat();
            String inputB = dis.readUTF();
            float inputC = dis.readFloat();
            float result = 0;

            // Perform calculation based on the operator
            switch (inputB) {
                case "+":
                    result = inputA + inputC;
                    break;
                case "-":
                    result = inputA - inputC;
                    break;
                case "x":
                    result = inputA * inputC;
                    break;
                case "/":
                    if (inputC != 0) {
                        result = inputA / inputC;
                    } else {
                        System.out.println("Error: Division by zero.");
                        result = 0; // Set to zero or some error code
                    }
                    break;
                default:
                    System.out.println("Invalid operator: " + inputB);
                    result = 0; // or some error code
                    break;
            }

            OutputStream os = conn.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            dos.writeFloat(result);
            dos.flush();
            conn.close();
        }

    }
}
