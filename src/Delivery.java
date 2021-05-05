import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Delivery {
	JFrame f = new JFrame();
	JPanel p1 = new JPanel();
	
	JLabel customerLab = new JLabel("顧客姓名：");
	JLabel contactLab = new JLabel("連絡電話：");
	JLabel addressLab = new JLabel("地址：");
	JLabel rocRegionLab = new JLabel("縣/市");
	JLabel localRegionLab = new JLabel("鄉/鎮/市/區");
	JLabel roadLab = new JLabel("路");
	JLabel streetLab = new JLabel("街");
	JLabel secLab = new JLabel("段");
	JLabel laneLab = new JLabel("巷");
	JLabel alleyLab = new JLabel("弄");
	JLabel numberLab = new JLabel("號");
	JLabel floorLab = new JLabel("樓  之");
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
	JButton addBtn = new JButton("確定");
	
	JComboBox<?> rocRegionCmbBox;
    String[] rocRegionString = {"臺北市","新北市","基隆市","桃園市","新竹市","新竹縣","苗栗縣","臺中市","彰化縣","南投縣","雲林縣","嘉義市","嘉義縣","臺南市","高雄市","屏東縣","臺東縣","花蓮縣","宜蘭縣","*澎湖縣","*金門縣","*連江縣"};
    JComboBox taipeiCmbBox;
    String[] taipeiString = {"中正區","大同區","中山區","松山區","大安區","萬華區","信義區","士林區","北投區","內湖區","南港區","文山區"}; 
    JComboBox newtaipeiCmbBox;
    String[] newtaipeiString = {"板橋區","三重區","新莊區","永和區","中和區","土城區","新店區","三峽區","樹林區","鶯歌區","泰山區","林口區","蘆洲區","五股區","八里區",
    							"淡水區","三芝區","石門區","萬里區","金山區","汐止區","深坑區","石碇區","瑞芳區","平溪區","雙溪區","貢寮區","坪林區","烏來區"};
    JComboBox keelungCmbBox;
    String[] keelungString = {"仁愛區","信義區","中正區","中山區","安樂區","暖暖區","七堵區"};
    JComboBox taoyuanCmbBox;
    String[] taoyuanString = {"中壢區","平鎮區","龍潭區","楊梅區","新屋區","觀音區","桃園區","龜山區","八德區","大溪區","復興區","大園區","蘆竹區"};
    JComboBox hsinchuCityCmbBox;
    String[] hsinchuCityString = {"東區","北區","香山區"};
    JComboBox hsinchuCountyCmbBox;
    String[] hsinchuCountyString = {"竹北市","湖口鄉","新豐鄉","新埔鎮","關西鎮","芎林鄉","寶山鄉","竹東鎮","五峰鄉","橫山鄉","尖石鄉","北埔鄉","峨眉鄉"};
    JComboBox miaoliCmbBox;
    String[] miaoliString = {"竹南鎮","頭份市","三灣鄉","南庄鄉","獅潭鄉","後龍鎮","通霄鎮","苑裡鎮","苗栗市","造橋鄉","頭屋鄉","公館鄉","大湖鄉","泰安鄉","銅鑼鄉","三義鄉","西湖鄉","卓蘭鎮"};
    JComboBox taichungCmbBox;
    String[] taichungString = {"中區","東區","南區","西區","北區","北屯區","西屯區","南屯區","太平區","大里區","霧峰區","烏日區","豐原區","后里區","石岡區",
    						   "東勢區","和平區","新社區","潭子區","大雅區","神岡區","大肚區","沙鹿區","龍井區","梧棲區","清水區","大甲區","外埔區","大安區"};
    JComboBox changhuaCmbBox;
    String[] changhuaString = {"彰化市","芬園鄉","花壇鄉","秀水鄉","鹿港鎮","福興鄉","線西鄉","和美鎮","伸港鄉","員林市","社頭鄉","永靖鄉","埔心鄉",
    						   "溪湖鎮","大村鄉","埔鹽鄉","田中鎮","北斗鎮","田尾鄉","埤頭鄉","溪州鄉","竹塘鄉","二林鎮","大城鄉","芳苑鄉","二水鄉"};
    JComboBox nantouCmbBox;
    String[] nantouString = {"南投市","中寮鄉","草屯鎮","國姓鄉","埔里鎮","仁愛鄉","名間鄉","集集鎮","水里鄉","魚池鄉","信義鄉","竹山鎮","鹿谷鄉"};
    JComboBox yunlinCmbBox;
    String[] yunlinString = {"斗南鎮","大埤鄉","虎尾鎮","土庫鎮","褒忠鄉","東勢鄉","臺西鄉","崙背鄉","麥寮鄉","斗六市","林內鄉","古坑鄉","莿桐鄉","西螺鎮","二崙鄉","北港鎮","水林鄉","口湖鄉","四湖鄉","元長鄉"};
    JComboBox chiayiCityCmbBox;
    String[] chiayiCityString = {"東區","西區"};
    JComboBox chiayiCountyCmbBox;
    String[] chiayiCountyString = {"番路鄉","梅山鄉","竹崎鄉","阿里山鄉","中埔鄉","大埔鄉","水上鄉","鹿草鄉","太保市","朴子市","東石鄉","六腳鄉","新港鄉","民雄鄉","大林鎮","溪口鄉","義竹鄉","布袋鎮"};
    JComboBox tainanCmbBox;
    String[] tainanString = {"中西區","東區","南區","北區","安平區","安南區","永康區","歸仁區","新化區","左鎮區","玉井區","楠西區","南化區","仁德區","關廟區","龍崎區","官田區","麻豆區","佳里區",
    						 "西港區","七股區","將軍區","學甲區","北門區","新營區","後壁區","白河區","東山區","六甲區","下營區","柳營區","鹽水區","善化區","大內區","山上區","新市區","安定區"};
    JComboBox kaohsiungCmbBox;
    String[] kaohsiungString = {"新興區","前金區","苓雅區","鹽埕區","鼓山區","旗津區","前鎮區","三民區","楠梓區","小港區","左營區","鳳山區","大寮區","林園區","鳥松區","大樹區","仁武區","大社區","岡山區",
    							"路竹區","阿蓮區","田寮區","燕巢區","橋頭區","梓官區","彌陀區","永安區","湖內區","旗山區","美濃區","六龜區","內門區","杉林區","甲仙區","桃源區","那瑪夏區","茂林區","茄萣區"};
    JComboBox pingtungCmbBox;
    String[] pingtungString = {"屏東市","九如鄉","里港鄉","高樹鄉","鹽埔鄉","長治鄉","麟洛鄉","內埔鄉","竹田鄉","萬丹鄉","潮州鎮","萬巒鄉","三地門鄉","霧台鄉","瑪家鄉","泰武鄉","來義鄉",
    						   "崁頂鄉","新埤鄉","南州鄉","林邊鄉","東港鎮","琉球鄉","佳冬鄉","新園鄉","枋寮鄉","枋山鄉","春日鄉","獅子鄉","車城鄉","牡丹鄉","恆春鎮","滿州鄉"};
    JComboBox taitungCmbBox;
    String[] taitungString = {"臺東市","綠島鄉","蘭嶼鄉","延平鄉","卑南鄉","鹿野鄉","關山鎮","海端鄉","池上鄉","東河鄉","成功鎮","長濱鄉","太麻里鄉","金峰鄉","大武鄉","達仁鄉"};
    JComboBox hualienCmbBox;
    String[] hualienString = {"花蓮市","新城鄉","秀林鄉","吉安鄉","壽豐鄉","鳳林鎮","光復鄉","豐濱鄉","瑞穗鄉","萬榮鄉","玉里鎮","卓溪鄉","富里鄉"};
    JComboBox yilanCmbBox;
    String[] yilanString = {"宜蘭市","頭城鎮","礁溪鄉","壯圍鄉","員山鄉","羅東鎮","三星鄉","大同鄉","五結鄉","冬山鄉","蘇澳鎮","南澳鄉","釣魚臺"};
    JComboBox penghuCmbBox;
    String[] penghuString = {"馬公市","西嶼鄉","望安鄉","七美鄉","白沙鄉","湖西鄉"};
    JComboBox kinmenCmbBox;
    String[] kinmenString = {"金沙鎮","金湖鎮","金寧鄉","金城鎮","烈嶼鄉","烏坵鄉"};
    JComboBox lienchiangCmbBox;
    String[] lienchiangString = {"南竿鄉","北竿鄉","莒光鄉","東引鄉"};
    
    Font font1 = new Font("微軟正黑體",Font.BOLD,14);
    Font font2 = new Font("微軟正黑體",Font.PLAIN,16);
    String customer = "";
    String contact ="";
    String region = "臺北市";
    String local = "中正區";
	String address = "";
	String road = "", street = "", sec = "",lane = "",alley = "", number = "",floor = "", num = "";
	int deliveryState = 0;//有無宅配,無0,有1
    
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
		
		rocRegionLab.setBounds(65,80,85,20);//縣/市
		rocRegionLab.setFont(font1);
		p1.add(rocRegionLab);
		
		localRegionLab.setBounds(155,80,85,20);//鄉/鎮/市/區
		localRegionLab.setFont(font1);
		p1.add(localRegionLab);
		
		roadLab.setBounds(335,100,15,35);//路
		roadLab.setFont(font1);
		p1.add(roadLab);
		
		streetLab.setBounds(445,100,15,35);//街
		streetLab.setFont(font1);
		p1.add(streetLab);
		
		secLab.setBounds(495,100,15,35);//段
		secLab.setFont(font1);
		p1.add(secLab);
		
		laneLab.setBounds(115,155,15,35);//巷
		laneLab.setFont(font1);
		p1.add(laneLab);
		
		alleyLab.setBounds(185,155,15,35);//弄
		alleyLab.setFont(font1);
		p1.add(alleyLab);
		
		numberLab.setBounds(255,155,15,35);//號
		numberLab.setFont(font1);
		p1.add(numberLab);
		
		floorLab.setBounds(310,155,40,35);//樓
		floorLab.setFont(font1);
		p1.add(floorLab);
		
		customerTxtFd.setBounds(100,20,140,35);//顧客姓名
		customerTxtFd.setFont(font2);
		p1.add(customerTxtFd);
		
		contactTxtFd.setBounds(350,20,140,35);//連絡電話
		contactTxtFd.setFont(font2);
		p1.add(contactTxtFd);
		
		roadTxtFd.setBounds(245,100,90,35);//路
		roadTxtFd.setFont(font1);
		p1.add(roadTxtFd);
		
		streetTxtFd.setBounds(355,100,90,35);//街
		streetTxtFd.setFont(font1);
		p1.add(streetTxtFd);
		
		secTxtFd.setBounds(465,100,30,35);//段
		secTxtFd.setFont(font1);
		p1.add(secTxtFd);
		
		laneTxtFd.setBounds(65,155,50,35);//巷
		laneTxtFd.setFont(font1);
		p1.add(laneTxtFd);
		
		alleyTxtFd.setBounds(135,155,50,35);//弄
		alleyTxtFd.setFont(font1);
		p1.add(alleyTxtFd);
		
		numberTxtFd.setBounds(205,155,50,35);//號
		numberTxtFd.setFont(font1);
		p1.add(numberTxtFd);
		
		floorTxtFd.setBounds(275,155,35,35);//樓
		floorTxtFd.setFont(font1);
		p1.add(floorTxtFd);
		
		numTxtFd.setBounds(350,155,35,35);//之...
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
	    
	    taipeiCmbBox = new JComboBox(taipeiString);//臺北市
	    taipeiCmbBox.setBounds(155,100,85,35); 
	    taipeiCmbBox.setBackground(Color.lightGray);
	    taipeiCmbBox.setForeground(Color.black);
	    taipeiCmbBox.setVisible(true);
	    taipeiCmbBox.setFont(font1);
	    taipeiCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(taipeiCmbBox);
	    
	    newtaipeiCmbBox = new JComboBox(newtaipeiString);//新北市
	    newtaipeiCmbBox.setBounds(155,100,85,35); 
	    newtaipeiCmbBox.setBackground(Color.lightGray);
	    newtaipeiCmbBox.setForeground(Color.black);
	    newtaipeiCmbBox.setVisible(false);
	    newtaipeiCmbBox.setFont(font1);
	    newtaipeiCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(newtaipeiCmbBox);
	    
	    keelungCmbBox = new JComboBox(keelungString);//基隆市
	    keelungCmbBox.setBounds(155,100,85,35); 
	    keelungCmbBox.setBackground(Color.lightGray);
	    keelungCmbBox.setForeground(Color.black);
	    keelungCmbBox.setVisible(false);
	    keelungCmbBox.setFont(font1);
	    keelungCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(keelungCmbBox);
	    
	    taoyuanCmbBox = new JComboBox(taoyuanString);//桃園市
	    taoyuanCmbBox.setBounds(155,100,85,35); 
	    taoyuanCmbBox.setBackground(Color.lightGray);
	    taoyuanCmbBox.setForeground(Color.black);
	    taoyuanCmbBox.setVisible(false);
	    taoyuanCmbBox.setFont(font1);
	    taoyuanCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(taoyuanCmbBox);
	    
	    hsinchuCityCmbBox = new JComboBox(hsinchuCityString);//新竹市
	    hsinchuCityCmbBox.setBounds(155,100,85,35); 
	    hsinchuCityCmbBox.setBackground(Color.lightGray);
	    hsinchuCityCmbBox.setForeground(Color.black);
	    hsinchuCityCmbBox.setVisible(false);
	    hsinchuCityCmbBox.setFont(font1);
	    hsinchuCityCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(hsinchuCityCmbBox);
	    
	    hsinchuCountyCmbBox = new JComboBox(hsinchuCountyString);//新竹縣
	    hsinchuCountyCmbBox.setBounds(155,100,85,35); 
	    hsinchuCountyCmbBox.setBackground(Color.lightGray);
	    hsinchuCountyCmbBox.setForeground(Color.black);
	    hsinchuCountyCmbBox.setVisible(false);
	    hsinchuCountyCmbBox.setFont(font1);
	    hsinchuCountyCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(hsinchuCountyCmbBox);
	    
	    miaoliCmbBox = new JComboBox(miaoliString);//苗栗縣
	    miaoliCmbBox.setBounds(155,100,85,35); 
	    miaoliCmbBox.setBackground(Color.lightGray);
	    miaoliCmbBox.setForeground(Color.black);
	    miaoliCmbBox.setVisible(false);
	    miaoliCmbBox.setFont(font1);
	    miaoliCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(miaoliCmbBox);
	    
	    taichungCmbBox = new JComboBox(taichungString);//臺中市
	    taichungCmbBox.setBounds(155,100,85,35); 
	    taichungCmbBox.setBackground(Color.lightGray);
	    taichungCmbBox.setForeground(Color.black);
	    taichungCmbBox.setVisible(false);
	    taichungCmbBox.setFont(font1);
	    taichungCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(taichungCmbBox);
	    
	    changhuaCmbBox = new JComboBox(changhuaString);//彰化縣
	    changhuaCmbBox.setBounds(155,100,85,35); 
	    changhuaCmbBox.setBackground(Color.lightGray);
	    changhuaCmbBox.setForeground(Color.black);
	    changhuaCmbBox.setVisible(false);
	    changhuaCmbBox.setFont(font1);
	    changhuaCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(changhuaCmbBox);
	    
	    nantouCmbBox = new JComboBox(nantouString);//南投縣
	    nantouCmbBox.setBounds(155,100,85,35); 
	    nantouCmbBox.setBackground(Color.lightGray);
	    nantouCmbBox.setForeground(Color.black);
	    nantouCmbBox.setVisible(false);
	    nantouCmbBox.setFont(font1);
	    nantouCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(nantouCmbBox);
	    
	    yunlinCmbBox = new JComboBox(yunlinString);//雲林縣
	    yunlinCmbBox.setBounds(155,100,85,35); 
	    yunlinCmbBox.setBackground(Color.lightGray);
	    yunlinCmbBox.setForeground(Color.black);
	    yunlinCmbBox.setVisible(false);
	    yunlinCmbBox.setFont(font1);
	    yunlinCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(yunlinCmbBox);
	    
	    chiayiCityCmbBox = new JComboBox(chiayiCityString);//嘉義市
	    chiayiCityCmbBox.setBounds(155,100,85,35); 
	    chiayiCityCmbBox.setBackground(Color.lightGray);
	    chiayiCityCmbBox.setForeground(Color.black);
	    chiayiCityCmbBox.setVisible(false);
	    chiayiCityCmbBox.setFont(font1);
	    chiayiCityCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(chiayiCityCmbBox);
	    
	    chiayiCountyCmbBox = new JComboBox(chiayiCountyString);//嘉義縣
	    chiayiCountyCmbBox.setBounds(155,100,85,35); 
	    chiayiCountyCmbBox.setBackground(Color.lightGray);
	    chiayiCountyCmbBox.setForeground(Color.black);
	    chiayiCountyCmbBox.setVisible(false);
	    chiayiCountyCmbBox.setFont(font1);
	    chiayiCountyCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(chiayiCountyCmbBox);
	    
	    tainanCmbBox = new JComboBox(tainanString);//臺南市
	    tainanCmbBox.setBounds(155,100,85,35); 
	    tainanCmbBox.setBackground(Color.lightGray);
	    tainanCmbBox.setForeground(Color.black);
	    tainanCmbBox.setVisible(false);
	    tainanCmbBox.setFont(font1);
	    tainanCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(tainanCmbBox);
	    
	    kaohsiungCmbBox = new JComboBox(kaohsiungString);//高雄市
	    kaohsiungCmbBox.setBounds(155,100,85,35); 
	    kaohsiungCmbBox.setBackground(Color.lightGray);
	    kaohsiungCmbBox.setForeground(Color.black);
	    kaohsiungCmbBox.setVisible(false);
	    kaohsiungCmbBox.setFont(font1);
	    kaohsiungCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(kaohsiungCmbBox);
	    
	    pingtungCmbBox = new JComboBox(pingtungString);//屏東縣
	    pingtungCmbBox.setBounds(155,100,85,35); 
	    pingtungCmbBox.setBackground(Color.lightGray);
	    pingtungCmbBox.setForeground(Color.black);
	    pingtungCmbBox.setVisible(false);
	    pingtungCmbBox.setFont(font1);
	    pingtungCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(pingtungCmbBox);
	    
	    taitungCmbBox = new JComboBox(taitungString);//臺東縣
	    taitungCmbBox.setBounds(155,100,85,35); 
	    taitungCmbBox.setBackground(Color.lightGray);
	    taitungCmbBox.setForeground(Color.black);
	    taitungCmbBox.setVisible(false);
	    taitungCmbBox.setFont(font1);
	    taitungCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(taitungCmbBox);
	    
	    hualienCmbBox = new JComboBox(hualienString);//花蓮縣
	    hualienCmbBox.setBounds(155,100,85,35); 
	    hualienCmbBox.setBackground(Color.lightGray);
	    hualienCmbBox.setForeground(Color.black);
	    hualienCmbBox.setVisible(false);
	    hualienCmbBox.setFont(font1);
	    hualienCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(hualienCmbBox);
	    
	    yilanCmbBox = new JComboBox(yilanString);//宜蘭縣
	    yilanCmbBox.setBounds(155,100,85,35); 
	    yilanCmbBox.setBackground(Color.lightGray);
	    yilanCmbBox.setForeground(Color.black);
	    yilanCmbBox.setVisible(false);
	    yilanCmbBox.setFont(font1);
	    yilanCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(yilanCmbBox);
	    
	    penghuCmbBox = new JComboBox(penghuString);//澎湖縣
	    penghuCmbBox.setBounds(155,100,85,35); 
	    penghuCmbBox.setBackground(Color.lightGray);
	    penghuCmbBox.setForeground(Color.black);
	    penghuCmbBox.setVisible(false);
	    penghuCmbBox.setFont(font1);
	    penghuCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(penghuCmbBox);
	    
	    kinmenCmbBox = new JComboBox(kinmenString);//金門縣
	    kinmenCmbBox.setBounds(155,100,85,35); 
	    kinmenCmbBox.setBackground(Color.lightGray);
	    kinmenCmbBox.setForeground(Color.black);
	    kinmenCmbBox.setVisible(false);
	    kinmenCmbBox.setFont(font1);
	    kinmenCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(kinmenCmbBox);
	    
	    lienchiangCmbBox = new JComboBox(lienchiangString);//連江縣
	    lienchiangCmbBox.setBounds(155,100,85,35); 
	    lienchiangCmbBox.setBackground(Color.lightGray);
	    lienchiangCmbBox.setForeground(Color.black);
	    lienchiangCmbBox.setVisible(false);
	    lienchiangCmbBox.setFont(font1);
	    lienchiangCmbBox.addActionListener(ProcessRegionCmbBox);
	    p1.add(lienchiangCmbBox);
		
		f.setTitle("宅配服務");
		f.setBounds(330,320,530,260);
		f.setLayout(null);
		f.setVisible(false);
		f.setResizable(false);
	}
	
	private void reset() {//重置
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
	
	private void initialize() {//初始化
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
	
	public String[] returnDeliveryInfo() {//回傳顧客姓名
		String[] deliveryInfo = {customer,contact,address};
		return deliveryInfo;
	}
	
	public int returnDeliveryState() {//回傳有無宅配
		return deliveryState;
	}
		
	public ActionListener ProcessRegionCmbBox = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == rocRegionCmbBox) {
				initialize();//呼叫初始化的方法
				region = (String)rocRegionCmbBox.getSelectedItem();
				switch(region) {
					case "臺北市":taipeiCmbBox.setVisible(true);
								local = "中正區";
					break;
					case "新北市":newtaipeiCmbBox.setVisible(true);
								local = "板橋區";
					break;
					case "基隆市":keelungCmbBox.setVisible(true);
								local = "仁愛區";
					break;
					case "桃園市":taoyuanCmbBox.setVisible(true);
								local = "中壢區";
					break;
					case "新竹市":hsinchuCityCmbBox.setVisible(true);
								local = "東區";
					break;
					case "新竹縣":hsinchuCountyCmbBox.setVisible(true);
								local = "竹北市";
					break;
					case "苗栗縣":miaoliCmbBox.setVisible(true);
								local = "竹南鎮";
					break;
					case "臺中市":taichungCmbBox.setVisible(true);
								local = "中區";
					break;
					case "彰化縣":changhuaCmbBox.setVisible(true);
								local = "彰化市";
					break;
					case "南投縣":nantouCmbBox.setVisible(true);
								local = "南投市";
					break;
					case "雲林縣":yunlinCmbBox.setVisible(true);
								local = "斗南鎮";
					break;
					case "嘉義市":chiayiCityCmbBox.setVisible(true);
								local = "東區";
					break;
					case "嘉義縣":chiayiCountyCmbBox.setVisible(true);
								local = "番路鄉";
					break;
					case "臺南市":tainanCmbBox.setVisible(true);
								local = "中西區";
					break;
					case "高雄市":kaohsiungCmbBox.setVisible(true);
								local = "新興區";
					break;
					case "屏東縣":pingtungCmbBox.setVisible(true);
								local = "屏東市";
					break;
					case "臺東縣":taitungCmbBox.setVisible(true);
								local = "臺東市";
					break;
					case "花蓮縣":hualienCmbBox.setVisible(true);
								local = "花蓮市";
					break;
					case "宜蘭縣":yilanCmbBox.setVisible(true);
								local = "宜蘭市";
					break;
					case "*澎湖縣":penghuCmbBox.setVisible(true);
								local = "馬公市";
					break;
					case "*金門縣":kinmenCmbBox.setVisible(true);
								local = "金沙鎮";
					break;
					case "*連江縣":lienchiangCmbBox.setVisible(true);
								local = "南竿鄉";
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
					road = roadTxtFd.getText()+"路";
				if(!streetTxtFd.getText().equals(""))
					street = streetTxtFd.getText()+"街";
				if(!secTxtFd.getText().equals(""))
					sec = secTxtFd.getText()+"段";
				if(!laneTxtFd.getText().equals(""))
					lane = laneTxtFd.getText()+"巷";
				if(!alleyTxtFd.getText().equals(""))
					alley = alleyTxtFd.getText()+"弄";
				if(!numberTxtFd.getText().equals(""))
					number = numberTxtFd.getText()+"號";
				if(!floorTxtFd.getText().equals(""))
					floor = floorTxtFd.getText()+"樓";
				if(!numTxtFd.getText().equals(""))
					num = "之"+numTxtFd.getText(); 
				if((!road.equals("") || !street.equals("") || !lane.equals("")) &&! number.equals("") && !customer.equals("") && !contact.equals("")) {//設定資訊最少要有路(街)及號,且要有顧客姓名
					if(!road.equals("") && !street.equals("")) {//如果路跟街同時填寫,顯示錯誤訊息
						JOptionPane.showMessageDialog(null,"輸入地址格式不正確，請您再次檢查！","錯誤！",JOptionPane.ERROR_MESSAGE);
					}
					else {
						address = region+local+road+street+sec+lane+alley+number+floor+num ;
						int ask = JOptionPane.showConfirmDialog(null,"確認宅配資訊\n顧客姓名："+customer+"\n連絡電話："+contact+"\n地址："+address,"建檔確認",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(ask == JOptionPane.YES_OPTION) {
							f.setVisible(false);
							deliveryState = 1;
						}
					}
				} 
				else {
					JOptionPane.showMessageDialog(null,"輸入資訊不完整，請填寫完整！","錯誤！",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	};
}