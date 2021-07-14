package me.riverz.tank.v1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
 
public class Missile {
  /*子弹本身数据*/
  Tank.Direction dir;  //子弹方向
  Color c;  //子弹颜色
  int x,y;  //子弹位置
  public static final int XSPEED = 15;  //横向移动速度
  public static final int YSPEED = 15;  //纵向移动速度
  public static final int Whith = 10;    //子弹宽
  public static final int Higth = 10;    //子弹高
  private boolean live = true;  //判断子弹的存活
  private boolean good;  //判断子弹和阵营
   
  private TankClient tc;//主类权限
   
 
  public Missile(Tank.Direction dir,Color c, int x, int y) {
    super();
      this.dir = dir;
      this.x = x;
      this.y = y;
      this.c = c;
  }
  public Missile(Tank.Direction dir,Color c, int x, int y,boolean good,TankClient tc){
    this(dir,c,x,y);
    this.good = good;
    this.tc = tc;
  }
   
  /*获取子弹的存活*/
  public boolean isLive() {
    return live;
  }
  /*设置子弹的存活*/
  public void setLive(boolean live) {
    this.live = live;
  }
  public void draw(Graphics g){
    /*如果子弹死亡状态将这个子弹在子弹集合中删除*/
    if(!live){
      tc.missiles.remove(this);  //集合中删除
      return;
    }
    /*先保存之前的画笔颜色，画完之后再还原画笔颜色*/
    Color d = g.getColor();  //获取当前画笔颜色
    g.setColor(c);  //设置画笔颜色为红色
    /*画子弹*/
    g.fillOval(x, y, Whith, Higth);  
     
    g.setColor(d);  //还原画笔颜色
    move();  //移动
  }
   
  public void move(){
    /*判断移动方向移动坦克位置*/
    switch(dir){
    case L:
      x-=XSPEED;
      break;
    case LU:
      x-=XSPEED;
      y-=YSPEED;
      break;
    case U:
      y-=YSPEED;
      break;
    case RU:
      x+=XSPEED;
      y-=YSPEED;
      break;
    case R:
      x+=XSPEED;
      break;
    case RD:
      x+=XSPEED;
      y+=YSPEED;
      break;
    case D:
      y+=YSPEED;
      break;
    case LD:
      x-=XSPEED;
      y+=YSPEED;
      break;
    case STOP:
      break;
    }
    /*判断子弹的越界情况；出界则子弹死亡，在子弹集合中删去*/
    if(x<0||y<0||x>TankClient.GAME_WIDTH||y>TankClient.GAME_HEIGTH)
      live = false;
  }
  /*碰撞；获取子弹的范围*/
  public Rectangle getRect(){
    return new Rectangle(x,y,Whith,Higth);
  }
  /*子弹与坦克碰撞过程*/
  public boolean hitTank(Tank t){
    /*如果子弹与坦克在同一范围则子弹和坦克同时死亡；且子弹只能杀死对方坦克*/
    if(this.live&&this.getRect().intersects(t.getRect())&&t.isLive()&&this.good!=t.isGood()){
      if(t.isGood()){ //好坦克
        /*我方坦克子弹射中会减少生命值，生命值0的时候会死亡*/
        t.setLife(t.getLife()-20);
        if(t.getLife()<=0) 
          t.setLive(false);
      }else{ //坏坦克
        t.setLive(false);//死亡
      }
      this.live=false;//子弹死亡
      tc.explode.add(new Explode(x, y, tc));//新建爆炸加入集合
      return true;
    }
    return false;
  }
  /*循环坦克集合分别进行判断子弹碰撞*/
  public boolean hitTanks(List<Tank> tanks){
    for  (int i = 0; i < tanks.size(); i++){
      if(hitTank(tanks.get(i)))
        return true;
    }
    return false;
  }
  /*子弹与墙的碰撞过程*/
  public boolean hitWall(Wall w){
    /*如果子弹与墙的范围重合子弹死亡*/
    if(this.live&&this.getRect().intersects(w.getRect())){
      this.live=false;  //子弹死亡
      return true;
    }
    return false;
  }
}
