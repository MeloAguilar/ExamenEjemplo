package DAL;


import java.io.*;

public class SqlFiles {


    public static void ReadSql (File fileToRead){
        String linea;
        Connection cnn;
        try {
            cnn = new Connection();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToRead));
            linea = bufferedReader.readLine();
            while (linea != null){
                //Aqui ponemos el metodo de insercion.
                   linea =  linea.replace(";", "");

                cnn.saveFromFile(linea);
                linea = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error abriendo el archivo.");
            e.printStackTrace();
        }
    }
}