package com.techlabs.app.repository;

import com.techlabs.app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByENameLike(String empName);

    List<Employee> findByEEmail(String empEmail);

    List<Employee> findByEActive(boolean isActive);

    List<Employee> findByENameStartingWith(String charName);

    List<Employee> findByESalaryGreaterThanAndEDesignationLike(double salary, String designation);

    List<Employee> findByESalaryBetween(double startSalary, double endSalary);

    List<Employee> findByEActiveAndESalary(boolean isActive, double salary);

    int countByEActive(boolean isActive);

    int countByEDesignationLike(String designation);

//    Annotation @Query usage
//    JPQL Queries

    @Query("SELECT e FROM Employee e WHERE e.eName=:name")
    List<Employee> getByName(@Param("name") String empName);

    @Query("SELECT e FROM Employee e WHERE e.eEmail=:email")
    List<Employee> getByEmail(@Param("email") String empEmail);

    @Query("SELECT e FROM Employee e WHERE e.eActive=:active")
    List<Employee> getByActive(@Param("active") boolean isActive);

    @Query("SELECT e FROM Employee e WHERE e.eName LIKE CONCAT(:prefix, '%')")
    List<Employee> getNameStartingWith(@Param("prefix") String charName);

    @Query("SELECT e FROM Employee e WHERE e.eSalary>=:salary AND e.eDesignation=:designation")
    List<Employee> getEmployeeWithSalaryGreaterThanAndDesignation(@Param("salary") double salary,
                                                                  @Param("designation") String designation);

    @Query("SELECT e FROM Employee e WHERE e.eSalary BETWEEN :start AND :end")
    List<Employee> getEmployeeBySalaryBetween(@Param("start") double startSalary,
                                              @Param("end") double endSalary);

    @Query("SELECT e FROM Employee e WHERE e.eActive=:active AND e.eSalary=:salary")
    List<Employee> getEmployeeByActiveAndSalary(@Param("active") boolean isActive,
                                                @Param("salary") double salary);

    @Query("SELECT COUNT(e) FROM Employee e WHERE e.eActive=:active")
    int countEmployeesByActive(@Param("active") boolean isActive);

    @Query("SELECT COUNT(e) FROM Employee e WHERE e.eDesignation=:designation")
    int countEmployeesByDesignation(@Param("designation") String designation);


    //    Native Queries

    @Query(value = "SELECT * FROM employees e WHERE e.emp_name = ?1", nativeQuery = true)
    List<Employee> findByNameNative(String empName);

    @Query(value = "SELECT * FROM employees e WHERE e.emp_email = ?1", nativeQuery = true)
    List<Employee> findByEmailNative(String empEmail);

    @Query(value = "SELECT * FROM employees e WHERE e.emp_active = ?1", nativeQuery = true)
    List<Employee> findByActiveNative(boolean isActive);

    @Query(value = "SELECT * FROM employees e WHERE e.emp_name LIKE CONCAT(?1, '%')", nativeQuery = true)
    List<Employee> findNameStartingWithNative(String charName);

    @Query(value = "SELECT * FROM employees e WHERE e.emp_salary >= ?1 AND e.emp_design = ?2", nativeQuery = true)
    List<Employee> findEmployeesBySalaryGreaterThanAndDesignationNative(double salary, String designation);

    @Query(value = "SELECT * FROM employees e WHERE e.emp_salary BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Employee> findEmployeesBySalaryBetweenNative(double startSalary, double endSalary);

    @Query(value = "SELECT * FROM employees e WHERE e.emp_active = ?1 AND e.emp_salary = ?2", nativeQuery = true)
    List<Employee> findEmployeesByActiveAndSalaryNative(boolean isActive, double salary);

    @Query(value = "SELECT COUNT(*) FROM employees e WHERE e.emp_active = ?1", nativeQuery = true)
    int countEmployeesByActiveNative(boolean isActive);

    @Query(value = "SELECT COUNT(*) FROM employees e WHERE e.emp_design = ?1", nativeQuery = true)
    int countEmployeesByDesignationNative(String designation);

}
