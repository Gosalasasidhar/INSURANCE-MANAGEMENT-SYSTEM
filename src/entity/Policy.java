package entity;

public class Policy {
	private int policyId;
	private String policyName;
	private String policyType;
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	@Override
    public String toString() {
        return "policyId=" + policyId +System.lineSeparator()+
                "policyName='" + policyName + System.lineSeparator() +
                "policyType='" + policyType + System.lineSeparator() ;
	}

}
