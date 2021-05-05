import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.*;

class CMgr {//TR�������,DI�v�t��T,SD���u��T

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenW = screenSize.width;
    int screenH = screenSize.height;
    int tabpaneW,tabpaneH;
	
    JFrame f = new JFrame();                
    JPanel p1 = new JPanel();
    JPanel TRPanel = new JPanel();//��������e��
    JPanel SIPanel = new JPanel();
    JPanel DIPanel = new JPanel();//�v�t��T
    JPanel SDPanel = new JPanel();//���u��T
    
    JTabbedPane tabpane = new JTabbedPane();//��O�޲z���Үe��
    String [] tabTxt = {"����O��","�w�s�d��","�v�t��T","���u��T"};//���Ҥ��e
    
    JScrollPane TRSPane;
    JScrollPane SISPane;//�w�s�d�߷ưʮe��(���)
    JScrollPane DISPane;
    JScrollPane SDSPane;//���u��Ʒưʮe��(���)
    
    JTable TRTable;
    DefaultTableModel TRdfTable;
    String [] TRTable_title = {"������","����ɶ�","�ӫ~�f��","�ӫ~�W��","�ƶq","�p�p","�馩","�U�Ƚs��"};
    
    JTable SITable;//�ŧi�@�Ӯw�s�d�ߪ��
    DefaultTableModel SIdfTable;
    String [] SITable_title = {"�f��","�~��","�{���w�s","�i�f/�P�h","�`�w�s"};
    
    JTable DITable;
    DefaultTableModel DIdfTable;
    String [] DITable_title = {"������","�U�Ƚs��","�U�ȩm�W","�s���q��","�a�}"};
    
    JTable SDTable;//�ŧi�@�ӭ��u��ƪ��
    DefaultTableModel SDdfTable;
    String [] SDTable_title = {"���d���","���u�s��","���u�m�W","¾��","�W�Z���d","�W�Z���d","�ɼ�"};
    
    String[] productTypeString = {"���˰ӫ~","���˰ӫ~","��˰ӫ~","��L�ӫ~","�������"};
    JComboBox productTypeCmbBox = new JComboBox(productTypeString);
    
    JLabel titleLabel = new JLabel("���t�R��ޫ�x�޲z�t��",SwingConstants.CENTER);
    JLabel TRsDateLabel = new JLabel("�_�l���",SwingConstants.CENTER);
    JLabel TReDateLabel = new JLabel("������",SwingConstants.CENTER);
    JLabel TRcustomerLabel = new JLabel("�U�Ƚs��",SwingConstants.CENTER);
    JLabel productTypeLabel = new JLabel("�ӫ~����",SwingConstants.CENTER);
    JLabel productIDLabel = new JLabel("�ӫ~�f��",SwingConstants.CENTER);
    JLabel productCountLabel = new JLabel("�ƶq",SwingConstants.CENTER);
    JLabel SDsDateLabel = new JLabel("�_�l���",SwingConstants.CENTER);
    JLabel SDeDateLabel = new JLabel("������",SwingConstants.CENTER);
    JLabel SDstaffLabel = new JLabel("¾���u��",SwingConstants.CENTER);
    JLabel DIsDateLabel = new JLabel("�_�l���",SwingConstants.CENTER);
    JLabel DIeDateLabel = new JLabel("������",SwingConstants.CENTER);
    
    JTextField TRsDateTxtFd = new JTextField("");
    JTextField TReDateTxtFd = new JTextField("");
    JTextField TRcustomerTxtFd = new JTextField("");
    JTextField productIDTxtFd = new JTextField("");
    JTextField selectedProductTxtFd = new JTextField("");
    JTextField productCountTxtFd = new JTextField("");
    JTextField SDsDateTxtFd = new JTextField("");
    JTextField SDeDateTxtFd = new JTextField("");
    JTextField SDstaffTxtFd = new JTextField("");
    JTextField DIsDateTxtFd = new JTextField("");
    JTextField DIeDateTxtFd = new JTextField("");
    
    JButton homeBtn = new JButton("��^����");//�ϥΪ̤���������
    JButton TRsDateBtn = new JButton("��");
    JButton TReDateBtn = new JButton("��");
    JButton TRdateQueryBtn = new JButton("����d�ߥ��");
    JButton TRcustomerQueryBtn = new JButton("�U�Ȭd�ߥ��");
    JButton productTypeQueryBtn = new JButton("�����d�߮w�s");
    JButton productIDQueryBtn = new JButton("�f���d�߮w�s");
    JButton productPurchaseBtn = new JButton("�i�f");
    JButton productReturnBtn = new JButton("�P�h");
    JButton SDsDateBtn = new JButton("��");
    JButton SDeDateBtn = new JButton("��");
    JButton SDdateQueryBtn = new JButton("����d�߭��u");
    JButton SDstaffQueryBtn = new JButton("�u���d�߭��u");
    JButton DIsDateBtn = new JButton("��");
    JButton DIeDateBtn = new JButton("��");
    JButton DIqueryBtn = new JButton("�d�ߦv�t��T");
    
    Color IndianRed = new Color(255,106,106);
    Color Wheat	= new Color(245,222,179);
    Color Seashell = new Color(238,229,222);
    Color PaleTurquoise = new Color(150,205,205);
    Color LightGoldenro = new Color(238,220,130);
    Color LightSalmon = new	Color(255,160,122);
    Color Jasmine = new Color(230,195,92);
    Color LightSkyBlue = new Color(30,144,255);
    Color Coral = new Color(255,114,86);
    
    Font font1 = new Font("�L�n������",Font.BOLD,36);
    Font font2 = new Font("�L�n������",Font.BOLD,16);
    Font font3 = new Font("�s�ө���",Font.PLAIN,16);
    
    String productType = "JJ4718881__";
    String productID = "";
    String productName = "";
    int productCount = 0;
    int selectedRow = 0;
    
    CDM_dbma mydbma = new CDM_dbma();//��Ʈw
    
    CMgr(){
        p1.setBounds(0,0,screenW,screenH);
        p1.setBackground(IndianRed);
        p1.setLayout(null); 
        f.add(p1);
    	
        tabpane.setBounds(0,(int)(screenH*0.15),screenW,(int)(screenH*0.85));//��O�޲z���Үe��
        tabpane.setFont(new Font("�L�n������", Font.PLAIN, 24));
        tabpane.add(tabTxt[0],TRPanel);//����O�����Ҫ����ޤΤ��e
        tabpane.add(tabTxt[1],SIPanel);//���Үe���w�s�d�߭��Ҫ����ޤΤ��e 
        tabpane.add(tabTxt[2],DIPanel);
        tabpane.add(tabTxt[3],SDPanel);
        p1.add(tabpane);
        tabpaneW = tabpane.getWidth();
        tabpaneH = tabpane.getHeight();
        
        TRPanel.setBackground(Wheat);
        TRPanel.setLayout(null);
        SIPanel.setBackground(Seashell);
        SIPanel.setLayout(null);
        DIPanel.setBackground(PaleTurquoise);
        DIPanel.setLayout(null);
        SDPanel.setBackground(LightGoldenro);
        SDPanel.setLayout(null);
        /*�H�W���e���]�w*/
        
        titleLabel.setBounds((int)(screenW*0.2),(int)(screenH*0.03),(int)(screenW*0.6),(int)(screenH*0.12));
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(font1);
        p1.add(titleLabel);
        
        homeBtn.setFont(font2);
        homeBtn.setBounds((int)(screenW*0.85),(int)(screenH*0.05),(int)(screenW*0.1),(int)(screenH*0.08));
        homeBtn.setBackground(LightSalmon);
        p1.add(homeBtn);
        
        /*TR*/
        TRdfTable=new DefaultTableModel(new String[][]{},TRTable_title) {
        	public boolean isCellEditable(int row, int column){
        		return false;
        	}
    	};
        TRTable=new JTable(TRdfTable);
        TRTable.setRowHeight(40);
        TRTable.setEnabled(false);
        TRTable.setFont(font3);
        JTableHeader TRTableHead = TRTable.getTableHeader();
        TRTableHead.setPreferredSize(new Dimension(TRTableHead.getWidth(),35));
        TRTableHead.setFont(font2);
        TRSPane = new JScrollPane(TRTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        TRSPane.setBounds(0,tabpaneH/10*2,tabpaneW,tabpaneH/10*8);
        TRSPane.setVisible(true);
        TRPanel.add(TRSPane);
        
        TRsDateLabel.setBounds(tabpaneW/100,tabpaneH/50,tabpaneW/100*10,tabpaneH/50*3);
        TRsDateLabel.setFont(font2);
        TRPanel.add(TRsDateLabel);
        
        TReDateLabel.setBounds(tabpaneW/100*35,tabpaneH/50,tabpaneW/100*10,tabpaneH/50*3);
        TReDateLabel.setFont(font2);
        TRPanel.add(TReDateLabel);
        
        TRcustomerLabel.setBounds(tabpaneW/100,tabpaneH/50*6,tabpaneW/100*10,tabpaneH/50*3);
        TRcustomerLabel.setFont(font2);
        TRPanel.add(TRcustomerLabel);
        
        TRsDateTxtFd.setBounds(tabpaneW/100*11,tabpaneH/50,tabpaneW/100*15,tabpaneH/50*3);
        TRsDateTxtFd.setEditable(false);
        TRsDateTxtFd.setFont(font2);
        TRPanel.add(TRsDateTxtFd);
        
        TReDateTxtFd.setBounds(tabpaneW/100*45,tabpaneH/50,tabpaneW/100*15,tabpaneH/50*3);
        TReDateTxtFd.setEditable(false);
        TReDateTxtFd.setFont(font2);
        TRPanel.add(TReDateTxtFd);
        
        TRcustomerTxtFd.setBounds(tabpaneW/100*11,tabpaneH/50*6,tabpaneW/100*20,tabpaneH/50*3);
        TRcustomerTxtFd.setFont(font2);
        TRPanel.add(TRcustomerTxtFd);
        
        TRsDateBtn.setBounds(tabpaneW/100*27,tabpaneH/50,tabpaneW/100*5,tabpaneH/50*3);
        TRsDateBtn.setBackground(Color.lightGray);
        TRsDateBtn.setFont(font2);
        TRsDateBtn.addActionListener(ProcessDateBtn);
        TRPanel.add(TRsDateBtn);
        
        TReDateBtn.setBounds(tabpaneW/100*61,tabpaneH/50,tabpaneW/100*5,tabpaneH/50*3);
        TReDateBtn.setBackground(Color.lightGray);
        TReDateBtn.setFont(font2);
        TReDateBtn.addActionListener(ProcessDateBtn);
        TRPanel.add(TReDateBtn);
        
        TRdateQueryBtn.setBounds(tabpaneW/100*70,tabpaneH/50,tabpaneW/100*12,tabpaneH/50*3);
        TRdateQueryBtn.setBackground(Jasmine);
        TRdateQueryBtn.setFont(font2);
        TRdateQueryBtn.addActionListener(ProcessTRDateQueryBtn);
        TRPanel.add(TRdateQueryBtn);
        
        TRcustomerQueryBtn.setBounds(tabpaneW/100*35,tabpaneH/50*6,tabpaneW/100*12,tabpaneH/50*3);
        TRcustomerQueryBtn.setBackground(Jasmine);
        TRcustomerQueryBtn.setFont(font2);
        TRcustomerQueryBtn.addActionListener(ProcessTRCustomerQueryBtn);
        TRPanel.add(TRcustomerQueryBtn);
        
        /*SI*/
        SIdfTable=new DefaultTableModel(new String[][]{},SITable_title) {
        	public boolean isCellEditable(int row, int column){
		        return false;
		    }
        };
        SITable=new JTable(SIdfTable);
        SITable.setRowHeight(40);
        SITable.setFont(font3);
        JTableHeader SITableHead = SITable.getTableHeader();
        SITableHead.setPreferredSize(new Dimension(SITableHead.getWidth(),35));
        SITableHead.setFont(font2);
        SITable.addMouseListener(ProcessSITable);
        SISPane = new JScrollPane(SITable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        SISPane.setBounds(0,tabpaneH/10*2,tabpaneW,tabpaneH/10*8);
        SISPane.setVisible(true);
        SIPanel.add(SISPane);
        
        productTypeLabel.setBounds(tabpaneW/100,tabpaneH/50,tabpaneW/100*10,tabpaneH/50*3);
        productTypeLabel.setFont(font2);
        SIPanel.add(productTypeLabel);
        
        productTypeCmbBox.setBounds(tabpaneW/100*11,tabpaneH/50,tabpaneW/100*15,tabpaneH/50*3);
        productTypeCmbBox.setFont(font2);
        productTypeCmbBox.addActionListener(ProcessProductTypeCmbBox);
        SIPanel.add(productTypeCmbBox);
        
        productTypeQueryBtn.setBounds(tabpaneW/100*30,tabpaneH/50,tabpaneW/100*12,tabpaneH/50*3);
        productTypeQueryBtn.setBackground(Jasmine);
        productTypeQueryBtn.setFont(font2);
        productTypeQueryBtn.addActionListener(ProcessProductTypeQueryBtn);
        SIPanel.add(productTypeQueryBtn);
        
        productIDLabel.setBounds(tabpaneW/100*45,tabpaneH/50,tabpaneW/100*10,tabpaneH/50*3);
        productIDLabel.setFont(font2);
        SIPanel.add(productIDLabel);
        
        productIDTxtFd.setBounds(tabpaneW/100*55,tabpaneH/50,tabpaneW/100*20,tabpaneH/50*3);
        productIDTxtFd.setFont(font2);
        SIPanel.add(productIDTxtFd);
        
        productIDQueryBtn.setBounds(tabpaneW/100*79,tabpaneH/50,tabpaneW/100*12,tabpaneH/50*3);
        productIDQueryBtn.setBackground(Jasmine);
        productIDQueryBtn.setFont(font2);
        productIDQueryBtn.addActionListener(ProcessProductIDQueryBtn);
        SIPanel.add(productIDQueryBtn);
        
        selectedProductTxtFd.setBounds(tabpaneW/100*3,tabpaneH/50*6,tabpaneW/100*26,tabpaneH/50*3);
        selectedProductTxtFd.setEditable(false);
        selectedProductTxtFd.setFont(font2);
        SIPanel.add(selectedProductTxtFd);
        
        productCountLabel.setBounds(tabpaneW/100*33,tabpaneH/50*6,tabpaneW/100*5,tabpaneH/50*3);
        productCountLabel.setFont(font2);
        SIPanel.add(productCountLabel);
        
        productCountTxtFd.setBounds(tabpaneW/100*38,tabpaneH/50*6,tabpaneW/100*6,tabpaneH/50*3);
        productCountTxtFd.setFont(font2);
        productCountTxtFd.setEnabled(false);
        SIPanel.add(productCountTxtFd);
        
        productPurchaseBtn.setBounds(tabpaneW/100*48,tabpaneH/50*6,tabpaneW/100*7,tabpaneH/50*3);
        productPurchaseBtn.setBackground(LightSkyBlue);
        productPurchaseBtn.setFont(font2);
        productPurchaseBtn.setEnabled(false);
        productPurchaseBtn.addActionListener(ProcessProductPurchaseBtn);
        SIPanel.add(productPurchaseBtn);
        
        productReturnBtn.setBounds(tabpaneW/100*59,tabpaneH/50*6,tabpaneW/100*7,tabpaneH/50*3);
        productReturnBtn.setBackground(Coral);
        productReturnBtn.setFont(font2);
        productReturnBtn.setEnabled(false);
        productReturnBtn.addActionListener(ProcessProductReturnBtn);
        SIPanel.add(productReturnBtn);
        
        /*DI*/
        DIdfTable=new DefaultTableModel(new String[][]{},DITable_title) {
        	public boolean isCellEditable(int row, int column){
		        return false;
		    }
        };
        DITable=new JTable(DIdfTable);
        DITable.setRowHeight(40);
        TableColumnModel cModel = DITable.getColumnModel();/*�U���T��]�w���U�O�e��*/
		TableColumn Title4 = cModel.getColumn(4);
		Title4.setPreferredWidth(250);
        DITable.setFont(font3);
        JTableHeader DITableHead = DITable.getTableHeader();
        DITableHead.setPreferredSize(new Dimension(DITableHead.getWidth(),35));
        DITableHead.setFont(font2);
        DITable.addMouseListener(ProcessDITable);
        DISPane = new JScrollPane(DITable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        DISPane.setBounds(0,tabpaneH/10,tabpaneW,tabpaneH/10*9);
        DISPane.setVisible(true);
        DIPanel.add(DISPane);
        
        DIsDateLabel.setBounds(tabpaneW/100,tabpaneH/50,tabpaneW/100*10,tabpaneH/50*3);
        DIsDateLabel.setFont(font2);
        DIPanel.add(DIsDateLabel);
        
        DIeDateLabel.setBounds(tabpaneW/100*35,tabpaneH/50,tabpaneW/100*10,tabpaneH/50*3);
        DIeDateLabel.setFont(font2);
        DIPanel.add(DIeDateLabel);
        
        DIsDateTxtFd.setBounds(tabpaneW/100*11,tabpaneH/50,tabpaneW/100*15,tabpaneH/50*3);
        DIsDateTxtFd.setEditable(false);
        DIsDateTxtFd.setFont(font2);
        DIPanel.add(DIsDateTxtFd);
        
        DIeDateTxtFd.setBounds(tabpaneW/100*45,tabpaneH/50,tabpaneW/100*15,tabpaneH/50*3);
        DIeDateTxtFd.setEditable(false);
        DIeDateTxtFd.setFont(font2);
        DIPanel.add(DIeDateTxtFd);
        
        DIsDateBtn.setBounds(tabpaneW/100*27,tabpaneH/50,tabpaneW/100*5,tabpaneH/50*3);
        DIsDateBtn.setBackground(Color.lightGray);
        DIsDateBtn.setFont(font2);
        DIsDateBtn.addActionListener(ProcessDateBtn);
        DIPanel.add(DIsDateBtn);
        
        DIeDateBtn.setBounds(tabpaneW/100*61,tabpaneH/50,tabpaneW/100*5,tabpaneH/50*3);
        DIeDateBtn.setBackground(Color.lightGray);
        DIeDateBtn.setFont(font2);
        DIeDateBtn.addActionListener(ProcessDateBtn);
        DIPanel.add(DIeDateBtn);
        
        DIqueryBtn.setBounds(tabpaneW/100*70,tabpaneH/50,tabpaneW/100*12,tabpaneH/50*3);
        DIqueryBtn.setBackground(Jasmine);
        DIqueryBtn.setFont(font2);
        DIqueryBtn.addActionListener(ProcessDIQueryBtn);
        DIPanel.add(DIqueryBtn);
        
        /*SD*/
        SDdfTable=new DefaultTableModel(new String[][]{},SDTable_title);
        SDTable=new JTable(SDdfTable);
        SDTable.setRowHeight(40);
        SDTable.setEnabled(false);
        SDTable.setFont(font3);
        JTableHeader SDTableHead = SDTable.getTableHeader();
        SDTableHead.setPreferredSize(new Dimension(SDTableHead.getWidth(),35));
        SDTableHead.setFont(font2);
        SDSPane = new JScrollPane(SDTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        SDSPane.setBounds(0,tabpaneH/10*2,tabpaneW,tabpaneH/10*8);
        SDSPane.setVisible(true);
        SDPanel.add(SDSPane);
        
        SDsDateLabel.setBounds(tabpaneW/100,tabpaneH/50,tabpaneW/100*10,tabpaneH/50*3);
        SDsDateLabel.setFont(font2);
        SDPanel.add(SDsDateLabel);
        
        SDeDateLabel.setBounds(tabpaneW/100*35,tabpaneH/50,tabpaneW/100*10,tabpaneH/50*3);
        SDeDateLabel.setFont(font2);
        SDPanel.add(SDeDateLabel);
        
        SDstaffLabel.setBounds(tabpaneW/100,tabpaneH/50*6,tabpaneW/100*10,tabpaneH/50*3);
        SDstaffLabel.setFont(font2);
        SDPanel.add(SDstaffLabel);
        
        SDsDateTxtFd.setBounds(tabpaneW/100*11,tabpaneH/50,tabpaneW/100*15,tabpaneH/50*3);
        SDsDateTxtFd.setEditable(false);
        SDsDateTxtFd.setFont(font2);
        SDPanel.add(SDsDateTxtFd);
        
        SDeDateTxtFd.setBounds(tabpaneW/100*45,tabpaneH/50,tabpaneW/100*15,tabpaneH/50*3);
        SDeDateTxtFd.setEditable(false);
        SDeDateTxtFd.setFont(font2);
        SDPanel.add(SDeDateTxtFd);
        
        SDstaffTxtFd.setBounds(tabpaneW/100*11,tabpaneH/50*6,tabpaneW/100*20,tabpaneH/50*3);
        SDstaffTxtFd.setFont(font2);
        SDPanel.add(SDstaffTxtFd);
        
        SDsDateBtn.setBounds(tabpaneW/100*27,tabpaneH/50,tabpaneW/100*5,tabpaneH/50*3);
        SDsDateBtn.setBackground(Color.lightGray);
        SDsDateBtn.setFont(font2);
        SDsDateBtn.addActionListener(ProcessDateBtn);
        SDPanel.add(SDsDateBtn);
        
        SDeDateBtn.setBounds(tabpaneW/100*61,tabpaneH/50,tabpaneW/100*5,tabpaneH/50*3);
        SDeDateBtn.setBackground(Color.lightGray);
        SDeDateBtn.setFont(font2);
        SDeDateBtn.addActionListener(ProcessDateBtn);
        SDPanel.add(SDeDateBtn);
        
        SDdateQueryBtn.setBounds(tabpaneW/100*70,tabpaneH/50,tabpaneW/100*12,tabpaneH/50*3);
        SDdateQueryBtn.setBackground(Jasmine);
        SDdateQueryBtn.setFont(font2);
        SDdateQueryBtn.addActionListener(ProcessSDDateQueryBtn);
        SDPanel.add(SDdateQueryBtn);
        
        SDstaffQueryBtn.setBounds(tabpaneW/100*35,tabpaneH/50*6,tabpaneW/100*12,tabpaneH/50*3);
        SDstaffQueryBtn.setBackground(Jasmine);
        SDstaffQueryBtn.setFont(font2);
        SDstaffQueryBtn.addActionListener(ProcessSDStaffQueryBtn);
        SDPanel.add(SDstaffQueryBtn);

        f.setTitle("��x�޲z�t��");
        f.setLayout(null);
        f.setBounds(0,0,screenW,screenH);
        f.setUndecorated(true);
    }
    /**/
    private void initializeTable(DefaultTableModel dfTable) {//����l��
    	dfTable.setRowCount(0);
		dfTable.fireTableDataChanged();
    }
    /**/
    public void initializeCMgr() {//��l�����O����
    	TRdfTable.setRowCount(0);
		TRdfTable.fireTableDataChanged();
		SIdfTable.setRowCount(0);
		SIdfTable.fireTableDataChanged();
		DIdfTable.setRowCount(0);
		DIdfTable.fireTableDataChanged();
		SDdfTable.setRowCount(0);
		SDdfTable.fireTableDataChanged();
		initializeStockInquire();
    }
    /**/
    public void initializeStockInquire() {//��l�Ʈw�s�d��
    	selectedProductTxtFd.setText("");
		productCountTxtFd.setText("");
		productCountTxtFd.setEnabled(false);
		productPurchaseBtn.setEnabled(false);
		productReturnBtn.setEnabled(false);
		productID="";
		productName="";
		selectedRow=0;
		productCount=0;
    }
    /**/
    public ActionListener ProcessDateBtn = new ActionListener(){//�����ܫ��s
        public void actionPerformed(ActionEvent e){
            if( e.getSource() == TRsDateBtn ){
                  DatePopup DP1 = new DatePopup(TRsDateTxtFd);
                  DP1.showDialog();          
            }
            if( e.getSource() == TReDateBtn ){
                  DatePopup DP2 = new DatePopup(TReDateTxtFd);
                  DP2.showDialog();          
            }
            if( e.getSource() == DIsDateBtn ){
                DatePopup DP1 = new DatePopup(DIsDateTxtFd);
                DP1.showDialog();          
            }
            if( e.getSource() == DIeDateBtn ){
                DatePopup DP2 = new DatePopup(DIeDateTxtFd);
                DP2.showDialog();          
            }
            if( e.getSource() == SDsDateBtn ){
                DatePopup DP1 = new DatePopup(SDsDateTxtFd);
                DP1.showDialog();          
            }
            if( e.getSource() == SDeDateBtn ){
                DatePopup DP2 = new DatePopup(SDeDateTxtFd);
                DP2.showDialog();          
            }
        }    
    };
    /**/
    public ActionListener ProcessProductTypeCmbBox = new ActionListener() {//�U�Կ���ܰӫ~����
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == productTypeCmbBox) {
				String type = (String)productTypeCmbBox.getSelectedItem();
				switch(type) {
					case "���˰ӫ~":
						productType = "JJ4718881__";
					break;
					case "���˰ӫ~":
						productType = "JJ4718882__";
					break;
					case "��˰ӫ~":
						productType = "JJ4718883__";
					break;
					case "��L�ӫ~":
						productType = "JJ4718880__";
					break;
					case "�������":
						productType = "JJ471888___";
				}
			}
		}
    };
    /**/
    public ActionListener ProcessTRDateQueryBtn = new ActionListener(){/*�Τ���d�ߥ������*/
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource() == TRdateQueryBtn) {
    			initializeTable(TRdfTable);//�I�s����l�Ƥ�k
    			String sDateStr = TRsDateTxtFd.getText();
				String eDateStr = TReDateTxtFd.getText();
    			if(sDateStr.length()>0 && eDateStr.length()>0){
    				int rowSize = mydbma.get_rowSize_of_tradingRecord_by_date(sDateStr, eDateStr);//���d�ݭn�X�����
    				if(rowSize == 0) {
    					JOptionPane.showMessageDialog(null,"�d�L��������I");
    				}
    				else {
    					String [][] Result = mydbma.findRD_in_TB_tradingRecord_by_date(sDateStr, eDateStr,rowSize);
    					for(int i=0; i<rowSize;i++) {
    						TRdfTable.addRow(new Object[]{Result[i][0],Result[i][1],Result[i][2],Result[i][3],Result[i][4],Result[i][5],Result[i][6],Result[i][7]});
    						TRdfTable.fireTableDataChanged();//�ե�DefaultTableModel��fireTableDataChanged��k�i��model��s
    						TRTable.updateUI();
    					}
    				}
    			}
    			else
    				JOptionPane.showMessageDialog(null,"�����g������I","���~�I",JOptionPane.ERROR_MESSAGE);
    		}
    	}
    };
    /**/
    public ActionListener ProcessTRCustomerQueryBtn = new ActionListener(){/*���U�Ƚs���d�ߥ������*/
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource() == TRcustomerQueryBtn) {
    			initializeTable(TRdfTable);
				String customerID = TRcustomerTxtFd.getText();
    			if(customerID.length()>0){
    				int rowSize = mydbma.get_rowSize_of_tradingRecord_by_customerID(customerID);
    				if(rowSize == 0) {
    					JOptionPane.showMessageDialog(null,"�d�L��������I");
    				}
    				else {
    					String [][] Result = mydbma.findRD_in_TB_tradingRecord_by_customerID(customerID,rowSize);
    					for(int i=0; i<rowSize;i++) {
    						TRdfTable.addRow(new Object[]{Result[i][0],Result[i][1],Result[i][2],Result[i][3],Result[i][4],Result[i][5],Result[i][6],Result[i][7]});
    						TRdfTable.fireTableDataChanged();
    						TRTable.updateUI();
    					}
    				}
    			}
    			else
    				JOptionPane.showMessageDialog(null,"�п�J�@���U�Ƚs���I","���~�I",JOptionPane.ERROR_MESSAGE);
    		}
    	}
    };
    /**/
    public ActionListener ProcessProductTypeQueryBtn = new ActionListener(){/*�ΰӫ~�����d�߮w�s*/
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource() == productTypeQueryBtn) {
    			initializeTable(SIdfTable);
    			initializeStockInquire();
    			int rowSize = mydbma.get_rowSize_of_productInfo(productType);
    			if(rowSize == 0) {
    				JOptionPane.showMessageDialog(null,"�d�L�w�s��ơI");
    			}
    			else {
    				String [][] Result = mydbma.findRD_in_TB_productInfo(productType,rowSize);
    				for(int i=0; i<rowSize;i++) {
    					SIdfTable.addRow(new Object[]{Result[i][0],Result[i][1],Result[i][2]});
    					SIdfTable.fireTableDataChanged();
    					SITable.updateUI();
    				}
    			}
    		}
    	}
    };
    /**/
    public ActionListener ProcessProductIDQueryBtn = new ActionListener(){/*�γf���d�߮w�s*/
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource() == productIDQueryBtn) {
    			initializeTable(SIdfTable);
    			initializeStockInquire();
    			String productID = productIDTxtFd.getText();
    			if(productID.length()>0){
    				int rowSize = mydbma.get_rowSize_of_productInfo(productID);
    				if(rowSize == 0) {
    					JOptionPane.showMessageDialog(null,"�d�L�w�s��ơI");
    				}
    				else {
    					String [][] Result = mydbma.findRD_in_TB_productInfo(productID,rowSize);
    					for(int i=0; i<rowSize;i++) {
    						SIdfTable.addRow(new Object[]{Result[i][0],Result[i][1],Result[i][2]});
    						SIdfTable.fireTableDataChanged();
    						SITable.updateUI();
    					}
    				}
    			}
    			else
    				JOptionPane.showMessageDialog(null,"�п�J�ӫ~�f���I","���~�I",JOptionPane.ERROR_MESSAGE);
    		}
    	}
    };
    /**/
    public MouseListener ProcessSITable = new MouseListener(){//�I��w�s���
    	public void mouseClicked(MouseEvent e) {
    		if(e.getClickCount()==1){
    			selectedRow = SITable.getSelectedRow();
    			if(SITable.getValueAt(selectedRow,3) == null) {
    				productID = (String)SITable.getValueAt(selectedRow,0);
    				productName = (String)SITable.getValueAt(selectedRow,1);
    				productCount = Integer.parseInt((String)SITable.getValueAt(selectedRow,2));
    				selectedProductTxtFd.setText(productID+"---"+productName);
    				productCountTxtFd.setEnabled(true);
    				productPurchaseBtn.setEnabled(true);
    				if(productCount>0)
    					productReturnBtn.setEnabled(true);
    			}
    			else {
    				initializeStockInquire();
    			}
    		}
    	}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
    };
    /**/
    public ActionListener ProcessProductPurchaseBtn = new ActionListener(){//�i�f���s
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource() == productPurchaseBtn && !productCountTxtFd.getText().equals("")) {
    			int purchaseAmount= Integer.parseInt(productCountTxtFd.getText());//�i�f�q
    			if(purchaseAmount>0) {
    				productCount = productCount + purchaseAmount;//�i�f��w�s�q=�Ѿl�w�s+�i�f�q
    	    		mydbma.updateRD_in_TB_productInfo(productCount,productID);
    	    		SITable.setValueAt("(�w�i�f)"+purchaseAmount,selectedRow,3);
    	    		SITable.setValueAt(productCount,selectedRow,4);
    	    		initializeStockInquire();
    			}
    			else
    				JOptionPane.showMessageDialog(null,"�i�f�ƶq���o�p��1�I","���~�I",JOptionPane.ERROR_MESSAGE);
    		}
    		else 
        		JOptionPane.showMessageDialog(null,"�п�J�i�f�ƶq�I","���~�I",JOptionPane.ERROR_MESSAGE);
        }
    };
    /**/
    public ActionListener ProcessProductReturnBtn = new ActionListener(){//�P�h���s
        public void actionPerformed(ActionEvent e){
        	if(e.getSource() == productReturnBtn && !productCountTxtFd.getText().equals("")) {
    			int returnAmount= Integer.parseInt(productCountTxtFd.getText());//�P�h�q
    			if(returnAmount>0 && productCount>=returnAmount) {
    				productCount = productCount - returnAmount;//�P�h��w�s�q=�Ѿl�w�s-�P�h�q
    	    		mydbma.updateRD_in_TB_productInfo(productCount,productID);
    	    		SITable.setValueAt("(�w�P�h)"+returnAmount,selectedRow,3);
    	    		SITable.setValueAt(productCount,selectedRow,4);
    	    		initializeStockInquire();
    			}
    			else if(productCount<returnAmount){
    				JOptionPane.showMessageDialog(null,"�P�h�q���o�j��w�s�q�I","���~�I",JOptionPane.ERROR_MESSAGE);
    			}
    			else
    				JOptionPane.showMessageDialog(null,"�P�h�ƶq���o�p��1�I","���~�I",JOptionPane.ERROR_MESSAGE);
    		}
        	else 
        		JOptionPane.showMessageDialog(null,"�п�J�P�h�ƶq�I","���~�I",JOptionPane.ERROR_MESSAGE);
        }    
    };
    /**/
    public ActionListener ProcessDIQueryBtn = new ActionListener(){/*�d���U�Ȧv�t��T*/
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource() == DIqueryBtn) {
    			initializeTable(DIdfTable);
    			String sDateStr = DIsDateTxtFd.getText();
    			String eDateStr = DIeDateTxtFd.getText();
    			if(sDateStr.length()>0 && eDateStr.length()>0){
    				int rowSize = mydbma.get_rowSize_of_deliveryInfo(sDateStr, eDateStr);
    				if(rowSize == 0) {
    					JOptionPane.showMessageDialog(null,"�d�L�v�t��T�I");
    				}
    				else {
    					String [][] Result = mydbma.findRD_in_TB_deliveryInfo(sDateStr, eDateStr, rowSize);
    					for(int i=0; i<rowSize;i++) {
    						DIdfTable.addRow(new Object[]{Result[i][0],Result[i][1],Result[i][2],Result[i][3],Result[i][4]});
    						DIdfTable.fireTableDataChanged();
    						DITable.updateUI();
    					}
    				}
    			}
    			else
    				JOptionPane.showMessageDialog(null,"�����g������I","���~�I",JOptionPane.ERROR_MESSAGE);
    		}
    	}
    };
    /**/
    public MouseListener ProcessDITable = new MouseListener(){//�I��w�s���
    	public void mouseClicked(MouseEvent e) {
    		if(e.getClickCount()==1){
    			selectedRow = DITable.getSelectedRow();
    			TRcustomerTxtFd.setText((String)DITable.getValueAt(selectedRow,1));
    			//selectedRow = 0;
    		}
    	}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
    };
    /**/
    /**/
    public ActionListener ProcessSDDateQueryBtn = new ActionListener(){/*�Τ���d�߭��u��T*/
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource() == SDdateQueryBtn) {
    			initializeTable(SDdfTable);
    			String sDateStr = SDsDateTxtFd.getText();
    			String eDateStr = SDeDateTxtFd.getText();
    			if(sDateStr.length()>0 && eDateStr.length()>0){
    				int rowSize = mydbma.get_rowSize_of_staffInfo_by_date(sDateStr, eDateStr);
    				if(rowSize == 0) {
    					JOptionPane.showMessageDialog(null,"�d�L���u��T�I");
    				}
    				else {
    					String [][] Result = mydbma.findRD_in_TB_staffInfo_by_date(sDateStr, eDateStr,rowSize);
    					for(int i=0; i<rowSize;i++) {
    						SDdfTable.addRow(new Object[]{Result[i][0],Result[i][1],Result[i][2],Result[i][3],Result[i][4],Result[i][5],Result[i][6]});
    						SDdfTable.fireTableDataChanged();
    						SDTable.updateUI();
    					}
    				}
    			}
    			else
    				JOptionPane.showMessageDialog(null,"�����g������I","���~�I",JOptionPane.ERROR_MESSAGE);
    		}
    	}
    };
    /**/
    public ActionListener ProcessSDStaffQueryBtn = new ActionListener(){/*��¾���u���d�߭��u��T*/
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource() == SDstaffQueryBtn) {
    			initializeTable(SDdfTable);
    			String staffID = SDstaffTxtFd.getText();
    			if(staffID.length()>0){
    				int rowSize = mydbma.get_rowSize_of_staffInfo_by_staffID(staffID);
    				if(rowSize == 0) {
    					JOptionPane.showMessageDialog(null,"�d�L���u��T�I");
    				}
    				else {
    					String [][] Result = mydbma.findRD_in_TB_staffInfo_by_staffID(staffID,rowSize);
    					for(int i=0; i<rowSize;i++) {
    						SDdfTable.addRow(new Object[]{Result[i][0],Result[i][1],Result[i][2],Result[i][3],Result[i][4],Result[i][5],Result[i][6]});
    						SDdfTable.fireTableDataChanged();
    						SDTable.updateUI();
    					}
    				}
    			}
    			else
    				JOptionPane.showMessageDialog(null,"�п�J�@��¾���u���I","���~�I",JOptionPane.ERROR_MESSAGE);
    		}
    	}
    };
}