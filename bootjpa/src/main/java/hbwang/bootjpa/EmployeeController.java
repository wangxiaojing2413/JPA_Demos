package hbwang.bootjpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping("queryAll")
	@ResponseBody
	public List<Employee> queryAll() {
		List<Employee> list = new ArrayList<Employee>();
		list = employeeRepository.findAll();
		return list;
	}
}