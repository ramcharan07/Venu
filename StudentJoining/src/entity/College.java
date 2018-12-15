package entity;

public class College {
	private int cId;
	private String cname;
	private String clocation;
	private String cmarks;
	public String getCmarks() {
		return cmarks;
	}
	public void setCmarks(String cmarks) {
		this.cmarks = cmarks;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getClocation() {
		return clocation;
	}
	public void setClocation(String clocation) {
		this.clocation = clocation;
	}
	@Override
	public String toString() {
		return "College [cId=" + cId + ", cname=" + cname + ", clocation=" + clocation + ", cmarks=" + cmarks + "]\n";
	}
	

}
