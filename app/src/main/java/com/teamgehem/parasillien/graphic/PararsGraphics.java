/**
 * @FileName : PararsGraphics.java
 * @Project	 : Parasilien
 * @Package : com.android.parasilien.graphic
 * @Date	 : 2010. 9. 29.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.parasillien.graphic;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.SurfaceHolder;

/**
 * @Class	 : PararsGraphics
 * @Date	 : 2010. 9. 29.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : Graphics Ultil Class를 상속받고, 변수를 낀 Custom Utils
 */
public class PararsGraphics extends Graphics {
    private Typeface tf[];
    private int alpha;
    /**
     * PararsGraphics's Constructor
     * @param holder
     * @Comment  :
     */
    public PararsGraphics(SurfaceHolder holder) {
        super(holder);
        alpha = 0;
        tf = new Typeface[10];
    }
    
    public void setTypeface(int idx, Typeface tf) {
        this.tf[idx]=tf;
    }
    
    public void setFontType(int idx) {
        paint.setTypeface(tf[idx]);
    }
    
    public void fadeOut() {
        canvas.drawColor(Color.argb(alpha=alpha<255?alpha+=3:255, 0, 0, 0));
     //   Log.d("PG", new String().valueOf(alpha));
        //return alpha;
    }
}



















