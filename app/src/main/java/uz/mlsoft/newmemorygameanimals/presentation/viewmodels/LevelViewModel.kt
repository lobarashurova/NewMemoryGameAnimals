package uz.mlsoft.newmemorygameanimals.presentation.viewmodels

import androidx.lifecycle.LiveData

interface LevelViewModel {
    val moveMoveToGameFragment: LiveData<Unit>

    fun onEasyClicked()
    fun onMediumClicked()
    fun onHardClicked()
}