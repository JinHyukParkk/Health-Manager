import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

//메니저 클래스
public class InfoManager extends JFrame implements ActionListener{
	JTextArea textArea;			//메인 창의 Infomation Board
	JTextField textField;		//회원 이름 텍스트 필드
	JTextField idf;				//로그인 창 아이디 텍스트 필드
	JPasswordField passtf;		//로그인 창 패스워드 필드
	CardLayout cardLayout;		//로그인 창에서 메인 창으로 넘어갈 때의 카드레이아웃 선언
	Container pane;				//로그인 창에서 메인 창으로 널어갈 때 필요한 컨테이너 선언
	JMenuItem list;				//메뉴바의 리스트
	JMenuItem save;				//메뉴바의 저장
	JMenuItem quit;				//메뉴바의 종료
	JMenuItem logout; 			//메뉴바의 로그아웃
	JButton check;				//로그인 창의 확인 버튼
	JButton join;				//로그인 창의 가입 버튼
	JButton login_quit;			//로그인 창의 종료 버튼
	JButton schb;				//메인 창의 검색 버튼
	JButton adjb;				//메인 창의 수정 버튼
	JButton addb;				//메인 창의 회원등록 버튼
	JButton delb;				//메인 창의 삭제 버튼
	JButton saveB;				//메인 창의 저장 버튼
	JButton listB;				//메인 창의 리스트 버튼
	JButton quitB;				//메인 창의 종료 버튼
	HashMap<String, String> map  = new HashMap<>();		//아이디, 패스워드 저장 해쉬맵
	String id = null;			//로그인 한 아이디 저장
	String colName[] = {"번호","이름"};		//J테이블 제목
	DefaultTableModel model;				//J테이블 모델
	JScrollPane tableScroll;				//J테이블 스크롤
	public ArrayList<Info> infolist= new ArrayList<Info>();				//회원 정보
	public ArrayList<Health> heallist = new ArrayList<Health>(); 		//회원 신체, 무술 정보

	public InfoManager(String title){							// 로그인창, 메인창GUI
		super(title);											//제목
		loadhashfile();											//Manager 데이터 정보 모아오기
		cardLayout = new CardLayout();							//카드레이아웃 생성
		setLayout(cardLayout);									//카드레이아웃을 쓰기 위한 세팅
		setDefaultCloseOperation(EXIT_ON_CLOSE);				//프로세스까지 종료
		Border border=BorderFactory.createEtchedBorder();		//BorderFactory를 이용하여 GUI 디자인.

	    //로그인 창

		pane = getContentPane();								//카드레이아웃 파라미터로 쓸때 필요 컨데이너 생성
		JPanel loginp = new JPanel();							//로그인 판넬
		loginp.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		JLabel loginl = new JLabel("무술센터 매니저 로그인");
		loginl.setHorizontalAlignment(JLabel.CENTER);			//라벨 위치
		p.add(loginl);
		loginp.add("North", p);
		//아이디, 패스워드 창
		Border b=BorderFactory.createTitledBorder(border, "ID");			// 박스 씌우기
		Border c=BorderFactory.createTitledBorder(border, "Password");
		JPanel passp = new JPanel();
		passp.setLayout(new BorderLayout());
		JPanel idpanel  = new JPanel();
		idf = new JTextField(20);
		idpanel.add(idf);
		JPanel passpanel = new JPanel();
		passtf = new JPasswordField(20);
		passpanel.add(passtf);

		passtf.addActionListener(this);
		idpanel.setBorder(b);
		passpanel.setBorder(c);
		passp.add("North",idpanel);
		passp.add("South",passpanel);
		loginp.add("Center", passp);

		JPanel checkp = new JPanel();
		check = new JButton("로그인");
		join = new JButton("가입");
		login_quit = new JButton("종료");
		checkp.setLayout(new FlowLayout());
		checkp.add(join);
		checkp.add(check);
		checkp.add(login_quit);
		loginp.add("South", checkp);
		check.addActionListener(this);
		join.addActionListener(this);
		login_quit.addActionListener(this);
		setSize(300,220);
		pane.add("loginp", loginp);

		//메인 창
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());
		textArea=new JTextArea(20, 25);
		textArea.setEditable(false);

		//등록
		addb=new JButton("회원 등록");
		addb.setPreferredSize(new Dimension(110,20));
		addb.addActionListener(this);

		//선택 창
		Border a=BorderFactory.createTitledBorder(border, "Member Infomation");
		Border add_border=BorderFactory.createTitledBorder(border, "New");
		JPanel edit = new JPanel();
		edit.setLayout(new BorderLayout());

		//선택창 내부 구성
		JPanel to = new JPanel();
		JPanel sel=new JPanel();
		to.setLayout(new BorderLayout());
		to.setBorder(a);
		adjb=new JButton("수정");
		schb=new JButton("검색");
		delb=new JButton("삭제");
		JPanel textp = new JPanel();
		JLabel namep = new JLabel("회원 이름 : ");
		textField = new JTextField(5);
		textp.add(namep);
		textp.add(textField);
		to.add("North",textp);
		sel.setLayout(new FlowLayout());
		sel.add(schb);
		sel.add(adjb);
		sel.add(delb);
		delb.addActionListener(this);
		schb.addActionListener(this);
		adjb.addActionListener(this);
		to.add(sel);

		//save, list, quit
		JPanel menuP = new JPanel(new GridLayout(3,1));
		listB=new JButton("리스트");
		saveB=new JButton("저장");
		quitB=new JButton("종료");
		saveB.addActionListener(this);
		listB.addActionListener(this);
		quitB.addActionListener(this);
		menuP.add(listB);
		menuP.add(saveB);
		menuP.add(quitB);
		edit.add("East",menuP);
		edit.add("West",addb);
		edit.add("Center",to);

		//메뉴바
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("MENU");

		list = new JMenuItem("리스트");
		save = new JMenuItem("저장");
		logout = new JMenuItem("로그아웃");
		quit = new JMenuItem("종료");
		list.addActionListener(this);
		save.addActionListener(this);
		logout.addActionListener(this);
		quit.addActionListener(this);

		fileMenu.add(list);
		fileMenu.add(save);
		fileMenu.addSeparator();
		fileMenu.add(logout);
		fileMenu.add(quit);
		mb.add(fileMenu);

		//텍스트 보드
		JScrollPane scrollTextArea=new JScrollPane(textArea);
		Border textBorder=BorderFactory.createTitledBorder(border, "Infomation Board");
		scrollTextArea.setBorder(textBorder);

		//리스트 테이블, 마우스 리스너
		Border listBorder=BorderFactory.createTitledBorder(border, "Body Check");
		model = new DefaultTableModel(colName,0){
			@Override
			public boolean isCellEditable(int row, int column) {
	        // TODO Auto-generated method stub
	    	if (column >= 0){
	    		return false;
	        }else{
	        	return true;
	        	}
	    	}
		};
		JTable table = new JTable(model);
		table.addMouseListener(new MouseListener() {
	         @Override
	         public void mouseClicked(MouseEvent e) {
	            // TODO Auto-generated method stub
	            if (e.getClickCount() == 2){
	            	 Point point = e.getPoint();
	                 int row,column;
	                 row = table.rowAtPoint(point);
	                 column = table.columnAtPoint(point);
	                 Object oc = table.getValueAt(row,column);
	                 String name = (String)oc;
	                 throwclass(name);                      // Exercise 클래스 실행 메소드
	            }
	         }
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		}
		);
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();    //가운데 정렬
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		table.getColumn("번호").setPreferredWidth(40);                                //셀 간격
		table.getColumn("번호").setCellRenderer(celAlignCenter);
		table.getColumn("이름").setCellRenderer(celAlignCenter);

		tableScroll = new JScrollPane(table);
		tableScroll.setBorder(listBorder);
		tableScroll.setPreferredSize(new Dimension(110,200));


		main.add(tableScroll, BorderLayout.WEST);
		main.add(edit, BorderLayout.SOUTH);
		main.add(scrollTextArea, BorderLayout.CENTER);
		main.add(mb, BorderLayout.NORTH);
		pane.add("main", main);


		cardLayout.show(pane, "loginp");
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	public void throwclass(String name){
		new Exercise(this, get_id(), name);
	}
	public String get_id(){
		return this.id;
	}
	public boolean changecard(String id, String passh, String passw, int x, int y){     //메인창GUT으로 카드레이아웃
		if(map.containsKey(id) && passw.equals(passh)){
			setSize(x,y);
			input(id);
			Healthinput(id);
			model.setNumRows(0);
			resetlist(id);
			cardLayout.show(pane, "main");
			return false;
		}else{
			JOptionPane.showMessageDialog(null, "패스워드를 틀리셨습니다.", "Message",
					JOptionPane.WARNING_MESSAGE);
			passtf.setText("");
			passtf.requestFocus();
			return true;}
	}
	public void deleteInfo(String name){    //데이터 삭제 메소드
		boolean is = true;
		for(int i=0; i<infolist.size(); i++){
			if(id.equals(infolist.get(i).get_id()) && name.equals(infolist.get(i).get_name())){
				is = false;
				infolist.remove(i);
				JOptionPane.showMessageDialog(null, "삭제되었습니다.", "Message",
						JOptionPane.INFORMATION_MESSAGE);
				resetlist(id);
			}
		}
		if(is){
			JOptionPane.showMessageDialog(null, "삭제하려는 이름이 없습니다.", "Message",
					JOptionPane.INFORMATION_MESSAGE);
			resetlist(id);
		}
		textField.setText("");
		textField.requestFocus();
	}
	public void deleteHeal(String name){    //Health 객체 삭제 메소드
		for(int i=0; i<heallist.size(); i++){
			if(id.equals(heallist.get(i).get_id()) && name.equals(heallist.get(i).get_name())){
				heallist.remove(i);
			}
		}
	}
	public void searchInfo(String name){    //데이터 찾기, 출력 메소드
		boolean is = true;
		for(int i=0; i<infolist.size(); i++){
			if(id.equals(infolist.get(i).get_id()) && name.equals(infolist.get(i).get_name())){
				is = false;
				textArea.append("--------------------------------------------\n");
				textArea.append(infolist.get(i).toString()+"\n");
			}
		}
		boolean as = true;
		for(int i=0; i<heallist.size(); i++){
			if(id.equals(heallist.get(i).get_id()) && name.equals(heallist.get(i).get_name())){
				as = false;
				textArea.append(heallist.get(i).toString()+"\n");
				textArea.append("--------------------------------------------\n");
			}
		}
		if(is==false && as){
			textArea.append("--------------------------------------------\n");
		}
		if(is){
			JOptionPane.showMessageDialog(null, "찾으시는 이름이 없습니다.", "Message",
					JOptionPane.INFORMATION_MESSAGE);
		}
		textField.setText("");
		textField.requestFocus();
	}
	public void adjustInfo(String name){    //데이터 수정 메소드
		int search = 0;
		boolean is = false;
		for(int i=0; i<infolist.size(); i++){
			if(id.equals(infolist.get(i).get_id()) && name.equals(infolist.get(i).get_name())){
				search = i;
				is = true;
			}
		}
		if(is){
			new AdjustFrame(this, search);
		}
		else{
			JOptionPane.showMessageDialog(null, "수정하려는 이름정보가 없습니다..", "Message",
				JOptionPane.WARNING_MESSAGE);}
		textField.setText("");
		textField.requestFocus();
	}
	public void logOut(int x, int y){       //로그아웃 메소드
		setSize(x,y);
		cardLayout.show(pane, "loginp");
		idf.setText("");
		passtf.setText("");
		idf.requestFocus();
		textArea.setText("");
	}
	public void resetlist(String id){       //바디체크 리스트 수정 메소드
		//
		String row[][] = new String[infolist.size()][2];
		int count = 0;
		for(int i=0; i<infolist.size(); i++){
			if(id.equals(infolist.get(i).get_id())){
				count++;
				row[i][0] = Integer.toString(count);
				row[i][1] = infolist.get(i).get_name();
				model.addRow(row[i]);}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == join){
			new JoinMan(this);
		}
		if(e.getSource() == check || e.getSource() == passtf){
			id = idf.getText();
			String passh = passtf.getText();
			String passw = map.get(id);
			if(changecard(id,passh,passw,450,470)){
				return;}
		}
		if(e.getSource() == login_quit || e.getSource() == quitB){
			System.exit(1);
		}
		if(e.getSource() == addb){
			model.setNumRows(0);
			new AddFrame(this);
		}else if(e.getSource() == delb){
			String name = textField.getText();
			model.setNumRows(0);
			deleteInfo(name);
			deleteHeal(name);
		}else if(e.getSource() == schb){
			String name = textField.getText();
			searchInfo(name);
		}else if(e.getSource() == adjb){
			String name = textField.getText();
			adjustInfo(name);
		}else if(e.getSource() == list || e.getSource() == listB){
			new ListFrame(this);
		}else if(e.getSource() == save || e.getSource() == saveB){
			output(id);
			Healthoutput(id);
			JOptionPane.showMessageDialog(null, "저장되었습니다.", "Message",
					JOptionPane.INFORMATION_MESSAGE);;
		}else if(e.getSource() == logout){
			logOut(300,220);
		}else if(e.getSource() == quit)
			System.exit(1);
	}

	public void output(String id){			// info 객체 파일 저장
    	FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try{
            fout = new FileOutputStream("Infodata.dat");
            oos = new ObjectOutputStream(fout);

            oos.writeObject(infolist);
            oos.reset();
            oos.writeObject(infolist);
            oos.reset();

        }catch(Exception ex){
        }finally{
            try{
                oos.close();
                fout.close();
            }catch(IOException ioe){}
        } // finally
    }
	public void Healthoutput(String id){	// heal 객체 파일 저장
    	FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try{
            fout = new FileOutputStream("Healdata.dat");
            oos = new ObjectOutputStream(fout);

            oos.writeObject(heallist);
            oos.reset();
            oos.writeObject(heallist);
            oos.reset();

        }catch(Exception ex){
        }finally{
            try{
                oos.close();
                fout.close();
            }catch(IOException ioe){}
        } // finally
    }

    public void input(String id)            // info 객체 파일 읽기
	{
	FileInputStream fin = null;
	ObjectInputStream ois = null;

	try{
		fin = new FileInputStream("Infodata.dat");
		ois = new ObjectInputStream(fin);

		infolist = (ArrayList)ois.readObject();

	}catch(Exception ex){
	}finally{
		try{
			if(ois != null){
				ois.close();
				fin.close();}
		}catch(IOException ioe){}
	}// finally
	}
    public void Healthinput(String id)      // heal 객체 파일 읽기
	{
	FileInputStream fin = null;
	ObjectInputStream ois = null;

	try{
		fin = new FileInputStream("Healdata.dat");
		ois = new ObjectInputStream(fin);

		heallist = (ArrayList)ois.readObject();

	}catch(Exception ex){
	}finally{
		try{
			if(ois != null){
				ois.close();
				fin.close();}
		}catch(IOException ioe){}
	}// finally
	}

    public void loadhashfile(){             // 메니저 아이디, 비밀번호 Hashmap파일 읽기
    	FileInputStream fin = null;
    	ObjectInputStream ois = null;

    	try{
    		fin = new FileInputStream("ManagerSave.dat");
    		ois = new ObjectInputStream(fin);

    		map = (HashMap)ois.readObject();

    	}catch(Exception ex){
    	}finally{
    		try{
    			if(ois != null){
    				ois.close();
    				fin.close();}
    		}catch(IOException ioe){}
    	}// finally
    	}
}
