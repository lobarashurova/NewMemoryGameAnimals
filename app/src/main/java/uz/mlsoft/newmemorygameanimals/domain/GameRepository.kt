package uz.mlsoft.newmemorygameanimals.domain

import uz.mlsoft.newmemorygameanimals.data.CardData
import uz.mlsoft.newmemorygameanimals.data.LevelEnum

interface GameRepository {
    fun getCardByLevel(enum: LevelEnum):List<CardData>
}