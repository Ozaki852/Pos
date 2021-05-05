import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class CHome {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenW = screenSize.width;
	int screenH = screenSize.height;
	
	JFrame f = new JFrame();
	JPanel p1 = new JPanel();
	JPanel chackPanel = new JPanel();
	int chackPanelW,chackPanelH;
	ImageIcon logoIcon = new ImageIcon("logo.png");
	JLabel logoLab = new JLabel(logoIcon);
	JLabel acntLab = new JLabel("工號：",JLabel.CENTER);
	JLabel pwdLab = new JLabel("密碼：",JLabel.CENTER);
	
	JTextField acntTxtFd = new JTextField("");
    JPasswordField pwdTxtFd = new JPasswordField("");
	
	JButton usrIntBtn = new JButton("前台");
	JButton mgrBtn = new JButton("後台");
	JButton punchBtn = new JButton("員工打卡");
	JButton logoutBtn = new JButton("系統登出");
	JButton fastbuyBtn = new JButton("系統說明");
	
	Color PaleTurquoise = new Color(150,205,205);
	Color LightSlateBlue = new Color(132,112,255);
	Color IndianRed = new Color(255,106,106);
	Color Goldenrod = new Color(255,193,37);
	Color PaleGreen = new Color(152,251,152);
	Color Burlywood	= new Color(222,184,135);
	
	Font font1 = new Font("微軟正黑體",Font.BOLD,24);
	
	CHome(){
		p1.setBounds(0,0,screenW,screenH);
		p1.setLayout(null);
		p1.setBackground(PaleTurquoise);
		f.add(p1);
		
		logoLab.setBounds((int)(screenW*0.35),(int)(screenH*0.3),(int)(screenW*0.3),(int)(screenH*0.4));
		p1.add(logoLab);
		
		chackPanel.setBounds((int)(screenW*0.7),(int)(screenH*0.4),(int)(screenW*0.25),(int)(screenH*0.2));
		chackPanel.setLayout(null);
		chackPanel.setBackground(null);
		p1.add(chackPanel);
		chackPanelW = chackPanel.getWidth();
		chackPanelH = chackPanel.getHeight();
		
		acntLab.setBounds(0,chackPanelH/10*1,chackPanelW/4*1,chackPanelH/10*3);
		acntLab.setFont(new Font("微軟正黑體",Font.BOLD,acntLab.getWidth()/3));
		chackPanel.add(acntLab);
		
		pwdLab.setBounds(0,chackPanelH/10*6,chackPanelW/4*1,chackPanelH/10*3);
		pwdLab.setFont(new Font("微軟正黑體",Font.BOLD,pwdLab.getWidth()/3));
		chackPanel.add(pwdLab);
		
		acntTxtFd.setBounds(chackPanelW/4*1,chackPanelH/10*1,chackPanelW/4*3,chackPanelH/10*3);
		acntTxtFd.setFont(font1);
		chackPanel.add(acntTxtFd);
		
		pwdTxtFd.setBounds(chackPanelW/4*1,chackPanelH/10*6,chackPanelW/4*3,chackPanelH/10*3);
		pwdTxtFd.setFont(font1);
		chackPanel.add(pwdTxtFd);
		
		usrIntBtn.setBounds((int)(screenW*0.65),(int)(screenH*0.1),(int)(screenW*0.25),(int)(screenH*0.2));
		usrIntBtn.setFont(font1);
		usrIntBtn.setBackground(LightSlateBlue);
		p1.add(usrIntBtn);
		
		mgrBtn.setBounds((int)(screenW*0.65),(int)(screenH*0.7),(int)(screenW*0.25),(int)(screenH*0.2));
		mgrBtn.setFont(font1);
		mgrBtn.setBackground(IndianRed);
		p1.add(mgrBtn);
		
		punchBtn.setBounds((int)(screenW*0.1),(int)(screenH*0.1),(int)(screenW*0.25),(int)(screenH*0.2));
		punchBtn.setFont(font1);
		punchBtn.setBackground(Goldenrod);
		p1.add(punchBtn);
		
		logoutBtn.setBounds((int)(screenW*0.1),(int)(screenH*0.7),(int)(screenW*0.25),(int)(screenH*0.2));
		logoutBtn.setFont(font1);
		logoutBtn.setBackground(Burlywood);
		p1.add(logoutBtn);
		
		fastbuyBtn.setBounds((int)(screenW*0.05),(int)(screenH*0.4),(int)(screenW*0.25),(int)(screenH*0.2));
		fastbuyBtn.setFont(font1);
		fastbuyBtn.setBackground(PaleGreen);
		p1.add(fastbuyBtn);
		
		f.setTitle("首頁");
		f.setLayout(null);
		f.setBounds(0,0,screenW,screenH);
		f.setUndecorated(true);
	}
}