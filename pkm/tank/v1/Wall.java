package me.riverz.tank.v1;

import java.awt.Graphics;
import java.awt.Rectangle;
 
 
public class Wall {
  /*墙数据*/
  int x,y,w,h;  //位置和宽高
  private TankClient tc;  //主类权限
   
  public Wall(int x, int y, int w, int h, TankClient tc) {
    super();
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.tc = tc;
  }
  /*获取墙的范围*/
  public Rectangle getRect(){
    return new Rectangle(x,y,w,h);
  }
  /*画墙*/
  public void draw(Graphics g){
    g.fillRect(x, y, w, h);
  }
}