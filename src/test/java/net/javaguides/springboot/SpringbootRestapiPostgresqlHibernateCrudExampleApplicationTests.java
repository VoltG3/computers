package net.javaguides.springboot;

import net.javaguides.springboot.controller.DepartmentController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringbootRestapiPostgresqlHibernateCrudExampleApplicationTests {
	private DepartmentController departmentController;

	/*public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";*/

	@Test
	void contextLoads() {

		space(1);
		System.out.println("###########################");
		System.out.println("#                         #");
		System.out.println("###########################");
		space(1);
	}
	/*@GetMapping("/employees")
	public List<Employee> findAll() {
		return this.employeeRepository.findAll();
	}*/

	private void space(int count) {
		for(int step = 0; step < count; step++) {
			System.out.println("");
		}
	}
}
