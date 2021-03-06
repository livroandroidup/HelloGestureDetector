package br.com.up.hellogesturedetector;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author rlecheta
 * 
 */
public class MyImageView extends View {
	private Drawable mIcon;
	private float scaleFactor = 1;

	public MyImageView(Context context) {
		super(context);

		init(context);
	}

	public MyImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public MyImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		mIcon = context.getResources().getDrawable(R.drawable.ic_launcher);
		mIcon.setBounds(0, 0, mIcon.getIntrinsicWidth(), mIcon.getIntrinsicHeight());
	}

	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// canvas.save();
		// // canvas.translate(mPosX, mPosY);
		canvas.scale(scaleFactor, scaleFactor);
		mIcon.draw(canvas);
		// canvas.restore();
	}

	public void setScaleFactor(float scaleFactor) {
		this.scaleFactor = scaleFactor;
	}
}
