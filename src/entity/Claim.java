
package entity;
import java.util.Date;

public class Claim {
	private int claimId;
	private int claimNumber;
	private Date dateFiled;
	private long claimAmount;
	public Claim(int claimId, int claimNumber, Date dateFiled, long claimAmount, String status, Policy policy,
			Client client) {
		this.claimId = claimId;
		this.claimNumber = claimNumber;
		this.dateFiled = dateFiled;
		this.claimAmount = claimAmount;
		this.status = status;
		this.policy = policy;
		this.client = client;
	}
	private String status;
	private Policy policy;
	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public int getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(int claimNumber) {
		this.claimNumber = claimNumber;
	}
	public Date getDateFiled() {
		return dateFiled;
	}
	public void setDateFiled(Date dateFiled) {
		this.dateFiled = dateFiled;
	}
	public long getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(long claimAmount) {
		this.claimAmount = claimAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	private Client client;

}
