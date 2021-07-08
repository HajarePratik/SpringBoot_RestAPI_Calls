package com.bridgelabz.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.demo.model.ModelUser;

@RestController
@RequestMapping("/hello")
public class SpringBootAPIRestController 
{

	// UC1 :-  http://localhost:8080/hello
	@RequestMapping(value = {"", "/", "/home"})
	public String sayHello()
	{
		return "Hello From BridgeLabz!!!";
	}
	
	// UC2 :- http://localhost:8080/hello/query?name=Pratik
	@RequestMapping(value = {"/query"}, method = RequestMethod.GET)
	public String sayHello(@RequestParam(value = "name")String name) 
	{
		return "Hello " + name ;
	}
	
	// UC3 :- http://localhost:8080/hello/param/Pratik
	@GetMapping("/param/{name}")
	public String sayHelloParam(@PathVariable String name)
	{
		return "Hello " + name + "!" ;
	}
	
	// UC4 :- http://localhost:8080/hello/post : {"firstName": "Pratik","lastName": "Hajare"}
	@PostMapping("/post")
	public String sayHello(@RequestBody ModelUser user) 
	{
		return "Hello " + user.getFirstName() + " " + user.getLastName();
	}
	
	// UC5 :- http://localhost:8080/hello/put/Pratik/?lastName=Hajare
	@PutMapping("/put/{firstName}")
	public String sayHello(@PathVariable String firstName, @RequestParam(value = "lastName")String lastName)
	{
		return "Hello " + firstName + " " + lastName ;
	}
	
}
