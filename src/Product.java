class Product {
	CDM_dbma mydbma = new CDM_dbma();
	
    String[][] productNameA = {{"麥纖方塊酥","芝麻方塊酥","杏仁方塊酥"},
    						   {"黑糖方塊酥","咖啡方塊酥","茶梅方塊酥"},
    						   {"起司方塊酥","",""},
    						   {"","",""},
    						   {"","",""}};
    String[][] productPriceA = {{"60","60","60"},
			   					{"60","60","60"},
			   					{"60","",""},
			   					{"","",""},
			   					{"","",""}};
    String[][] productIDA = {{"JJ471888101","JJ471888102","JJ471888103"},
							 {"JJ471888104","JJ471888105","JJ471888106"},
							 {"JJ471888107","",""},
							 {"","",""},
							 {"","",""}};//條碼名規則國家+公司+商品 EX:471(中華民國)888(公司)101(商品)
    
    String[][] productNameB = {{"麥纖方塊酥","芝麻方塊酥","鹹蛋黃方塊酥"},
    						   {"黑糖方塊酥","海苔方塊酥",""},
    						   {"","",""},
    						   {"","",""},
    						   {"","",""}};
    String[][] productPriceB = {{"120","120","120"},
			   					{"120","120",""},
			   					{"","",""},
			   					{"","",""},
			   					{"","",""}};
    String[][] productIDB = {{"JJ471888201","JJ471888202","JJ471888203"},
							 {"JJ471888204","JJ471888205",""},
							 {"","",""},
							 {"","",""},
							 {"","",""}};
    
    String[][] productNameC = {{"麥纖方塊酥","芝麻方塊酥","杏仁方塊酥"},
    						   {"黑糖方塊酥","可可方塊酥","紫地瓜方塊酥"},
    						   {"","",""},
    						   {"","",""},
    						   {"","",""}};
    String[][] productPriceC = {{"160","160","160"},
			   					{"160","160","160"},
			   					{"","",""},
			   					{"","",""},
			   					{"","",""}};
    String[][] productIDC = {{"JJ471888301","JJ471888302","JJ471888303"},
			 				 {"JJ471888304","JJ471888305","JJ471888306"},
			 				 {"","",""},
			 				 {"","",""},
			 				 {"","",""}};
    
    String[][] productNameD = {{"巧克力方塊酥","紅椒方塊酥","抹茶方塊酥"},
    							{"黑芝麻餅","鹹蛋黃餅",""},
    							{"","",""},
    							{"","",""},
    							{"","",""}};
    String[][] productPriceD = {{"158","180","54"},
			   					{"135","135",""},
			   					{"","",""},
			   					{"","",""},
			   					{"","",""}};
    String[][] productIDD = {{"JJ471888001","JJ471888002","JJ471888003"},
			 				 {"JJ471888004","JJ471888005",""},
			 				 {"","",""},
			 				 {"","",""},
			 				 {"","",""}};
    
    public void saveProductInfo() {
    	for(int i=0; i<productNameA.length; i++) {
    		for(int j=0; j<productNameA[0].length; j++) {
    			if(productIDA[i][j].length()>0 && productNameA[i][j].length()>0)//有商品才傳
    				mydbma.insertRD_into_TB_productInfo(productIDA[i][j],"盒裝"+productNameA[i][j]);
    		}
    	}
    	for(int i=0; i<productNameB.length; i++) {
    		for(int j=0; j<productNameB[0].length; j++) {
    			if(productIDB[i][j].length()>0 && productNameB[i][j].length()>0)
    				mydbma.insertRD_into_TB_productInfo(productIDB[i][j],"罐裝"+productNameB[i][j]);
    		}
    	}
    	for(int i=0; i<productNameC.length; i++) {
    		for(int j=0; j<productNameC[0].length; j++) {
    			if(productIDC[i][j].length()>0 && productNameC[i][j].length()>0)
    				mydbma.insertRD_into_TB_productInfo(productIDC[i][j],"桶裝"+productNameC[i][j]);
    		}
    	}
    	for(int i=0; i<productNameD.length; i++) {
    		for(int j=0; j<productNameD[0].length; j++) {
    			if(productIDD[i][j].length()>0 && productNameD[i][j].length()>0)
    				mydbma.insertRD_into_TB_productInfo(productIDD[i][j],productNameD[i][j]);
    		}
    	}
	}
}
