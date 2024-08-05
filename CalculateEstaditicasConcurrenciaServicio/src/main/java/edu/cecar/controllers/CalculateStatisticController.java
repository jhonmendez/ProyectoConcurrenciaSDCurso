/**
 * Class: CalculateStatisticController.java
 * 
 * @since 18/07/2024
 * @version 0.1
 * @author Ing. Jhon Jaime Mendez
 * @copyrigth JASOFT
 **/

package edu.cecar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import edu.cecar.models.ResultCalculateSale;
import edu.cecar.services.CalculateStatisticService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Tutorial", description = "Tutorial Gestion APIs")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/calculate")
@Slf4j
public class CalculateStatisticController {

	@Autowired
	private CalculateStatisticService calculateStatisticService;

	@Operation(summary = "Calcula de forma concurrente con n cores")
	@ApiResponses({
			@ApiResponse(responseCode = "201", content = {
					@Content(schema = @Schema(implementation = CalculateStatisticController.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@CrossOrigin(origins = { "*" }, maxAge = 4800, allowCredentials = "false")
	@GetMapping("/{numbersCores}")
	public ResultCalculateSale listarEstadisticas(@PathVariable int numbersCores) {

		return calculateStatisticService.getCalulateSaleStatistic(numbersCores);

	}

}
