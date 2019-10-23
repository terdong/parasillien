/**
 * @FileName : FactoryEnemy.java
 * @Project	 : Parasilien
 * @Package : com.android.parasilien.system
 * @Date	 : 2010. 9. 30.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.parasillien.system;

import com.teamgehem.parasillien.bean.BeanBody;
import com.teamgehem.parasillien.bean.BeanEnemy;
import com.teamgehem.parasillien.bean.BeanMissile;

/**
 * @Class	 : FactoryEnemy
 * @Date	 : 2010. 9. 30.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class FactoryEnemy {

    /**
     * FactoryEnemy's Constructor
     * @Comment  :
     */
    private FactoryEnemy() {
    }
    public static BeanEnemy createEnemy(BeanBody mainB, BeanMissile bm, int idx) {
        BeanEnemy be=null;
        switch (idx) {
            case 0:
                be = new BeanEnemy(mainB, bm, 1,1,5);
                break;
            case 1:
                be =new BeanEnemy(mainB, bm, 3,3,10);
                break;
            case 2:
                be =new BeanEnemy(mainB, bm, 5,5,10);
                break;
            default:
                break;
        }
        return be;
    }

}
