/**
 * @FileName : BeanParasilien.java
 * @Project	 : Parasilien
 * @Package : com.android.parasilien.bean
 * @Date	 : 2010. 9. 28.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.parasillien.bean;

import android.graphics.Bitmap;
import android.graphics.Point;

/**
 * @Class	 : BeanParasilien
 * @Date	 : 2010. 9. 28.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class BeanParasilien extends BeanCommon {
    
    // Image width
    private int iWidth;
    // Image width/2
    private int iWidthHalf;
    // Image heigh
    private int iHeigh;
    // Image heigh/2
    private int iHeighHalf;
    // Player's Life
    private int life;
    // stamina point
    private int sp;
    // missile press
    private boolean fire;
    // missile Max Number;
    private int mMax;
    
    
    /**
     * BeanParasilien's Constructor
     * @Comment  :
     */
    public BeanParasilien(BeanBody mainB, BeanMissile bm, int hp, int dmg, int speedMove) {
        super(mainB,bm,hp,dmg,speedMove);
       life = 10;
       sp = 100;
       fire = false;
       mMax = 20;
    }
    public int getLife() {
        return life;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public int getSp() {
        return sp;
    }
    public void setSp(int sp) {
        this.sp = sp;
    }
    public boolean getFire() {
        return fire;
    }
    public void setFire(boolean fire) {
        this.fire = fire;
    }
    public void setmMax(int mMax) {
        this.mMax = mMax;
    }
    public int getmMax() {
        return mMax;
    }
    public int getiWidth() {
        return iWidth;
    }
    public void setiWidth(int iWidth) {
        this.iWidth = iWidth;
        this.iWidthHalf = iWidth/2;
    }
    public int getiHeigh() {
        return iHeigh;
    }
    public void setiHeigh(int iHeigh) {
        this.iHeigh = iHeigh;
        this.iHeighHalf = iHeigh/2;
    }
    public int getiWidthHalf() {
        return iWidthHalf;
    }
    public int getiHeighHalf() {
        return iHeighHalf;
    }
    
}










