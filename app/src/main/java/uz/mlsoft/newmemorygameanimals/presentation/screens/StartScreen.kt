package uz.mlsoft.newmemorygameanimals.presentation.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.mlsoft.newmemorygameanimals.R


@AndroidEntryPoint
class StartScreen : Fragment(R.layout.screen_start) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            delay(2000)
            findNavController().navigate(R.id.action_startScreen_to_levelsScreen)
        }
    }
}