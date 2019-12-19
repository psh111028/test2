

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MainClass extends JFrame implements ActionListener{
	ProgTest1 pt1 = new ProgTest1();
	ProgTest2 pt2 = new ProgTest2();
	
	JTextField jtf1 = new JTextField(10);
	JTextField jtf2 = new JTextField(10);
	JTextField jtf3 = new JTextField(10);
	JRadioButton jrb1 = new JRadioButton("남", true);
	JRadioButton jrb2 = new JRadioButton("여");
	ButtonGroup rg = new ButtonGroup();
	JTextArea jta1 = new JTextArea(7, 20);
	
	MainClass() {
		super("프로그래밍언어활용평가");
		JPanel jpn1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel jpn2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel jpn3 = new JPanel(new BorderLayout());
		JLabel jlb1 = new JLabel("회원ID:");
		JLabel jlb2 = new JLabel("회원이름:");
		JLabel jlb3 = new JLabel("전화번호:");
		JLabel jlb4 = new JLabel("성별:");
		
		
		rg.add(jrb1);
		rg.add(jrb2);
		JButton jbt1 = new JButton("회원등록");
		JButton jbt2 = new JButton("회원삭제");
		JButton jbt3 = new JButton("전체회원조회");
		JButton jbt4 = new JButton("구구단보기");
		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
		jbt3.addActionListener(this);
		jbt4.addActionListener(this);
		
		
		//////////////////////////////////회원등록, 삭제, 조회
		Box hBox = Box.createHorizontalBox();
		hBox.add(Box.createHorizontalGlue());
		hBox.add(jlb1);
		hBox.add(jtf1);
		hBox.add(Box.createHorizontalStrut(5));
		hBox.add(jlb2);
		hBox.add(jtf2);
		hBox.add(Box.createHorizontalStrut(5));
		hBox.add(jlb3);
		hBox.add(jtf3);
		hBox.add(Box.createHorizontalStrut(5));
		hBox.add(jlb4);
		hBox.add(jrb1);
		hBox.add(jrb2);
		hBox.add(Box.createGlue());
		Box hhBox = Box.createHorizontalBox();
		hhBox.add(Box.createHorizontalGlue());
		hhBox.add(add(jbt1));
		hhBox.add(Box.createHorizontalStrut(10));
		hhBox.add(add(jbt2));
		hhBox.add(Box.createHorizontalStrut(10));
		hhBox.add(add(jbt3));
		hhBox.add(Box.createHorizontalGlue());
		Box vBox = Box.createVerticalBox();
		vBox.add(hBox);
		vBox.add(Box.createVerticalStrut(10));
		vBox.add(hhBox);
		jpn1.setBorder(new TitledBorder(new EtchedBorder(), "회원등록,삭제,조회"));
		jpn1.add(vBox);
		
		//////////////////////////////////회원등록, 삭제, 조회
		Box hhhBox = Box.createHorizontalBox();
		hhhBox.add(Box.createGlue());
		hhhBox.add(jbt4);
		hhhBox.add(Box.createGlue());
		jpn2.setBorder(new TitledBorder(new EtchedBorder(), "구구단"));
		jpn2.add(hhhBox);
		
		//////////////////////////////////결과
		Box hhhhBox = Box.createHorizontalBox();
		hhhhBox.add(Box.createGlue());
		hhhhBox.add(jta1);
		hhhhBox.add(Box.createGlue());
		jpn3.setBorder(new TitledBorder(new EtchedBorder(), "결과"));
		jpn3.add(hhhhBox, BorderLayout.CENTER);
		
		Box vvBox = Box.createVerticalBox();
		vvBox.add(jpn1);
		vvBox.add(jpn2);
		vvBox.add(jpn3);
		add(vvBox);
		
		setSize(800, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MainClass();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("회원등록")) {
			String rStr = "";
			Enumeration<AbstractButton> em = rg.getElements();
			while(em.hasMoreElements()) {
				AbstractButton abtn = em.nextElement();
				if (abtn.isSelected()) {
					rStr = abtn.getText();
				}
			}
			int con = JOptionPane.showConfirmDialog(this, "회원을 등록하시겠습니까?", "회원등록", 2);
			if (con == JOptionPane.YES_OPTION) {
				pt2.mapListAdd(jtf1.getText(), jtf2.getText(), jtf3.getText(), rStr);
			} else if (con == JOptionPane.NO_OPTION) {
				
			}
		}

		if (e.getActionCommand().equals("회원삭제")) {
			int con = JOptionPane.showConfirmDialog(this, "회원을 삭제하시겠습니까?", "회원삭제", 2);
			if (con == JOptionPane.YES_OPTION) {
				pt2.mapListRemove(jtf1.getText());
			} else if (con == JOptionPane.NO_OPTION) {
				
			}
		}

		if (e.getActionCommand().equals("전체회원조회")) {
			String txt = "회원ID\t회원이름\t전화번호\t성별\n";
			String result = "";
			ArrayList<MemberData> alist = new ArrayList<MemberData>();
			alist = pt2.getMapList();
			Iterator<MemberData> it = alist.iterator();
			
			while (it.hasNext()) {
				MemberData md = it.next();
				result = result + md.getMemberID() + "\t" + md.getName() + "\t" + md.getTel() + "\t" + md.getGender() + "\n";
			}
			jta1.setText(txt + result);
		}

		if (e.getActionCommand().equals("구구단보기")) {
			String num = JOptionPane.showInputDialog(this, "몇단을 보시겠습니까?");
			jta1.setText(pt1.getGugudan(Integer.parseInt(num)));
		}
	}

}
