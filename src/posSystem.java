import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class posSystem {
	public static void main(String[] args) {
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("�s�ө���",Font.BOLD,16)));//�]�w�T��������r�j�p
		CDM_dbma mydbma = new CDM_dbma();//��Ʈw
		//mydbma.createDB();
		mydbma.createTB_tradingRecord();
		mydbma.createTB_productInfo();
		mydbma.createTB_deliveryInfo();
		mydbma.createTB_staffInfo();
		Product myProduct = new Product();
		myProduct.saveProductInfo();
		CPos myPos = new CPos();
	}
}