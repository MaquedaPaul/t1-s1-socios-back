package ar.utn.aceleradora.gestion.socios.modelos.reservas;

import java.security.SecureRandom;

public class Reserva {


    private String generarCodigoSeguimiento(){
        Integer id = 5; //--> reemplazar por getId();
        String idString = id.toString();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder codigo = new StringBuilder();

        for (int i = 0; i < 11; i++) {
            int indice = random.nextInt(caracteres.length());
            codigo.append(caracteres.charAt(indice));
        }
        codigo.append(idString);
        return codigo.toString();
    }
}
