package server;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {

    private final List<String> files = new ArrayList<>();
    private final Pattern pattern = Pattern.compile("file[1-9]|file10");

    public void addFile(String file) {
        Matcher matcher = pattern.matcher(file);
        if (!matcher.matches() || files.size() >= 10 || files.contains(file)) {
            System.out.println("Cannot add the file " + file);
        } else {
            files.add(file);
            System.out.println("The file " + file + " added successfully");
        }
    }

    public void getFile(String file) {
        if (files.contains(file)) {
            System.out.println("The file " + file + " was sent");
        } else {
            System.out.println("The file " + file + " not found");
        }
    }

    public void deleteFile(String file) {
        if (files.contains(file)) {
            files.remove(file);
            System.out.println("The file " + file + " was deleted");
        } else {
            System.out.println("The file " + file + " not found");
        }
    }
}
