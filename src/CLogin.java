import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CLogin {
	JFrame f = new JFrame();
    JPanel p1 = new JPanel();
    ImageIcon icon = new ImageIcon("阿里山.png");
    JLabel imageLab = new JLabel(icon);
    JLabel logoLab = new JLabel("系統登入畫面");
    JLabel acntLab = new JLabel("使用者：");
    JLabel pwdLab = new JLabel("密  碼：");
    JTextField acntTxtFd = new JTextField("");
    JPasswordField pwdTxtFd = new JPasswordField("");
    JButton LoginBtn = new JButton("登入");
    JButton cancelBtn = new JButton("取消");
    Color color1 = new Color(205,186,150);
    Font font1 = new Font("標楷體", Font.BOLD,40);
    Font font2 = new Font("標楷體",Font.BOLD,24);
    Font font3 = new Font("標楷體",Font.BOLD,20);
    
    String[][] UsrDataString = {{"000","000"}};
    
    CLogin(){
    	p1.setBounds(0,0,500,340);
        p1.setLayout(null);
        f.add(p1);
        
        imageLab.setBounds(0,0,500,340);
        imageLab.setLayout(null);
        p1.add(imageLab);

        logoLab.setBounds(120,40,300,40);
        logoLab.setFont(font1); 
        imageLab.add(logoLab);

        acntLab.setBounds(70,110,105,40);
        acntLab.setFont(font2); 
        imageLab.add(acntLab);
        
        acntTxtFd.setBounds(175,110,220,40);
        acntTxtFd.setFont(font2);
        acntTxtFd.setBorder(BorderFactory.createLoweredBevelBorder());
        imageLab.add(acntTxtFd);

        pwdLab.setBounds(70,170,105,40);
        pwdLab.setFont(font2);
        imageLab.add(pwdLab);
        
        pwdTxtFd.setBounds(175,170,220,40);
        pwdTxtFd.setFont(new Font("微軟正黑體",Font.BOLD,24));
        pwdTxtFd.setBorder(BorderFactory.createLoweredBevelBorder());
        imageLab.add(pwdTxtFd);

        LoginBtn.setBounds(120,240,100,45);
        LoginBtn.setBackground(color1);
        LoginBtn.setFont(font2);
        LoginBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        imageLab.add(LoginBtn);
        
        cancelBtn.setBounds(270,240,100,45);
        cancelBtn.setBackground(color1);
        cancelBtn.setFont(font2);
        cancelBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        cancelBtn.addActionListener(ProcessClearAcntPwd);
        imageLab.add(cancelBtn);
        
        f.setTitle("POS系統登入畫面");
        f.setLayout(null);
        f.setBounds(200,200,500,360);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    void clearAcntPwd(){
    	acntTxtFd.setText("");
        pwdTxtFd.setText("");
    }
    
    public ActionListener ProcessClearAcntPwd = new ActionListener(){
        public void actionPerformed(ActionEvent e){
             if(e.getSource() ==  cancelBtn) {  
            	 clearAcntPwd();//呼叫方法clearAcntPwd去執行清空帳號密碼欄
             }
        }    
    };
}