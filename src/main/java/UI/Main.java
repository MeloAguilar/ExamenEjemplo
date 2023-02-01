package UI;

import DAL.SqlFiles;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        SqlFiles.ReadSql(new File("C:\\Users\\carra\\IdeaProjects\\ExamenEjemplo\\src\\main\\resources\\VQ_Naves.sql"));
    }
}
