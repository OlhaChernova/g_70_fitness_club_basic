package app.exceptions;

public class TrainerNotFoundExeption extends RuntimeException {
    public TrainerNotFoundExeption(Long id) {
        super(String.format("Тренер с идентификатором %d не найден", id));
    }
}
