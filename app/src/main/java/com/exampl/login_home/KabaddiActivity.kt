package com.exampl.login_home

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.exampl.login_home.databinding.ActivityKabaddiBinding

class KabaddiActivity : AppCompatActivity() {

    private lateinit var skorA: TextView
    private lateinit var skorB: TextView

    private lateinit var binding: ActivityKabaddiBinding
    private val viewModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_kabaddi)
        binding.lifecycleOwner = this
        binding.scoreViewModel = viewModel

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel.scoreA.observer(this, Observer { score ->
            binding.skorA.text = score.toString()
        })

        viewModel.scoreB.observer(this, Observer { score ->
            binding.skorB.text = score.toString()
        })


        // Deklasrasi + Inisialisasi
        binding.buttonPlus1A.setOnClickListener { viewModel.incrementSkorA() }
        binding.buttonPlus2A.setOnClickListener {
            viewModel.incrementSkorA()
            viewModel.incrementSkorA()
        }
        binding.buttonPlus1B.setOnClickListener { viewModel.incrementSkorB() }
        binding.buttonPlus2B.setOnClickListener {
            viewModel.incrementSkorB()
            viewModel.incrementSkorB()
        }

        binding.btnreset.setOnClickListener {
            resetSkor()
            skorA.setValuea(0)
            skorB.setValueb(0)
        }

    }
}