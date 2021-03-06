import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class Exercise extends JFrame implements ActionListener{
	JTextField tfheight;		//무술 등록창의 키 텍스트 필드
	JTextField tfweight;		//무술 등록창의 몸무게 텍스트 필드
	JRadioButton boxing;		//무술 등록창의 복싱 라디오 버튼
	JRadioButton muatie;		//무술 등록창의 무에타이 라디오 버튼
	JRadioButton jujitsu;		//무술 등록창의 주짓수 라디오 버튼
	JRadioButton taegyundo;		//무술 등록창의 태권도 라디오 버튼
	JRadioButton gumdo;			//무술 등록창의 검도 라디오 버튼
	JRadioButton wrestling;		//무술 등록창의 레스팅 라디오 버튼
	JRadioButton kapoara;		//무술 등록창의 카포에라 라디오 버튼
	JRadioButton youdo;			//무술 등록창의 유도 라디오 버튼
	JRadioButton yuswu;			//무술 등록창의 우슈 라디오 버튼
	JButton ok;					//무술 등록창의 확인 버튼
	JButton cancel;				//무술 등록창의 취소 버튼
	InfoManager info;			//Heallist에 로그인 id와 회원 이름을 불러오기 위한 메니저 변수
	String id = null;			//Health 에 아이디 저장
	String name = null;			//Health 에 회원 이름 저장
	String height = null;		//Health 에 회원 키 저장
	String weight = null;		//Health 에 회원 몸무게 저장
	String skill = null;		//Health 에 회원 무술 저장

	public Exercise(InfoManager tempinfo,String id, String name){
		setTitle("Martial Arts");
		info = tempinfo;
		this.id = id;
		this.name = name;
		for(int i =0; i<info.heallist.size(); i++){
			if(name.equals(info.heallist.get(i).get_name()) && id.equals(info.heallist.get(i).get_id())){
				height = info.heallist.get(i).get_height();
				weight = info.heallist.get(i).get_weight();
				skill = info.heallist.get(i).get_skill();
			}
		}
		JPanel total = new JPanel(new BorderLayout());
		Border border=BorderFactory.createEtchedBorder();
		Border heightB=BorderFactory.createTitledBorder(border, "키");
		Border weightB=BorderFactory.createTitledBorder(border, "몸무게");
		JPanel bodyp = new JPanel(new FlowLayout());
		JPanel heightp = new JPanel();
		JPanel weightp = new JPanel();
		heightp.setBorder(heightB);
		weightp.setBorder(weightB);
		tfheight = new JTextField(10);
		tfheight.setText(height);
		tfweight = new JTextField(10);
		tfweight.setText(weight);
		heightp.add(tfheight);
		weightp.add(tfweight);
		bodyp.add(heightp);
		bodyp.add(weightp);

		JPanel artp = new JPanel(new BorderLayout());
		Border skillb=BorderFactory.createTitledBorder(border, "무술");
		artp.setBorder(skillb);
		JLabel top = new JLabel(name+"님이 배우고 싶은 무술 하나를 고르시오.");
		top.setHorizontalAlignment(JLabel.CENTER);
		JPanel artkind = new JPanel(new GridLayout(3,3));
		ButtonGroup artgroup = new ButtonGroup();
		boxing = new JRadioButton("복싱",true);
		muatie = new JRadioButton("무에타이",true);
		jujitsu = new JRadioButton("주짓수",true);
		taegyundo = new JRadioButton("태권도",true);
		gumdo = new JRadioButton("검도",true);
		wrestling = new JRadioButton("레슬링",true);
		kapoara = new JRadioButton("카포에라",true);
		youdo =  new JRadioButton("유도",true);
		yuswu =  new JRadioButton("우슈",true);
		artgroup.add(boxing);
		artgroup.add(muatie);
		artgroup.add(jujitsu);
		artgroup.add(taegyundo);
		artgroup.add(gumdo);
		artgroup.add(wrestling);
		artgroup.add(kapoara);
		artgroup.add(youdo);
		artgroup.add(yuswu);

		artkind.add(boxing);
		artkind.add(muatie);
		artkind.add(jujitsu);
		artkind.add(taegyundo);
		artkind.add(gumdo);
		artkind.add(wrestling);
		artkind.add(kapoara);
		artkind.add(youdo);
		artkind.add(yuswu);

		if(skill == null){
		}else{
			if(skill.equals("복싱")){
				boxing.setSelected(true);
		     }else if(skill.equals("무에타이")){
		    	 muatie.setSelected(true);
		     }else if(skill.equals("주짓수")){
		    	 jujitsu.setSelected(true);
		     }else if(skill.equals("태권도")){
		    	 taegyundo.setSelected(true);
		     }else if(skill.equals("검도")){
		    	 gumdo.setSelected(true);
		     }else if(skill.equals("레슬링")){
		    	 wrestling.setSelected(true);
		     }else if(skill.equals("카포에라")){
		    	 kapoara.setSelected(true);
		     }else if(skill.equals("유도")){
		    	 youdo.setSelected(true);
		     }else if(skill.equals("우슈")){
		    	 yuswu.setSelected(true);
		     }
		}

		artp.add("North",top);
		artp.add("Center", artkind);
		//확인 취소,
		JPanel but = new JPanel();
		JPanel okp = new JPanel();
		JPanel cancelp = new JPanel();
		ok = new JButton("확인");
		cancel = new JButton("취소");
		ok.addActionListener(this);
		cancel.addActionListener(this);
		okp.add(ok);
		cancelp.add(cancel);
		but.add(okp);
		but.add(cancel);

		total.add("North",bodyp);
		total.add("Center",artp);
		total.add("South",but);
		add(total);

		setSize(300,500);
		setVisible(true);
	}
	public boolean range(String text){     //String이 숫자인지 판별하는 메소드
		try{
			int num = Integer.parseInt(text);
		}catch(NumberFormatException e){
			return true;
		}
		return false;
	}
	public void warning(String text){			//오류 메시지 출력
		JOptionPane.showMessageDialog(null, text, "Message",
				JOptionPane.ERROR_MESSAGE);
	}
	public String selectedArts(){
		if(boxing.isSelected()){
	    	return "복싱";
	    }else if(muatie.isSelected()){
	    	return "무에타이";
	    }else if(jujitsu.isSelected()){
	    	return "주짓수";
	    }else if(taegyundo.isSelected()){
	    	return "태권도";
	    }else if(gumdo.isSelected()){
	    	return "검도";
	    }else if(wrestling.isSelected()){
	    	return "레슬링";
	    }else if(kapoara.isSelected()){
	    	return "카포에라";
	    }else if(youdo.isSelected()){
	    	return "유도";
	    }else if(yuswu.isSelected()){
	    	return "우슈";
	    }
		return null;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ok){
			String height2 = tfheight.getText();
			if(range(height2)){
				warning("키를 다시 입력하시오");
				tfheight.setText("");
				tfheight.requestFocus();
				return;
			}
			String weight2 = tfweight.getText();
			if(range(weight2)){
				warning("몸무게를 다시 입력하시오");
				tfweight.setText("");
				tfweight.requestFocus();
				return;
			}

			String arts = null;
			arts = selectedArts();

			boolean is = true;
			int search = 0;
			for(int i =0; i<info.heallist.size(); i++){
				if(name.equals(info.heallist.get(i).get_name()) && id.equals(info.heallist.get(i).get_id())){
					is = false;
					search=i;
					info.heallist.remove(i);
					info.heallist.add(i, new Health(id,name,height2,weight2,arts));
					JOptionPane.showMessageDialog(null, "수정되었습니다.", "Message",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
			if(is){
				info.heallist.add(new Health(id,name,height2,weight2,arts));
				JOptionPane.showMessageDialog(null, "등록되었습니다.", "Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
			dispose();
		}else if(e.getSource() == cancel){
			dispose();
		}
	}
}
