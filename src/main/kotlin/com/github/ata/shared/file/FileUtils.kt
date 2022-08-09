package com.github.ata.shared.file

object FileUtils {

    fun loadResource(path: String): String {
        return this.javaClass.getResource(path)?.readText()
            ?: throw IllegalArgumentException("The requested resource $path not found")

    }
}