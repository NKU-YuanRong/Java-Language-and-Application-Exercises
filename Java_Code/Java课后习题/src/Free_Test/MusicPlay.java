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
               //��������Ŀ�ﴴ��һ��Source folder�����������ļ��ŵ��������,�ٰ�·������
               File f = new File(url); //url���������·����
               cb = f.toURL();
               aau = Applet.newAudioClip(cb);

           } catch (MalformedURLException e) {
               
               e.printStackTrace();
           }
       }
       //�������ֵķ���,�����������Ҫ��һ��int����
       public void musicMain(int n) {
           //��switchѭ��
           switch (n) {
           //�����1�Ϳ�ʼ����
           case 1:
               aau.play();
               break;
           //�����2,��ֹͣ����
           case 2:
               aau.stop();
               break;
           case 3:
               //ѭ������
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
