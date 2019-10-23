/**
 * @FileName : Missile.java
 * @Project	 : Parasilien
 * @Package : com.android.parasilien.system
 * @Date	 : 2010. 9. 30.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.parasillien.bean;


/**
 * @Class	 : Missile
 * @Date	 : 2010. 9. 30.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 미사일 팩토리를 통해 생성됨
 */
public class BeanMissile {
    // Missile Name
    private String mName;
    // Damage
    private int mDmg;
    // Missile Speed
    private int speedMove;
    // Missile Shoot Delay
    private int speedShoot;
    // Missile Image ID
    private int mImgId;
    // Missile Image Idx
    private int mImgIdx;
    // Missile Arrow
    private int arrow;
    /**
     * Missile's Constructor
     * @Comment  :
     */
    public BeanMissile() {
    }
    public BeanMissile(String mName, int mDmg, int speedMove, int speedShoot, int mImgId, int mImgIdx, int arrow) {
        this.mName = mName;
        this.mDmg = mDmg;
        this.speedMove = speedMove;
        this.speedShoot = speedShoot;
        this.mImgId = mImgId;
        this.mImgIdx = mImgIdx;
        this.arrow = arrow;
    }
    public String getmName() {
        return mName;
    }
    public int getmDmg() {
        return mDmg;
    }
    public int getSpeedMove() {
        return speedMove;
    }
    public int getSpeedShoot() {
        return speedShoot;
    }
    public int getmImgId() {
        return mImgId;
    }
    public int getmImgIdx() {
        return mImgIdx;
    }
    public void setmImgIdx(int mImgIdx) {
        this.mImgIdx = mImgIdx;
    }
    public void setArrow(int arrow) {
        this.arrow = arrow;
    }
    public int getArrow() {
        return arrow;
    }
}