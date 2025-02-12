package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.*;

public class Exercise32 {

    public static void main(String[] args) {

        String result = generateStringToSave(null);  // Prueba con null para que pida al usuario la entrada
        System.out.println("Texto a guardar: " + result);

        printToFile(result);       // Guardamos el texto en un archivo

    }

    public static String generateStringToSave(String string) {
        if (string != null) {
            return string;  // Si el texto no es nulo, lo devolvemos tal cual
        } else {
            return generateUserInputToSave();  // Si es nulo, pedimos al usuario que lo ingrese
        }

    }


    private static String generateUserInputToSave(){
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while(!(string = Utils.string()).isEmpty()){
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        File file = new File("src/main/resources/data.txt");  // Especificamos el archivo donde se guardará el texto, se crea antes la ruta para poder guardar en el

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(string);  // Escribe la cadena en el archivo
            System.out.println("El texto ha sido guardado en el archivo '/src/main/resources/data.text'");
        } catch (Exception e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }

    }


}


