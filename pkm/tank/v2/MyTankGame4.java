package me.riverz.tank.v2;

//MyTankGame4.java
/*
 * 功能：坦克游戏2.0
 * 1: 画出坦克
 * 2：我的坦克可以上下移动
 * 3: 画出敌人坦克
 * 4: 我的坦克可以发子弹 
 * 5：子弹可以连发(最多可以连发五颗)
 * 6: 当我的坦克击中敌人坦克时候，敌人消失（爆炸
 *       『 判断子弹是否击中坦克；什么时候调用；』
 *       爆炸：1先准备三张图；2定义Bomb类；3在击中敌人坦克时放入炸弹Vector 4绘制
 * 7: 敌人坦克在我规定范围移动
 * 8：敌人坦克也能发子弹
 * 9: 当敌人坦克击中我的坦克，我的坦克消失
 */
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
public class MyTankGame4 extends JFrame{
	MyPanel mp = null;
	public static void main(String[] args) {
		MyTankGame4 mytankgame1 = new MyTankGame4();
	}

	public MyTankGame4(){
		mp = new MyPanel(); 
		Thread t = new Thread(mp);
		t.start();
		this.add(mp);
		// 注册监听
		this.addKeyListener(mp);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
class MyPanel extends JPanel implements KeyListener,Runnable{

	//定义一个我的坦克
	Hero hero = null;

	//定义敌人的坦克
	Vector<EnemyTank> ets = new Vector<EnemyTank>();

	//定义一个炸弹的集合
	Vector<Bomb> bombs = new Vector<Bomb>();

	//敌人坦克多少
	int enSize = 3;
	//
	//定义三张图片的图片的切换，才能组成一颗炸弹
	Image image1 = null;
	Image image2 = null;
	Image image3 = null;

	//构造
	public MyPanel(){
		hero = new Hero(100,100);
		// 敌人的坦克初始化
		for(int i = 0; i <enSize; i++)
		{
			//   创建敌人的坦克对象
			EnemyTank et = new EnemyTank((i+1)*50, 0);
			et.setColor(0);
			et.setDirect(2);
			//   启动敌人坦克
			Thread t = new Thread(et);
			t.start();

			//   给敌人坦克谈价一颗子弹
			Shot s = new Shot(et.x+10,et.y+30,2);
			et.ss.add(s);
			Thread t2 = new Thread(s);
			t2.start();

			//   加入
			ets.add(et);
		}
		try{
			image1 = ImageIO.read(new File("bomb_1.gif"));
			image2 = ImageIO.read(new File("bomb_2.gif"));
			image3 = ImageIO.read(new File("bomb_3.gif"));

		}catch(Exception e){
			e.printStackTrace();
		}
		// 初始化三张图片
		// image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
		// image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
		// image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));


	}

	//重新paint
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0, 400, 300);

		// 画出自己的坦克
		if(hero.isLive==true)
		{
			this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 1);
		}

		// 从ss中取出每一颗子弹，并绘制
		for(int i = 0; i <hero.ss.size(); i++)
		{
			//   取出子弹
			Shot myShot = hero.ss.get(i);
			// 画出子弹 画出一颗子弹，怎么画出多子弹？遍历
			if(myShot!=null&&myShot.isLive==true)
			{
				g.draw3DRect(myShot.x, myShot.y, 1, 1, false);
			}
			if(myShot.isLive==false)
			{
				//     从ss向量中删除该子弹
				hero.ss.remove(myShot);
			}
		}

		// 画出炸弹
		for(int i = 0; i < bombs.size();i++)
		{
			Bomb b = bombs.get(i);
			if(b.life > 6)
			{
				g.drawImage(image1, b.x, b.y,30,30, this);
			}else if(b.life>4)
			{
				g.drawImage(image2, b.x, b.y,30,30, this);
			}else{
				g.drawImage(image3, b.x, b.y,30,30, this);
			}
			//   让b的生命值减少
			b.lifeDown();
			//   如果炸弹生命值==0踢出去
			if(b.life == 0)
			{
				bombs.remove(b);
			}
		}


		// 画出敌人坦克
		for(int i = 0 ; i < ets.size(); i++)
		{
			EnemyTank et = ets.get(i);
			if(et.isLive)
			{
				this.drawTank(et.getX(), et.getY(), g,et.getDirect(), 0);
				//     画出敌人子弹
				for(int j = 0; j < et.ss.size();j++)
				{
					Shot enemyShot = et.ss.get(j);
					if(enemyShot.isLive)
					{
						g.draw3DRect(enemyShot.x, enemyShot.y, 1, 1, false);
					}else{
						//          敌人坦死亡了
						et.ss.remove(enemyShot);
					}

				}
			}
		}
	}

	//敌人子弹是否击我
	public void hitMe()
	{
		//取出每一个敌人坦克
		for(int i = 0; i < this.ets.size(); i++)
		{
			//   取出敌人坦克
			EnemyTank et = ets.get(i);
			if(et.isLive==true)
			{
				for(int j = 0; j < et.ss.size(); j++)
				{
					//       取出子弹
					Shot enemyShot = et.ss.get(j);
					if(enemyShot.isLive==true)
					{
						this.hitTank(enemyShot, hero);
					}
				}
			}
		}
	}

	//我的子弹是否击中敌人坦克
	public void hitEnemyTank()
	{
		// 判断是否击中敌人的坦克
		for(int i = 0; i < hero.ss.size(); i++)
		{
			Shot myShot = hero.ss.get(i);
			//   判断子弹是否有效
			if(myShot.isLive==true)
			{
				//     取出每一个坦克与它判断
				for(int j = 0; j < ets.size(); j++)
				{
					EnemyTank et = ets.get(j);
					if(et.isLive==true)
					{
						this.hitTank(myShot,et);
					}
				}
			}
		}
	}


	//写一个函数专门判断子弹是否击中坦克
	public void hitTank(Shot s, Tank et)
	{

		switch(et.direct)
		{
		//   如果敌人坦克方向是上或者是下
		case 0:
		case 2:
			if(s.x>et.x&&s.x<et.x+20&&s.y>et.y&&s.y<et.y+30)
			{
				//       击中死亡
				s.isLive = false;
				//       坦克死亡
				et.isLive = false;

				//       创建一颗炸弹，放入Vector
				Bomb b = new Bomb(et.x, et.y);
				bombs.add(b);
			}

		case 1:
		case 3:
			if(s.x>et.x&&s.x<et.x+30&&s.y>et.y&&s.y<et.y+20)
			{
				{
					//         击中死亡
					s.isLive = false;
					//         敌人坦克死亡
					et.isLive = false;
					Bomb b = new Bomb(et.x, et.y);
					bombs.add(b);
				}
			}
		} 
	}

	//画出坦克
	public void drawTank(int x , int y, Graphics g, int direct, int type)
	{
		// 坦克类型
		switch(type)
		{
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		// 坦克方向
		switch(direct)
		{
		//   向上
		case 0:
			//     画出左边坦克
			g.fill3DRect(x, y, 5, 30, false);
			//     画出右边坦克
			g.fill3DRect(x+15, y, 5, 30, false);
			//     画出中间矩形
			g.fill3DRect(x+5, y+5, 10, 20, false);
			//     画出原形
			g.fillOval(x+5, y+10, 10, 10);
			//     画出直线
			g.drawLine(x+10, y+15, x+10, y);
			break;
		case 1:
			//     向右
			//     画出上面矩形
			g.fill3DRect(x, y, 30, 5, false);
			//     画出下面矩形
			g.fill3DRect(x, y+15, 30, 5, false);
			//     画出中间矩形
			g.fill3DRect(x+5, y+5, 20, 10, false);
			//     画出圆形
			g.fillOval(x+10, y+5, 10, 10);
			//     画出线
			g.drawLine(x+15, y+10, x+30, y+10);
			break;
		case 2:
			//     画出下边坦克
			g.fill3DRect(x, y, 5, 30, false);
			//     画出右边坦克
			g.fill3DRect(x+15, y, 5, 30, false);
			//     画出中间矩形
			g.fill3DRect(x+5, y+5, 10, 20, false);
			//     画出原形
			g.fillOval(x+5, y+10, 10, 10);
			//     画出直线
			g.drawLine(x+10, y+15, x+10, y+30);
			break;
		case 3:
			//     向左边
			//     画出上面矩形
			g.fill3DRect(x, y, 30, 5, false);
			//     画出下面矩形
			g.fill3DRect(x, y+15, 30, 5, false);
			//     画出中间矩形
			g.fill3DRect(x+5, y+5, 20, 10, false);
			//     画出圆形
			g.fillOval(x+10, y+5, 10, 10);
			//     画出线
			g.drawLine(x+15, y+10, x, y+10);
			break;

		}

	}
	//对键摁下做出处理啊 a向左 s 向下 d向右 w向上 
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W)
		{
			this.hero.setDirect(0);
			this.hero.moveUP();
		}else if(e.getKeyCode()==KeyEvent.VK_D)
		{
			this.hero.setDirect(1);
			this.hero.moveRight();
		}else if(e.getKeyCode()==KeyEvent.VK_S)
		{
			this.hero.setDirect(2);
			this.hero.moveDown();
		}
		else if(e.getKeyCode()==KeyEvent.VK_A)
		{
			this.hero.setDirect(3);
			this.hero.moveLeft();
		}

		if(e.getKeyCode()==KeyEvent.VK_J)
		{ 
			//   判断玩家是否摁下J
			//     开火
			if(this.hero.ss.size()<=4&&this.hero.isLive==true)
			{
				this.hero.shotEnemy();
			}
		}

		// 必须重新绘制Panel
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void run(){
		while(true)
		{
			try{
				Thread.sleep(100);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			this.hitEnemyTank();
			//   函数判断敌人的子弹是否击中我
			this.hitMe();
			this.repaint();
		}
	}
}