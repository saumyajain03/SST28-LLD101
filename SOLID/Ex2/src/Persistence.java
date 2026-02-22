public interface Persistence {
    void save(String invoiceId, String content);
    int countLines(String invoiceId);
}