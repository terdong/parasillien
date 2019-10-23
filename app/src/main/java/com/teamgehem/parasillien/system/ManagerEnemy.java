/**
 * @FileName : ManagerEnemy.java
 * @Project	 : Parasilien
 * @Package : com.android.parasilien.system
 * @Date	 : 2010. 9. 30.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.parasillien.system;

import com.teamgehem.parasillien.bean.BeanEnemy;

import java.util.ArrayList;


/**
 * @Class	 : ManagerEnemy
 * @Date	 : 2010. 9. 30.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class ManagerEnemy {
    private ArrayList<BeanEnemy> alEnemy;
    private BeanEnemy be[];
    /**
     * ManagerEnemy's Constructor
     * @Comment  :
     */
    public ManagerEnemy(BeanEnemy be []) {
            this.be = be;
            alEnemy = new ArrayList<BeanEnemy>();
    }
    public void addEnemy(int id) {
        alEnemy.add(be[id].clone());
    }
    public void setAlEnemy(ArrayList<BeanEnemy> alEnemy) {
        this.alEnemy = alEnemy;
    }
    public ArrayList<BeanEnemy> getAlEnemy() {
        return alEnemy;
    }
}

















