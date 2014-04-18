package com.dszi.neuro;

public class DataEncapsule
{
    private double[] data;
    private String name;

    public DataEncapsule(String arg, double[] arg2)
    {
        name = arg;
        data = arg2;
    }
    
    public String GetName()
    {
    	return name;
    }

    public double Get(int arg1)
    {
        return data[arg1];
    }

    public char Mask(double arg1)
    {
        if (arg1 == -1) return ' ';
        else if (arg1 == 1) return '*';
        else return '0';
    }
    
    public void SGNthedata(double[] arg1)
    {
        double[] output = new double[arg1.length];

        for (int i = 0; i < arg1.length; i++)
        {
            if (arg1[i] >= 0) output[i] = 1;
            else if (arg1[i] < 0) output[i] = -1;
        }
        data = output;
    }
}

//Dla modelu asocjacji, z wbudowan¹ funkcj¹ SGN z ca³ego zbioru danych. Dla danych <0 zwraca -1,
//dla wiêkszych 1. Mo¿na zmieniaæ w zale¿noœci od danych na wejœciu (od tego jaki zasiêg widzenia ma traktor).