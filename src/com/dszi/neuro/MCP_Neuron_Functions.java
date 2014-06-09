package com.dszi.neuro;

public class MCP_Neuron_Functions {
	
	double MCPNeuronOutput(double[] vector1, double[] vector2)
    {
        double result = 0;
        boolean error = false;
        int length1 = vector1.length, length2 = vector2.length;

        if (length1 != length2) error = true; //Cartesian product of tables with different sizes
        else
        {
            for (int i = 0; i < length1; i++)
            {
                result = result + vector1[i] * vector2[i];
            }
        }
        if (result >= 0) result = 1;
        if (result < 0) result = 0;
        if (error == true) result = 3.14;
        return result;
    }
	
	/*//TODO: zrobiæ pe³n¹ reprezentacjê neuronu MCP (jeœli bêdzie potrzebna), jest chwilowo tylko wyjœcie z neuronu
	przy zadanych wektorach na wejœciu.
	*/
	
}
