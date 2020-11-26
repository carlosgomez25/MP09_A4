package elpuig;

import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("/home/carlos/textamagat");
        byte[] textenbytes = Files.readAllBytes(path);

        File f = new File("/home/carlos/claves.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br =  new BufferedReader(fr);
        int keysize = 128;
        byte[] textoDesencriptado = null;
        while (textoDesencriptado == null) {
            String line = br.readLine();
            SecretKey secretKey = Xifrar.passwordKeyGeneration(line, keysize);
            textoDesencriptado = Xifrar.decryptData(secretKey, textenbytes);
        }

        System.out.println("Texto desencriptado: " + new String(textoDesencriptado));





        //    int keysize = 128;
    //    String keyText = "contraseña123";
    //    SecretKey secretKey = Xifrar.passwordKeyGeneration(keyText, keysize);
    //    String text = "Texto encriptado";
    //    //Encripto
    //    byte[] textoEncriptado = Xifrar.encryptData(secretKey, text.getBytes());
    //    //Desencripto
    //    byte[] textoDesencriptado = Xifrar.decryptData(secretKey, textoEncriptado);
    //    System.out.println("Texto encriptado: " + new String(textoEncriptado));
    //    System.out.println("Texto desencriptado: " + new String(textoDesencriptado));
    }

}
