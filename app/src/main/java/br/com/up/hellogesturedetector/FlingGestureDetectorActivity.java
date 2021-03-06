package br.com.up.hellogesturedetector;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Detecta gesto de swipe lateral, para fazer scroll para os lados
 * 
 * @author Ricardo Lecheta
 *
 */
public class FlingGestureDetectorActivity extends Activity {

	private TextView text;
	private ImageView img;
	private GestureDetector gestureDetector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fling_gesture_detector);

		img = (ImageView) findViewById(R.id.img);
		text = (TextView) findViewById(R.id.text);
		text.setText("Faça um gesto");

		gestureDetector = new GestureDetector(this, new MyFlingGestureDetector());
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		boolean ok = gestureDetector.onTouchEvent(event);
		if(ok) {
			return super.onTouchEvent(event);
		}
		return ok;
	}

	class MyFlingGestureDetector extends SimpleOnGestureListener {
		private float swipeMinDistance = 100;
		private float swipeThreasholdVelocity = 200;

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			try {
				// right to left swipe
				if (e1.getX() - e2.getX() > swipeMinDistance && Math.abs(velocityX) > swipeThreasholdVelocity) {
					text.setText("<<< Left");
					
					mover(-100);
				} else if (e2.getX() - e1.getX() > swipeMinDistance && Math.abs(velocityX) > swipeThreasholdVelocity) {
					text.setText("Right >>>");
				
					mover(100);
				}
			} catch (Exception e) {
			}
			return false;
		}
	}
	
	private void mover(int x) {
		img.animate().setDuration(1000).xBy(x);
	}
}
