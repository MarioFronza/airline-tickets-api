package shared.extension

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import shared.exception.ObjectConversionException

object StringExtensions {

    val logger = getLogger()

    inline fun <reified R: Any> String.convertTo(): R {
       try {
           val json = Json {
               ignoreUnknownKeys = true
           }
           return json.decodeFromString(this)
       }catch (e: Exception){
           logger.error(e.message)
           throw ObjectConversionException("Could not parse object from string: $this")
       }
    }


    fun String.removeBreakLines() =
        this.trimIndent().replace("\n", "")
}