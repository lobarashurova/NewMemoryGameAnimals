package uz.mlsoft.newmemorygameanimals.presentation.viewmodels.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.mlsoft.newmemorygameanimals.data.CardData
import uz.mlsoft.newmemorygameanimals.data.LevelEnum
import uz.mlsoft.newmemorygameanimals.domain.GameRepository
import uz.mlsoft.newmemorygameanimals.presentation.viewmodels.GameViewModel
import javax.inject.Inject


@HiltViewModel
class GameViewModelImpl @Inject constructor(
    private val repository: GameRepository)
    : GameViewModel, ViewModel() {

    override val cardsListLiveData = MutableLiveData<List<CardData>>()

    override fun getCardByLevel(levelEnum: LevelEnum) {
        cardsListLiveData.value = repository.getCardByLevel(levelEnum)

    }
}