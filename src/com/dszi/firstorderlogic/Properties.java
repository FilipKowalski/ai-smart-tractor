package com.dszi.firstorderlogic;

import com.dszi.gui.SingleCell;

public class Properties {
	//Proste relacje jednoelemenetowe, okreœlaj¹ce stan pojedynczego pola na mapce.
	public boolean NeedsWateringUrgently(SingleCell s) {
		boolean result=false;
		if(s.Irrigation<20) result = true;
		else result=false;
		return result;
	}
	public boolean NeedsWatering(SingleCell s) {
		boolean result=false;
		if(s.Irrigation<50) result = true;
		else result=false;
		return result;
	}
	public boolean CouldUseWatering(SingleCell s) {
		boolean result=false;
		if(s.Irrigation<70) result = true;
		else result=false;
		return result;
	}
	public boolean WellWatered(SingleCell s) {
		boolean result=false;
		if(s.Irrigation>70) result = true;
		else result=false;
		return result;
	}
	public boolean NeedsFertilisingUrgently(SingleCell s) {
		boolean result=false;
		if(s.soilDestruction>70) result = true;
		else result=false;
		return result;
	}
	public boolean NeedsFertilising(SingleCell s) {
		boolean result=false;
		if(s.soilDestruction>30) result = true;
		else result=false;
		return result;
	}
	public boolean CouldUseFertilising(SingleCell s) {
		boolean result=false;
		if(s.soilDestruction>10) result = true;
		else result=false;
		return result;
	}
	public boolean WellFertilised(SingleCell s) {
		boolean result=false;
		if(s.soilDestruction<10) result = true;
		else result=false;
		return result;
	}
	public boolean PlaguedbyPests(SingleCell s) {
		boolean result=false;
		if(s.numberofPests>10) result = true;
		else result=false;
		return result;
	}
	public boolean SomePestsPresent(SingleCell s) {
		boolean result=false;
		if(s.numberofPests>=1) result = true;
		else result=false;
		return result;
	}
	public boolean ClearfromPests(SingleCell s) {
		boolean result=false;
		if(s.numberofPests==0) result = true;
		else result=false;
		return result;
	}
	public boolean IsDead(SingleCell s) {
		boolean result=false;
		if(s.numberofPests>15 || s.Irrigation==0 || s.soilDestruction==100) result=true;
		else result=false;
		return result;
	}
	//Z³o¿one relacje:
	public boolean IsinPerfectCondidion(SingleCell s) {
		boolean result=false;
		if(ClearfromPests(s)==true && WellWatered(s)==true && WellFertilised(s)==true) result = true;
		else result=false;
		return result;
	}
	public boolean SomeWorkNeeded(SingleCell s) {
		boolean result=false;
		if(ClearfromPests(s)==false && WellWatered(s)==true && WellFertilised(s)==true) result = true;
		if(ClearfromPests(s)==true && WellWatered(s)==false && WellFertilised(s)==true) result = true;
		if(ClearfromPests(s)==true && WellWatered(s)==true && WellFertilised(s)==false) result = true;
		else result=false;
		return result;
	}
	//Mo¿na definiowaæ przez logiczne || i && w Javie, albo korzystaæ z operatorów z Operators.
	//W miare potrzeb mo¿na zdefiniowaæ za pomoc¹ prostych andów relacje typu XOR, NAND nawet
	//w operatorach.
}
