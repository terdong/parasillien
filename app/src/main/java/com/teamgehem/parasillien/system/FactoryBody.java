/**
 * @FileName : FactoryBody.java
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

/**
 * @Class	 : FactoryBody
 * @Date	 : 2010. 9. 30.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 비행기체를 생성하는 팩토리 클래스
 */
public class FactoryBody {
    // type Name
    private static String tn;
    // body Image ID
    private static int bII;
    // body Image Index
    private static int bIIdx;
    // Explosion Image ID
    private static int eII;
    // Explosion Image Index
    private static int eIIdx;
    /**
     * FactoryBody's Constructor
     * @Comment  :
     */
    private FactoryBody() {}
    public static BeanBody createBody(int idx) {
        /* idx
         * 0 : Parasilien
         * 1 : tri_green
         * 2 : rect_green
         * 3 : dia_green
         * 10 : tri_orange
         * 20 : rect_purple
         * 30 : dia_blue
         * 40 : boss_00 
         * */
        switch (idx) {
            case 0:
                setParam("paras_host",idx,0,0,0);
                break;
            case 1:
                setParam("paras_tri",idx,0,0,0);
                break;
            case 2:
                setParam("paras_rect",idx,0,0,0);
                break;
            case 3:
                setParam("paras_dia",idx,0,0,0);
                break;
            case 10:
                setParam("tri_orange",idx,0,0,0);
                break;
            case 20:
                setParam("rect_purple",idx,0,0,0);
                break;
            case 30:
                setParam("dia_blue",idx,0,0,0);
                break;
            case 40:
                setParam("boss_00",idx,0,0,0);
                break;
            default:
                setParam("error_Body",0,0,0,0);
                break;
        }
        return new BeanBody(tn,bII, bIIdx, eII, eIIdx);
    }
    private static void setParam(String str, int i, int j, int k, int l) {
        tn=str;bII=i;bIIdx=j;eII=k;eIIdx=l;
    }
}









