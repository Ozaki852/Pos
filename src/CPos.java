import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

class CPos{
	CLogin myLogin = new CLogin();
	CHome myHome = new CHome();
	CUsrInt myUsrInt = new CUsrInt();
	CMgr myMgr = new CMgr();
	CPunch myPunch = new CPunch();
	staff mystaff = new staff();
	
	CPos(){
		myLogin.f.setVisible(true);
		myHome.f.setVisible(false);
		myUsrInt.f.setVisible(false);
		myPunch.setVisible(false);
		myLogin.LoginBtn.addActionListener(ProcessSwitchInterface);
		myHome.logoutBtn.addActionListener(ProcessSwitchInterface);
		myHome.usrIntBtn.addActionListener(ProcessSwitchInterface);
		myHome.mgrBtn.addActionListener(ProcessSwitchInterface);
		myHome.punchBtn.addActionListener(ProcessSwitchInterface);
		myUsrInt.homeBtn.addActionListener(ProcessSwitchInterface);
		myUsrInt.handoverBtn.addActionListener(ProcessSwitchInterface);
		myMgr.homeBtn.addActionListener(ProcessSwitchInterface);
		myPunch.homeBtn.addActionListener(ProcessSwitchInterface);
	}
	
	public ActionListener ProcessSwitchInterface = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == myLogin.LoginBtn) {
				for(int i=0; i<myLogin.UsrDataString.length; i++) {
					if(myLogin.acntTxtFd.getText().equals(myLogin.UsrDataString[i][0]) && myLogin.pwdTxtFd.getText().equals(myLogin.UsrDataString[i][1])){
						myLogin.f.setVisible(false);
						myHome.f.setVisible(true);
						myLogin.clearAcntPwd();
					}
					else {
						JOptionPane.showMessageDialog(null,"帳號或密碼輸入錯誤，請重新輸入。","錯誤！",JOptionPane.ERROR_MESSAGE);
						myLogin.clearAcntPwd();
					}
				}
			}
			
			if(e.getSource() == myHome.logoutBtn) {
				myHome.f.setVisible(false);
				myLogin.f.setVisible(true);
				myHome.acntTxtFd.setText("");
			}
			
			if(e.getSource() == myHome.usrIntBtn) {
				for(int i=0; i<mystaff.staffDataString.length; i++) {
					if(myHome.acntTxtFd.getText().equals(mystaff.staffDataString[i][1]) && myHome.pwdTxtFd.getText().equals(mystaff.staffDataString[i][2])){
						Date now = new Date();
						if(now.getHours()>=8 && now.getHours()<12)
							myUsrInt.shiftTxtFd.setText("早班");
						else if(now.getHours()>=12 && now.getHours()<18)
							myUsrInt.shiftTxtFd.setText("中班");
						else if(now.getHours()>=18 && now.getHours()<22)
							myUsrInt.shiftTxtFd.setText("晚班");
						else {
							myUsrInt.shiftTxtFd.setText("休息中");
						}
						myUsrInt.userTxtFd.setText(mystaff.staffDataString[i][1]+mystaff.staffDataString[i][0]);
						myHome.f.setVisible(false);
						myUsrInt.f.setVisible(true);
						myUsrInt.initializeCUsrInt();
					}
				}
			}
			
			if(e.getSource() == myUsrInt.homeBtn) {
				myHome.pwdTxtFd.setText("");//清空密碼
				myUsrInt.f.setVisible(false);
				myHome.f.setVisible(true);
			}
			
			if(e.getSource() == myUsrInt.handoverBtn) {
				myHome.acntTxtFd.setText("");//清空帳號
				myHome.pwdTxtFd.setText("");//清空密碼
				myUsrInt.f.setVisible(false);
				myHome.f.setVisible(true);
			}
			
			if(e.getSource() == myHome.mgrBtn) {
				for(int i=0; i<mystaff.mgrDataString.length; i++) {
					if(myHome.acntTxtFd.getText().equals(mystaff.mgrDataString[i][1]) && myHome.pwdTxtFd.getText().equals(mystaff.mgrDataString[i][2])){
						myHome.f.setVisible(false);
						myMgr.f.setVisible(true);
						myHome.acntTxtFd.setText("");//清空帳號
						myHome.pwdTxtFd.setText("");//清空密碼
					}
				}
			}
			
			if(e.getSource() == myMgr.homeBtn) {
				myMgr.f.setVisible(false);
				myHome.f.setVisible(true);
				myMgr.initializeCMgr();
			}
			
			if(e.getSource() == myHome.punchBtn) {
				myHome.f.setVisible(false);
				myPunch.setVisible(true);
			}
			
			if(e.getSource() == myPunch.homeBtn) {
				myPunch.setVisible(false);
				myHome.f.setVisible(true);
			}
		}
	};
}