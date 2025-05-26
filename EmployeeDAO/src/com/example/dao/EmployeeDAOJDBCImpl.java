package com.example.dao;

import java.sql.*;
import java.util.ArrayList;

import com.example.model.Employee;

public class EmployeeDAOJDBCImpl implements EmployeeDAO {
	
	private Connection con;
	
	

	EmployeeDAOJDBCImpl() throws Exception{
		String url = "jdbc:mysql://localhost:3306/EmployeeDB";
        String username = "root";
        String password = "abc123";
        
        try {
			con=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			throw new Exception("資料庫連線建立失敗:"+e);
		}
	}

	@Override
	public void close() throws Exception {
		if(con!=null)
			con.close();
	}

	@Override
	public void add(Employee emp) throws DAOException {
		String sql = "INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?, ?)";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1,emp.getId());
			pstmt.setString(2,emp.getFirstName());
			pstmt.setString(3,emp.getLastName());
			pstmt.setDate(4,new java.sql.Date(emp.getBirthDate().getTime()));
			pstmt.setFloat(5,emp.getSalary());
			if(pstmt.executeUpdate()!=1) {
				throw new DAOException("新增員工失敗");
			}			
		}catch (SQLException se) {
			throw new DAOException("新增資料失敗:",se);
		}

	}

	@Override
	public void update(Employee emp) throws DAOException {
		String update = "UPDATE EMPLOYEE SET FIRSTNAME=?, LASTNAME=?, BIRTHDATE=?, SALARY=? WHERE ID=?";
		try(PreparedStatement pstmt = con.prepareStatement(update)){
			pstmt.setString(1,emp.getFirstName());
			pstmt.setString(2,emp.getLastName());
			pstmt.setDate(3,new java.sql.Date(emp.getBirthDate().getTime()));
			pstmt.setFloat(4,emp.getSalary());
			pstmt.setInt(5,emp.getId());
			if(pstmt.executeUpdate()!=1) {
				throw new DAOException("修改員工失敗");
			}			
		} catch (SQLException se) {
			throw new DAOException("修改資料失敗:",se);
		}

	}

	@Override
	public void delete(int id) throws DAOException {
		String delete = "DELETE FROM EMPLOYEE WHERE ID=?";
		try(PreparedStatement pstmt = con.prepareStatement(delete)){
			pstmt.setInt(1,id);
			if(pstmt.executeUpdate()!=1) {
				throw new DAOException("刪除員工失敗");
			}			
		} catch (SQLException se) {
			throw new DAOException("刪除資料失敗:",se);
		}

	}

	

	@Override
	public Employee findById(int id) throws DAOException {
		String query = "SELECT * FROM EMPLOYEE WHERE ID=?";
		Employee emp = null;
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				emp = new Employee(rs.getInt("ID"),rs.getString("FirstName"),rs.getString("LastName"),
						           rs.getDate("Birthdate"),rs.getFloat("Salary"));
			}
			return emp;
		} catch (SQLException se) {
			throw new DAOException("搜尋失敗:",se);
		}
	}

	@Override
	public Employee[] getAllEmployees() throws DAOException {
		String getAll = "SELECT * FROM EMPLOYEE";
		try(Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getAll)){
			ArrayList<Employee> emps = new ArrayList<>();
			while(rs.next()) {
				Employee emp = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),
						                    rs.getDate(4),rs.getFloat(5));
				emps.add(emp);
			}
			return emps.toArray(new Employee[0]);
		} catch (SQLException se) {
			throw new DAOException("搜尋失敗:",se);
		}
	}

}
