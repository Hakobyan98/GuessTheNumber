package com.example.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.game.databinding.FragmentGameScreenBinding
import kotlinx.android.synthetic.main.fragment_registration.*
import java.util.*

class GameScreenFragment : Fragment() {

    lateinit var binding:FragmentGameScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_game_screen,container,false)

        binding.okButton.setOnClickListener { okButtonClick(it)}
        return binding.root
    }

    private fun okButtonClick(view:View){
        val randomInt = Random().nextInt(5) + 1
        val number = binding.numberEdit.text.toString().toInt()
        if(number == randomInt){
            view.findNavController().navigate(GameScreenFragmentDirections.
                Action_gameScreenFragment_to_winScreenFragment(randomInt.toString(),
                GameScreenFragmentArgs.fromBundle(arguments!!).username.toString()))
        }
        else{
            view.findNavController().navigate(GameScreenFragmentDirections.
                Action_gameScreenFragment_to_gameOverFragment(randomInt.toString()))
        }
    }
}