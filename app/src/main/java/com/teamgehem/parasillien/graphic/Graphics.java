package com.teamgehem.parasillien.graphic;

import java.text.NumberFormat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.SurfaceHolder;

public abstract class Graphics {
    protected SurfaceHolder holder;
    protected Paint paint;
    protected Canvas canvas;

    public Graphics(SurfaceHolder holder) {
        this.holder=holder;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
    }
    // lock
    public void lock() {
        canvas=holder.lockCanvas();
    }
    // unlock
    public void unlock() {
        holder.unlockCanvasAndPost(canvas);
    }
    
    // set Color
    public void setColor(int color) {
        paint.setColor(color);
    }
    
    // set FontSize
    public void setFontSize(int fontSize) {
        paint.setTextSize(fontSize);
    }
    
    // set FontType
    public void setFontType(Typeface tf) {
        paint.setTypeface(tf);
    }
    
    // get String Width
    public int stringWidth(String str) {
        return (int) paint.measureText(str);
    }
    // get String Heigh
    public int stringHeigh() {
        return (int) paint.getTextSize();
    }
    // drawing String
    public void drawString(String str, int x, int y) {
        canvas.drawText(str,x,y,paint);
    }
    public void drawString(int num, int x, int y) {
        canvas.drawText(NumberFormat.getNumberInstance().format(num),x,y,paint);
    }
    
    // drawing Rect
    public void fillRect(int x, int y, int w, int h) {
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(new Rect(x,y,x+w,y+h),paint);
    }
    
    // drawing Bitmap
    public void drawBitmap(Bitmap bitmap, int x, int y) {
        canvas.drawBitmap(bitmap,x,y,null);
    }
    public void drawBitmap(Bitmap bitmap, Point p) {
        canvas.drawBitmap(bitmap,p.x,p.y,null);
    }
    
    
    // drawing BackGround
    public void backGround(int x, int y, int w, int h) {
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(new Rect(x,y,x+w,y+h),paint);
    }
    
    abstract public void fadeOut();

}















