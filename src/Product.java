class Product {
	CDM_dbma mydbma = new CDM_dbma();
	
    String[][] productNameA = {{"���֤���p","�۳¤���p","��������p"},
    						   {"�¿}����p","�@�ؤ���p","��������p"},
    						   {"�_�q����p","",""},
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
							 {"","",""}};//���X�W�W�h��a+���q+�ӫ~ EX:471(���إ���)888(���q)101(�ӫ~)
    
    String[][] productNameB = {{"���֤���p","�۳¤���p","�гJ������p"},
    						   {"�¿}����p","���a����p",""},
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
    
    String[][] productNameC = {{"���֤���p","�۳¤���p","��������p"},
    						   {"�¿}����p","�i�i����p","���a�ʤ���p"},
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
    
    String[][] productNameD = {{"���J�O����p","���Ԥ���p","�ٯ�����p"},
    							{"�ª۳»�","�гJ����",""},
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
    			if(productIDA[i][j].length()>0 && productNameA[i][j].length()>0)//���ӫ~�~��
    				mydbma.insertRD_into_TB_productInfo(productIDA[i][j],"����"+productNameA[i][j]);
    		}
    	}
    	for(int i=0; i<productNameB.length; i++) {
    		for(int j=0; j<productNameB[0].length; j++) {
    			if(productIDB[i][j].length()>0 && productNameB[i][j].length()>0)
    				mydbma.insertRD_into_TB_productInfo(productIDB[i][j],"����"+productNameB[i][j]);
    		}
    	}
    	for(int i=0; i<productNameC.length; i++) {
    		for(int j=0; j<productNameC[0].length; j++) {
    			if(productIDC[i][j].length()>0 && productNameC[i][j].length()>0)
    				mydbma.insertRD_into_TB_productInfo(productIDC[i][j],"���"+productNameC[i][j]);
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
