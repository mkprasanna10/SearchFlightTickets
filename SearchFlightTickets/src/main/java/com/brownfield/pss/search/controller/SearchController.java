package com.brownfield.pss.search.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brownfield.pss.search.entity.Flight;
import com.brownfield.pss.search.entity.Inventory;
import com.brownfield.pss.search.service.SearchComponent;
import com.brownfield.pss.search.service.SearchQuery;

@RestController
@CrossOrigin
@RequestMapping("/search")
public class SearchController 
{
	private SearchComponent searchComponent;
	
	@Autowired
	public SearchController(SearchComponent searchComponent)
	{
		this.searchComponent = searchComponent;
	}
	
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public List<Flight> getFlightDetails(@RequestBody SearchQuery query)
	{
		return searchComponent.search(query);
	}
	
    @PostMapping(path= "/TicketUpdate", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> TicketCountUpdate(
		        @RequestHeader(name = "flightNumber", required = true) String FlightNumber,
		        @RequestHeader(name = "flightDate", required = true) String FlightDate,
		        @RequestHeader(name = "new_inventory", required = true) String inventoryid,
		        @RequestBody Inventory inventory) 
	{
		searchComponent.TicketCountUpdate(FlightNumber,FlightDate,Integer.parseInt(inventoryid));
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(inventory.getId())
                .toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	/*@RequestMapping(value="/TicketUpdate",method=RequestMethod.POST)
	public Inventory TicketCountUpdate(@RequestParam(value="flightNumber") String FlightNumber, 
			@RequestParam(value="flightDate") String FlightDate,@RequestParam(value="new_inventory") int new_inventory)
	{
		System.out.println("Ticket Method Invoked---->");
		//searchComponent.TicketCountUpdate(FlightNumber,FlightDate,new_inventory);
		return searchComponent.TicketCountUpdate(FlightNumber,FlightDate,new_inventory);
	}*/
	
}
