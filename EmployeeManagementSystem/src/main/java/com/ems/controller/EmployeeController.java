package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ems.model.EmployeeModel;
import com.ems.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping(value = { "/", "loadForm" })
	public String loadForm(Model model) {
		EmployeeModel employee = new EmployeeModel();
		model.addAttribute("emp", employee);
		return "form";
	}

	@PostMapping(value = "/addEmployee")
	public String handleSubmit(@ModelAttribute("emp") EmployeeModel emp, Model model) {
		boolean isSaved = empService.saveEmployee(emp);
		String msg = "";
		if (isSaved) {
			msg = "Employeed Saved Successfully.";
		} else {
			msg = "Filed to add employee";
		}
		model.addAttribute("message", msg);
		return "form";
	}

	@GetMapping(value = "/viewAllEmployees")
	public String viewALl(Model model) {
		List<EmployeeModel> employees = empService.viewAllEmployees();
		model.addAttribute("employees", employees);
		return "viewEmployees";
	}

	@GetMapping(value = "/deleteEmployee")
	public String deleteEmpooyee(@RequestParam(value = "id") Integer id, Model model) {
		// System.out.println(id);
		empService.deleteEmployee(id);
		String deletionMsg = "Deletion Successful.";
		model.addAttribute("deletionMsg", deletionMsg);
		return "redirect:/viewAllEmployees";
	}

	@GetMapping(value = "/editEmployee")
	public String editEmployee(@RequestParam(value = "id") Integer id, Model model) {
		EmployeeModel empToEdit = empService.getEmployeeById(id);
		model.addAttribute("empToEdit", empToEdit);
		return "employeeEditorForm";
	}

	@PostMapping(value = "/saveEditedEmployee")
	public String saveEdited(@ModelAttribute("empToEdit") EmployeeModel empToEdit, Model model) {
		boolean isSaved = empService.updateEmployee(empToEdit);
		String msg = "";
		if (isSaved) {
			msg = "Edition Successful.";
		}
		msg = "Edition Terminated.";
		model.addAttribute("msg", msg);
		return "redirect:/viewAllEmployees";
	}
}
