/**
 * @FileName : BeanEnemy.java
 * @Project	 : Parasilien
 * @Package : com.android.parasilien.bean
 * @Date	 : 2010. 9. 28.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.parasillien.bean;

import android.graphics.Point;

/**
 * @Class	 : BeanEnemy
 * @Date	 : 2010. 9. 28.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class BeanEnemy extends BeanCommon implements Cloneable {
    private int wayPackId;
    private int wayPackIdx;
    private int present;
    private int presentPersent;
    /**
     * BeanEnemy's Constructor
     * @Comment  :
     */
    public BeanEnemy(BeanBody mainB, BeanMissile bm, int hp, int dmg, int speedMove) {
        super(mainB,bm,hp,dmg,speedMove);
        p = new Point(200,100);
    }
    public BeanEnemy clone() {
        try {
            return (BeanEnemy)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int getWayPackId() {
        return wayPackId;
    }
    public void setWayPackId(int wayPackId) {
        this.wayPackId = wayPackId;
    }
    public int getWayPackIdx() {
        return wayPackIdx;
    }
    public void setWayPackIdx(int wayPackIdx) {
        this.wayPackIdx = wayPackIdx;
    }
    public int getPresent() {
        return present;
    }
    public void setPresent(int present) {
        this.present = present;
    }
    public int getPresentPersent() {
        return presentPersent;
    }
    public void setPresentPersent(int presentPersent) {
        this.presentPersent = presentPersent;
    }
}









