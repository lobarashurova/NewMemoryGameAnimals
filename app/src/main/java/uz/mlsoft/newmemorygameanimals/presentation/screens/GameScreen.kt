package uz.mlsoft.newmemorygameanimals.presentation.screens

import android.media.MediaPlayer
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.mlsoft.newmemorygameanimals.R
import uz.mlsoft.newmemorygameanimals.data.CardData
import uz.mlsoft.newmemorygameanimals.data.LevelEnum
import uz.mlsoft.newmemorygameanimals.databinding.ScreenGameBinding
import uz.mlsoft.newmemorygameanimals.presentation.dialogs.WindDialog
import uz.mlsoft.newmemorygameanimals.presentation.viewmodels.GameViewModel
import uz.mlsoft.newmemorygameanimals.presentation.viewmodels.impl.GameViewModelImpl
import uz.mlsoft.newmemorygameanimals.utils.closeCard
import uz.mlsoft.newmemorygameanimals.utils.hideCard
import uz.mlsoft.newmemorygameanimals.utils.openCard


@AndroidEntryPoint
class GameScreen : Fragment(R.layout.screen_game) {
    private val gameViewModel: GameViewModel by viewModels<GameViewModelImpl>()
    private val binding by viewBinding(ScreenGameBinding::bind)
    private var level: LevelEnum = LevelEnum.EASY
    private var imageHeight = 0
    private var text_level = ""
    private var imageWidth = 0
    private val imagesList = ArrayList<ImageView>()
    private var initialOpened = -1
    private var afterOpened = -1
    private var count = 0
    private var touchCount = 0
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var mediaPlater2: MediaPlayer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initializeModels()
        loadViews()
        gameViewModel.cardsListLiveData.observe(viewLifecycleOwner, cardsObserver)
        onClicks()
    }

    private fun initializeModels() {
        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.u_click)
        mediaPlater2 = MediaPlayer.create(requireContext(), R.raw.click_sound)
        level = requireArguments().getSerializable("data") as LevelEnum
        text_level = requireArguments().getString("level")!!
        binding.levelTexts.text = text_level
        binding.chronometer.apply {
            start()
            base = SystemClock.elapsedRealtime()
        }
    }

    private val cardsObserver = Observer<List<CardData>> {
        for (i in 0 until level.verCount) {
            for (j in 0 until level.horCount) {
                val imageView = ImageView(requireContext())
                binding.container.addView(imageView)
                val layoutParam = imageView.layoutParams as ConstraintLayout.LayoutParams
                layoutParam.width = imageWidth
                layoutParam.height = imageHeight
                imageView.x = i * imageWidth * 1f
                imageView.y = j * imageHeight * 1f
                imageView.layoutParams = layoutParam
                imageView.tag = it[i * level.horCount + j]
                imageView.setBackgroundResource(R.drawable.score_back)
                imageView.animate()
                    .x(i * imageWidth * 1f)
                    .y(j * imageHeight * 1f)
                    .setDuration(3000)
                    .start()
                imagesList.add(imageView)
            }
        }
        clickingImages()
    }


    private fun clickingImages() {
        imagesList.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                if (initialOpened == -1 && index != initialOpened) {
                    initialOpened = index
                    imageView.openCard()
                    touchCount++

                } else if (afterOpened == -1 && index != afterOpened && index != initialOpened) {
                    afterOpened = index
                    touchCount++
                    imageView.openCard {
                        check()
                    }
                }
                binding.scoreCount.text = touchCount.toString()
            }
        }
    }

    private fun check() {
        if ((imagesList[initialOpened].tag as CardData).id == (imagesList[afterOpened].tag as CardData).id) {
            imagesList[initialOpened].hideCard()
            count++
            imagesList[afterOpened].hideCard {
                initialOpened = -1
                afterOpened = -1
            }
            mediaPlater2.start()
        } else {
            imagesList[initialOpened].closeCard()
            imagesList[afterOpened].closeCard {
                initialOpened = -1
                afterOpened = -1
            }
        }

        if (count == (level.horCount * level.verCount / 2)) {
            val dialog = WindDialog()
            dialog.show(parentFragmentManager, null)
            binding.chronometer.stop()

        }
    }


    private fun loadViews() {
        binding.container.post {
            imageHeight = binding.container.height / level.horCount
            imageWidth = binding.container.width / level.verCount
            gameViewModel.getCardByLevel(level)
        }
    }

    private fun onClicks() {
        binding.homeBtn.setOnClickListener {
            mediaPlayer.start()
            findNavController().popBackStack()
        }
        binding.restartBtn.setOnClickListener {
            binding.container.removeAllViews()
            loadViews()
            binding.chronometer.base=SystemClock.elapsedRealtime()
            binding.chronometer.start()
        }
    }
}