/**
 * @FileName : GroupEnemy.java
 * @Project	 : Parasilien
 * @Package : com.android.parasilien.bean
 * @Date	 : 2010. 9. 28.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.parasillien.system;


import com.teamgehem.parasillien.bean.BeanBody;
import com.teamgehem.parasillien.bean.BeanCommon;
import com.teamgehem.parasillien.bean.BeanEnemy;
import com.teamgehem.parasillien.bean.BeanMissile;
import com.teamgehem.parasillien.bean.BeanParasilien;

/**
 * @Class	 : GroupEnemy
 * @Date	 : 2010. 9. 28.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 적 관리자
 */
public class CommonGroup {
    private BeanBody bb[];
    private BeanMissile bmParas[];
    private BeanMissile bmEnemy[];
    
    private BeanCommon paras;
    private BeanCommon enemy[];
    /**
     * GroupEnemy's Constructor
     * @Comment  :
     */
    public CommonGroup() {
        bb = new BeanBody[50];
        bmParas = new BeanMissile[12];
        bmEnemy = new BeanMissile[12];
        bb[0] = FactoryBody.createBody(0);
        bb[1] = FactoryBody.createBody(1);
        bb[2] = FactoryBody.createBody(2);
        bb[3] = FactoryBody.createBody(3);
        bb[10] = FactoryBody.createBody(10);
        bb[20] = FactoryBody.createBody(20);
        bb[30] = FactoryBody.createBody(30);
        bb[40] = FactoryBody.createBody(40);
        
        for(int i=0; i<bmParas.length; i++) {
            bmParas[i] = FactoryMissile.createMissile(i,0);
            bmEnemy[i] = FactoryMissile.createMissile(i,1);
        }
        
        enemy = new BeanEnemy[20];
        enemy[0] = FactoryEnemy.createEnemy(bb[10],bmEnemy[0],0);
        enemy[1] = FactoryEnemy.createEnemy(bb[20],bmEnemy[0],1);
        enemy[2] = FactoryEnemy.createEnemy(bb[30],bmEnemy[0],2);
        
        paras = new BeanParasilien(bb[0], bmParas[0], 100, 1, 10);
    }
    public BeanBody[] getBb() {
        return bb;
    }
    public BeanMissile[] getBm() {
        return bmParas;
    }
    public BeanParasilien getParas() {
        return (BeanParasilien)paras;
    }
    public BeanEnemy[] getEnemy() {
        return (BeanEnemy[]) enemy;
    }
}


























