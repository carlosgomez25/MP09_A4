package elpuig;

import javax.crypto.SecretKey;

public class Main2 {

    public static void main(String[] args){
        int keysize = 128;
        String keyText = "contraseña123";
        SecretKey secretKey = Xifrar.keygenKeyGeneration(keyText, keysize);
        String text = "Texto encriptado";
        //Encripto
        byte[] textoEncriptado = Xifrar.encryptData(secretKey, text.getBytes());
        //Desencripto
        byte[] textoDesencriptado = Xifrar.decryptData(secretKey, textoEncriptado);
        System.out.println("Texto encriptado: " + new String(textoEncriptado));
        System.out.println("Texto desencriptado: " + new String(textoDesencriptado));
    }
}
