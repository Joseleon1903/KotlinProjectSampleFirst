package org.example.project.sample.first

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
