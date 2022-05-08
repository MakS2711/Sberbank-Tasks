package dorofeev;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class WordHandler {
    private static final int QUEUE_CAPACITY = 10;
    private static final AtomicInteger count = new AtomicInteger();
    private static final LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(QUEUE_CAPACITY);

    public static int countWord(@NotNull String word, @NotNull String property) throws IOException, InterruptedException {
        Properties properties = new Properties();
        properties.load(new FileReader(property));

        final String PATH = properties.getProperty("path");
        final String COUNT_THREAD = properties.getProperty("countThread");

        if (word == null) {
            throw new RuntimeException("Search word not found!");
        }

        if (PATH == null) {
            throw new RuntimeException("File not found!");
        }

        if (COUNT_THREAD == null || Integer.parseInt(COUNT_THREAD) < 1) {
            throw new RuntimeException("The number of threads is incorrect!");
        }

        ExecutorService service = Executors.newFixedThreadPool(Integer.parseInt(COUNT_THREAD));
        service.execute(frequencyOfTheWord(word));

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                blockingQueue.put(currentLine);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            awaitTerminationAfterShutdown(service);
        }

        return count.get();
    }

    private static Runnable frequencyOfTheWord(String searchWord) {
        return () -> {
            while (true) {
                try {
                    String line = blockingQueue.take();
                    String[] text = line.split("\\W+");
                    for (var word : text) {
                        if (word.equalsIgnoreCase(searchWord)) {
                            count.incrementAndGet();
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    private static void awaitTerminationAfterShutdown(ExecutorService threadPool) {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(5, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

