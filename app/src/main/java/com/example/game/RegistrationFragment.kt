package com.example.game


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.game.databinding.FragmentRegistrationBinding
import kotlinx.android.synthetic.main.fragment_registration.*

class RegistrationFragment : Fragment() {
    lateinit var binding : FragmentRegistrationBinding

    override fun onCreateView(
                inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
             binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_registration, container, false)

        binding.startButton.setOnClickListener { view: View ->
              view.findNavController()
                .navigate(RegistrationFragmentDirections.
                    Action_registrationFragment_to_gameScreenFragment(binding.nameEdit.text.toString()))
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,view!!.findNavController()) ||
                super.onOptionsItemSelected(item)
    }
}
