package com.example.mysplash

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.mysplash.databinding.SplashActivityBinding

class SplashActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        val splashActivityBinding = SplashActivityBinding.inflate(layoutInflater)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }else {
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        setContentView(splashActivityBinding.root)

        val splashAnimation = AnimationUtils.loadAnimation(this,R.anim.animation)
        splashActivityBinding.imageView.animation= splashAnimation
        splashAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {

                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()

            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })
        val splashAnimationTrash = AnimationUtils.loadAnimation(this,R.anim.animation_trash)
        splashActivityBinding.imageView2.animation=splashAnimationTrash


    }
}


