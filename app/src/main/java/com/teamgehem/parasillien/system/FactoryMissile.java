/**
 * @FileName : FactoryMissile.java
 * @Project	 : Parasilien
 * @Package : com.android.parasilien.system
 * @Date	 : 2010. 9. 30.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.parasillien.system;


import com.teamgehem.parasillien.bean.BeanMissile;

/**
 * @Class	 : FactoryMissile
 * @Date	 : 2010. 9. 30.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 미사일 생성하는 팩토리 클래스
 */
public class FactoryMissile {

    /**
     * FactoryMissile's Constructor
     * @Comment  :
     */
    private FactoryMissile() {
    }
    public static BeanMissile createMissile(int idx, int arrow) {
        return checkIdx(idx, arrow);
    }
    /**
     * @param idx
     * @param arrow
     * @return Missile
     * @Comment : idx에 따라 각기 다른 미사일이 생성됨
     */
    private static BeanMissile checkIdx(int idx, int arrow) {
        BeanMissile m = null;
        /*
         * 0 : 작은 form 미사일(Lv0)
         * 1 : 작은+미사일 스피드 향상 (Lv0.1)
         * 2 : 작은+미사일 연사속도 향상(Lv0.2)
         * 3 : 기본 form 미사일(Lv1)
         * 4 : 기본+스피드,연사속도 향상(Lv1.5)
         * 5 : 중형 form 미사일(Lv2)
         * 6 : 중형 from 미사일 향상(Lv2.5)
         * 7 : 대형 from 미사일(Lv3)
         * 8 : 레이저 from 미사일(Lv4)
         * 9 : 레이저 축소 미사일(Lv4.5)
         * 10 : 회전 from 미사일(Lv5)
         * 11 : 회전 Return 미사일(Lv5.5)
         *      화면에서 사라졌다가 반대 방향으로 돌아감
         * */
        switch (idx) {
            case 0:
                m = new BeanMissile("Normal",1,8,10,1,0,arrow);                
                break;
            case 1:
                break;
            default:
                m = new BeanMissile("error_Missile",1,1,1,1,0,arrow);   
                break;
        }
        return m;
    }
}
