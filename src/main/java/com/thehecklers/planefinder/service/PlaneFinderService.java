package com.thehecklers.planefinder.service;

import com.thehecklers.planefinder.repository.PlaneRepository;
import com.thehecklers.planefinder.domain.Aircraft;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Random;

@Service
public class PlaneFinderService {
    private final PlaneRepository repo;
    private final FlightGenerator generator;

    @SneakyThrows
    public PlaneFinderService(PlaneRepository repo, FlightGenerator generator) {
        this.repo = repo;
        this.generator = generator;
    }

    public Iterable<Aircraft> getAircraft() throws IOException {
        return saveSamplePositions();
    }

    private Iterable<Aircraft> saveSamplePositions() {
        final Random rnd = new Random();

        repo.deleteAll();

        for (int i = 0; i < rnd.nextInt(10); i++) {
            repo.save(generator.generate());
        }

        return repo.findAll();
    }
}

