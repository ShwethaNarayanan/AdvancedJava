package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.entities.BankInfo;
import com.bank.entities.ContactInfo;
import com.bank.entities.PersonalInfo;
import com.bank.exceptions.CustomExceptions;



@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private DataSource datasource;

	Connection con;

	@Override
	public int savePersonalInfo(PersonalInfo personalinfo) throws CustomExceptions{
		try {
			con = datasource.getConnection();
			String query = ("INSERT INTO personalinfo(fname, mname, lname, gender) VALUES(?,?,?,?)");
			PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, personalinfo.getFname());
			ps.setString(2, personalinfo.getLname());
			ps.setString(3, personalinfo.getMname());
			ps.setString(4, personalinfo.getGender());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			int accountid = 0;
			if (rs.next()) {
				accountid = rs.getInt(1);
			}
			System.out.println("Account id: " + accountid);
			return accountid;

		} catch (SQLException e) {
			System.out.println("Error with SQL");
			throw new CustomExceptions(e.getMessage());
		}
	}

	@Override
	public int saveBankInfo(BankInfo bankinfo) throws CustomExceptions{
		try {
			con = datasource.getConnection();
			String query = ("INSERT INTO bankinfo(accountid, bankname, account, ssn) VALUES(?,?,?,?)");
			PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, bankinfo.getAccountid());
			ps.setString(2, bankinfo.getBankname());
			ps.setInt(3, bankinfo.getAccount());
			ps.setInt(4, bankinfo.getSsn());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			int bankid = 0;
			if (rs.next()) {
				bankid = rs.getInt(1);
			}
			System.out.println("Bank id: " + bankid);
			return bankid;

		} catch (SQLException e) {
			System.out.println("Error with SQL");
			throw new CustomExceptions(e.getMessage());
		}

	}

	@Override
	public int saveContactInfo(ContactInfo contactinfo) throws CustomExceptions{

		try {
			con = datasource.getConnection();
			String query = ("INSERT INTO contactinfo(accountid, address, city, state, country, phone) VALUES(?,?,?,?,?,?)");
			PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, contactinfo.getAccountid());
			ps.setString(2, contactinfo.getAddress());
			ps.setString(3, contactinfo.getCity());
			ps.setString(4, contactinfo.getState());
			ps.setString(5, contactinfo.getCountry());
			ps.setString(6, contactinfo.getPhone());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			int contactid = 0;
			if (rs.next()) {
				contactid = rs.getInt(1);
			}
			System.out.println("Contact id: " + contactid);
			return contactid;

		} catch (SQLException e) {
			System.out.println("Error with SQL");
			throw new CustomExceptions(e.getMessage());
		}
	}



}
