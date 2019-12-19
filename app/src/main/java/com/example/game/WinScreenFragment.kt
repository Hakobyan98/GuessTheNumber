package com.example.game

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.game.databinding.FragmentWinScreenBinding

class WinScreenFragment : Fragment() {
    lateinit var binding : FragmentWinScreenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_win_screen,container,false)

        binding.startAgainButton.setOnClickListener { view:View ->
            view.findNavController().navigate(WinScreenFragmentDirections
                .actionWinScreenFragmentToGameScreenFragment(WinScreenFragmentArgs.fromBundle(arguments!!).winner))
        }

        binding.winningNumber.setText("Winning number is ${WinScreenFragmentArgs.fromBundle(arguments!!).numb}")
        binding.congratsText.setText("Congrats!! ${WinScreenFragmentArgs.fromBundle(arguments!!).winner}")

        return binding.root
    }

}
