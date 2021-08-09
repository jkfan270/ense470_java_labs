/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jkfan
 */


public class tankFactory {
	public Tank tankType(int type) {
		switch(type) {
			case 0: return new tank_Sherman();
			case 1: return new tank_Tiger();
			case 2: return new tank_Churchill();
			case 3: return new tank_T34();
			case 4: return new tank_Panzer();
                        default:
				return null;
		}
	}
}
    

