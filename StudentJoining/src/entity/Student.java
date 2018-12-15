package entity;

public class Student {
	
	private String sname;
	private String smail;
	private int smarks;
	private String slocation;
	private int sId;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getSlocation() {
		return slocation;
	}
	public void setSlocation(String slocation) {
		this.slocation = slocation;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSmail() {
		return smail;
	}
	public void setSmail(String smail) {
		this.smail = smail;
	}
	public int getSmarks() {
		return smarks;
	}
	public void setSmarks(int smarks) {
		this.smarks = smarks;
	}
	@Override
	public String toString() {
		return "Student [sname=" + sname + ", smail=" + smail + ", smarks=" + smarks + ", slocation=" + slocation
				+ ", sId=" + sId + "]\n";
	}
	

}
