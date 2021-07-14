package me.riverz.tank.v1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
 
import javax.swing.ImageIcon;
 
 
public class Tank {
  /*坦克本身数据*/
  int x, y;//坦克坐标
  private int oldX, oldY;  //坦克上一步坐标
  public static final int Whith = 30;  //坦克宽
  public static final int Higth = 30;  //坦克高
  public static final int XSPEED = 5;  //横向移动速度
  public static final int YSPEED = 5;  //纵向移动速度
  private Color color;  //坦克颜色
  private boolean bL=false, bU=false, bR=false, bD=false;  //四个方向控制值
  enum Direction {L, LU, U, RU, R, RD, D, LD, STOP};  //由四个方向值合成八个方向的移动
  private Direction dir = Direction.STOP;  //出场方向
  private Direction ptDir = Direction.D;  //炮筒初始方向 
  private boolean good;  //判断坦克的阵营
  private boolean live = true;  //判断坦克是否存活
  private static Random r = new Random();//设置一个随机值变量
  private static int step = r.nextInt(12)+3;  //敌方坦克随机移动步骤3-14步
  private int Life = 100;  //血量
  private BloodBar bb = new BloodBar();  //血块类
   
//  ImageIcon icon = new ImageIcon("res\\myTank.jpg");
//  ImageIcon icon2 = new ImageIcon("res\\enemyTank.jpg");
//  Image image = icon.getImage();
//  Image image2 = icon2.getImage();
   
   
  private TankClient tc;  //主类权限
 
  public Tank(int x, int y, boolean good, Color color) {
    super();
    this.x = x;
    this.y = y;
    this.color = color;
    this.good = good;
  }
  public Tank(int x, int y, boolean good,Color color,Direction dir,TankClient tc){
    this(x,y,good,color);
    this.dir = dir;
    this.tc = tc;
  }
  /*获取坦克生命值*/
  public int getLife() {
    return Life;
  }
  /*设置坦克生命值*/
  public void setLife(int Life) {
    this.Life = Life;
  }
 
  /*获取坦克阵营*/
  public boolean isGood() {
    return good;
  }
  /*设置坦克阵营*/
  public void setGood(boolean good) {
    this.good = good;
  }
  /*获取坦克存活状态*/
  public boolean isLive() {
    return live;
  }
  /*设置坦克存活状态*/
  public void setLive(boolean live) {
    this.live = live;
  }
  /*画坦克*/
  public void draw(Graphics g){
    if(!live){  
      if(!good){
        tc.tanks.remove(this);  //敌方坦克死亡时在集合中删除
        //tc.tanks.add(new Tank(r.nextInt(700),r.nextInt(500),false,Color.blue,Direction.D,this.tc));
      }
      return;
    }
    /*先保存之前的画笔颜色，画完之后再还原画笔颜色*/
    Color c = g.getColor();  //获取当前画笔颜色
    g.setColor(color);  //设置画笔颜色为红色
    /*画坦克*/
    g.fillOval(x, y, Whith, Higth);
    /*两种方法绘制敌我坦克，运用之前加入的图片或者颜色区分*/
//    if(good)
//      g.drawImage(image, x, y,Whith,Higth,null);
//    else
//      g.drawImage(image2, x, y, Whith, Higth, null);
    if(good)  
      bb.draw(g);  //我方坦克画血条
    g.setColor(Color.black);
    /*通过炮筒方向画出炮筒*/
    switch(ptDir){
    case L:
      g.drawLine(x+Tank.Whith/2, y+Tank.Higth/2, x, y+Tank.Higth/2);
      break;
    case LU:
      g.drawLine(x+Tank.Whith/2, y+Tank.Higth/2, x, y);
      break;
    case U:
      g.drawLine(x+Tank.Whith/2, y+Tank.Higth/2, x+Tank.Whith/2, y);
      break;
    case RU:
      g.drawLine(x+Tank.Whith/2, y+Tank.Higth/2, x+Tank.Whith, y);
      break;
    case R:
      g.drawLine(x+Tank.Whith/2, y+Tank.Higth/2, x+Tank.Whith, y+Tank.Higth/2);
      break;
    case RD:
      g.drawLine(x+Tank.Whith/2, y+Tank.Higth/2, x+Tank.Whith, y+Tank.Higth);
      break;
    case D:
      g.drawLine(x+Tank.Whith/2, y+Tank.Higth/2, x+Tank.Whith/2, y+Tank.Higth);
      break;
    case LD:
      g.drawLine(x+Tank.Whith/2, y+Tank.Higth/2, x, y+Tank.Higth);
      break;
    }
    g.setColor(c);  //还原画笔颜色
    move();//移动
  }
   
  /*键盘监听；摁键*/
  public void KeyPressed(KeyEvent e){
    int key = e.getKeyCode();  //将键盘监听到的摁键以整数保存
    /*键盘移动坦克*/
    switch(key){
    /*移动摁键*/
    case KeyEvent.VK_UP:
      bU=true;
      break;
    case KeyEvent.VK_DOWN:
      bD=true;
      break;
    case KeyEvent.VK_RIGHT:
      bR=true;
      break;
    case KeyEvent.VK_LEFT:
      bL=true;
      break;
    }
    locateDirection();
  }
   
  /*键盘监听；抬起键*/
  public void keyReleased(KeyEvent e){
    int key = e.getKeyCode();  //将键盘监听到的摁键以整数保存
    /*键盘移动坦克*/
    switch(key){
    case KeyEvent.VK_UP:
      bU=false;
      break;
    case KeyEvent.VK_DOWN:
      bD=false;
      break;
    case KeyEvent.VK_RIGHT:
      bR=false;
      break;
    case KeyEvent.VK_LEFT:
      bL=false;
      break;
    case KeyEvent.VK_Z:  //单发子弹
      if(live)
        fire();
      break;
    case KeyEvent.VK_F2:  //我方复活
      if(!this.live){
        this.live=true;
        this.setLife(100);
      }
      break;
    case KeyEvent.VK_F3:  //敌方复活
      fuhuo();
      break;
    case KeyEvent.VK_A:    //无敌导弹
      superFire();
      break;
    case KeyEvent.VK_Q:    //回血
      if(this.live)
        this.Life = 100;
      break;
    case KeyEvent.VK_E:    //释放血块
      tc.b.fh();
      break;
    /*还原位置键*/
    case KeyEvent.VK_R:
      x = 50;
      y = 50;
      break;
    }
    locateDirection();  //合成方向
  }
  /*合成移动方向*/
  void locateDirection(){
    if(bL&&!bU&&!bR&&!bD) dir=Direction.L;
    else if(bL&&bU&&!bR&&!bD) dir=Direction.LU;
    else if(!bL&&bU&&!bR&&!bD) dir=Direction.U;
    else if(!bL&&bU&&bR&&!bD) dir=Direction.RU;
    else if(!bL&&!bU&&bR&&!bD) dir=Direction.R;
    else if(!bL&&!bU&&bR&&bD) dir=Direction.RD;
    else if(!bL&&!bU&&!bR&&bD) dir=Direction.D;
    else if(bL&&!bU&&!bR&&bD) dir=Direction.LD;
    else if(!bL&&!bU&&!bR&&!bD) dir=Direction.STOP;
  }
   
  void move(){ //移动
    /*记录上一步的位置*/
    oldX = x;
    oldY = y;
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
    /*判断坦克移动越界情况（游戏边界）*/
    if(x < 5)  x = 5;
    if(y < 25)  y = 25;
    if(x+Whith > tc.GAME_WIDTH-5)  x = tc.GAME_WIDTH-Whith-5;
    if(y+Higth > tc.GAME_HEIGTH-5) y = tc.GAME_HEIGTH-Higth-5;
     
    if(dir != Direction.STOP)  //如果坦克不静止就改变炮筒方向
      ptDir = dir;
     
    /*敌方坦克自动移动*/
    if(!good){
      Direction[] dirs = Direction.values();  //将方向变量设为数组
      if(step == 0){
        step = r.nextInt(12)+3;  //随机移动步骤
        int randomNumber = r.nextInt(dirs.length);  //随机移动方向
        dir = dirs[randomNumber];
      }
      step--;
      if(r.nextInt(40)>30) this.fire();  //随机是否发射炮弹
    }
  }
  /*敌方坦克复活*/
  public void fuhuo(){
    if(tc.tanks.size() < 20)
      while(true){
        int x = r.nextInt(700);
        int y = r.nextInt(500);
        Tank t = new Tank(x,y,false,Color.blue,Direction.D,tc);
        /*如果坦克与墙重合则重新随机位置直到不重合为止才将新坦克加入集合*/
        if(t.getRect().intersects(tc.wall1.getRect())||t.getRect().intersects(tc.wall2.getRect())
            ||t.getRect().intersects(tc.wall3.getRect())
            ||t.getRect().intersects(tc.wall4.getRect())){
          continue;
        }
        else{
          tc.tanks.add(t);
          break;
        }
    }
  }
  /*子弹发射*/
  public void fire(){
    int x = this.x + Whith/2 - Missile.Whith/2;  //控制子弹方向为坦克中间
    int y = this.y + Higth/2 - Missile.Higth/2;
    tc.missiles.add(new Missile(ptDir,color,x,y,good,tc)); //创建新的子弹类加入到子弹集合中
  }
  /*碰撞；获取坦克的范围*/
  public Rectangle getRect(){
    return new Rectangle(x,y,Whith,Higth);
  }
  /*回执上一步位置*/
  private void stay(){
    x = oldX;
    y = oldY;
  } 
  /*如果撞墙，调用stay方法，返回上一步位置*/
  public boolean hitWall(Wall w){ 
    if(this.live&&this.getRect().intersects(w.getRect())){
      this.stay();
      return true;
    }
    return false;
  }
  /*坦克互相撞击事件*/
  public boolean hitTanks(List<Tank> tanks){ 
    for(int i=0;i<tanks.size();i++){
      Tank t=tanks.get(i);
      if(this!=t){//自己与自己不可相撞
        /*如果相撞返回上一步位置*/
        if(this.live&&t.isLive()&&this.getRect().intersects(t.getRect())){
          this.stay();
          t.stay();
          return true;
        }
      }
    }
    return false;
  }
  /*带开火方向的发射函数*/
  public Missile fire(Direction dir){
    if(!live) return null;
    int x=this.x+Whith/2-Missile.Whith/2;
    int y=this.y+Higth/2-Missile.Higth/2;
    Missile m=new Missile(dir,color,x, y,good, this.tc);
    tc.missiles.add(m);
    return m;
  }
  /*超级射击导弹*/
  private void superFire(){
    Direction[] dirs=Direction.values();
    for(int i=0;i<8;i++){
      fire(dirs[i]);//循环调用八个方向
    }
  }
  /*新增血块类*/
  private class BloodBar{
    /*画血条*/
    public void draw(Graphics g){
      Color c=g.getColor();
      g.setColor(Color.red);
      g.drawRect(x, y-10, Whith, 10);
      int w=Whith*Life/100;
      g.fillRect(x, y-10, w, 10);
      g.setColor(c);
    }
  }
  /*吃血方法*/
  public boolean eatBlood(Blood b){
    if(this.live&&b.isLive()&&this.isGood()&&this.getRect().intersects(b.getRect())){
      this.setLife(100);
      b.setLive(false);
      return true;
    }
    if(this.getRect().intersects(tc.wb.getRect()))
      this.Life = 100;
    return false;
  }
}
