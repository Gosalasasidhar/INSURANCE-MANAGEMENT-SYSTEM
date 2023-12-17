package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import entity.Policy;
import exceptionn.PoliciesNotFouund;
import exceptionn.PolicyAlreadyExists;
import exceptionn.PolicyNotFoundException;
import util.DBConnUtil;
import util.DBPropertyUtil;

public class InsuranceServiceImpl implements IPolicyService {
	private Connection con;
	public InsuranceServiceImpl() 
	{
		String connectionString =DBPropertyUtil.getConnectionString("src/resources/db.properties");
		this.con=DBConnUtil.getConnection(connectionString);
	}

	@Override
	public boolean createPolicy(Policy policy) throws PolicyAlreadyExists {
		try {
			 PreparedStatement ps = con.prepareStatement("SELECT * FROM Policy WHERE policyId = ?");
		        ps.setInt(1, policy.getPolicyId());
		        ResultSet rs = ps.executeQuery();
		        if (rs.next()) {
		            throw new PolicyAlreadyExists("Policy with ID " + policy.getPolicyId() + " already exists.");
		        }

			
			ps=con.prepareStatement("insert into Policy values(?,?,?)");
			ps.setInt(1, policy.getPolicyId());
			ps.setString(2, policy.getPolicyName());
			ps.setString(3,policy.getPolicyType());
			int i=ps.executeUpdate();
			
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public Policy getPolicy(int policyId) throws PolicyNotFoundException {
		try {
			PreparedStatement ps=con.prepareStatement("select * from Policy where policyId=?");
			ps.setInt(1, policyId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Policy p=new Policy();
				p.setPolicyId(rs.getInt(1));
				p.setPolicyName(rs.getString(2));
				p.setPolicyType(rs.getString(3));
				return p;
			}
			else
			{
				throw new PolicyNotFoundException("policy not found for the id"+policyId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}

	@Override
	public Collection<Policy> getAllPolicies() throws PoliciesNotFouund {
		Collection<Policy> policies=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from Policy");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Policy p=new Policy();
				p.setPolicyId(rs.getInt(1));
				p.setPolicyName(rs.getString(2));
				p.setPolicyType(rs.getString(3));
				policies.add(p);
			}
			if(policies.isEmpty())
			{
				throw new PoliciesNotFouund("There are currently no policies");
			}
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return policies;
	}

	@Override
	public boolean updatePolicy(Policy policy) throws PolicyNotFoundException {
		try {
	        PreparedStatement ps = con.prepareStatement("update Policy set policyName=?, policyType=? where policyId=?");
	        ps.setString(1, policy.getPolicyName());
	        ps.setString(2, policy.getPolicyType());
	        ps.setInt(3, policy.getPolicyId());

	        int rowsAffected = ps.executeUpdate();
	        if(rowsAffected==0)
	        {
	        	throw new PolicyNotFoundException("policy not found with id"+policy.getPolicyId());
	        }
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace(); // Handle the exception appropriately (logging, throwing a custom exception, etc.)
	        return false;
	    }
	}

	@Override
	public boolean deletePolicy(int policyId) throws PolicyNotFoundException {
		try {
			PreparedStatement ps=con.prepareStatement("delete from Policy where policyId=?");
			ps.setInt(1, policyId);
			int i=ps.executeUpdate();
			if(i==0)
			{
				throw new PolicyNotFoundException("The policy is not there with id"+policyId);
			}
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		// TODO Auto-generated method stub
		
	}
	public String closeConnection() {
        DBConnUtil.closeConnection(con);
        return "connection closed";
    }

}
