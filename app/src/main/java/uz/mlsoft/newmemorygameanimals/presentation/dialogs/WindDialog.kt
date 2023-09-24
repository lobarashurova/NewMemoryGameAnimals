package uz.mlsoft.newmemorygameanimals.presentation.dialogs

import android.media.MediaPlayer
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.mlsoft.newmemorygameanimals.R
import uz.mlsoft.newmemorygameanimals.databinding.DialogWinBinding

class WindDialog :DialogFragment(R.layout.dialog_win) {
    private val binding by viewBinding (DialogWinBinding::bind)
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var restartListener :(()->Unit)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.u_click)

//        binding.restartBtn.setOnClickListener {
//            restartListener.invoke()
//        }
        binding.menuBtn.setOnClickListener {
            mediaPlayer.start()
            findNavController().navigate(R.id.levelsScreen)
            dismiss()
        }
    }

//    fun setRestartListener(block:()->Unit){
//        this.restartListener=block
//    }

    override fun onResume() {
        super.onResume()
        dialog!!.window!!.setLayout(1000, 1600)
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog?.setCancelable(false)
    }
}