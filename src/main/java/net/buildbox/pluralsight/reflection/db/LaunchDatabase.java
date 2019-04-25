package net.buildbox.pluralsight.reflection.db;

import org.hsqldb.server.Server;

public class LaunchDatabase {
    public static void main(String[] args) {
        launch("--help");
        launch("--database.0", "file:target/mydb", "--dbname.0", "xdb");

        System.out.println("DB launched");
        // jdbc:h2:/home/msanders/Projects/reflection/db-files/db-pluralsight;IFEXISTS=false
    }

    private static void launch(String ... args) {
        Server.main(args);
    }
}
