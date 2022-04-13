package dto;

public class MemberDTO {

	private int eNumber;
	private String eName;
	private String eId;
	private String ePw;
	
	public int geteNumber() {
		return eNumber;
	}
	public void seteNumber(int eNumber) {
		this.eNumber = eNumber;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}
	public String getePw() {
		return ePw;
	}
	public void setePw(String ePw) {
		this.ePw = ePw;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [eNumber=" + eNumber + ", eName=" + eName + ", eId=" + eId + ", ePw=" + ePw + "]";
	}
	
	
	

}
