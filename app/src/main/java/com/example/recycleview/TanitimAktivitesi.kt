package com.example.recycleview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recycleview.databinding.ActivityMainBinding
import com.example.recycleview.databinding.ActivityTanitimAktivitesiBinding

class TanitimAktivitesi : AppCompatActivity() {
    private lateinit var binding: ActivityTanitimAktivitesiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTanitimAktivitesiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_tanitim_aktivitesi)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //val adapterdenGelenIntent = intent
        //adapterdenGelenIntent.getSerializableExtra("secilenKahraman",superkahraman::class.java)//yeni hali buyuk ihtimalle su an gayet iyi
        //val secilenKahraman= adapterdenGelenIntent.getSerializableExtra("secilenKahraman")as superkahraman

        //binding.imageView.setImageResource(secilenKahraman.resim)
       // binding.isimTextView.text = secilenKahraman.isim
       // binding.meslekTextView.text = secilenKahraman.meslek
        val secilenKahraman = MySingleton.secilenSuperKahraman
        secilenKahraman?.let{
            binding.imageView.setImageResource((secilenKahraman.resim))
            binding.isimTextView.text = secilenKahraman.isim
            binding.meslekTextView.text = secilenKahraman.meslek

        }

    }
}