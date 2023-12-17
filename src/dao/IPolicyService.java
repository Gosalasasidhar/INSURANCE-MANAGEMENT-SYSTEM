package dao;
import java.util.Collection;

import entity.Policy;
import exceptionn.PoliciesNotFouund;
import exceptionn.PolicyAlreadyExists;
import exceptionn.PolicyNotFoundException;

public interface IPolicyService {
	boolean createPolicy(Policy policy) throws PolicyAlreadyExists;
	Policy getPolicy(int policyId) throws PolicyNotFoundException;
	Collection<Policy> getAllPolicies() throws PoliciesNotFouund;
	boolean updatePolicy(Policy policy) throws PolicyNotFoundException;
	boolean deletePolicy(int policyId) throws PolicyNotFoundException;
	
	

}
