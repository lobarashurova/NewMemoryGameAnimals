package uz.mlsoft.newmemorygameanimals.domain.impl

import uz.mlsoft.newmemorygameanimals.R
import uz.mlsoft.newmemorygameanimals.data.CardData
import uz.mlsoft.newmemorygameanimals.data.LevelEnum
import uz.mlsoft.newmemorygameanimals.domain.GameRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepositoryImpl @Inject constructor() : GameRepository {

    private val list = ArrayList<CardData>()


    init {
        list.add(CardData(id = 1, pic = R.drawable.anim1))
        list.add(CardData(id = 2, pic = R.drawable.anim2))
        list.add(CardData(id = 3, pic = R.drawable.anim3))
        list.add(CardData(id = 4, pic = R.drawable.anim4))
        list.add(CardData(id = 5, pic = R.drawable.anim5))
        list.add(CardData(id = 6, pic = R.drawable.anim6))
        list.add(CardData(id = 7, pic = R.drawable.anim7))
        list.add(CardData(id = 8, pic = R.drawable.anim8))
        list.add(CardData(id = 9, pic = R.drawable.anim19))
        list.add(CardData(id = 10, pic = R.drawable.anim12))
        list.add(CardData(id = 11, pic = R.drawable.anim13))
        list.add(CardData(id = 12, pic = R.drawable.anim14))
        list.add(CardData(id = 13, pic = R.drawable.anim15))
        list.add(CardData(id = 14, pic = R.drawable.anim16))
        list.add(CardData(id = 15, pic = R.drawable.anim17))
        list.add(CardData(id = 16, pic = R.drawable.anim18))
        list.add(CardData(id = 17, pic = R.drawable.anim19))
        list.add(CardData(id = 18, pic = R.drawable.anim23))
        list.add(CardData(id = 19, pic = R.drawable.anim24))
        list.add(CardData(id = 20, pic = R.drawable.anim25))
        list.add(CardData(id = 21, pic = R.drawable.anim26))
        list.add(CardData(id = 22, pic = R.drawable.anim26))
        list.add(CardData(id = 23, pic = R.drawable.anim27))
        list.add(CardData(id = 24, pic = R.drawable.anim28))
    }

    override fun getCardByLevel(enum: LevelEnum): List<CardData> {
        val count = enum.horCount * enum.verCount
        list.shuffle()
        val result = ArrayList<CardData>(count)
        val sortedList = list.subList(0, count / 2)
        result.addAll(sortedList)
        result.addAll(sortedList)
        result.shuffle()
        return result
    }
}