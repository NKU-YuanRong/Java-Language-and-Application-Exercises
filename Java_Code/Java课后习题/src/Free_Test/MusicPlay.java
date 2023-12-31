package Free_Test;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MusicPlay {

    private AudioClip aau;
    private String url;
    
    
    public MusicPlay(String url){
    	this.url=url;
        playMusic();
     
    }
       public  void playMusic(){
           try {
               URL cb;
               //可以在项目里创建一个Source folder包，将音乐文件放到这个包里,再把路径给它
               File f = new File(url); //url这里放音乐路径。
               cb = f.toURL();
               aau = Applet.newAudioClip(cb);

           } catch (MalformedURLException e) {
               
               e.printStackTrace();
           }
       }
       //控制音乐的方法,调用这个方法要给一个int参数
       public void musicMain(int n) {
           //用switch循环
           switch (n) {
           //如果是1就开始播放
           case 1:
               aau.play();
               break;
           //如果是2,就停止播放
           case 2:
               aau.stop();
               break;
           case 3:
               //循环播放
               aau.loop();
               break;
           default:
               break;
           }
       }
       public static void main(String[] args) {
		MusicPlay mp = new MusicPlay("D:\\ChessingSound2.wav");
		mp.playMusic();
	}
}
