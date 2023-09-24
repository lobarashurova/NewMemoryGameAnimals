package uz.mlsoft.newmemorygameanimals.presentation.viewmodels

import androidx.lifecycle.LiveData
import uz.mlsoft.newmemorygameanimals.data.CardData
import uz.mlsoft.newmemorygameanimals.data.LevelEnum

interface GameViewModel {
    val cardsListLiveData: LiveData<List<CardData>>
    fun getCardByLevel(levelEnum: LevelEnum)
}