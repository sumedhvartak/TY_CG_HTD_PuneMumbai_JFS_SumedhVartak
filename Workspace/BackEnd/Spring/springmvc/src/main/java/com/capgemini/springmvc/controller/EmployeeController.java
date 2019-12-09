package com.capgemini.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.springmvc.bean.EmployeeInfoBean;
import com.capgemini.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/empLoginForm")
	public String displayEmpLoginForm() {
		return "empLoginForm";
	}//End of method
	
	@PostMapping("/empLogin")
	public String emplogin(int empId,String password, ModelMap modelMap, HttpServletRequest req) {//The name of empLoginfoem name and here inpara level name must be ame
	
		EmployeeInfoBean employeeInfoBean =  service.authenticate(empId, password);
		if(employeeInfoBean != null)
		{
			//Valid Credential
			HttpSession session = req.getSession(true);
			session.setAttribute("employeeInfoBean", employeeInfoBean);
			
			return "empHomePage";
			
		}
		else
		{
			modelMap.addAttribute("msg", "Invalid Crdential.......");
			return "empLoginForm";
		}
		
	}//End of empLogin()
	
	@GetMapping("/addEmployeeForm")
	public String displayAddEmployee(HttpSession session, ModelMap modelMap) {
		if(session.isNew()) {//if user not login
			modelMap.addAttribute("msg", "Please Login");
			return "empLoginForm";
		}else {
			return "addEmployeeForm";
		}
	}//End of addEmployee
	
	@PostMapping("/addEmp")
	public String addEmployee(EmployeeInfoBean employeeInfoBean, HttpSession session, ModelMap modelMap) {

		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First!!!");
			return "empLoginForm";

		} else {
			// Valid Session
			if (service.addEmployee(employeeInfoBean)) {
				modelMap.addAttribute("msg", "Employee Added Successfully!");
			} else {
				modelMap.addAttribute("msg", "Unable to add Employee");
			}
			return "addEmployeeForm";
		}
	}// End of addEmployee()

	
	@GetMapping("/Logout")
	public String logout(HttpSession session,ModelMap modelMap) {
		
		session.invalidate();
		modelMap.addAttribute("msg", "Logged out Successfully");
		return "empLoginForm";
	}//End of logout method
	
	@GetMapping("/UpdateEmployeeForm")
	public String displayUpdateEmployee(HttpSession session, ModelMap modelMap) {
		if(session.isNew()) {
			//Invalid Session
			modelMap.addAttribute("msg", "Please Login");
			return "empLoginForm";
		}else {
			
			return "UpdateEmployeeForm";
		}
	}//End of displayUpdateEmployee()
	
	@PostMapping("/updateEmployee")
	public String updateEmployee(EmployeeInfoBean employeeInfoBean, HttpSession session, ModelMap modelMap) {
		if(session.isNew()) {
			//Invalid Session
			modelMap.addAttribute("msg", "Please Login");
			return "empLoginForm";
		}else {
			
			if(service.updateEmployee(employeeInfoBean)) {
				modelMap.addAttribute("msg", "Updated Successfully ");
			}else {
				modelMap.addAttribute("msg", "Updated Successfully ");
			}
			return "UpdateEmployeeForm";
		}//end of else
	}//End of updateEmployee() method
	
	@GetMapping("/deleteEmployeeForm")
	public String displayDeleteEmployeeForm(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "empLoginForm";
		
		} else {
			// Valid Session
			return "deleteEmployeeForm";
		}
	}// End of displayDeleteEmployeeForm()
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(int empId, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "empLoginForm";
		
		} else {
			// Valid Session
			if(service.deleteEmployee(empId)) {
				modelMap.addAttribute("msg", "Employee Deleted Successfully!");
			} else {
				modelMap.addAttribute("msg", "Employee ID " + empId + " Not Found!");
			}
			
			return "deleteEmployeeForm";
		}
	}// End of deleteEmployee()
	
	@GetMapping("/seeAllEmployees")
	public String getAllEmployees(HttpSession session, ModelMap modelMap) {
		
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "empLoginForm";
		
		} else {
			// Valid Session
			List<EmployeeInfoBean> employeesList = service.getAllEmployees();
			modelMap.addAttribute("employeesList", employeesList);
			
			return "displayAllEmployees";
		}
	}// End of getAllEmployees()
	
	@GetMapping("/home")
	public String displayEmpHomePage(HttpSession session, ModelMap modelMap) {

		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "empLoginForm";
		
		} else {
			// Valid Session
			return "empHomePage";
		}
	}// End of displayEmpHomePage()

	@GetMapping("/searchEmployeeForm")
	public String displaySearchEmployeeForm(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "empLoginForm";
		
		} else {
			// Valid Session
			return "searchEmployeeForm";
		}
	}// End of displaySearchEmployeeForm()
	
	@GetMapping("/searchEmployee")
	public String searchEmployee(int empId, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "empLoginForm";
		
		} else {
			EmployeeInfoBean employeeInfoBean = service.getEmployee(empId);
			if (employeeInfoBean != null) {
				modelMap.addAttribute("employeeInfoBean", employeeInfoBean);
			} else {
				modelMap.addAttribute("msg", "Employee ID " + empId + " Not Found!!!");
			}
			
			return "searchEmployeeForm";
		}
	}// End of searchEmployee()
	

	
	
	
}//End of Controller
