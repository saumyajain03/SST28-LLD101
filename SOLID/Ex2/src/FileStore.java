import java.util.*;

public class FileStore implements Persistence {
    private final Map<String, String> storage = new HashMap<>();

    @Override
    public void save(String invoiceId, String content) {
        storage.put(invoiceId, content);
    }

    @Override
    public int countLines(String invoiceId) {
        return storage.getOrDefault(invoiceId, "").split("\n").length;
    }
}