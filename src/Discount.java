import java.awt.*;
import javax.swing.*;

class Discount extends JFrame{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenW = screenSize.width;
	int screenH = screenSize.height;
	JPanel p = new JPanel();
	JButton[] offBtn = new JButton[12];
	String[] offString = {"95 §é","9 §é","85 §é","8 §é","75§é","7 §é","65§é","6§é","5 §é","3§é","1§é","ÃØ°e"};
	double[] offValue = {0.95, 0.9, 0.85, 0.8, 0.75, 0.7, 0.65, 0.6, 0.5, 0.3, 0.1, 0};
	
	Discount(){		
		p.setBounds(0,0,435,200);
		p.setLayout(new FlowLayout());
		p.setBackground(Color.orange);
		add(p);
		
		for(int i=0; i<offBtn.length; i++) {
			offBtn[i] = new JButton(offString[i]);
			offBtn[i].setBackground(Color.lightGray);
			offBtn[i].setFont(new Font("·L³n¥¿¶ÂÅé",Font.PLAIN,24));
	    	p.add(offBtn[i]);
		}
		
		setTitle("§é¦©");
		setLayout(null);
		setBounds(screenW/2-220,screenH/2-100,440,200);
		setVisible(false);
		setResizable(false);
	}
}