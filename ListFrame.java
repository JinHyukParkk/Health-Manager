import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


class ListFrame extends JFrame implements ActionListener{
	private String colName[] = {"번호","이름"};
	private DefaultTableModel model = new DefaultTableModel(colName,0);
	private DefaultTableModel model1 = new DefaultTableModel(colName,0);
	private DefaultTableModel model2 = new DefaultTableModel(colName,0);
	private DefaultTableModel model3 = new DefaultTableModel(colName,0);
	private DefaultTableModel model4 = new DefaultTableModel(colName,0);
	private DefaultTableModel model5 = new DefaultTableModel(colName,0);
	private DefaultTableModel model6 = new DefaultTableModel(colName,0);
	private DefaultTableModel model7 = new DefaultTableModel(colName,0);
	private DefaultTableModel model8 = new DefaultTableModel(colName,0);
	private JTable table = new JTable(model);
	private JTable table1 = new JTable(model1);
	private JTable table2 = new JTable(model2);
	private JTable table3 = new JTable(model3);
	private JTable table4 = new JTable(model4);
	private JTable table5 = new JTable(model5);
	private JTable table6 = new JTable(model6);
	private JTable table7 = new JTable(model7);
	private JTable table8 = new JTable(model8);
	private JPanel pan = new JPanel();
	private JPanel pan1 = new JPanel();
	private JPanel pan2 = new JPanel();
	private JPanel pan3 = new JPanel();
	private JPanel pan4 = new JPanel();
	private JPanel pan5 = new JPanel();
	private JPanel pan6 = new JPanel();
	private JPanel pan7 = new JPanel();
	private JPanel pan8 = new JPanel();
	private JScrollPane tableScroll;
	private JScrollPane tableScroll1;
	private JScrollPane tableScroll2;
	private JScrollPane tableScroll3;
	private JScrollPane tableScroll4;
	private JScrollPane tableScroll5;
	private JScrollPane tableScroll6;
	private JScrollPane tableScroll7;
	private JScrollPane tableScroll8;
	JButton ok;
	InfoManager infomg;


	public void savetable(String id, String text, DefaultTableModel model){
		String row[][] = new String[infomg.heallist.size()][2];
		int count = 0;
		for(int i=0; i<infomg.heallist.size(); i++){
			if(id.equals(infomg.heallist.get(i).get_id()) && infomg.heallist.get(i).get_skill().equals(text)){
				count++;
				row[i][0] = Integer.toString(count);
				row[i][1] = infomg.heallist.get(i).get_name();
				model.addRow(row[i]);}
		}
	}
	public void settable(JTable table){
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();     // 가운데 정렬
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		table.getColumn("번호").setPreferredWidth(30);
		table.getColumn("이름").setPreferredWidth(50);
		table.getColumn("번호").setCellRenderer(celAlignCenter);
		table.getColumn("이름").setCellRenderer(celAlignCenter);
		table.setEnabled(false);
	}
	public ListFrame(InfoManager temp_infomg){     //리스트 목록GUI
		infomg = temp_infomg;
		setTitle("무술별 인원 리스트");
		setLayout(new BorderLayout());

		JPanel totalskill = new JPanel(new GridLayout(1,9));
		JLabel skill = new JLabel("복싱");
		JLabel skill1 = new JLabel("무에타이");
		JLabel skill2 = new JLabel("주짓수");
		JLabel skill3 = new JLabel("태권도");
		JLabel skill4 = new JLabel("검도");
		JLabel skill5 = new JLabel("레슬링");
		JLabel skill6 = new JLabel("카포에라");
		JLabel skill7 = new JLabel("유도");
		JLabel skill8 = new JLabel("우슈");
		skill.setHorizontalAlignment(JLabel.CENTER);
		skill1.setHorizontalAlignment(JLabel.CENTER);
		skill2.setHorizontalAlignment(JLabel.CENTER);
		skill3.setHorizontalAlignment(JLabel.CENTER);
		skill4.setHorizontalAlignment(JLabel.CENTER);
		skill5.setHorizontalAlignment(JLabel.CENTER);
		skill6.setHorizontalAlignment(JLabel.CENTER);
		skill7.setHorizontalAlignment(JLabel.CENTER);
		skill8.setHorizontalAlignment(JLabel.CENTER);

		totalskill.add(skill);
		totalskill.add(skill1);
		totalskill.add(skill2);
		totalskill.add(skill3);
		totalskill.add(skill4);
		totalskill.add(skill5);
		totalskill.add(skill6);
		totalskill.add(skill7);
		totalskill.add(skill8);

		JPanel totallist = new JPanel(new GridLayout(1,9));
		String id = infomg.id;
		savetable(id,"복싱",model);
		savetable(id,"무에타이",model1);
		savetable(id,"주짓수",model2);
		savetable(id,"태권도",model3);
		savetable(id,"검도",model4);
		savetable(id,"레슬링",model5);
		savetable(id,"카포에라",model6);
		savetable(id,"유도",model7);
		savetable(id,"우슈",model8);

		settable(table);
		settable(table1);
		settable(table2);
		settable(table3);
		settable(table4);
		settable(table5);
		settable(table6);
		settable(table7);
		settable(table8);

		pan.add(table);
		pan1.add(table1);
		pan2.add(table2);
		pan3.add(table3);
		pan4.add(table4);
		pan5.add(table5);
		pan6.add(table6);
		pan7.add(table7);
		pan8.add(table8);

		totallist.add(pan);
		totallist.add(pan1);
		totallist.add(pan2);
		totallist.add(pan3);
		totallist.add(pan4);
		totallist.add(pan5);
		totallist.add(pan6);
		totallist.add(pan7);
		totallist.add(pan8);


		//확인 버튼
		JPanel okp = new JPanel();
		ok = new JButton("확인");
		ok.addActionListener(this);
		okp.add(ok);

		add("North", totalskill);
		add("Center", totallist);
		add("South", okp);
		setSize(1000,400);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ok){
			dispose();
		}
	}

}
