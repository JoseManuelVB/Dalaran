package mx.com.isc8.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**@author 90836 */
public class EncriptarPassword {
    
    public static void main(String[] args) {
        String password = "123";
        System.out.println("password : " + password);
        System.out.println("password encriptado: " + EncriptarPassword(password));
    }

    public static String EncriptarPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}