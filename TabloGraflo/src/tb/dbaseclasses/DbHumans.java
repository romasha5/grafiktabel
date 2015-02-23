//Клас-обгортка для таблиці Humans
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
	private Integer timeId;
	private String timeName;
	
	
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
	
	public Integer getTimeId() {
		return timeId;
	}
	public void setTimeId(Integer timeId) {
		this.timeId = timeId;
	}
	public String getTimeName() {
		return timeName;
	}
	public void setTimeName(String timeName) {
		this.timeName = timeName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public DbHumans (String lastname, String name, String fathersname,
				String position, Integer tablenumber, Float percent, String sex,
				Integer timeId){
		this.lastname=lastname;
		this.name=name;
		this.fathersname=fathersname;
		this.position=position;
		this.tablenumber=tablenumber;
		this.percent=percent;
		this.sex=sex;
		this.timeId=timeId;
	}
	

}
