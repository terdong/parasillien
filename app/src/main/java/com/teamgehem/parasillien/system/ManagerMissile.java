/**
 * @FileName : ManagerMissile.java
 * @Project	 : Parasilien
 * @Package : com.android.parasilien.system
 * @Date	 : 2010. 9. 30.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.parasillien.system;

import java.util.ArrayList;


import android.graphics.Point;

import com.teamgehem.parasillien.bean.BeanMissile;

/**
 * @Class	 : ManagerMissile
 * @Date	 : 2010. 9. 30.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 화면상의 모든 미사일을 관리하는 매니저 클래스
 */
public class ManagerMissile {
    private final int MAXMISSILE = 80;
    private ArrayList<MissileOwner> alMissile;
    private int maxMissile;
    /**
     * ManagerMissile's Constructor
     * @Comment  :
     */
    public ManagerMissile() {
        this.maxMissile = MAXMISSILE;
        alMissile = new ArrayList<MissileOwner>(MAXMISSILE);
    }
    public ManagerMissile(int maxMissile) {
        this.maxMissile = maxMissile;
        alMissile = new ArrayList<MissileOwner>(maxMissile);
    }
    public void addMissilePosition(int charId, Point p, BeanMissile bm) {
        alMissile.add(new MissileOwner(charId, p , bm));
    }
    public ArrayList<MissileOwner> getAlMissile() {
        return alMissile;
    }
    public void setAlMissile(ArrayList<MissileOwner> alMissile) {
        this.alMissile = alMissile;
    }
    public boolean checkEnableFire() {
        return maxMissile>alMissile.size();
    }
    public boolean checkIsEmpty() {
        return alMissile.isEmpty();
    }
    public class MissileOwner{
        private int charId;
        private Point p;
        private BeanMissile bm;
        public MissileOwner(int charId, Point p, BeanMissile bm) {
            this.charId = charId;
            this.setP(p);
            this.bm = bm;
        }
        
        public void moveMissile() {
            switch (bm.getArrow()) {
                case 0:
                    p.y -= bm.getSpeedShoot();
                    break;
                case 1:
                    p.y += bm.getSpeedShoot();
                    break;
                case 2:
                    p.x -= bm.getSpeedShoot();
                    break;
                case 3:
                    p.x += bm.getSpeedShoot();
                    break;
                default:
                    break;
            }
        }
        
        public void setId(int id) {
            this.charId = id;
        }
        public int getId() {
            return charId;
        }
        public void setP(Point p) {
            this.p = p;
        }
        public Point getP() {
            return p;
        }
        public int getImgMissile() {
            return bm.getmImgId();
        }
        public int getArrow() {
            return bm.getArrow();
       }
        public int getSpeedMove() {
            return bm.getSpeedMove();
        }
    }
}










