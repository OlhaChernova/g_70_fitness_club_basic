package app.service;

import app.domain.Trainer;
import app.exceptions.TrainerNotFoundExeption;
import app.exceptions.TrainerRestoreException;
import app.exceptions.TrainerSaveException;
import app.repository.TrainerRepository;

import java.util.List;

public class TrainerService {

    private final TrainerRepository repository = new TrainerRepository();
    private static TrainerService instance;

    public TrainerService() {
    }

    public static TrainerService getInstance() {
        if (instance == null) {
            instance = new TrainerService();
        }
        return instance;
    }

    public Trainer save(Trainer trainer) {
        if (trainer == null) {
            throw new TrainerSaveException("Тренер не может быть пустым");
        }

        String name = trainer.getName();
        if (name == null || name.trim().isEmpty()) {
            throw new TrainerSaveException("Имя не может быть пустым");
        }

        trainer.setActive(true);
        return repository.save(trainer);
    }

    public List<Trainer> getAllActiveTrainers() {
        return repository.findAll()
                .stream()
                .filter(Trainer::isActive)
                .toList();
    }

    public Trainer getActiveTrainerById(Long id) {
        Trainer trainer = repository.findById(id);

        if (trainer == null || !trainer.isActive()) {
            throw new TrainerNotFoundExeption(id);
        }
        return trainer;
    }

    public void deleteById(Long id) {
        Trainer trainer = getActiveTrainerById(id);
        trainer.setActive(false);
    }

    public void deleteByName(String name) {
        getAllActiveTrainers()
                .stream()
                .filter(x -> x.getName().equals(name))
                .forEach(x -> x.setActive(false));
    }

    public void restoreById(Long id) {
        Trainer trainer = repository.findById(id);

        if (trainer == null) {
            throw new TrainerNotFoundExeption(id);
        }
        trainer.setActive(true);
    }

    public void restoreByName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new TrainerRestoreException("Имя не может быть пустым");
        }
        Trainer trainer = repository.findByName(name);
        trainer.setActive(true);
    }

    public int getActiveTrainersNumber() {
        return getAllActiveTrainers().size();
    }
}