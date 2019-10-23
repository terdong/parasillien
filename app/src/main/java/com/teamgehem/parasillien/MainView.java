package com.teamgehem.parasillien;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.teamgehem.parasillien.bean.BeanEnemy;
import com.teamgehem.parasillien.bean.BeanParasilien;
import com.teamgehem.parasillien.graphic.ImageGroup;
import com.teamgehem.parasillien.graphic.PararsGraphics;
import com.teamgehem.parasillien.messages.Msg;
import com.teamgehem.parasillien.system.CommonGroup;
import com.teamgehem.parasillien.system.ManagerEnemy;
import com.teamgehem.parasillien.system.ManagerMissile;


/**
 * @Class	 : MainView
 * @Date	 : 2010. 9. 28.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class MainView extends SurfaceView implements SurfaceHolder.Callback {
    // Log's TAG
    private final static String TAG = Msg.getStr("str0"); //$NON-NLS-1$

    // Timer frame Tick
    private final static int TICK = 1000/30;

    // display flag
    private final static int
            S_LOGO              =0,
            S_TITLE             =1,
            S_TITLE_SINGLE      =2,
            S_TITLE_MULTI       =3,
            S_TITLE_OPTION      =4,
            S_TITLE_CREDIT      =5,
            S_TITLE_QUIT        =6,
            S_PLAY              =7,
            S_RANK              =8,
            S_GAMEOVER          =9;

    // Object flag
    private final static int
            PARAS               =0,
            ENEMY               =1;

    /*System*/
    private SurfaceHolder holder;
    private Timer timer;
    private PararsGraphics g;
    private ImageGroup ig;
    private AssetManager am;
    private int WIDTH,HEIGH;
    private int tX, tY;


    /*Game*/
    // Scene
    private int scene;
    // Object
    private CommonGroup cg;
    private BeanParasilien paras;
    private BeanEnemy enemy;

    private ManagerMissile managerM;
    private ManagerEnemy managerE;
    private ArrayList<ManagerMissile.MissileOwner> alMissileDummy;

    // pool
    private int pX, pY;
    private int mSP; // Missile Speed
    // Check Box
    private int aHeight, aWidth, aX1,aX2,aY1,aY2;
    private int bHeight, bWidth, bX1,bX2,bY1,bY2;
    private Rect aRect,bRect;
    private int mBGFarWidth, mBGFarHeight;
    private int mBGNearWidth, mBGNearHeight;
    private int mBGFarMoveX, mBGFarMoveY, mBGFarNewMoveX,mBGFarNewMoveY;
    private int mBGNearMoveX, mBGNearMoveY,mBGNearNewMoveX,mBGNearNewMoveY;
    private int mBGFarSpeed,mBGNearSpeed;

    // Player's Score
    private int pScore;
    private int pScoreHigh;

    // Timer
//    private long currentTime;
//    private long LastTime;
    private int frame;



    public MainView(Context context) {
        super(context);
        // Create Graphics Class
        holder = getHolder();
        holder.addCallback(this);
        g= new PararsGraphics(holder);
        am = context.getAssets();

        g.setTypeface(0,Typeface.DEFAULT);
        g.setTypeface(1,Typeface.createFromAsset(am, "fonts/candice.ttf"));
    }
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
    }
    public void surfaceCreated(SurfaceHolder holder) {
        //init
        init();
        timer=new Timer();
        timer.scheduleAtFixedRate(new PTimerTask(),0,TICK);
    }
    public void surfaceDestroyed(SurfaceHolder holder) {
        timer.cancel();
        timer=null;
    }

    /**
     *  void
     * @Comment : 초기화 메소드
     */
    private void init() {
        WIDTH = getWidth();
        HEIGH = getHeight();
        ig = new ImageGroup(getResources(),WIDTH,HEIGH);
        scene = S_LOGO;
        cg= new CommonGroup();
        paras = cg.getParas();
        paras.setiWidth(ig.getBody(paras.getBodyImageId()).getWidth());
        paras.setiHeigh(ig.getBody(paras.getBodyImageId()).getHeight());
        managerE = new ManagerEnemy(cg.getEnemy());
        managerM = new ManagerMissile();
        alMissileDummy = new ArrayList<ManagerMissile.MissileOwner>();
        frame = 0;

        pScore = 999999999;
        pScoreHigh = 999999999;

        managerE.addEnemy(0);


        // Test
        tX = tY = -1;
        pX = WIDTH/2;
        pY = HEIGH-ig.getBody(paras.getBodyImageId()).getHeight();
        //     scene=S_PLAY;

        mBGFarWidth = ig.getUi()[0].getWidth();
        mBGFarHeight = ig.getUi()[0].getHeight();
        Log.d(TAG,"width="+WIDTH+" heigh="+HEIGH+" mBGFarWidth="+mBGFarWidth+" mBGFARHeigh="+mBGFarHeight);
        mBGFarMoveX = 0;
        mBGFarMoveY = -(mBGFarHeight-HEIGH);
        mBGFarSpeed=10;
        mBGNearMoveX = 0;mBGNearMoveY = 0;
        mBGNearNewMoveX = 0;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int tE = event.getAction();
        switch (scene) {
            case S_LOGO:
                if(tE==MotionEvent.ACTION_DOWN)
                    scene=S_PLAY;
                break;
            case S_PLAY:

                if(tE==MotionEvent.ACTION_DOWN) {
                    tX = (int)event.getX();
                    tY = (int)event.getY();
                    paras.setFire(true);
                } else if(tE==MotionEvent.ACTION_UP){
                    tX = -1; tY = -1;
                    paras.setFire(false);
                } else if(tE==MotionEvent.ACTION_MOVE){
                    tX = (int)event.getX();
                    tY = (int)event.getY();
                }
                break;
            default:
                break;
        }
        return true;
    }


    // Timer's Class
    public class PTimerTask extends TimerTask{
        String str;
        int count=0;
        int speed = paras.getSpeedMove();
        int arrow=0;
        int temp1=HEIGH, temp2 = 0;

        @Override
        public void run() {
            synchronized (holder) {
                g.lock();
                // BackGround Color
                g.backGround(0, 0, WIDTH, HEIGH);

                switch (scene) {
                    case S_LOGO:
                        sLogo();
                        break;
                    case S_TITLE:
                        Log.d(TAG, "S_TITTLE");
                        scene++;
                        break;
                    case S_TITLE_SINGLE:
                        Log.d(TAG, "S_TITTLE_SINGLE");
                        scene++;
                        break;
                    case S_TITLE_MULTI:
                        Log.d(TAG, "S_TITTLE_MULTI");
                        scene++;
                        break;
                    case S_TITLE_QUIT:
                        Log.d(TAG, "S_TITTLE_QUIT");
                        scene++;
                        break;
                    case S_PLAY:
                        // Main Frame Counter
                        frame++;
                        // Image_Background
                        //Log.d(TAG,"mBGFarMoveX="+mBGFarMoveX+" MBgFarMoveY="+mBGFarMoveY);
                        g.drawBitmap(ig.getUi()[0], mBGFarMoveX, mBGFarMoveY);
                        mBGFarMoveY += mBGFarSpeed;
                        if (-mBGFarMoveY < HEIGH) {
                            g.drawBitmap(ig.getUi()[0], mBGFarNewMoveX, mBGFarNewMoveY += mBGFarSpeed);
                            if (-mBGFarMoveY < 0) {
                                mBGFarMoveX = mBGFarNewMoveX;
                                mBGFarMoveY = -(mBGFarHeight - HEIGH);
                            }
                        } else if (-mBGFarMoveY <= HEIGH) {
                            mBGFarNewMoveX = mBGFarMoveX == 0 ? -(mBGFarWidth / 2) : 0;
                            mBGFarNewMoveY = -(mBGFarHeight);
                        }

                        // UI Top
                        g.setFontType(1);
                        g.setFontSize(15);
                        g.setColor(Color.WHITE);
                        str = Msg.getStr("str2");
                        g.drawString(str, 0, 15);
                        g.drawBitmap(ig.getUi()[6], 5, 20);
                        str = Msg.getStr("str3");
                        g.drawString(str, (WIDTH - g.stringWidth(str)) / 2, 15);
                        g.drawString(pScoreHigh, (WIDTH - g.stringWidth(str)) / 2, 30);
                        str = Msg.getStr("str4");
                        g.drawString(str, WIDTH - g.stringWidth(str), 15);
                        g.drawString(pScore, WIDTH - (g.stringWidth(str) * 2), 30);

                        // UI Side
                        g.setFontType(0);
                        g.setFontSize(9);
                        g.setColor(Color.WHITE);
                        g.drawBitmap(ig.getUi()[1], 0, (HEIGH - ig.getUi()[1].getHeight()) / 2);
                        g.drawBitmap(ig.getUi()[1], WIDTH - ig.getUi()[1].getWidth(), (HEIGH - ig.getUi()[1].getHeight()) / 2);
                        g.drawBitmap(ig.getUi()[5], (WIDTH - ig.getUi()[5].getWidth()) / 2, 35);
                        g.drawBitmap(ig.getUi()[2], WIDTH - ig.getUi()[2].getWidth(), (HEIGH - ig.getUi()[2].getHeight()) / 2);
                        g.drawBitmap(ig.getUi()[3], 0, (HEIGH - ig.getUi()[3].getHeight()) / 2);
                        g.drawBitmap(ig.getUi()[4], (WIDTH - ig.getUi()[4].getWidth()) / 2, 35);
                        str = Msg.getStr("str5");
                        g.drawString(str, 1, (HEIGH + ig.getUi()[1].getHeight()) / 2 + g.stringHeigh());
                        str = Msg.getStr("str6");
                        g.drawString(str, WIDTH - ig.getUi()[1].getWidth(), (HEIGH + ig.getUi()[1].getHeight()) / 2 + g.stringHeigh());

                        // Character - paras
                        g.drawBitmap(ig.getBody(paras.getBodyImageId()),
                                pX - (paras.getiWidthHalf()),
                                pY - (paras.getiWidthHalf()));

                        // Character - Enemy

                        for (BeanEnemy be : managerE.getAlEnemy()) {
                            // 이 부분은 나중에 클래스로 따로 빼놔서 길이 정보 저장해놔야됨
                            aHeight = ig.getBody(be.getBodyImageId()).getHeight();
                            aWidth = ig.getBody(be.getBodyImageId()).getWidth();
                            aX1 = be.getP().x - (aWidth / 2);
                            aY1 = be.getP().y - (aHeight / 2);
                            aX2 = be.getP().x + (aWidth / 2);
                            aY2 = be.getP().y + (aHeight / 2);
                            for (ManagerMissile.MissileOwner mo : managerM.getAlMissile()) {
                                bHeight = ig.getMissile(mo.getImgMissile()).getHeight();
                                bWidth = ig.getMissile(mo.getImgMissile()).getWidth();
                                bX1 = mo.getP().x - (bWidth / 2);
                                bY1 = mo.getP().y - (bHeight / 2);
                                bX2 = mo.getP().x + (bWidth / 2);
                                bY2 = mo.getP().y + (bHeight / 2);

                                if (((aX1 < bX2) && (bX1 < aX2)) && ((aY1 < bY2) && (bY1 < aY2))) {
                                    Log.d(TAG, "Checkit!!");
                                }
                            }


                            g.drawBitmap(ig.getBody(be.getBodyImageId()), be.getP());

                            //Log.d(TAG,be.getP().x+" "+be.getP().y);
                            // if(frame%be.getMissileDelay()==0)
                            //     managerM.addMissilePosition(ENEMY, be.getP(), be.getBm());
                        }
//                   g.drawBitmap(ig.getBody())

                        // Missile Add - Paras
                        if (paras.getFire()
                                && frame % paras.getMissileDelay() == 0
                                && managerM.checkEnableFire()) {
                            managerM.addMissilePosition(PARAS, new Point(pX, pY), paras.getBm());
                        }

                        missileRun();
                        move(speed);

                        break;
                    case S_RANK:

                        break;
                    default:
                        break;
                }
                g.unlock();
            }
        }

        /**
         *  void
         * @Comment : 미사일을 진행시킴
         */
        @SuppressWarnings("unchecked")
        public void missileRun() {
            if(!managerM.checkIsEmpty()){
                for(ManagerMissile.MissileOwner mo:managerM.getAlMissile()) {
                    mSP=mo.getArrow();
                    if((mo.getP().x<0 || WIDTH<mo.getP().x) || (mo.getP().y<0 || HEIGH<mo.getP().y))
                        continue;
                    g.drawBitmap(ig.getMissile(mo.getImgMissile()),mo.getP());
                    mo.moveMissile();
                    alMissileDummy.add(mo);
                }
                managerM.setAlMissile((ArrayList<ManagerMissile.MissileOwner>) alMissileDummy.clone());
                alMissileDummy.clear();
            }
        }

        /**
         *  void
         * @Comment : Display Developer Logo
         */
        private void sLogo() {
            g.drawBitmap(ig.getsLogo()[0],
                    WIDTH/2-(ig.getsLogo()[0].getWidth()/2),temp1);
            g.drawBitmap(ig.getsLogo()[1],
                    WIDTH/2-(ig.getsLogo()[1].getHeight()/2),temp2);
            if(arrow<=150)
                temp1=HEIGH-(arrow+5);
            if(arrow<=60)
                temp2=arrow+5;
            else if(arrow>=250)
                g.fadeOut();
            if(arrow++>=400)
                scene=S_PLAY;
        }

        /**
         *  void
         * @Comment : 터치 포인트로 parasilien 이동
         */
        private void move(int speed) {
            if(tX!=-1 && tY!=-1) {
                if(pX==tX) {
                    if(pY<tY) pY+=speed;
                    else if(pY>tY) pY+=-speed;
                }else if(pY==tY) {
                    if(pX<tX) pX+=speed;
                    else if(pX>tX) pX+=-speed;
                }else if(pX<tX) {
                    pX+=speed;
                    if(pY<tY) { pY+=speed;}
                    else if(pY>tY) { pY+=-speed;}
                }else if(pX>tX) {
                    pX+=-speed;
                    if(pY<tY) {pY+=speed;}
                    else if(pY>tY) {pY+=-speed;}
                }
                if(tX-speed<pX && pX<tX+speed) pX=tX;
                if(tY-speed<pY && pY<tY+speed) pY=tY;
            }
        }
    }

    private static Random rand=new Random();
    public static int reand(int num) {
        return (rand.nextInt()>>>1) %num;
    }
}