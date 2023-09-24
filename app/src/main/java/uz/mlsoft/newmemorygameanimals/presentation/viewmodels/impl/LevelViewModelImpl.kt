package uz.mlsoft.newmemorygameanimals.presentation.viewmodels.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.mlsoft.newmemorygameanimals.presentation.viewmodels.LevelViewModel
import javax.inject.Inject


class LevelViewModelImpl @Inject constructor() : LevelViewModel, ViewModel() {
    override val moveMoveToGameFragment = MutableLiveData<Unit>()

    override fun onEasyClicked() {
        moveMoveToGameFragment.value = Unit
    }

    override fun onMediumClicked() {
        moveMoveToGameFragment.value = Unit
    }

    override fun onHardClicked() {
        moveMoveToGameFragment.value = Unit
    }
}