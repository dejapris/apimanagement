package fr.tm.ima.digitaltour.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.tm.ima.digitaltour.api.model.Color;
import fr.tm.ima.digitaltour.api.service.ColorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/color")
@Api(value="couleurs", description="Gestion des couleurs")
public class ColorController {

	private ColorService colorService = ColorService.getInstance();
	
	@ApiOperation(value = "Ajoute une couleur dans le tableau",response = Iterable.class)
	@RequestMapping(value = "/add/", method = RequestMethod.POST)
	public ResponseEntity<?> addColor(@RequestBody Color col) {
		colorService.addColor(col);
		return new ResponseEntity<String>("Save OK", HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Renvoit l'ensemble du tableau",response = Iterable.class)
	@RequestMapping(value = "/get/", method = RequestMethod.GET)
	public int[] getArray() {
		return colorService.getTab();
	}
	
}
