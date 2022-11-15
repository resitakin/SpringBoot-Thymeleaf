package com.simple.project1.Conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.simple.project1.Service.IEmpService;
import com.simple.project1.model.Employee;

@Controller
public class EmpController {
	
	@Autowired
	private IEmpService empService;
	
	@GetMapping("/")
	public String viewHomePakage(Model model) {
		model.addAttribute("allemplist",empService.getAllEmployee());
		
		return "index";
		
	}
	
	@GetMapping("/addnew")
	public String addNewEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "newemp";
		
		
		
	}
	@PostMapping("/save")
	public String saveEmploye(@ModelAttribute("employee") Employee employee) {
		empService.save(employee);
		return "redirect:/";
	}
	@GetMapping("/showFormUpdate/{id}")
	public String updateForm(@PathVariable(value="id")long id,Model model) {
		Employee employee=empService.getById(id);
		model.addAttribute("employee", employee);
		return "update";
		
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteId(@PathVariable(value="id")long id) {
		empService.deleteViaId(id);
		return "redirect:/";
	}

}
