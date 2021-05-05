import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

class CUsrInt {
	Product product = new Product();
	Delivery delivery = new Delivery();
	Discount discount = new Discount();
	CDM_dbma mydbma = new CDM_dbma();
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenW = screenSize.width;
	int screenH = screenSize.height;
	int p1W,p1H,p2W,p2H,p3W,p3H,BillPanelW,BillPanelH;
	
	JFrame f = new JFrame();
	JPanel p1 = new JPanel();
	JPanel p2A = new JPanel();
	JPanel p2B = new JPanel();
	
	JPanel p3 = new JPanel();
	JPanel p2Aa = new JPanel();
	JPanel showBillPanel = new JPanel();
	JPanel digitPanelA = new JPanel();
	JPanel digitPanelB = new JPanel();
	
	JTabbedPane typeTabPane = new JTabbedPane();//�ӫ~����
    JPanel p3a = new JPanel();
    JPanel p3b = new JPanel();
    JPanel p3c = new JPanel();
    JPanel p3d = new JPanel();
    String tabTxtA = "����";
    String tabTxtB = "����";
    String tabTxtC = "���";
    String tabTxtD = "��L";
	
	String [] table_Title = {"��","�~��","���","�ƶq","�p�p(��)","�馩"};
	DefaultTableModel dfTable;//���Ҳ�
	JTable myTable;
	JScrollPane productPane;
	
	String [] productID_Title = {"�f��","�ƶq"};//�x�s��ƥΤ����
	DefaultTableModel productID_dfTable = new DefaultTableModel(new String[][]{}, productID_Title);
	JTable productID_Table = new JTable(productID_dfTable);
	
	ImageIcon userIcon = new ImageIcon("�ϥΪ�.png");
	ImageIcon productIcon = new ImageIcon("����p.png");
	
	JLabel userLab = new JLabel(userIcon);
	JLabel titleLab = new JLabel("���t�R��޾P��e�x",SwingConstants.CENTER);
	JLabel totalLab = new JLabel("�`���B",SwingConstants.CENTER);
	JLabel payLab = new JLabel("��    �I",SwingConstants.CENTER);
	JLabel overLab = new JLabel("��    �s",SwingConstants.CENTER);
	
	JTextField digitTxtFdA = new JTextField("0");
	JTextField digitTxtFdB = new JTextField("0");
	JTextField shiftTxtFd = new JTextField("");//�Z�O
	JTextField userTxtFd = new JTextField();//�ϥΪ�
	JTextField subtotalTxtFd = new JTextField();
	JTextField totalTxtFd = new JTextField("");
	JTextField payTxtFd =  new JTextField("");
	JTextField overTxtFd = new JTextField("");
	
	JButton homeBtn = new JButton("����");
	JButton handoverBtn = new JButton("���Z");
	JButton returnBtn = new JButton("�h�f");
	JButton deliveryBtn = new JButton("�v�t�쩲");
	JButton discountBtn = new JButton("�馩");
	JButton payBtn = new JButton("�I�{");
	JButton addBtn = new JButton("�ӫ~�T�{");
	JButton redoBtn = new JButton("���s���");
	JButton cancelBtn = new JButton("�浧����");
	JButton clearBtn = new JButton("�M�ũҦ�");
	JButton backBtn = new JButton("�~����");
	JButton totalBtn = new JButton("�� �b");
	
	JButton[][] productBtnA = new JButton[5][3];
    String[][] productBtnStringA = product.productNameA;
    String[][] productPriceStringA = product.productPriceA;
    String[][] productIDStringA = product.productIDA;
    
    JButton[][] productBtnB = new JButton[5][3];
    String[][] productBtnStringB = product.productNameB;
    String[][] productPriceStringB = product.productPriceB;
    String[][] productIDStringB = product.productIDB;
    
    JButton[][] productBtnC = new JButton[5][3];
    String[][] productBtnStringC = product.productNameC;
    String[][] productPriceStringC = product.productPriceC;
    String[][] productIDStringC = product.productIDC;
    
    JButton[][] productBtnD = new JButton[5][3];
    String[][] productBtnStringD = product.productNameD;
    String[][] productPriceStringD = product.productPriceD;
    String[][] productIDStringD = product.productIDD;
    
    JButton[][] digitBtnA = new JButton[4][3];
    JButton[][] digitBtnB = new JButton[4][3];
    String[][] digitBtnString = {{"7","8","9"},{"4","5","6"},{"1","2","3"},{"0","00","C"}};
	
	Color SteelBlue = new Color(70,130,180);//p2�I��
	Color LightSlateBlue = new Color(132,112,255);//p1�I��
	Color DeepSkyBlue = new Color(0,191,255);//�n�X�B��x�B���u���d�B�v�t�쩲�B�馩�B�I�{
	Color LightSkyBlue = new Color(30,144,255);//�Ʀr��
	Color Green4 = new Color(0,139,0);//�ӫ~�T�{
	Color Gold = new Color(255,215,0);//���s���
	Color Tan = new Color(255,165,79);//�浧����
	Color Coral = new Color(255,114,86);//�M�ũҦ�
	Color OldLace = new Color(253,245,230);//���˰ӫ~
	Color lavender = new Color(230,230,250);//���˰ӫ~
	Color LemonChiffon = new Color(255,250,205);//��˰ӫ~
	Color Honeydew = new Color(240,255,240);//��L�ӫ~
	
	Font font1 = new Font("�L�n������",Font.BOLD,36);
	Font font2 = new Font("�L�n������",Font.BOLD,30);
	Font font3 = new Font("�L�n������",Font.PLAIN,28);
	Font font4 = new Font("�з���",Font.BOLD,20);
	Font font5 = new Font("�s�ө���",Font.BOLD,16);
	Font font6 = new Font("�L�n������",Font.PLAIN,20);
	Font font7 = new Font("�L�n������",Font.BOLD,16);
	
	int rowIndex = 0;
	int rowCount;//����`��
	int amount;
	int price;
	int total;
	int pay;
	int over;
	int customer = 0;
	//int stockCount = 0;
	int deliveryState = 0;//���L�v�t,�L0,��1
	
	CUsrInt(){
		for(int i=0; i<discount.offBtn.length; i++) {
			discount.offBtn[i].addActionListener(ProcessDiscountBtn);
		}
		/*�H�U���e���]�w*/
		p1.setBounds(0,0,(int)(screenW*0.55),(int)(screenH*0.55));
		p1.setLayout(null);
		p1.setBackground(LightSlateBlue);
		f.add(p1);
		p1W = p1.getWidth();
		p1H = p1.getHeight();
		
		p2A.setBounds(0,(int)(screenH*0.55),(int)(screenW*0.55),(int)(screenH*0.45));
		p2A.setLayout(null);
		p2A.setBackground(SteelBlue);
		f.add(p2A);
		p2W = p2A.getWidth();
		p2H = p2A.getHeight();
		
		p2B.setBounds(0,(int)(screenH*0.55),(int)(screenW*0.55),(int)(screenH*0.45));//���b�e��
		p2B.setLayout(null);
		p2B.setBackground(SteelBlue);
		p2B.setVisible(false);
		f.add(p2B);
		
		p3.setBounds((int)(screenW*0.55),0,(int)(screenW*0.45),screenH);
		p3.setLayout(null);
		p3.setBackground(Color.lightGray);
		f.add(p3);
		p3W = p3.getWidth();
		p3H = p3.getHeight();
		
		typeTabPane.setBounds(0,80,p3W,p3H-80);//���Үe��
		typeTabPane.setFont(font3);
		typeTabPane.setBackground(Color.white);
		typeTabPane.add(tabTxtA,p3a);
		typeTabPane.add(tabTxtB,p3b);
		typeTabPane.add(tabTxtC,p3c);
		typeTabPane.add(tabTxtD,p3d);
        p3.add(typeTabPane);
        
		p3a.setLayout(new GridLayout(5,3,4,4));
		//p3a.setBackground(color2);
		p3b.setLayout(new GridLayout(5,3,4,4));
		//p3b.setBackground(color2);
		p3c.setLayout(new GridLayout(5,3,4,4));
		//p3c.setBackground(color2);
		p3d.setLayout(new GridLayout(5,3,4,4));
		//p3d.setBackground(color2);
		/*�H�W���e���]�w*/
		/*�H�U��P1*/
		titleLab.setBounds((int)(p1W*0.2),0,(int)(p1W*0.6),(int)(p1H*0.2));
		titleLab.setFont(font1);
		titleLab.setForeground(Color.white);
		p1.add(titleLab);
		
		dfTable = new DefaultTableModel(new String[][]{},table_Title){
		    public boolean isCellEditable(int row, int column){
		        return false;
		    }
		};
	    myTable = new JTable(dfTable);
		myTable.setRowHeight(40);
		TableColumnModel cModel = myTable.getColumnModel();/*�U���T��]�w���U�O�e��*/
		TableColumn Title0 = cModel.getColumn(0),Title1 = cModel.getColumn(1);
		Title0.setPreferredWidth(30);
		Title1.setPreferredWidth(130);
		myTable.setFont(font5);
		myTable.setEnabled(true);
		//myTable.setCellSelectionEnabled(false);//�O�_���\���C������P�ɦs�b
	    myTable.setRowSelectionAllowed(true);//����ɾ�C�|�ܦ�
	    JTableHeader tableHead = myTable.getTableHeader();
	    tableHead.setPreferredSize(new Dimension(tableHead.getWidth(),35));
	    tableHead.setFont(font7);
		productPane = new JScrollPane(myTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		productPane.setBounds(0,(int)(p1H*0.2),p1W,(int)(p1H*0.8));
		productPane.setVisible(true);
		p1.add(productPane);
		/*�H�W��P1*/
		/*�H�U��P2A*/
		p2Aa.setBounds(10,10,(int)(p2W*0.6)-20,(int)(p2H*0.75)-20);
		p2Aa.setLayout(new GridLayout(3,3,5,5));
		p2Aa.setBackground(SteelBlue);
		p2A.add(p2Aa);
		
		homeBtn.setFont(font7);
		homeBtn.setBackground(DeepSkyBlue);
		homeBtn.setForeground(Color.white);
		p2Aa.add(homeBtn);
		
		deliveryBtn.setFont(font7);
		deliveryBtn.setBackground(DeepSkyBlue);
		deliveryBtn.addActionListener(ProcessDeliveryBtn);
		p2Aa.add(deliveryBtn);
		
		discountBtn.setFont(font7);
		discountBtn.setBackground(DeepSkyBlue);
		discountBtn.addActionListener(ProcessDiscountBtn);
		p2Aa.add(discountBtn);
				
		handoverBtn.setFont(font7);
		handoverBtn.setBackground(DeepSkyBlue);
		handoverBtn.setForeground(Color.white);
		p2Aa.add(handoverBtn);
		
		cancelBtn.setFont(font7);
		cancelBtn.setBackground(Tan);
		cancelBtn.addActionListener(ProcessOperateBtn);
		p2Aa.add(cancelBtn);
		
		redoBtn.setFont(font7);
		redoBtn.setBackground(Gold);
		redoBtn.addActionListener(ProcessOperateBtn);
		p2Aa.add(redoBtn);
		
		returnBtn.setFont(font7);
		returnBtn.setBackground(DeepSkyBlue);
		returnBtn.setForeground(Color.white);
//		returnBtn.addActionListener();
		p2Aa.add(returnBtn);
		
		clearBtn.setFont(font7);
		clearBtn.setBackground(Coral);
		clearBtn.addActionListener(ProcessOperateBtn);
		p2Aa.add(clearBtn);
		
		addBtn.setFont(font7);
		addBtn.setBackground(Green4);
		addBtn.addActionListener(ProcessOperateBtn);
		p2Aa.add(addBtn);
		
		payBtn.setBounds((int)(p2W*0.4),(int)(p2H*0.75)-5,(int)(p2W*0.2)-10,(int)(p2H*0.25)-5);
		payBtn.setFont(font7);
		payBtn.setBackground(DeepSkyBlue);
		payBtn.addActionListener(ProcessPayBtn);
		p2A.add(payBtn);
		
		subtotalTxtFd.setBounds(10,(int)(p2H*0.75)-5,(int)(p2W*0.4)-15,(int)(p2H*0.25)-5);
		subtotalTxtFd.setFont(font3);
		subtotalTxtFd.setEditable(false);
		subtotalTxtFd.setBorder(BorderFactory.createLineBorder(Color.black,1));
		p2A.add(subtotalTxtFd);
		
		digitTxtFdA.setBounds((int)(p2W*0.6),10,(int)(p2W*0.4)-10,(int)(p2H*0.2)-10);
		digitTxtFdA.setFont(font3);
		digitTxtFdA.setHorizontalAlignment(JTextField.RIGHT);
		digitTxtFdA.setEditable(false);
		p2A.add(digitTxtFdA);
		
		digitPanelA.setBounds((int)(p2W*0.6),(int)(p2H*0.2)+5,(int)(p2W*0.4)-10,(int)(p2H*0.8)-15);
		digitPanelA.setLayout(new GridLayout(4,3,3,3));
		digitPanelA.setBackground(SteelBlue);
		p2A.add(digitPanelA);
		for(int i=0; i<digitBtnA.length; i++) {
			for(int j=0; j<digitBtnA[0].length; j++) {
				digitBtnA[i][j] = new JButton(digitBtnString[i][j]);
				digitBtnA[i][j].setBackground(LightSkyBlue);
				digitBtnA[i][j].setFont(font3);
				digitBtnA[i][j].addActionListener(ProcessDigitBtnA);
				digitPanelA.add(digitBtnA[i][j]);
			}
		}
		/*�H�W��P2A*/
		/*�H�U��P2B*/
		showBillPanel.setBounds(15,30,(int)(p2W*0.6)-40,(int)(p2H*0.75)-65);
		showBillPanel.setLayout(null);
		showBillPanel.setBackground(SteelBlue);
		p2B.add(showBillPanel);
		BillPanelW = showBillPanel.getWidth();
		BillPanelH = showBillPanel.getHeight();
		
		totalLab.setBounds(0,0,(BillPanelW/10)*3,(BillPanelH/3)-10);
		totalLab.setFont(font3);
		showBillPanel.add(totalLab);
		
		totalTxtFd.setBounds((BillPanelW/10)*3,0,(BillPanelW/10)*7,(BillPanelH/3)-10);
		totalTxtFd.setFont(font3);
		totalTxtFd.setEditable(false);
		totalTxtFd.setBorder(BorderFactory.createLoweredBevelBorder());
		showBillPanel.add(totalTxtFd);
		
		payLab.setBounds(0,(BillPanelH/3)+5,(BillPanelW/10)*3,(BillPanelH/3)-10);
		payLab.setFont(font3);
		showBillPanel.add(payLab);
		
		payTxtFd.setBounds((BillPanelW/10)*3,(BillPanelH/3)+5,(BillPanelW/10)*7,(BillPanelH/3)-10);
		payTxtFd.setFont(font3);
		payTxtFd.setEditable(false);
		payTxtFd.setBorder(BorderFactory.createLoweredBevelBorder());
		showBillPanel.add(payTxtFd);
		
		overLab.setBounds(0,(BillPanelH/3)*2+10,(BillPanelW/10)*3,(BillPanelH/3)-10);
		overLab.setFont(font3);
		showBillPanel.add(overLab);
		
		overTxtFd.setBounds((BillPanelW/10)*3,(BillPanelH/3)*2+10,(BillPanelW/10)*7,(BillPanelH/3)-10);
		overTxtFd.setFont(font3);
		overTxtFd.setEditable(false);
		overTxtFd.setBorder(BorderFactory.createLoweredBevelBorder());
		showBillPanel.add(overTxtFd);
		
		backBtn.setBounds(10,(int)(p2H*0.75)-5,(int)(p2W*0.2)-10,(int)(p2H*0.25)-5);
		backBtn.setFont(font7);
		backBtn.setBackground(DeepSkyBlue);
		backBtn.addActionListener(ProcessBackBtn);
		p2B.add(backBtn);
		
		totalBtn.setBounds((int)(p2W*0.2)+10,(int)(p2H*0.75)-5,(int)(p2W*0.4)-20,(int)(p2H*0.25)-5);
		totalBtn.setFont(font2);
		totalBtn.setBackground(Color.red);
		totalBtn.setForeground(Color.white);
		totalBtn.setBorder(BorderFactory.createLineBorder(Color.black,1));
		totalBtn.addActionListener(ProcessTotalBtn);
		p2B.add(totalBtn);
		
		digitTxtFdB.setBounds((int)(p2W*0.6),10,(int)(p2W*0.4)-10,(int)(p2H*0.2)-10);
		digitTxtFdB.setFont(font3);
		digitTxtFdB.setHorizontalAlignment(JTextField.RIGHT);
		digitTxtFdB.setEditable(false);
		p2B.add(digitTxtFdB);
		
		digitPanelB.setBounds((int)(p2W*0.6),(int)(p2H*0.2)+5,(int)(p2W*0.4)-10,(int)(p2H*0.8)-15);
		digitPanelB.setLayout(new GridLayout(4,3,3,3));
		digitPanelB.setBackground(SteelBlue);
		p2B.add(digitPanelB);
		for(int i=0; i<digitBtnB.length; i++) {
			for(int j=0; j<digitBtnB[0].length; j++) {
				digitBtnB[i][j] = new JButton(digitBtnString[i][j]);
				digitBtnB[i][j].setBackground(LightSkyBlue);
				digitBtnB[i][j].setFont(font3);
				digitBtnB[i][j].addActionListener(ProcessDigitBtnB);
				digitPanelB.add(digitBtnB[i][j]);
			}
		}
		/*�H�W��P2B*/
		/*�H�U��P3*/
		userLab.setBounds((int)(p3W*0.05),15,50,50);
		p3.add(userLab);
		
		shiftTxtFd.setBounds((int)(p3W*0.05)+55,15,(int)(p3W*0.3),50);
		shiftTxtFd.setFont(font4);
		shiftTxtFd.setHorizontalAlignment(JTextField.CENTER);
		shiftTxtFd.setEditable(false);
		p3.add(shiftTxtFd);
		
		userTxtFd.setBounds((int)(p3W*0.35)+60,15,(int)(p3W*0.6)-60,50);
		userTxtFd.setFont(font4);
		userTxtFd.setHorizontalAlignment(JTextField.CENTER);
		userTxtFd.setEditable(false);
		p3.add(userTxtFd);
		
		for(int i=0; i<productBtnA.length; i++) {
			for(int j=0; j<productBtnA[0].length; j++) {
				productBtnA[i][j] = new JButton(productBtnStringA[i][j]);
				productBtnA[i][j].setBackground(OldLace);
				productBtnA[i][j].setFont(font5);
	    		productBtnA[i][j].addActionListener(ProcessProductBtn);
	    		p3a.add(productBtnA[i][j]);
	    	}
		}
		
		for(int i=0; i<productBtnB.length; i++) {
			for(int j=0; j<productBtnB[0].length; j++) {
				productBtnB[i][j] = new JButton(productBtnStringB[i][j]);
				productBtnB[i][j].setBackground(lavender);
				productBtnB[i][j].setFont(font5);
	    		productBtnB[i][j].addActionListener(ProcessProductBtn);
	    		p3b.add(productBtnB[i][j]);
	    	}
		}
		
		for(int i=0; i<productBtnC.length; i++) {
			for(int j=0; j<productBtnC[0].length; j++) {
				productBtnC[i][j] = new JButton(productBtnStringC[i][j]);
				productBtnC[i][j].setBackground(LemonChiffon);
				productBtnC[i][j].setFont(font5);
	    		productBtnC[i][j].addActionListener(ProcessProductBtn);
	    		p3c.add(productBtnC[i][j]);
	    	}
		}
		
		for(int i=0; i<productBtnD.length; i++) {
			for(int j=0; j<productBtnD[0].length; j++) {
				productBtnD[i][j] = new JButton(productBtnStringD[i][j]);
				productBtnD[i][j].setBackground(Honeydew);
				productBtnD[i][j].setFont(font5);
	    		productBtnD[i][j].addActionListener(ProcessProductBtn);
	    		p3d.add(productBtnD[i][j]);
	    	}
		}
		/*�H�W��P3*/		
		/*�H�U�������]�w*/
		f.setTitle("�P��e�x");
		f.setLayout(null);
		f.setBounds(0,0,screenW,screenH);
		f.setUndecorated(true);
		/*�H�W�������]�w*/
	}
	/**************end of CUsrInt****************/
	
	private void totalPrice() {//�]�w���`���B����k
		for(int i=0; i<rowIndex; i++) {
			price = Integer.parseInt((String)myTable.getValueAt(i,4));//���[�p�p]�r��A�A�ର���
			total = total + price;
			subtotalTxtFd.setText(" "+String.valueOf(total)+"��");//�N(�`���B)����ƭ��ର�r��,����ܦbtotalTxtFd
		}
	}
	
	public void initializeCUsrInt() {//��l��
		homeBtn.setEnabled(true);
		handoverBtn.setEnabled(true);
		dfTable.setRowCount(0);//�M�Ū��
		dfTable.fireTableDataChanged();
		productID_dfTable.setRowCount(0);//�M�Ū��
		productID_dfTable.fireTableDataChanged();
		rowIndex=0;
		rowCount=0;
		subtotalTxtFd.setText("");
		digitTxtFdA.setText("0");
		digitTxtFdB.setText("0");
		totalTxtFd.setText("");
		payTxtFd.setText("");
		overTxtFd.setText("");
		//stockCount=0;
		amount=0;
		price=0;
		total=0;
		pay = 0;
		over=0;
		deliveryState=0;
		delivery.deliveryState=0;
		setProductBtnEnabledTrue();//�I�s�]�w�ӫ~���s�ҥΪ���k
	}
	
	public void newTableData(String itemName, String itemPrice, String itemID) {//�I��ӫ~���s�ᰵ�����]�w
		homeBtn.setEnabled(false);
		handoverBtn.setEnabled(false);
		dfTable.addRow(new Object[]{"",itemName,itemPrice,"1",itemPrice,""});
		dfTable.fireTableDataChanged();//�ե�DefaultTableModel��fireTableDataChanged��k�i��model��s
		myTable.updateUI();
		productID_dfTable.addRow(new Object[]{itemID,""});
		productID_dfTable.fireTableDataChanged();
		productID_Table.updateUI();
		price = (Integer.parseInt(itemPrice));//���[���]�ۦ��ର���price
		rowCount=dfTable.getRowCount();//���o����`�C��
		//String[][] productStock = mydbma.findRD_in_TB_productInfo(itemID,1);//�q��Ʈw���o�ӫ~�w�s
		//stockCount = Integer.parseInt(productStock[0][2]);//�w�s�ƶq
	}
	
	public void setProductBtnEnabledTrue() {//�]�w�ӫ~���s��
		for(int i=0; i<productBtnA.length; i++) {
			for(int j=0; j<productBtnA[0].length; j++) {
				//if(!productBtnStringA[i][j].equals("")) {
	    			//String[][] productCount = mydbma.findRD_in_TB_productInfo(productIDStringA[i][j],1);//�q��Ʈw���o�ӫ~�w�s
	    			//if(Integer.parseInt(productCount[0][2]) > 0) {
	    				productBtnA[i][j].setEnabled(true);
	    			//}
	    			//else {
	    			//	productBtnA[i][j].setEnabled(false);//�N�S���w�s���ӫ~����
	    			//}
	    		//}
			}
		}
		for(int i=0; i<productBtnB.length; i++) {
			for(int j=0; j<productBtnB[0].length; j++) {
				//if(!productBtnStringB[i][j].equals("")) {
	    			//String[][] productStock = mydbma.findRD_in_TB_productInfo(productIDStringB[i][j],1);//�q��Ʈw���o�ӫ~�w�s
	    			//if(Integer.parseInt(productStock[0][2]) > 0) {
	    				productBtnB[i][j].setEnabled(true);
	    			//}
	    			//else {
	    			//	productBtnB[i][j].setEnabled(false);
	    			//}
	    		//}
			}
		}
		for(int i=0; i<productBtnC.length; i++) {
			for(int j=0; j<productBtnC[0].length; j++) {
				//if(!productBtnStringC[i][j].equals("")) {
	    			//String[][] productStock = mydbma.findRD_in_TB_productInfo(productIDStringC[i][j],1);//�q��Ʈw���o�ӫ~�w�s
	    			//if(Integer.parseInt(productStock[0][2]) > 0) {
	    				productBtnC[i][j].setEnabled(true);
	    			//}
	    			//else {
	    			//	productBtnC[i][j].setEnabled(false);
	    			//}
	    		//}
			}
		}
		for(int i=0; i<productBtnD.length; i++) {
			for(int j=0; j<productBtnD[0].length; j++) {
				//if(!productBtnStringD[i][j].equals("")) {
	    			//String[][] productStock = mydbma.findRD_in_TB_productInfo(productIDStringD[i][j],1);//�q��Ʈw���o�ӫ~�w�s
	    			//if(Integer.parseInt(productStock[0][2]) > 0) {
	    				productBtnD[i][j].setEnabled(true);
	    			//}
	    			//else {
	    			//	productBtnD[i][j].setEnabled(false);
	    			//}
	    		//}
			}
		}
	}
	
	public void setProductBtnEnabledFalse() {//�]�w�ӫ~���s����
		for(int i=0; i<productBtnA.length; i++) {
			for(int j=0; j<productBtnA[0].length; j++) {
				productBtnA[i][j].setEnabled(false);
			}
		}
		for(int i=0; i<productBtnB.length; i++) {
			for(int j=0; j<productBtnB[0].length; j++) {
				productBtnB[i][j].setEnabled(false);
			}
		}
		for(int i=0; i<productBtnC.length; i++) {
			for(int j=0; j<productBtnC[0].length; j++) {
				productBtnC[i][j].setEnabled(false);
			}
		}
		for(int i=0; i<productBtnD.length; i++) {
			for(int j=0; j<productBtnD[0].length; j++) {
				productBtnD[i][j].setEnabled(false);
			}
		}
	}
	
	/**************�U����ť��****************/
	public ActionListener ProcessProductBtn = new ActionListener() {//�ӫ~
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<productBtnA.length; i++) {
				for(int j=0; j<productBtnA[0].length; j++) {
					if(e.getSource() == productBtnA[i][j] && !productBtnStringA[i][j].equals("") && rowCount-rowIndex==0) {
						String itemName = tabTxtA+productBtnStringA[i][j];
						String itemPrice = productPriceStringA[i][j];
						String itemID = productIDStringA[i][j];
						newTableData(itemName,itemPrice,itemID);
						setProductBtnEnabledFalse();
					}
				}
			}
			for(int i=0; i<productBtnB.length; i++) {
				for(int j=0; j<productBtnB[0].length; j++) {
					if(e.getSource() == productBtnB[i][j] && !productBtnStringB[i][j].equals("") && rowCount-rowIndex==0) {
						String itemName = tabTxtB+productBtnStringB[i][j];
						String itemPrice = productPriceStringB[i][j];
						String itemID = productIDStringB[i][j];
						newTableData(itemName,itemPrice,itemID);
						setProductBtnEnabledFalse();
					}
				}
			}
			for(int i=0; i<productBtnC.length; i++) {
				for(int j=0; j<productBtnC[0].length; j++) {
					if(e.getSource() == productBtnC[i][j] && !productBtnStringC[i][j].equals("") && rowCount-rowIndex==0) {
						String itemName = tabTxtC+productBtnStringC[i][j];
						String itemPrice = productPriceStringC[i][j];
						String itemID = productIDStringC[i][j];
						newTableData(itemName,itemPrice,itemID);
						setProductBtnEnabledFalse();
					};
				}
			}
			for(int i=0; i<productBtnD.length; i++) {
				for(int j=0; j<productBtnD[0].length; j++) {
					if(e.getSource() == productBtnD[i][j] && !productBtnStringD[i][j].equals("") && rowCount-rowIndex==0) {
						String itemName = productBtnStringD[i][j];
						String itemPrice = productPriceStringD[i][j];
						String itemID = productIDStringD[i][j];
						newTableData(itemName,itemPrice,itemID);
						setProductBtnEnabledFalse();
					}
				}
			}
		}
	};
	
	public ActionListener ProcessDigitBtnA = new ActionListener() {//�Ʀr��A
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<digitBtnA.length; i++) {
				for(int j=0; j<digitBtnA[0].length; j++) {
					if(e.getSource() == digitBtnA[3][2] && rowCount-rowIndex==1) {
						digitTxtFdA.setText("0");
					}
					else if(e.getSource() == digitBtnA[i][j] && rowCount-rowIndex==1){
						if(amount<=10000) {
							amount = Integer.parseInt(digitTxtFdA.getText()+digitBtnA[i][j].getText());//���JTextField���ȡA�A�ର���
							price = Integer.parseInt((String)myTable.getValueAt(rowIndex,2));//���[���]�r��A�A�ର���
							price = price*amount;//���*�ƶq
							digitTxtFdA.setText(String.valueOf(amount));//����ର�r�ꪺ����b�Ʀr��r���
							myTable.setValueAt(String.valueOf(amount),rowIndex,3);//����ର�r�ꪺ�ƶq�b���
				    		myTable.setValueAt(String.valueOf(price),rowIndex,4);//�N(���*�ƶq)�ର�r���b������
				    		myTable.setValueAt("",rowIndex,5);//�p�G�ƶq����,��檺�馩�|�M��
						}
					}
				}
			}
		}
	};
	
	public ActionListener ProcessDigitBtnB = new ActionListener() {//�Ʀr��B
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<digitBtnB.length; i++) {
				for(int j=0; j<digitBtnB[0].length; j++) {
					if(e.getSource() == digitBtnB[3][2]){
						digitTxtFdB.setText("0");
						pay = 0;
					}
					else if(e.getSource() == digitBtnB[i][j]) {//�Ĥ@�ӿ�J���Ʀr���o��0
						if(pay<=1000000) {
							pay = Integer.parseInt(digitTxtFdB.getText()+digitBtnB[i][j].getText());
							digitTxtFdB.setText(String.valueOf(pay));
						}
					}
				}
			}
		}
	};
	
	public ActionListener ProcessOperateBtn = new ActionListener() {//��汱����
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == clearBtn && rowCount != 0) {//�M�ũҦ�
				int ask = JOptionPane.showConfirmDialog(null,"�T�w�n�M�ũҦ��ӫ~����?","�T�{�M��",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if( ask == JOptionPane.YES_OPTION ) {
					initializeCUsrInt();//�I�s��l�Ƥ�k
				}
            }
			
			if(e.getSource() == redoBtn && rowCount-rowIndex==1) {//���s���
				dfTable.removeRow(rowCount-1);
				dfTable.fireTableDataChanged();
				productID_dfTable.removeRow(rowCount-1);
				productID_dfTable.fireTableDataChanged();
				rowCount=dfTable.getRowCount();//���s���o����`�C��
				digitTxtFdA.setText("0");
				amount = 0;
				//stockCount=0;
				setProductBtnEnabledTrue();//�I�s�]�w�ӫ~���s�ҥΪ���k
            }
			
			if (e.getSource() == cancelBtn && rowCount != 0) {//�����涵
  				int selectedRow=myTable.getSelectedRow();//���o������C,�S������|�w�]��-1
  				if (selectedRow != -1 && selectedRow < rowIndex) {//����� :�R�����w�C
  					dfTable.removeRow(selectedRow);
  					productID_dfTable.removeRow(selectedRow);
  					for(int i=selectedRow; i<rowIndex-1; i++) {//���s�Ƨ�
  						myTable.setValueAt(String.valueOf(i+1),i,0);
  					}
  					if(selectedRow == 0) {
  						subtotalTxtFd.setText("");
  					}
  					rowCount=dfTable.getRowCount();//���s���o����`�C��
  					rowIndex--;
  	  				total = 0;
  					totalPrice();//�I�s���`���B����k
  				}
  				else if (selectedRow == -1) {//�L���:���~�T��
  					JOptionPane.showMessageDialog(null,"�п�ܱ��������~���C","���~�I",JOptionPane.ERROR_MESSAGE);
  				}
  				else {//����F�S���~�����C
  					JOptionPane.showMessageDialog(null,"�S���i�H�������~���C","���~�I",JOptionPane.ERROR_MESSAGE);
  				}
  			}
			
			if( e.getSource() == addBtn && rowCount-rowIndex==1 /*&& stockCount>=amount*/) {//�ӫ~�T�{
				if(((String)myTable.getValueAt(rowIndex,3)).equals("0") || ((String)myTable.getValueAt(rowIndex,3)).equals("")) {
					JOptionPane.showMessageDialog(null,"�ӫ~�ƶq���o�p��1�C","���~�I",JOptionPane.ERROR_MESSAGE);
				}
				else {
					myTable.setValueAt(String.valueOf(rowIndex+1),rowIndex,0);
					rowIndex++;
					total = 0;
					totalPrice();//�I�s���`���B����k
					amount = 0;
					//stockCount=0;
					digitTxtFdA.setText("0");
					setProductBtnEnabledTrue();
				}
			}
//			else if( e.getSource() == addBtn && rowCount-rowIndex==1 && stockCount<amount){
//				JOptionPane.showMessageDialog(null,"�ӫ~�w�s�����A�ȳѾl "+stockCount+" ��","�w�s�����I",JOptionPane.WARNING_MESSAGE);
//				digitTxtFdA.setText("0");
//			}
		}
	};
	
	public ActionListener ProcessDiscountBtn = new ActionListener() {//�馩
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == discountBtn && rowCount-rowIndex==1) {
				discount.setVisible(true);
			}
			else if(e.getSource() == discountBtn && rowCount-rowIndex==0){
				JOptionPane.showMessageDialog(null,"���I��ӫ~�I","���~�I",JOptionPane.ERROR_MESSAGE);
			}
			for(int i=0; i<discount.offBtn.length; i++) {
				if(e.getSource() == discount.offBtn[i]) {
					int disPrice = price;
					disPrice = (int)(disPrice*discount.offValue[i]);
					myTable.setValueAt(String.valueOf(disPrice),rowIndex,4);
					myTable.setValueAt(String.valueOf(discount.offString[i]),rowIndex,5);
					discount.setVisible(false);
				}
			}	
		}
	};
	
	public ActionListener ProcessDeliveryBtn = new ActionListener() {//�v�t�A��
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == deliveryBtn)
				delivery = new Delivery();
				delivery.f.setVisible(true);
		}
	};
	
	public ActionListener ProcessPayBtn = new ActionListener() {//�I�{
		public void actionPerformed(ActionEvent e) {
		    if(e.getSource() == payBtn && rowCount == 0)
				JOptionPane.showMessageDialog(null,"���I��ӫ~�I","���~�I",JOptionPane.ERROR_MESSAGE);
		    else if(e.getSource() == payBtn && rowCount-rowIndex==1)//�n�אּ�YrowIndex����""�N���X�T��
				JOptionPane.showMessageDialog(null,"�|���T�{�ӫ~�A���I���u�T�{�ӫ~�v�I","���~�I",JOptionPane.ERROR_MESSAGE);
			else{
				totalTxtFd.setText(subtotalTxtFd.getText());
				overTxtFd.setText("");
				p2B.setVisible(true);
				p2A.setVisible(false);
				setProductBtnEnabledFalse();
			}
		}
	};
	
	public ActionListener ProcessTotalBtn = new ActionListener() {//���b
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == totalBtn) {
				total = 0;
				totalPrice();//�I�s���`���B����k
				payTxtFd.setText(" "+pay+"��");
				if (!payTxtFd.getText().equals("0")){
					if(pay>=total) {
						over=pay-total;
						overTxtFd.setText(" "+String.valueOf(over)+"��");//��s��r
						int ask = JOptionPane.showConfirmDialog(null,"�`���B�G"+total+"��\n�ꦬ�G"+pay+"��\n��s�G"+over+"��\n�T�{�w�������T���B?","���b�T�{",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(ask == JOptionPane.YES_OPTION){
							Date now = new Date();
							SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
							SimpleDateFormat CMdate = new SimpleDateFormat("yyMMdd");
							SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
							String dateStr = date.format(now);
							String CMdateStr = CMdate.format(now);
							String timeStr = time.format(now);
							customer++;
							String customerID = "CM"+CMdateStr+String.format("%05d",customer);
							for(int i=0; i<rowIndex; i++) {//�N��������ǤJ��Ʈw
								String[] trading = {dateStr,
										            timeStr,
										            (String)productID_Table.getValueAt(i,0),
												    (String)myTable.getValueAt(i,1),
												    (String)myTable.getValueAt(i,3),
												    (String)myTable.getValueAt(i,4),
												    (String)myTable.getValueAt(i,5),
												    customerID};
								mydbma.insertRD_into_TB_tradingRecord(trading);
								System.out.println((String)productID_Table.getValueAt(i,0));
							}
							deliveryState = delivery.returnDeliveryState();//���o���L�v�t�����A
							/*---------------���v�t�~�|����----------------*/
							System.out.println(deliveryState);//����
							if(deliveryState == 1){//���v�t
								String [] deliveryInfo = delivery.returnDeliveryInfo();//���o�v�t��T
								mydbma.insertRD_into_TB_deliveryInfo(dateStr,customerID,deliveryInfo);//�N�v�t��T�ǤJ��Ʈw
							}
							/*------------------------------------------*/
							initializeCUsrInt();//�I�s��l�Ƥ�k
							p2A.setVisible(true);
							p2B.setVisible(false);
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"�ҥI�{�������I","�`�N�I",JOptionPane.ERROR_MESSAGE);
						digitTxtFdB.setText("0");
						payTxtFd.setText("");
						overTxtFd.setText("");
					}
				}
			}
		}
	};
	
	public ActionListener ProcessBackBtn = new ActionListener() {//�~����
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == backBtn) {
				p2A.setVisible(true);
				p2B.setVisible(false);
				digitTxtFdB.setText("0");
				payTxtFd.setText("");
				setProductBtnEnabledTrue();
			}	
		}
	};
}