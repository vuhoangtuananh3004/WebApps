package com.web.generatorId;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StudentIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
	
		Connection con = session.connection();
		
		String prefix = "TN";
		
		try {
			Statement stmt = con.createStatement();
			ResultSet  rs = stmt.executeQuery("Select count(studentId) as Id from com.web.entity.Student");
			
			if (rs.next()) {
				int id =  rs.getInt(1) +1;
				String generateId = prefix + String.valueOf(id);
				System.out.println("Generator Id: " + generateId);
				return generateId;	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}

}
