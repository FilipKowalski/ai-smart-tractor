package com.dszi.neuro;

public class AssocModel {
	double[] IdealPattern = new double[144];
	double[] IdealPattern2 = new double[144];
	
	DataEncapsule Z0 = new DataEncapsule("Idealny 1",IdealPattern);
    DataEncapsule Z1 = new DataEncapsule("Idealny 2",IdealPattern2);
	
    /*
    double [][] W = new double[144][144];

    for(int i = 0; i<144; i++)
    {
        for(int j = 0; j<144; j++)
        {
            W[i][j] = (new Double(1/144) * (Z0.Get(i) * Z0.Get(j))) + (new Double(1/144) * (Z1.Get(i) * Z1.Get(j)));
        }
    }
    double[] resultz0 = new double[25];
    double[] resultz1 = new double[25];
    
    double tempold=0, tempnew=0;

    for (i = 0; i < 25; i++)
    {
        for (int j = 0; j < 25; j++)
        {
            if (j == 24) { tempold = tempnew; tempnew = W[i][j] * Z0.Get(j); tempnew = tempold + tempnew; resultz0[i] = tempnew; tempnew = 0; tempold = 0; }
            else { tempold = tempnew;  tempnew = W[i][j] * Z0.Get(j); tempnew = tempnew + tempold; }
        }
    }

    for (i = 0; i < 25; i++)
    {
        for (int j = 0; j < 25; j++)
        {
            if (j == 24) { tempold = tempnew; tempnew = W[i][j] * Z1.Get(j); tempnew = tempold + tempnew; resultz1[i] = tempnew; tempnew = 0; tempold = 0; }
            else { tempold = tempnew; tempnew = W[i][j] * Z1.Get(j); tempnew = tempnew + tempold; }
        }
    }
}
    //TODO: Wektory 2d nie dzia³aj¹? B³¹d kompilatora? Powinno dzia³aæ jako asocjacja dla zestawu danych idealnych,
    pomocne do robienia tolerancji b³êdu dla zadanego wzorca.
    
    */
    
}




