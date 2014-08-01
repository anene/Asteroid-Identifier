package com.example.science_fairapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity  {
	private ImageView hImageViewPic;
	private Button iButton, gButton;
	private Button sButton;
	private TextView tf;
	private TextView tf2;
	
	RelativeLayout mRelativeLayoutMain;
	
	private int currentImage = 0;
	private double positionX = 0.0;
	private double positionY = 0.0;
	int images[] = { R.drawable.ic_launcher, R.drawable.image1,
			R.drawable.image2, R.drawable.image3, R.drawable.image4,
			R.drawable.image5, R.drawable.image6, R.drawable.image7,
			R.drawable.image8, R.drawable.image9, R.drawable.image10,
			R.drawable.image11, R.drawable.image12, R.drawable.image13,
			R.drawable.image14, R.drawable.image15, R.drawable.image16,
			R.drawable.image17, R.drawable.image18, R.drawable.image19,
			R.drawable.image20, R.drawable.image21, R.drawable.image22,
			R.drawable.image23, R.drawable.image24, R.drawable.image25};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tf2 = (TextView)findViewById(R.id.textView2);
		tf2.setText("To Submit: http://goo.gl/6qr4km");
		
		hImageViewPic = (ImageView)findViewById(R.id.imageView1);
		iButton = (Button)findViewById(R.id.button2);
		gButton = (Button)findViewById(R.id.button1);
		sButton = (Button)findViewById(R.id.button3);

        iButton.setOnClickListener(iButtonChangeImageListener);
        gButton.setOnClickListener(gButtonChangeImageListener);
        sButton.setOnClickListener(sButtonUpdateImageListener);
        
//        mRelativeLayoutMain = (RelativeLayout) findViewById(R.layout.activity_main);
//        mRelativeLayoutMain.setOnTouchListener(this);
        
    }
	OnClickListener sButtonUpdateImageListener = new OnClickListener() {
		
		public void onClick (View v) {
			
			tf = (TextView) findViewById(R.id.textView1);
			tf.setText("Image : " + currentImage + " Postion X: "  + positionX + " Postion Y: " + positionY); 
			
		}
	};
    OnClickListener iButtonChangeImageListener = new OnClickListener() {

        public void onClick(View v) {
            //Increase Counter to move to next Image
            currentImage++;
            currentImage = currentImage % images.length;

            hImageViewPic.setImageResource(images[currentImage]);

        }
    };

    View.OnClickListener gButtonChangeImageListener = new OnClickListener() {

        public void onClick(View v) {
            //Increase Counter to move to next Image
            currentImage--;
            currentImage = (currentImage + images.length) % images.length;

            hImageViewPic.setImageResource(images[currentImage]);

        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // MotionEvent object holds X-Y values
//    	Path path = new Path();
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            positionX = event.getX();
            positionY = event.getY();
        }
 
        return super.onTouchEvent(event);
    }

    
}