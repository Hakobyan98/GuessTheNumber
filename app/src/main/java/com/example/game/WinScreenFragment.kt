package com.example.game

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.game.databinding.FragmentWinScreenBinding
import kotlinx.android.synthetic.main.fragment_registration.*
import kotlinx.android.synthetic.main.fragment_win_screen.*

class WinScreenFragment : Fragment() {

    val args = WinScreenFragmentArgs.fromBundle(arguments!!)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentWinScreenBinding>(inflater,
            R.layout.fragment_win_screen,container,false)

        binding.startAgainButton.setOnClickListener { view:View->
            view.findNavController().navigate(R.id.action_winScreenFragment_to_gameScreenFragment)
        }

        binding.congratsText.text = args.winner
        Toast.makeText(context,"number was ${args.numb}",Toast.LENGTH_SHORT).show()
        return binding.root
    }
}
