package me.riverz.tank.v1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
 
 
public class Blood {
  /*血块数据*/
  int x, y, w, h;//血块位置和大小
  private TankClient tc;  //主类权限
  private boolean live=true;//血块的存活
  private static Random r = new Random();//设置一个随机值变量
  /*获取血块的存活状态*/
  public boolean isLive() {
    return live;
  }
  /*设置血块的存活状态*/
  public void setLive(boolean live) {
    this.live = live;
  }
  /*血块位置初值随机一个数值*/
  public Blood(){
    x=r.nextInt(600)+100;
    y=r.nextInt(400)+100;
    w=h=15;
  }
  /*画血块*/
  public void draw(Graphics g){
    if(!live) return;
    Color c=g.getColor();
    g.setColor(Color.magenta);
    g.fillRect(x, y, w, h);
    g.setColor(c);
  }
  /*释放血块*/
  public void fh(){
    if(!live){
      x = r.nextInt(600)+100;
      y = r.nextInt(400)+100;
      live = true;
    }
  }
  /*获取血块范围*/
  public Rectangle getRect(){
    return new Rectangle(x, y, w, h);
  }
}
