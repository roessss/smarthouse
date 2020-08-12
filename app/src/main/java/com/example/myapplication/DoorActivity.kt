package com.example.myapplication

import android.graphics.Bitmap
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.lifecycleScope
import coil.Coil
import coil.request.GetRequest
import com.example.myapplication.web.WebClient
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.SocketTimeoutException

class DoorActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val photo = intent.getStringExtra("photo")
        val iv = findViewById<ImageView>(R.id.imageView)
        val btn = findViewById<Button>(R.id.button)
        lifecycleScope.launch{
            iv.setImageBitmap(getBitmap(photo ?: return@launch))
        }
        btn.setOnClickListener{
            openDoor()
        }
    }
    suspend fun getBitmap(url: String): Bitmap? {
        val request = GetRequest.Builder(this)
            .data(url)
            .build()
        val result = Coil.imageLoader(this).execute(request).drawable
        return result?.toBitmap(result.intrinsicWidth, result.intrinsicHeight)
    }
    fun openDoor(){

        lifecycleScope.launch {
            try {
                WebClient.setOpenDoorState()
            }catch (ex: HttpException){
                Toast.makeText(this@DoorActivity, "Error ${ex.code()}", Toast.LENGTH_SHORT).show()
            }catch (timeout: SocketTimeoutException){
                Toast.makeText(this@DoorActivity, "Timeout!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}