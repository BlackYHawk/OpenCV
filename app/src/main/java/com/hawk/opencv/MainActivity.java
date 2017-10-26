package com.hawk.opencv;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hawk.opencv.opencv.OpenCVHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivPic;
    private Button btnGray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        ivPic = (ImageView) findViewById(R.id.ivPic);
        btnGray = (Button) findViewById(R.id.btnGray);
        btnGray.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(
                R.mipmap.head)).getBitmap();
        int w = bitmap.getWidth(), h = bitmap.getHeight();
        int[] pix = new int[w * h];
        bitmap.getPixels(pix, 0, w, 0, 0, w, h);
        int [] resultPixes= OpenCVHelper.gray(pix,w,h);
        Bitmap result = Bitmap.createBitmap(w,h, Bitmap.Config.RGB_565);
        result.setPixels(resultPixes, 0, w, 0, 0,w, h);
        ivPic.setImageBitmap(result);
    }
}
