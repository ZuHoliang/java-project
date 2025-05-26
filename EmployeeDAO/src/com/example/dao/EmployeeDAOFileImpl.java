//package com.example.dao;
//
//import java.io.*;
//import java.text.*;
//import java.util.*;
//import com.example.model.Employee;
//
//public class EmployeeDAOFileImpl implements EmployeeDAO {
//	
//	private static SortedMap<Integer, Employee> employees = new TreeMap<>();
//	private SimpleDateFormat df=new SimpleDateFormat("MMM d, yyyy", 
//			Locale.US);
//	private String fileName;
//	
//	
//	public EmployeeDAOFileImpl(String fileName) {
//		this.fileName=fileName;
//	}
//	
//	
//	private void syncData() throws DAOException {
//		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
//			employees.clear();
//			String line;
//			while ((line=br.readLine())!=null && line.trim().length()!=0) {
//				String[] data = line.split("\\|");
//				try {
//					int id = Integer.parseInt(data[0]);
//					String fn = data[1];
//					String ln = data[2];
//					Date bd = df.parse(data[3]);
//					float salary = Float.parseFloat(data[4]);
//					Employee emp = new Employee(id,fn,ln,bd,salary);
//					employees.put(id,emp);
//				} catch(ParseException|RuntimeException pn) {
//					System.err.println("資料錯誤"+ line);
//				}
//				
//			}
//			
//			} catch (IOException e) {
//				throw new DAOException("資料讀取失敗",e);
//			}
//		
//	}
//	
//
//	private void commit() throws DAOException{
//		try(PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
//			Set<Integer> index = employees.keySet();
//			for(int i : index) {
//				Employee emp = employees.get(i);
//				pw.printf("%d|%s|%s|%s|%.2f%n",
//						  emp.getId(),emp.getFirstName(),emp.getLastName(),
//						  df.format(emp.getBirthDate()),emp.getSalary());
//			}
//			pw.flush();
//		} catch (IOException e) {
//			throw new DAOException("資料讀取失敗",e);
//		}
//		
//	}
//		
//
//	@Override
//	public void add(Employee emp) throws DAOException {
//		int id =emp.getId();	
//			if(employees.containsKey(id)) {
//				throw new DAOException("編號["+id+"]已存在，新增失敗");
//			}
//			employees.put(id,emp);
//			this.commit();
//	}
//
//	@Override
//	public void update(Employee emp) throws DAOException {
//		int id =emp.getId();
//		if(!employees.containsKey(id)) {
//			throw new DAOException("編號["+id+"]不存在，修改失敗");
//		}
//		employees.put(id,emp);
//		this.commit();
//	}
//
//	@Override
//	public void delete(int id) throws DAOException {
//		if(!employees.containsKey(id)) {
//			throw new DAOException("編號["+id+"]不存在，刪除失敗");
//		}
//		employees.remove(id);
//		this.commit();
//	}
//
//	@Override
//	public Employee findById(int id) throws DAOException {		
//		this.syncData();
//		return employees.get(id);		
//	}
//
//	@Override
//	public Employee[] getAllEmployees() throws DAOException {
//		this.syncData();
//		return employees.values().toArray(new Employee[0]);
//	}
//	
//	@Override
//	public void close() throws Exception {
//		System.out.print("資源關閉");
//	}
//
//
//}
