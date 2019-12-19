package com.example.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.game.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {
    lateinit var binding : FragmentGameOverBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_game_over,container,false)

        binding.startAgainButton.setOnClickListener { view:View->
            view.findNavController().navigate(GameOverFragmentDirections
                .actionGameOverFragmentToGameScreenFragment(GameOverFragmentArgs.fromBundle(arguments!!).user))
        }

        binding.youLostText.setText("You Lost ${GameOverFragmentArgs.fromBundle(arguments!!).user}")
        return binding.root
    }
}
