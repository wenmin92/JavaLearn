package cc.wenmin92.temp

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.serialization.Serializable
import java.io.File

fun main() {
    val content = File("data.json").readText()
    val data = Gson().fromJson<List<Item>>(content, object : TypeToken<List<Item>>() {}.type)
    println(data.size)
    data.groupBy { it.deadDate }.forEach { (key, value) ->
        println("$key[${value.size}]: ${value.maxBy { it.order }?.order}")
    }
}

/*{
    "PATIENT_NO": "12aade3e72f48cea",
    "FU_TIMES": "royd25982b3403e",
    "住院号": 366035,
    "出院日期": "2016/05/23",
    "差值": 2,
    "随访时间": "2017/02/18",
    "随访时长": 8,
    "末次随访时间": "2019/02/18",
    "order": 1,
    "备注": "生存"
}*/
@Serializable
data class Item(val order: Int, val deadDate: String)