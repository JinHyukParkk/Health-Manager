import java.io.Serializable;


public class Info implements Serializable{
	private String name;
	private String gender;
	private String year;
	private String phonenum;
	private String job;
	private String address;
	private String blood;
	private String id;

	public Info(String name,String gender, String year, String phonenum, String job,String address,String blood,String id){
		this.name = name;
		this.gender = gender;
		this.year = year;
		this.phonenum = phonenum;
		this.job = job;
		this.address = address;
		this.blood = blood;
		this.id = id;
	}
	public String get_company(){
		return "";
	}
	public String get_level(){
		return "";
	}
	public String get_univ(){
		return "";
	}
	public String get_grade(){
		return "";
	}
	public String get_thing(){
		return "";
	}
	public String toString(){
		return "이름 : "+name+'\n'+"생년월일 : "+year+"\n"+"핸드폰번호 : "+phonenum+"\n"+"주소 : "+address+"\n"+"성별 : "+gender+"\n"+"혈액형 : "+blood+"\n"+"직업 : "+job;
	}
	public String get_id(){
		return this.id;
	}
	public String get_blood(){
		return this.blood;
	}
	public String get_address(){
		return this.address;
	}
	public String get_name(){
		return this.name;
	}
	public String get_phonenum(){
		return this.phonenum;
	}
	public String get_year(){
		return this.year;
	}
	public String get_gender(){
		return this.gender;
	}
	public String get_job(){
		return this.job;
	}
}
class CompanyInfo extends Info{
	String company;
	String level;

	public CompanyInfo(String name,String gender, String year, String phonenum, String job,String address,String blood,String id,String company, String level){
		super(name,gender,year,phonenum, job, address, blood,id);
		this.company = company;
		this.level = level;
	}
	public String toString(){
		return super.toString()+"\n"+"회사 : "+company+"\n"+"직급 : "+level;
	}
	public String get_company(){
		return super.get_company()+this.company;
	}
	public String get_level(){
		return super.get_level()+this.level;
	}

}
class UnivInfo extends Info{
	String univ;
	String grade;
	public UnivInfo(String name,String gender, String year, String phonenum, String job,String address,String blood,String id,String univ, String grade){
		super(name,gender,year,phonenum, job, address, blood,id);
		this.univ = univ;
		this.grade = grade;
	}
	public String toString(){
		return super.toString()+"\n"+"학교 : "+univ+"\n"+"학년 : "+grade;
	}
	public String get_univ(){
		return super.get_univ()+this.univ;
	}
	public String get_grade(){
		return super.get_grade()+this.grade;
	}
}
class PersonInfo extends Info{
	String thing;
	public PersonInfo(String name,String gender, String year, String phonenum, String job,String address,String blood,String id,String thing){
		super(name,gender,year,phonenum, job, address, blood,id);
		this.thing = thing;
	}
	public String toString(){
		return super.toString()+"\n"+"하는일  : "+thing;
	}
	public String get_thing(){
		return super.get_thing()+this.thing;
	}
}
