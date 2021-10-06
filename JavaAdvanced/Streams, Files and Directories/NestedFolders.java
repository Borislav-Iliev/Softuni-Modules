package StreamsFilesAndDirectories;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;

public class _08NestedFolders {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\SoftUni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File root = new File(path.toString());

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        int count = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles)
                if (nestedFile.isDirectory())
                    dirs.offer(nestedFile);
            count++;
            System.out.println(current.getName());
        }
        System.out.println(count + " folders");

    }
}
