package com.example.animationdemo;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {

    Animation animFadeIn;
    Animation animFadeOut;
    Animation animFadeInOut;
    Animation animZoomIn;
    Animation animZoomOut;
    Animation animLeftRight;
    Animation animRightLeft;
    Animation animTopBottom;
    Animation animBounce;
    Animation animFlash;
    Animation animRotateLeft;
    Animation animRotateRight;

    ImageView imageView;
    TextView textStatus;
    Button btnFadeIn;
    Button btnFadeOut;
    Button btnFadeInOut;
    Button btnZoomIn;
    Button btnZoomOut;
    Button btnLeftRight;
    Button btnRightLeft;
    Button btnTopBottom;
    Button btnBounce;
    Button btnFlash;
    Button btnRotateLeft;
    Button btnRotateRight;
    SeekBar seekBarSpeed;
    TextView textSeekerSpeed;
    int seekSpeedProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        //    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        //    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        //    return insets;
        //});
        loadAnimations();
        loadUI();
    }

    private void loadAnimations() {
        animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        animFadeIn.setAnimationListener(this);
        animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        animFadeInOut = AnimationUtils.loadAnimation(this, R.anim.fade_in_out);
        animZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        animZoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        animLeftRight = AnimationUtils.loadAnimation(this, R.anim.left_right);
        animRightLeft = AnimationUtils.loadAnimation(this, R.anim.right_left);
        animTopBottom = AnimationUtils.loadAnimation(this, R.anim.top_bot);
        animBounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        animFlash = AnimationUtils.loadAnimation(this, R.anim.flash);
        animRotateLeft = AnimationUtils.loadAnimation(this, R.anim.rotate_left);
        animRotateRight = AnimationUtils.loadAnimation(this, R.anim.rotate_right);

    }

    private void loadUI() {
        imageView = findViewById(R.id.imageView);
        textStatus = findViewById(R.id.textStatus);
        btnFadeIn = findViewById(R.id.btnFadeIn);
        btnFadeOut = findViewById(R.id.btnFadeOut);
        btnFadeInOut = findViewById(R.id.btnFadeInOut);
        btnZoomIn = findViewById(R.id.btnZoomIn);
        btnZoomOut = findViewById(R.id.btnZoomOut);
        btnLeftRight = findViewById(R.id.btnLeftRight);
        btnRightLeft = findViewById(R.id.btnRightLeft);
        btnTopBottom = findViewById(R.id.btnTopBottom);
        btnBounce = findViewById(R.id.btnBounce);
        btnFlash = findViewById(R.id.btnFlash);
        btnRotateLeft = findViewById(R.id.btnRotateLeft);
        btnRotateRight = findViewById(R.id.btnRotateRight);

        btnFadeIn.setOnClickListener(this);
        btnFadeOut.setOnClickListener(this);
        btnFadeInOut.setOnClickListener(this);
        btnZoomIn.setOnClickListener(this);
        btnZoomOut.setOnClickListener(this);
        btnLeftRight.setOnClickListener(this);
        btnRightLeft.setOnClickListener(this);
        btnTopBottom.setOnClickListener(this);
        btnBounce.setOnClickListener(this);
        btnFlash.setOnClickListener(this);
        btnRotateLeft.setOnClickListener(this);
        btnRotateRight.setOnClickListener(this);

        seekBarSpeed = findViewById(R.id.seekBarSpeed);
        textSeekerSpeed = findViewById(R.id.textSeekerSpeed);

        seekBarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser) {
                seekSpeedProgress = value;
                textSeekerSpeed.setText("" + seekSpeedProgress + " of " + seekBarSpeed.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    @Override
    public void onAnimationEnd(Animation animation) {
        textStatus.setText("STOPPED");
    }
    @Override
    public void onAnimationRepeat(Animation animation) {
    }
    @Override
    public void onAnimationStart(Animation animation) {
        textStatus.setText("RUNNING");
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnFadeIn) {
            animFadeIn.setDuration(seekSpeedProgress);
            animFadeIn.setAnimationListener(this);
            imageView.startAnimation(animFadeIn);
        } else if (v.getId() == R.id.btnFadeOut) {
            animFadeOut.setDuration(seekSpeedProgress);
            animFadeOut.setAnimationListener(this);
            imageView.startAnimation(animFadeOut);
        } else if (v.getId() == R.id.btnFadeInOut) {
            animFadeInOut.setDuration(seekSpeedProgress);
            animFadeInOut.setAnimationListener(this);
            imageView.startAnimation(animFadeInOut);
        } else if (v.getId() == R.id.btnZoomIn) {
            animZoomIn.setDuration(seekSpeedProgress);
            animZoomIn.setAnimationListener(this);
            imageView.startAnimation(animZoomIn);
        } else if (v.getId() == R.id.btnZoomOut) {
            animZoomOut.setDuration(seekSpeedProgress);
            animZoomOut.setAnimationListener(this);
            imageView.startAnimation(animZoomOut);
        } else if (v.getId() == R.id.btnLeftRight) {
            animLeftRight.setDuration(seekSpeedProgress);
            animLeftRight.setAnimationListener(this);
            imageView.startAnimation(animLeftRight);
        } else if (v.getId() == R.id.btnRightLeft) {
            animRightLeft.setDuration(seekSpeedProgress);
            animRightLeft.setAnimationListener(this);
            imageView.startAnimation(animRightLeft);
        } else if (v.getId() == R.id.btnTopBottom) {
            animTopBottom.setDuration(seekSpeedProgress);
            animTopBottom.setAnimationListener(this);
            imageView.startAnimation(animTopBottom);
        } else if (v.getId() == R.id.btnBounce) {
            animBounce.setDuration(seekSpeedProgress / 10);
            animBounce.setAnimationListener(this);
            imageView.startAnimation(animBounce);
        } else if (v.getId() == R.id.btnFlash) {
            animFlash.setDuration(seekSpeedProgress / 10);
            animFlash.setAnimationListener(this);
            imageView.startAnimation(animFlash);
        } else if (v.getId() == R.id.btnRotateLeft) {
            animRotateLeft.setDuration(seekSpeedProgress);
            animRotateLeft.setAnimationListener(this);
            imageView.startAnimation(animRotateLeft);
        } else if (v.getId() == R.id.btnRotateRight) {
            animRotateRight.setDuration(seekSpeedProgress);
            animRotateRight.setAnimationListener(this);
            imageView.startAnimation(animRotateRight);
        }
    }
}