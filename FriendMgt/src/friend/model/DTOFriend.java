package friend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name = "friend")
public class DTOFriend{
	
	//states==>property,attribute,field...........
	@Id
	@GeneratedValue
	private int NUM;// friend identifier
	private String NAMES;//friend name
	private String TEL;
	private String ADDR;
	
	public int getNUM() {
		return NUM;
	}
	@Override
	public String toString() {
		return "DTOFriend [NAMES=" + NAMES + ", TEL=" + TEL
				+ ", ADDR=" + ADDR + "]";
	}
	public void setNUM(int nUM) {
		NUM = nUM;
	}
	public String getNAMES() {
		return NAMES;
	}
	public void setNAMES(String nAMES) {
		NAMES = nAMES;
	}
	public String getTEL() {
		return TEL;
	}
	public void setTEL(String tEL) {
		TEL = tEL;
	}
	public String getADDR() {
		return ADDR;
	}
	public void setADDR(String aDDR) {
		ADDR = aDDR;
	}
	
}
