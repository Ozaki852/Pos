import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.text.ParseException;
import java.text.SimpleDateFormat;

class CPunch extends JFrame{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenW = screenSize.width;
	int screenH = screenSize.height;
	int p1W,p1H,p2W,p2H,p3W,p3H;
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel keyboardPanel = new JPanel();
	
	JButton homeBtn = new JButton("��^����");
	JButton clearBtn = new JButton("�M��");
	JButton correct = new JButton("��");
	JButton enterBtn = new JButton("Enter");
	JButton punchBtn = new JButton("punch");
	JTextField staffIDTxtFd = new JTextField("");
	JPasswordField pwdTxtFd = new JPasswordField("");
	JLabel titleLab = new JLabel("���u���d�t��",SwingConstants.CENTER);
	JLabel PUNtime = new JLabel();
	JLabel PUNdate = new JLabel();
	JTextField dutyTexFD = new JTextField("�W�Z");
	
	JScrollPane mySPane;   
    JTable myTable; 
    String table_title[] = {"���u�s��","���u�m�W","���d���","�W�Z�ɶ�","�U�Z�ɶ�"}; 
    String[][] table_Data = new String[30][5];
    
    JButton[] dutyBtn = new JButton[2];
    String[] dutyBtnString = {"�W�Z","�U�Z"};
    
    JButton[][] keyboardBtn = new JButton[4][10];
    String[][] keyboardString = {{"1","2","3","4","5","6","7","8","9","0"}
     							,{"Q","W","E","R","T","Y","U","I","O","P"}
     							,{"A","S","D","F","G","H","J","K","L",""}
     							,{"Z","X","C","V","B","N","M","","",""}};
    
    JLabel[][] StaData = new JLabel[5][1];
    String[][] StaString = {{"���d���A�G"},{"���u�s���G"},{"���u�K�X�G"},{"���d����G"},{"���d�ɶ��G"}};
    
	Color Goldenrod = new Color(255,193,37);
	Color Tan = new Color(255,165,79);
	Color PaleGreen = new Color(152,251,152);
	
	int state = 0;//�b���K�X��J���A,�b��=0,�K�X=1
	int rowIndex = 0;
	
	staff mystaff = new staff();
	CDM_dbma mydbma = new CDM_dbma();
	
	CPunch(){
		p1.setBounds(0,0,screenW,(int)(screenH*0.2));
		p1.setBackground(Goldenrod);
		p1.setLayout(null);
		add(p1);
		p1W = p1.getWidth();
		p1H = p1.getHeight();
		
		p2.setBounds(0,(int)(screenH*0.2),(int)(screenW*0.5),(int)(screenH*0.8));
		p2.setLayout(null);
		add(p2);
		p2W = p2.getWidth();
		p2H = p2.getHeight();
		
		p3.setBounds((int)(screenW*0.5),(int)(screenH*0.2),(int)(screenW*0.5),(int)(screenH*0.8));
		p3.setBackground(Tan);
		p3.setLayout(null);
		add(p3);
		p3W = p3.getWidth();
		p3H = p3.getHeight();
		
		titleLab.setBounds((int)(p1W*0.3),0,(int)(p1W*0.4),p1H);
		titleLab.setFont(new Font("�L�n������",Font.BOLD,30));
		p1.add(titleLab);
		
		homeBtn.setBounds((int)(p1W*0.85),(int)(p1H*0.3),(int)(p1W*0.1),(int)(p1H*0.4));
		homeBtn.setBackground(Color.yellow);
		homeBtn.setFont(new Font("�L�n������",Font.BOLD,15));
		p1.add(homeBtn);
		
		myTable = new JTable(table_Data, table_title);
		myTable.setEnabled(false);	
		myTable.setRowHeight(30);                       		
		myTable.setFont(new Font("�L�n������", Font.PLAIN, 16));
		for(int i=0; i<table_Data.length; i++)
			for(int j=0;j<table_Data[0].length; j++)
				myTable.setValueAt("",i,j);
	    mySPane = new JScrollPane(myTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);  
	    mySPane.setBounds(0,0,p2W,p2H);
	    mySPane.setEnabled(false);
	    mySPane.setVisible(true);         
	    p2.add(mySPane);
	    
		for(int i=0; i<StaData.length; i++){
			for(int j=0; j<StaData[0].length; j++){
				StaData[i][j] = new JLabel(StaString[i][j],SwingConstants.CENTER);
		      	StaData[i][j].setFont(new Font("�L�n������", Font.BOLD, 20));
		      	StaData[i][j].setBounds((int)(p3W*0.01),(int)((p3H*0.01)+i*(p3H*0.1)),(int)(p3W*0.2),(int)(p3H*0.09));
		      	//StaData[i][j].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		      	StaData[i][j].setForeground(Color.black);
		      	p3.add(StaData[i][j]);                              
		    }
		}//���u���d Data Label(���D)
		
		for(int i=0; i<dutyBtn.length; i++){
	     	dutyBtn[i] = new JButton(dutyBtnString[i]);
	     	dutyBtn[i].setFont(new Font("�L�n������", Font.BOLD, 20));
	     	dutyBtn[i].setBounds((int)((p3W*0.4)+i*(p3W*0.21)),(int)(p3H*0.01),(int)(p3W*0.2),(int)(p3H*0.09));
	     	dutyBtn[i].setForeground(Color.black);
	     	dutyBtn[i].setBackground(Color.gray);
	     	dutyBtn[i].setBorder(BorderFactory.createRaisedBevelBorder());
	     	dutyBtn[i].addActionListener(ProcessOperateBtn);
	     	p3.add(dutyBtn[i]);        
		}//�W�U�Z���A����
	    
		keyboardPanel.setBounds((int)(p3W*0.02),(int)(p3H*0.61),(int)(p3W*0.6),(int)(p3H*0.38));
		keyboardPanel.setLayout(new GridLayout(4,10,1,1));
		keyboardPanel.setBackground(Tan);
		keyboardPanel.setVisible(true);
		p3.add(keyboardPanel);
	    for(int i=0; i<keyboardBtn.length; i++){
	    	for(int j=0; j<keyboardBtn[0].length; j++){
	    		keyboardBtn[i][j] = new JButton(keyboardString[i][j]);
	    		keyboardBtn[i][j].setFont(new Font("�L�n������", Font.PLAIN, 20));
	    		keyboardBtn[i][j].setBackground(PaleGreen);
	    		//keyboardBtn[i][j].setForeground(Color.black);
	    		keyboardBtn[i][j].setBorder(BorderFactory.createEtchedBorder());
	    		keyboardBtn[i][j].addActionListener(ProcessKeyboardBtn);
	    		keyboardPanel.add(keyboardBtn[i][j]);                    
	       	}
	  	} //��L
	   
	    dutyTexFD.setBounds((int)(p3W*0.21),(int)(p3H*0.01),(int)(p3W*0.18),(int)(p3H*0.09));
		dutyTexFD.setForeground(Color.black);
		dutyTexFD.setEditable(false);
		dutyTexFD.setBorder(BorderFactory.createRaisedBevelBorder());
		dutyTexFD.setFont(new Font("�L�n������",Font.BOLD,24));
		p3.add(dutyTexFD); //�W�U�Z���A���
	    
	    staffIDTxtFd.setBounds((int)(p3W*0.21),(int)(p3H*0.11),(int)(p3W*0.6),(int)(p3H*0.09));
		staffIDTxtFd.setForeground(Color.black);
		staffIDTxtFd.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		staffIDTxtFd.setFont(new Font("�з���",Font.BOLD,24));
		staffIDTxtFd.setEditable(false);
		p3.add(staffIDTxtFd); //���uID��J���
			
		pwdTxtFd.setBounds((int)(p3W*0.21),(int)(p3H*0.21),(int)(p3W*0.6),(int)(p3H*0.09));
		pwdTxtFd.setForeground(Color.black);
		pwdTxtFd.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		pwdTxtFd.setFont(new Font("�L�n������",Font.BOLD,24));
		pwdTxtFd.setEditable(false);
		p3.add(pwdTxtFd); //���u�K�X��J���
		
	    PUNdate.setBounds((int)(p3W*0.21),(int)(p3H*0.31),(int)(p3W*0.6),(int)(p3H*0.09));
	    PUNdate.setForeground(Color.black);
	    PUNdate.setBorder(BorderFactory.createRaisedBevelBorder());
	    PUNdate.setFont(new Font("�з���",Font.BOLD,24));
	    p3.add(PUNdate); // ���d�����
	    
	    PUNtime.setBounds((int)(p3W*0.21),(int)(p3H*0.41),(int)(p3W*0.6),(int)(p3H*0.09));
	    PUNtime.setForeground(Color.black);
	    PUNtime.setBorder(BorderFactory.createRaisedBevelBorder());
	    PUNtime.setFont(new Font("�з���",Font.BOLD,24));
	    p3.add(PUNtime); // ���d�ɶ���
	   
	    clearBtn.setBounds((int)(p3W*0.62)+5,(int)(p3H*0.61),(int)(p3W*0.15),(int)(p3H*0.1));
	    clearBtn.setBackground(Color.gray);
	    clearBtn.setForeground(Color.black);
	    clearBtn.setBorder(BorderFactory.createEtchedBorder());
	    clearBtn.setFont(new Font("�L�n������",Font.BOLD,20));
	    clearBtn.addActionListener(ProcessOperateBtn);
	    p3.add(clearBtn);//�M��
	 	
	    correct.setFont(new Font("�L�n������",Font.BOLD,20));
	    correct.setBounds((int)(p3W*0.62)+5,(int)(p3H*0.71)+5,(int)(p3W*0.15),(int)(p3H*0.1));
	    correct.setBackground(Color.gray);
	    correct.setForeground(Color.black);
	    correct.setBorder(BorderFactory.createEtchedBorder());
	    correct.addActionListener(ProcessOperateBtn);
	    p3.add(correct);//��
	    
	    enterBtn.setBounds((int)(p3W*0.62)+5,(int)(p3H*0.81)+10,(int)(p3W*0.15),(int)(p3H*0.18)-10);
	    enterBtn.setBackground(Color.blue);
	    enterBtn.setForeground(Color.white);
	    enterBtn.setBorder(BorderFactory.createLineBorder(Color.red,2));
	    enterBtn.setFont(new Font("�L�n������",Font.BOLD,24));
	    enterBtn.addActionListener(ProcessOperateBtn);
	    p3.add(enterBtn); //��ƿ�J�T�{��
	   	   
	    punchBtn.setBounds((int)(p3W*0.77)+10,(int)(p3H*0.61),(int)(p3W*0.21)-10,(int)(p3H*0.38));
	    punchBtn.setBackground(Color.blue);
	    punchBtn.setForeground(Color.white);
	    punchBtn.setBorder(BorderFactory.createLineBorder(Color.red,2));
	    punchBtn.setFont(new Font("�L�n������",Font.BOLD,20));
	    punchBtn.addActionListener(ProcessPunchBtn);
	    p3.add(punchBtn);//���d���s

	    setTitle("���d�t��");
	    setLayout(null);
	    setBounds(0,0,screenW,screenH);
	    setUndecorated(true);//���n���
	}
	
	public ActionListener ProcessKeyboardBtn = new ActionListener() {//�p��L
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<keyboardBtn.length; i++) {
				for(int j=0; j<keyboardBtn[0].length; j++) {
					if(state == 0 && e.getSource() == keyboardBtn[i][j]) {
						staffIDTxtFd.setText(staffIDTxtFd.getText()+keyboardBtn[i][j].getText());
					}
					if(state == 1 && e.getSource() == keyboardBtn[i][j]){
						pwdTxtFd.setText(pwdTxtFd.getText()+keyboardBtn[i][j].getText());
					}
				}
			}
		}
	};
	
	public ActionListener ProcessOperateBtn = new ActionListener() {//�B�z��r���
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == enterBtn && !staffIDTxtFd.getText().equals("")) {
				state = 1;
			}
			if(e.getSource() == clearBtn) {
				pwdTxtFd.setText("");
				staffIDTxtFd.setText("");
				state = 0;				
			}
			if(e.getSource() == correct) {
				if(!pwdTxtFd.getText().equals("")) {//�p�G�K�X��즳���e�N�R��
					pwdTxtFd.setText("");
				}
				else{//�K�X���S�����e�N�R���b�����
					Document doc = staffIDTxtFd.getDocument();
	                if (doc.getLength() > 0) {
	                    try {
							doc.remove(doc.getLength() - 1, 1);
						} catch (BadLocationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	                }
					state = 0;
				}				
			}
			if(e.getSource() == dutyBtn[0]) {
				dutyTexFD.setText("�W�Z");	
			}
			if(e.getSource() == dutyBtn[1]) {
				dutyTexFD.setText("�U�Z");
			}
		}
	};
	
	public ActionListener ProcessPunchBtn = new ActionListener() {//�B�z���d���s
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == punchBtn && !pwdTxtFd.getText().equals("")) {
				Date now = new Date();
				SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
				SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
				String dateStr = date.format(now);
				String timeStr = time.format(now);
				PUNdate.setText(dateStr);
				PUNtime.setText(timeStr);
				for(int i=0; i<mystaff.staffDataString.length; i++) {
					if(staffIDTxtFd.getText().equals(mystaff.staffDataString[i][1]) && pwdTxtFd.getText().equals(mystaff.staffDataString[i][2])) {
						myTable.setValueAt(mystaff.staffDataString[i][1],rowIndex,0);
						myTable.setValueAt(mystaff.staffDataString[i][0],rowIndex,1);
						myTable.setValueAt(PUNdate.getText(),rowIndex,2);
						if(dutyTexFD.getText().equals("�W�Z")) {
							myTable.setValueAt(PUNtime.getText(),rowIndex,3);
							String[] staff = {dateStr,
											  mystaff.staffDataString[i][1],
								      		  mystaff.staffDataString[i][0],
								      		  mystaff.staffDataString[i][3],
								      		  timeStr,
								      		  "",
						              		  "0"};
							mydbma.insertRD_into_TB_staffInfo(staff);
						}
						
						if(dutyTexFD.getText().equals("�U�Z")){
							String[][] staffPunch = mydbma.findRD_in_TB_staffInfo_by_staffID(mystaff.staffDataString[i][1],1);
							if(!staffPunch[0][4].equals("") && staffPunch[0][5].equals("")) {
								myTable.setValueAt(PUNtime.getText(),rowIndex,4);
								int hours=0,H1=0,H2=0,M1=0,M2=0,S1=0,S2=0;
								try {
									Date clockONtime = time.parse(staffPunch[0][4]);
									H1 = clockONtime.getHours();
									M1 = clockONtime.getMinutes();
									S1 = clockONtime.getSeconds();
									H2 = now.getHours();
									M2 = now.getMinutes();
									S2 = now.getSeconds();
									hours = (H2+M2/60+S2/3600)-(H1+M1/60+S1/3600);
								} 
								catch (ParseException e1) {
									e1.printStackTrace();
								}
								mydbma.updateRD_in_TB_staffInfo_hours(hours,mystaff.staffDataString[i][1]);
								mydbma.updateRD_in_TB_staffInfo_clockOFF(PUNtime.getText(),mystaff.staffDataString[i][1]);
								JOptionPane.showMessageDialog(null,"�u���ɶ� "+((H2-H1)*3600+(M2-M1)*60+(S2-S1))+"��");
								JOptionPane.showMessageDialog(null,"�U�Z�Яd�N��q�w�� ^_^");
							}
						}
					}
				}
				if(!((String)myTable.getValueAt(rowIndex,0)).equals("")) {
					rowIndex++;
				}
			}
			staffIDTxtFd.setText("");
			pwdTxtFd.setText("");
			state = 0;
		}

		private int get_rowSize_of_staffInfo_by_staffID(String staffID) {
			// TODO Auto-generated method stub
			return 0;
		}
	};
}