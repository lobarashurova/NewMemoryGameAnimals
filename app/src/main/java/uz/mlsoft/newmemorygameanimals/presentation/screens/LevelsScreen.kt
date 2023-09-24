package uz.mlsoft.newmemorygameanimals.presentation.screens

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.mlsoft.newmemorygameanimals.R
import uz.mlsoft.newmemorygameanimals.data.LevelEnum
import uz.mlsoft.newmemorygameanimals.databinding.ScreenLevelsBinding


@AndroidEntryPoint
class LevelsScreen : Fragment(R.layout.screen_levels) {
    private val binding by viewBinding(ScreenLevelsBinding::bind)
    private lateinit var mediaPlayer: MediaPlayer
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.u_click)
        binding.apply {
            beginnerBtn.setOnClickListener {
                openGameScreen(LevelEnum.BEGINNER, "BEGINNER")
                mediaPlayer.start()
            }
            easyBtn.setOnClickListener {
                openGameScreen(LevelEnum.EASY, "EASY")
                mediaPlayer.start()
            }
            mediumBtn.setOnClickListener {
                openGameScreen(LevelEnum.MEDIUM, "MEDIUM")
                mediaPlayer.start()
            }
            hardBtn.setOnClickListener {
                openGameScreen(LevelEnum.HARD, "HARD")
                mediaPlayer.start()
            }
        }

        onClicks()
    }

    private fun openGameScreen(levelEnum: LevelEnum, message: String) {
        findNavController().navigate(
            R.id.action_levelsScreen_to_gameScreen,
            bundleOf("data" to levelEnum, "level" to message)
        )
    }

    private fun onClicks() {
        binding.rateBtn.setOnClickListener {
            rateApp()
            mediaPlayer.start()
        }

        binding.buttonShare.setOnClickListener {
            shareProject(requireContext())
            mediaPlayer.start()
        }

        binding.infoBtn.setOnClickListener {
            findNavController().navigate(R.id.action_levelsScreen_to_infoScreen)
            mediaPlayer.start()
        }
    }

    private fun shareProject(context: Context) {
        val packageName = context.packageName
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(
            Intent.EXTRA_TEXT,
            "Hoziroq yuklab oling!: " + "https://play.google.com/store/apps/details?id=${context.applicationContext?.packageName}"
        )
        sendIntent.type = "text/plain"
        context.startActivity(sendIntent)
    }

    private fun rateApp() {
        val i = Intent(Intent.ACTION_VIEW)
        i.data =
            Uri.parse("https://play.google.com/store/apps/details?id={context?applicationContext?.packageName}")
        requireActivity().startActivity(i)
    }


}