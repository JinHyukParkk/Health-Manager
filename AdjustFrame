import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class AdjustFrame extends JFrame implements ActionListener{
	JTextField tfName;
	JTextField tfYear;
	JTextField tfAddress;
	JTextField tfMonth;
	JTextField tfDate;
	JTextField tfTel1;
	JTextField tfTel2;
	JTextField tfTel3;
	JTextField tfschool;
	JTextField tfgrade;
	JTextField tfcompany;
	JTextField tflevel;
	JTextField sometext;
	JPanel jobkind;
	GridBagLayout gb;
	GridBagConstraints gbc;
	CardLayout cardLayout;
	JRadioButton rbMan;
	JRadioButton rbWoman;
	JRadioButton rbA;
	JRadioButton rbB;
	JRadioButton rbO;
	JRadioButton rbAB;
	JComboBox cbJob;
	JButton btnInsert;
	JButton cancel;
	private String name;
	private String phonenum;
	private String year;
	private String gender;
	private String job;
	private String address;
	private String blood;
	private String id;
	private String thing;
	private String univ;
	private String grade;
	private String company;
	private String level;
	String kind;
	InfoManager infomg;
	int infonum;

	Container contentPane;

	public AdjustFrame(InfoManager infog, int infonum){      //수정GUI
		infomg = infog;
		id = infomg.id;
		this.infonum = infonum;
		setTitle("정보 수정");
		gb = new GridBagLayout();
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		setLayout(gb);
		//이름
		JLabel bname = new JLabel("이름 : ");
		tfName = new JTextField(10);
		tfName.setText(infog.infolist.get(infonum).get_name());
		tfName.setEditable(false);
		gbAdd(bname,0,1,1,1);
		gbAdd(tfName,1,1,3,1);
		//생년월일
		JLabel bBirth = new JLabel("생년월일 : ");
		tfYear = new JTextField(6);
		tfYear.setText(infog.infolist.get(infonum).get_year().substring(0, 4));
		tfMonth = new JTextField(6);
		tfMonth.setText(infog.infolist.get(infonum).get_year().substring(6, 8));
		tfDate = new JTextField(6);
		tfDate.setText(infog.infolist.get(infonum).get_year().substring(10, 12));
		JPanel pBirth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pBirth.add(tfYear);
		pBirth.add(new JLabel("/"));
		pBirth.add(tfMonth);
		pBirth.add(new JLabel("/"));
		pBirth.add(tfDate);
		gbAdd(bBirth,0,2,1,1);
		gbAdd(pBirth,1,2,3,1);
		//전화
		JLabel bTel = new JLabel("전화 :");
		JPanel pTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tfTel1 = new JTextField(6);
		tfTel1.setText(infog.infolist.get(infonum).get_phonenum().substring(0, 3));
		tfTel2 = new JTextField(6);
		tfTel2.setText(infog.infolist.get(infonum).get_phonenum().substring(4, 8));
		tfTel3 = new JTextField(6);
		tfTel3.setText(infog.infolist.get(infonum).get_phonenum().substring(9, 13));
		pTel.add(tfTel1);
		pTel.add(new JLabel(" - "));
		pTel.add(tfTel2);
		pTel.add(new JLabel(" - "));
		pTel.add(tfTel3);
		gbAdd(bTel, 0,3,1,1);
		gbAdd(pTel, 1,3,3,1);
		//주소
		JLabel bAddress = new JLabel("주소 : ");
		tfAddress = new JTextField(10);
		tfAddress.setText(infog.infolist.get(infonum).get_address());
		gbAdd(bAddress,0,4,1,1);
		gbAdd(tfAddress,1,4,3,1);
		//성별
		JLabel bGender = new JLabel("성별 : ");
		JPanel pGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rbMan = new JRadioButton("남자",true);
		rbWoman = new JRadioButton("여자",true);
		String genderkind = infog.infolist.get(infonum).get_gender();
		if(genderkind.equals("A형")){
	        rbA.setSelected(true);
	     }else if(genderkind.equals("B형")){
	        rbB.setSelected(true);
	     }
		ButtonGroup group = new ButtonGroup();
		group.add(rbMan);
		group.add(rbWoman);
		pGender.add(rbMan);
		pGender.add(rbWoman);
		gbAdd(bGender, 0,5,1,1);
		gbAdd(pGender,1,5,3,1);
		//혈액형
		JLabel bBlood = new JLabel("성별 : ");
		JPanel pBlood = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rbA = new JRadioButton("A형",true);
		rbB = new JRadioButton("B형",true);
		rbO = new JRadioButton("O형",true);
		rbAB = new JRadioButton("AB형",true);
		String bloodkind = infog.infolist.get(infonum).get_blood();
		if(bloodkind.equals("A형")){
	        rbA.setSelected(true);
	     }else if(bloodkind.equals("B형")){
	        rbB.setSelected(true);
	     }else if(bloodkind.equals("O형")){
		        rbO.setSelected(true);
	     }else if(bloodkind.equals("AB형")){
		        rbAB.setSelected(true);
	     }
		ButtonGroup bloodgroup = new ButtonGroup();
		bloodgroup.add(rbA);
		bloodgroup.add(rbB);
		bloodgroup.add(rbO);
		bloodgroup.add(rbAB);
		pBlood.add(rbA);
		pBlood.add(rbB);
		pBlood.add(rbO);
		pBlood.add(rbAB);
		gbAdd(bBlood, 0,6,1,1);
		gbAdd(pBlood,1,6,3,1);
		//직업
		JLabel bJob = new JLabel("직업 : ");
		String[] arrJob = {"---","일반인", "학생", "직장인"};
		cbJob = new JComboBox(arrJob);
		cbJob.setSelectedItem(infog.infolist.get(infonum).get_job());
		cbJob.addActionListener(this);
		JPanel pJob = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pJob.add(cbJob);
		gbAdd(bJob,0,7,1,1);
		gbAdd(pJob,1,7,3,1);
		//상속자들
		jobkind = new JPanel(cardLayout = new CardLayout());
		gbAdd(jobkind,0,8,4,1);
		//빈칸
		JPanel blank = new JPanel();
		jobkind.add("---",blank);

		//하는일
		JLabel some = new JLabel("하는일 : ");
		sometext = new JTextField(20);
		JPanel person_some = new JPanel();
		person_some.add(some);
		person_some.add(sometext);
		jobkind.add("일반인",person_some);
		//학교,학년
		JPanel sch = new JPanel(new BorderLayout());
		JPanel a = new JPanel();
		JPanel b = new JPanel();
		JLabel lbschool = new JLabel("학교/전공 : ");
		JLabel lbgrade = new JLabel("학년 : ");
		tfschool = new JTextField(20);
		tfgrade = new JTextField(20);
		a.add(lbschool);
		a.add(tfschool);
		b.add(lbgrade);
		b.add(tfgrade);
		sch.add("North", a);
		sch.add("South", b);
		jobkind.add("학생",sch);
		//직장, 직급
		JPanel comp = new JPanel(new BorderLayout());
		JPanel c = new JPanel();
		JPanel d = new JPanel();
		JLabel lbcompany = new JLabel("회사 : ");
		JLabel lblevel = new JLabel("직급 : ");
		tfcompany = new JTextField(20);
		tflevel = new JTextField(20);
		c.add(lbcompany);
		c.add(tfcompany);
		d.add(lblevel);
		d.add(tflevel);
		comp.add("North", c);
		comp.add("South", d);
		jobkind.add("직장인",comp);

		if(infog.infolist.get(infonum).get_job().equals("일반인")){
			sometext.setText(infog.infolist.get(infonum).get_thing());
		}else if(infog.infolist.get(infonum).get_job().equals("학생")){
			tfschool.setText(infog.infolist.get(infonum).get_univ());
			tfgrade.setText(infog.infolist.get(infonum).get_grade());
		}else if(infog.infolist.get(infonum).get_job().equals("직장인")){
			tfcompany.setText(infog.infolist.get(infonum).get_company());
			tflevel.setText(infog.infolist.get(infonum).get_level());
		}
		//버튼
		JPanel pButton = new JPanel();
		btnInsert = new JButton("확인");
		cancel = new JButton("취소");
		btnInsert.addActionListener(this);
		cancel.addActionListener(this);
		pButton.add(btnInsert);
		pButton.add(cancel);
		gbAdd(pButton,0,10,4,1);

		setSize(400,400);
		setVisible(true);
	}
	private void gbAdd(JComponent c, int x, int y, int w, int h){   //판넬위치 정하는 메소드
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		//gb.setConstraints(c, gbc);
		gbc.insets = new Insets(2, 2, 2, 2);
		add(c, gbc);
	}
	public boolean blankinsp(String text){     //빈칸 찾는 메소드
		if(text == null || text.trim().equals("")){
			return true;
		}
		return false;
	}
	public boolean overlapName(String name){    //이름 중복 찾는 메소드
		for(int i=0; i<infomg.infolist.size(); i++){
			if(id.equals(infomg.infolist.get(i).get_id()) && name.equals(infomg.infolist.get(i).get_name())){
				JOptionPane.showMessageDialog(null, "이름이 중복됩니다.", "Message",
						JOptionPane.ERROR_MESSAGE);
				return true;
			}
		}
		return false;
	}
	public void warning(String text){			//오류 메시지 출력
		JOptionPane.showMessageDialog(null, text, "Message",
				JOptionPane.ERROR_MESSAGE);}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cbJob){
			Object obj = cbJob.getSelectedItem();
			kind = (String)obj;
			cardLayout.show(jobkind,kind);
		}
		if(e.getSource() == btnInsert){
			name = tfName.getText();
			phonenum = tfTel1.getText()+tfTel2.getText()+tfTel3.getText();
			year = tfYear.getText()+tfMonth.getText()+tfDate.getText();
			//빈칸이 있을 때 리턴하는 조건문
			if(blankinsp(name) || blankinsp(phonenum) || blankinsp(year)){
				warning("빈칸을 채우시오.");
				return;}
			String pnum1 = tfTel1.getText();
			String pnum2 = tfTel2.getText();
			String pnum3 = tfTel3.getText();
			if(pnum1.length() != 3 || pnum2.length() != 4 || pnum3.length() != 4){
				warning("핸드폰번호를 다시 입력하세요.");
				return;}
			String gyear = tfYear.getText();
			String gmonth = tfMonth.getText();
			String gdate = tfDate.getText();
			int iyear = Integer.parseInt(gyear);
			int imonth = Integer.parseInt(gmonth);
			int idate = Integer.parseInt(gdate);
			if(gyear.length() != 4 || 2015 < iyear || iyear < 1000){
				warning("출생 년도를 다시 입력하시오.");
				return;
			}else if(gmonth.length() != 2 || 12 < imonth || imonth < 1){
				warning("출생 월을 다시 입력하시오.\n ex) 02월");
				return;
			}else if((imonth == 1 || imonth == 3|| imonth == 5 || imonth == 7 || imonth == 8 || imonth == 10 ||imonth == 12) && (idate < 1 || 31 < idate)){
				warning("출생 일을 다시 입력하시오.");
				return;
			}else if((imonth == 4 || imonth == 6|| imonth == 9 || imonth == 1) && (idate < 1 || 30 < idate)){
				warning("출생 일을 다시 입력하시오.");
				return;
			}else if(imonth == 2 && (idate < 1 || 28 < idate)){
				warning("출생 일을 다시 입력하시오.");
				return;
			}
			phonenum = tfTel1.getText()+"-"+tfTel2.getText()+"-"+tfTel3.getText();
			year = tfYear.getText()+"년 "+tfMonth.getText()+"월 "+tfDate.getText()+"일";
			//주소
			address = tfAddress.getText();
			//성별
		    if(rbMan.isSelected()){
		    	gender = "남자";
		    }else if(rbWoman.isSelected()){
		    	gender = "여자";
		    }
		    //혈액형
		    if(rbA.isSelected()){
		    	blood = "A형";
		    }else if(rbB.isSelected()){
		    	blood = "B형";
		    }else if(rbO.isSelected()){
		    	blood = "O형";
		    }else if(rbAB.isSelected()){
		    	blood = "AB형";
		    }
		    //직업
			Object jobo = cbJob.getSelectedItem();
			job = (String)jobo;
			//owner(id)
			infomg.infolist.remove(infonum);
			if(kind.equals("일반인")){
				thing = sometext.getText();
				infomg.infolist.add(infonum,new PersonInfo(name, gender, year, phonenum, job, address,blood, id, thing));
			}else if(kind.equals("학생")){
				univ = tfschool.getText();
				grade = tfgrade.getText();
				infomg.infolist.add(infonum,new UnivInfo(name, gender, year, phonenum, job, address,blood, id, univ, grade));
			}else if(kind.equals("직장인")){
				company = tfcompany.getText();
				level = tflevel.getText();
				infomg.infolist.add(infonum,new CompanyInfo(name, gender, year, phonenum, job, address,blood, id, company, level));
			}else{
				infomg.infolist.add(infonum,new Info(name, gender, year, phonenum, job, address,blood, id));
			}
			infomg.output(id);
			JOptionPane.showMessageDialog(null, "수정되었습니다.", "Message",
					JOptionPane.INFORMATION_MESSAGE);
			dispose();               //창 종료
		}else if(e.getSource() == cancel){
			dispose();
		}
	}
}
