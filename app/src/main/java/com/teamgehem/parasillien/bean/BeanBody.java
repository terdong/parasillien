/**
 * @FileName : BeanBody.java
 * @Project	 : Parasilien
 * @Package : com.android.parasilien.bean
 * @Date	 : 2010. 9. 30.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.parasillien.bean;

/**
 * @Class	 : BeanBody
 * @Date	 : 2010. 9. 30.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 비행기 기체
 */
public class BeanBody {
    // Type Name
    private String typeName;
    // Body Image Id
    private int bBodyImgId;
    // Body Image Index
    private int bBodyImgIdx;
    // Explosion Image Id
    private int bExpImgId;
    // Explosion Image Index
    private int bExpImgIdx;
    
    /**
     * BeanBody's Constructor
     * @Comment  :
     */
    public BeanBody(String tn, int bBII, int bBIIdx, int bEII, int bEIIdx) {
        this.typeName = tn;
        this.bBodyImgId = bBII;
        this.bBodyImgIdx = bBIIdx;
        this.bExpImgId = bEII;
        this.bExpImgIdx = bEIIdx;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getbBodyImgId() {
        return bBodyImgId;
    }

    public int getbBodyImgIdx() {
        return bBodyImgIdx;
    }

    public int getbExpImgId() {
        return bExpImgId;
    }

    public int getbExpImgIdx() {
        return bExpImgIdx;
    }
}
