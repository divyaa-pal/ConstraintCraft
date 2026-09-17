package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    public static void saveToReports(
            String filename,
            String content) {

        try {

            Path folder = Path.of("reports");

            Files.createDirectories(folder);

            Files.writeString(
                    folder.resolve(filename),
                    content
            );

        } catch (IOException e) {

            System.out.println(
                    "Could not save report: "
                    + e.getMessage()
            );
        }
    }
}