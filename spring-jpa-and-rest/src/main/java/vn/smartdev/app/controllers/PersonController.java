package vn.smartdev.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.smartdev.app.entities.Person;
import vn.smartdev.app.models.ResultModel;
import vn.smartdev.app.repositories.IPersonRepository;

@Controller
public class PersonController {

	@Autowired
	IPersonRepository iPersonRepository;

	@RequestMapping(value = "/rest/add/person", method = RequestMethod.GET)
	@ResponseBody
	public ResultModel addPerson(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "email", required = false) String email) {
		Person person = new Person();
		person.setName(name);
		person.setEmail(email);
		ResultModel result = new ResultModel();
		Person data = iPersonRepository.save(person);
		result.setStatus("SUCCESS");
		result.setMessage("Create person successful!");
		result.setData(data);
		return result;
	}
}
