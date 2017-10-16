package com.capcom.monitoring.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capcom.monitoring.dao.JDBCTestDao;
import com.capcom.monitoring.model.Employee;


@Controller
public class RameezController {
	
	
	@Autowired
	JDBCTestDao jdbcTestDao;
	
	@RequestMapping("/rameez")
	public ModelAndView myfunc() {
		System.out.println("Inside myfunc");
		
		List<String> myList = null;
		myList = new ArrayList<>();
		myList.add("rameez");
		myList.add("raja");
		myList.add("mom");
		myList.add("dad");
		myList.add("afiya");
		myList.add("izan");
		myList.add("zaina");
		
		System.out.println(myList);
		
		System.out.println("************************************");
		
		for (String s : myList) {
			System.out.println("Hello! "+ s);
		}
		
		
		ModelAndView mv = new ModelAndView();
		ModelMap model = new ModelMap();
			
		model.addAttribute("myownlist", myList);
		
		mv.addAllObjects(model);
		mv.setViewName("rameez");		
		return mv;
	}

	@RequestMapping("/emp")
	public ModelAndView getAllEmp() {
		System.out.println("In controller getAllEmp");
		
		List<Employee> empList  = this.jdbcTestDao.getAllEmployees();
		
		System.out.println(empList);
		System.out.println("#######################################");
		
		for (Employee e : empList) {
			System.out.println(e);
		}
		
		ModelAndView mv = new ModelAndView();
		ModelMap model = new ModelMap();
			
		model.addAttribute("employeeList", empList);
		
		mv.addAllObjects(model);
		mv.setViewName("employee");		
		return mv;
	}
	
}
