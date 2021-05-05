import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Delivery {
	JFrame f = new JFrame();
	JPanel p1 = new JPanel();
	
	JLabel customerLab = new JLabel("�U�ȩm�W�G");
	JLabel contactLab = new JLabel("�s���q�ܡG");
	JLabel addressLab = new JLabel("�a�}�G");
	JLabel rocRegionLab = new JLabel("��/��");
	JLabel localRegionLab = new JLabel("�m/��/��/��");
	JLabel roadLab = new JLabel("��");
	JLabel streetLab = new JLabel("��");
	JLabel secLab = new JLabel("�q");
	JLabel laneLab = new JLabel("��");
	JLabel alleyLab = new JLabel("��");
	JLabel numberLab = new JLabel("��");
	JLabel floorLab = new JLabel("��  ��");
	JTextField customerTxtFd = new JTextField("");
	JTextField contactTxtFd = new JTextField("");
	JTextField roadTxtFd = new JTextField("");
	JTextField streetTxtFd = new JTextField("");
	JTextField secTxtFd = new JTextField("");
	JTextField laneTxtFd = new JTextField("");
	JTextField alleyTxtFd = new JTextField("");
	JTextField numberTxtFd = new JTextField("");
	JTextField floorTxtFd = new JTextField("");
	JTextField numTxtFd = new JTextField("");
	JButton addBtn = new JButton("�T�w");
	
	JComboBox<?> rocRegionCmbBox;
    String[] rocRegionString = {"�O�_��","�s�_��","�򶩥�","��饫","�s�˥�","�s�˿�","�]�߿�","�O����","���ƿ�","�n�뿤","���L��","�Ÿq��","�Ÿq��","�O�n��","������","�̪F��","�O�F��","�Ὤ��","�y����","*���","*������","*�s����"};
    JComboBox taipeiCmbBox;
    String[] taipeiString = {"������","�j�P��","���s��","�Q�s��","�j�w��","�U�ذ�","�H�q��","�h�L��","�_���","�����","�n���","��s��"}; 
    JComboBox newtaipeiCmbBox;
    String[] newtaipeiString = {"�O����","�T����","�s����","�éM��","���M��","�g����","�s����","�T�l��","��L��","�a�q��","���s��","�L�f��","Ī�w��","���Ѱ�","�K����",
    							"�H����","�T�۰�","�۪���","�U����","���s��","�����","�`�|��","�����","��ڰ�","���˰�","���˰�","�^�d��","�W�L��","�Q�Ӱ�"};
    JComboBox keelungCmbBox;
    String[] keelungString = {"���R��","�H�q��","������","���s��","�w�ְ�","�x�x��","�C����"};
    JComboBox taoyuanCmbBox;
    String[] taoyuanString = {"���c��","�����","�s���","������","�s�ΰ�","�[����","����","�t�s��","�K�w��","�j�˰�","�_����","�j���","Ī�˰�"};
    JComboBox hsinchuCityCmbBox;
    String[] hsinchuCityString = {"�F��","�_��","���s��"};
    JComboBox hsinchuCountyCmbBox;
    String[] hsinchuCountyString = {"�˥_��","��f�m","�s�׶m","�s�H��","������","�|�L�m","�_�s�m","�˪F��","���p�m","��s�m","�y�۶m","�_�H�m","�o�ܶm"};
    JComboBox miaoliCmbBox;
    String[] miaoliString = {"�˫n��","�Y����","�T�W�m","�n�ܶm","���m","���s��","�q�]��","�b����","�]�ߥ�","�y���m","�Y�ζm","���]�m","�j��m","���w�m","���r�m","�T�q�m","���m","������"};
    JComboBox taichungCmbBox;
    String[] taichungString = {"����","�F��","�n��","���","�_��","�_�ٰ�","��ٰ�","�n�ٰ�","�ӥ���","�j����","���p��","�Q���","�׭��","�Z����","�۩���",
    						   "�F�հ�","�M����","�s����","��l��","�j����","������","�j�{��","�F����","�s����","��ϰ�","�M����","�j�Ұ�","�~�H��","�j�w��"};
    JComboBox changhuaCmbBox;
    String[] changhuaString = {"���ƥ�","���m","��¶m","�q���m","������","�ֿ��m","�u��m","�M����","����m","���L��","���Y�m","�ùt�m","�H�߶m",
    						   "�˴���","�j���m","�H�Q�m","�Ф���","�_����","�Ч��m","���Y�m","�˦{�m","�˶�m","�G�L��","�j���m","�ڭb�m","�G���m"};
    JComboBox nantouCmbBox;
    String[] nantouString = {"�n�륫","���d�m","�����","��m�m","�H����","���R�m","�W���m","������","�����m","�����m","�H�q�m","�ˤs��","�����m"};
    JComboBox yunlinCmbBox;
    String[] yunlinString = {"��n��","�j��m","�����","�g�w��","�ǩ��m","�F�նm","�O��m","�[�I�m","���d�m","�椻��","�L���m","�j�|�m","�l��m","������","�G�[�m","�_����","���L�m","�f��m","�|��m","�����m"};
    JComboBox chiayiCityCmbBox;
    String[] chiayiCityString = {"�F��","���"};
    JComboBox chiayiCountyCmbBox;
    String[] chiayiCountyString = {"�f���m","���s�m","�˱T�m","�����s�m","���H�m","�j�H�m","���W�m","����m","�ӫO��","���l��","�F�۶m","���}�m","�s��m","�����m","�j�L��","�ˤf�m","�q�˶m","���U��"};
    JComboBox tainanCmbBox;
    String[] tainanString = {"�����","�F��","�n��","�_��","�w����","�w�n��","�ñd��","�k����","�s�ư�","�����","�ɤ���","�����","�n�ư�","���w��","���q��","�s�T��","�x�а�","�¨���","�Ψ���",
    						 "����","�C�Ѱ�","�N�x��","�ǥҰ�","�_����","�s���","�����","�ժe��","�F�s��","���Ұ�","�U���","�h���","�Q����","���ư�","�j����","�s�W��","�s����","�w�w��"};
    JComboBox kaohsiungCmbBox;
    String[] kaohsiungString = {"�s����","�e����","�d����","�Q�L��","���s��","�X�z��","�e���","�T����","�����","�p���","�����","��s��","�j�d��","�L���","���Q��","�j���","���Z��","�j����","���s��",
    							"���˰�","������","�мd��","�P�_��","���Y��","��x��","������","�æw��","�򤺰�","�X�s��","���@��","���t��","������","���L��","�ҥP��","�緽��","�����L��","�Z�L��","�X�_��"};
    JComboBox pingtungCmbBox;
    String[] pingtungString = {"�̪F��","�E�p�m","����m","����m","�Q�H�m","���v�m","�ﬥ�m","���H�m","�˥жm","�U���m","��{��","�U�r�m","�T�a���m","���x�m","���a�m","���Z�m","�Ӹq�m",
    						   "�r���m","�s��m","�n�{�m","�L��m","�F����","�[�y�m","�ΥV�m","�s��m","�D�d�m","�D�s�m","�K��m","��l�m","�����m","�d���m","��K��","���{�m"};
    JComboBox taitungCmbBox;
    String[] taitungString = {"�O�F��","��q�m","�����m","�����m","���n�m","�����m","���s��","���ݶm","���W�m","�F�e�m","���\��","���ضm","�ӳ¨��m","���p�m","�j�Z�m","�F���m"};
    JComboBox hualienCmbBox;
    String[] hualienString = {"�Ὤ��","�s���m","�q�L�m","�N�w�m","���׶m","��L��","���_�m","���ضm","���J�m","�U�a�m","�ɨ���","���˶m","�I���m"};
    JComboBox yilanCmbBox;
    String[] yilanString = {"�y����","�Y����","�G�˶m","����m","���s�m","ù�F��","�T�P�m","�j�P�m","�����m","�V�s�m","Ĭ�D��","�n�D�m","�����O"};
    JComboBox penghuCmbBox;
    String[] penghuString = {"������","�����m","��w�m","�C���m","�ըF�m","���m"};
    JComboBox kinmenCmbBox;
    String[] kinmenString = {"���F��","������","����m","������","�P���m","�Q���m"};
    JComboBox lienchiangCmbBox;
    String[] lienchiangString = {"�n��m","�_��m","�����m","�F�޶m"};
    
    Font font1 = new Font("�L�n������",Font.BOLD,14);
    Font font2 = new Font("�L�n������",Font.PLAIN,16);
    String customer = "";
    String contact ="";
    String region = "�O�_��";
    String local = "������";
	String address = "";
	String road = "", street = "", sec = "",lane = "",alley = "", number = "",floor = "", num = "";
	int deliveryState = 0;//���L�v�t,�L0,��1
    
	Delivery() {
		p1.setBounds(0,0,530,260);
		p1.setLayout(null);
		f.add(p1);
		
		customerLab.setBounds(15,20,85,35);
		customerLab.setFont(font2);
		p1.add(customerLab);
		
		contactLab.setBounds(265,20,85,35);
		contactLab.setFont(font2);
		p1.add(contactLab);
		
		addressLab.setBounds(15,100,50,35);
		addressLab.setFont(font2);
		p1.add(addressLab);
		
		rocRegionLab.setBounds(65,80,85,20);//��/��
		rocRegionLab.setFont(font1);
		p1.add(rocRegionLab);
		
		localRegionLab.setBounds(155,80,85,20);//�m/��/��/��
		localRegionLab.setFont(font1);
		p1.add(localRegionLab);
		
		roadLab.setBounds(335,100,15,35);//��
		roadLab.setFont(font1);
		p1.add(roadLab);
		
		streetLab.setBounds(445,100,15,35);//��
		streetLab.setFont(font1);
		p1.add(streetLab);
		
		secLab.setBounds(495,100,15,35);//�q
		secLab.setFont(font1);
		p1.add(secLab);
		
		laneLab.setBounds(115,155,15,35);//��
		laneLab.setFont(font1);
		p1.add(laneLab);
		
		alleyLab.setBounds(185,155,15,35);//��
		alleyLab.setFont(font1);
		p1.add(alleyLab);
		
		numberLab.setBounds(255,155,15,35);//��
		numberLab.setFont(font1);
		p1.add(numberLab);
		
		floorLab.setBounds(310,155,40,35);//��
		floorLab.setFont(font1);
		p1.add(floorLab);
		
		customerTxtFd.setBounds(100,20,140,35);//�U�ȩm�W
		customerTxtFd.setFont(font2);
		p1.add(customerTxtFd);
		
		contactTxtFd.setBounds(350,20,140,35);//�s���q��
		contactTxtFd.setFont(font2);
		p1.add(contactTxtFd);
		
		roadTxtFd.setBounds(245,100,90,35);//��
		roadTxtFd.setFont(font1);
		p1.add(roadTxtFd);
		
		streetTxtFd.setBounds(355,100,90,35);//��
		streetTxtFd.setFont(font1);
		p1.add(streetTxtFd);
		
		secTxtFd.setBounds(465,100,30,35);//�q
		secTxtFd.setFont(font1);
		p1.add(secTxtFd);
		
		laneTxtFd.setBounds(65,155,50,35);//��
		laneTxtFd.setFont(font1);
		p1.add(laneTxtFd);
		
		alleyTxtFd.setBounds(135,155,50,35);//��
		alleyTxtFd.setFont(font1);
		p1.add(alleyTxtFd);
		
		numberTxtFd.setBounds(205,155,50,35);//��
		numberTxtFd.setFont(font1);
		p1.add(numberTxtFd);
		
		floorTxtFd.setBounds(275,155,35,35);//��
		floorTxtFd.setFont(font1);
		p1.add(floorTxtFd);
		
		numTxtFd.setBounds(350,155,35,35);//��...
		numTxtFd.setFont(font1);
		p1.add(numTxtFd);
		
		addBtn.setBounds(400,150,100,45);
		addBtn.setBackground(Color.lightGray);
		addBtn.setFont(font1);
		addBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		addBtn.addActionListener(ProcessAddBtn);
		p1.add(addBtn);
		
		rocRegionCmbBox = new JComboBox(rocRegionString);
		rocRegionCmbBox.setBounds(65,100,85,35); 
		rocRegionCmbBox.setBackground(Color.lightGray);
		rocRegionCmbBox.setForeground(Color.black);
		rocRegionCmbBox.setVisible(true);
		rocRegionCmbBox.setFont(font1);
		rocRegionCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(rocRegionCmbBox);
	    
	    taipeiCmbBox = new JComboBox(taipeiString);//�O�_��
	    taipeiCmbBox.setBounds(155,100,85,35); 
	    taipeiCmbBox.setBackground(Color.lightGray);
	    taipeiCmbBox.setForeground(Color.black);
	    taipeiCmbBox.setVisible(true);
	    taipeiCmbBox.setFont(font1);
	    taipeiCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(taipeiCmbBox);
	    
	    newtaipeiCmbBox = new JComboBox(newtaipeiString);//�s�_��
	    newtaipeiCmbBox.setBounds(155,100,85,35); 
	    newtaipeiCmbBox.setBackground(Color.lightGray);
	    newtaipeiCmbBox.setForeground(Color.black);
	    newtaipeiCmbBox.setVisible(false);
	    newtaipeiCmbBox.setFont(font1);
	    newtaipeiCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(newtaipeiCmbBox);
	    
	    keelungCmbBox = new JComboBox(keelungString);//�򶩥�
	    keelungCmbBox.setBounds(155,100,85,35); 
	    keelungCmbBox.setBackground(Color.lightGray);
	    keelungCmbBox.setForeground(Color.black);
	    keelungCmbBox.setVisible(false);
	    keelungCmbBox.setFont(font1);
	    keelungCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(keelungCmbBox);
	    
	    taoyuanCmbBox = new JComboBox(taoyuanString);//��饫
	    taoyuanCmbBox.setBounds(155,100,85,35); 
	    taoyuanCmbBox.setBackground(Color.lightGray);
	    taoyuanCmbBox.setForeground(Color.black);
	    taoyuanCmbBox.setVisible(false);
	    taoyuanCmbBox.setFont(font1);
	    taoyuanCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(taoyuanCmbBox);
	    
	    hsinchuCityCmbBox = new JComboBox(hsinchuCityString);//�s�˥�
	    hsinchuCityCmbBox.setBounds(155,100,85,35); 
	    hsinchuCityCmbBox.setBackground(Color.lightGray);
	    hsinchuCityCmbBox.setForeground(Color.black);
	    hsinchuCityCmbBox.setVisible(false);
	    hsinchuCityCmbBox.setFont(font1);
	    hsinchuCityCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(hsinchuCityCmbBox);
	    
	    hsinchuCountyCmbBox = new JComboBox(hsinchuCountyString);//�s�˿�
	    hsinchuCountyCmbBox.setBounds(155,100,85,35); 
	    hsinchuCountyCmbBox.setBackground(Color.lightGray);
	    hsinchuCountyCmbBox.setForeground(Color.black);
	    hsinchuCountyCmbBox.setVisible(false);
	    hsinchuCountyCmbBox.setFont(font1);
	    hsinchuCountyCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(hsinchuCountyCmbBox);
	    
	    miaoliCmbBox = new JComboBox(miaoliString);//�]�߿�
	    miaoliCmbBox.setBounds(155,100,85,35); 
	    miaoliCmbBox.setBackground(Color.lightGray);
	    miaoliCmbBox.setForeground(Color.black);
	    miaoliCmbBox.setVisible(false);
	    miaoliCmbBox.setFont(font1);
	    miaoliCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(miaoliCmbBox);
	    
	    taichungCmbBox = new JComboBox(taichungString);//�O����
	    taichungCmbBox.setBounds(155,100,85,35); 
	    taichungCmbBox.setBackground(Color.lightGray);
	    taichungCmbBox.setForeground(Color.black);
	    taichungCmbBox.setVisible(false);
	    taichungCmbBox.setFont(font1);
	    taichungCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(taichungCmbBox);
	    
	    changhuaCmbBox = new JComboBox(changhuaString);//���ƿ�
	    changhuaCmbBox.setBounds(155,100,85,35); 
	    changhuaCmbBox.setBackground(Color.lightGray);
	    changhuaCmbBox.setForeground(Color.black);
	    changhuaCmbBox.setVisible(false);
	    changhuaCmbBox.setFont(font1);
	    changhuaCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(changhuaCmbBox);
	    
	    nantouCmbBox = new JComboBox(nantouString);//�n�뿤
	    nantouCmbBox.setBounds(155,100,85,35); 
	    nantouCmbBox.setBackground(Color.lightGray);
	    nantouCmbBox.setForeground(Color.black);
	    nantouCmbBox.setVisible(false);
	    nantouCmbBox.setFont(font1);
	    nantouCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(nantouCmbBox);
	    
	    yunlinCmbBox = new JComboBox(yunlinString);//���L��
	    yunlinCmbBox.setBounds(155,100,85,35); 
	    yunlinCmbBox.setBackground(Color.lightGray);
	    yunlinCmbBox.setForeground(Color.black);
	    yunlinCmbBox.setVisible(false);
	    yunlinCmbBox.setFont(font1);
	    yunlinCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(yunlinCmbBox);
	    
	    chiayiCityCmbBox = new JComboBox(chiayiCityString);//�Ÿq��
	    chiayiCityCmbBox.setBounds(155,100,85,35); 
	    chiayiCityCmbBox.setBackground(Color.lightGray);
	    chiayiCityCmbBox.setForeground(Color.black);
	    chiayiCityCmbBox.setVisible(false);
	    chiayiCityCmbBox.setFont(font1);
	    chiayiCityCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(chiayiCityCmbBox);
	    
	    chiayiCountyCmbBox = new JComboBox(chiayiCountyString);//�Ÿq��
	    chiayiCountyCmbBox.setBounds(155,100,85,35); 
	    chiayiCountyCmbBox.setBackground(Color.lightGray);
	    chiayiCountyCmbBox.setForeground(Color.black);
	    chiayiCountyCmbBox.setVisible(false);
	    chiayiCountyCmbBox.setFont(font1);
	    chiayiCountyCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(chiayiCountyCmbBox);
	    
	    tainanCmbBox = new JComboBox(tainanString);//�O�n��
	    tainanCmbBox.setBounds(155,100,85,35); 
	    tainanCmbBox.setBackground(Color.lightGray);
	    tainanCmbBox.setForeground(Color.black);
	    tainanCmbBox.setVisible(false);
	    tainanCmbBox.setFont(font1);
	    tainanCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(tainanCmbBox);
	    
	    kaohsiungCmbBox = new JComboBox(kaohsiungString);//������
	    kaohsiungCmbBox.setBounds(155,100,85,35); 
	    kaohsiungCmbBox.setBackground(Color.lightGray);
	    kaohsiungCmbBox.setForeground(Color.black);
	    kaohsiungCmbBox.setVisible(false);
	    kaohsiungCmbBox.setFont(font1);
	    kaohsiungCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(kaohsiungCmbBox);
	    
	    pingtungCmbBox = new JComboBox(pingtungString);//�̪F��
	    pingtungCmbBox.setBounds(155,100,85,35); 
	    pingtungCmbBox.setBackground(Color.lightGray);
	    pingtungCmbBox.setForeground(Color.black);
	    pingtungCmbBox.setVisible(false);
	    pingtungCmbBox.setFont(font1);
	    pingtungCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(pingtungCmbBox);
	    
	    taitungCmbBox = new JComboBox(taitungString);//�O�F��
	    taitungCmbBox.setBounds(155,100,85,35); 
	    taitungCmbBox.setBackground(Color.lightGray);
	    taitungCmbBox.setForeground(Color.black);
	    taitungCmbBox.setVisible(false);
	    taitungCmbBox.setFont(font1);
	    taitungCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(taitungCmbBox);
	    
	    hualienCmbBox = new JComboBox(hualienString);//�Ὤ��
	    hualienCmbBox.setBounds(155,100,85,35); 
	    hualienCmbBox.setBackground(Color.lightGray);
	    hualienCmbBox.setForeground(Color.black);
	    hualienCmbBox.setVisible(false);
	    hualienCmbBox.setFont(font1);
	    hualienCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(hualienCmbBox);
	    
	    yilanCmbBox = new JComboBox(yilanString);//�y����
	    yilanCmbBox.setBounds(155,100,85,35); 
	    yilanCmbBox.setBackground(Color.lightGray);
	    yilanCmbBox.setForeground(Color.black);
	    yilanCmbBox.setVisible(false);
	    yilanCmbBox.setFont(font1);
	    yilanCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(yilanCmbBox);
	    
	    penghuCmbBox = new JComboBox(penghuString);//���
	    penghuCmbBox.setBounds(155,100,85,35); 
	    penghuCmbBox.setBackground(Color.lightGray);
	    penghuCmbBox.setForeground(Color.black);
	    penghuCmbBox.setVisible(false);
	    penghuCmbBox.setFont(font1);
	    penghuCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(penghuCmbBox);
	    
	    kinmenCmbBox = new JComboBox(kinmenString);//������
	    kinmenCmbBox.setBounds(155,100,85,35); 
	    kinmenCmbBox.setBackground(Color.lightGray);
	    kinmenCmbBox.setForeground(Color.black);
	    kinmenCmbBox.setVisible(false);
	    kinmenCmbBox.setFont(font1);
	    kinmenCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(kinmenCmbBox);
	    
	    lienchiangCmbBox = new JComboBox(lienchiangString);//�s����
	    lienchiangCmbBox.setBounds(155,100,85,35); 
	    lienchiangCmbBox.setBackground(Color.lightGray);
	    lienchiangCmbBox.setForeground(Color.black);
	    lienchiangCmbBox.setVisible(false);
	    lienchiangCmbBox.setFont(font1);
	    lienchiangCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(lienchiangCmbBox);
		
		f.setTitle("�v�t�A��");
		f.setBounds(330,320,530,260);
		f.setLayout(null);
		f.setVisible(false);
		f.setResizable(false);
	}
	
	private void reset() {//���m
		customer = "";
	    contact ="";
		road = "";
		street = "";
		sec = "";
		lane = "";
		alley = "";
		number = "";
		floor = ""; 
		num = "";
	}
	
	private void initialize() {//��l��
		taipeiCmbBox.setVisible(false);
		newtaipeiCmbBox.setVisible(false);
		keelungCmbBox.setVisible(false);
		taoyuanCmbBox.setVisible(false);
		hsinchuCityCmbBox.setVisible(false);
		hsinchuCountyCmbBox.setVisible(false);
		miaoliCmbBox.setVisible(false);
		taichungCmbBox.setVisible(false);
		changhuaCmbBox.setVisible(false);
		nantouCmbBox.setVisible(false);
		yunlinCmbBox.setVisible(false);
		chiayiCityCmbBox.setVisible(false);
		chiayiCountyCmbBox.setVisible(false);
		tainanCmbBox.setVisible(false);
		kaohsiungCmbBox.setVisible(false);
		pingtungCmbBox.setVisible(false);
		taitungCmbBox.setVisible(false);
		hualienCmbBox.setVisible(false);
		yilanCmbBox.setVisible(false);
		penghuCmbBox.setVisible(false);
		kinmenCmbBox.setVisible(false);
		lienchiangCmbBox.setVisible(false);
		roadTxtFd.setText("");
		streetTxtFd.setText("");
		secTxtFd.setText("");
		laneTxtFd.setText("");
		alleyTxtFd.setText("");
		numberTxtFd.setText("");
		floorTxtFd.setText("");
		numTxtFd.setText("");
	}
	
	public String[] returnDeliveryInfo() {//�^���U�ȩm�W
		String[] deliveryInfo = {customer,contact,address};
		return deliveryInfo;
	}
	
	public int returnDeliveryState() {//�^�Ǧ��L�v�t
		return deliveryState;
	}
		
	public ActionListener ProcessRegionCmbBox = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == rocRegionCmbBox) {
				initialize();//�I�s��l�ƪ���k
				region = (String)rocRegionCmbBox.getSelectedItem();
				switch(region) {
					case "�O�_��":taipeiCmbBox.setVisible(true);
								local = "������";
					break;
					case "�s�_��":newtaipeiCmbBox.setVisible(true);
								local = "�O����";
					break;
					case "�򶩥�":keelungCmbBox.setVisible(true);
								local = "���R��";
					break;
					case "��饫":taoyuanCmbBox.setVisible(true);
								local = "���c��";
					break;
					case "�s�˥�":hsinchuCityCmbBox.setVisible(true);
								local = "�F��";
					break;
					case "�s�˿�":hsinchuCountyCmbBox.setVisible(true);
								local = "�˥_��";
					break;
					case "�]�߿�":miaoliCmbBox.setVisible(true);
								local = "�˫n��";
					break;
					case "�O����":taichungCmbBox.setVisible(true);
								local = "����";
					break;
					case "���ƿ�":changhuaCmbBox.setVisible(true);
								local = "���ƥ�";
					break;
					case "�n�뿤":nantouCmbBox.setVisible(true);
								local = "�n�륫";
					break;
					case "���L��":yunlinCmbBox.setVisible(true);
								local = "��n��";
					break;
					case "�Ÿq��":chiayiCityCmbBox.setVisible(true);
								local = "�F��";
					break;
					case "�Ÿq��":chiayiCountyCmbBox.setVisible(true);
								local = "�f���m";
					break;
					case "�O�n��":tainanCmbBox.setVisible(true);
								local = "�����";
					break;
					case "������":kaohsiungCmbBox.setVisible(true);
								local = "�s����";
					break;
					case "�̪F��":pingtungCmbBox.setVisible(true);
								local = "�̪F��";
					break;
					case "�O�F��":taitungCmbBox.setVisible(true);
								local = "�O�F��";
					break;
					case "�Ὤ��":hualienCmbBox.setVisible(true);
								local = "�Ὤ��";
					break;
					case "�y����":yilanCmbBox.setVisible(true);
								local = "�y����";
					break;
					case "*���":penghuCmbBox.setVisible(true);
								local = "������";
					break;
					case "*������":kinmenCmbBox.setVisible(true);
								local = "���F��";
					break;
					case "*�s����":lienchiangCmbBox.setVisible(true);
								local = "�n��m";
					break;
				}
			}
			if(e.getSource() == taipeiCmbBox)
				local = (String)taipeiCmbBox.getSelectedItem();
			if(e.getSource() == newtaipeiCmbBox)
				local = (String)newtaipeiCmbBox.getSelectedItem();
			if(e.getSource() == keelungCmbBox)
				local = (String)keelungCmbBox.getSelectedItem();
			if(e.getSource() == taoyuanCmbBox)
				local = (String)taoyuanCmbBox.getSelectedItem();
			if(e.getSource() == hsinchuCityCmbBox)
				local = (String)hsinchuCityCmbBox.getSelectedItem();
			if(e.getSource() == hsinchuCountyCmbBox)
				local = (String)hsinchuCountyCmbBox.getSelectedItem();
			if(e.getSource() == miaoliCmbBox)
				local = (String)miaoliCmbBox.getSelectedItem();
			if(e.getSource() == taichungCmbBox)
				local = (String)taichungCmbBox.getSelectedItem();
			if(e.getSource() == changhuaCmbBox)
				local = (String)changhuaCmbBox.getSelectedItem();
			if(e.getSource() == nantouCmbBox)
				local = (String)nantouCmbBox.getSelectedItem();
			if(e.getSource() == yunlinCmbBox)
				local = (String)yunlinCmbBox.getSelectedItem();
			if(e.getSource() == chiayiCityCmbBox)
				local = (String)chiayiCityCmbBox.getSelectedItem();
			if(e.getSource() == chiayiCountyCmbBox)
				local = (String)chiayiCountyCmbBox.getSelectedItem();
			if(e.getSource() == tainanCmbBox)
				local = (String)tainanCmbBox.getSelectedItem();
			if(e.getSource() == kaohsiungCmbBox)
				local = (String)kaohsiungCmbBox.getSelectedItem();
			if(e.getSource() == pingtungCmbBox)
				local = (String)pingtungCmbBox.getSelectedItem();
			if(e.getSource() == taitungCmbBox)
				local = (String)taitungCmbBox.getSelectedItem();
			if(e.getSource() == hualienCmbBox)
				local = (String)hualienCmbBox.getSelectedItem();
			if(e.getSource() == yilanCmbBox)
				local = (String)yilanCmbBox.getSelectedItem();
			if(e.getSource() == penghuCmbBox)
				local = (String)penghuCmbBox.getSelectedItem();
			if(e.getSource() == kinmenCmbBox)
				local = (String)kinmenCmbBox.getSelectedItem();
			if(e.getSource() == lienchiangCmbBox)
				local = (String)lienchiangCmbBox.getSelectedItem();
		}
	};
	
	public ActionListener ProcessAddBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == addBtn) {
				reset();
				customer = customerTxtFd.getText();
				contact = contactTxtFd.getText();
				if(!roadTxtFd.getText().equals(""))
					road = roadTxtFd.getText()+"��";
				if(!streetTxtFd.getText().equals(""))
					street = streetTxtFd.getText()+"��";
				if(!secTxtFd.getText().equals(""))
					sec = secTxtFd.getText()+"�q";
				if(!laneTxtFd.getText().equals(""))
					lane = laneTxtFd.getText()+"��";
				if(!alleyTxtFd.getText().equals(""))
					alley = alleyTxtFd.getText()+"��";
				if(!numberTxtFd.getText().equals(""))
					number = numberTxtFd.getText()+"��";
				if(!floorTxtFd.getText().equals(""))
					floor = floorTxtFd.getText()+"��";
				if(!numTxtFd.getText().equals(""))
					num = "��"+numTxtFd.getText(); 
				if((!road.equals("") || !street.equals("") || !lane.equals("")) &&! number.equals("") && !customer.equals("") && !contact.equals("")) {//�]�w��T�̤֭n����(��)�θ�,�B�n���U�ȩm�W
					if(!road.equals("") && !street.equals("")) {//�p�G�����P�ɶ�g,��ܿ��~�T��
						JOptionPane.showMessageDialog(null,"��J�a�}�榡�����T�A�бz�A���ˬd�I","���~�I",JOptionPane.ERROR_MESSAGE);
					}
					else {
						address = region+local+road+street+sec+lane+alley+number+floor+num ;
						int ask = JOptionPane.showConfirmDialog(null,"�T�{�v�t��T\n�U�ȩm�W�G"+customer+"\n�s���q�ܡG"+contact+"\n�a�}�G"+address,"���ɽT�{",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(ask == JOptionPane.YES_OPTION) {
							f.setVisible(false);
							deliveryState = 1;
						}
					}
				} 
				else {
					JOptionPane.showMessageDialog(null,"��J��T������A�ж�g����I","���~�I",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	};
}