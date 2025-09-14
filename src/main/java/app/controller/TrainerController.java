package app.controller;

import app.domain.Trainer;
import app.service.TrainerService;

import java.util.List;

public class TrainerController {

    private final TrainerService service = new TrainerService();

    public Trainer save(String name) {
        Trainer trainer = new Trainer(name);
        return service.save(trainer);
    }

    public List<Trainer> getAll() {
        return service.getAllActiveTrainers();
    }

    public Trainer getById(Long id) {
        return service.getActiveTrainerById(id);
    }

    public void deleteById(Long id) {
        service.deleteById(id);
    }

    public void deleteByName (String name) {
        service.deleteByName(name);
    }

    public void restoreById(Long id) {
        service.restoreById(id);
    }

    public void restoreByName(String name) {
        service.restoreByName(name);
    }

    public int getTrainersNumber() {
        return service.getActiveTrainersNumber();
    }
}