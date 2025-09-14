package app.exceptions;

public class MemeberNotFoundException extends RuntimeException {
    public MemeberNotFoundException(Long id) {
        super(String.format("Член клуба с идентификатором %d не найден", id));
    }
}
