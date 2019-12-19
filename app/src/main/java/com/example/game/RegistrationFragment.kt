package com.example.game

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.game.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {
    lateinit var binding : FragmentRegistrationBinding

    override fun onCreateView(
                inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_registration, container, false
        )

        binding.startButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(RegistrationFragmentDirections.
                    actionRegistrationFragmentToGameScreenFragment(
                        binding.nameEdit.text.toString()))
        }

        return binding.root
    }
    
}
