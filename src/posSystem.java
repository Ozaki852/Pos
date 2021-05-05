import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class posSystem {
	public static void main(String[] args) {
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("新細明體",Font.BOLD,16)));//設定訊息視窗文字大小
		CDM_dbma mydbma = new CDM_dbma();//資料庫
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