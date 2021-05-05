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
	
	JTabbedPane typeTabPane = new JTabbedPane();//商品頁籤
    JPanel p3a = new JPanel();
    JPanel p3b = new JPanel();
    JPanel p3c = new JPanel();
    JPanel p3d = new JPanel();
    String tabTxtA = "盒裝";
    String tabTxtB = "罐裝";
    String tabTxtC = "桶裝";
    String tabTxtD = "其他";
	
	String [] table_Title = {"序","品項","單價","數量","小計(元)","折扣"};
	DefaultTableModel dfTable;//表格模組
	JTable myTable;
	JScrollPane productPane;
	
	String [] productID_Title = {"貨號","數量"};//儲存資料用不顯示
	DefaultTableModel productID_dfTable = new DefaultTableModel(new String[][]{}, productID_Title);
	JTable productID_Table = new JTable(productID_dfTable);
	
	ImageIcon userIcon = new ImageIcon("使用者.png");
	ImageIcon productIcon = new ImageIcon("方塊酥.png");
	
	JLabel userLab = new JLabel(userIcon);
	JLabel titleLab = new JLabel("飛速買科技銷售前台",SwingConstants.CENTER);
	JLabel totalLab = new JLabel("總金額",SwingConstants.CENTER);
	JLabel payLab = new JLabel("實    付",SwingConstants.CENTER);
	JLabel overLab = new JLabel("找    零",SwingConstants.CENTER);
	
	JTextField digitTxtFdA = new JTextField("0");
	JTextField digitTxtFdB = new JTextField("0");
	JTextField shiftTxtFd = new JTextField("");//班別
	JTextField userTxtFd = new JTextField();//使用者
	JTextField subtotalTxtFd = new JTextField();
	JTextField totalTxtFd = new JTextField("");
	JTextField payTxtFd =  new JTextField("");
	JTextField overTxtFd = new JTextField("");
	
	JButton homeBtn = new JButton("首頁");
	JButton handoverBtn = new JButton("換班");
	JButton returnBtn = new JButton("退貨");
	JButton deliveryBtn = new JButton("宅配到府");
	JButton discountBtn = new JButton("折扣");
	JButton payBtn = new JButton("付現");
	JButton addBtn = new JButton("商品確認");
	JButton redoBtn = new JButton("重新選取");
	JButton cancelBtn = new JButton("單筆取消");
	JButton clearBtn = new JButton("清空所有");
	JButton backBtn = new JButton("繼續交易");
	JButton totalBtn = new JButton("結 帳");
	
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
	
	Color SteelBlue = new Color(70,130,180);//p2背景
	Color LightSlateBlue = new Color(132,112,255);//p1背景
	Color DeepSkyBlue = new Color(0,191,255);//登出、後台、員工打卡、宅配到府、折扣、付現
	Color LightSkyBlue = new Color(30,144,255);//數字鍵
	Color Green4 = new Color(0,139,0);//商品確認
	Color Gold = new Color(255,215,0);//重新選取
	Color Tan = new Color(255,165,79);//單筆取消
	Color Coral = new Color(255,114,86);//清空所有
	Color OldLace = new Color(253,245,230);//盒裝商品
	Color lavender = new Color(230,230,250);//罐裝商品
	Color LemonChiffon = new Color(255,250,205);//桶裝商品
	Color Honeydew = new Color(240,255,240);//其他商品
	
	Font font1 = new Font("微軟正黑體",Font.BOLD,36);
	Font font2 = new Font("微軟正黑體",Font.BOLD,30);
	Font font3 = new Font("微軟正黑體",Font.PLAIN,28);
	Font font4 = new Font("標楷體",Font.BOLD,20);
	Font font5 = new Font("新細明體",Font.BOLD,16);
	Font font6 = new Font("微軟正黑體",Font.PLAIN,20);
	Font font7 = new Font("微軟正黑體",Font.BOLD,16);
	
	int rowIndex = 0;
	int rowCount;//表格總數
	int amount;
	int price;
	int total;
	int pay;
	int over;
	int customer = 0;
	//int stockCount = 0;
	int deliveryState = 0;//有無宅配,無0,有1
	
	CUsrInt(){
		for(int i=0; i<discount.offBtn.length; i++) {
			discount.offBtn[i].addActionListener(ProcessDiscountBtn);
		}
		/*以下為容器設定*/
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
		
		p2B.setBounds(0,(int)(screenH*0.55),(int)(screenW*0.55),(int)(screenH*0.45));//結帳容器
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
		
		typeTabPane.setBounds(0,80,p3W,p3H-80);//頁籤容器
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
		/*以上為容器設定*/
		/*以下為P1*/
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
		TableColumnModel cModel = myTable.getColumnModel();/*下面三行設定表格各別寬度*/
		TableColumn Title0 = cModel.getColumn(0),Title1 = cModel.getColumn(1);
		Title0.setPreferredWidth(30);
		Title1.setPreferredWidth(130);
		myTable.setFont(font5);
		myTable.setEnabled(true);
		//myTable.setCellSelectionEnabled(false);//是否允許行跟列的選取同時存在
	    myTable.setRowSelectionAllowed(true);//選取時整列會變色
	    JTableHeader tableHead = myTable.getTableHeader();
	    tableHead.setPreferredSize(new Dimension(tableHead.getWidth(),35));
	    tableHead.setFont(font7);
		productPane = new JScrollPane(myTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		productPane.setBounds(0,(int)(p1H*0.2),p1W,(int)(p1H*0.8));
		productPane.setVisible(true);
		p1.add(productPane);
		/*以上為P1*/
		/*以下為P2A*/
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
		/*以上為P2A*/
		/*以下為P2B*/
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
		/*以上為P2B*/
		/*以下為P3*/
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
		/*以上為P3*/		
		/*以下為視窗設定*/
		f.setTitle("銷售前台");
		f.setLayout(null);
		f.setBounds(0,0,screenW,screenH);
		f.setUndecorated(true);
		/*以上為視窗設定*/
	}
	/**************end of CUsrInt****************/
	
	private void totalPrice() {//設定算總金額的方法
		for(int i=0; i<rowIndex; i++) {
			price = Integer.parseInt((String)myTable.getValueAt(i,4));//抓取[小計]字串，再轉為整數
			total = total + price;
			subtotalTxtFd.setText(" "+String.valueOf(total)+"元");//將(總金額)的整數值轉為字串,並顯示在totalTxtFd
		}
	}
	
	public void initializeCUsrInt() {//初始化
		homeBtn.setEnabled(true);
		handoverBtn.setEnabled(true);
		dfTable.setRowCount(0);//清空表格
		dfTable.fireTableDataChanged();
		productID_dfTable.setRowCount(0);//清空表格
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
		setProductBtnEnabledTrue();//呼叫設定商品按鈕啟用的方法
	}
	
	public void newTableData(String itemName, String itemPrice, String itemID) {//點選商品按鈕後做相關設定
		homeBtn.setEnabled(false);
		handoverBtn.setEnabled(false);
		dfTable.addRow(new Object[]{"",itemName,itemPrice,"1",itemPrice,""});
		dfTable.fireTableDataChanged();//調用DefaultTableModel的fireTableDataChanged方法可做model刷新
		myTable.updateUI();
		productID_dfTable.addRow(new Object[]{itemID,""});
		productID_dfTable.fireTableDataChanged();
		productID_Table.updateUI();
		price = (Integer.parseInt(itemPrice));//抓取[單價]自串轉為整數price
		rowCount=dfTable.getRowCount();//取得表格總列數
		//String[][] productStock = mydbma.findRD_in_TB_productInfo(itemID,1);//從資料庫取得商品庫存
		//stockCount = Integer.parseInt(productStock[0][2]);//庫存數量
	}
	
	public void setProductBtnEnabledTrue() {//設定商品按鈕啟
		for(int i=0; i<productBtnA.length; i++) {
			for(int j=0; j<productBtnA[0].length; j++) {
				//if(!productBtnStringA[i][j].equals("")) {
	    			//String[][] productCount = mydbma.findRD_in_TB_productInfo(productIDStringA[i][j],1);//從資料庫取得商品庫存
	    			//if(Integer.parseInt(productCount[0][2]) > 0) {
	    				productBtnA[i][j].setEnabled(true);
	    			//}
	    			//else {
	    			//	productBtnA[i][j].setEnabled(false);//將沒有庫存的商品隱藏
	    			//}
	    		//}
			}
		}
		for(int i=0; i<productBtnB.length; i++) {
			for(int j=0; j<productBtnB[0].length; j++) {
				//if(!productBtnStringB[i][j].equals("")) {
	    			//String[][] productStock = mydbma.findRD_in_TB_productInfo(productIDStringB[i][j],1);//從資料庫取得商品庫存
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
	    			//String[][] productStock = mydbma.findRD_in_TB_productInfo(productIDStringC[i][j],1);//從資料庫取得商品庫存
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
	    			//String[][] productStock = mydbma.findRD_in_TB_productInfo(productIDStringD[i][j],1);//從資料庫取得商品庫存
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
	
	public void setProductBtnEnabledFalse() {//設定商品按鈕關閉
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
	
	/**************各項傾聽器****************/
	public ActionListener ProcessProductBtn = new ActionListener() {//商品
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
	
	public ActionListener ProcessDigitBtnA = new ActionListener() {//數字鍵A
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<digitBtnA.length; i++) {
				for(int j=0; j<digitBtnA[0].length; j++) {
					if(e.getSource() == digitBtnA[3][2] && rowCount-rowIndex==1) {
						digitTxtFdA.setText("0");
					}
					else if(e.getSource() == digitBtnA[i][j] && rowCount-rowIndex==1){
						if(amount<=10000) {
							amount = Integer.parseInt(digitTxtFdA.getText()+digitBtnA[i][j].getText());//抓取JTextField的值，再轉為整數
							price = Integer.parseInt((String)myTable.getValueAt(rowIndex,2));//抓取[單價]字串，再轉為整數
							price = price*amount;//單價*數量
							digitTxtFdA.setText(String.valueOf(amount));//顯示轉為字串的單價在數字文字欄位
							myTable.setValueAt(String.valueOf(amount),rowIndex,3);//顯示轉為字串的數量在表格
				    		myTable.setValueAt(String.valueOf(price),rowIndex,4);//將(單價*數量)轉為字串後在表格顯示
				    		myTable.setValueAt("",rowIndex,5);//如果數量重選,表格的折扣會清空
						}
					}
				}
			}
		}
	};
	
	public ActionListener ProcessDigitBtnB = new ActionListener() {//數字鍵B
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<digitBtnB.length; i++) {
				for(int j=0; j<digitBtnB[0].length; j++) {
					if(e.getSource() == digitBtnB[3][2]){
						digitTxtFdB.setText("0");
						pay = 0;
					}
					else if(e.getSource() == digitBtnB[i][j]) {//第一個輸入的數字不得為0
						if(pay<=1000000) {
							pay = Integer.parseInt(digitTxtFdB.getText()+digitBtnB[i][j].getText());
							digitTxtFdB.setText(String.valueOf(pay));
						}
					}
				}
			}
		}
	};
	
	public ActionListener ProcessOperateBtn = new ActionListener() {//表格控制鍵
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == clearBtn && rowCount != 0) {//清空所有
				int ask = JOptionPane.showConfirmDialog(null,"確定要清空所有商品項目?","確認清空",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if( ask == JOptionPane.YES_OPTION ) {
					initializeCUsrInt();//呼叫初始化方法
				}
            }
			
			if(e.getSource() == redoBtn && rowCount-rowIndex==1) {//重新選取
				dfTable.removeRow(rowCount-1);
				dfTable.fireTableDataChanged();
				productID_dfTable.removeRow(rowCount-1);
				productID_dfTable.fireTableDataChanged();
				rowCount=dfTable.getRowCount();//重新取得表格總列數
				digitTxtFdA.setText("0");
				amount = 0;
				//stockCount=0;
				setProductBtnEnabledTrue();//呼叫設定商品按鈕啟用的方法
            }
			
			if (e.getSource() == cancelBtn && rowCount != 0) {//取消單項
  				int selectedRow=myTable.getSelectedRow();//取得選取的列,沒有選取會預設為-1
  				if (selectedRow != -1 && selectedRow < rowIndex) {//有選取 :刪除指定列
  					dfTable.removeRow(selectedRow);
  					productID_dfTable.removeRow(selectedRow);
  					for(int i=selectedRow; i<rowIndex-1; i++) {//重新排序
  						myTable.setValueAt(String.valueOf(i+1),i,0);
  					}
  					if(selectedRow == 0) {
  						subtotalTxtFd.setText("");
  					}
  					rowCount=dfTable.getRowCount();//重新取得表格總列數
  					rowIndex--;
  	  				total = 0;
  					totalPrice();//呼叫算總金額的方法
  				}
  				else if (selectedRow == -1) {//無選取:錯誤訊息
  					JOptionPane.showMessageDialog(null,"請選擇欲取消的品項。","錯誤！",JOptionPane.ERROR_MESSAGE);
  				}
  				else {//選取了沒有品項的列
  					JOptionPane.showMessageDialog(null,"沒有可以取消的品項。","錯誤！",JOptionPane.ERROR_MESSAGE);
  				}
  			}
			
			if( e.getSource() == addBtn && rowCount-rowIndex==1 /*&& stockCount>=amount*/) {//商品確認
				if(((String)myTable.getValueAt(rowIndex,3)).equals("0") || ((String)myTable.getValueAt(rowIndex,3)).equals("")) {
					JOptionPane.showMessageDialog(null,"商品數量不得小於1。","錯誤！",JOptionPane.ERROR_MESSAGE);
				}
				else {
					myTable.setValueAt(String.valueOf(rowIndex+1),rowIndex,0);
					rowIndex++;
					total = 0;
					totalPrice();//呼叫算總金額的方法
					amount = 0;
					//stockCount=0;
					digitTxtFdA.setText("0");
					setProductBtnEnabledTrue();
				}
			}
//			else if( e.getSource() == addBtn && rowCount-rowIndex==1 && stockCount<amount){
//				JOptionPane.showMessageDialog(null,"商品庫存不足，僅剩餘 "+stockCount+" 件","庫存不足！",JOptionPane.WARNING_MESSAGE);
//				digitTxtFdA.setText("0");
//			}
		}
	};
	
	public ActionListener ProcessDiscountBtn = new ActionListener() {//折扣
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == discountBtn && rowCount-rowIndex==1) {
				discount.setVisible(true);
			}
			else if(e.getSource() == discountBtn && rowCount-rowIndex==0){
				JOptionPane.showMessageDialog(null,"請點選商品！","錯誤！",JOptionPane.ERROR_MESSAGE);
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
	
	public ActionListener ProcessDeliveryBtn = new ActionListener() {//宅配服務
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == deliveryBtn)
				delivery = new Delivery();
				delivery.f.setVisible(true);
		}
	};
	
	public ActionListener ProcessPayBtn = new ActionListener() {//付現
		public void actionPerformed(ActionEvent e) {
		    if(e.getSource() == payBtn && rowCount == 0)
				JOptionPane.showMessageDialog(null,"請點選商品！","錯誤！",JOptionPane.ERROR_MESSAGE);
		    else if(e.getSource() == payBtn && rowCount-rowIndex==1)//要改為若rowIndex等於""就跳出訊息
				JOptionPane.showMessageDialog(null,"尚未確認商品，請點按「確認商品」！","錯誤！",JOptionPane.ERROR_MESSAGE);
			else{
				totalTxtFd.setText(subtotalTxtFd.getText());
				overTxtFd.setText("");
				p2B.setVisible(true);
				p2A.setVisible(false);
				setProductBtnEnabledFalse();
			}
		}
	};
	
	public ActionListener ProcessTotalBtn = new ActionListener() {//結帳
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == totalBtn) {
				total = 0;
				totalPrice();//呼叫算總金額的方法
				payTxtFd.setText(" "+pay+"元");
				if (!payTxtFd.getText().equals("0")){
					if(pay>=total) {
						over=pay-total;
						overTxtFd.setText(" "+String.valueOf(over)+"元");//找零文字
						int ask = JOptionPane.showConfirmDialog(null,"總金額："+total+"元\n實收："+pay+"元\n找零："+over+"元\n確認已收取正確金額?","結帳確認",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
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
							for(int i=0; i<rowIndex; i++) {//將交易紀錄傳入資料庫
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
							deliveryState = delivery.returnDeliveryState();//取得有無宅配的狀態
							/*---------------有宅配才會執行----------------*/
							System.out.println(deliveryState);//測試
							if(deliveryState == 1){//有宅配
								String [] deliveryInfo = delivery.returnDeliveryInfo();//取得宅配資訊
								mydbma.insertRD_into_TB_deliveryInfo(dateStr,customerID,deliveryInfo);//將宅配資訊傳入資料庫
							}
							/*------------------------------------------*/
							initializeCUsrInt();//呼叫初始化方法
							p2A.setVisible(true);
							p2B.setVisible(false);
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"所付現金不足！","注意！",JOptionPane.ERROR_MESSAGE);
						digitTxtFdB.setText("0");
						payTxtFd.setText("");
						overTxtFd.setText("");
					}
				}
			}
		}
	};
	
	public ActionListener ProcessBackBtn = new ActionListener() {//繼續交易
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