package com.sl.buslines.backend;

import com.sl.buslines.backend.models.Bus;
import com.sl.buslines.backend.repository.BuslinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final BuslinesRepository repository;

	@Autowired
	public DatabaseLoader(BuslinesRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new Bus(1, 5, List.of("10018", "10025")));
	}
}
