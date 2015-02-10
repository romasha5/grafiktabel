package tb.dbaseclasses;

public class DbHumans  {
	
	private Integer id;
	private String lastname;
	private String name;
	private String fathersname;
	private String position;
	private Integer tablenumber;
	private Float percent;
	private String sex;
	private DbTime time;
	
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFathersname() {
		return fathersname;
	}
	public void setFathersname(String fathersname) {
		this.fathersname = fathersname;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Integer getTablenumber() {
		return tablenumber;
	}
	public void setTablenumber(Integer tablenumber) {
		this.tablenumber = tablenumber;
	}
	public Float getPercent() {
		return percent;
	}
	public void setPercent(Float percent) {
		this.percent = percent;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public DbTime getId_time() {
		return time;
	}
	public void setId_time(Integer id_time,String name_time) {
		this.time.setId(id_time);
		this.time.setName(name_time);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

}
