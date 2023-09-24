package uz.mlsoft.newmemorygameanimals.presentation.screens

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.mlsoft.newmemorygameanimals.R
import uz.mlsoft.newmemorygameanimals.databinding.ScreenInfoBinding

class InfoScreen : Fragment(R.layout.screen_info) {
    private val binding by viewBinding(ScreenInfoBinding::bind)
    private lateinit var mediaPlayer: MediaPlayer
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.u_click)
        binding.homeBtn.setOnClickListener {
            mediaPlayer.start()
            findNavController().popBackStack()
        }
    }


}