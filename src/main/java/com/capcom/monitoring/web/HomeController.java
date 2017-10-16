package com.capcom.monitoring.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capcom.monitoring.model.Monitor;
import com.capcom.monitoring.model.MonitorRequest;
import com.capcom.monitoring.service.JDBCTestService;
import com.capcom.monitoring.service.SearchService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {
	
	private static Logger LOG = LogManager.getLogger();
	
	@Autowired
	private JDBCTestService service;
	
	@Autowired
	private SearchService searchService;
	
	@Autowired
	private MonitorRequestValidator monitorRequestValidator;
	
	//Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(monitorRequestValidator);
	}
	
	@RequestMapping("/")
	public String index() {
		System.out.println("index");
		//String aa = service.jdbcTestSpring();
		//System.out.println(aa);
		return "index";
	}
	
	@RequestMapping("/homesearchresults")
	public ModelAndView homeSearchResults(HttpServletRequest request,
            HttpServletResponse response) {
		System.out.println("homesearchresults");
		String searchKey = request.getParameter("searchTextbox");
		String searchType = request.getParameter("maindropdown");
		System.out.println(searchType);
		System.out.println(searchKey);
		
		ModelAndView mv = new ModelAndView();
		
		if (searchType.equals("server")) {
			boolean isValidServer = searchService.isValidServer(searchKey);
			if (isValidServer) {				
				mv.addObject("server", searchKey);
				mv.setViewName("searchResults");
			} else {
				mv.addObject("message", "No result found");
				mv.setViewName("index");
			}
		} else {
			mv.setViewName("index");
		}
		
		return mv;
	}
	
	/**
	 * This method will be used for main page server/escal search
	 * 
	 * @param request
	 * @param type
	 * @param searchString
	 * @return
	 */
	@RequestMapping("/searchText/{type}/{searchString}")
	@ResponseBody
	public String typeahead(HttpServletRequest request, @PathVariable String type, @PathVariable String searchString )  
	{
		System.out.println(type);
		System.out.println(searchString);
		List<String> serverList = searchService.getServers(searchString);
		String jsonArray = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonArray = mapper.writeValueAsString(serverList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}	
		
		return jsonArray;
	}
	
	@RequestMapping("/test123")
	public String test()  
	{
		searchService.test();
		return "index";
	}
	
	@RequestMapping("/cpumonitors/{serverName}")
	@ResponseBody
	public String getCPUMonitors(@PathVariable String serverName) {
		//List<Monitor> list = getMonitorList();
		System.out.println("Server Name:  "+serverName);
		List<Monitor> list = searchService.getCPUMonitors(serverName);
		Map<String, List<Monitor>> myMap = new HashMap<>();
		myMap.put("data", list);
		
		
		String jsonArray = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonArray = mapper.writeValueAsString(myMap);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println(jsonArray);
		
		return jsonArray;
	}
	
	@RequestMapping("/getCreateCPUMonitorPage/{serverName}")
	public String getCreateCPUMonitor(@PathVariable String serverName, Model model) {
		//model.addAttribute("serverName", serverName);
		MonitorRequest monitorRequest = new MonitorRequest();
		monitorRequest.setHostname(serverName);
		model.addAttribute("monitorRequest", monitorRequest);
		
		System.out.println("Server Name CPU:  "+serverName);
		
		//return mv;
		return "createCPUMonitor";
	}
	
	@RequestMapping(value="/createCPUMonitor", method=RequestMethod.POST)
	//public String createCPUMonitor(@ModelAttribute("monitorRequest") MonitorRequest monitorRequest,BindingResult result, Model model, HttpServletRequest request) {
	public String createCPUMonitor(@ModelAttribute("monitorRequest") @Validated  MonitorRequest monitorRequest, BindingResult bindingResult, Model model, HttpServletRequest request) {
		System.out.println("createCPUMonitor POST");
		LOG.info("*createCPUMonitor POST");
		LOG.info(monitorRequest);
		//getMonitorRequest(request);
		model.addAttribute("server",monitorRequest.getHostname());
		if (bindingResult.hasErrors()) {
			LOG.info("Returning createCPUMonitor.jsp page");
			return "createCPUMonitor";
		}
		
		String result = searchService.createCPUMonitor(monitorRequest);
		
		return "searchResults";
	}
	
	
	private MonitorRequest getMonitorRequest(HttpServletRequest request) {
		System.out.println("***********In getMonitorRequest***********");
		MonitorRequest monReq = new MonitorRequest();
		monReq.setCondition(request.getParameter("condition"));
		monReq.setInterval(request.getParameter("interval"));
		monReq.setEscalType(request.getParameter("escalType"));
		monReq.setEscalGroup(request.getParameter("escalGroup"));
		monReq.setSchedule(request.getParameter("schedule"));
		monReq.setChgGroup(request.getParameter("chgGroup"));
		System.out.println(monReq);
		return monReq;
	}

	private List<Monitor> getMonitorList() {
		Monitor monitor = new Monitor();
		monitor.setMonitorId(10001);
		monitor.setSource("vlrtp927");
		monitor.setMonitorName("[vos654321][CPU][SS][99][Error]");
		monitor.setHostName("vos654321");
		monitor.setInterval("15m");
		monitor.setCondition("99");
		monitor.setEscalType("Incident");
		monitor.setEscalGroup("apm_dev");
		monitor.setSchedule("Daily");
		monitor.setChangeGroup("ftgei_ops");
		
		Monitor monitor1 = new Monitor();
		monitor1.setMonitorId(10002);
		monitor1.setSource("vlrtp929");
		monitor1.setMonitorName("[vos654324][CPU][SS][98][Error]");
		monitor.setHostName("vos654324");
		monitor1.setInterval("15m");
		monitor1.setCondition("98");
		monitor1.setEscalType("Email Mailbox");
		monitor1.setEscalGroup("apm_dev");
		monitor1.setSchedule("Weekdays");
		monitor1.setChangeGroup("ftgei_ops");
		
		List<Monitor> list = new ArrayList<>();
		list.add(monitor);
		list.add(monitor1);
		return list;
	}
	
	
	
}
