package com.guzya.lesson5_worke

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.media3.common.util.Log
import com.guzya.lesson5_worke.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var count = 0
    private var galleryImage: Bitmap? = null

    private val content = this.registerForActivityResult(ActivityResultContracts.GetContent()) {
        binding.ivGallery.setImageURI(it)
        galleryImage = binding.ivGallery.drawable.toBitmap()
        Log.e("TAG", galleryImage.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            val savedCount = savedInstanceState.getInt(COUNT_KEY)
            count = savedCount
            val imageBitmap = savedInstanceState.getParcelable<Bitmap>(GALLERY_KEY)
            galleryImage = imageBitmap
        }

        binding.tvCounter.text = count.toString()
        binding.ivGallery.setImageBitmap(galleryImage)
        openImage()
        setupCount()
    }

    private fun setupCount() = with(binding) {
        btnIncrement.setOnClickListener {
            if (count == 10) {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)
            } else {
                tvCounter.text = (++count).toString()
            }
        }

        btnDecrement.setOnClickListener {
            if (count != 0) {
            } else {
                tvCounter.text = (--count).toString()
            }
        }
    }

    private fun openImage() = with(binding) {
        ivGallery.setOnClickListener {
            content.launch("image/*")
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.apply {
            putInt(COUNT_KEY, count)
            putParcelable(GALLERY_KEY, galleryImage)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        const val COUNT_KEY = "count"
        const val GALLERY_KEY = "gallery"
    }
}