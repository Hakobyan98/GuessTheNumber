package com.example.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.game.databinding.FragmentGameOverBinding
import kotlinx.android.synthetic.main.fragment_registration.*

class GameOverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGameOverBinding>(inflater,
            R.layout.fragment_game_over,container,false)

        binding.startAgainButton.setOnClickListener { view:View->
            view.findNavController().navigate(R.id.action_gameOverFragment_to_gameScreenFragment)
        }

        val args = GameOverFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context,"Number was ${args.num}",Toast.LENGTH_SHORT).show()

        return binding.root
    }

}
