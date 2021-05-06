package com.canhub.cropper.sample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.canhub.cropper.sample.camera.app.SCameraFragment
import com.canhub.cropper.sample.camera_java.app.SCameraFragmentJava
import com.canhub.cropper.sample.crop_image_view.app.SCropImageViewFragment
import com.canhub.cropper.sample.extend_activity.app.SExtendActivity
import com.canhub.cropper.sample.extend_activity.app.SExtendActivityJava
import com.example.croppersample.R
import com.example.croppersample.databinding.ActivityMainBinding

internal class SMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.sampleCropImageView.setOnClickListener {
            hideButtons(binding)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, SCropImageViewFragment.newInstance())
                .commit()
        }

        binding.sampleCustomActivity.setOnClickListener {
            SExtendActivity.start(this)
        }

        binding.sampleCropImage.setOnClickListener {
            hideButtons(binding)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, SCameraFragment.newInstance())
                .commit()
        }

        binding.sampleCustomActivityJava.setOnClickListener {
            val intent = Intent(this, SExtendActivityJava::class.java)
            startActivity(intent)
        }

        binding.sampleCropImageJava.setOnClickListener {
            hideButtons(binding)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, SCameraFragmentJava.newInstance())
                .commit()
        }
    }

    private fun hideButtons(binding: ActivityMainBinding) {
        binding.image.visibility = View.GONE
        binding.buttons.visibility = View.GONE
    }
}
