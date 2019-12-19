package com.example.game

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
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


        binding.okButton.isEnabled = false
        binding.numberEdit.doAfterTextChanged {it ->
            binding.okButton.isEnabled = true
        }
        binding.okButton.setOnClickListener { okButtonClick(it) }
        return binding.root
    }

    private fun okButtonClick(view:View){
        val args = GameScreenFragmentArgs.fromBundle(arguments!!)
        val randomInt = Random().nextInt(3) + 1

        val number = binding.numberEdit.text.toString().toInt()
        if(number == randomInt){
            view.findNavController().navigate(GameScreenFragmentDirections.
            actionGameScreenFragmentToWinScreenFragment(number,args.username))
        }
        else{
            view.findNavController().navigate(
                GameScreenFragmentDirections.actionGameScreenFragmentToGameOverFragment(args.username))
        }
    }

}
