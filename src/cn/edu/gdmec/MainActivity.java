package cn.edu.gdmec;

import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
	private ImageView imageView;
	
	private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.imageView);
        
        handler=new Handler(){
        	public void handlerMessage(android.os.Message msg) {
				// TODO Auto-generated method stub
        		int imageResource = (Integer) msg.obj;
        		imageView.setImageResource(imageResource);
			};
        };
    }
    public void doClick(View v){
    	//1.工作线程中执行下载
    	new Thread(){
    		public void run(){
    			try{
    				Thread.sleep(3000);
    			}catch (InterruptedException e){
    				e.printStackTrace();
    			}
    			Message msg=Message.obtain();
    			msg.obj=R.drawable.ic_launcher;
    			//
    			handler.sendMessage(msg);
    			
    		}
    		
    	}.start();
    }

  
}
