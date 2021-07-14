package me.riverz.tank.v1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
 
import javax.swing.JFrame;
 
/**
 * @ClassName: TankClient 
 * @author rivers
 * @date 2017年11月18日 下午7:58:25
 * @Description:利用Java语言中的集合、Swing、线程等知识点编写一个坦克大战游戏。
（1） 画出敌我坦克的原理：
在坦克类里面有一个布尔类型变量good。用于判断坦克的阵营，在创建坦克对象时在Tank类的构造方法中传入good的值。在画坦克的时候判断good的值，区分敌我坦克的颜色；
（2） 坦克运动的原理：
在坦克类里写入了监听键盘摁键的响应事件，对监听到的上下左右键进行记录，并合成坦克移动的八个方向的变量。之后对应每个方向的不同对坦克坐标x，y的值做响应的更改实现我方坦克的移动。而敌方坦克则自动移动，通过随机数对敌方坦克移动方向的随机，并且随机出每次移动的次数。两个随机值相结合即实现了敌方坦克的移动。
（3） 坦克发射子弹的原理：
通过键盘监听，检测到发射子弹命令后将主类的子弹类集合中添加一个子弹类。将炮筒的方向以及坦克的位置以及坦克的阵营传入给子弹类，
在主类paint画方法中一直循环子弹类集合，如果集合内有子弹，就画出来。这样就实现了发射子弹。
（4） 坦克、子弹、墙的碰撞原理：
在坦克类子弹类墙类中分别getRect方法获取自身的范围，然后在每次画坦克、子弹时都会进行相应的碰撞检测（在坦克类里有与墙和出自己外的坦克相撞的处理方法、在子弹类里有与墙和坦克相碰撞的处理方法。），如果自身与不该碰撞的物体的范围相重合，则代表两物体相撞。
（5）坦克加血的原理：
 在血块类中有血块与我方坦克相碰撞的处理方法，如果血块范围与坦克范围重合则血块类死亡，并且坦克类的血量回复置满。
（6）坦克复活的原理：
通过键盘监听，检测到我方坦克复活命令后，如果我方坦克处于死亡状态，则将我方坦克存货状态改为活着并且将我方坦克血量回置满血。 
编程思想：
坦克大战的编程思想在主类开启一个线程，没50毫秒循环一次画方法（绘制整个界面内的所有东西）。画的东西有敌我坦克（颜色区分）、子弹、墙、血块、爆炸。
所以总共写出了几个类：Tank坦克类、Missile子弹类、Wall墙类、Blood血块类、TankClient主类。在每一个类中均写有画方法实现本类属性的绘制功能。
在主类中有键盘监听事件调用这Tank类的键盘监听事件。通过键盘监听判断出对Tank做出相应的移动，而敌方Tank则是随机运动。
并且每次刷新都有调用各类的碰撞方法，判断一些不该碰撞的对象的情况时做出处理。而每个对象的创建例如子弹这些是在触发产生之后将新建子弹类加入一个子弹类集合之中，
在绘制的时候判断集合中的数量进行绘制，出界或者打死坦克则在集合中删除。其他类也均相似，不在细说。
 代码中每步都注释有相应的解释。 
 */
public class TankClient extends JFrame{
  /**
   * @param args
   */
  Image OffScrennImage = null;  //双缓冲内存图片存储
  /*游戏大小*/
  public static final int GAME_WIDTH = 800;  //界面宽
  public static final int GAME_HEIGTH = 600;  //界面高
   
  Tank myTank = new Tank(500,400,true,Color.red,Tank.Direction.STOP, this);//我方坦克类
  List<Missile> missiles = new ArrayList<Missile>();//子弹的集合
  List<Explode> explode = new ArrayList<Explode>();//爆炸集合
  List<Tank> tanks = new ArrayList<Tank>();  //坦克集合
  Wall wall1 = new Wall(150,200,20,300,this);  //墙1
  Wall wall2 = new Wall(250,500,300,20,this);  //墙2
  Wall wall3 = new Wall(650,200,20,300,this);  //墙2
  Wall wall4 = new Wall(250,300,300,20,this);  //墙2
  Wall wb = new Wall(750,550,40,40,this);  //墙2
  Blood b = new Blood();  //血类
   
   
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    TankClient tc=new TankClient();
    tc.lauchFrame();
  }
 
  private void lauchFrame() {
    // TODO Auto-generated method stub
    for (int i = 0; i < 10; i++){
      tanks.add(new Tank(50+40*(i+1), 50, false,Color.blue,Tank.Direction.D, this));
    }
    this.setLocation(100, 100);  //窗口初始坐标点
    this.setSize(GAME_WIDTH, GAME_HEIGTH);    //窗口初始大小
    this.setTitle("TankWar");  //窗口名称
    /*窗口监听*/
    this.addWindowListener(new WindowAdapter() {
      @Override
      /*点退出叉之后运行*/
      public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        System.exit(0);  //退出
      }
    });
    this.addKeyListener(new KeyMoniton());  //设置键盘监听
    this.setVisible(true);  //设置窗口显现
    this.setResizable(false);  //设置窗口不可改变大小
    this.getContentPane().setBackground(Color.green);  //设置窗口前景色为绿色
    new Thread(new PaintThread()).start();  //开始运行PaintThread类run
  }
 
  @Override
  public void paint(Graphics g) {
    // TODO Auto-generated method stub
    //Graphics为画笔类
    super.paint(g);
    myTank.draw(g);
    wall1.draw(g);
    wall2.draw(g);
    wall3.draw(g);
    wall4.draw(g);
    wb.draw(g);
    b.draw(g);
    myTank.eatBlood(b);
    myTank.hitWall(wall1);
    myTank.hitWall(wall2);
    myTank.hitWall(wall3);
    myTank.hitWall(wall4);
    /*循环子弹集合*/
    for (int i = 0; i < missiles.size(); i++){
      Missile m = missiles.get(i);  //获取当前子弹
      m.hitTanks(tanks);  //自己子弹打死敌方坦克
      m.hitWall(wall1);  //子弹与墙
      m.hitWall(wall2);
      m.hitWall(wall3);
      m.hitWall(wall4);
      m.hitTank(myTank);//敌人子弹打击自己的坦克
      m.draw(g);  //画子弹
    }
    for  (int i = 0; i < explode.size(); i++){
      explode.get(i).draw(g);  //画爆炸
    }
    for (int i = 0; i < tanks.size(); i++){
      Tank t = tanks.get(i);
      t.draw(g);  //画敌方坦克
      t.hitTanks(tanks);
      t.hitWall(wall1);  //坦克与墙
      t.hitWall(wall2);
      t.hitWall(wall3);
      t.hitWall(wall4);
    }
    //g.setFont(new Font("宋体",Font.BOLD,20));
    g.drawString("missiles count:"+missiles.size(), 10, 50);//显示
    g.drawString("explode count:"+explode.size(), 10, 80);//显示
    g.drawString("tanks count:"+tanks.size(),10, 110);
    g.drawString("myTank Life:"+myTank.getLife(), 10, 130);
    g.drawString("回血:", 750, 540);
    g.drawString("方向键移动方向；E:释放移动血快", 10, 590);
    g.drawString("z：发射东风-31；a：发射东风-41;", 10, 570);
    g.drawString("F2：复活；F3：敌方复活（对多20）", 10, 550);
    g.drawString("R：位置还原;Q:血量加满", 10, 530);
  }
   
  @Override
  /*repaint-〉update->paint*/
  public void update(Graphics g) {
    // TODO Auto-generated method stub
    super.update(g);
    if(OffScrennImage == null)
      OffScrennImage = this.createImage(GAME_WIDTH, GAME_HEIGTH);
    Graphics goffscrenn = OffScrennImage.getGraphics();  //设置一个内存画笔颜色为前景图片颜色
    Color c = goffscrenn.getColor();  //还是先保存前景颜色
    goffscrenn.setColor(Color.green);  //设置内存画笔颜色为绿色
    goffscrenn.fillRect(0, 0, GAME_WIDTH, GAME_HEIGTH);  //画成图片，大小为游戏大小
    goffscrenn.setColor(c);  //还原颜色
    g.drawImage(OffScrennImage, 0, 0, null);  //在界面画出保存的图片
    paint(goffscrenn);  //把内存画笔调用给paint
  }
 
  private class PaintThread implements Runnable{
 
    @Override
    public void run() {
      // TODO Auto-generated method stub
      while(true){
        repaint();  //运行顺序repaint->update->paint
        try{
          Thread.sleep(50);  //每隔50毫秒刷新画面一次
        }catch(InterruptedException e){
          e.printStackTrace();
        }
      }
    }
     
  }
  /*键盘响应*/
  private class KeyMoniton extends KeyAdapter{
 
    /*摁下键盘响应*/
    @Override
    public void keyPressed(KeyEvent e) {
      // TODO Auto-generated method stub
      super.keyPressed(e);
      myTank.KeyPressed(e);
    }
    /*抬起键盘响应*/
    @Override
    public void keyReleased(KeyEvent e) {
      // TODO Auto-generated method stub
      super.keyReleased(e);
      myTank.keyReleased(e);
    }
     
  }
}