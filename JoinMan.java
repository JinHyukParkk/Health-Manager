import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class JoinMan extends JFrame implements ActionListener{
	InfoManager infog;			//메니저의 해쉬맵에 아이디와 비밀번호 저장하기 위해
	JTextField idf;				//아이디 텍스트 필드
	JPasswordField passf;		//비밀번호 패스워드 필드
	JPasswordField passff;		//비밀번호 확인 패스워드 필드
	JButton ok;					//가입 창의 확인 버튼
	JButton cancel;				//가입 창의 취소 버튼

	public JoinMan(InfoManager temp_infog){
		infog = temp_infog;
		setTitle("관리자 추가");
		setLayout(new BorderLayout());
		Border border=BorderFactory.createEtchedBorder();
		JPanel passp = new JPanel();
		passp.setLayout(new GridLayout(4,1));

		JLabel scp = new JLabel("가입하실 아이디와 패스워드를 입력하시오");
		scp.setHorizontalAlignment(JLabel.CENTER);
		passp.add(scp);

		Border b=BorderFactory.createTitledBorder(border, "Id");
		Border c=BorderFactory.createTitledBorder(border, "Password");
		Border d=BorderFactory.createTitledBorder(border, "Password 확인");
		JPanel idfp = new JPanel();
		JPanel passfp = new JPanel();
		JPanel passffp = new JPanel();
		idf = new JTextField(20);
		passf = new JPasswordField(20);
		passff = new JPasswordField(20);
		passff.addActionListener(this);
		idf.setBorder(b);
		passf.setBorder(c);
		passff.setBorder(d);
		idfp.add(idf);
		passfp.add(passf);
		passffp.add(passff);
		passp.add(idfp);
		passp.add(passfp);
		passp.add(passffp);
		add("Center",passp);

		JPanel okp = new JPanel();
		ok = new JButton("확인");
		cancel = new JButton("취소");
		ok.addActionListener(this);
		cancel.addActionListener(this);
		okp.add(ok);
		okp.add(cancel);
		add("South", okp);

		setSize(300,300);
		setVisible(true);

	}
	public boolean blankinsp(String text){     //빈칸 메소드
		if(text == null || text.trim().equals("")){
			return true;
		}
		return false;
	}
	public void warning(String text){			//오류 메시지 출력
		JOptionPane.showMessageDialog(null, text, "Message",
				JOptionPane.ERROR_MESSAGE);}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ok || e.getSource() == passff){
			String id = idf.getText();
			String pass = passf.getText();
			String passw = passff.getText();
			if(blankinsp(id)){
				warning("빈칸을 채워 주세요.");
				idf.requestFocus();
			}else if(blankinsp(pass)){
				warning("빈칸을 채워 주세요.");
				passf.requestFocus();
			}else if(blankinsp(passw)){
				warning("빈칸을 채워 주세요.");
				passff.requestFocus();
			}else if(infog.map.containsKey(id)){
				warning("이미 가입된 아이디가 존재합니다.");
				idf.setText("");
				passf.setText("");
				passff.setText("");
				idf.requestFocus();
			}else{
				if(pass.equals(passw)){
					infog.map.put(id,passw);
					savehashfile();
				}else{
					warning("패스워드가 일치하지 않습니다.");
					passf.setText("");
					passff.setText("");
					passf.requestFocus();
					return;
				}
				JOptionPane.showMessageDialog(null, "가입되었습니다.", "Message",
						JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		}else if(e.getSource() == cancel){
			dispose();
		}
	}
	public void savehashfile(){            //메니저 아이디,비번 파일저장 메소드
		FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try{
            fout = new FileOutputStream("ManagerSave.dat");
            oos = new ObjectOutputStream(fout);
            oos.writeObject(infog.map);
            oos.reset();
            oos.writeObject(infog.map);
            oos.reset();
            System.out.println("ManagerSave 파일에 저장되었습니다.");
        }catch(Exception ex){
        }finally{
            try{
                oos.close();
                fout.close();
            }catch(IOException ioe){}
        } // finally
	}
}
