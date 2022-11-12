package pti.sb_rest_autorentcars.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pti.sb_rest_autorentcars.db.Database;
import pti.sb_rest_autorentcars.model.Car;

@RestController
public class AppController {
	@GetMapping("/allCars")
	public List<Car> allCars() {
		Database db = new Database();
		List<Car> cars = db.getAllCars();
		db.close();
		return cars;
	}

}
