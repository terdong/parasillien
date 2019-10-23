package com.teamgehem.parasillien.bean;

import android.graphics.Point;

/**
 * @Class	 : BeanParasilien
 * @Date	 : 2010. 9. 28.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public abstract class BeanCommon {
    protected BeanBody mainB;
    protected BeanMissile mainM;
    private int hp;
    private int dmg;
    private int speedMove;
    // Position
    protected Point p;
    
    public BeanCommon() {
    }
    public BeanCommon(BeanBody mainB, BeanMissile bm, int hp, int dmg, int speedMove) {
        this.mainB = mainB;
        this.mainM = bm;
        this.hp = hp;
        this.dmg = dmg;
        this.speedMove = speedMove;
        this.p = new Point();
    }
    public void setBb(BeanBody bb) {
        this.mainB = bb;
    }
    public BeanBody getBb() {
        return mainB;
    }
    public int getBodyImageId() {
        return mainB.getbBodyImgId();
    }
    public int getBodyImageIdx() {
        return mainB.getbBodyImgIdx();
    }
    public int getExplosionImageId() {
        return mainB.getbExpImgId();
    }
    public int getExplosionImageIdx() {
        return mainB.getbExpImgIdx();
    }
    public int getMissileImageId() {
        return mainM.getmImgId();
    }
    public int getMissileImageIdx() {
        return mainM.getmImgIdx();
    }
    public int getMissileArrow() {
        return mainM.getArrow();
    }
    public int getMissileSpeed() {
        return mainM.getSpeedMove();
    }
    public int getMissileDelay() {
        return mainM.getSpeedShoot();
    }
    public Point getP() {
        return p;
    }
    public void setP(Point p) {
        this.p = p;
    }
    public BeanMissile getBm() {
        return mainM;
    }
    public void setBm(BeanMissile bm) {
        this.mainM = bm;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getDmg() {
        return dmg;
    }
    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
    public int getSpeedMove() {
        return speedMove;
    }
    public void setSpeedMove(int speedMove) {
        this.speedMove = speedMove;
    }
}














