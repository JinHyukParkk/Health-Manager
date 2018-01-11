import java.io.Serializable;


public class Health implements Serializable{
	String id;					//회원의 메너지 아이디
	String name;				//회원의 이름
	String height;				//회원의 키
	String weight;				//회원의 몸무게
	String skill;				//회원의 무술

	public Health(String id, String name,String height,String weight,String skill){
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.skill = skill;
	}
	public String toString(){
		return "키 : "+height+"cm"+"\n"+"몸무게 : "+weight+"kg"+"\n"+"배우는 무술 : "+skill;
	}
	public String get_id() {
		return id;
	}

	public String get_name() {
		return name;
	}

	public String get_height() {
		return height;
	}

	public String get_weight() {
		return weight;
	}

	public String get_skill() {
		return skill;
	}

}
