import java.io.*;

class FileWriterThread extends Thread {
    private FileOutputStream fileOutputStream;
    private byte[] data;

    public FileWriterThread(FileOutputStream fileOutputStream, byte[] data) {
        this.fileOutputStream = fileOutputStream;
        this.data = data;
    }

    @Override
    public void run() {
        try {
            fileOutputStream.write(data);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

public class Lab113 {

    public static void main(String[] args) {
        String fileName = "binaryfile.bin";
        int fileSize = 10000;
        int numThreads = 4;

        byte[] data = generateData(fileSize / numThreads);

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            Thread[] threads = new Thread[numThreads];

            for (int i = 0; i < numThreads; i++) {
                threads[i] = new FileWriterThread(fileOutputStream, data);
                threads[i].start();
            }

            for (Thread thread : threads) {
                thread.join();
                thread.yield();
            }

            System.out.println("Binary file written successfully.");
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static byte[] generateData(int size) {
        byte[] data = new byte[size];
        for (int i = 0; i < size; i++) {
            data[i] = (byte) (Math.random() * 256);
        }
        return data;
    }
}