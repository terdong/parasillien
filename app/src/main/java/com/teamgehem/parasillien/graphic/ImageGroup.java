/**
 * @FileName : Images.java
 * @Project	 : Parasilien
 * @Package : com.android.parasilien.graphic
 * @Date	 : 2010. 9. 28.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.parasillien.graphic;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.teamgehem.parasillien.R;

/**
 * @Class	 : Images
 * @Date	 : 2010. 9. 28.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : Game 에 쓰이는 각종 이미지 로딩
 */
public class ImageGroup {
    private Resources r;
    //private Bitmap scene [][];
    private Bitmap sLogo[];
    private Bitmap body[];
    private Bitmap ui[];
    private Bitmap missile[];
    /**
     * Images's Constructor
     * @param r 
     * @param r 
     * @param h 
     * @param w 
     * @Comment  :
     */
    public ImageGroup(Resources r, int w, int h) {
        this.r = r;
        //scene [][] = new Bitmap[]
        sLogo = new Bitmap[2];
        body = new Bitmap[50];
        ui = new Bitmap[7];
        missile = new Bitmap[2];
        
        sLogo[0] = setBm(R.drawable.scene_00_company);
        sLogo[1] = setBm(R.drawable.scene_00_logo);
        
        ui[0] = Bitmap.createScaledBitmap(setBm(R.drawable.scene_02_play_ui_background),w*2,h*4,true);
        ui[1] = setBm(R.drawable.scene_02_play_ui_bar_bg);
        ui[2] = setBm(R.drawable.scene_02_play_ui_bar_blue);
        ui[3] = setBm(R.drawable.scene_02_play_ui_bar_green);
        ui[4] = setBm(R.drawable.scene_02_play_ui_bar_purple);
        ui[5] = Bitmap.createScaledBitmap(setBm(R.drawable.scene_02_play_ui_bar_bg), ui[1].getHeight(), ui[1].getWidth(), true);
        ui[6] = Bitmap.createScaledBitmap(setBm(R.drawable.body_00_paras), 15, 15, true);
        
        for(int i=0; i<missile.length; i++)
            missile[i] = setBm(R.drawable.scene_02_play_missile_small+i);
        
//        for(int i=0; i<body.length; i++)
//                body[i] = setBm(R.drawable.body_00_paras+i);
        body[0] = setBm(R.drawable.body_00_paras);
        body[1] = setBm(R.drawable.body_01_tri_green);
        body[2] = setBm(R.drawable.body_02_rect_green);
        body[3] = setBm(R.drawable.body_03_dia_green);
        body[10] = setBm(R.drawable.body_10_tri_orange);
        body[20] = setBm(R.drawable.body_20_rect_purple);
        body[30] = setBm(R.drawable.body_30_dia_blue);
    }
    private Bitmap setBm(int id) {
        return BitmapFactory.decodeResource(r,id);
    }
    public Bitmap[] getsLogo() {
        return sLogo;
    }
    public Bitmap[] getUi() {
        return ui;
    }
    public Bitmap getBody(int id) {
        return body[id];
    }
    public Bitmap getMissile(int id) {
        return missile[id];
    }
}









